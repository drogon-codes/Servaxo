package servlets;

import entities.TblCompany;
import entities.TblModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ejb.AdminLocal;
import entities.TblCity;
import entities.TblFeedback;
import entities.TblPartcategory;
import entities.TblParts;
import entities.TblServices;
import entities.TblState;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;


@WebServlet(name = "Servlet1", urlPatterns = {"/Servlet1"})
public class Servlet1 extends HttpServlet {
@EJB AdminLocal tbl;

Currency curr = Currency.getInstance("INR");
String symbol = curr.getSymbol();
DateFormat df = new SimpleDateFormat("DD-MM-YYYY HH:mm:ss");
Date today = Calendar.getInstance().getTime();
String datetime = df.format(today);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//            tbl.insertcompany(5, "kia", "car", datetime, datetime);
//            tbl.deletecompany(5);
//            tbl.updateCompany(5, "Kia", "https://bit.ly/3nKc3Dv", "car", datetime);
            
//            Collection<TblCompany> companies = tbl.getAllCompanies();
//            Collection<TblCompany> companies = tbl.getCompaniesById(3);
//            Collection<TblCompany> companies = tbl.getCompaniesByName("suzuki");
//            Collection<TblCompany> companies = tbl.getCompaniesByType("car");
            
            //tbl.insertModel(1, "gixxer", 1, "https://bit.ly/3tuz4ha", datetime, datetime);
            //tbl.updateModel(1, "Gixxer", 1, "https://bit.ly/3tuz4ha", datetime);
            //tbl.deleteModel(2);
            
            //Collection<TblModel> models = tbl.getAllModels();
            //Collection<TblModel> models = tbl.getModelsById(1);
            //Collection<TblModel> models = tbl.getModelsByName("gixxer");
            //Collection<TblModel> models = tbl.getModelsByCompany(0);
            
            //Collection<TblPartcategory> categories = tbl.getAllPartCategories();
            //Collection<TblPartcategory> categories = tbl.getPartCategoriesById(1);
            //Collection<TblPartcategory> categories = tbl.getPartCategoriesByName("tyres");
            //Collection<TblPartcategory> categories = tbl.getPartCategoriesByType("bike");
            
            //tbl.insertPartCategory(1, "Tyres", "bike", "https://bit.ly/3KnrhrJ", "Tyres for bikes", datetime, datetime);
            //tbl.updatePartCategory(1, "Tyres", "Bike", "https://bit.ly/3KnrhrJ", "Tyres for bikes", datetime);
            //tbl.deletePartCategory(3);
            
            //Collection<TblParts> parts = tbl.getAllParts();
            //Collection<TblParts> parts = tbl.getPartsById(1);
            //Collection<TblParts> parts = tbl.getPartsByName("alpha s1");
            //Collection<TblParts> parts = tbl.getPartsByModel("Gixxer");
            //Collection<TblParts> parts = tbl.getPartsByCategory("Tyres");
            
            //tbl.insertPart(1, 1, 1, "Actizip F5", 1825, "Actizip F5 front tyre by Apollo tyres for suzuki gixxer", "https://bit.ly/3tS3Cdd", null, null, null, null, "YES", datetime, datetime);
            //tbl.updatePart(1, 1, 1, "actizip f5", 1825, "Actizip F5 front tyre by Apollo tyres for suzuki gixxer", "https://bit.ly/3tS3Cdd", null, null, null, null, "YES", datetime);
            //tbl.updateActivePart(1, "NO", datetime);
            //tbl.deletePart(3);
            
            //Collection<TblServices> services = tbl.getAllServices();
            //Collection<TblServices> services = tbl.getAllServicesById(1);
            //Collection<TblServices> services = tbl.getAllServicesByName("Car Interior Spa");
            //Collection<TblServices> services = tbl.getAllServicesByType("Car");
            
            //tbl.insertService(1, "Car Interior Spa", "Car Wash, Interior Vacuum Cleaning, Interior Wet Shampooing and Detailing, Anti Viral and Bacterial Treatment", 1799, "YES", "Car", datetime, datetime);
            //tbl.updateService(1, "Car Interior Spa", "Car Wash, Interior Vacuum Cleaning, Interior Wet Shampooing and Detailing, Anti Viral and Bacterial Treatment", 1799, "YES", "Car", datetime);
            //tbl.updateActiveService(1, "NO", datetime);
            //tbl.deleteService(2);
            
