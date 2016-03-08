/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.divyadrushti.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author smahapat
 */
@Entity
@Table(name = "devices")
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "macAddress", nullable = false, length = 32, unique = true)
    private String macAddress;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "active", nullable = false)
    private boolean active = true;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "whenCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date whenCreated = new Date();
    
    @Basic(optional = false)
    @Column(name = "whenModified", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date whenModified = new Date();
    
    @Size(max = 64)
    @Column(name = "name", length = 64)
    private String name;
    
    @Column(name = "whyNotActiveId")
    private Integer whyNotActiveId;
    
    // default every hour
    @Size(min = 9, max = 9)
    @Column(name = "cron", length = 9)
    private String cron = "0 * * * *";
    
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @JsonIgnore(true)
    private User userId;

    public Device() {
    }

    public Device(String macAddress, String name, User user) {
        this.macAddress = macAddress;
        this.name = name;
        this.userId = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public User getUser() {
        return userId;
    }

    public void setUser(User user) {
        this.userId = user;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getWhenCreated() {
        return whenCreated;
    }

    public void setWhenCreated(Date whenCreated) {
        this.whenCreated = whenCreated;
    }

    public Date getWhenModified() {
        return whenModified;
    }

    public void setWhenModified(Date whenModified) {
        this.whenModified = whenModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWhyNotActiveId() {
        return whyNotActiveId;
    }

    public void setWhyNotActiveId(Integer whyNotActiveId) {
        this.whyNotActiveId = whyNotActiveId;
    }
    
    public String getCron(){
        return this.cron;
    }
    
    public void setCron(String cron){
        this.cron = cron;
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
        if (!(object instanceof Device)) {
            return false;
        }
        Device other = (Device) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.divyadrushti.models.Devices[ id=" + id + " ]";
    }
    
}
