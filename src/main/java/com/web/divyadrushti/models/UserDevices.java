/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.divyadrushti.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author smahapat
 */
@Entity
@Table(name = "user_devices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDevices.findAll", query = "SELECT u FROM UserDevices u"),
    @NamedQuery(name = "UserDevices.findById", query = "SELECT u FROM UserDevices u WHERE u.id = :id")})
public class UserDevices implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne
    private User userId;
    
    @JoinColumn(name = "deviceId", referencedColumnName = "id")
    @ManyToOne
    private Devices deviceId;

    public UserDevices() {
    }

    public UserDevices(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Devices getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Devices deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDevices)) {
            return false;
        }
        UserDevices other = (UserDevices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.divyadrushti.models.UserDevices[ id=" + id + " ]";
    }
    
}
