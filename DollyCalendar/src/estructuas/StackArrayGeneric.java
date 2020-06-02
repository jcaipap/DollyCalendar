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
public class StackArrayGeneric<T> implements StackGeneric<T>{
	private static final int N = 3;
	private int top;
	private T[] sarray;

	// constructors

	public StackArrayGeneric() {
		this(N);
	}

	public StackArrayGeneric(int n) {
		top = 0;
		sarray = (T[]) new Object[n];
	}


	//ejemplo constructor de int: 
	//StackArrayGeneric<Integer> stack;
	//stack = new StackArrayGeneric <Integer> ();


	// value returning methods
        @Override
	public boolean empty() {
		return top <= 0;
	}

        @Override
	public boolean full() {
		return top >= sarray.length;
	}

        @Override
	public T pop() {
		if(empty())
                    throw new RuntimeException("Stack is empty");
		top--;
		return sarray[top];
	}

	// void method
        @Override
	public void push(T item) {
		if(full())
                    throw new RuntimeException("Stack is full");
		sarray[top]=item;
		top++;
	}
        
        @Override
        public T peek(){
            if(empty())
                throw new RuntimeException("Stack is empty");
            return sarray[top];
        }
        public boolean compareToTop(T item){ 
            if(empty())
                throw new RuntimeException("Stack is empty");
            return item==sarray[top];
        }
        public int getLenght() {
            return sarray.length;
        }
        
        @Override
        public int search(T item){
            if(empty())
                throw new RuntimeException("Stack is empty");
            int counter=0;
            if(item.equals(sarray[0])){
                return 1;
            }
            while (!item.equals(sarray[counter])&&counter<sarray.length){
                counter++;
            }
            if(counter==sarray.length){
                return -1;
            } 
            return counter+1;
        }
}
