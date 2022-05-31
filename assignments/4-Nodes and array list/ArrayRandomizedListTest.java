import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class ArrayRandomizedListTest {
   /** A test that always fails. **/
   @Test public void arrayTestTest() {
      ArrayRandomizedList<String> obj = new  ArrayRandomizedList<String>();
      obj.add("a");
      obj.add("b");
      obj.add("c");
      obj.add("d");
      obj.iterator();
      obj.next();
      obj.next();
      obj.next();
      obj.next();
      obj.next();
   
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }
}
