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
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.Basic;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Table(name = "TransportistaChofer")
@XmlRootElement
public class TransportistaChofer implements Serializable
{
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdChofer")
    private Integer idChofer;
    @Column(name = "nombreChofer")
    private String nombreChofer;
    @Column(name = "Documento")
    private String documento;
    @JoinColumn(name = "Transportista", referencedColumnName = "Transportista")
    @ManyToOne(optional = false)
    private Transportista transportista;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "reparto")
    private List<RepartoItem> repartoItemList;
    @Column(name = "Codigo")
    private Long codigo;
    
    public Integer getIdChofer() {
        return this.idChofer;
    }
    
    public void setIdChofer(final Integer idChofer) {
        this.idChofer = idChofer;
    }
    
    public String getNombreChofer() {
        return this.nombreChofer;
    }
    
    public void setNombreChofer(final String nombreChofer) {
        this.nombreChofer = nombreChofer;
    }
    
    public String getDocumento() {
        return this.documento;
    }
    
    public void setDocumento(final String documento) {
        this.documento = documento;
    }
    
    public Transportista getTransportista() {
        return this.transportista;
    }
    
    public void setTransportista(final Transportista transportista) {
        this.transportista = transportista;
    }
    
    public Long getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Long codigo) {
        this.codigo = codigo;
    }
}
