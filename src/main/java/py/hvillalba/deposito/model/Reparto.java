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
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Size;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import java.util.Date;
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
@Table(name = "Reparto")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Reparto.findAll", query = "SELECT r FROM Reparto r"), @NamedQuery(name = "Reparto.findByOid", query = "SELECT r FROM Reparto r WHERE r.oid = :oid"), @NamedQuery(name = "Reparto.findByRegistroOrigen", query = "SELECT r FROM Reparto r WHERE r.registroOrigen = :registroOrigen"), @NamedQuery(name = "Reparto.findByFecha", query = "SELECT r FROM Reparto r WHERE r.fecha = :fecha"), @NamedQuery(name = "Reparto.findByObservacion", query = "SELECT r FROM Reparto r WHERE r.observacion = :observacion"), @NamedQuery(name = "Reparto.findBySucursalCarga", query = "SELECT r FROM Reparto r WHERE r.sucursalCarga = :sucursalCarga"), @NamedQuery(name = "Reparto.findByDepositoCarga", query = "SELECT r FROM Reparto r WHERE r.depositoCarga = :depositoCarga"), @NamedQuery(name = "Reparto.findByConteoConfirmado", query = "SELECT r FROM Reparto r WHERE r.conteoConfirmado = :conteoConfirmado") })
public class Reparto implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Oid")
    private Integer oid;
    @Column(name = "RegistroOrigen")
    private Integer registroOrigen;
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 100)
    @Column(name = "Observacion")
    private String observacion;
    @Column(name = "SucursalCarga")
    private Integer sucursalCarga;
    @Size(max = 3)
    @Column(name = "DepositoCarga")
    private String depositoCarga;
    @Column(name = "ConteoConfirmado")
    private Boolean conteoConfirmado;
    @JoinColumn(name = "chofer", referencedColumnName = "IdChofer")
    @ManyToOne(optional = false)
    private TransportistaChofer chofer;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "reparto")
    private List<RepartoItem> repartoItemList;
    
    public Reparto() {
    }
    
    public Reparto(final Integer oid) {
        this.oid = oid;
    }
    
    public Integer getOid() {
        return this.oid;
    }
    
    public void setOid(final Integer oid) {
        this.oid = oid;
    }
    
    public Integer getRegistroOrigen() {
        return this.registroOrigen;
    }
    
    public void setRegistroOrigen(final Integer registroOrigen) {
        this.registroOrigen = registroOrigen;
    }
    
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(final Date fecha) {
        this.fecha = fecha;
    }
    
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(final String observacion) {
        this.observacion = observacion;
    }
    
    public Integer getSucursalCarga() {
        return this.sucursalCarga;
    }
    
    public void setSucursalCarga(final Integer sucursalCarga) {
        this.sucursalCarga = sucursalCarga;
    }
    
    public String getDepositoCarga() {
        return this.depositoCarga;
    }
    
    public void setDepositoCarga(final String depositoCarga) {
        this.depositoCarga = depositoCarga;
    }
    
    public Boolean getConteoConfirmado() {
        return this.conteoConfirmado;
    }
    
    public void setConteoConfirmado(final Boolean conteoConfirmado) {
        this.conteoConfirmado = conteoConfirmado;
    }
    
    @XmlTransient
    public List<RepartoItem> getRepartoItemList() {
        return this.repartoItemList;
    }
    
    public void setRepartoItemList(final List<RepartoItem> repartoItemList) {
        this.repartoItemList = repartoItemList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += ((this.oid != null) ? this.oid.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Reparto)) {
            return false;
        }
        final Reparto other = (Reparto)object;
        return (this.oid != null || other.oid == null) && (this.oid == null || this.oid.equals(other.oid));
    }
    
    @Override
    public String toString() {
        return "py.hvillalba.deposito.api.model.Reparto[ oid=" + this.oid + " ]";
    }
    
    public TransportistaChofer getChofer() {
        return this.chofer;
    }
    
    public void setChofer(final TransportistaChofer chofer) {
        this.chofer = chofer;
    }
}
