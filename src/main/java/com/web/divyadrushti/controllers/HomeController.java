/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.divyadrushti.controllers;

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
public class HomeController extends BaseController {

    
    /**
    * Simply selects the home view to render by returning its name.
     * @param request
     * @param mav
     * @return 
    */
   @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
   public ModelAndView login(HttpServletRequest request, ModelAndView mav) {
       
       String name = request.getUserPrincipal().getName();
       mav.addObject("username", name);
       mav.setViewName("home");
       return mav;
   }
}
