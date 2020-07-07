
package estructuas;
import java.io.Serializable;
import java.util.Arrays;
/**
 *
 * @author andre
 * @param <T>
 */
public class DynamicArray <T extends Comparable<T>> implements Serializable{
    private T[] array;
    private int size;
    private int capacity;
     
    public DynamicArray(){
        array = (T[]) new   Comparable[2];
        size=0;
        capacity=2;
    }
     
    public void additem(T item){
        if (size == capacity){
            ensureCapacity(2); 
        }
        array[size] = item;
        size++;
    }
     
    public void additem(int index, T item){
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
    public void setitem(int index, T item){
        array[index]=item;
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

    public void ensureCapacity(int minCapacity){
        T[] temp = (T[]) new Comparable [capacity*minCapacity];
        for (int i=0; i < capacity; i++){
            temp[i] = array[i];
        }
        array = temp;
        capacity = capacity * minCapacity;
    }
     
    public void trimToSize(){
//        System.out.println("Trimming the array");
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

    public void printitems(){
        System.out.println("items in array are :"+Arrays.toString(array));
    }
}
