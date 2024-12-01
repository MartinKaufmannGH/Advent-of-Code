package org.example;

import java.io.*;
import java.util.Iterator;
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
    //  Iterator<Integer> iteratorTwo = listTwo.iterator();

    Integer num = 0;
    Integer result = 0;
    while (iteratorOne.hasNext()) {
      Integer current = iteratorOne.next();
      num = Math.toIntExact(listTwo.stream().filter(c -> c.equals(current)).count());
      result += current * num;
    }
    System.out.println(result);
  }
}