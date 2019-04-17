package myweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import myweb.service.AdminService;
import myweb.service.StorageService;
import myweb.service.TinTucService;
import myweb.entity.Admin;
import myweb.entity.TinTuc;

@Controller
public class HomeController {
	
	@Autowired
    private AdminService adminService;
	
	@Autowired
    private TinTucService tintucService;
	
	@Autowired
    private StorageService storageService;
	
	@RequestMapping(value = {"/","/trangchu"}, method = RequestMethod.GET)
	public String TrangChu(Model model, HttpSession session) { 
		session.removeAttribute("usernamead");
		
		List<TinTuc> lPopular = tintucService.findAllPopular().subList(0, 4); 
		model.addAttribute("lPopularNews",lPopular);
		model.addAttribute("firstPopular", lPopular.get(0));
		
		List<TinTuc> lNews = tintucService.findAllNew().subList(0, 4);
		model.addAttribute("lNewNews",lNews);
		
		List<TinTuc> lRan1 = tintucService.findRandom1();
		model.addAttribute("random1",lRan1.get(0));
		List<TinTuc> lRan2 = tintucService.findRandom2();
		int i=0;
		while (lRan2.get(i).getMatintuc().equals(lRan1.get(0).getMatintuc()))
			i++;
		model.addAttribute("random2",lRan2.get(i));
		List<TinTuc> lRan3 = tintucService.findRandom3();
		int j=0;
		while (lRan3.get(j).getMatintuc().equals(lRan1.get(0).getMatintuc())
				|| lRan3.get(j).getMatintuc().equals(lRan2.get(i).getMatintuc()))
			j++;
		model.addAttribute("random3",lRan3.get(j));
		return "trangchu";
	}
	@RequestMapping(value = "admin_TC", method = RequestMethod.GET)
	public String TrangChu_Admin(Model model, HttpSession session) { 
		if (session.getAttribute("usernamead")==null) return "login_ad";
		List<TinTuc> lPopular = tintucService.findAllPopular().subList(0, 4); 
		model.addAttribute("lPopularNews",lPopular);
		model.addAttribute("firstPopular", lPopular.get(0));
		
		List<TinTuc> lNews = tintucService.findAllNew().subList(0, 4);
		model.addAttribute("lNewNews",lNews);
		
		List<TinTuc> lRan1 = tintucService.findRandom1();
		model.addAttribute("random1",lRan1.get(0));
		List<TinTuc> lRan2 = tintucService.findRandom2();
		int i=0;
		while (lRan2.get(i).getMatintuc().equals(lRan1.get(0).getMatintuc()))
			i++;
		model.addAttribute("random2",lRan2.get(i));
		List<TinTuc> lRan3 = tintucService.findRandom3();
		int j=0;
		while (lRan3.get(j).getMatintuc().equals(lRan1.get(0).getMatintuc())
				|| lRan3.get(j).getMatintuc().equals(lRan2.get(i).getMatintuc()))
			j++;
		model.addAttribute("random3",lRan3.get(j));
		return "admin_TC";
	}
	
	@RequestMapping(value = "/newnews", method = RequestMethod.GET)
	public String TinTucMoi(Model model) { 
		model.addAttribute("listNew",tintucService.findAllNew().subList(0, 4));
		model.addAttribute("listPopular",tintucService.findAllPopular().subList(0, 4));
		return "newnews";
	}
	@RequestMapping(value = "/popularnews", method = RequestMethod.GET)
	public String TinTucPhoBien(Model model) { 
		model.addAttribute("listNew",tintucService.findAllNew().subList(0, 4));
		model.addAttribute("listPopular",tintucService.findAllPopular().subList(0, 4));
		return "popularnews";
	}
	@RequestMapping(value = "/totalnews", method = RequestMethod.GET)
	public String TatCaTinTuc(Model model) { 
		model.addAttribute("listNew",tintucService.findAllNew().subList(0, 4));
		model.addAttribute("listPopular",tintucService.findAllPopular().subList(0, 4));
		model.addAttribute("listAll",tintucService.getAllDescByNgay());
		return "totalnews";
	}
	@RequestMapping(value = "/lienhe", method = RequestMethod.GET)
	public String LienHe() { 
		return "lienhe";
	}
	
