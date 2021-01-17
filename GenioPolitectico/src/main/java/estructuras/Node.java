/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

/**
 *
 * @author test1
 * @param <String>
 */
public class Node<String> {
    private String pregunta;
    private Node<String> left;
    private Node<String> right;
    
    
    public Node(String pregunta){
        this.pregunta = pregunta;
    }

    public String getPregunta() {
        return pregunta;
    }
    
    
    
    
}
