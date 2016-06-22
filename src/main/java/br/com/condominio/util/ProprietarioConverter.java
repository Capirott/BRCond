package br.com.condominio.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.condominio.model.Proprietario;
import br.com.condominio.service.ProprietarioService;

@Named
public class ProprietarioConverter implements Converter {
 
	@Inject
	private ProprietarioService proprietarioService;
	
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            return proprietarioService.consultarPorId(Long.valueOf(value));
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return ((Proprietario) object).getId().toString(); 
        }
        else {
            return null;
        }
    }   
}     
