import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;
public class LinkedRandomizedList<T> implements RandomizedList<T> {
/**
    * Adds the specified element to this list. If the element is null, this
    * method throws an IllegalArgumentException.
    */
   public void add(T element) {
   
   }
/**
    * Selects and removes an element selected uniformly at random from the
    * elements currently in the list. If the list is empty this method returns
    * null.
    */
   public T remove() {
      return null;
   }
   
   /**
    * Selects but does not remove an element selected uniformly at random from
    * the elements currently in the list. If the list is empty this method
    * return null.
    */
   public T sample() {
      return null;
   }
   /**
    * Returns the number of elements in this list.
    */
   public int size() {
      return -99;
   }
 
   /**
    * Returns true if this list contains no elements, false otherwise.
    */
   public boolean isEmpty() {
      return false;
   }
   
   /**
    * Creates and returns an iterator over the elements of this list.
    */
   private class SelfIterator implements Iterator<T> {
   }

}