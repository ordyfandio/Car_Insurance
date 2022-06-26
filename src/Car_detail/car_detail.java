package Car_detail;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class car_detail extends Application{
    public static void main(String[] args) {
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Car_detail.fxml"));
        Image icon= new Image(getClass().getResourceAsStream("../images/car_register.jpg"));
        stage.getIcons().add(icon);
        Scene scene=new Scene(root);
        stage.setTitle("Car details Form");
        stage.setScene(scene);
        stage.show();
    }
}
