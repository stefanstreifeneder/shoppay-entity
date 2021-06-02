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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stefan
 */
@Entity
@Table(name = "PERSON_PAYMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonPayment.findAll", query = "SELECT p FROM PersonPayment p"),
    @NamedQuery(name = "PersonPayment.findByIdPersonPayment", query = "SELECT p FROM PersonPayment p WHERE p.idPersonPayment = :idPersonPayment"),
    @NamedQuery(name = "PersonPayment.findByNamePaymentProvider", query = "SELECT p FROM PersonPayment p WHERE p.namePaymentProvider = :namePaymentProvider"),
    @NamedQuery(name = "PersonPayment.findByIbanId", query = "SELECT p FROM PersonPayment p WHERE p.ibanId = :ibanId"),
    @NamedQuery(name = "PersonPayment.findByBicId", query = "SELECT p FROM PersonPayment p WHERE p.bicId = :bicId"),
    @NamedQuery(name = "PersonPayment.findByCreditCardNumber", query = "SELECT p FROM PersonPayment p WHERE p.creditCardNumber = :creditCardNumber"),
    @NamedQuery(name = "PersonPayment.findByExpirationDate", query = "SELECT p FROM PersonPayment p WHERE p.expirationDate = :expirationDate"),
    @NamedQuery(name = "PersonPayment.findByCheckNumber", query = "SELECT p FROM PersonPayment p WHERE p.checkNumber = :checkNumber")})
public class PersonPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSON_PAYMENT")
    private Integer idPersonPayment;
    @Size(max = 50)
    @Column(name = "NAME_PAYMENT_PROVIDER")
    private String namePaymentProvider;
    @Size(max = 26)
    @Column(name = "IBAN_ID")
    private String ibanId;
    @Size(max = 11)
    @Column(name = "BIC_ID")
    private String bicId;
    @Size(max = 23)
    @Column(name = "CREDIT_CARD_NUMBER")
    private String creditCardNumber;
    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @Size(max = 3)
    @Column(name = "CHECK_NUMBER")
    private String checkNumber;
    
    @OneToMany(mappedBy = "personPayment")
    private Collection<OrderPayment> orderPaymentCollection;
    
    @JoinColumn(name = "PERSON", referencedColumnName = "ID_PERSON")
    @ManyToOne
    private Person person;

    public PersonPayment() {
    }

    public PersonPayment(Integer idPersonPayment) {
        this.idPersonPayment = idPersonPayment;
    }

    public Integer getIdPersonPayment() {
        return idPersonPayment;
    }

    public void setIdPersonPayment(Integer idPersonPayment) {
        this.idPersonPayment = idPersonPayment;
    }

    public String getNamePaymentProvider() {
        return namePaymentProvider;
    }

    public void setNamePaymentProvider(String namePaymentProvider) {
        this.namePaymentProvider = namePaymentProvider;
    }

    public String getIbanId() {
        return ibanId;
    }

    public void setIbanId(String ibanId) {
        this.ibanId = ibanId;
    }

    public String getBicId() {
        return bicId;
    }

    public void setBicId(String bicId) {
        this.bicId = bicId;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @XmlTransient
    public Collection<OrderPayment> getOrderPaymentCollection() {
        return orderPaymentCollection;
    }

    public void setOrderPaymentCollection(Collection<OrderPayment> orderPaymentCollection) {
        this.orderPaymentCollection = orderPaymentCollection;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonPayment != null ? idPersonPayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonPayment)) {
            return false;
        }
        PersonPayment other = (PersonPayment) object;
        if ((this.idPersonPayment == null && other.idPersonPayment != null) || (this.idPersonPayment != null && !this.idPersonPayment.equals(other.idPersonPayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "shoppayentity.entity.PersonPayment[ idPersonPayment=" + idPersonPayment + " ]";
    }
    
}
