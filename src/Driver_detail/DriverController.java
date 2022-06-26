package Driver_detail;

import Accident_detail.Accident;
import Car_detail.car_detailDB;
import Car_owner.Car_ownerController;
import Car_owner.car_owner;
import Remove_car.remove;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Component;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import register_car.register;


public class DriverController implements Initializable {
    
    Connection con;
    ResultSet rs;
    PreparedStatement pst;

    @FXML
    private TextField txtname;
    @FXML
    private TextField txtlicense;
    @FXML
    private TextField txtaddress;
    @FXML
    private Button driverbutton;
    @FXML
    private Button carownerbutton;
    @FXML
    private Button accidentbutton;
    @FXML
    private Button registerbutton;
    @FXML
    private Button removebutton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void driverbuttonOnAction(ActionEvent event) {
        if(event.getSource()==driverbutton){
            
            String name =txtname.getText();
            String address =txtaddress.getText();
            String license =txtlicense.getText();
            
            try{
                Statement s =Car_ownerController.mycon().createStatement();
                s.executeUpdate("INSERT INTO driver_car (name,address,number_license)"
                   + "VALUES('"+name+"','"+address+"','"+license+"')");
                Component parentComponent = null;
                JOptionPane.showMessageDialog(parentComponent, "Your Driver Account have been Created ");
            }catch(Exception ex){
                System.out.println(ex);
            }
            
            txtname.setText("");
            txtaddress.setText("");
            txtlicense.setText("");
        }
    }

    @FXML
    private void carownerbuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new car_owner().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(DriverController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void accidentbuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new Accident().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(DriverController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void registerbuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new register().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(DriverController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removebuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new remove().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(DriverController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
