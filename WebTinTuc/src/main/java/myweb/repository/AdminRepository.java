package myweb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import myweb.entity.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, String> {
	@Modifying
	@Transactional
	@Query("Update Admin ad SET ad.hoten=:hoten, ad.email=:email, ad.sdt=:sdt, ad.diachi=:diachi where ad.tendangnhap=:tendangnhap")
	void UpdateInfor(@Param("hoten") String hoten, @Param("email") String email,@Param("sdt") String sdt, 
			@Param("diachi") String diachi, @Param("tendangnhap") String tendangnhap);
	
	@Modifying
	@Transactional
	@Query("Update Admin ad SET ad.matkhau=:matkhau where ad.tendangnhap=:tendangnhap")
	void UpdatePassword(@Param("matkhau") String matkhau, @Param("tendangnhap") String tendangnhap);
	
}
