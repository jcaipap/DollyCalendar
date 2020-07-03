/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuas;

import java.io.Serializable;

/**
 *
 * @author andre
 * @param <T>
 */
public class NodeGeneric<T> implements Serializable{
    T data;
    NodeGeneric<T> next;
    
    public NodeGeneric() {
        this(null);
    }
    
    public NodeGeneric(T data) {
        this.data = data;
        next = null;
    }

    public NodeGeneric(T data, NodeGeneric<T> next) {
        this.data = data;
        this.next = next;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public NodeGeneric getNext() {
        return next;
    }
    
    public void setNext(NodeGeneric<T> next) {
        this.next = next;
    }
}