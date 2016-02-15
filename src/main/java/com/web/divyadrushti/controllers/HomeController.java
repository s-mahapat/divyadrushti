/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.divyadrushti.controllers;

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
     * @param mav
     * @return 
    */
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public ModelAndView login(ModelAndView mav) {
       
       mav.setViewName("home");
       return mav;
   }
}
