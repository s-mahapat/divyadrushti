/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.divyadrushti;

import java.io.File;
import java.io.FileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author smahapat
 */
public class ImageFilter implements FileFilter {

    private final String extension;
    private long startdt = 0;
    private long enddt = 0;
    
    private static final Logger log = LoggerFactory.getLogger(ImageFilter.class.getName());
    
    public ImageFilter(String extension, long starttime, long endtime){
        this.extension = extension;
        this.startdt = starttime;
        this.enddt = endtime;
    }
    
    /**
     * Implementation of the FileFilter accept method.
     *
     * @return
     */
    @Override
    public boolean accept(File pathname) {
        
        log.debug("Checking file {}", pathname.getName());
        
        // get the file name
        String name = pathname.getName();
        if(name.lastIndexOf('.') > 0)
        {
            // get last index for '.' char
            int lastIndex = name.lastIndexOf('.');

            // get extension
            String str = name.substring(lastIndex);
            
            long lastModified = pathname.lastModified();
            boolean isWithinDates = false;
            
            // check that the last modified date of the file is within the range
            // given by the user
            if( lastModified >= startdt && lastModified < enddt)
                isWithinDates = true;
            
            // match path name extension
            if(str.equals(this.extension))
            {
                return (true && isWithinDates);
            }
        }
        return false;
    }
    
}
