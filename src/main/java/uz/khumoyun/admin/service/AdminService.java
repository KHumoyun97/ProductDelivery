package uz.khumoyun.admin.service;


import uz.khumoyun.persistencelibrary.entities.Admin;

import java.util.List;

public interface AdminService {
    Admin save(Admin admin);

    List<Admin> findAll();
}
