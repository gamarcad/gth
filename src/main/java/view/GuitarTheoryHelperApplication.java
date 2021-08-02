package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class GuitarTheoryHelperApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // get the local defined by the user
        Locale locale = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("strings", locale);


        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"), bundle);
        root.getStylesheets().add("/global.css");
        primaryStage.setTitle("Guitar Theory Helper");
        primaryStage.getIcons().add(new Image("/gth-logo.png"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
