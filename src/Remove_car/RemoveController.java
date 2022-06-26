package Remove_car;

import Accident_detail.Accident;
import Car_detail.car_detailDB;
import Driver_detail.driver;
import Insurance_policy.InsuranceController;
import Insurance_policy.insurance;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.table.TableModel;
import register_car.register;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class RemoveController implements Initializable {
    Connection con;
    ResultSet rs;
    PreparedStatement pst;

    @FXML
    private Button removebutton;
    @FXML
    private Button accidentbutton;
    @FXML
    private Button drivebutton;
    @FXML
    private Button registerbutton;
    @FXML
    private Button buttonInsurance;

    @FXML
    private TextField txtmatricule;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    @FXML
    private void removebuttonOnAction(ActionEvent event) {
       
        if(event.getSource()==removebutton){
            
            String matricule =txtmatricule.getText();
          
//            String license =txtlicense.getText();
            
            
            if(matricule.equals("")){
                JOptionPane.showMessageDialog(null,"Your Matricule is Blancks !");
            }else{
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/assurance","root","");
                    
                    pst = (PreparedStatement) con.prepareStatement("DELETE FROM register_cars WHERE matricule_nb=?");
                    pst.setString(1,matricule);

                    pst.executeUpdate();
//                    if(rs.next()){
//                   JOptionPane.showMessageDialog(null,"Delete Successful!");
//                   }else{
//                   JOptionPane.showMessageDialog(null,"Delete Failed !");
//                  }
                    txtmatricule.setText("");
                }catch (ClassNotFoundException ex){
                    Logger.getLogger(RemoveController.class.getName()).log(Level.SEVERE, null, ex);
                }catch (SQLException ex) {
                   Logger.getLogger(RemoveController.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        }
              
    }

    @FXML
    private void accidentbuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new Accident().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(RemoveController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void drivebuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new driver().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(RemoveController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void registerbuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new register().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(RemoveController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void buttonInsuranceOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new insurance().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(RemoveController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
