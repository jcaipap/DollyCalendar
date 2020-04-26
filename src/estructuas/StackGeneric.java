/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuas;

/**
 *
 * @author JAndres
 * @param <T>
 */
public interface StackGeneric<T> {
    boolean empty();
    boolean full();
    T pop();
    void push(T item);
    T peek();
    int search(T item);
}
