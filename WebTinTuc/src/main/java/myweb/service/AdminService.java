package myweb.service;

import myweb.entity.Admin;
import myweb.entity.TinTuc;

import java.util.List;


public interface AdminService {
	Iterable<Admin> findAll();

    Admin findOne(String username);

    void UpdateInfor(String hoten, String email, String sdt, String diachi,String tendangnhap);
    
    void UpdatePassword(String matkhau, String tendangnhap);
}
