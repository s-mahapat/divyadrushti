/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.divyadrushti.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author smahapat
 */
@Entity
@Table(name = "devices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devices.findAll", query = "SELECT d FROM Devices d"),
    @NamedQuery(name = "Devices.findById", query = "SELECT d FROM Devices d WHERE d.id = :id"),
    @NamedQuery(name = "Devices.findByMacAddress", query = "SELECT d FROM Devices d WHERE d.macAddress = :macAddress"),
    @NamedQuery(name = "Devices.findByActive", query = "SELECT d FROM Devices d WHERE d.active = :active"),
    @NamedQuery(name = "Devices.findByWhenCreated", query = "SELECT d FROM Devices d WHERE d.whenCreated = :whenCreated"),
    @NamedQuery(name = "Devices.findByWhenModified", query = "SELECT d FROM Devices d WHERE d.whenModified = :whenModified"),
    @NamedQuery(name = "Devices.findByLocation", query = "SELECT d FROM Devices d WHERE d.location = :location"),
    @NamedQuery(name = "Devices.findByWhyNotActiveId", query = "SELECT d FROM Devices d WHERE d.whyNotActiveId = :whyNotActiveId")})
public class Devices implements Serializable {

    @OneToMany(mappedBy = "deviceId")
    private Collection<Cron> cronCollection;
    @OneToMany(mappedBy = "deviceId")
    private Collection<UserDevices> userDevicesCollection;

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "macAddress", nullable = false, length = 32)
    private String macAddress;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "active", nullable = false)
    private int active;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "whenCreated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date whenCreated;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "whenModified", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date whenModified;
    
    @Size(max = 64)
    @Column(name = "location", length = 64)
    private String location;
    
    @Column(name = "whyNotActiveId")
    private Integer whyNotActiveId;

    public Devices(Integer id, String macAddress, int active, Date whenCreated, Date whenModified) {
        this.id = id;
        this.macAddress = macAddress;
        this.active = active;
        this.whenCreated = whenCreated;
        this.whenModified = whenModified;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getWhyNotActiveId() {
        return whyNotActiveId;
    }

    public void setWhyNotActiveId(Integer whyNotActiveId) {
        this.whyNotActiveId = whyNotActiveId;
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
        if (!(object instanceof Devices)) {
            return false;
        }
        Devices other = (Devices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.divyadrushti.models.Devices[ id=" + id + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Cron> getCronCollection() {
        return cronCollection;
    }

    public void setCronCollection(Collection<Cron> cronCollection) {
        this.cronCollection = cronCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<UserDevices> getUserDevicesCollection() {
        return userDevicesCollection;
    }

    public void setUserDevicesCollection(Collection<UserDevices> userDevicesCollection) {
        this.userDevicesCollection = userDevicesCollection;
    }
    
}
