package com.samjain.project.CrudOperations.Controller;
import com.samjain.project.CrudOperations.Model.User;
import com.samjain.project.CrudOperations.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }

    @PostMapping(value = "/create")
    public String createOperation(@RequestBody User user){
        userRepo.save(user);
        return "User saved into database.";
    }

    @GetMapping(value = "/read")
    public List<User> readOperation(){
        return userRepo.findAll();
    }

    @PutMapping(value = "/update/{id}")
    public String updateOperation(@PathVariable long id, @RequestBody User user){
        User updatedUser= userRepo.findById(id).get();
        updatedUser.setName(user.getName());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        userRepo.save(updatedUser);
        return "User details updated.";

    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteOperation(@PathVariable long id){
        User deleteUser= userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "User deleted successfully.";
    }
}
