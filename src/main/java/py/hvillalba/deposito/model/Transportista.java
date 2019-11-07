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
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.Basic;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Table(name = "Transportista")
@XmlRootElement
public class Transportista implements Serializable
{
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Transportista")
    private Integer transportista;
    @Column(name = "RazonSocial")
    private String razonSocial;
    @Column(name = "Ruc")
    private String ruc;
    @Column(name = "Codigo")
    private Integer codigo;
    
    public Integer getTransportista() {
        return this.transportista;
    }
    
    public void setTransportista(final Integer transportista) {
        this.transportista = transportista;
    }
    
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(final String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
    public String getRuc() {
        return this.ruc;
    }
    
    public void setRuc(final String ruc) {
        this.ruc = ruc;
    }
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
}
