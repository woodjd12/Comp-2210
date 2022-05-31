import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class MinOfThreeTest {
   /** Test MinOfThree. **/
   @Test
   public void test1min1() {
      int a = 1;
      int b = 2;
      int c = 3;
      int expected = 1;
      int actual = MinOfThree.min1(a, b, c);
      assertEquals(expected, actual);
   }
   /** Test MinOfThree. **/
   @Test
   public void test2min1() {
      int a = 2;
      int b = 1;
      int c = 3;
      int expected = 1;
      int actual = MinOfThree.min1(a, b, c);
      assertEquals(expected, actual);
   }
/** Test MinOfThree. **/
   @Test
   public void test3min1() {
      int a = 2;
      int b = 3;
      int c = 1;
      int expected = 1;
      int actual = MinOfThree.min1(a, b, c);
      assertEquals(expected, actual);
   }
   /** Test MinOfThree. **/
   @Test
   public void test4min1() {
      int a = 2;
      int b = 2;
      int c = 3;
      int expected = 2;
      int actual = MinOfThree.min1(a, b, c);
      assertEquals(expected, actual);
   }
   /** Test MinOfThree. **/
   @Test
   public void test1min2() {
      int a = 1;
      int b = 2;
      int c = 3;
      int expected = 1;
      int actual = MinOfThree.min2(a, b, c);
      assertEquals(expected, actual);
   }
   /** Test MinOfThree. **/
   @Test
   public void test2min2() {
      int a = 3;
      int b = 1;
      int c = 2;
      int expected = 1;
      int actual = MinOfThree.min2(a, b, c);
      assertEquals(expected, actual);
   }
   /** Test MinOfThree. **/
   @Test
   public void test3min2() {
      int a = 3;
      int b = 2;
      int c = 1;
      int expected = 1;
      int actual = MinOfThree.min2(a, b, c);
      assertEquals(expected, actual);
   }
   /** Test MinOfThree. **/
   @Test
   public void test4min2() {
      int a = 1;
      int b = 1;
      int c = 2;
      int expected = 1;
      int actual = MinOfThree.min2(a, b, c);
      assertEquals(expected, actual);
   }
   /** Test MinOfThree. **/
   @Test
   public void test5min2() {
      int a = 3;
      int b = 1;
      int c = 1;
      int expected = 1;
      int actual = MinOfThree.min2(a, b, c);
      assertEquals(expected, actual);
   }
   /** Test MinOfThree. **/
   @Test
   public void test6min2() {
      int a = 1;
      int b = 2;
      int c = 1;
      int expected = 1;
      int actual = MinOfThree.min2(a, b, c);
      assertEquals(expected, actual);
   }
   /** Test MinOfThree. **/
   @Test
   public void test7min2() {
      int a = 1;
      int b = 1;
      int c = 1;
      int expected = 1;
      int actual = MinOfThree.min2(a, b, c);
      assertEquals(expected, actual);
   }
}
