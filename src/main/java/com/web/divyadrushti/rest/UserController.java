/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.divyadrushti.rest;

import com.web.divyadrushti.ManageUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.web.divyadrushti.models.User;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author smahapat
 */
@RestController
@RequestMapping("/rest/user")
public class UserController {
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody User GetUser(@RequestParam(value="email") String username) {
            
        ManageUser mu = new ManageUser();
        User user = mu.getUser(username);
        return user;
    }
}
