/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.converters;

import advocacia.fenix.ejbs.TipoDecisaoFacade;
import advocacia.fenix.entities.TipoDecisao;
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
@FacesConverter(value = "tipoDecisaoConverter", forClass = TipoDecisao.class)
public class TipoDecisaoConverter implements  Converter{
    
    TipoDecisaoFacade tipoDecisaoFacade = lookupTipoDecisaoFacade();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        TipoDecisao tipoDecisao;
        if (value != null) {
            tipoDecisao = (TipoDecisao)tipoDecisaoFacade.find(Integer.parseInt(value));
            return tipoDecisao;
        }
        return null;
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if (value != null) {
            return ((TipoDecisao) value).getIdTipoDecisao().toString();
        }
        return null;
    }

    private TipoDecisaoFacade lookupTipoDecisaoFacade() {
         Context context = null;
        try {
            context = new InitialContext();
            return (TipoDecisaoFacade) context.lookup("java:global/advocaciafenix/TipoDecisaoFacade");
        } catch (NamingException ne) {
            System.out.println("Erro" + ne.getMessage());
            return null;
        }
    }
    
}
