package myweb.service;


import java.util.List;

import org.springframework.data.repository.query.Param;

import myweb.entity.TinTuc;
public interface TinTucService {

	Iterable<TinTuc> findAll();

	List<TinTuc> findAllByColumn(String tieude);
	
	List<TinTuc> findAllPopular();
	
	List<TinTuc> findAllNew();

    TinTuc findOne(String id);

    void save(TinTuc contact);

    void delete(String id);
    
    List<TinTuc> findRandom1();
	
	List<TinTuc> findRandom2();
	
	List<TinTuc> findRandom3();
	
	List<TinTuc> getAllDescByNgay();
	
	void UpdateNews(String tieude, String anh, String noidung, String matintuc);
	
	void UpdateLuotXem(String matintuc);
	
	void DeleteNews(String matintuc);
	
	void InsertNews(String matintuc, String tieude, String anh, String noidung, String tacgia, int luotxem);
	
	List<TinTuc> search(String keysearch);
}
