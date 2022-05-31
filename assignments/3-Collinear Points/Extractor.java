import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Extractor.java. Implements feature extraction for collinear points in
 * two dimensional data.
 *
 * @author  YOUR NAME (you@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version TODAY
 *
 */
public class Extractor {
   
   /** raw data: all (x,y) points from source data. */
   private Point[] points;
   
   /** lines identified from raw data. */
   private SortedSet<Line> lines;
  
   /**
    * Builds an extractor based on the points in the file named by filename. 
    */
   public Extractor(String filename) {
      try {
         this.points = new Point[0];
         int i = 0;
         Scanner scanFile = new Scanner(new File(filename));
         int numPts = scanFile.nextInt();
         while (scanFile.hasNext() && i < numPts) {
            int x = scanFile.nextInt();
            int y = scanFile.nextInt();
            points = Arrays.copyOf(points, points.length + 1);
            points[i] = new Point(x, y);
            i++;
         }
      }
      catch (Exception e) {
         System.out.println("*****ERROR**** " + e.toString());
      }
         
   
   }
  
   /**
    * Builds an extractor based on the points in the Collection named by pcoll. 
    *
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   public Extractor(Collection<Point> pcoll) {
      points = pcoll.toArray(new Point[]{});
   }
  
   /**
    * Returns a sorted set of all line segments of exactly four collinear
    * points. Uses a brute-force combinatorial strategy. Returns an empty set
    * if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesBrute() {
      lines = new TreeSet<Line>(); 
      double slope1;
      double slope2;
      double slope3;
      
      for (int p = 0; p < points.length - 3; p++) {
         for (int q = p + 1; q < points.length - 2; q++) {
            for (int r = q + 1; r < points.length - 1; r++) {
               for (int s = r + 1; s < points.length; s++) {
                  Line line = new Line();
                  slope1 = points[p].slopeTo(points[q]);
                  slope2 = points[q].slopeTo(points[r]);
                  slope3 = points[r].slopeTo(points[s]);
                  if (slope1 == slope2 && slope2 == slope3) {
                     line.add(points[p]);
                     line.add(points[q]);
                     line.add(points[r]);
                     line.add(points[s]);
                  }
                  if (line.length() > 3) {
                     lines.add(line);
                  }
               }
            }
         }
      }
   
      return lines;
   }
  
   /**
    * Returns a sorted set of all line segments of at least four collinear
    * points. The line segments are maximal; that is, no sub-segments are
    * identified separately. A sort-and-scan strategy is used. Returns an empty
    * set if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesFast() {
      lines = new TreeSet<Line>(); 
      Point[] pointsBySlope = Arrays.<Point>copyOf(points, points.length);
      Arrays.sort(points);
      for (int referencePoint = 0; referencePoint < points.length; referencePoint++) { 
         Line line = new Line();
         Arrays.<Point>sort(pointsBySlope, points[referencePoint].slopeOrder);
         int start = 0;
         int end = 0;
         int currentPoint = 0;
         while (currentPoint < pointsBySlope.length - 1) {
            if (pointsBySlope[currentPoint].compareTo(pointsBySlope[referencePoint]) < 0) {
               while (currentPoint < pointsBySlope.length - 1 && pointsBySlope[currentPoint].compareTo(pointsBySlope[referencePoint]) < 0) {
                  currentPoint++;
               }
               start = currentPoint;
               end = currentPoint;
               if (currentPoint == pointsBySlope.length - 1) {
                  break;
               }
            }
            double slope1 = pointsBySlope[currentPoint].slopeTo(points[referencePoint]);
            double slope2 = pointsBySlope[currentPoint + 1].slopeTo(points[referencePoint]);
            if (slope1 == slope2) {
               line.add(pointsBySlope[currentPoint]);
               end++;
            }
            else {
               line.add(points[referencePoint]);
               if (line.length() > 3) {   
                  lines.add(line);
               }
               start = ++end;
            }
            if (end == pointsBySlope.length - 1) {
               break;
            }
            currentPoint++;
            
         }
      }
      return lines;
   }
}
