/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import data.Archivo;
import estructuras.ArbolDecision;
import java.util.ArrayList;
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
    private ArbolDecision<String> arbol;
    
    private static final String DISENIOROOT = "-fx-background-color: rgba(219, 219, 219, 0.5);";
    private static final String DISENIOBOTONES = "-fx-font-type: Tahoma;-fx-font-size: 30;-fx-background-color:rgba(63, 127, 191, 0.4);"; 
    private static final String DISENIOLABEL = "-fx-font-type: Tahoma;-fx-font-size: 50;-fx-background-color:rgba(188, 188, 188, 0);"; 
    
    public VistaPartida(){
        arbol = crearArbol();
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
        pregunta.setText(arbol.getPregunta()); // aqui hay que sacar la prregunta que este en la raiz del arbol
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
                    arbol.bajar(true);
                    if(!arbol.isCurrentNull()){
                        pregunta.setText(arbol.getPregunta()); // se pone la pregunta que corresponda bajando en el arbol 
                    }
                }
        );
    }
    
    private void eventoNo(){
        no.setOnAction(
                e -> {
                    arbol.bajar(false);
                    if(!arbol.isCurrentNull()){
                        pregunta.setText(arbol.getPregunta()); // se pone la pregunta que corresponda bajando en el arbol 
                    }
                }
        );
    }
    
    /**
     * Crea el arbol de decision con las preguntas y respuestas del archivo datos
     * @return 
     */
    public static ArbolDecision<String> crearArbol(){
        ArbolDecision<String> arbol = new ArbolDecision<>();
        ArrayList<String> elementos = Archivo.elementosArbol();
        
        arbol.add(elementos.get(0).substring(3),null);
        
        for(int i=1;i<elementos.size();i++){
            
            boolean esPregunta = elementos.get(i).contains("#P");
            boolean anteriorEsPregunta = elementos.get(i-1).contains("#P");
            
            if(esPregunta){
                int j = 1;
                while(elementos.get(i-j).contains("#R") || arbol.nodeIsFull(elementos.get(i-j).substring(3))) 
                    j++;
                arbol.add(elementos.get(i).substring(3),elementos.get(i-j).substring(3));
            }else{
                if(anteriorEsPregunta)
                    arbol.add(elementos.get(i).substring(3), elementos.get(i-1).substring(3));
                else
                    arbol.add(elementos.get(i).substring(3), elementos.get(i-2).substring(3));
            }     
        }
        return arbol;
    }
    
}
