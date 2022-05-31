import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;
public class LinkedDoubleEndedList<T> implements DoubleEndedList<T> {
   private Node front = null;
   private Node rear = null;
   private int size = 0;

/**
    * Adds element to the front of the list. If element is null,
    * this method throws an IllegalArgumentException.
    */
   public void addFirst(T element){
      if (element == null) {
         throw new IllegalArgumentException();
      }
      if (isEmpty()) {
         front = new Node(element);
         rear = front;
         size++;
      }
      else {
         Node p = new Node(element);
         p.next = front;
         front.prev = p;
         front = p;
         size++;
      }
   }
   
   /**
    * Adds element to the end of the list. If element is null,
    * this method throws an IllegalArgumentException.
    */
   public void addLast(T element){
      if (element == null) {
         throw new IllegalArgumentException();
      }
      if (isEmpty()) {
         front = new Node(element);
         rear = front;
         size++;
      }
      else {
         Node p = new Node(element);
         p.prev = rear;
         rear.next = p;
         rear = p;
         size++;
      }
      
   }
      
   /**
    * Delete and return the element at the front of the list.
    * If the list is empty, this method returns null.
    */
   public T removeFirst() {
      if (isEmpty()) {
         return null;
      }
      if (size == 1) {
         Node x = front;
         front = null;
         rear = null;
         size--;
         return x.element;
      }
      Node x = front;
      Node p = null;
      front.next.prev = p;
      p = front.next;
      front.next = p;
      front = p;
      size--;
      return x.element;
   }
   
   /**
    * Delete and return the element at the end of the list.
    * If the list is empty, this method returns null.
    */
   public T removeLast() {
      if (isEmpty()) {
         return null;
      }
      if (size == 1) {
         Node x = front;
         front = null;
         rear = null;
         size--;
         return x.element;
      }
      Node x = rear;
      Node p = null;
      rear.prev.next = p;
      p = rear.prev;
      rear.prev = p;
      rear = p;
      size--;
      return x.element;
   }
    /**
    * Returns true if this list contains no elements, false otherwise.
    */
   public boolean isEmpty() {
      return size == 0;
   }
   /**
    * Returns the number of elements in this list.
    */
   public int size() {
      return size;
   }

   
   public Iterator<T> iterator() {
      SelfIterator itr = new SelfIterator();
      return itr;
   
   }
   private class SelfIterator implements Iterator<T> {
      
      private Node current = front;
      public boolean hasNext() { 
         return current != null;
      }
      public T next() { 
         if (!hasNext())
            throw new NoSuchElementException();
         T result = current.element;
         current = current.next; 
         return result;
      }
   }


   private class Node {
      private T element;
      private Node next;
      private Node prev;
   
      public Node(T e) {
         element = e;
      }
   }
   
}