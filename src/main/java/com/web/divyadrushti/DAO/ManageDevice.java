/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.divyadrushti.DAO;

import com.web.divyadrushti.HibernateUtil;
import com.web.divyadrushti.models.Device;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author smahapat
 */
public class ManageDevice {
    
    private static final Logger log = Logger.getLogger(ManageDevice.class.getName());

    public Device addDevice(Device device) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Device addedDevice = null;
        try {
            tx = session.beginTransaction();
            session.save(device);
            tx.commit();
            addedDevice = device;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            log.fatal(e);
        } finally {
            session.close();
        }
        return addedDevice;
    }
    
    public Device updateDevice(Device device){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Device updatedDevice = null;
        try {
            tx = session.beginTransaction();
            session.update(device);
            tx.commit();
            updatedDevice = device;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            log.fatal(e);
        } finally {
            session.close();
        }
        return updatedDevice;
    }
    
    /**
    * Gets the device details
    * 
     * @param macAddress
    * @return User Object
    */
    public Device getDevice(String macAddress) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Device device = null;
        try {
                tx = session.beginTransaction();
                log.debug("Getting device object for macid=" + macAddress);

                // Add restriction to get user with username
                Criterion macIdCr = Restrictions.eq("macAddress", macAddress);
                Criteria cr = session.createCriteria(Device.class);
                cr.setMaxResults(1);
                cr.add(macIdCr);
                device = (Device)cr.uniqueResult();
                tx.commit();
        } catch (HibernateException e) {
                if (tx != null)
                        tx.rollback();
                log.fatal(e);
        } finally {
                session.close();
        }
        return device;
    }
}
