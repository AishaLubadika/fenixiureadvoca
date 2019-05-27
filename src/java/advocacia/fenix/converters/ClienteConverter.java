/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.converters;

import advocacia.fenix.ejbs.ClienteFacade;
import advocacia.fenix.entities.Cliente;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author LUBADIKA
 */
@FacesConverter(value = "clienteConverter", forClass = Cliente.class)
public class ClienteConverter implements Converter{
    
    ClienteFacade clienteFacade =lookupClienteFacade();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Cliente cliente;
        if (value != null) {
            cliente = (Cliente)clienteFacade.find(Integer.parseInt(value));
            return cliente;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Cliente) value).getIdCliente().toString();
        }
        return null;
    }

    private ClienteFacade lookupClienteFacade() {
        Context context = null;
        try {
            context = new InitialContext();
            return (ClienteFacade) context.lookup("java:global/advocaciafenix/ClienteFacade");
        } catch (NamingException ne) {
            System.out.println("Erro" + ne.getMessage());
            return null;
        }
    }
    
}
