import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class LineTest {
  /** Add returns true. **/
   @Test public void addTest1() {
      Line line = new Line();
      line.add(new Point(1, 1));
      line.add(new Point(1, 0));
      line.add(new Point(1, 2));
      line.add(new Point(1, 3));
      System.out.print(line.toString());
      Assert.assertEquals(true, line.add(new Point(1, 4)));
   }
   /** Add test duplicate. **/
   @Test public void addTest2() {
      Line line = new Line();
      line.add(new Point(1, 0));
      line.add(new Point(1, 1));
      line.add(new Point(1, 2));
      line.add(new Point(1, 3));
      line.add(new Point(1, 4));
      
      Assert.assertEquals(false, line.add(new Point(1, 4)));
   }
   /** Add test not on same line. **/
   @Test public void addTest3() {
      Line line = new Line();
      line.add(new Point(1, 0));
      line.add(new Point(1, 1));
      line.add(new Point(1, 2));
      line.add(new Point(1, 3));
      line.add(new Point(1, 4));
      
      Assert.assertEquals(false, line.add(new Point(2, 5)));
   }
   /** Add test no points in collection. **/
   @Test public void addTest4() { 
      Line line = new Line();
      Assert.assertEquals(true, line.add(new Point(1, 4)));
   }
   /** Add test 1 point in collection **/
   @Test public void addTest5() {
      Line line = new Line();
      line.add(new Point(1, 0));
      Assert.assertEquals(true, line.add(new Point(1, 4)));
   }
   /** First Test lowest not added **/
   @Test public void firstTest1() {
      Line line = new Line();
      Point p = new Point(1, 1);
      line.add(new Point(1, 1));
      line.add(new Point(1, 2));
      line.add(new Point(2, 0));
      line.add(new Point(1, 3));
      line.add(new Point(1, 4));
      
      Assert.assertEquals(p, line.first());
   }
   /** Last Test highest not added **/
   @Test public void lastTest1() {
      Line line = new Line();
      Point p = new Point(1, 3);
      line.add(new Point(1, 1));
      line.add(new Point(1, 2));
      line.add(new Point(1, 0));
      line.add(new Point(1, 3));
      line.add(new Point(2, 4));
      
      Assert.assertEquals(p, line.last());
   }
   /** Length Test highest not added **/
   @Test public void lengthTest1() {
      Line line = new Line();
      line.add(new Point(1, 1));
      line.add(new Point(1, 2));
      line.add(new Point(1, 0));
      line.add(new Point(1, 3));
      line.add(new Point(2, 4));
      
      Assert.assertEquals(4, line.length());
   }
   /** Length Test no points **/
   @Test public void lengthTest2() {
      Line line = new Line();
      Assert.assertEquals(0, line.length());
   }
}


