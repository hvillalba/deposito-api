/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.hvillalba.deposito.dto;

/**
 *
 * @author hectorvillalba
 */
public class Request<T>
{
    private String type;
    private T data;
    

    
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public T getData() {
        return this.data;
    }
    
    public void setData(final T data) {
        this.data = data;
    }
}
