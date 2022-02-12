/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Admin
 */
@Embeddable
public class TblServicelistPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "serviceorder_id")
    private int serviceorderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "service_id")
    private int serviceId;

    public TblServicelistPK() {
    }

    public TblServicelistPK(int serviceorderId, int serviceId) {
        this.serviceorderId = serviceorderId;
        this.serviceId = serviceId;
    }

    public int getServiceorderId() {
        return serviceorderId;
    }

    public void setServiceorderId(int serviceorderId) {
        this.serviceorderId = serviceorderId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) serviceorderId;
        hash += (int) serviceId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblServicelistPK)) {
            return false;
        }
        TblServicelistPK other = (TblServicelistPK) object;
        if (this.serviceorderId != other.serviceorderId) {
            return false;
        }
        if (this.serviceId != other.serviceId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblServicelistPK[ serviceorderId=" + serviceorderId + ", serviceId=" + serviceId + " ]";
    }
    
}
