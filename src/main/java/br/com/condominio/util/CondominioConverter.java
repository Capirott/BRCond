package br.com.condominio.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.condominio.model.Condominio;
import br.com.condominio.service.CondominioService;

@Named
public class CondominioConverter implements Converter {
 
	@Inject
	private CondominioService condominioService;
	
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            return condominioService.consultarPorId(Long.valueOf(value));
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return ((Condominio) object).getId().toString(); 
        }
        else {
            return null;
        }
    }   
}     
