import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;
public class ArrayRandomizedList<T> implements RandomizedList<T> {
   private T[] newElements;
   private T[] elements;
   private int size;
   public ArrayRandomizedList() {
      elements = (T[]) new Object[5];
      size = 0;
   }
/**
    * Adds the specified element to this list. If the element is null, this
    * method throws an IllegalArgumentException.
    */
   public void add(T element) {
      if (element == null) {
         throw new IllegalArgumentException();
      }
      if (size == elements.length) {
         resize(elements.length * 2);
      }
      elements[size] = element;
      size++;
   }
/**
    * Selects and removes an element selected uniformly at random from the
    * elements currently in the list. If the list is empty this method returns
    * null.
    */
   public T remove() {
      if (isEmpty()) {
         return null;
      }
      Random rand = new Random();
      int index = rand.nextInt(size);
      T element = elements[index];
      elements[index] = null;
      size--;
      if (index != size) {
         elements[index] = elements[size];
         elements[size] = null;
      }
      
      return element;
   }
   
   /**
    * Selects but does not remove an element selected uniformly at random from
    * the elements currently in the list. If the list is empty this method
    * return null.
    */
   public T sample() {
      if (isEmpty()) {
         return null;
      }
      Random rand = new Random();
      int index = rand.nextInt(size);
      T element = elements[index];
      return element;
   }
   /**
    * Returns the number of elements in this list.
    */
   public int size() {
      return size;
   }
 
   /**
    * Returns true if this list contains no elements, false otherwise.
    */
   public boolean isEmpty() {
      return size == 0;
   }
   
   private void resize(int capacity) {
      T[] a = (T[]) new Object[capacity];
      for (int i = 0; i < elements.length; i++) {
         a[i] = elements[i];
      }
      elements = a;
   }
   
   public SelfIterator iterator() {
      SelfIterator itr = new SelfIterator(elements, size);
      return itr;
   }
   
   /**
    * Creates and returns an iterator over the elements of this list.
    */
   private class SelfIterator implements Iterator<T> {
      private int size;
      private int current;
      private T[] items;
      public SelfIterator(T[] elementsIn, int sizeIn) {
         items = elementsIn;
         size = sizeIn;
         current = size - 1;
      }
      
      public boolean hasNext() {
      
         return (current >= 0);
      }
      public T next() {
         Random rand = new Random();
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         int randNum = rand.nextInt(current + 1);
         T item = items[randNum];
         items[randNum] = items[current];
         items[current] = item;
         current--;
         return item;
      }
   }

}