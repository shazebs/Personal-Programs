// Author: @shazebs
// Date:   12/23/20
// Time:   12:30 PM

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PaycheckCalculator extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("PaycheckCalculator.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Pay Calculator");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
