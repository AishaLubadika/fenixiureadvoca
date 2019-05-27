/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.converters;

import advocacia.fenix.ejbs.ProcessoFacade;
import advocacia.fenix.entities.Processo;
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
@FacesConverter(value = "processoConverter", forClass = Processo.class)
public class ProcessoConverter implements Converter{
     ProcessoFacade processoFacade= lookupProcessoFacade();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Processo processo;
        if (value != null) {
            processo = (Processo)processoFacade.find(Integer.parseInt(value));
            return processo;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Processo) value).getIdProcesso().toString();
        }
        return null;
    }

    private ProcessoFacade lookupProcessoFacade() {
          Context context = null;
        try {
            context = new InitialContext();
            return (ProcessoFacade) context.lookup("java:global/advocaciafenix/ProcessoFacade");
        } catch (NamingException ne) {
            System.out.println("Erro" + ne.getMessage());
            return null;
        }
    }
    
}
