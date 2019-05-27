/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.mb;

import java.io.Serializable;
import javax.inject.Named;

import javax.enterprise.context.SessionScoped;

/**
 *
 * @author LUBADIKA
 */
@Named(value = "chamarPaginaMBean")
@SessionScoped
public class ChamarPaginaMBean implements Serializable{
      private static final long serialVersionUID = 1L;
    
    public ChamarPaginaMBean() {
    }
    
     public String listaradvogado() {
        return "advogado_listar.jsf";
    }
}
