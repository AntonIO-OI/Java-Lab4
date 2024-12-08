package org.example;

import java.util.Set;

/**
 * Main class that demonstrates the text processing functionality.
 */
public class Main {
    public static void main(String[] args) {
        String inputText = "What, is\t\t your \tname?     This is a,, test. How are,  you \t doing? Hello world!";
        int targetLength = 4;

        // Parse the text
        StringParser parser = new StringParser();
        Text text = parser.parseText(inputText);
        System.out.println(text);

        // Analyze the text
        TextAnalyzer analyzer = new TextAnalyzer(text);
        Set<String> uniqueWords = analyzer.findUniqueWordsInQuestions(targetLength);

        // Print results
        System.out.println("Unique words of length " + targetLength + " in interrogative sentences:");
        uniqueWords.forEach(System.out::println);
    }
}
