/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBeans;

import client.AdminrestClient;
import ejb.AdminLocal;
import entities.TblState;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author c computer
 */
//@Named(value = "stateCDI")
@ManagedBean(name = "stateCDI")
@SessionScoped
@Dependent
public class stateCDI {

    AdminrestClient arc = new AdminrestClient();
    @EJB AdminLocal al;
    TblState currentState;

    public TblState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(TblState currentState) {
        this.currentState = currentState;
    }
    
    Response res;
    Collection<TblState> states;
    GenericType<Collection<TblState>> gStates = new GenericType<Collection<TblState>>(){
    };
    
    DateFormat df = new SimpleDateFormat("DD-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    
    String stateName, stateCode;
    Integer stateId ;

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }
    
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
    
    public stateCDI() {
    }
    
    public Collection<TblState> viewStates(){
        res =   arc.getAllStates(Response.class);
        states = res.readEntity(gStates);
        return states;
//        return this.al.getAllStates();
    }
    
    public void viewId(){
        Integer row =  0,id=1;
        row = this.al.getAllStates().size();
        System.out.println(row);
    }
    
    public String addState(){
//        this.al.insertState(stateName, stateCode, datetime, datetime);
        this.arc.insertState(stateName, stateCode, datetime, datetime);
        stateName = null;
        stateCode = null;
        return "viewStates.xhtml?faces-redirect=true";
    }
    
    public String deleteState(Integer stateId){
//        this.al.deleteState(stateId);
        this.arc.deleteState(stateId.toString());
        return "viewStates.xhtml?faces-redirect=true";
    }
    
    public String redirectToEditState(){
        return "updateState.xhtml?faces-redirect=true";
    }
    
    public String saveState(){
        stateName = currentState.getStateName();
        stateCode = currentState.getStateCode();
        stateId = currentState.getStateId();
        
        this.arc.updateState(stateId.toString(), stateName, stateCode, datetime);
        
        stateName = null;
        stateCode = null;
        stateId = null;
        return "viewStates.xhtml?faces-redirect=true";
    }
}
