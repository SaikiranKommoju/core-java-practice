package com.vsks.java8.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample1 {

    public static void main(String[] args) {
        int[] arr = {1, 34, 3, 98, 9, 76, 45, 4};

        //Sort the integers naturally (Asc order)
        int[] sortedArray = Arrays.stream(arr)
                .sorted()
                .toArray();
        System.out.println("Number in natural sorting order = " + Arrays.toString(sortedArray));

        //Arrange the numeric Strings in dictionary order
        Set<String> stringSet = new TreeSet<>();
        for (int i : arr) {
            stringSet.add(String.valueOf(i));
        }
        System.out.println("Numeric strings in dictionary order = " + stringSet);

        //Find the shortest possible number
        String shortest = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .sorted()
                .collect(Collectors.joining());
        System.out.println("Shortest possible num = " + shortest);

        //Find the longest possible number
        String longest = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
                .collect(Collectors.joining());
        System.out.println("Longest possible num = " + longest);

        //Remove duplicates from String and return in same order
        String s1 = "dabfcadef";
        String distinctChars = s1.chars()
                .distinct()
                .mapToObj(it -> String.valueOf((char) it))
                .collect(Collectors.joining());
        System.out.println("Distinct characters = " + distinctChars);

        //Find the word that has the highest length
        String s2 = "I am interested to grow in my organization";
        String lengthyWord = Arrays.stream(s2.split("\\s+"))
                .reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2)
                .get();
        System.out.println("Lengthy word = " + lengthyWord);

        //Find the word that has the nth highest length
        int n = 3;
        String nthHighestLengthyWord = Arrays.stream(s2.split("\\s+"))
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(n - 1)
                .findFirst().get();
        System.out.println("Nth highest length word = " + nthHighestLengthyWord);

        //Find the length of the longest word
        int longestWordLength = Arrays.stream(s2.split("\\s+"))
                .mapToInt(String::length)
                .max()
                .getAsInt();
        System.out.println("Longest word length = " + longestWordLength);

        //Find the length of nth longest word
        int nthLongestWordLength = Arrays.stream(s2.split("\\s+"))
                .mapToInt(String::length)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(n - 1)
                .findFirst().get();
        System.out.println("Nth longest word length = " + nthLongestWordLength);

        //Find the number of occurrence of each word
        String s3 = "the quick brown fox jumps right over the little lazy dog little aeiou";
        Map<String, Long> wordOccurrence = Arrays.stream(s3.split("\\s+")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Word-Occurrence = " + wordOccurrence);

        //Find the word with the maximum number of vowels
        String wordWithMoreVowels = Arrays.stream(s3.split("\\s+"))
                .reduce((it1, it2) -> (it1.replaceAll("[^aeiou]", "").length()) > (it2.replaceAll("[^aeiou]", "").length()) ? it1 : it2)
                .get();
        System.out.println("Word with more Vowels = " + wordWithMoreVowels);

        //Find the first non-repeated character
        String s4 = "The quick brown fox jumps over the lazy dog";
        String firstNonRepeatedChar = Arrays.stream(s4.split(""))
                .peek(it -> System.out.println("Char: " + it + " => First Index: " + s4.indexOf(it) + ", Last Index: " + s4.lastIndexOf(it)))
                .filter(it -> s4.indexOf(it) == s4.lastIndexOf(it))
                .findFirst().get();
        System.out.println("First non-repeated char = " + firstNonRepeatedChar);

        //Group odd and even numbers from array
        List<List<Integer>> oddEven = Arrays.stream(arr)
                .sorted()
                .boxed()
                .collect(Collectors.groupingBy(it -> it % 2 == 0))
                //.collect(Collectors.partitioningBy(it -> it % 2 == 0))
                .values()
                .stream()
                .collect(Collectors.toList());
        System.out.println("Odd & Even num list = " + oddEven);

        //Group the numbers by range
        int[] arr2 = {2, 34, 54, 23, 33, 20, 59, 11, 19, 37};
        Map<Integer, List<Integer>> rangeNumbers = Arrays.stream(arr2)
                .sorted()
                .boxed()
                .collect(Collectors.groupingBy(it -> ((it / 10) * 10), Collectors.toList()));
        System.out.println("Range-Num = " + rangeNumbers);

        //Form a list that should contain only integers
        List<String> alphaNumericEleList = Arrays.asList("as", "123", "32", "2as");
        List<Integer> numerics = alphaNumericEleList.stream()
                .map(it -> it.chars().filter(Character::isDigit).mapToObj(it3 -> String.valueOf((char) it3)).collect(Collectors.joining()))
                .filter(it4 -> null != it4 && !it4.isEmpty())
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println("Numeric = " + numerics);

        //Find the sum of unique elements in the array
        int[] arr4 = {5, 6, 7, 8, 5, 5, 8, 8, 7};
        int sum = Arrays.stream(arr4)
                .distinct()
                .sum();
        System.out.println("Unique ele sum = " + sum);

        Speech speech = new Speech();
        List<String> words = speech.paragraphs.stream()
                .flatMap(p -> p.sentences.stream())
                .flatMap(s -> s.words.stream())
                .collect(Collectors.toList());
        System.out.println("Words in Speech = " + words);

        List<String> sentences = Arrays.asList("My name is SaiKiran", "I'm a Software Developer in EPAM Systems - HYD", "My skills are Java 8, Spring Boot & Microservices");
        List<String> wordList = sentences.stream()
                .flatMap(s -> Stream.of(s.split("\\s+")))
                .collect(Collectors.toList());
        System.out.println("Words in Sentences = " + wordList);
    }
}

class Speech {
    List<Paragraph> paragraphs;
}

class Paragraph {
    List<Sentence> sentences;
}

class Sentence {
    List<String> words;
}