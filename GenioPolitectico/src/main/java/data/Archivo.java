/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import exceptions.VentanaError;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author test1
 */
public class Archivo {
    /**
     * Ruta del archivo que contiene los elementos del arbol en pre-orden
     */
    private static final String RUTA_DATA = Constants.RESOURCE_TXT+"/datos.txt";
    /**
     * Ruta de la imagen del genioPolitecnico
     */
    private static final String RUTA_IMAGENGENIO = Constants.RESOURCE_IMAGES+"/genio.png";
    
    /**
     * Retorna un ImageView con la imagen del genioPolitecnico
     * @return 
     */
    public static ImageView getGenioPolitecnico(int alto, int ancho){
        try{
            FileInputStream fi = new FileInputStream(RUTA_IMAGENGENIO);
            return new ImageView(new Image(fi,alto,ancho,true,true));
        } catch (FileNotFoundException ex) {
            VentanaError.mostrarError(ex);
        }
        return null;
    }
    
    /**
     * Retorna un ArrayList con las lineas del archivo datos.txt
     * @return 
     */
    public static ArrayList<String> elementosArbol(){
        ArrayList<String> lista = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(RUTA_DATA))){
            String linea;
            while((linea = br.readLine())!=null){
                lista.add(linea);
            }
        } catch (FileNotFoundException ex) {
            VentanaError.mostrarError(ex);
        } catch (IOException ex) {
            VentanaError.mostrarError(ex);
        }
        
        return lista;
    }
}
