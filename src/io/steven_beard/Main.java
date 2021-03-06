package io.steven_beard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println(getLargestWordAndWordCount("./passage.txt"));
    }


    public static String getLargestWordAndWordCount(String filePath) throws IOException {
    /*
       Identifies the word in file with the maximum word length (largestWord)
       Once the word with maximum length has been identified,
       print the first sentence that contains that word (firstSentence)
       Identify the average word length of all words in the file (averageWordLength)
    */
        String[] sentenceToArray;
        String fileString = "";
        String largestword = "";
        String firstSentence = "";
        double wordCount = 0;
        double letterCount = 0;
        double averageWordLength;


        // Read File to String

            fileString = new String(Files.readAllBytes(Paths.get(filePath)));


        // Check file for punctuations that have no white space after them. Add white space
        // https://stackoverflow.com/questions/2973436/regex-lookahead-lookbehind-and-atomic-groups
        //Todo check for other edge cases, if the file is poorly written this script will not work correctly.
        String fixed = fileString.replaceAll("(?<=\\p{Ll})[.!?](?=\\p{Lu})", "[.!?] ");

        //convert string containing file to string [] split after boundary (\b)
        // string on .!? followed by any amount of white space (\s+)
        sentenceToArray = fixed.split("\\b[.!?]\\s+");
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
            }
        }
        averageWordLength = letterCount / wordCount;

        return "The largest word is " + largestword + "." + "\n" +
                "The first sentence using the largest word is \"" + firstSentence + ".\"" + "\n" +
                "The average word length is " + averageWordLength + " letters.";
    }
}

