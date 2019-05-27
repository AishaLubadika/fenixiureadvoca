/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.converters;

import advocacia.fenix.ejbs.MunicipioFacade;
import advocacia.fenix.entities.Municipio;
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
@FacesConverter(value = "municipioConverter", forClass = Municipio.class)
public class MunicipioConverter implements Converter{
    
    MunicipioFacade municipioFacade = lookupMunicipioFacade();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
            Municipio municipio;
        if (value != null) {
            municipio = (Municipio)municipioFacade.find(Integer.parseInt(value));
            return municipio;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Municipio) value).getIdMunicipio().toString();
        }
        return null;
    }

    private MunicipioFacade lookupMunicipioFacade() {
         Context context = null;
        try {
            context = new InitialContext();
            return (MunicipioFacade) context.lookup("java:global/advocaciafenix/MunicipioFacade");
        } catch (NamingException ne) {
            System.out.println("Erro" + ne.getMessage());
            return null;
        }
    }
    
}
