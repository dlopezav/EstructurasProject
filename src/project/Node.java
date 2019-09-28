package project;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class Node <T> implements Serializable{
    T element;
    Node<T> next;
    
    public Node(){
        this(null,null);
    };

    public Node(T element){
        this.element = element;
        this.next = null;
        
    };
    
    public Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    };
}
