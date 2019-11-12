/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Hp
 */
    public  class AvlNode{
        Persona element;      // The data in the node
        AvlNode  left;         // Left child
        AvlNode right;        // Right child
        int height;       // Height
        
        AvlNode( Persona theElement ){
            this( theElement, null, null );
        }

        AvlNode( Persona theElement, AvlNode lt, AvlNode rt ){
            element  = theElement;
            left     = lt;
            right    = rt;
            height   = 0;
        }
        
        public long getCC(){
            return element.getCedula();
        }
        public Persona getPer(){
            return element;
        }
        
    }
