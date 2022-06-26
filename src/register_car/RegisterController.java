package register_car;

import Accident_detail.Accident;
import Car_detail.Car_detailController;
import Car_detail.car_detail;
import Car_detail.car_detailDB;
import Driver_detail.driver;
import Remove_car.remove;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Component;
import java.io.File;
import java.net.URL;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class RegisterController implements Initializable {
    Connection con;
    ResultSet rs;
    PreparedStatement pst;

    @FXML
    private ImageView brandingImageView;
    @FXML
    private Button buttonRegister;
    @FXML
    private Button accidentbutton;
    @FXML
    private Button carbutton;
    @FXML
    private Button drivebutton;
    @FXML
    private Button removebutton;
    @FXML
    private TextField txtmatricule;
    @FXML
    private TextField txtowner;
    @FXML
    private TextField txtbrand;
    @FXML
    private TextField txtcolor;
    @FXML
    private TextField txtlicense;
    @FXML
    private TextField txtpolicy;
    @FXML
    private TextField txtyear;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        File brandingFile = new File("@../images/logo-d-assurance-auto.jpg");
//        Image brandingImage = new Image(brandingFile.toURI().toString());
//        brandingImageView.setImage(brandingImage);
    }    

    @FXML
    private void buttonRegisterOnAction(ActionEvent event) {
        if(event.getSource()==buttonRegister){
            
            String matricule =txtmatricule.getText();
            String owner =txtowner.getText();
            String brand =txtbrand.getText();
            String color =txtcolor.getText();
            String license =txtlicense.getText();
            String policy =txtpolicy.getText();
            String year =txtyear.getText();
            
            
            try{
                Statement s =Car_detailController.mycon().createStatement();
                s.executeUpdate("INSERT INTO register_cars (matricule_nb,owner_id,driver_license,policy_id,year,color,car_brand)"
                   + "VALUES('"+matricule+"','"+owner+"','"+license+"','"+policy+"','"+year+"','"+color+"','"+brand+"')");
                Component parentComponent = null;
           JOptionPane.showMessageDialog(parentComponent, "Your Car have been register ");
            }catch(Exception ex){
                System.out.println(ex);
            }
            
            txtmatricule.setText("");
            txtowner.setText("");
            txtbrand.setText("");
            txtcolor.setText("");
            txtlicense.setText("");
            txtpolicy.setText("");
            txtyear.setText("");
        }
    }

    @FXML
    private void accidentbuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new Accident().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void carOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new car_detail().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void drivebuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new driver().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removebuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new remove().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
