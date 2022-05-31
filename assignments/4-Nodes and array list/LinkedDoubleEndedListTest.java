import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class LinkedDoubleEndedListTest {
   /** A test that always fails. **/
   @Test public void NodeTest() {
      LinkedDoubleEndedList<String> obj = new LinkedDoubleEndedList<String>();
      obj.addFirst("a");
      obj.addLast("b");
      obj.addLast("c");
      obj.addFirst("d");
      obj.removeLast();
      obj.removeFirst();
      obj.removeLast();
      obj.removeFirst();
      obj.addFirst("A");
      obj.removeLast();
      
      
      
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }
}
