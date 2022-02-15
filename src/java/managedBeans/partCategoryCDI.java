/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBeans;

import client.AdminrestClient;
import ejb.AdminLocal;
import entities.TblPartcategory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;


//@Named(value = "partCategoryCDI")
@ManagedBean(name = "partCategoryCDI")
@SessionScoped
@Dependent
public class partCategoryCDI {

    @EJB AdminLocal al;
    AdminrestClient arc = new AdminrestClient();
    
    Integer partCategoryId;
    String categoryName, vehicleType, categoryDescription, fileName;
    Part categoryImage;
    File savedFile;
    
    DateFormat df = new SimpleDateFormat("DD-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    
    Response res;
    Collection<TblPartcategory> partCategories;
    GenericType<Collection<TblPartcategory>> gPartCategories = new GenericType<Collection<TblPartcategory>>(){
    };
    TblPartcategory currentPartCategory;
    
    public Part getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(Part categoryImage) {
        this.categoryImage = categoryImage;
    }

    public Integer getPartCategoryId() {
        return partCategoryId;
    }

    public void setPartCategoryId(Integer partCategoryId) {
        this.partCategoryId = partCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public TblPartcategory getCurrentPartCategory() {
        return currentPartCategory;
    }

    public void setCurrentPartCategory(TblPartcategory currentPartCategory) {
        this.currentPartCategory = currentPartCategory;
    }
    
    public void upload(){
        fileName = Paths.get(categoryImage.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
//        String extension = FilenameUtils.getExtension(categoryName);
//        String fileName = random() + "." + extension;
        savedFile = new File("C:\\Users\\c computer\\Documents\\NetBeansProjects\\Servaxo\\web\\uploads\\partCatImg", fileName);

        try (InputStream input = categoryImage.getInputStream()) {
            Files.copy(input, savedFile.toPath());
        }
        catch (IOException e) {
            System.out.print(e);
        }
    }
    public String addPartCategory(){
//        System.out.println(categoryName);
//        System.out.println(vehicleType);
//        System.out.println(fileName);
//        System.out.println(categoryDescription);
        arc.insertPartCategory(categoryName, vehicleType, fileName, categoryDescription, datetime, datetime);
        categoryName = "";
        vehicleType = "";
        categoryImage = null;
        categoryDescription = "";
        
        return "viewPartCategory.xhtml?faces-redirect=true";
        
    }
    
    public Collection<TblPartcategory> allPartCategory(){
//        res = arc.getAllPartCategories(Response.class);
//        partCategories = res.readEntity(gPartCategories);
//        return partCategories;

        return this.al.getAllPartCategories();
    }
    
    public String deletePartCategory(Integer partCategoryId){
        this.arc.deletePartCategory(partCategoryId.toString());
        return "viewPartCategory.xhtml?faces-redirect=true";
    }
    public partCategoryCDI() {
    }
    
}
