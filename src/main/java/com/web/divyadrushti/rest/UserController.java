/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.divyadrushti.rest;

import com.web.divyadrushti.DAO.ManageDevice;
import com.web.divyadrushti.DAO.ManageUser;
import com.web.divyadrushti.ImageFilter;
import com.web.divyadrushti.models.Device;
import com.web.divyadrushti.models.User;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(UserController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public User GetUser(@RequestParam(value = "email") String username) {

        ManageUser mu = new ManageUser();
        User user = mu.getUser(username);
        return user;
    }

    /**
     * Adds a device to the database.
     *
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

    /**
     * Updates a device to the database.
     *
     * @param userId
     * @param device
     * @return
     */
    @RequestMapping(value = "/{userId}/device", method = RequestMethod.PUT)
    public Device updateDevice(@PathVariable int userId, @RequestBody Device device) {

        ManageUser mu = new ManageUser();

        // get user object
        User user = mu.getUser(userId);

        // set the user to whom the device belongs
        device.setUser(user);
        ManageDevice md = new ManageDevice();

        return md.updateDevice(device);
    }

    @RequestMapping(value = "/{userId}/device/list", method = RequestMethod.GET)
    public List<Device> getDeviceList(@PathVariable int userId) {

        ManageUser mu = new ManageUser();

        // get user object
        List<Device> devices = mu.getUserDevices(userId);

        return devices;

    }

    @RequestMapping(value = "/{userId}/device/{deviceId}/images/{starttime}/{endtime}", method = RequestMethod.GET)
    public List<String> getUserDeviceImages(@PathVariable int userId,
            @PathVariable int deviceId,
            @PathVariable long starttime,
            @PathVariable long endtime,
            HttpServletRequest request) {

        String customerImages = request.getSession().getServletContext().getRealPath("/WEB-INF/customer_images");

        String fullPath = customerImages.concat("/" + userId + "/" + deviceId);
        File folder = new File(fullPath);

        ImageFilter imgFilter = new ImageFilter(".jpg", starttime, endtime);

        File[] files = folder.listFiles(imgFilter);
        List<String> fileNames = new ArrayList<>();

        /*form the correct path of the image
          cimages/userid/deviceid/filename, cimages is only for the outside world
          the actual location is cutomer_images
          Also check that the list of files is not null, this occurs if the path is invalid
        */
        if (files != null) {
            for (File file : files) {
                fileNames.add(String.format("cimages/%s/%s/%s", userId, deviceId, file.getName()));
            }
        }

        return fileNames;
    }

    @RequestMapping(value = "/device/images", method = RequestMethod.POST)
    public String saveUserDeviceImage(@RequestParam(value = "macid") String macAddress) {

        ManageDevice md = new ManageDevice();
        Device device = md.getDevice(macAddress);

        int userId = device.getUser().getId();
        int deviceId = device.getId();

        return null;
    }

}
