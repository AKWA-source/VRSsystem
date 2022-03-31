package com.example.VRSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.example.VRSystem.Model.User;
import com.example.VRSystem.Repository.Admin_repository;
import com.example.VRSystem.Repository.User_repository;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:8081", "http://192.168.1.102:8081"})                                                  
@RestController
@RequestMapping(path="/Project/REST-API")
public class LoginLogoutController {

    @Autowired
    private User_repository user_repository;

    @Autowired
    private Admin_repository admin_repository;


    @Transactional
    @GetMapping(value="/login")
    public String findByUserName(@RequestBody User user) {
        Long id;
        if(user_repository.isUserExistByUsernameAndPassword(user.getUsername(),user.getPassword()) == 1) {
            id = user_repository.findByUsername(user.getUsername());
            user_repository.updateUserActiveStatus(true, id);
            return "USER IS VALID";
        }
        if(admin_repository.isAdminExistByUsernameAndPassword(user.getUsername(),user.getPassword()) == 1) {
            id = admin_repository.findByUsername(user.getUsername());
            admin_repository.updateAdminActiveStatus(true, id);
            return "/admin/" + id + "/home";
        }
        return "Incorrect username or password";
    }


    @Transactional
    @PutMapping(value="/logout/user/{id}")
    public String findByUserStatus(@PathVariable long id) {
        if(user_repository.isUserExistByUserID(id) == 1) {
            user_repository.updateUserActiveStatus(false, id);
            return "Logout Successful";
        }
        return "User " + id + " not found";
    }


    @Transactional
    @PutMapping(value="/logout/admin/{id}") //Map ONLY GET Requests and means URL's start with /login/{userName}(after Application path).
    public String findByAdminStatus(@PathVariable long id) {
        if(admin_repository.isAdminExistByAdminID(id) == 1) {
            admin_repository.updateAdminActiveStatus(false, id);
            return "Logout Successful";
        }
        return "Admin " + id + " not found";
    }


    @Transactional
    @PutMapping(value="/changepassword/{role}/{id}", params = { "current_password", "new_password"})
    public String findByUserName(@PathVariable("role") String role, @PathVariable("id") long id, @RequestParam("current_password") String current_password, @RequestParam("new_password") String new_password) {
        switch (role) {
            case "admin":
                if (admin_repository.isAdminExistByAdminIDAndPassword(id, current_password) == 1) {
                    admin_repository.updateAdminPassword(new_password, id);
                    return "Password Updated Successfully";
                } else {
                    return "Invalid Old Password";
                }
            case "user":
                if (user_repository.isUserExistByUserIDAndPassword(id, current_password) == 1) {
                    user_repository.updateUserPassword(new_password, id);
                    return "Password Updated Successfully";
                } else {
                    return "Invalid Old Password";
                }
            default:
                return "Role not found";
        }
    }

}
