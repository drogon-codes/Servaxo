/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBeans;

import client.AdminrestClient;
import ejb.AdminLocal;
import entities.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;


@Named(value = "partCDI")
@SessionScoped
public class partCDI implements Serializable {
    
    AdminrestClient arc = new AdminrestClient();
    @EJB AdminLocal al;
    Integer partId, modelId, partCategoryId, price;
    String partName, partDescription, fileName1, fileName2, fileName3, fileName4, isActive, videoURL;
    Part partImage1, partImage2, partImage3, partManual;
    TblParts currentPart;

    public TblParts getCurrentPart() {
        return currentPart;
    }

    public void setCurrentPart(TblParts currentPart) {
        this.currentPart = currentPart;
    }

    public Part getPartManual() {
        return partManual;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public void setPartManual(Part partManual) {
        this.partManual = partManual;
    }
    File savedFile1, savedFile2, savedFile3, savedFile4;

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getPartCategoryId() {
        return partCategoryId;
    }

    public void setPartCategoryId(Integer partCategoryId) {
        this.partCategoryId = partCategoryId;
    }
    
    DateFormat df = new SimpleDateFormat("DD-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    
    Response res;
    Collection<TblPartcategory> partCategories;
    Collection<TblModel> models;
    Collection<TblParts> parts;
    GenericType<Collection<TblPartcategory>> gPartCategories = new GenericType<Collection<TblPartcategory>>(){
    };
    GenericType<Collection<TblModel>> gModels = new GenericType<Collection<TblModel>>(){
    };
    GenericType<Collection<TblParts>> gParts = new GenericType<Collection<TblParts>>(){
    };

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public Part getPartImage1() {
        return partImage1;
    }

    public void setPartImage1(Part partImage1) {
        this.partImage1 = partImage1;
    }

    public Part getPartImage2() {
        return partImage2;
    }

    public void setPartImage2(Part partImage2) {
        this.partImage2 = partImage2;
    }

    public Part getPartImage3() {
        return partImage3;
    }

    public void setPartImage3(Part partImage3) {
        this.partImage3 = partImage3;
    }
    
    public partCDI() {
    }
    
    public Collection<TblModel> getModels(){
//        res =   arc.getAllModels(Response.class);
//        models = res.readEntity(gModels);
//        return models;
        return this.al.getAllModels();
    }
    
    public Collection<TblPartcategory> getPartCategories(){
//        res =   arc.getAllPartCategories(Response.class);
//        partCategories = res.readEntity(gPartCategories);
//        return partCategories; 
        return this.al.getAllPartCategories();
    }
    
    public void upload1(){
        fileName1 = Paths.get(partImage1.getSubmittedFileName()).getFileName().toString(); // MSIE fix.        
        savedFile1 = new File("C:\\Users\\c computer\\Documents\\NetBeansProjects\\Servaxo\\web\\uploads\\partImg", fileName1);

        try (InputStream input = partImage1.getInputStream()) {
            Files.copy(input, savedFile1.toPath());
        }
        catch (IOException e) {
            System.out.print(e);
        }
    }
    
    public void upload2(){
        fileName2 = Paths.get(partImage2.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        savedFile2 = new File("C:\\Users\\c computer\\Documents\\NetBeansProjects\\Servaxo\\web\\uploads\\partImg", fileName2);
        try (InputStream input = partImage2.getInputStream()) {
            Files.copy(input, savedFile2.toPath());
        }
        catch (IOException e) {
            System.out.print(e);
        }
    }
    
    public void upload3(){
        fileName3 = Paths.get(partImage3.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        savedFile3 = new File("C:\\Users\\c computer\\Documents\\NetBeansProjects\\Servaxo\\web\\uploads\\partImg", fileName3);
        try (InputStream input = partImage3.getInputStream()) {
            Files.copy(input, savedFile3.toPath());
        }
        catch (IOException e) {
            System.out.print(e);
        }
    }
    
    public void upload4(){
        fileName4 = Paths.get(partManual.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        savedFile4 = new File("C:\\Users\\c computer\\Documents\\NetBeansProjects\\Servaxo\\web\\uploads\\partMan", fileName4);
        try (InputStream input = partManual.getInputStream()) {
            Files.copy(input, savedFile4.toPath());
        }
        catch (IOException e) {
            System.out.print(e);
        }
    }
    public String insertPart(){
        isActive = "yes";        
//        arc.insertPart(modelId.toString(), partCategoryId.toString(), partName, price.toString(), partDescription, fileName1, fileName2, fileName3, fileName4, videoURL, isActive, datetime, datetime);
        al.insertPart(modelId, partCategoryId, partName, price, partDescription, fileName1, fileName2, fileName3, fileName4, videoURL, isActive, datetime, datetime);
        modelId = null;
        partCategoryId = null;
        partDescription = null;
        partImage1 = null;
        partImage2 = null;
        partImage3 = null;
        partManual = null;
        videoURL = "";
        return "viewParts.xhtml?faces-redirect=true";
    }
    
    public Collection<TblParts> allParts(){
//        res =   arc.getAllParts(Response.class);
//        parts = res.readEntity(gParts);
//        return parts; 
        return this.al.getAllParts();
    }
    
    public String deletePart(Integer partId){
        this.arc.deletePart(partId.toString());
        return "viewParts.xhtml?faces-redirect=true"; 
    }
    
    public String redirectToUpdatePart(){
        return "updatePart.xhtml?faces-redirect=true"; 
    }
    
    public String savePart(){
        partId = currentPart.getPartId();
        price = currentPart.getPrice();
        partName = currentPart.getPartName();
        modelId = currentPart.getModelId().getModelId();
        partCategoryId = currentPart.getPartcategoryId().getPartcategoryId();
        videoURL = currentPart.getVideoUrl();
        partDescription = currentPart.getPartDescription();
        isActive = currentPart.getIsactive();
        if(fileName1==null){
            fileName1 = currentPart.getImg1();
        }
        if(fileName2==null){
            fileName2 = currentPart.getImg2();
        }
        if(fileName3==null){
            fileName3 = currentPart.getImg3();
        }
        if(fileName4==null){
            fileName4 = currentPart.getPartManualPdf();
        }
//        this.arc.updatePart(partId.toString(), modelId.toString(), partCategoryId.toString(), partName, price.toString(), partDescription, fileName1, fileName2, fileName3, fileName4, videoURL, isActive, datetime);
        this.al.updatePart(partId, modelId, partCategoryId, partName, price, partDescription, fileName1, fileName2, fileName3, fileName4, videoURL, isActive, datetime);
        modelId = null;
        partName = "";
        partCategoryId = null;
        partDescription = "";
        partImage1 = null;
        partImage2 = null;
        partImage3 = null;
        partManual = null;
        videoURL = "";
        price = null;
        return "viewParts.xhtml?faces-redirect=true";
    }
    
//    public String updateActive(Integer partId){
//        String isActiveStatus = al.getIsActive(partId);
////        System.out.println(isActive);
//        if("no".equals(isActiveStatus)){
//            isActiveStatus="yes";
//        }
//        else if("yes".equals(isActiveStatus))
//        {
//            isActiveStatus="no";
//        }
//        else
//        {
//            isActiveStatus="sup";
//        }
//        this.al.updateActivePart(partId, isActiveStatus, datetime);
////        this.arc.updateActivePart(partId.toString(), isActiveStatus, datetime);
//        return "viewParts.xhtml?faces-redirect=true";
////        return isActive;
//    }
    
}
