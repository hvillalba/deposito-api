/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.hvillalba.deposito.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author hectorvillalba
 */
@Entity
@Table(name = "Calle")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Calle.findAll", query = "SELECT c FROM Calle c"), @NamedQuery(name = "Calle.findByCalle", query = "SELECT c FROM Calle c WHERE c.calle = :calle"), @NamedQuery(name = "Calle.findByDescripcion", query = "SELECT c FROM Calle c WHERE c.descripcion = :descripcion"), @NamedQuery(name = "Calle.findByCodigo", query = "SELECT c FROM Calle c WHERE c.codigo = :codigo") })
public class Calle implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Calle")
    private Integer calle;
    @Size(max = 60)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 3)
    @Column(name = "Codigo")
    private String codigo;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "calle")
    private List<Ubicaciones> ubicacionesList;
    
    public Calle() {
    }
    
    public Calle(final Integer calle) {
        this.calle = calle;
    }
    
    public Integer getCalle() {
        return this.calle;
    }
    
    public void setCalle(final Integer calle) {
        this.calle = calle;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final String codigo) {
        this.codigo = codigo;
    }
    
    @XmlTransient
    public List<Ubicaciones> getUbicacionesList() {
        return this.ubicacionesList;
    }
    
    public void setUbicacionesList(final List<Ubicaciones> ubicacionesList) {
        this.ubicacionesList = ubicacionesList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += ((this.calle != null) ? this.calle.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Calle)) {
            return false;
        }
        final Calle other = (Calle)object;
        return (this.calle != null || other.calle == null) && (this.calle == null || this.calle.equals(other.calle));
    }
    
    @Override
    public String toString() {
        return "py.hvillalba.deposito.api.model.Calle[ calle=" + this.calle + " ]";
    }
}
