/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.divyadrushti;

import org.apache.log4j.Logger;
import com.web.divyadrushti.models.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author smahapat
 */
public class ManageUser {
    
    private static final Logger log = Logger.getLogger(ManageUser.class.getName());
    
    /**
    * Gets the user details like first name, address mobile etc
    * 
    * @param username
    * @return Patient Object
    */
   public User getUser(String username) {
           
       Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        User user = null;
        try {
                tx = session.beginTransaction();
                
                // Add restriction to get user with username
                Criterion emailCr = Restrictions.eq("email", username);
                Criteria cr = session.createCriteria(User.class);
                cr.setMaxResults(1);
                cr.add(emailCr);
                user = (User)cr.uniqueResult();
                tx.commit();
        } catch (HibernateException e) {
                if (tx != null)
                        tx.rollback();
                log.fatal(e);
        } finally {
                session.close();
        }
        return user;
   }
    
}
