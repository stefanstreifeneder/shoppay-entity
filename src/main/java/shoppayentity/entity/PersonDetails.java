/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppayentity.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stefan
 */
@Entity
@Table(name = "PERSON_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonDetails.findAll", query = "SELECT p FROM PersonDetails p"),
    @NamedQuery(name = "PersonDetails.findByIdPersonDetails", query = "SELECT p FROM PersonDetails p WHERE p.idPersonDetails = :idPersonDetails"),
    @NamedQuery(name = "PersonDetails.findByStreet", query = "SELECT p FROM PersonDetails p WHERE p.street = :street"),
    @NamedQuery(name = "PersonDetails.findByCity", query = "SELECT p FROM PersonDetails p WHERE p.city = :city"),
    @NamedQuery(name = "PersonDetails.findByPostalcode", query = "SELECT p FROM PersonDetails p WHERE p.postalcode = :postalcode"),
    @NamedQuery(name = "PersonDetails.findByCountry", query = "SELECT p FROM PersonDetails p WHERE p.country = :country"),
    @NamedQuery(name = "PersonDetails.findByTelephone", query = "SELECT p FROM PersonDetails p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "PersonDetails.findByBirthday", query = "SELECT p FROM PersonDetails p WHERE p.birthday = :birthday")})
public class PersonDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSON_DETAILS")
    private Integer idPersonDetails;
    @Size(max = 100)
    @Column(name = "STREET")
    private String street;
    @Size(max = 100)
    @Column(name = "CITY")
    private String city;
    @Size(max = 100)
    @Column(name = "POSTALCODE")
    private String postalcode;
    @Size(max = 100)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 100)
    @Column(name = "TELEPHONE")
    private String telephone;
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @JoinColumn(name = "PERSON", referencedColumnName = "ID_PERSON")
    @ManyToOne
    private Person person;

    public PersonDetails() {
    }

    public PersonDetails(Integer idPersonDetails) {
        this.idPersonDetails = idPersonDetails;
    }

    public Integer getIdPersonDetails() {
        return idPersonDetails;
    }

    public void setIdPersonDetails(Integer idPersonDetails) {
        this.idPersonDetails = idPersonDetails;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
        hash += (idPersonDetails != null ? idPersonDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonDetails)) {
            return false;
        }
        PersonDetails other = (PersonDetails) object;
        if ((this.idPersonDetails == null && other.idPersonDetails != null) || (this.idPersonDetails != null && !this.idPersonDetails.equals(other.idPersonDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "shoppayentity.entity.PersonDetails[ idPersonDetails=" + idPersonDetails + " ]";
    }
    
}
