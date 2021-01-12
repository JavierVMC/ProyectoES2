/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import data.Archivo;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author test1
 */
public class VistaMenuInicial {
    private VBox root;
    private Button jugar;
    private Button salir;
    
    private static final String DISENIOROOT = "-fx-background-color: rgba(219, 219, 219, 0.5);";
    private static final String DISENIOBOTONES = "-fx-font-type: Tahoma;-fx-font-size: 30;-fx-background-color:rgba(63, 127, 191, 0.4);"; 
    
    
    public VistaMenuInicial() {
        root = new VBox();
        disenioRoot();
        
        crearTitulo();
        cargarImagenGenio();
        crearBotones();
        eventos();
    }
    
    
    private void crearTitulo(){
        Text titulo = new Text("Genio Politecnico");
        HBox h = new HBox();
        h.setAlignment(Pos.TOP_CENTER);
        h.setSpacing(100);
        titulo.setFill(Color.BLACK);
        titulo.setStroke(Color.BLACK);
        titulo.setStrokeWidth(1);
        titulo.setFont(new Font("Tahoma",80));
        
        h.getChildren().add(titulo);
        root.getChildren().add(h);
    }
    
    private void crearBotones(){
        jugar = new Button("Jugar");
        salir = new Button("Salir");
        disenioBotones();
        root.getChildren().addAll(jugar,salir);
    }
    
    private void disenioBotones(){
        jugar.setMinSize(300, 100);
        jugar.setStyle(DISENIOBOTONES);
        
        salir.setMinSize(300, 20);
        salir.setStyle(DISENIOBOTONES);
    }
    
    private void cargarImagenGenio(){
        root.getChildren().add(Archivo.getGenioPolitecnico());
    }
    
    private void disenioRoot(){
        root.setAlignment(Pos.CENTER);
        root.setStyle(DISENIOROOT);
        root.setSpacing(30);
    }
    
    
    public Pane getRoot(){
        return root;
    }
    
    private void eventos(){
        eventoSalir();
        eventoJugar();
    }
    
    
    
    
    private void eventoSalir(){
        salir.setOnAction(
                e -> {
                    Stage st = (Stage) salir.getScene().getWindow();
                    st.close();
                }
        );
    }
    
    private void eventoJugar(){
        jugar.setOnAction(
                e -> {
                }
        );
    }
}
