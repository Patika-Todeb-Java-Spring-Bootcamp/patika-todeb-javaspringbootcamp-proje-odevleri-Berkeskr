package com.example.libraryautomationsystem.controller;

import com.example.libraryautomationsystem.model.Admin;
import com.example.libraryautomationsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/admins")
    public ResponseEntity getAllAdmin(){
        List<Admin> allAdmin = adminService.getAllAdmin();
        return ResponseEntity.ok(allAdmin);

    }
    @GetMapping("/admin/{id}")
    public ResponseEntity getAdminById(@PathVariable Long id) {
        Admin adminById = adminService.getAdminById(id);
        return ResponseEntity.status(HttpStatus.OK).body(adminById);
    }

    @PostMapping("/admin")
    public ResponseEntity createAdmin(@RequestBody Admin admin){
        Admin createdAdmin = adminService.createAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdmin);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
        return ResponseEntity.status(HttpStatus.OK).body("Admin deleted");
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity updateAdmin(@PathVariable Long id,@RequestBody Admin admin){
        //System.out.println("admın:{} create request",admin);
        Admin updatedAdmin = adminService.updateAdmin(id, admin);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAdmin);
    }

    // TODO : buradakı desıgn patternsslere bakarak book controller yarat
    // TODO : projeyı memory db'de çalışcak hale getır
    // TODO : log4j ımplanatasyounu ve admın controller ıçın loglama ışlemerınn yapılması
    // TODO log4j log leveller nedır hangı durumda hangı log basılmalıdır.



}
