/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import data.Archivo;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author test1
 */
public class VistaPartida {
    private HBox root;
    private VBox preguntas;
    private Button si;
    private Button no;
    private Label pregunta;
    
    private static final String DISENIOROOT = "-fx-background-color: rgba(219, 219, 219, 0.5);";
    private static final String DISENIOBOTONES = "-fx-font-type: Tahoma;-fx-font-size: 30;-fx-background-color:rgba(63, 127, 191, 0.4);"; 
    private static final String DISENIOLABEL = "-fx-font-type: Tahoma;-fx-font-size: 50;-fx-background-color:rgba(188, 188, 188, 0);"; 
    
    public VistaPartida(){
        root = new HBox();
        disenioRoot();
        preguntas = new VBox();
        disenioPreguntas();
        agregarImagenGenio();
        crearLabel();
        crearBotones();
        root.getChildren().add(preguntas);
        eventos();
    }
    
    private void agregarImagenGenio(){
        root.getChildren().add(Archivo.getGenioPolitecnico(700,600));
    }
    
    private void crearBotones(){
        si = new Button("Si");
        no = new Button("No");
        disenioBotones();
        preguntas.getChildren().addAll(si,no);
    }
    
    private void disenioBotones(){
        si.setMinSize(300, 80);
        si.setStyle(DISENIOBOTONES);
        
        no.setMinSize(300, 80);
        no.setStyle(DISENIOBOTONES);
    }
    
    private void disenioRoot(){
        root.setMinSize(1280, 720);
        root.setAlignment(Pos.CENTER);
        root.setStyle(DISENIOROOT);
        root.setSpacing(30);
    }
    
    private void disenioPreguntas(){
        preguntas.setAlignment(Pos.CENTER);
        preguntas.setSpacing(30);
        preguntas.setStyle(DISENIOROOT);
        preguntas.setMinWidth(800);
    }
    
    private void crearLabel(){
        pregunta = new Label();
        pregunta.setText("Escoge si o no"); // aqui hay que sacar la prregunta que este en la raiz del arbol
        pregunta.setAlignment(Pos.CENTER);
        pregunta.setTextAlignment(TextAlignment.CENTER);
        pregunta.setMaxWidth(700);
        pregunta.setWrapText(true);
        pregunta.setStyle(DISENIOLABEL);
        
        preguntas.getChildren().add(pregunta);
    }
    
    public void setPregunta(String p){
        pregunta.setText(p);
    }
    
    public Pane getRoot(){
        return root;
    }
    
    
    private void eventos(){
        eventoSi();
        eventoNo();
    }
    
    
    
    
    private void eventoSi(){
        si.setOnAction(
                e -> {
                    pregunta.setText("pregunta si respondo que si"); // se pone la pregunta que corresponda bajando en el arbol 
                }
        );
    }
    
    private void eventoNo(){
        no.setOnAction(
                e -> {
                    pregunta.setText("pregunta si respondo que no"); // se pone la pregunta que corresponda bajando en el arbol 
                }
        );
    }
    
}
