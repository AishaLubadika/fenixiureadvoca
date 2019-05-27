/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.converters;

import advocacia.fenix.ejbs.ProvinciaFacade;
import advocacia.fenix.entities.Provincia;
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

@FacesConverter(value = "provinciaConverter", forClass = Provincia.class)
public class ProvinciaConverter implements Converter{
    ProvinciaFacade provinciaFacade =lookupProvinciaFacade();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Provincia provincia;
         if (value != null) {
            provincia = (Provincia)provinciaFacade.find(Integer.parseInt(value));
            return provincia;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Provincia) value).getIdProvincia().toString();
        }
        return null;
    }

    private ProvinciaFacade lookupProvinciaFacade() {
        Context context = null;
        try {
            context = new InitialContext();
            return (ProvinciaFacade) context.lookup("java:global/advocaciafenix/ProvinciaFacade");
        } catch (NamingException ne) {
            System.out.println("Erro" + ne.getMessage());
            return null;
        }
    }
    
}
