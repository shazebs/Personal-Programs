// Author: @shazebs
// Date:   12/9/20
// Time:   8:42 PM

package JavaFX_Sample_2;

// import libraries
//------------------
import javafx.application.Application;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javafx.scene.Cursor;

import javafx.stage.Modality;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import javafx.scene.image.ImageView;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javafx.scene.control.Hyperlink;


//------------------------------------------------------
public class LoginTemplate extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // Hyperlinks
        Hyperlink githubLink = new Hyperlink("https://github.com/shazebs/Personal-Programs");



        // Account Screen Window
        //-----------------------
        Stage accountWindow = new Stage();
        accountWindow.setTitle("Account Screen");
        accountWindow.centerOnScreen();

        VBox accountRoot = new VBox();
        Image spaceImage = new Image("https://cdn.mos.cms.futurecdn.net/zKupvCf2pYuDfW5K4ZQwAF.jpg");
        ImageView accountScreenImage = new ImageView(spaceImage);

        accountRoot.getChildren().addAll(accountScreenImage);

        Scene accountScene = new Scene(accountRoot);
        accountWindow.setScene(accountScene);

        accountWindow.setHeight(950);
        accountWindow.setWidth(1600);

        accountWindow.show();



        // Login Screen Window (Modality)
        //--------------------------------
        Stage loginWindow = new Stage();
        loginWindow.setTitle("Login Screen");

        // set window margins
        loginWindow.setWidth(400);
        loginWindow.setHeight(400);

        // set window x-y screen position
        loginWindow.setX(100);
        loginWindow.setY(100);
        // loginWindow.centerOnScreen();

        // Modality *
        loginWindow.initModality(Modality.WINDOW_MODAL);
        loginWindow.initOwner(accountWindow);

        // Set Window Style
        loginWindow.initStyle(StageStyle.DECORATED);

        // root node
        VBox loginRoot = new VBox(); // parent node

        Image sampleImage1 = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZVXlfUUcbDcxSd14ziEA2tK_kwVxU_wpSRg&usqp=CAU");

        // Place an image in the Login Screen Window
        ImageView loginScreenImage = new ImageView(sampleImage1);

        // Create some label controls
        // Label usernameLabel = new Label("Username"); // child node 1
        // usernameLabel.setTextFill(Color.web("#4263f5"));
        // usernameLabel.setFont(new Font("Arial", 25));
        Hyperlink usernameLink = new Hyperlink("Username");
        usernameLink.setTextFill(Color.web("#4263f5"));
        usernameLink.setFont(new Font("Arial", 25));

        usernameLink.setOnAction(e -> {
           usernameLink.setText("This feature is not yet available");
        });


        Label passwordLabel = new Label("Password"); // child node 2
        passwordLabel.setTextFill(Color.web("#4263f5"));
        passwordLabel.setFont(new Font("Arial", 25));

        Label forgotPasswordLabel = new Label("Forgot Password?"); // child node 3
        forgotPasswordLabel.setFont(new Font(16));


        // Label signUpLabel = new Label("Sign Up"); // child node 4
        // signUpLabel.setFont(new Font(16));
        Hyperlink signUpLink = new Hyperlink("Sign Up");

        signUpLink.setOnAction(e -> {
           signUpLink.setText("This feature is not yet available!");
        });

        loginRoot.getChildren().addAll(loginScreenImage, usernameLink, passwordLabel, forgotPasswordLabel, signUpLink);


        // Create a Scene for the Login Screen Window
        Scene loginScene = new Scene(loginRoot);
        loginScene.setCursor(Cursor.HAND);


        loginWindow.setScene(loginScene);

        loginWindow.show();





    } // End of 'start' method




    //-------------------------------------------------------
    public static void main(String[] args) { launch(args); }

}


