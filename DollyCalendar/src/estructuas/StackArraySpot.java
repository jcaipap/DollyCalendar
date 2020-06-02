/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuas;

import data.Casilla;

/**
 *
 * @author andre

 */
public class StackArraySpot  {
   
    private static final int N = 3;
	private int top;
	private Casilla[] sarray;

	// constructors

	public StackArraySpot() {
		this(N);
	}

	public StackArraySpot(int n) {
		top = 0;
		sarray = new Casilla[n];
	}


	public boolean empty() {
		return top <= 0;
	}

	public boolean full() {
		return top >= sarray.length;
	}


	public Casilla pop() {
		if(empty())
                    throw new RuntimeException("Stack is empty");
		top--;
		return sarray[top];
	}


	public void push(Casilla item) {
		if(full())
                    throw new RuntimeException("Stack is full");
		sarray[top]=item;
		top++;
	}
        

        public Casilla peek(){
            if(empty())
                throw new RuntimeException("Stack is empty");
            return sarray[top];
        }
        
        public boolean compareToTop(Casilla item){ 
            if(empty())
                throw new RuntimeException("Stack is empty");
            return item==sarray[top];
        }
        public int getLenght() {
            return sarray.length;
        }
        

        public int search(Casilla item){
            if(empty())
                throw new RuntimeException("Stack is empty");
            int counter=0;
            if(item.equalsName(sarray[0])){
                return 1;
            }
            while (!item.equalsName(sarray[counter])&&counter<sarray.length){
                counter++;
            }
            if(counter==sarray.length){
                return -1;
            } 
            return counter+1;
        }
    
    public Casilla getItemInPosition(int position){
        return sarray[position];
    }
    
    
    public void pushAt(Casilla item,int pos) {
		sarray[pos]=item;
	}

}
