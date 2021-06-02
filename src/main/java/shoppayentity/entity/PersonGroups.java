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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stefan
 */
@Entity
@Table(name = "PERSON_GROUPS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonGroups.findAll", query = "SELECT p FROM PersonGroups p"),
    @NamedQuery(name = "PersonGroups.findByIdPersonGroups", query = "SELECT p FROM PersonGroups p WHERE p.idPersonGroups = :idPersonGroups"),
    @NamedQuery(name = "PersonGroups.findByEmail", query = "SELECT p FROM PersonGroups p WHERE p.email = :email")})
public class PersonGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSON_GROUPS")
    private Integer idPersonGroups;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @JoinColumn(name = "GROUPS", referencedColumnName = "ID_GROUPS")
    @ManyToOne
    private Groups groups;
    @JoinColumn(name = "PERSON", referencedColumnName = "ID_PERSON")
    @ManyToOne
    private Person person;

    public PersonGroups() {
    }

    public PersonGroups(Integer idPersonGroups) {
        this.idPersonGroups = idPersonGroups;
    }

    public Integer getIdPersonGroups() {
        return idPersonGroups;
    }

    public void setIdPersonGroups(Integer idPersonGroups) {
        this.idPersonGroups = idPersonGroups;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
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
        hash += (idPersonGroups != null ? idPersonGroups.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonGroups)) {
            return false;
        }
        PersonGroups other = (PersonGroups) object;
        if ((this.idPersonGroups == null && other.idPersonGroups != null) || (this.idPersonGroups != null && !this.idPersonGroups.equals(other.idPersonGroups))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "shoppayentity.entity.PersonGroups[ idPersonGroups=" + idPersonGroups + " ]";
    }
    
}
