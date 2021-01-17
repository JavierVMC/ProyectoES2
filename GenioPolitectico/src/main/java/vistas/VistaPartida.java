/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import data.Archivo;
import estructuras.ArbolDecision;
import exceptions.VentanaAviso;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

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
    
    private Button jugarDenuevo;
    private Button salir;
    
    private TextField animal;
    private TextField preguntaParaAnimal;
    private ToggleGroup group;
    private String ultimaRespuesta;
    private RadioButton rb1;
    private RadioButton rb2;
    private Button enviar;
    
    
    private static final String DISENIOROOT = "-fx-background-color: rgba(219, 219, 219, 0.5);";
    private static final String DISENIOBOTONES = "-fx-font-type: Tahoma;-fx-font-size: 30;-fx-background-color:rgba(63, 127, 191, 0.4);"; 
    private static final String DISENIOLABEL = "-fx-font-type: Tahoma;-fx-font-size: 50;-fx-background-color:rgba(188, 188, 188, 0);"; 
    private static final String DISENIOLABELFORMULARIO = "-fx-font-type: Tahoma;-fx-font-size: 30;-fx-background-color:rgba(188, 188, 188, 0);"; 
    
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
    
    /**
     * Crea los botones usados en vistaPartida
     */
    private void crearBotones(){
        si = new Button("Si");
        no = new Button("No");
        jugarDenuevo = new Button("Volver a jugar");
        salir = new Button("Salir");
        enviar = new Button("Enviar");
        disenioBotones();
        preguntas.getChildren().addAll(si,no);
    }
    
    /**
     * Crea el Label donde apareceran las preguntas del arbol
     */
    private void crearLabel(){
        pregunta = new Label();
        pregunta.setText(arbol.getPregunta());
        aplicarEstiloLabel(pregunta);
        preguntas.getChildren().add(pregunta);
    }
    
    /**
     * Crea los TextFields que se usaran en caso de agregar un nuevo elemento al arbol
     */
    private void crearTextField(){
        animal = new TextField();
        preguntaParaAnimal = new TextField();
        aplicarEstiloTextField(animal);
        aplicarEstiloTextField(preguntaParaAnimal);
    }
    
    /**
     * Crea los radioButtons que se usaran en caso de agregar un nuevo elemento al arbol
     */
    private void crearRButtons(){
        group = new ToggleGroup(); 

        rb1 = new RadioButton("Si"); 
        rb1.setUserData("Si"); 
        rb1.setToggleGroup(group); 

        rb2 = new RadioButton("No"); 
        rb2.setUserData("No"); 
        rb2.setToggleGroup(group); 
    }
    
    /**
     * Carga la imagen del genioPolitecnico
     */
    private void agregarImagenGenio(){
        root.getChildren().add(Archivo.getGenioPolitecnico(700,600));
    }
    
    /**
     * Aplica estilos sobre los botones en vistaPartida
     */
    private void disenioBotones(){
        si.setMinSize(300, 80);
        si.setStyle(DISENIOBOTONES);
        
        no.setMinSize(300, 80);
        no.setStyle(DISENIOBOTONES);
        
        jugarDenuevo.setMinSize(300, 80);
        jugarDenuevo.setStyle(DISENIOBOTONES);
        
        salir.setMinSize(300, 80);
        salir.setStyle(DISENIOBOTONES);
        
        enviar.setMinSize(300, 80);
        enviar.setStyle(DISENIOBOTONES);
    }
    
    /**
     * Aplica estilo al root
     */
    private void disenioRoot(){
        root.setMinSize(1280, 720);
        root.setAlignment(Pos.CENTER);
        root.setStyle(DISENIOROOT);
        root.setSpacing(30);
    }
    
    /**
     * Aplica estilo a la seccion de preguntas y respuestas en VistaPartida
     */
    private void disenioPreguntas(){
        preguntas.setAlignment(Pos.CENTER);
        preguntas.setSpacing(30);
        preguntas.setStyle(DISENIOROOT);
        preguntas.setMinWidth(800);
    }
    
    /**
     * Aplica estilos al Label pasado como parametro
     * @param l 
     */
    private void aplicarEstiloLabel(Label l){
        l.setAlignment(Pos.CENTER);
        l.setTextAlignment(TextAlignment.CENTER);
        l.setMaxWidth(700);
        l.setWrapText(true);
        l.setStyle(DISENIOLABEL);
    }
    /**
     * Aplica estilos de formulario al Label pasado como parametro
     * @param l 
     */
    private void aplicarEstiloLabelFORMULARIO(Label l){
        l.setAlignment(Pos.CENTER);
        l.setTextAlignment(TextAlignment.CENTER);
        l.setMaxWidth(700);
        l.setWrapText(true);
        l.setStyle(DISENIOLABELFORMULARIO);
    }
    
    /**
     * Aplica estilos de formulario al TextField pasado como parametro
     * @param tf 
     */
    private void aplicarEstiloTextField(TextField tf){
        tf.setPrefHeight(30);
        tf.setMaxWidth(600);
    }
    
    /**
     * Retorna el nodo raiz de vistaPartida
     * @return 
     */
    public Pane getRoot(){
        return root;
    }
    
    /**
     * Contiene la llamada a todos los eventos dentro de vistaPartida
     */
    private void eventos(){
        eventoSi();
        eventoNo();
        eventoJugarDenuevo();
        eventoSalir();
        eventoEnviar();
    }
    
    
    
    /**
     * Evento de click en el boton 'Si'
     */
    private void eventoSi(){
        si.setOnAction(
                e -> {
                    if(!arbol.isCurrentLeave()){
                        arbol.bajar(true);
                        if(!arbol.isCurrentNull()){
                            ultimaRespuesta = arbol.getPregunta();
                            pregunta.setText(ultimaRespuesta);
                        }
                    }else{
                        pregunta.setText("Lo he adivinado!\nQue desea hacer ahora?");
                        preguntas.getChildren().remove(si);
                        preguntas.getChildren().remove(no);
                        preguntas.getChildren().addAll(jugarDenuevo,salir);
                    }
                }
        );
    }
    
    /**
     * Evento de click en el boton 'No'
     */
    private void eventoNo(){
        no.setOnAction(
                e -> {
                    if(!arbol.isCurrentLeave()){
                        arbol.bajar(false);
                        if(!arbol.isCurrentNull()){
                            ultimaRespuesta = arbol.getPregunta();
                            pregunta.setText(ultimaRespuesta);
                        }
                    }else{
                        crearTextField();
                        preguntas.setSpacing(10);
                        preguntas.getChildren().remove(si);
                        preguntas.getChildren().remove(no);
                        pregunta.setText("Oh no! No pude adivinar!\nAyudame a mejorar mi prediccion!");
                        Label p1 = new Label("Que animal estabas pensando?");
                        aplicarEstiloLabelFORMULARIO(p1);
                        aplicarEstiloTextField(animal);
                        Label p2 = new Label("Escribe una pregunta que me permita diferenciar entre el animal que estabas pensando y "+ultimaRespuesta);
                        aplicarEstiloLabelFORMULARIO(p2);
                        aplicarEstiloTextField(preguntaParaAnimal);
                        Label p3 = new Label("Para el animal en que estabas pensando la respuesta a la pregunta que ingresaste, es si o no?");
                        aplicarEstiloLabelFORMULARIO(p3);
                        
                        crearRButtons();
                        preguntas.getChildren().addAll(p1,animal,p2,preguntaParaAnimal,p3,rb1,rb2,enviar);
                        
                    }
                }
        );
    }
    
    /**
     * Evento de click en el boton 'Volver a jugar'
     */
    private void eventoJugarDenuevo(){
        jugarDenuevo.setOnAction(
                e -> {
                    Stage s = (Stage) salir.getScene().getWindow();
                    s.close();
                    VistaPartida vp = new VistaPartida();
                    Stage st = new Stage();
                    Scene sc = new Scene(vp.getRoot(), 1280, 720);
                    st.setScene(sc);
                    st.setTitle("Genio Politecnico - Partida");
                    st.show();
                }
        
        );
    }
    
    /**
     * Evento de click en el boton 'Salir'
     */
    private void eventoSalir(){
        salir.setOnAction(
                e -> {
                    Stage st = (Stage) salir.getScene().getWindow();
                    st.close();
                }
        
        );
    }
    
    /**
     * Evento de click en el boton 'Enviar'
     */
    private void eventoEnviar(){
        enviar.setOnAction(
                e -> {
                    if(!animal.getText().isBlank() && !preguntaParaAnimal.getText().isBlank() && group.getSelectedToggle()!=null){
                        agregarElementoAlArbol(preguntaParaAnimal.getText(),animal.getText(),group.getSelectedToggle().getUserData().toString());
                        Archivo.guardarArbol(arbol.crearListaArbol());
                        preguntas.getChildren().clear();
                        pregunta.setText("Gracias por tu contribucion!");
                        preguntas.getChildren().addAll(pregunta,salir);
                    }else{
                        VentanaAviso.mostrarAviso("Advertencia","Todos los campos son obligatorios.",Color.RED);
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
    
    /**
     * Agrega un nuevo elemento al arbol de decision
     * @param pregunta
     * @param animal
     * @param respuesta 
     */
    private void agregarElementoAlArbol(String pregunta, String animal, String respuesta){
        if(respuesta.equalsIgnoreCase("si"))
            arbol.agregarNuevoNodo(pregunta, animal, true);
        else
            arbol.agregarNuevoNodo(pregunta, animal, false);
    }
}
