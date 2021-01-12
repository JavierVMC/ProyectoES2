/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.geniopolitectico;

import vistas.VistaMenuInicial;
import data.Constants;
import exceptions.VentanaError;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author test1
 */
public class App  extends Application{
    
    public void start(Stage stage) {
        VistaMenuInicial vmi;
        try {
            vmi = new VistaMenuInicial();
            Scene principal = new Scene(vmi.getRoot(),800,720);
            stage.setScene(principal);
            stage.setTitle("Genio Politecnico");
            stage.setResizable(false);
            Image icono =  new Image(new FileInputStream(Constants.RESOURCE_IMAGES+"/logoEspol.png"));
            stage.getIcons().add(icono);
            stage.show();
        } catch (FileNotFoundException ex) {
            VentanaError.mostrarError(ex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
