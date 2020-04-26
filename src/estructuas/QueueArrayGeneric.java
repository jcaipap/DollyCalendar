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
public class QueueArrayGeneric<T> {
	private final int N;
	private int front, rear, count;
	private T[] qarray;
	
	public QueueArrayGeneric() {
		front = rear = count = 0;
		this.N=5;
		qarray = (T[]) new Object[N];
	}


	public QueueArrayGeneric(int n) {
		front = rear = count = 0;
		qarray = (T[]) new Object[n];
		this.N = n;
	}

	//ejemplo constructor de int: 
	//QueueArrayGeneric<Integer> queue;
	//queue = new QueueArrayGeneric <Integer> ();

	public T dequeue() {
		T item = null;
		if(empty())
			System.out.println("Queue is empty: item not dequeued");
		else {
			item = qarray[front];
			front = (front + 1) % N;
		count--;
		}
	
		return item;
	}
	
	public void enqueue(T item) {
		if(full())
			System.out.println("Queue is full: item not enqueued");
		else {
			qarray[rear] = item;
			rear = (rear + 1) % N;
			count++;
		}
	}
	
	public boolean empty() {
		return count <= 0;
	}
	
	public boolean full() {
		return count >= N;
	}

	public int getCount() {
		return count;
	}
        
        public T element(){
            if (empty())
                throw new RuntimeException("Queue is empty");
            return qarray[front];
        }
        public boolean compareToFront(T item){ 
            if(empty())
                throw new RuntimeException("Stack is empty");
            return item==qarray[front];
        }
        public boolean compareToRear(T item){ 
            if(empty())
                throw new RuntimeException("Stack is empty");
            return item==qarray[rear];
        }
} 