            //Collection<TblFeedback> feedbacks = tbl.getAllFeedbacks();
            //Collection<TblFeedback> feedbacks = tbl.getFeedbacksById(1);
            //Collection<TblFeedback> feedbacks = tbl.getFeedbacksByName("Vivek Maniyar");
            //Collection<TblFeedback> feedbacks = tbl.getFeedbacksByContactNo("9601128501");
            //Collection<TblFeedback> feedbacks = tbl.getFeedbacksByEmail("vivekmaniyar9601@gmail.com");
            
            //tbl.insertState(2, "Maharashtra", "MH", datetime, datetime);
            //tbl.updateState(1, "Gujarat", "GJ", datetime);
            //tbl.deleteState(2);
            
            //Collection<TblState> states = tbl.getAllStates();
            //Collection<TblState> states = tbl.getStatesById(1);
            //Collection<TblState> states = tbl.getStatesByName("Gujarat");
            //Collection<TblState> states = tbl.getStatesByCode("GJ");
            
            //tbl.insertCity(2, "Ahmedabad", 1, "GJ01", datetime, datetime);
            //tbl.updateCity(1, "Surat", 1, "GJ05", datetime);
            //tbl.deleteCity(2);
            
            //Collection<TblCity> cities = tbl.getAllCities();
            //Collection<TblCity> cities = tbl.getCitiesById(1);
            //Collection<TblCity> cities = tbl.getCitiesByState("Gujarat");
            //Collection<TblCity> cities = tbl.getCitiesByName("Surat");
            //Collection<TblCity> cities = tbl.getCitiesByCode("GJ05");
            
            out.println("<h1>Servlet Servlet1 at " + request.getContextPath() + "</h1>");
            
//<editor-fold defaultstate="collapsed" desc="companies">
//            for(TblCompany company : companies){
//                out.println("Company Name: " + company.getCompanyName() + "<br/>");
//                out.println("Company Type: " + company.getCompanyType() + "<br/><br/>");
//            }
//</editor-fold>
              
//<editor-fold defaultstate="collapsed" desc="Models">
//            for(TblModel model: models){
//                out.println("Model Name: " + model.getModelName() + "<br/>");
//            }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Part categories">
//              for(TblPartcategory category: categories){
//                  out.println("Category Name: " + category.getCategoryName() + "<br/>");
//                  out.println("Vehicle type: " + category.getVehicleType() + "<br/><br/>");
//              }
//</editor-fold>
            
//<editor-fold defaultstate="collapsed" desc="parts">
//                for(TblParts part: parts){
//                    out.println("Part Name: " + part.getPartName() + "<br/>");
//                    out.println("Description: " + part.getPartDescription() + "<br/>");
//                    out.println("Price: " + symbol + part.getPrice() + "<br/>");
//                    out.println("Available?: " + part.getIsactive() + "<br/><br/>");
//                }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="services">
//                for(TblServices service: services){
//                    out.println("Service Name: " + service.getServiceName() + "<br/>");
//                    out.println("Service Description: " + service.getServiceDescription() + "<br/>");
//                    out.println("Service Price: " + symbol + service.getServicePrice() + "<br/>");
//                    out.println("Available?: " + service.getIsactive() + "<br/><br/>");
//                }
//</editor-fold>
                
//<editor-fold defaultstate="collapsed" desc="feedbacks">
//                for(TblFeedback feedback: feedbacks){
//                    out.println("Name: " + feedback.getName() + "<br/>");
//                    out.println("Contact no: " + feedback.getContactNo() + "<br/>");
//                    out.println("E-mail ID: " + feedback.getEmail() + "<br/>");
//                    out.println("Feedback: " + "'" + feedback.getFeedbackText() + "'" + "<br/><br/>");
//                }
//</editor-fold>
        
//<editor-fold defaultstate="collapsed" desc="states">
//                for(TblState state: states){
//                    out.println("State Name: " + state.getStateName() + "<br/>");
//                    out.println("State Code: " + state.getStateCode() + "<br/><br/>");
//                }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="cities">
//                for(TblCity city: cities){
//                    out.println("City Name: " + city.getCityName() + "<br/>");
//                    out.println("City Code: " + city.getCityCode() + "<br/><br/>");
//                }
//</editor-fold>


        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
