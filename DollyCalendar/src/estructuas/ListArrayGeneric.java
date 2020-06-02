/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuas;

/**
 *
 * @author andre
 * @param <T>
 */
public class ListArrayGeneric<T extends Comparable<T>> {
    private final int N;
    private int position, count;
    private T[] lArray;
    T reference;
    
    //ListArrayGeneric<String> opTable= new ListArrayGeneric<String>();
    
    public ListArrayGeneric() {
            count=0;    
            N=20;
            lArray = (T[]) new Comparable[N];
    }

    public ListArrayGeneric(int n) {
            count=0;
            this.N = n;
            lArray = (T[]) new Comparable[N];
    }
    
    private boolean empty() {
        return count <= 0;
    }

    private boolean full() {
        return count>= N;
    }
    
    public boolean insert(T item) {
        boolean inserted=false;
        if(!full())
            if (!search(item)){
                for(int j=count; j>position; j--)
                    lArray[j] = lArray[j-1];
                lArray[position] = item;
                count++;
                inserted = true;
            }
            else;
        return inserted;
    }
    
    public boolean delete(T item) {
        boolean deleted=false;
        if(!empty())
            if(search(item)){
                for(int j=position; j<count-1; j++)
                    lArray[j] = lArray[j+1];
                count--;
                deleted = true;
         }
        else
        System.out.println("List is Empty");
    return deleted;
     }
    
    public boolean search(T item) {
        boolean found, stop;
        found = false;
        stop = false;
        position = 0;
        while(position != count && !stop)
            if(lArray[position].compareTo(item) >= 0){
                stop = true;
                if(lArray[position].compareTo(item) == 0)
                    found = true;
            }
        else
            position++;
    return found;
    }
    
    public void output() {
        System.out.print("List: ");
        int j = 0;
        while(j != count) {
            System.out.print(lArray[j]+" ");
            j++;
        }
        System.out.println();
    }
    
    public int size(){
        return count;
    }
    
    public T getItemInPosition(int position){
        return lArray[position];
    }
    
    public int compareTo(T item) {
        int result;
        if(reference.compareTo(item) > 0)
            result = 1;
        else
            if(reference.compareTo(item) < 0)
                result = -1;
            else
                result = 0;
    return result;
    }
    
    public void pushAt(T item,int pos) {
		lArray[pos]=item;
	}
    
} 


/**
 * *3. Write a method deleteAt that can be added to the ListArray class in
    Fig. 4.1 which removes the item at the specific position from the list. The
    method accepts a position as a parameter.
    * 
    4. Write a method positionOf that can be added to the ListArray class in
    Fig. 4.1 which returns the position of the specific item in the list. The method
    accepts an item as a parameter.
    * 
    5. Write a method search that performs a binary search and that can replace the
    existing search method in Fig. 4.1 ListArray class.
 * 
 */