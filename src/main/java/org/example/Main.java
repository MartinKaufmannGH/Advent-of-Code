package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader;
    LinkedList<Integer> listOne = new LinkedList<>();
    LinkedList<Integer> listTwo = new LinkedList<>();
    File inp = new File("Day 1 Input");
    reader = new BufferedReader(new FileReader("Day 1 Input"));
    String line = reader.readLine();
    while (line != null) {
      listOne.add(Integer.parseInt(line.split(" {3}")[0]));
      listTwo.add(Integer.parseInt(line.split(" {3}")[1]));
      line = reader.readLine();
    }
    listOne.sort(Integer::compareTo);
    listTwo.sort(Integer::compareTo);

    Iterator<Integer> iteratorOne = listOne.iterator();
    Iterator<Integer> iteratorTwo = listTwo.iterator();

    Integer result = 0;
    while (iteratorOne.hasNext()) {
      //  System.out.println(iteratorOne.next());
      //  System.out.println(iteratorTwo.next());
      result += Math.abs( iteratorOne.next() - iteratorTwo.next());
    }
    System.out.println(result);
  }
}