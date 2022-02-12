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
    Response res;
    Collection<TblState> states;
    GenericType<Collection<TblState>> gStates;
    DateFormat df = new SimpleDateFormat("DD-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    
    String stateName, stateCode;
    Integer uStateId ;
    
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
//        res =   arc.getAllStates(Response.class);
//        states = res.readEntity(gStates);
//        return states;
        return this.al.getAllStates();
    }
    
    public void viewId(){
        Integer row =  0,id=1;
        row = this.al.getAllStates().size();
        System.out.println(row);
    }
    
    public String addState(){
//        System.out.println(lastId);
//        System.out.println(stateName);
//        System.out.println(stateCode);
        this.al.insertState(6, stateName, stateCode, datetime, datetime);
        return "viewStates.xhtml";
    }
    
    public String deleteState(Integer stateId){
        this.al.deleteState(stateId);
        return "viewStates.xhtml";
    }
    
}
