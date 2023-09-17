package ytt.app.cpsc233demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ytt.app.cpsc233demo3.utilities   .InputReader;
import ytt.app.cpsc233demo3.videoTracking.Category;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * CPSC 233 W22 GROUP PROJECT
 *
 * @author Jason Ngu & Brian Tran
 * Date: April 01st 2022
 * Course: CPSC 233 W22
 * UCIDs (Jason Ngu: 30145770) & (Brian Tran: 30064686)
 * Instructor: Jonathan Hudson
 * TA: (Jason Ngu: Tejash Shrestha) & (Brian Tran: Abdelghani Guerbas)
 *
 * java description: the following is the Main.java used to launch the program and the GUI elements in the mainController
 */

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
        stage.setTitle("CPSC 233 W22 Project Youtube Tracker V1.0");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("youtube.png")));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * deals with commandline arg
     * @param args file name to preload into program
     */
    public static void main(String[] args) {
        MainController.args = args;
        if (args.length != 0) {
            System.out.println(MainController.launchArgs());
        }

        launch();

    }
}