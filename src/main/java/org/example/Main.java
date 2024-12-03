package org.example;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    reader = new BufferedReader(new FileReader("Inputs/Day 2 Test"));
    String line = reader.readLine();
    ArrayList<Integer> intArray = new ArrayList<>();
    int zaehler = 0;
    Boolean safe = false;
    Boolean trip = false;
    Boolean mode;
    while (line != null) {
      //  var diff = getDifference(intArray);

      // var validAsc = buildValidAscList(intArray);
      // var validDesc = buildValidDescList(intArray);
      /*
      if (validAsc != null) {
        System.out.println(validAsc);
        zaehler++;
      } else if (validDesc != null) {
        System.out.println(validDesc);
        zaehler++;
      } else {
        for (int i = 0; i < intArray.length; i++) {
          System.out.print(intArray[i] + " ");
        }
        System.out.println();
      }
       */
      var tempArray = Arrays.stream(line.split(" ")).flatMapToInt(c -> IntStream.of(Integer.parseInt(c))).toArray();
      for (int i = 0; i < tempArray.length; i++) {
        intArray.add(tempArray[i]);
      }
      isSafe(intArray);
      line = reader.readLine();
    }
    //  System.out.println(zaehler);


    /*
    BufferedReader readerInput = new BufferedReader(new FileReader("Inputs/Day 3 Input"));
    String lineInput = readerInput.readLine();
    StringBuilder processed = new StringBuilder();
    StringBuilder inputInput = new StringBuilder();
    int i = 0;
    while (lineInput != null) {
      inputInput.append(lineInput);
      lineInput = readerInput.readLine();
    }
    Matcher matcherPreProcesser = Pattern.compile("(?<=do\\(\\))(.*?)(?=don't\\(\\)|$)").matcher(inputInput);
    while (matcherPreProcesser.find()) {
      processed.append(matcherPreProcesser.group());
    }
    Matcher matcherInput = Pattern.compile("(?<=mul\\()[0-9]{1,3},[0-9]{1,3}(?=\\))").matcher(processed);
    while (matcherInput.find()) {
      var elementArr = processed.substring(matcherInput.start(), matcherInput.end()).split(",");
      i += getMult(elementArr[0],elementArr[1]);
    }
    System.out.println(i);
     */
  }



  public static boolean determineMode(int a, int b) {
    return a > b;
  }

  public static List<Integer> getDifference(int[] input) {

    List<Integer> difference = new ArrayList<>();
    for (int i = 0; i < input.length - 1; i++) {
      difference.add((input[i] - input[i + 1]) * -1);
    }
    return difference;
  }

  public static List<Integer> buildValidAscList(int[] input) {
    List<Integer> list = new ArrayList<>();
    ArrayList<Integer> arr = new ArrayList<>();
    for (int i = 0; i < input.length; i++) {
      arr.add(input[i]);
    }
    int i = 0;
    while( i < arr.size() - 1) {
      var num1 = arr.get(i);
      var num2 = arr.get(i + 1);
      if (num1 < num2 && Math.abs(num1 - num2) <= 3) {
        i++;
      } else {
        arr.remove(num2);
      }
    }
    arr.stream().distinct().forEach(list::add);
    System.out.println("List Asc");
    System.out.println(list);
    if (list.size() >= input.length - 1) {
      return list;
    } else {
      return null;
    }
  }

  public static List<Integer> buildValidDescList(int[] input) {
    List<Integer> list = new ArrayList<>();
    ArrayList<Integer> arr = new ArrayList<>();
    for (int i = 0; i < input.length; i++) {
      arr.add(input[i]);
    }
    int i = 0;
    while( i < arr.size() - 1) {
      var num1 = arr.get(i);
      var num2 = arr.get(i + 1);
      if (num1 > num2 && Math.abs(num1 - num2) <= 3) {
        i++;
      } else {
        arr.remove(num2);
      }
    }
    arr.stream().distinct().forEach(list::add);
    System.out.println("List Des");
    System.out.println(list);
    System.out.println(list.size());
    System.out.println(input.length - 1);
    if (list.size() >= input.length - 1) {
      return list;
    } else {
      return null;
    }
  }

  public static Integer getMult(String einsInp, String zweiInp) {
    Integer eins = Integer.parseInt(einsInp);
    Integer zwei = Integer.parseInt(zweiInp);
    return eins * zwei;
  }

  public static Boolean isSafe(ArrayList<Integer> input) {

    ArrayList<Integer> sorted = input;
    Collections.sort(sorted);
    ArrayList<Integer> reverse = sorted;
    Collections.reverse(reverse);
    Integer i = 0;
    if ( input.equals(sorted) || input.equals(reverse)) {
      ArrayList<Integer> temp = new ArrayList<>();
      input.stream().distinct().forEach(temp::add);

      if (temp.size() == input.size()) {
        return true;
      } else {
        return madeSafe(input, i);
      }
    } else {
      return madeSafe(input, i);
    }
  }
  public static Boolean madeSafe(ArrayList<Integer> input, Integer i) {
    var temp = input;
    if (i < input.size()) {
      temp.remove(i);
      if (!isSafe(temp)) {
        i++;
        return madeSafe(temp, i);
      } else {
        return true;
      }
    } else {
      return false;
    }

  }
}