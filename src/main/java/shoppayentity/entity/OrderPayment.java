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
@Table(name = "ORDER_PAYMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderPayment.findAll", query = "SELECT o FROM OrderPayment o"),
    @NamedQuery(name = "OrderPayment.findByIdOrderPayment", query = "SELECT o FROM OrderPayment o WHERE o.idOrderPayment = :idOrderPayment")})
public class OrderPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ORDER_PAYMENT")
    private Integer idOrderPayment;
    @JoinColumn(name = "CUSTOMER_ORDER", referencedColumnName = "ID_CUSTOMER_ORDER")
    @ManyToOne
    private CustomerOrder customerOrder;
    @JoinColumn(name = "PERSON_PAYMENT", referencedColumnName = "ID_PERSON_PAYMENT")
    @ManyToOne
    private PersonPayment personPayment;

    public OrderPayment() {
    }

    public OrderPayment(Integer idOrderPayment) {
        this.idOrderPayment = idOrderPayment;
    }

    public Integer getIdOrderPayment() {
        return idOrderPayment;
    }

    public void setIdOrderPayment(Integer idOrderPayment) {
        this.idOrderPayment = idOrderPayment;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public PersonPayment getPersonPayment() {
        return personPayment;
    }

    public void setPersonPayment(PersonPayment personPayment) {
        this.personPayment = personPayment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrderPayment != null ? idOrderPayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderPayment)) {
            return false;
        }
        OrderPayment other = (OrderPayment) object;
        if ((this.idOrderPayment == null && other.idOrderPayment != null) || (this.idOrderPayment != null && !this.idOrderPayment.equals(other.idOrderPayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "shoppayentity.entity.OrderPayment[ idOrderPayment=" + idOrderPayment + " ]";
    }
    
}
