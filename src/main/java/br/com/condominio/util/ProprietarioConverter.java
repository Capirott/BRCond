package br.com.condominio.util;
 
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
 
import br.com.condominio.model.Proprietario;
import br.com.condominio.service.ProprietarioService;;
 
@FacesConverter("proprietarioConverter")
public class ProprietarioConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                ProprietarioService service = (ProprietarioService) fc.getExternalContext().getApplicationMap().get("ProprietarioService");
                return service.listarTodos().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Proprietario."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Proprietario) object).getId());
        }
        else {
            return null;
        }
    }   
}  