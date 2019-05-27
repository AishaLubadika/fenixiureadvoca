/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.converters;

import advocacia.fenix.ejbs.TipoProcessoFacade;
import advocacia.fenix.entities.TipoProcesso;
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
@FacesConverter(value = "tipoProcessoConverter", forClass = TipoProcesso.class)
public class TipoProcessoConverter implements Converter{
    
    TipoProcessoFacade tipoProcessoFacade = lookupTipoProcessoFacade();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        TipoProcesso tipoProcesso;
        if (value != null) {
            tipoProcesso = (TipoProcesso)tipoProcessoFacade.find(Integer.parseInt(value));
            return tipoProcesso;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if (value != null) {
            return ((TipoProcesso) value).getIdTipoProcesso().toString();
        }
        return null;
    }

    private TipoProcessoFacade lookupTipoProcessoFacade() {
        Context context = null;
        try {
            context = new InitialContext();
            return (TipoProcessoFacade) context.lookup("java:global/advocaciafenix/TipoProcessoFacade");
        } catch (NamingException ne) {
            System.out.println("Erro" + ne.getMessage());
            return null;
        }
    }
    
}
