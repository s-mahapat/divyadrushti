/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.divyadrushti.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author smahapat
 */
@Controller
@RequestMapping("/partials")
public class PartialsController extends BaseController {

    
    /**
    * Returns a template file from the partials folder.
     * @param view
     * @return 
    */
   @RequestMapping(value = "/{view}", method = RequestMethod.GET)
   public ModelAndView getTemplate(@PathVariable(value = "view") String view) {
       
       ModelAndView mav = new ModelAndView();
       mav.setViewName("partials/" + view);
       return mav;
   }
}
