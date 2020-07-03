/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuas;

import java.io.Serializable;

/**
 *
 * @author JAndres
 * @param <K>
 * @param <V>
 */
public class HashNode <K,V> implements Serializable, Comparable<HashNode<K,V>>{
    final K key;
    V value;
    HashNode<K, V> next;

    public HashNode(K key, V value, HashNode<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
    
    public HashNode(K key, V value){ 
        this.key = key; 
        this.value = value; 
    } 
    
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public HashNode<K, V> getNext() {
        return next;
    }
    @Override
    public int compareTo(HashNode hashnode){
        int result;
        Object obj=(Object) key;
        String comp=hashnode.getKey().toString();
        result=obj.toString().compareTo(comp);
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj instanceof HashNode) {
            HashNode hashNode = (HashNode) obj;

            return key.equals(hashNode.getKey())
                    && value.equals(hashNode.getValue());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + ((key == null) ? 0 : key.hashCode());
        hash = 17 * hash + ((value == null) ? 0 : value.hashCode());
        return hash;
    }

    @Override
    public String toString() {
        return "{" + key + ", " + value + "}";
    }
}
