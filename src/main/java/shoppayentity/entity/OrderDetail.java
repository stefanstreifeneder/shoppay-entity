/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppayentity.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stefan
 */
@Entity
@Table(name = "ORDER_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o"),
    @NamedQuery(name = "OrderDetail.findByIdOrderDetail", query = "SELECT o FROM OrderDetail o WHERE o.idOrderDetail = :idOrderDetail"),
    @NamedQuery(name = "OrderDetail.findByQty", query = "SELECT o FROM OrderDetail o WHERE o.qty = :qty")})
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ORDER_DETAIL")
    private Integer idOrderDetail;
    @Column(name = "QTY")
    private Integer qty;
    @JoinColumn(name = "CUSTOMER_ORDER", referencedColumnName = "ID_CUSTOMER_ORDER")
    @ManyToOne
    private CustomerOrder customerOrder;

    public OrderDetail() {
    }

    public OrderDetail(Integer idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public Integer getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(Integer idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrderDetail != null ? idOrderDetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.idOrderDetail == null && other.idOrderDetail != null) || (this.idOrderDetail != null && !this.idOrderDetail.equals(other.idOrderDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "shoppayentity.entity.OrderDetail[ idOrderDetail=" + idOrderDetail + " ]";
    }
    
}
