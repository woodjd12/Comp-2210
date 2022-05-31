import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class SelectorTest {
  /** Test min in Selector. **/
   @Test 
   public void minTest1() {
      int[] a = {2, 4, 6, 8, 10};
      int expected = 2;
      int actual = Selector.min(a);
      assertEquals(expected, actual);
   }
   /** Test min in Selector. **/
   @Test 
   public void minTest2() {
      int[] a = {5, 9, 1, 7, 3};
      int expected = 1;
      int actual = Selector.min(a);
      assertEquals(expected, actual);
   }
   /** Test max in Selector. **/
   @Test 
   public void maxTest1() {
      int[] a = {5, 9, 1, 7, 3};
      int expected = 9;
      int actual = Selector.max(a);
      assertEquals(expected, actual);
   }
    /** Test range in Selector. **/
   @Test 
   public void rangeTest1() {
      int[] a = {5, 9, 1, 7, 3};
      int low = 3;
      int high = 5;
      int[] expected = {5, 3};
      int[] actual = Selector.range(a, low, high);
      assertEquals(expected, actual);
   }
   // SPECIAL CIRCUMSTANCES
   /** Test min in Selector. **/
   @Test 
   public void minTestSpec1() {
      int[] a = {1, 9, 1, 1, 3};
      int expected = 1;
      int actual = Selector.min(a);
      assertEquals(expected, actual);
   }
    /** Test max in Selector. **/
   @Test 
   public void maxTestSPEC1() {
      int[] a = {5, 9, 9, 9, 3};
      int expected = 9;
      int actual = Selector.max(a);
      assertEquals(expected, actual);
   }
}
