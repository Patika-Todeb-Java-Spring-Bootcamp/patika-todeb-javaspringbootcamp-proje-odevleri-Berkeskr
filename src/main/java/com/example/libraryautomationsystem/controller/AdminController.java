package com.example.libraryautomationsystem.controller;

import com.example.libraryautomationsystem.model.Admin;
import com.example.libraryautomationsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public ResponseEntity getAllAdmin(){
        List<Admin> allAdmin = adminService.getAllAdmin();
        return ResponseEntity.ok(allAdmin);

    }
    @GetMapping("/{id}")
    public ResponseEntity getAdminById(@PathVariable Long id) {
        Admin adminById;
        try {
            adminById = adminService.getAdminById(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(adminById);
    }

    @PostMapping("/create")
    public ResponseEntity createAdmin(@RequestBody Admin admin){
        Admin createdAdmin = adminService.createAdmin(admin);
        if(createdAdmin==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Creation failed");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdmin);
    }
    //localhost:8080/admin?id=variable is syntax
    @DeleteMapping
    public ResponseEntity deleteAdmin(@RequestParam(name = "id")Long id){
        try {
            adminService.deleteAdmin(id);

        }catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Admin deleted");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateAdmin(@PathVariable Long id,@RequestBody Admin admin){
        Admin updatedAdmin = adminService.updateAdmin(id, admin);
        if(updatedAdmin==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Update failed");
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedAdmin);
    }




}
