/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuas;
import java.util.Arrays;
/**
 *
 * @author andre
 * @param <T>
 */
public class DynamicArray <T extends Comparable<T>>{
private T[] array;
    private int size;
    private int capacity;
     
    public DynamicArray(){
        array = (T[]) new   Comparable[2];
        size=0;
        capacity=2;
    }
     
    public void additem(T item){
        // double the capacity if all the allocated space is utilized
        if (size == capacity){
            ensureCapacity(2); 
        }
        array[size] = item;
        size++;
    }
     
    public void additem(int index, T item){
        // double the capacity if all the allocated space is utilized
        if (size == capacity){
            ensureCapacity(2); 
        }
        for(int i=size-1;i>=index;i--){
            array[i+1] = array[i];
        }
        array[index] = item;
        size++;
    }
 
    public T getitem(int index){
        return array[index];
    }
     

    public void remove(int index){
        if(index>=size || index<0){
            System.out.println("No item at this index");
        }else{
            for(int i=index;i<size-1;i++){
                array[i] = array[i+1];
            }
            array[size-1]=null;
            size--;
        }
    }
     
    /* method to increase the capacity, if necessary, to ensure it can hold at least the 
    *  number of items specified by minimum capacity arguement
    */
    public void ensureCapacity(int minCapacity){
        T[] temp = (T[]) new Comparable [capacity*minCapacity];
        for (int i=0; i < capacity; i++){
            temp[i] = array[i];
        }
        array = temp;
        capacity = capacity * minCapacity;
    }
     
    /*
    *  Trim the capacity of dynamic array to the current size. i.e. remove unused space
    */
    public void trimToSize(){
        System.out.println("Trimming the array");
	T[] temp = (T[]) new Comparable [size];
        for (int i=0; i < size; i++){
            temp[i] = array[i];
        }
        array = temp;
        capacity = array.length;
         
    }
     
    public int size(){
        return size;
    }
     

    public int capacity(){
        return capacity;
    }
     
    // method to print items in array
    public void printitems(){
        System.out.println("items in array are :"+Arrays.toString(array));
    }
}
