
package lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolutionsLesson2 {
  private static final String WORD_REGEXP = "[- .:,]+";

  public void runExercises() throws IOException {
    System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 2");
    System.out.println("Running exercise 1 solution...");
    exercise1();
    System.out.println("Running exercise 2 solution...");
    exercise2();
    System.out.println("Running exercise 3 solution...");
    exercise3();
    System.out.println("Running exercise 4 solution...");
    exercise4();
    System.out.println("Running exercise 5 solution...");
    exercise5();
    System.out.println("Running exercise 6 solution...");
    exercise6();
    System.out.println("Running exercise 7 solution...");
    exercise7();
  }

  /**
   * Exercise 1
   *
   * Create a new list with all the strings from original list converted to
   * lower case and print them out.
   */
  private void exercise1() {
    List<String> list = Arrays.asList(
        "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

    List<String> newList = list.stream()
        .map(String::toLowerCase)
        .collect(Collectors.toList());

    newList.forEach(System.out::println);
  }

 
  private void exercise2() {
    List<String> list = Arrays.asList(
        "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

    List<String> newList = list.stream()
        .filter(w -> w.length() % 2 == 1)
        .map(String::toLowerCase)
        .collect(Collectors.toList());

    newList.forEach(System.out::println);
  }


  private void exercise3() {
    List<String> list = Arrays.asList(
        "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

    String merged = list.stream()
        .skip(1)
        .limit(3)
        .collect(Collectors.joining("-"));
    System.out.println(merged);
  }

 private void exercise4() throws IOException {
    try (BufferedReader reader = 
        Files.newBufferedReader(Paths.get("SonnetI.txt"))) {
      long lineCount = reader.lines().count();
      System.out.println("Number of lines = " + lineCount);
    }
  }

  private void exercise5() throws IOException {
    try (BufferedReader reader = 
        Files.newBufferedReader(Paths.get("SonnetI.txt"))) {

      List<String> uniqueWords = reader.lines()
          .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
          .distinct()
          .collect(Collectors.toList());

      uniqueWords.stream()
          .forEach(System.out::println);
    }
  }

  private void exercise6() throws IOException {
    try (BufferedReader reader = 
        Files.newBufferedReader(Paths.get("SonnetI.txt"))) {

      List<String> words = reader.lines()
          .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
          .map(String::toLowerCase)
          .distinct()
          .sorted()
          .collect(Collectors.toList());

      words.stream().forEach(System.out::println);
    }
  }

  
  private void exercise7() throws IOException {
    try (BufferedReader reader = 
        Files.newBufferedReader(Paths.get("SonnetI.txt"))) {

      List<String> words = reader.lines()
          .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
          .map(String::toLowerCase)
          .distinct()
          .sorted((a, b) -> a.length() - b.length())
          .collect(Collectors.toList());

      words.stream().forEach(System.out::println);
    }
  }

  public static void main(String[] args) throws IOException {
    SolutionsLesson2 lesson = new SolutionsLesson2();
    lesson.runExercises();
  }
}

