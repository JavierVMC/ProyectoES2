/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

/**
 *
 * @author test1
 */
public class ArbolDecision<E> {
    private Node<E> previousNode; //referencia al nodo anterior en el que estaba el usuario
    private Node<E> currentNode; //referencia al nodo en el que esta el usuario
    private Node<E> root; // referencia a la raiz
    
    private class Node<E>{
        private final E data;
        private Node<E> left; // referencia al hijo izquierdo
        private Node<E> right;// referencia al hijo derecho
        
        public Node(E data){
            this.data = data;
        }
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public boolean add(E child, E parent){
        Node<E> nchild = new Node<>(child);
        if(isEmpty() && parent==null){
            root = nchild;
            currentNode = root;
            return true;
        }
        // add(B,A)
        Node<E> np = searchNode(parent);
        Node<E> nce = searchNode(child);
        if(nce==null && np!=null){
           if(np.left == null){
               np.left = nchild;
               return true;
           }
           else if(np.right == null){
               np.right = nchild;
               return true;
           }
        }
        return false;
    }
    
    public boolean nodeIsFull(E data){
        Node<E> nodo = searchNode(data);
        return nodo.left!=null && nodo.right!=null;
    }
    
    
    private Node<E> searchNode(E data){
        return searchNode(data,root);
    }
    
    private Node<E> searchNode(E data, Node<E> p){
        if(p==null)
            return p;
        else if(p.data.equals(data))
            return p;
        else{
            Node<E> rl = searchNode(data,p.left);
            if(rl!=null) return rl;
            return searchNode(data,p.right);
        }
        
    }
    
    private Node<E> searchParent(E data){
        return searchParent(data,root);
    }
    
    private Node<E> searchParent(E data, Node<E> n){
        if(n==null) return n;
        else if((n.left!=null && n.left.data.equals(data)) 
                || (n.right!=null && n.right.data.equals(data)))
            return n;
        else{
            Node<E> nl = searchParent(data,n.left);
            if(nl != null) return nl;
            return searchParent(data,n.right);
        }         
    }
    
    
    public void bajar(boolean respuesta){
        if(currentNode!=null){
            if(respuesta){
                Node<E> tmp = currentNode;
                currentNode = currentNode.left;  
                previousNode = tmp;
            }
            else{
                Node<E> tmp = currentNode;
                currentNode = currentNode.right;
                previousNode = tmp;
            }
        }
    }
    
    
    public E getPregunta(){
        return currentNode.data;
    }
    
    public boolean isCurrentNull(){
        return currentNode==null;
    }
    
    public void agregarNuevoNodo(E pregunta, E animal, boolean respuesta){
        Node<E> nuevoNodoPregunta = new Node(pregunta);
        Node<E> nuevoNodoRespuesta = new Node(animal);
        if(previousNode.left == currentNode){
            if(respuesta){
                previousNode.left = nuevoNodoPregunta;
                nuevoNodoPregunta.right = currentNode;
                nuevoNodoPregunta.left = nuevoNodoRespuesta;
            }
            else{
                previousNode.left = nuevoNodoPregunta;
                nuevoNodoPregunta.left = currentNode;
                nuevoNodoPregunta.right = nuevoNodoRespuesta;
            }
        }
        else if(previousNode.right == currentNode){
            if(respuesta){
                previousNode.right = nuevoNodoPregunta;
                nuevoNodoPregunta.right = currentNode;
                nuevoNodoPregunta.left = nuevoNodoRespuesta;
            }
            else{
                previousNode.right = nuevoNodoPregunta;
                nuevoNodoPregunta.left = currentNode;
                nuevoNodoPregunta.right = nuevoNodoRespuesta;
            }
        }
    }
    
    
    public void preOrden(){
        preOrden(root);
    }
    
    private void preOrden(Node<E> p){
        if(p!=null){
            System.out.print(p.data + " ");
            preOrden(p.left);
            preOrden(p.right);
        }
    }
    
    
}
