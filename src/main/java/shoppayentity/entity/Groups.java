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
@Table(name = "GROUPS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g"),
    @NamedQuery(name = "Groups.findByIdGroups", query = "SELECT g FROM Groups g WHERE g.idGroups = :idGroups"),
    @NamedQuery(name = "Groups.findByName", query = "SELECT g FROM Groups g WHERE g.name = :name"),
    @NamedQuery(name = "Groups.findByDescription", query = "SELECT g FROM Groups g WHERE g.description = :description")})
public class Groups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_GROUPS")
    private Integer idGroups;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 300)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "groups")
    private Collection<PersonGroups> personGroupsCollection;

    public Groups() {
    }

    public Groups(Integer idGroups) {
        this.idGroups = idGroups;
    }

    public Integer getIdGroups() {
        return idGroups;
    }

    public void setIdGroups(Integer idGroups) {
        this.idGroups = idGroups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<PersonGroups> getPersonGroupsCollection() {
        return personGroupsCollection;
    }

    public void setPersonGroupsCollection(Collection<PersonGroups> personGroupsCollection) {
        this.personGroupsCollection = personGroupsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGroups != null ? idGroups.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groups)) {
            return false;
        }
        Groups other = (Groups) object;
        if ((this.idGroups == null && other.idGroups != null) || (this.idGroups != null && !this.idGroups.equals(other.idGroups))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "shoppayentity.entity.Groups[ idGroups=" + idGroups + " ]";
    }
    
}
