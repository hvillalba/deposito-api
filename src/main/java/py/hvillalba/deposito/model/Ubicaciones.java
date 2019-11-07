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
@Table(name = "Ubicaciones")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Ubicaciones.findAll", query = "SELECT u FROM Ubicaciones u"), @NamedQuery(name = "Ubicaciones.findByOid", query = "SELECT u FROM Ubicaciones u WHERE u.oid = :oid"), @NamedQuery(name = "Ubicaciones.findByActivo", query = "SELECT u FROM Ubicaciones u WHERE u.activo = :activo") })
public class Ubicaciones implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Oid")
    private Integer oid;
    @Column(name = "Activo")
    private Boolean activo;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "ubicaciones")
    private List<RepartoPicking> repartoPickingList;
    @JoinColumn(name = "Calle", referencedColumnName = "Calle")
    @ManyToOne(optional = false)
    private Calle calle;
    @JoinColumn(name = "Deposito", referencedColumnName = "Deposito")
    @ManyToOne(optional = false)
    private Deposito deposito;
    @JoinColumn(name = "Estante", referencedColumnName = "Estante")
    @ManyToOne(optional = false)
    private Estante estante;
    @JoinColumn(name = "Fila", referencedColumnName = "Fila")
    @ManyToOne(optional = false)
    private Fila fila;
    @JoinColumn(name = "Sucursal", referencedColumnName = "Sucursal")
    @ManyToOne(optional = false)
    private Sucursal sucursal;
    @Transient
    private Double existencia;
    @Transient
    private String codigoArticulo;
    @Transient
    private String lote;
    
    public Ubicaciones() {
    }
    
    public Ubicaciones(final Integer oid) {
        this.oid = oid;
    }
    
    public Integer getOid() {
        return this.oid;
    }
    
    public void setOid(final Integer oid) {
        this.oid = oid;
    }
    
    public Boolean getActivo() {
        return this.activo;
    }
    
    public void setActivo(final Boolean activo) {
        this.activo = activo;
    }
    
    @XmlTransient
    public List<RepartoPicking> getRepartoPickingList() {
        return this.repartoPickingList;
    }
    
    public void setRepartoPickingList(final List<RepartoPicking> repartoPickingList) {
        this.repartoPickingList = repartoPickingList;
    }
    
    public Calle getCalle() {
        return this.calle;
    }
    
    public void setCalle(final Calle calle) {
        this.calle = calle;
    }
    
    public Deposito getDeposito() {
        return this.deposito;
    }
    
    public void setDeposito(final Deposito deposito) {
        this.deposito = deposito;
    }
    
    public Estante getEstante() {
        return this.estante;
    }
    
    public void setEstante(final Estante estante) {
        this.estante = estante;
    }
    
    public Fila getFila() {
        return this.fila;
    }
    
    public void setFila(final Fila fila) {
        this.fila = fila;
    }
    
    public Sucursal getSucursal() {
        return this.sucursal;
    }
    
    public void setSucursal(final Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += ((this.oid != null) ? this.oid.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Ubicaciones)) {
            return false;
        }
        final Ubicaciones other = (Ubicaciones)object;
        return (this.oid != null || other.oid == null) && (this.oid == null || this.oid.equals(other.oid));
    }
    
    @Override
    public String toString() {
        return "py.hvillalba.deposito.api.model.Ubicaciones[ oid=" + this.oid + " ]";
    }
    
    public Double getExistencia() {
        return this.existencia;
    }
    
    public void setExistencia(final Double existencia) {
        this.existencia = existencia;
    }
    
    public String getCodigoArticulo() {
        return this.codigoArticulo;
    }
    
    public void setCodigoArticulo(final String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }
    
    public String getLote() {
        return this.lote;
    }
    
    public void setLote(final String lote) {
        this.lote = lote;
    }
}
