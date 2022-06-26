package Remove_car;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class remove extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("remove.fxml"));
        Image icon= new Image(getClass().getResourceAsStream("../images/car_register.jpg"));
        stage.getIcons().add(icon);
        Scene scene=new Scene(root);
        stage.setTitle("Remove Car Form");
        stage.setScene(scene);
        stage.show();
    }
 
}
