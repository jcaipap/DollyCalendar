/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuas;

import java.util.Arrays;

/**
 *
 * @author JAndres
 * @param <K>
 * @param <V>
 */
public class HashGeneric<K, V> {

    private HashNode<K, V>[] bucketArray;
    private DynamicArray values;
    private int capacity;
    private int size=0;
    private final double load=0.75;

    public HashGeneric() {
        bucketArray = new HashNode[4];
        capacity = 4;
        for (int i = 0; i <capacity; i++) {
            bucketArray[i] = null;
        }
        values=new DynamicArray();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index=Math.abs(hashCode%capacity);
        return index;
    }

    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray[bucketIndex-1];
        HashNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        size--;
        if (prev != null) {
            prev.next = head.next;
        } else {
            bucketArray[bucketIndex-1] = head.next;
        }
        return head.value;
    }
    
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray[bucketIndex-1];
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }
    
    public V getValue(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray[bucketIndex-1];
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
        }
        return null;
    }
    
    
    public void add(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray[bucketIndex-1];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        
        size++;
        head = bucketArray[bucketIndex-1];
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        bucketArray[bucketIndex-1] = newNode;

        if (size==load*capacity) {
            HashNode<K, V>[] temp = bucketArray;
            capacity *= 2;
            size = 0;
            bucketArray = new HashNode[capacity];
            for (int i = 0; i < capacity; i++) {
                bucketArray[i] = null;
            }

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
        values.additem((Comparable) value);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (HashNode entry : bucketArray) {
            while (entry != null) {
                sb.append(entry);
                if (entry.next != null) {
                    sb.append(", ");
                }
                entry = entry.next;
            }
        }
        return sb.toString();
    }
     public DynamicArray getHashArray() {
        DynamicArray sb = new DynamicArray();
        for (HashNode entry : bucketArray) {
            while (entry != null) {
                sb.additem((Comparable) entry.getValue());
                entry = entry.next;
            }
        }
        return sb;
    }
    
}
