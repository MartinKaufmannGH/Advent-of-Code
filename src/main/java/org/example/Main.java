package org.example;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    /* DAY 1
    BufferedReader reader;
    reader = new BufferedReader(new FileReader("Day 1 Input"));
    String line = reader.readLine();

    LinkedList<Integer> listOne = new LinkedList<>();
    LinkedList<Integer> listTwo = new LinkedList<>();

    while (line != null) {
      listOne.add(Integer.parseInt(line.split(" {3}")[0]));
      listTwo.add(Integer.parseInt(line.split(" {3}")[1]));
      line = reader.readLine();
    }
    listOne.sort(Integer::compareTo);
    listTwo.sort(Integer::compareTo);

    Iterator<Integer> iteratorOne = listOne.iterator();
    //  Iterator<Integer> iteratorTwo = listTwo.iterator();

    Integer num = 0;
    Integer result = 0;
    while (iteratorOne.hasNext()) {
      Integer current = iteratorOne.next();
      num = Math.toIntExact(listTwo.stream().filter(c -> c.equals(current)).count());
      result += current * num;
    }
    System.out.println(result);
     */
    BufferedReader reader;
    reader = new BufferedReader(new FileReader("Day 2 Input"));
    String line = reader.readLine();
    int[] intArray;
    int zaehler = 0;
    Boolean safe = false;
    Boolean trip = false;
    Boolean mode;
    while (line != null) {
      ArrayList<Integer> tempArray = new ArrayList<>();
      intArray = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (!(intArray[0] == intArray[1])) {
        mode = determineMode(intArray[0],intArray[1]);
      } else {
        mode = determineMode(intArray[1],intArray[2]);
        trip = true;
      }
      if (mode) {
        for (int i = 0; i < intArray.length - 1; i++) {
          if (intArray[i] < intArray[i + 1]  && !trip) {
            tempArray.add(intArray[i]);
            trip = true;
          } else if (intArray[i] > intArray[i + 1]) {
            tempArray.add(intArray[i]);
          } else if (intArray[i] == intArray[i + 1] && !trip) {
            trip = true;
          } else {
            break ;
          }
      }
        if (tempArray.size() < intArray.length -1) {
          break ;
        }
        zaehler++;
      }
      line = reader.readLine();
    }
    System.out.println(zaehler);
  }
  public static boolean determineMode(int a, int b) {
    return a > b;
  }
}