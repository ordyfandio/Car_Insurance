package Accident_detail;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Accident extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("accident.fxml"));
        Image icon= new Image(getClass().getResourceAsStream("../images/car_register.jpg"));
        stage.getIcons().add(icon);
        Scene scene=new Scene(root);
        stage.setTitle("Accident Detail Form");
        stage.setScene(scene);
        stage.show();
    }
}
