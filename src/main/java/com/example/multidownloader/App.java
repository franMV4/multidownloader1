package com.example.multidownloader;

import com.example.multidownloader.util.R;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class App extends Application {

    @Override
    public void init() throws Exception {
        super.init();
    }
    private final Logger logger = Logger.getLogger(App.class.getName());
    FileHandler fh;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(R.getUI("multidownload.fxml"));
        loader.setController(new AppController());
        ScrollPane vbox = loader.load();

        Scene scene2 = new Scene(vbox);
        stage.setScene(scene2);
        stage.setTitle("Downloader");
        stage.show();


        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("C:/Users/franm/IdeaProjects/multidescarga/multidescargas.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            logger.info("El programa se ha iniciado");

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("Es logger no se ha podido iniciar");

        }
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}

