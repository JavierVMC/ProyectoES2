/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 *
 * @author test1
 */
public class VentanaAviso {
    /**
     * Root de la clase VentanaAviso
     */
    private HBox root;
    /**
     * Diseño aplicado a los labels de la clase VentanaAviso
     */
    private static final String DISENIOLABEL = "-fx-font-size: 20;-fx-font-weight: bold;";
    
    /**
     * Constructor de la clase VentanaAviso
     * @param mensaje
     * @param color 
     */
    private VentanaAviso(String mensaje, Paint color) {
        
        Label l = new Label(mensaje);
        l.setStyle(DISENIOLABEL);
        l.setTextFill(color);
        root = new HBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(l);
    }
    /**
     * Muestra una ventana con el titulo, el mensaje y el color de letra pasados como parametros
     * @param titulo
     * @param mensaje
     * @param color 
     */
    public static void mostrarAviso(String titulo, String mensaje, Paint color) {
        
        Stage sAviso = new Stage();
        sAviso.setTitle(titulo);
        VentanaAviso va = new VentanaAviso(mensaje,color);
        Scene aviso = new Scene(va.getRoot(), 500, 150);
        sAviso.setScene(aviso);
        sAviso.setAlwaysOnTop(true);
        sAviso.show();
    }
    /**
     * Get del root de la clase VentanaAviso
     * @return 
     */
    public Pane getRoot() {
        return root;
    }
}
