package Insurance_policy;

import Accident_detail.Accident;
import Driver_detail.driver;
import Remove_car.remove;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Component;
import java.io.File;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import register_car.register;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class InsuranceController implements Initializable {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    @FXML
    private ImageView brandingImageView;
    @FXML
    private TextField txtname;
    @FXML
    private Button buttonInsurance;
    @FXML
    private Button accidentbutton;
    @FXML
    private Button drivebutton;
    @FXML
    private Button registerbutton;
    @FXML
    private Button removebutton;

   
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        File brandingFile = new File("@../images/assurance_car.png");
//        Image brandingImage = new Image(brandingFile.toURI().toString());
//        brandingImageView.setImage(brandingImage);
    }    
    
    public static Connection mycon(){
        Connection con = null ;
        try{
           
            Class.forName("com.mysql.jdbc.Driver");
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/assurance","root","");
;           
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        return con;
    }
    
    @FXML
    private void buttonInsuranceOnAction(ActionEvent event) {
        if(event.getSource()==buttonInsurance){
            String name =txtname.getText();
            
          
            try{
           Statement s =InsuranceController.mycon().createStatement();
           s.executeUpdate("INSERT INTO insurance (id,name)"
                   + "VALUES(id,'"+name+"')");
           Component parentComponent = null;
           JOptionPane.showMessageDialog(parentComponent, "Your Account Created");
           
           
            }
            catch(Exception ex){
               System.out.println(ex);
            }
            txtname.setText("");
        }
    }

    @FXML
    private void accidentbuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new Accident().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(InsuranceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void drivebuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new driver().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(InsuranceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void registerbuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new register().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(InsuranceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removebuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new remove().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(InsuranceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
