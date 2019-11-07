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
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Table(name = "RepartoPicking")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "RepartoPicking.findAll", query = "SELECT r FROM RepartoPicking r"), @NamedQuery(name = "RepartoPicking.findByOid", query = "SELECT r FROM RepartoPicking r WHERE r.oid = :oid"), @NamedQuery(name = "RepartoPicking.findByCantidadNecesaria", query = "SELECT r FROM RepartoPicking r WHERE r.cantidadNecesaria = :cantidadNecesaria"), @NamedQuery(name = "RepartoPicking.findByCantidadIngresada", query = "SELECT r FROM RepartoPicking r WHERE r.cantidadIngresada = :cantidadIngresada"), @NamedQuery(name = "RepartoPicking.findByCantidadContada", query = "SELECT r FROM RepartoPicking r WHERE r.cantidadContada = :cantidadContada") })
public class RepartoPicking implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "Oid")
    private Integer oid;
    @Column(name = "CantidadNecesaria")
    private Double cantidadNecesaria;
    @Column(name = "CantidadIngresada")
    private Double cantidadIngresada;
    @Column(name = "CantidadContada")
    private Double cantidadContada;
    @JoinColumn(name = "RepartoItem", referencedColumnName = "Oid")
    @ManyToOne(optional = false)
    private RepartoItem repartoItem;
    @JoinColumn(name = "Ubicaciones", referencedColumnName = "Oid")
    @ManyToOne(optional = false)
    private Ubicaciones ubicaciones;
    
    public RepartoPicking() {
    }
    
    public RepartoPicking(final Integer oid) {
        this.oid = oid;
    }
    
    public Integer getOid() {
        return this.oid;
    }
    
    public void setOid(final Integer oid) {
        this.oid = oid;
    }
    
    public Double getCantidadNecesaria() {
        return this.cantidadNecesaria;
    }
    
    public void setCantidadNecesaria(final Double cantidadNecesaria) {
        this.cantidadNecesaria = cantidadNecesaria;
    }
    
    public Double getCantidadIngresada() {
        return this.cantidadIngresada;
    }
    
    public void setCantidadIngresada(final Double cantidadIngresada) {
        this.cantidadIngresada = cantidadIngresada;
    }
    
    public Double getCantidadContada() {
        return this.cantidadContada;
    }
    
    public void setCantidadContada(final Double cantidadContada) {
        this.cantidadContada = cantidadContada;
    }
    
    public RepartoItem getRepartoItem() {
        return this.repartoItem;
    }
    
    public void setRepartoItem(final RepartoItem repartoItem) {
        this.repartoItem = repartoItem;
    }
    
    public Ubicaciones getUbicaciones() {
        return this.ubicaciones;
    }
    
    public void setUbicaciones(final Ubicaciones ubicaciones) {
        this.ubicaciones = ubicaciones;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += ((this.oid != null) ? this.oid.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof RepartoPicking)) {
            return false;
        }
        final RepartoPicking other = (RepartoPicking)object;
        return (this.oid != null || other.oid == null) && (this.oid == null || this.oid.equals(other.oid));
    }
    
    @Override
    public String toString() {
        return "py.hvillalba.deposito.api.model.RepartoPicking[ oid=" + this.oid + " ]";
    }
}
