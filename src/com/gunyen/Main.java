package com.gunyen;
/*
configuration -> add vm option -> paste: --module-path ${PATH_TO_FX} --add-modules javafx.fxml,javafx.controls,javafx.graphics
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/VaperNodeCalculaterScreen.fxml"));
        stage.setTitle("Vapor Nodes - Daily Compounding Calculator");
        stage.setScene(new Scene(root));
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
