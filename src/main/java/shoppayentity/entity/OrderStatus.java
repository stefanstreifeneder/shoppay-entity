/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppayentity.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stefan
 */
@Entity
@Table(name = "ORDER_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderStatus.findAll", query = "SELECT o FROM OrderStatus o"),
    @NamedQuery(name = "OrderStatus.findByIdOrderStatus", query = "SELECT o FROM OrderStatus o WHERE o.idOrderStatus = :idOrderStatus"),
    @NamedQuery(name = "OrderStatus.findByStatus", query = "SELECT o FROM OrderStatus o WHERE o.status = :status"),
    @NamedQuery(name = "OrderStatus.findByDescription", query = "SELECT o FROM OrderStatus o WHERE o.description = :description")})
public class OrderStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ORDER_STATUS")
    private Integer idOrderStatus;
    @Size(max = 45)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "orderStatus")
    private Collection<CustomerOrder> customerOrderCollection;

    public OrderStatus() {
    }

    public OrderStatus(Integer idOrderStatus) {
        this.idOrderStatus = idOrderStatus;
    }

    public Integer getIdOrderStatus() {
        return idOrderStatus;
    }

    public void setIdOrderStatus(Integer idOrderStatus) {
        this.idOrderStatus = idOrderStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<CustomerOrder> getCustomerOrderCollection() {
        return customerOrderCollection;
    }

    public void setCustomerOrderCollection(Collection<CustomerOrder> customerOrderCollection) {
        this.customerOrderCollection = customerOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrderStatus != null ? idOrderStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderStatus)) {
            return false;
        }
        OrderStatus other = (OrderStatus) object;
        if ((this.idOrderStatus == null && other.idOrderStatus != null) || (this.idOrderStatus != null && !this.idOrderStatus.equals(other.idOrderStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "shoppayentity.entity.OrderStatus[ idOrderStatus=" + idOrderStatus + " ]";
    }
    
}
