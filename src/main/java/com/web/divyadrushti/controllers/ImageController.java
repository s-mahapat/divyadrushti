/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.divyadrushti.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author smahapat
 */
@Controller
@RequestMapping("/cimages")
public class ImageController extends BaseController {
    
    
    @RequestMapping(value="/{userId}/{deviceId}/{filename:.*}", method=RequestMethod.GET, headers="Accept=*/*", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@PathVariable int userId, @PathVariable int deviceId, @PathVariable String filename, HttpServletRequest request)  {
        try {
            
            String fileName = String.format("/WEB-INF/customer_images/%s/%s/%s", userId, deviceId, filename);
            //String realFilePath = request.getSession().getServletContext().getRealPath(fileName);
            // Retrieve image from the classpath.
            InputStream is = request.getSession().getServletContext().getResourceAsStream(fileName); 

            // Prepare buffered image.
            BufferedImage img = ImageIO.read(is);

            // Create a byte array output stream.
            ByteArrayOutputStream bao = new ByteArrayOutputStream();

            // Write to output stream
            ImageIO.write(img, "jpg", bao);

            return bao.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
