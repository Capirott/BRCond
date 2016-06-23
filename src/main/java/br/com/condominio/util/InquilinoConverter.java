package br.com.condominio.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.condominio.model.Inquilino;
import br.com.condominio.service.InquilinoService;

@Named
public class InquilinoConverter implements Converter {
 
	@Inject
	private InquilinoService condominioService;
	
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
            return ((Inquilino) object).getId().toString(); 
        }
        else {
            return null;
        }
    }   
}     
