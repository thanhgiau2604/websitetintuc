package myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import java.util.List;

import myweb.entity.TinTuc;
import myweb.repository.TinTucRepository;

@Service
public class TinTucServiceImpl implements TinTucService {

	@Autowired
    private TinTucRepository tinTucRepository;
	@Override
	public Iterable<TinTuc> findAll() {
		return tinTucRepository.findAll();
	}

	@Override
	public List<TinTuc> findAllByColumn(String tieude){
		return tinTucRepository.findAllByColumn(tieude);
	}
	
	@Override
	public List<TinTuc> findAllPopular(){
		return tinTucRepository.findAllPopular();
	}
	
	@Override
	public List<TinTuc> findAllNew(){
		return tinTucRepository.findAllNew();
	}

	@Override
	public TinTuc findOne(String id) {
		return tinTucRepository.findOne(id);
		
	}

	@Override
	public void save(TinTuc tintuc) {
		tinTucRepository.save(tintuc);
	}

	@Override
	public void delete(String id) {
		tinTucRepository.delete(id);
	}
	
	@Override
	public List<TinTuc> findRandom1(){
		return tinTucRepository.findRandom1();
	}
	
	@Override
	public List<TinTuc> findRandom2(){
		return tinTucRepository.findRandom2();
	}
	
	@Override
	public List<TinTuc> findRandom3(){
		return tinTucRepository.findRandom3();
	}

	@Override
	public List<TinTuc> getAllDescByNgay() {
		return tinTucRepository.getAllDescByNgay();
	}

	@Override
	public void UpdateNews(String tieude, String anh, String noidung, String matintuc) {
		tinTucRepository.UpdateNews(tieude, anh, noidung, matintuc); 
	}

	@Override
	public void DeleteNews(String matintuc) {
		tinTucRepository.DeleteNews(matintuc); 
		
	}

	@Override
	public void InsertNews(String matintuc, String tieude, String anh, String noidung, String tacgia, int luotxem) {
		tinTucRepository.InsertNews(matintuc, tieude, anh, noidung, tacgia,luotxem); 	
	}

	@Override
	public void UpdateLuotXem(String matintuc) {
		tinTucRepository.UpdateLuotXem(matintuc); 
		
	}

}
