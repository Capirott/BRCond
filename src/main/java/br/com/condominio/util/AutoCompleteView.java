package br.com.condominio.util;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.SelectEvent;

import br.com.condominio.model.Proprietario;
import br.com.condominio.service.ProprietarioService;
 
@ManagedBean
public class AutoCompleteView {
     
    private String txt1;
    private String txt2;
    private String txt3;
    private String txt4;
    private String txt5;
    private String txt6;
    private String txt7;
    private String txt8;
    private Proprietario proprietario1;
    private Proprietario proprietario2;
    private Proprietario proprietario3;
    private Proprietario proprietario4;
    private List<Proprietario> selectedProprietarios;
     
    @ManagedProperty("#{proprietarioService}")
    private ProprietarioService service;
     
    public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            results.add(query + i);
        }
         
        return results;
    }
     
    public List<Proprietario> completeProprietario(String query) {
        List<Proprietario> allProprietarios = service.listarTodos();
        List<Proprietario> filteredProprietarios = new ArrayList<Proprietario>();
         
        for (int i = 0; i < allProprietarios.size(); i++) {
            Proprietario skin = allProprietarios.get(i);
            if(skin.getNome().toLowerCase().contains(query)) {
                filteredProprietarios.add(skin);
            }
        }
         
        return filteredProprietarios;
    }
     
    public void onItemSelect(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
    }
 
    public String getTxt1() {
        return txt1;
    }
 
    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }
 
    public String getTxt2() {
        return txt2;
    }
 
    public void setTxt2(String txt2) {
        this.txt2 = txt2;
    }
 
    public String getTxt3() {
        return txt3;
    }
 
    public void setTxt3(String txt3) {
        this.txt3 = txt3;
    }
 
    public String getTxt4() {
        return txt4;
    }
 
    public void setTxt4(String txt4) {
        this.txt4 = txt4;
    }
 
    public String getTxt5() {
        return txt5;
    }
 
    public void setTxt5(String txt5) {
        this.txt5 = txt5;
    }
 
    public String getTxt6() {
        return txt6;
    }
 
    public void setTxt6(String txt6) {
        this.txt6 = txt6;
    }
 
    public String getTxt7() {
        return txt7;
    }
 
    public void setTxt7(String txt7) {
        this.txt7 = txt7;
    }
 
    public String getTxt8() {
        return txt8;
    }
 
    public void setTxt8(String txt8) {
        this.txt8 = txt8;
    }
 
    public Proprietario getProprietario1() {
        return proprietario1;
    }
 
    public void setProprietario1(Proprietario proprietario1) {
        this.proprietario1 = proprietario1;
    }
 
    public Proprietario getProprietario2() {
        return proprietario2;
    }
 
    public void setProprietario2(Proprietario proprietario2) {
        this.proprietario2 = proprietario2;
    }
 
    public Proprietario getProprietario3() {
        return proprietario3;
    }
 
    public void setProprietario3(Proprietario proprietario3) {
        this.proprietario3 = proprietario3;
    }
 
    public Proprietario getProprietario4() {
        return proprietario4;
    }
 
    public void setProprietario4(Proprietario proprietario4) {
        this.proprietario4 = proprietario4;
    }
 
    public List<Proprietario> getSelectedProprietarios() {
        return selectedProprietarios;
    }
 
    public void setSelectedProprietarios(List<Proprietario> selectedProprietarios) {
        this.selectedProprietarios = selectedProprietarios;
    }
     
    public void setService(ProprietarioService service) {
        this.service = service;
    }
}