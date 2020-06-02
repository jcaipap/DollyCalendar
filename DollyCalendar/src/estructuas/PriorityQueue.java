/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuas;

/**
 *
 * @author JAndres
 */
import java.util.NoSuchElementException;
public class PriorityQueue<T extends Comparable<T>> {
    private T[] innerArray;
    private int size;
    public PriorityQueue() {
        this.innerArray = (T[]) new Comparable[10];
        size = 0;
    }
    public void enqueue(T item) {
        if (size == 0) {
            size++;
            innerArray[0] = item;
            return;
        }
        if (size() == innerArray.length)
            doubleArray();
        T temp = item;
        for (int i = 0; i < size; i++) {        
            if (item.compareTo(innerArray[i]) <= 0) {
                T next;
                temp = innerArray[i];
                innerArray[i] = item;
                while (i < size - 1) {
                    next = innerArray[i + 1];
                    innerArray[i + 1] = temp;
                    temp = next;
                    i++;
                }
                break;
            }
        }
        innerArray[size] = temp;
        size++;
    }
    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("The queue is empty");
        T retValue = innerArray[0];
        for (int i = 1; i < size; i++) {
            innerArray[i - 1] = innerArray[i];
        }
        innerArray[size - 1] = null;
        size--;
        return retValue;
    }
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException("The queue is empty");
        return innerArray[0];
    }
    public boolean contains(int item) {
        if (isEmpty())
            return false;
        for (int i = 0; i < size; i++) {
            if (innerArray[i].equals(item))
                return true;
        }
        return false;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    private void doubleArray() {
        T[] newArr =(T[]) new Comparable[innerArray.length * 2];
        for(int i = 0; i < innerArray.length; i++) {
            newArr[i] = innerArray[i];
        }
        innerArray = newArr;
    }
}
