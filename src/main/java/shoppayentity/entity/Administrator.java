/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppayentity.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Cacheable(true)
@Table(name = "PERSON")
@DiscriminatorValue(value = "admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Person a"),
    @NamedQuery(name = "Administrator.findByIdPerson", query = "SELECT a FROM Person a WHERE a.idPerson = :idPerson")})
public class Administrator extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSON")
    private Integer idPerson;
    
    @JoinColumn(name = "ID_PERSON", referencedColumnName = "ID_PERSON", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;
    
    
//    private List<Object> properties;
   

    public Administrator() {
    }

    public Administrator(Integer idPerson) {
        this.idPerson = idPerson;
    }
    
     /**
     * Get the value of properties
     *
     * @return the value of properties
     */
//    @XmlTransient
//    public List<Object> getProperties() {
//        return properties;
//    }

    /**
     * Set the value of properties
     *
     * @param properties new value of properties
     */
//    public void setProperties(List<Object> properties) {
//        this.properties = properties;
//    }
    
    

    

    @Override
    public Integer getIdPerson() {
        return idPerson;
    }

    @Override
    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
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
        hash += (idPerson != null ? idPerson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrator)) {
            return false;
        }
        Administrator other = (Administrator) object;
        if ( !this.idPerson.equals(other.idPerson)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "shoppay.entity.Administrator[ idPerson=" + idPerson + " ]";
    }
    
}
