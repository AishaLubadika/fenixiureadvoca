/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.converters;

import advocacia.fenix.ejbs.EstadoProcessoFacade;
import advocacia.fenix.entities.EstadoProcesso;
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
@FacesConverter(value = "estadoProcessoConverter", forClass = EstadoProcesso.class)
public class EstadoProcessoConverter implements Converter {
    
    EstadoProcessoFacade estadoProcessoFacade= lookupEstadoProcessofacade();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        EstadoProcesso estadoProcesso;
        if (value != null) {
            estadoProcesso = (EstadoProcesso)estadoProcessoFacade.find(Integer.parseInt(value));
            return estadoProcesso;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((EstadoProcesso) value).getIdEstadoProcesso().toString();
        }
        return null;
    }

    private EstadoProcessoFacade lookupEstadoProcessofacade() {
         Context context = null;
        try {
            context = new InitialContext();
            return (EstadoProcessoFacade) context.lookup("java:global/advocaciafenix/EstadoProcessoFacade");
        } catch (NamingException ne) {
            System.out.println("Erro" + ne.getMessage());
            return null;
        }
    }
    
}
