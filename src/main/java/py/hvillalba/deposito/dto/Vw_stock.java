package py.hvillalba.deposito.dto;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hectorvillalba
 */
public class Vw_stock implements Serializable
{
    private String codigoArticulo;
    private String lote;
    private Integer codigoSucursal;
    private String codigoDeposito;
    private String codigoCalle;
    private String codigoEstante;
    private String codigoFila;
    private Double existencia;
    private String sucursalDescripcion;
    private String depositoDescripcion;
    private Integer ubicacion;
    
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
    
    public Integer getCodigoSucursal() {
        return this.codigoSucursal;
    }
    
    public void setCodigoSucursal(final Integer codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }
    
    public String getCodigoDeposito() {
        return this.codigoDeposito;
    }
    
    public void setCodigoDeposito(final String codigoDeposito) {
        this.codigoDeposito = codigoDeposito;
    }
    
    public String getCodigoCalle() {
        return this.codigoCalle;
    }
    
    public void setCodigoCalle(final String codigoCalle) {
        this.codigoCalle = codigoCalle;
    }
    
    public String getCodigoEstante() {
        return this.codigoEstante;
    }
    
    public void setCodigoEstante(final String codigoEstante) {
        this.codigoEstante = codigoEstante;
    }
    
    public String getCodigoFila() {
        return this.codigoFila;
    }
    
    public void setCodigoFila(final String codigoFila) {
        this.codigoFila = codigoFila;
    }
    
    public Double getExistencia() {
        return this.existencia;
    }
    
    public void setExistencia(final Double existencia) {
        this.existencia = existencia;
    }
    
    public String getSucursalDescripcion() {
        return this.sucursalDescripcion;
    }
    
    public void setSucursalDescripcion(final String sucursalDescripcion) {
        this.sucursalDescripcion = sucursalDescripcion;
    }
    
    public String getDepositoDescripcion() {
        return this.depositoDescripcion;
    }
    
    public void setDepositoDescripcion(final String depositoDescripcion) {
        this.depositoDescripcion = depositoDescripcion;
    }
    
    public Integer getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(final Integer ubicacion) {
        this.ubicacion = ubicacion;
    }
}
