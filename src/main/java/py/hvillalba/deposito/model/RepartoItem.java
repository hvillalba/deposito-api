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
import javax.persistence.Transient;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
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
@Table(name = "RepartoItem")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "RepartoItem.findAll", query = "SELECT r FROM RepartoItem r"), @NamedQuery(name = "RepartoItem.findByOid", query = "SELECT r FROM RepartoItem r WHERE r.oid = :oid"), @NamedQuery(name = "RepartoItem.findByRegistroFactura", query = "SELECT r FROM RepartoItem r WHERE r.registroFactura = :registroFactura"), @NamedQuery(name = "RepartoItem.findByFactura", query = "SELECT r FROM RepartoItem r WHERE r.factura = :factura"), @NamedQuery(name = "RepartoItem.findByCantidad", query = "SELECT r FROM RepartoItem r WHERE r.cantidad = :cantidad"), @NamedQuery(name = "RepartoItem.findByConfirmado", query = "SELECT r FROM RepartoItem r WHERE r.confirmado = :confirmado") })
public class RepartoItem implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Oid")
    private Integer oid;
    @Column(name = "RegistroFactura")
    private Integer registroFactura;
    @Size(max = 15)
    @Column(name = "Factura")
    private String factura;
    @Column(name = "Cantidad")
    private Float cantidad;
    @Column(name = "Confirmado")
    private Boolean confirmado;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "repartoItem")
    private List<RepartoPicking> repartoPickingList;
    @JoinColumn(name = "ArticuloLote", referencedColumnName = "Oid")
    @ManyToOne(optional = false)
    private ArticuloLote articuloLote;
    @JoinColumn(name = "Reparto", referencedColumnName = "Oid")
    @ManyToOne(optional = false)
    private Reparto reparto;
    @Column(name = "RazonSocial")
    private String razonSocial;
    @Transient
    private Integer cantidadIngresada;
    
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(final String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
    public RepartoItem() {
    }
    
    public RepartoItem(final Integer oid) {
        this.oid = oid;
    }
    
    public Integer getOid() {
        return this.oid;
    }
    
    public void setOid(final Integer oid) {
        this.oid = oid;
    }
    
    public Integer getRegistroFactura() {
        return this.registroFactura;
    }
    
    public void setRegistroFactura(final Integer registroFactura) {
        this.registroFactura = registroFactura;
    }
    
    public String getFactura() {
        return this.factura;
    }
    
    public void setFactura(final String factura) {
        this.factura = factura;
    }
    
    public Float getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(final Float cantidad) {
        this.cantidad = cantidad;
    }
    
    public Boolean getConfirmado() {
        return this.confirmado;
    }
    
    public void setConfirmado(final Boolean confirmado) {
        this.confirmado = confirmado;
    }
    
    @XmlTransient
    public List<RepartoPicking> getRepartoPickingList() {
        return this.repartoPickingList;
    }
    
    public void setRepartoPickingList(final List<RepartoPicking> repartoPickingList) {
        this.repartoPickingList = repartoPickingList;
    }
    
    public ArticuloLote getArticuloLote() {
        return this.articuloLote;
    }
    
    public void setArticuloLote(final ArticuloLote articuloLote) {
        this.articuloLote = articuloLote;
    }
    
    public Reparto getReparto() {
        return this.reparto;
    }
    
    public void setReparto(final Reparto reparto) {
        this.reparto = reparto;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += ((this.oid != null) ? this.oid.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof RepartoItem)) {
            return false;
        }
        final RepartoItem other = (RepartoItem)object;
        return (this.oid != null || other.oid == null) && (this.oid == null || this.oid.equals(other.oid));
    }
    
    @Override
    public String toString() {
        return "py.hvillalba.deposito.api.model.RepartoItem[ oid=" + this.oid + " ]";
    }
    
    public Integer getCantidadIngresada() {
        return this.cantidadIngresada;
    }
    
    public void setCantidadIngresada(final Integer cantidadIngresada) {
        this.cantidadIngresada = cantidadIngresada;
    }
}
