/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.*;

/**
 *
 * @author Estudiante
 */
interface LinearList<T> {
    public boolean isEmpty();
    public int size();
    public void checkIndex(int index);
    public T get(int index);
    public int indexOf(T theElement);
    public T remove(int index);
    public void add(int index, T theElement);
    
    public Iterator<T> iterator();
    
    
    
    
    
}
