package org.example;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

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
    while (line != null) {
      intArray = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
      int[] sorted = intArray.clone();
      Arrays.sort(sorted);
      int[] sortedReverse = intArray.clone();
      for (int i = 0; i < sorted.length; i++) {
        sortedReverse[i] = sorted[sorted.length - 1 - i];
      }
      if (Arrays.equals(intArray, sortedReverse) || Arrays.equals(intArray, sorted)) {
        for (int j = 0; j < intArray.length - 1; j++) {
          safe = intArray[j] != intArray[j + 1] && Math.abs(intArray[j] - intArray[j + 1]) <= 3 ;
          if(!safe) {
            break;
          }
          System.out.println(intArray[j]);
          System.out.println(intArray[j+1]);
          System.out.println("-");
        }
        System.out.println(safe);
        if (safe) {
          zaehler++;
          System.out.println("***");
        }
      }
      line = reader.readLine();
      safe = false;
    }
    System.out.println(zaehler);
  }
}