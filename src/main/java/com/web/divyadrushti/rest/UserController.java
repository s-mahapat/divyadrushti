/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.divyadrushti.rest;

import com.web.divyadrushti.DAO.ManageDevice;
import com.web.divyadrushti.DAO.ManageUser;
import com.web.divyadrushti.models.Device;
import com.web.divyadrushti.models.User;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author smahapat
 */
@RestController
@RequestMapping("/rest/user")
public class UserController {
    
    @RequestMapping(method = RequestMethod.GET)
    public User GetUser(@RequestParam(value="email") String username) {
        
        
        ManageUser mu = new ManageUser();
        User user = mu.getUser(username);
        return user;
    }
    
    /**
    * Adds a device to the database.
     * @param userId
     * @param device
     * @return 
    */
   @RequestMapping(value = "/{userId}/device", method = RequestMethod.POST)
   public Device addDevice(@PathVariable int userId, @RequestBody Device device) {
       
       ManageUser mu = new ManageUser();
       
       // get user object
       User user = mu.getUser(userId);
       
       // set the user to whom the device belongs
       device.setUser(user);
       ManageDevice md = new ManageDevice();
       
       // add the device to the database
       return md.addDevice(device);
   }
   
   @RequestMapping(value = "/{userId}/device/list", method = RequestMethod.GET)
   public List<Device> getDeviceList(@PathVariable int userId) {
   
       ManageUser mu = new ManageUser();
       
       // get user object
       List<Device> devices = mu.getUserDevices(userId);
       
       return devices;
       
   }
   
   @RequestMapping(value = "/{userId}/device/{deviceId}/images", method = RequestMethod.GET)
   public List<String> getUserDeviceImages(@PathVariable int userId, @PathVariable int deviceId, HttpServletRequest request){
       String customerImages = request.getSession().getServletContext().getRealPath("/WEB-INF/customer_images");
       
       String fullPath = customerImages.concat("/" + userId + "/" + deviceId);
       File folder = new File(fullPath);
       
       // implement a filter to return only .jpg and .png files
       FileFilter filter = new FileFilter() {
           @Override
           public boolean accept(File pathname) {
               
               // get the file name
               String name = pathname.getName();
               if(name.lastIndexOf('.') > 0)
               {
                  // get last index for '.' char
                  int lastIndex = name.lastIndexOf('.');
                  
                  // get extension
                  String str = name.substring(lastIndex);
                  
                  // match path name extension
                  if(str.equals(".jpg"))
                  {
                     return true;
                  }
               }
               return false;
           }
       };
       
       File[] files =  folder.listFiles(filter);
       List<String> fileNames = new ArrayList<>();
       
       // form the correct path of the image
       // cimages/userid/deviceid/filename, cimages is only for the outside world
       // the actual location is cutomer_images
       for(File file : files){
           fileNames.add(String.format("cimages/%s/%s/%s", userId, deviceId, file.getName()));
       }
       
       return fileNames;
   }
   
   @RequestMapping(value = "/device/images", method = RequestMethod.POST)
   public String saveUserDeviceImage(@RequestParam(value="macid") String macAddress){
       
       ManageDevice md = new ManageDevice();
       Device device = md.getDevice(macAddress);
       
       int userId = device.getUser().getId();
       int deviceId = device.getId();
       
       return null;
   }
   
   
   
}
