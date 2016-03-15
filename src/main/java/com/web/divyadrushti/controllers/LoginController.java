/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.divyadrushti.controllers;

import com.web.divyadrushti.DAO.ManageUser;
import com.web.divyadrushti.models.User;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author smahapat
 */
@Controller
public class LoginController extends BaseController {


    /**
    * Simply selects the login view to render by returning its name.
     * @param mav
     * @return
    */
   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public ModelAndView login(ModelAndView mav) {

       mav.setViewName("login");
       return mav;
   }

   /**
    * Simply selects the logout view to render by returning its name.
     * @param request
     * @return
     * @throws java.io.IOException
    */
   @RequestMapping(value = "/logout", method = RequestMethod.GET)
   public String logout(HttpServletRequest request) throws IOException {

       request.getSession().invalidate();
       return "redirect:/";
   }

   /**
    * Simply selects the home view to render by returning its name.
     * @param request
     * @param mav
     * @return
    */
   @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
   public ModelAndView home(HttpServletRequest request, ModelAndView mav) {

       String name = request.getUserPrincipal().getName();
       ManageUser mu = new ManageUser();
       User user = mu.getUser(name);
       mav.addObject("user", user);
       mav.setViewName("home");
       return mav;
   }
}
