/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Cliente;
import Modelo.ClienteFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author yeye2
 */
@Named(value = "controladorCliente")
@SessionScoped
public class ControladorCliente implements Serializable {

    @EJB
    private ClienteFacadeLocal clienteFacade;

    public ClienteFacadeLocal getClienteFacade() {
        return clienteFacade;
    }

    public void setClienteFacade(ClienteFacadeLocal clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    Cliente cliente = new Cliente ();
    
    /**
     * Creates a new instance of ControladorCliente
     */
    
    
    public ControladorCliente() {
    }
    public List <Cliente> listarCliente(){
     return this.clienteFacade.findAll();
    }
     public String newCliente() {
        this.clienteFacade.create(cliente);
        cliente = new Cliente();
        return "listarClienteFiltro";
    }
 public String update (Cliente cliente){
     this.cliente= cliente;
     return "editarCliente";
 }    
 public String update() {
        this.clienteFacade.edit(cliente);
        
       return "listarClienteFiltro";
    }
   public String deleteCliente (Cliente cliente){
    this.cliente= cliente;
    return "eliminarCliente";
    }
 public String deleteCliente (){
     this.clienteFacade.remove(cliente);
     return "listarClienteFiltro";
     
 }

 
}
