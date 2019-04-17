package myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myweb.entity.Admin;
import myweb.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
    private AdminRepository adminRepository;
	
	@Override
	public Iterable<Admin> findAll() {
		return adminRepository.findAll();
	}

	@Override
	public Admin findOne(String username) {
		return adminRepository.findOne(username);
	}

	@Override
	public void UpdateInfor(String hoten, String email, String sdt, String diachi, String tendangnhap) {
		adminRepository.UpdateInfor(hoten, email, sdt, diachi, tendangnhap);
	}
	@Override
	public void UpdatePassword(String matkhau, String tendangnhap) {
		adminRepository.UpdatePassword(matkhau, tendangnhap); 		
	}



}
