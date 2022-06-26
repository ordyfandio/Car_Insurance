package Accident_report;

import Accident_detail.Accident;
import Driver_detail.driver;
import Remove_car.remove;
import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import register_car.register;


public class Accident_reController implements Initializable {
    Connection con;
    ResultSet rs;
    PreparedStatement pst;

    @FXML
    private Button accidentbutton;
    @FXML
    private Button drivebutton;
    @FXML
    private Button registerbutton;
    @FXML
    private Button removebutton;

    
    public static Connection mycon(){
        Connection con = null ;
        try{
           
            Class.forName("com.mysql.jdbc.Driver");
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/assurance","root","");
;           
        }
        catch(Exception ex){
        }
        
        return con;
    }
    @FXML
    private TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable, String> txtreport;
    @FXML
    private TableColumn<ModelTable, String> txtmatricule;
    @FXML
    private TableColumn<ModelTable, String> txtlocation;
    @FXML
    private TableColumn<ModelTable, String> txtdate;
    @FXML
    private TableColumn<ModelTable, String> txttime; 
    
    ObservableList<ModelTable> oblist = FXCollections.observableArrayList(); 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/assurance","root","");
            
            pst = (PreparedStatement) con.prepareStatement("SELECT * FROM accident");
            rs = pst.executeQuery();
            while(rs.next()){
                oblist.add(new ModelTable(rs.getString("matricule_nb"),rs.getString("report_id"), rs.getString("location_accident"), rs.getString("date_accident"), rs.getString("time_accident")));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Accident_reController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Accident_reController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        txtreport.setCellValueFactory(new PropertyValueFactory<>("txtreport"));
        txtmatricule.setCellValueFactory(new PropertyValueFactory<>("txtmatricule"));
        txtlocation.setCellValueFactory(new PropertyValueFactory<>("txtlocation"));
        txtdate.setCellValueFactory(new PropertyValueFactory<>("txtdate"));
        txttime.setCellValueFactory(new PropertyValueFactory<>("txttime"));  
        
        table.setItems(oblist);
    }    

    @FXML
    private void accidentbuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new Accident().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(Accident_reController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void drivebuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new driver().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(Accident_reController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void registerbuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new register().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(Accident_reController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removebuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new remove().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(Accident_reController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
