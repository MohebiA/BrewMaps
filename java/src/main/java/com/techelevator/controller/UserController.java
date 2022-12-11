package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.Authority;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao){
        this.userDao = userDao;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers(){
            return userDao.ListAll();
}
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/users/{id}", method = RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable int id, Principal principal){

        if (id == userDao.findIdByUsername(principal.getName())){
            return userDao.delete(id);
        } else if ((principal.getName()).equals("admin")) {
            return userDao.delete(id);
        }
        else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unable to delete account.");
        }


//
//        @PreAuthorize("isAuthenticated()")
//        @RequestMapping(path = "/users/{id}", method = RequestMethod.DELETE)
//        public boolean deleteUser(@PathVariable int id, Principal principal){
//            User user = userDao.findByUsername(principal.getName());
//            Set<Authority> authorites = user.getAuthorities();
//            authorites.
//
//            if (id == userDao.findIdByUsername(principal.getName())){
//                return userDao.delete(id);
//            } else if (userDao.findByUsername(principal.getName())!= null) {
//                return true;
//            }
//            else {
//                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unable to delete account.");
//            }
    }





}
