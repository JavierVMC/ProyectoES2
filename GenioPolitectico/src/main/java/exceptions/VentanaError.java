/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import data.Constants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author test1
 */
public class VentanaError {
    /**
     * Root de la clase VentanaError
     */
    private VBox root;
    private FileInputStream f;
    private static final String DISENIOLABEL = "-fx-font-size: 20;-fx-font-weight: bold;";
    /**
     * Constructor de la clase VentanaError
     * @param mensaje 
     */
    private VentanaError(String mensaje) {
        try {
            f = new FileInputStream(Constants.RESOURCE_IMAGES+ "/warning.png");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        Image adv = new Image(f, 50, 50, true, false);
        ImageView iv = new ImageView(adv);
        
        Label l = new Label(mensaje);
        l.setStyle(DISENIOLABEL);
        l.setTextFill(Color.RED);
        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(iv,l);
    }
    /**
     * Muestra una ventana con la excepcion producida
     * @param ex 
     */
    public static void mostrarError(Exception ex) {
        Stage serror = new Stage();
        VentanaError ve = new VentanaError(ex.getMessage());
        Scene error = new Scene(ve.getRoot(), 500, 150);
        serror.setScene(error);
        serror.setAlwaysOnTop(true);
        serror.show();
    }
    /**
     * Get del root de la clase VentanaError
     * @return 
     */
    public Pane getRoot() {
        return root;
    }
}