	@RequestMapping(value = "/DoiMatKhau", method = RequestMethod.GET)
	public String DoiMatKhau() { 
		return "DoiMatKhau";
	}
	
	@RequestMapping(value = "/QLTaiKhoan", method = RequestMethod.GET)
	public String QLTaiKhoan(Model model, HttpSession session) { 
		Admin admin = adminService.findOne(session.getAttribute("usernamead").toString());
		model.addAttribute("AdminInfor",admin);
		return "QLTaiKhoan";
	}
	
	@RequestMapping(value = "/QLTinTuc", method = RequestMethod.GET)
	public String QLTinTuc(Model model) { 
		model.addAttribute("list",tintucService.getAllDescByNgay());
		return "QLTinTuc";
	}
	@RequestMapping(value = "/ThayDoiThongTin", method = RequestMethod.GET)
	public String ThayDoiThongTin(Model model, HttpSession session) { 
		Admin admin = adminService.findOne(session.getAttribute("usernamead").toString());
		model.addAttribute("AdminInfor",admin);
		return "ThayDoiThongTin";
	}
	@RequestMapping(value = "/ThemTinTuc", method = RequestMethod.GET)
	public String ThemTinTuc() { 
		return "ThemTinTuc";
	}
	
	@RequestMapping(value = "/login_ad", method = RequestMethod.GET)
	public String DangNhap() { 
		return "login_ad";
	}
	
	@RequestMapping(value = "/CheckLogin", method = RequestMethod.POST)
	public String KiemTraDangNhap(@RequestParam(name="uname") String username, @RequestParam(name="psw") String password, Model model, HttpSession session) { 
		Admin admin = new Admin();
		admin = adminService.findOne(username);
		boolean LoginSuccess = false;
		if (admin!=null) {
			String myPass = admin.getmatkhau().toString();
			if (myPass.equals(password))
			{
				LoginSuccess=true;	
				session.setAttribute("usernamead", admin.gettendangnhap());
			}
		}
		if (LoginSuccess==true)
		{
			List<TinTuc> lPopular = tintucService.findAllPopular().subList(0, 4); 
			model.addAttribute("lPopularNews",lPopular);
			model.addAttribute("firstPopular", lPopular.get(0));
			
			List<TinTuc> lNews = tintucService.findAllNew().subList(0, 4);
			model.addAttribute("lNewNews",lNews);
			
			List<TinTuc> lRan1 = tintucService.findRandom1();
			model.addAttribute("random1",lRan1.get(0));
			List<TinTuc> lRan2 = tintucService.findRandom2();
			int i=0;
			while (lRan2.get(i).getMatintuc().equals(lRan1.get(0).getMatintuc()))
				i++;
			model.addAttribute("random2",lRan2.get(i));
			List<TinTuc> lRan3 = tintucService.findRandom3();
			int j=0;
			while (lRan3.get(j).getMatintuc().equals(lRan1.get(0).getMatintuc())
					|| lRan3.get(j).getMatintuc().equals(lRan2.get(i).getMatintuc()))
				j++;
			model.addAttribute("random3",lRan3.get(j));
		
			return "admin_TC";
		}
		else
		{
			model.addAttribute("checklg",1);
			return "login_ad";
		}
	}
	@RequestMapping(value = "/SaveInfor", method = RequestMethod.POST)
	public String LuuThongTinCaNhan(@RequestParam(name="usname") String username, @RequestParam(name="fullname") String hoten, 
			@RequestParam(name="number") String sdt, @RequestParam(name="email") String email, @RequestParam(name="address") String diachi,
			Model model, HttpSession session) { 
		
		adminService.UpdateInfor(hoten,email ,sdt, diachi,username);
		Admin admin = adminService.findOne(session.getAttribute("usernamead").toString());
		model.addAttribute("AdminInfor",admin);
		return "QLTaiKhoan";
	}
	
