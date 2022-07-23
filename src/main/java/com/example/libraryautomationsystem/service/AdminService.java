package com.example.libraryautomationsystem.service;

import antlr.StringUtils;
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
        return byId.orElseThrow(()->new RuntimeException("Admin not found"));

    }

    public Admin createAdmin(Admin admin){
        return adminRepository.save(admin);

    }

    public void deleteAdmin(Long id){
        getAdminById(id);
        adminRepository.delete(getAdminById(id));
    }

    public Admin updateAdmin(Long id,Admin admin){
        Optional<Admin> byId = adminRepository.findById(id);
        if(!byId.isPresent()){
            return null;
        }
        Admin updatedAdmin = byId.get();
        updatedAdmin.setName(admin.getName());
        updatedAdmin.setSurname(admin.getSurname());
        updatedAdmin.setEmail(admin.getEmail());
        return adminRepository.save(updatedAdmin);

    }
}
