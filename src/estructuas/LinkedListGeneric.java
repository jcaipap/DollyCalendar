/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuas;

import data.Casilla;
import java.util.Scanner;

/**
 *
 * @author andre
 * @param <T>
 */
public class LinkedListGeneric<T extends Comparable<T>> {
    private NodeGeneric<T> head;
    private NodeGeneric<T> last;
    private int N;
    
    public LinkedListGeneric() {
        head = null;
        last=null;
        N=0;
    }
    
    public boolean isEmpty() {
           return N == 0;
       }
    public int size() {
           return N;
       }
    public boolean insert(T item) {
        boolean inserted;
        NodeGeneric<T> ptr, prev,tail,preTail;
        inserted = false;
        ptr = head;
        prev = null;
        tail=head;
        preTail=null;
        while (ptr != null && ptr.getData().compareTo(item) <= 0) {
            prev = ptr;
            ptr = ptr.getNext();
        }
        if (ptr == null) {
            inserted = true;
            NodeGeneric<T> newp = new NodeGeneric();
            newp.setData(item);
            newp.setNext(ptr);
            if (prev == null) {
                head = newp;
                N++;
            } else {
                prev.setNext(newp);
                N++;
            }
        }
        while (tail!=null){
            preTail=tail;
            tail=tail.next;
            last=preTail;
        }
        return inserted;
    }
   /* public void insert(T item) {
           if (item == null) { throw new NullPointerException("The first argument for addLast() is null."); }
           if (!isEmpty()) {
               NodeGeneric prev = last;
               last = new NodeGeneric(item);
               prev.next = last;
           }
           else {
               last = new NodeGeneric(item);
               head = last;
           }
           N++;
       }*/
    public boolean delete(T item) {
           if (isEmpty()) { throw new IllegalStateException("Cannot remove() from and empty list."); }
           boolean result = false;
           NodeGeneric prev = head;
           NodeGeneric curr = head;
           while (curr.next != null || curr == last) {
               if (curr.data.equals(item)) {
                   if (N == 1) { head = null; last = null; }
                   else if (curr.equals(head)) { head = head.next; }
                   else if (curr.equals(last)) { last = prev; last.next = null; }
                   else { prev.next = curr.next; }
                   N--;
                   result = true;
                   break;
               }
               prev = curr;
               curr = prev.next;
           }
           return result;
       }

    
    public void printRecursive() {
        System.out.print("List Recursive: ");
        printR(head);
        System.out.println();
    }

    private void printR(NodeGeneric p) {
        if (p != null) {
            System.out.print(p.getData() + " ");
            printR(p.getNext());
        }
    }
    public NodeGeneric insertAt(NodeGeneric head,T data, int position){
        int i=0;
        NodeGeneric nodoNuevo = new NodeGeneric(data);
        NodeGeneric nodo=head;
                while(i<position-1){
                    nodo=nodo.getNext();
                    i++;
                    }
                
                nodo.setNext(nodoNuevo.getNext());
                nodo.setNext(nodoNuevo);
 
            return head;

    }
    public NodeGeneric insertAtHead(NodeGeneric head, int data){
        NodeGeneric nodo = new NodeGeneric(data);
 
            if(head==null){
                head=nodo;
            }else{
                nodo.setNext(head);
                head=nodo;
            }
 
        return head;

    }
    public NodeGeneric insertAtTail(NodeGeneric head, int data) {

        NodeGeneric nodo = new NodeGeneric(data);

        if (head == null) {
            head = nodo;
        } else {
            NodeGeneric nodo2 = head;
            while (nodo2.getNext() != null) {
                nodo2 = nodo2.getNext();
            }
            nodo2.setNext(nodo);
        }

        return head;

    }
}