/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBeans;

import client.AdminrestClient;
import ejb.AdminLocal;
import entities.*;
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
@ManagedBean(name = "cityCDI")
@SessionScoped
//@Named(value = "cityCDI")
@Dependent
public class cityCDI {

    AdminrestClient arc = new AdminrestClient();
    @EJB AdminLocal al;
    TblCity currentCity;

    public TblCity getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(TblCity currentCity) {
        this.currentCity = currentCity;
    }
    Response res;
    Collection<TblState> states;
    Collection<TblCity> cities;
    GenericType<Collection<TblState>> gStates = new GenericType<Collection<TblState>>(){
    };
    GenericType<Collection<TblCity>> gCities = new GenericType<Collection<TblCity>>(){
    };
    
    DateFormat df = new SimpleDateFormat("DD-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    
    Integer stateId, cityId;
    String cityName, cityCode;

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
    
    public Collection<TblState> getStates(){
        res =   arc.getAllStates(Response.class);
        states = res.readEntity(gStates);
        return states; 
    }
    
    public String addCity(){
        this.arc.insertCity(cityName, stateId.toString(), cityCode, datetime, datetime);
        cityName = "";
        cityCode = "";
        stateId = null;
        return "viewCities.xhtml?faces-redirect=true";
    }
    
    public Collection<TblCity> getCities(){
        res = arc.getAllCities(Response.class);
        cities = res.readEntity(gCities);
        return cities;
    }
    
    public String deleteCity(Integer cityId){
        this.arc.deleteCity(cityId.toString());
        return "viewCities.xhtml?faces-redirect=true";
    }
    
    public String redirectToEditCity(){
        return "updateCity.xhtml?faces-redirect=true";
    }
     
    public cityCDI() {
    }
    
    public String saveCity(){
        cityId = currentCity.getCityId();
        cityName = currentCity.getCityName();
        cityCode = currentCity.getCityCode();
        stateId = currentCity.getStateId().getStateId();
        
        this.arc.updateCity(cityId.toString(), cityName, stateId.toString(), cityCode, datetime);
        cityId = null;
        cityName = "";
        cityCode = "";
        stateId = null;
        
        return "viewCities.xhtml?faces-redirect=true";
    }
    
}
