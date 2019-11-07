/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.hvillalba.deposito.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hectorvillalba
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Response<T>
{
    private Integer codigo;
    private String mensaje;
    private T data;
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getMensaje() {
        return this.mensaje;
    }
    
    public void setMensaje(final String mensaje) {
        this.mensaje = mensaje;
    }
    
    public T getData() {
        return this.data;
    }
    
    public void setData(final T data) {
        this.data = data;
    }
}
