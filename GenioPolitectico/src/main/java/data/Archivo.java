/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import exceptions.VentanaError;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
}
