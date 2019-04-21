package myweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import myweb.entity.TinTuc;

@Repository
public interface TinTucRepository extends JpaRepository<TinTuc, String>{
	
	@Query("Select c from TinTuc c where c.tieude=tieude")
	List<TinTuc> findAllByColumn(@Param("tieude") String tieude);
	
	@Query("Select c from TinTuc c order by c.luotxem desc")
	List<TinTuc> findAllPopular();
	
	@Query("Select c from TinTuc c order by c.ngay desc")
	List<TinTuc> findAllNew();
	
	@Query("Select c from TinTuc c  order by RAND()")
	List<TinTuc> findRandom1();
	
	@Query("Select c from TinTuc c  order by RAND()")
	List<TinTuc> findRandom2();
	
	@Query("Select c from TinTuc c  order by RAND()")
	List<TinTuc> findRandom3();
	
	@Query("Select c from TinTuc c order by c.ngay desc")
	List<TinTuc> getAllDescByNgay();
	
	@Modifying
	@Transactional
	@Query("Update TinTuc tt SET tt.tieude=:tieude,tt.anh=:anh, tt.noidung=:noidung,tt.ngay=now() where tt.matintuc=:matintuc")
	void UpdateNews(@Param("tieude") String tieude, @Param("anh") String anh, 
			@Param("noidung") String noidung, @Param("matintuc") String matintuc);
	
	@Modifying
	@Transactional
	@Query("Update TinTuc tt SET tt.luotxem=tt.luotxem+1 where tt.matintuc=:matintuc")
	void UpdateLuotXem(@Param("matintuc") String matintuc);
	
	@Modifying
	@Transactional
	@Query("Delete TinTuc tt where tt.matintuc=:matintuc")
	void DeleteNews(@Param("matintuc") String matintuc);
	
	@Modifying
	@Transactional
	@Query(value = "Insert INTO dbtintuc (matintuc,tieude,anh,noidung,ngay,tacgia,luotxem) "
			+ "VALUES(:matintuc,:tieude,:anh,:noidung,NOW(),:tacgia,:luotxem)", nativeQuery=true)
	void InsertNews(@Param("matintuc") String matintuc, @Param("tieude") String tieude, @Param("anh") String anh, @Param("noidung") String noidung, @Param("tacgia") String tacgia, @Param("luotxem") int luotxem);
	
	@Query("Select c from TinTuc c where c.tieude like %:keysearch%")
	List<TinTuc> search(@Param("keysearch") String keysearch);
	
}
