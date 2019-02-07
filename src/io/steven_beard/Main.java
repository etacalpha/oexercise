package io.steven_beard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {

    public static void main(String[] args) {

        getLargestWordAndWordCount();
    }


    private static void getLargestWordAndWordCount() {
    /*
       Identifies the word in file with the maximum word length (largestWord)
       Once the word with maximum length has been identified,
       print the first sentence that contains that word(firstSentence)
       Identify the average word length of all words in the file(averageWordLength)
    */
        String[] sentenceToArray;
        String fileString = "";
        String largestword = "";
        String firstSentence = "";
        int wordCount = 0;
        int letterCount = 0;
        int averageWordLength;

        // Read File to String
        try {
            fileString = new String(Files.readAllBytes(Paths.get("./passage.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //convert string containing file to string [] split after boundary (\b)
        // string on .!? followed by any amount of white space (\s+)
        sentenceToArray = fileString.split("\\b[.!?]\\s+");
        for (String s : sentenceToArray) {
            // first loop returns sentences from file
            for (String a : s.split(" ")) {
                // Second loop evaluates each word in sentence for size
                if (largestword.length() < a.length()) {
                    largestword = a;
                }
                wordCount++;
                letterCount += a.length();
            }
            if (s.contains(largestword)) {
                firstSentence = s;
                break;
            }
        }
        averageWordLength = letterCount / wordCount;

        System.out.println("The largest word is: " + largestword);
        System.out.println("The first sentence using the largest word is: " + firstSentence);
        System.out.println("The average word length is: " + averageWordLength);
    }
}