	@RequestMapping(value = "/DoiPassword", method = RequestMethod.POST)
	public String DoiMatKhau(@RequestParam(name="oldpass") String mkcu, @RequestParam(name="newpass") String mkmoi, 
			@RequestParam(name="repass") String nhaplaimk, Model model, HttpSession session) { 
		Admin admin = adminService.findOne(session.getAttribute("usernamead").toString());
		if (!admin.getmatkhau().toString().equals(mkcu)) {
			model.addAttribute("checkDoiMK", 1);
			return "DoiMatKhau";
		}
		
		if (!mkmoi.equals(nhaplaimk)) {
			model.addAttribute("checkDoiMK", 2);
			return "DoiMatKhau";
		}
		adminService.UpdatePassword(mkmoi, session.getAttribute("usernamead").toString()); 
		model.addAttribute("checkDoiMK", 0);
		return "redirect:/admin_TC";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String XemTinTuc(@PathVariable("id") String matintuc, Model model) { 
		TinTuc tintuc = tintucService.findOne(matintuc);
		model.addAttribute("news", tintuc); 
		model.addAttribute("listNew",tintucService.findAllNew().subList(0, 4)); 
		model.addAttribute("listPopular",tintucService.findAllPopular().subList(0, 4));
		tintucService.UpdateLuotXem(matintuc);
		return "ChiTietTinTuc";
	}
	
	@RequestMapping(value = "/ttnew", method = RequestMethod.GET)
	public String ttnew(Model model) { 
		model.addAttribute("list",tintucService.findAllNew().subList(0, 4));
		return "QLTinTuc";
	}
	
	@RequestMapping(value = "/ttpopular", method = RequestMethod.GET)
	public String ttpopular(Model model) { 
		model.addAttribute("list",tintucService.findAllPopular().subList(0, 4));
		return "QLTinTuc";
	}
	
	@RequestMapping(value = "/edit={id}", method = RequestMethod.GET)
	public String EditNews(@PathVariable("id") String matintuc, Model model) { 
		model.addAttribute("tintuc",tintucService.findOne(matintuc)); 
		return "SuaTinTuc";
	}
	
	@RequestMapping(value = "/LuuTinTuc", method = RequestMethod.POST)
	public String LuuEdit(@RequestParam(name="tieude") String tieude, @RequestParam(name="pic") MultipartFile anh, 
			@RequestParam(name="noidung") String noidung, @RequestParam(name="matintuc") String matintuc, Model model) throws IOException { 
		tintucService.UpdateNews(tieude, anh.getOriginalFilename(), noidung, matintuc); 
		storageService.store(anh);
		
		model.addAttribute("list",tintucService.getAllDescByNgay());
		return "QLTinTuc";
	}
	
	@RequestMapping(value = "/delete?{id}", method = RequestMethod.GET)
	public String DeleteNews(@PathVariable("id") String matintuc, Model model) { 
		tintucService.DeleteNews(matintuc); 
		model.addAttribute("list",tintucService.getAllDescByNgay());
		return "QLTinTuc";
	}
	
	@RequestMapping(value = "/themtintuc", method = RequestMethod.POST)
	public String InsertNews(@RequestParam(name="matintuc") String matintuc, @RequestParam(name="tieude") String tieude, 
			@RequestParam(name="pic") MultipartFile anh, @RequestParam(name="noidung") String noidung, Model model, HttpSession session) throws IOException { 
		String tacgia = session.getAttribute("usernamead").toString();
		int luotxem =0;
		tintucService.InsertNews(matintuc, tieude, anh.getOriginalFilename(), noidung,tacgia, luotxem);
		storageService.store(anh);
		model.addAttribute("list",tintucService.getAllDescByNgay());
		return "QLTinTuc";
	}
}
