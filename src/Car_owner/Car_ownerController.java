package Car_owner;

import Accident_detail.Accident;
import Car_detail.car_detailDB;
import Driver_detail.driver;
import Insurance_policy.InsuranceController;
import Remove_car.remove;
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
import javafx.stage.Stage;
import register_car.register;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class Car_ownerController implements Initializable {
    
    Connection con;
    ResultSet rs;
    PreparedStatement pst;

    @FXML
    private Button carownerbutton;
    @FXML
    private Button accidentbutton;
    @FXML
    private Button registerbutton;
    @FXML
    private Button drivebutton;
    @FXML
    private Button removebutton;
    @FXML
    private TextField txtaddress;
    @FXML
    private TextField txtname;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
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
    private void carownerbuttonOnAction(ActionEvent event) throws SQLException {
        if(event.getSource()==carownerbutton){
            
            String name =txtname.getText();
            String address =txtaddress.getText();
            
            if(name.equals("") && address.equals("")){
                JOptionPane.showMessageDialog(null,"Your Name and Your address are Blancks !");
            }else{
                
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/assurance","root","");
                    
                    pst = (PreparedStatement) con.prepareStatement("SELECT * FROM driver_car WHERE name=? and address=?");
                    pst.setString(1,name);
                    pst.setString(2,address);
                    rs = pst.executeQuery();
                    if(rs.next()){
                   JOptionPane.showMessageDialog(null,"This Owner is already in the Database !");
                   }else{
                        JOptionPane.showMessageDialog(null,"This Owner is not in the Database!");   
                    }
                    txtname.setText("");
                    txtaddress.setText("");
                }catch(ClassNotFoundException ex){
                    Logger.getLogger(Car_ownerController.class.getName()).log(Level.SEVERE, null, ex);
                }catch (SQLException ex) {
                   Logger.getLogger(Car_ownerController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Car_ownerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void registerbuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new register().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(Car_ownerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void drivebuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new driver().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(Car_ownerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removebuttonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new remove().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(Car_ownerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
