/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppayentity.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stefan
 */
@Entity
@Table(name = "CUSTOMER_ORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerOrder.findAll", query = "SELECT c FROM CustomerOrder c"),
    @NamedQuery(name = "CustomerOrder.findByIdCustomerOrder", query = "SELECT c FROM CustomerOrder c WHERE c.idCustomerOrder = :idCustomerOrder"),
    @NamedQuery(name = "CustomerOrder.findByAmount", query = "SELECT c FROM CustomerOrder c WHERE c.amount = :amount"),
    @NamedQuery(name = "CustomerOrder.findByDateCreated", query = "SELECT c FROM CustomerOrder c WHERE c.dateCreated = :dateCreated")})
public class CustomerOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CUSTOMER_ORDER")
    private Integer idCustomerOrder;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "DATE_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @JoinColumn(name = "ORDER_STATUS", referencedColumnName = "ID_ORDER_STATUS")
    @ManyToOne
    private OrderStatus orderStatus;
    @JoinColumn(name = "PERSON", referencedColumnName = "ID_PERSON")
    @ManyToOne
    private Person person;
    @OneToMany(mappedBy = "customerOrder")
    private Collection<OrderDetail> orderDetailCollection;
    @OneToMany(mappedBy = "customerOrder")
    private Collection<OrderPayment> orderPaymentCollection;

    public CustomerOrder() {
    }

    public CustomerOrder(Integer idCustomerOrder) {
        this.idCustomerOrder = idCustomerOrder;
    }

    public Integer getIdCustomerOrder() {
        return idCustomerOrder;
    }

    public void setIdCustomerOrder(Integer idCustomerOrder) {
        this.idCustomerOrder = idCustomerOrder;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @XmlTransient
    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
    }

    @XmlTransient
    public Collection<OrderPayment> getOrderPaymentCollection() {
        return orderPaymentCollection;
    }

    public void setOrderPaymentCollection(Collection<OrderPayment> orderPaymentCollection) {
        this.orderPaymentCollection = orderPaymentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCustomerOrder != null ? idCustomerOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerOrder)) {
            return false;
        }
        CustomerOrder other = (CustomerOrder) object;
        if ((this.idCustomerOrder == null && other.idCustomerOrder != null) || (this.idCustomerOrder != null && !this.idCustomerOrder.equals(other.idCustomerOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "shoppayentity.entity.CustomerOrder[ idCustomerOrder=" + idCustomerOrder + " ]";
    }
    
}
