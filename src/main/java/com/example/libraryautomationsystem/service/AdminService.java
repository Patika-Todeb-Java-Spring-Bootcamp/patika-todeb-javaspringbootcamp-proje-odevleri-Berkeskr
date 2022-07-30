package com.example.libraryautomationsystem.service;

import com.example.libraryautomationsystem.exception.AdminAlreadyExist;
import com.example.libraryautomationsystem.exception.AdminNotFound;
import com.example.libraryautomationsystem.model.Admin;
import com.example.libraryautomationsystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmin(){
        List<Admin> adminList = adminRepository.findAll();
        return adminList;

    }

    public Admin getAdminById(Long id){
        Optional<Admin> byId = adminRepository.findById(id);
        return byId.orElseThrow(()->new AdminNotFound("Admin with id:"+id+" not found"));

    }

    public Admin createAdmin(Admin admin){

        Admin existingAdmin = adminRepository.findById(admin.getId()).orElse(null);
        if (existingAdmin==null){
            return adminRepository.save(admin);
        }
        else throw new AdminAlreadyExist("Admin already exist!");
    }

    public void deleteAdmin(Long id){
        getAdminById(id);
        adminRepository.delete(getAdminById(id));
    }

    public Admin updateAdmin(Long id,Admin admin){
        Admin existingAdmin = getAdminById(id);

        existingAdmin.setName(admin.getName());
        existingAdmin.setSurname(admin.getSurname());
        existingAdmin.setEmail(admin.getEmail());
        return adminRepository.save(existingAdmin);

    }
}
