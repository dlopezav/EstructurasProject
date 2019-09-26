/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.util.*;
import java.util.function.Consumer;

/**
 *
 * @author Estudiante
 */
public class Chain<T> implements LinearList<T>, Iterable<T> {
    
    protected Node<T> firstNode;
    protected int size;

    public Chain() {
        this.firstNode = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;    
    }

    @Override
    public void checkIndex(int index) {
        if( index<0 || index >= size){
            throw new IndexOutOfBoundsException
                    ("index = "+ index +" size "+ size);
        }
    }

    @Override
    public T get(int index) {
        checkIndex(index); 
        Node<T> currentNode = firstNode;
        for(int i=0; i< index; i++)
            currentNode = currentNode.next;
            
        return currentNode.element;
    }

    @Override
    public int indexOf(T theElement) {
        Node<T> currentNode = firstNode;
        int index = 0;
        while( currentNode != null && !currentNode.element.equals(theElement)){
            currentNode = currentNode.next;
            index++;
        }
        if(currentNode == null){
            return -1;
        }else{
            return index;
        }
   
    }

    @Override
    public T remove(int index) {
        checkIndex(index); 
        
        T removedElement;
            if( index == 0){
            removedElement = firstNode.element;
            firstNode = firstNode.next;
            }else{
            Node<T> q = firstNode;
            for (int i = 0; i < index - 1; i++) 
                q = q.next;
            
            removedElement = q.next.element;
            q.next = q.next.next;
                
            }
            size--;
            return removedElement;
       }
        
    

    @Override
    public void add(int index, T theElement) {
        if( index<0 || index > size){
            throw new IndexOutOfBoundsException
                    ("index = "+ index +" size "+ size);
        }
        
        if(index == 0){
            firstNode = new Node<T>(theElement,firstNode);
        }else{
            Node<T> p = firstNode;
            for( int i = 0; i<index - 1; i++ )
                p = p.next;
            
            p.next = new Node<T>(theElement, p.next);
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder( "[" );
        
        for( T x: this)
            s.append(Objects.toString( x) + ", ");
        
        if( size > 0) 
            s.setLength(s.length( ) - 2);
        s.append( "]" );
        
        return new String( s );
    }

    
    @Override
    public Iterator<T> iterator() {
        return new ChainIterator ( );
    }
    
    public class ChainIterator implements Iterator<T>{
        private Node<T> nextNode;

        public ChainIterator() {
            nextNode = firstNode;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public T next() {
            if( nextNode  != null ){
                T elementToReturn = nextNode.element;
                nextNode = nextNode.next;
                return elementToReturn;
            }else{
                throw new NoSuchElementException(" No next element" );
            }

        }

        public void remove(){
            throw new UnsupportedOperationException( "remove not supported" );
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
   
    
    
    
}
