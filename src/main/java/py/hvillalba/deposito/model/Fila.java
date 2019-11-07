/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.hvillalba.deposito.model;

/**
 *
 * @author hectorvillalba
 */
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Table(name = "Fila")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Fila.findAll", query = "SELECT f FROM Fila f"), @NamedQuery(name = "Fila.findByFila", query = "SELECT f FROM Fila f WHERE f.fila = :fila"), @NamedQuery(name = "Fila.findByDescripcion", query = "SELECT f FROM Fila f WHERE f.descripcion = :descripcion"), @NamedQuery(name = "Fila.findByCodigo", query = "SELECT f FROM Fila f WHERE f.codigo = :codigo") })
public class Fila implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fila")
    private Integer fila;
    @Size(max = 60)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 3)
    @Column(name = "Codigo")
    private String codigo;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "fila")
    private List<Ubicaciones> ubicacionesList;
    
    public Fila() {
    }
    
    public Fila(final Integer fila) {
        this.fila = fila;
    }
    
    public Integer getFila() {
        return this.fila;
    }
    
    public void setFila(final Integer fila) {
        this.fila = fila;
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
        hash += ((this.fila != null) ? this.fila.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Fila)) {
            return false;
        }
        final Fila other = (Fila)object;
        return (this.fila != null || other.fila == null) && (this.fila == null || this.fila.equals(other.fila));
    }
    
    @Override
    public String toString() {
        return "py.hvillalba.deposito.api.model.Fila[ fila=" + this.fila + " ]";
    }
}
