/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tbl_cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCart.findAll", query = "SELECT t FROM TblCart t"),
    @NamedQuery(name = "TblCart.findByCartId", query = "SELECT t FROM TblCart t WHERE t.cartId = :cartId"),
    @NamedQuery(name = "TblCart.findByQty", query = "SELECT t FROM TblCart t WHERE t.qty = :qty"),
@NamedQuery(name = "TblCart.findByUserId", query = "SELECT t FROM TblCart t WHERE t.userId = :userId")})
public class TblCart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cart_id")
    private Integer cartId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private int qty;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "created_at")
    private String createdAt;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "updated_at")
    private String updatedAt;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Usermaster userId;
    @JoinColumn(name = "part_id", referencedColumnName = "part_id")
    @ManyToOne(optional = false)
    private TblParts partId;

    public TblCart() {
    }

    public TblCart(Integer cartId) {
        this.cartId = cartId;
    }

    public TblCart(Integer cartId, int qty, String createdAt, String updatedAt) {
        this.cartId = cartId;
        this.qty = qty;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Usermaster getUserId() {
        return userId;
    }

    public void setUserId(Usermaster userId) {
        this.userId = userId;
    }

    public TblParts getPartId() {
        return partId;
    }

    public void setPartId(TblParts partId) {
        this.partId = partId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartId != null ? cartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCart)) {
            return false;
        }
        TblCart other = (TblCart) object;
        if ((this.cartId == null && other.cartId != null) || (this.cartId != null && !this.cartId.equals(other.cartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblCart[ cartId=" + cartId + " ]";
    }
    
}
