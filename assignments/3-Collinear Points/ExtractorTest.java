import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class ExtractorTest {
   /** A test that always fails. **/
   @Test public void defaultTest() {
      Extractor cl = new Extractor("input3a.txt");
      SortedSet<Line> bruteLines = cl.getLinesBrute();
      System.out.println("Brute: ");
      printLines(bruteLines);
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", output, output);
   }
}
