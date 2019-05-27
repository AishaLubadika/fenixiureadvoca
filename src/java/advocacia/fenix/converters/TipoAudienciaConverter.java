/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.converters;

import advocacia.fenix.ejbs.TipoAudienciaFacade;
import advocacia.fenix.entities.TipoAudiencia;
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
@FacesConverter(value = "tipoAudienciaConverter", forClass = TipoAudiencia.class)
public class TipoAudienciaConverter implements Converter{

    TipoAudienciaFacade tipoAudienciaFacade= lookupTipoAudiencia();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        TipoAudiencia tipoAudiencia;
         if (value != null) {
            tipoAudiencia = (TipoAudiencia)tipoAudienciaFacade.find(Integer.parseInt(value));
            return tipoAudiencia;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if (value != null) {
            return ((TipoAudiencia) value).getIdTipoAudiencia().toString();
        }
        return null;
    }

    private TipoAudienciaFacade lookupTipoAudiencia() {
           Context context = null;
        try {
            context = new InitialContext();
            return (TipoAudienciaFacade) context.lookup("java:global/advocaciafenix/TipoAudienciaFacade");
        } catch (NamingException ne) {
            System.out.println("Erro" + ne.getMessage());
            return null;
        }
    }
    
}
