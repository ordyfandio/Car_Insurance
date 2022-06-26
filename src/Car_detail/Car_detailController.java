package Car_detail;

import Accident_detail.Accident;
import Accident_report.ModelTable;
import Driver_detail.driver;
import Remove_car.remove;
import com.mysql.jdbc.Connection;
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
import register_car.register;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

public class Car_detailController implements Initializable {

    
    
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
    
    @FXML
    private TableView<car_detailDB> table;

    @FXML
    private TableColumn<car_detailDB, String> txtbrand;

    @FXML
    private TableColumn<car_detailDB, String> txtcolor;

    @FXML
    private TableColumn<car_detailDB, String> txtmatricule;

    @FXML
    private TableColumn<car_detailDB, String> txtyear;
    
    @FXML
    private TableColumn<car_detailDB, String> txtpolicy;
    @FXML
    private TableColumn<car_detailDB, String> txtowner;
    @FXML
    private TableColumn<car_detailDB, String> txtlicense;
    
    ObservableList<car_detailDB> oblist = FXCollections.observableArrayList();
    
    
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
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/assurance","root","");
            
            pst = (PreparedStatement) con.prepareStatement("SELECT * FROM register_cars ");
            rs = pst.executeQuery();
            while(rs.next()){
                oblist.add(new car_detailDB(rs.getString("matricule_nb"),rs.getString("color"), rs.getString("car_brand"), rs.getString("year"),rs.getString("policy_id"),rs.getString("owner_id"),rs.getString("driver_license")));
            }
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Car_detailController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Car_detailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtmatricule.setCellValueFactory(new PropertyValueFactory<>("txtmatricule"));
        txtcolor.setCellValueFactory(new PropertyValueFactory<>("txtcolor"));
        txtbrand.setCellValueFactory(new PropertyValueFactory<>("txtbrand"));
        txtyear.setCellValueFactory(new PropertyValueFactory<>("txtyear"));  
        txtpolicy.setCellValueFactory(new PropertyValueFactory<>("txtpolicy"));
        txtowner.setCellValueFactory(new PropertyValueFactory<>("txtowner"));
        txtlicense.setCellValueFactory(new PropertyValueFactory<>("txtlicense"));
        
        table.setItems(oblist);
    }    

   

    @FXML
    private void accidentbuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new Accident().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(Car_detailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void drivebuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new driver().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(Car_detailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void registerbuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new register().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(Car_detailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removebuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new remove().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(Car_detailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
