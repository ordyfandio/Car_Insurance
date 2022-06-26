package Accident_detail;

import Accident_report.Accident_reController;
import Accident_report.accident_re;
import Car_detail.car_detailDB;
import Driver_detail.driver;
import Insurance_policy.InsuranceController;
import Remove_car.remove;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Component;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import register_car.register;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class AccidentController implements Initializable {
    Connection con;
    ResultSet rs;
    PreparedStatement pst;
    
    
    @FXML
    private Button accidentbutton;
    @FXML
    private Button reportbutton;
    @FXML
    private Button drivebutton;
    @FXML
    private Button registerbutton;
    @FXML
    private Button removebutton;
    @FXML
    private TextField txtdate;

    @FXML
    private TextField txtlocation;

    @FXML
    private TextField txtmatricule;

    @FXML
    private TextField txtreport;

    @FXML
    private TextField txttime;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accidentbuttonOnAction(ActionEvent event) {
        if(event.getSource()==accidentbutton){
            String matricule =txtmatricule.getText();
            String report =txtreport.getText();
            String time =txttime.getText();
            String location =txtlocation.getText();
            String date =txtdate.getText();
            
            try{
                Statement s =Accident_reController.mycon().createStatement();
                s.executeUpdate("INSERT INTO accident (matricule_nb,report_id,location_accident,date_accident,time_accident)"
                   + "VALUES('"+matricule+"','"+report+"','"+location+"','"+date+"','"+time+"')");
                 Component parentComponent = null;
                 JOptionPane.showMessageDialog(parentComponent, "Your Accident detail have been submited ");
            }catch(Exception ex){
                System.out.println(ex);
            }
            
             txtmatricule.setText("");
             txtreport.setText("");
             txtlocation.setText("");
             txtdate.setText("");
             txtmatricule.setText("");
             txttime.setText("");
        }
    }

    @FXML
    private void reportbuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new accident_re().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(AccidentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void drivebuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new driver().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(AccidentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void registerbuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new register().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(AccidentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removebuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new remove().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(AccidentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
