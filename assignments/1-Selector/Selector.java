import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   John Wood (JDW0091@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  1/16/19
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    * @param a for array
    * @return int[]
    * @throw IllegalArgumentException for null or zero arrays
    */
   public static int min(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      else {
         int min = a[0];
         for (int i = 0; i < a.length; i++) {
            if (min > a[i]) {
               min = a[i];
            }
         }
         return min;
      }
   }


   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    * @param a for array
    * @return int[]
    * @throw IllegalArgumentException for null or zero arrays
    */
   public static int max(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      else {
         int max = a[0];
         for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
               max = a[i];
            }
         }
         return max;
      }
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmin(int[] a, int k) {
      if (k < 1 || a == null) {
         throw new IllegalArgumentException();
      }
      int count = 0;
      int[] b = new int[0];
      int index = 0;
      for (int i = 0; i < a.length - 1; i++) {
         for (int j = i + 1; j < a.length; j++) {
            if (a[i] == a[j]) {
               count++;
            }
            break;
         }
      }
      if (k > a.length - count) {
         throw new IllegalArgumentException();
      }
      for (int n = 0; n < a.length; n++) {
         b = Arrays.copyOf(b, b.length + 1);
         b[index] = a[n];
         index++;
      }
      Arrays.sort(b);
      for (int p = 0; p < k - 1; p++) {
         if (b[p] == b[p + 1]) {
            k++;
         }
      }
      
      return b[k - 1];
   }


   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmax(int[] a, int k) {
      if (k < 1 || a == null) {
         throw new IllegalArgumentException();
      }
      int count = 0;
      int[] b = new int[0];
      int index = 0;
      for (int i = 0; i < a.length - 1; i++) {
         for (int j = i + 1; j < a.length; j++) {
            if (a[i] == a[j]) {
               count++;
            }
            break;
         }
      }
      if (k > a.length - count) {
         throw new IllegalArgumentException();
      }
      for (int n = 0; n < a.length; n++) {
         b = Arrays.copyOf(b, b.length + 1);
         b[index] = a[n];
         index++;
      }
      Arrays.sort(b);
      for (int p = b.length - 1; p > b.length - k; p--) {
         if (b[p] == b[p - 1]) {
            k++;
         }
      }
      return b[b.length - k];
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    * @param a for array
    * @param low for low bound
    * @param high for high bound
    * @return int[]
    * @throw IllegalArgumentException for null or zero arrays
    */
   public static int[] range(int[] a, int low, int high) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      else {
         int count = 0;
         int[] b = new int[0];
         for (int i = 0; i < a.length; i++) {
            if (low <= a[i] && high >= a[i])  {
               b = Arrays.copyOf(b, b.length + 1);
               b[count] = a[i];
               count++;
            }
         }
         return b;
      }
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int ceiling(int[] a, int key) {
      int count = 0;
      int[] b = new int[0];
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      else {
         for (int i = 0; i < a.length; i++) {
            if (a[i] >= key) {
               b = Arrays.copyOf(b, b.length + 1);
               b[count] = a[i];
               count++;
            }
         }
         if (b.length == 0) {
            throw new IllegalArgumentException();
         }
         else {
            int ceiling = b[0];
            for (int j = 0; j < b.length; j++) {
               if (b[j] <= ceiling) {
                  ceiling = b[j];
               }
            }
            return ceiling;
         }
      }
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int floor(int[] a, int key) {
      int count = 0;
      int[] b = new int[0];
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      else {
         for (int i = 0; i < a.length; i++) {
            if (a[i] <= key) {
               b = Arrays.copyOf(b, b.length + 1);
               b[count] = a[i];
               count++;
            }
         }
         if (b.length == 0) {
            throw new IllegalArgumentException();
         }
         else {
            int floor = b[0];
            for (int j = 0; j < b.length; j++) {
               if (b[j] >= floor) {
                  floor = b[j];
               }
            }
            return floor;
         }
      }
   }
}