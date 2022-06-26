package Car_owner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class car_owner extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("car_owner.fxml"));
        Image icon= new Image(getClass().getResourceAsStream("../images/car_register.jpg"));
        stage.getIcons().add(icon);
        Scene scene=new Scene(root);
        stage.setTitle("Car Owner Form");
        stage.setScene(scene);
        stage.show();
    }
}
