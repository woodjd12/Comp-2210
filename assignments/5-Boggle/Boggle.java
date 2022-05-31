import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Boggle implements WordSearchGame {
   private TreeSet<String> ts;
   private boolean loaded;
   private String[] defaultBoard = new String[]{"E", "E", "C", "A", "A", "L", "E", "P", "H", 
                                "N", "B", "O", "Q", "T", "T", "Y"};
   private String[][] board;
   // visited positions in the maze
   private boolean[][] visited;

   public Boggle() {
      ts = new TreeSet<String>();
      loaded = false;
      setBoard(defaultBoard);
   }
         
  /**
  * Loads the lexicon into a data structure for later use. 
  * 
  * @param fileName A string containing the name of the file to be opened.
  * @throws IllegalArgumentException if fileName is null
  * @throws IllegalArgumentException if fileName cannot be opened.
  */

   public void loadLexicon(String fileName) {
      if (fileName == null) {
         throw new IllegalArgumentException();
      }
      try {
         Scanner scanFile = new Scanner(new File(fileName));
         while (scanFile.hasNext()) {
            String word = scanFile.next();
            word = word.toUpperCase();
            ts.add(word);
            scanFile.nextLine();
         }
      }
      catch (Exception e) {
         throw new IllegalArgumentException();
      }
      loaded = true;
   }
   
   /**
    * Stores the incoming array of Strings in a data structure that will make
    * it convenient to find words.
    * 
    * @param letterArray This array of length N^2 stores the contents of the
    *     game board in row-major order. Thus, index 0 stores the contents of board
    *     position (0,0) and index length-1 stores the contents of board position
    *     (N-1,N-1). Note that the board must be square and that the strings inside
    *     may be longer than one character.
    * @throws IllegalArgumentException if letterArray is null, or is  not
    *     square.
    */
   public void setBoard(String[] letterArray) {
      if (letterArray == null) {
         throw new IllegalArgumentException();
      }
      if (Math.sqrt(letterArray.length) - Math.ceil(Math.sqrt(letterArray.length)) != 0) {
         throw new IllegalArgumentException();
      }
      int dimension = (int) Math.sqrt(letterArray.length);
      board = new String[dimension][dimension];
      int i = 0;
      for (int x = 0; x < dimension; x++) {
         for (int y = 0; y < dimension; y++) {
            board[x][y] = letterArray[i].toUpperCase();
            i++;
         }
      }
      markAllUnvisited();
   }
   
   /**
    * Creates a String representation of the board, suitable for printing to
    *   standard out. Note that this method can always be called since
    *   implementing classes should have a default board.
    */
   public String getBoard() {
      int dimension = board[0].length;
      String output = "";
      for (int x = 0; x < dimension; x++) {
         for (int y = 0; y < dimension; y++) {
            output += board[x][y] + " ";
         }
         output += "\n";
         
      }
      return output;
   }
   
   /**
    * Retrieves all valid words on the game board, according to the stated game
    * rules.
    * 
    * @param minimumWordLength The minimum allowed length (i.e., number of
    *     characters) for any word found on the board.
    * @return java.util.SortedSet which contains all the words of minimum length
    *     found on the game board and in the lexicon.
    * @throws IllegalArgumentException if minimumWordLength < 1
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public SortedSet<String> getAllValidWords(int minimumWordLength) {
      if (minimumWordLength < 1) {
         throw new IllegalArgumentException();
      }
      if (!loaded) {
         throw new IllegalStateException();
      }
      SortedSet<String> allValidWords = new TreeSet<String>();
      for (String word : ts) {
         if (isOnBoard(word).size() == 0 || word.length() < minimumWordLength) {
            continue;
         }
         allValidWords.add(word);
      }
      
      return allValidWords;
   }
   
  /**
   * Computes the cummulative score for the scorable words in the given set.
   * To be scorable, a word must (1) have at least the minimum number of characters,
   * (2) be in the lexicon, and (3) be on the board. Each scorable word is
   * awarded one point for the minimum number of characters, and one point for 
   * each character beyond the minimum number.
   *
   * @param words The set of words that are to be scored.
   * @param minimumWordLength The minimum number of characters required per word
   * @return the cummulative score of all scorable words in the set
   * @throws IllegalArgumentException if minimumWordLength < 1
   * @throws IllegalStateException if loadLexicon has not been called.
   */  
   public int getScoreForWords(SortedSet<String> words, int minimumWordLength) {
      if (!loaded) {
         throw new IllegalStateException();
      }
      if (minimumWordLength < 1) {
         throw new IllegalArgumentException();
      }
      int score = 0;
      for (String word : words) {
         if (isOnBoard(word).size() < minimumWordLength) {
            continue;
         }
         if (!isValidWord(word)) {
            continue;
         }
         score += 1 + (word.length() - minimumWordLength);
      }
      
      return score;
   }
   
   /**
    * Determines if the given word is in the lexicon.
    * 
    * @param wordToCheck The word to validate
    * @return true if wordToCheck appears in lexicon, false otherwise.
    * @throws IllegalArgumentException if wordToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public boolean isValidWord(String wordToCheck) {
      wordToCheck = wordToCheck.toUpperCase();
      if (ts.contains(wordToCheck)) {
         return true;
      }
      return false;
   }
   
   /**
    * Determines if there is at least one word in the lexicon with the 
    * given prefix.
    * 
    * @param prefixToCheck The prefix to validate
    * @return true if prefixToCheck appears in lexicon, false otherwise.
    * @throws IllegalArgumentException if prefixToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public boolean isValidPrefix(String prefixToCheck) {
      if (prefixToCheck == null || loaded == false) {
         throw new IllegalArgumentException();
      }
      boolean validPrefix = ts.ceiling(prefixToCheck.toUpperCase()).startsWith(prefixToCheck.toUpperCase());
      return validPrefix;
   }
      
   /**
    * Determines if the given word is in on the game board. If so, it returns
    * the path that makes up the word.
    * @param wordToCheck The word to validate
    * @return java.util.List containing java.lang.Integer objects with  the path
    *     that makes up the word on the game board. If word is not on the game
    *     board, return an empty list. Positions on the board are numbered from zero
    *     top to bottom, left to right (i.e., in row-major order). Thus, on an NxN
    *     board, the upper left position is numbered 0 and the lower right position
    *     is numbered N^2 - 1.
    * @throws IllegalArgumentException if wordToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public List<Integer> isOnBoard(String wordToCheck) {
      List<Integer> path = new ArrayList();
      StringBuilder wordSoFar = new StringBuilder();
      int dimension = board[0].length;
      wordToCheck = wordToCheck.toUpperCase();
      for (int x = 0; x < dimension; x++) {
         for (int y = 0; y < dimension; y++) {
            if (wordToCheck.startsWith(board[x][y])) {
               dfsOneWord(x, y, wordToCheck, wordSoFar, path);
            }
         }
      }
      markAllUnvisited();
      return path;
   }
   
   public boolean dfsOneWord(int i, int j, String wordToCheck, StringBuilder wordSoFar, List<Integer> path) {
      if (i >= board[0].length || 0 > i) {
         return false;
      }
      if (j >= board[0].length || 0 > j) {
         return false;
      }
      if (visited[i][j]) {
         return false;
      }
      if (!wordToCheck.startsWith(wordSoFar.toString())) {
         return false;
      }
      if (wordToCheck.equals(wordSoFar.toString())) {
         return true;
      }
      visited[i][j] = true;
      wordSoFar = wordSoFar.append(board[i][j]);
      path.add(i * board[0].length + j);
      if (wordToCheck.equals(wordSoFar.toString())) {
         return true;
      }
      for (int x = -1; x <= 1; x++) {
         for (int y = -1; y <= 1; y++) {
            if (!((x == 0) && (y == 0))) {
               if (dfsOneWord(i + x, j + y, wordToCheck, wordSoFar, path)) {
                  return true;
               }
            }
         }
      }
      visited[i][j] = false;
      for (int k = 0; k < board[i][j].length(); k++) {
         wordSoFar = wordSoFar.deleteCharAt(wordSoFar.length() - 1);
      }
      path.remove(path.size() - 1);
      return false;
      
      
   }
   
   public void markAllUnvisited() {
      int dimension = board[0].length;
      visited = new boolean[dimension][dimension];
      for (int x = 0; x < dimension; x++) {
         for (int y = 0; y < dimension; y++) {
            visited[x][y] = false;
         }
      }
   
   }
}