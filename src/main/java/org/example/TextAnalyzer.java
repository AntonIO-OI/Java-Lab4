package org.example;

import java.util.HashSet;
import java.util.Set;

/**
 * Class for analyzing text and finding specific patterns.
 */
public class TextAnalyzer {
    private final Text text;

    /**
     * Creates a new TextAnalyzer instance.
     *
     * @param text the text to analyze
     */
    public TextAnalyzer(Text text) {
        this.text = text;
    }

    /**
     * Finds unique words of specified length in interrogative sentences.
     *
     * @param targetLength the length of words to find
     * @return set of unique words matching the criteria
     */
    public Set<String> findUniqueWordsInQuestions(int targetLength) {
        Set<String> uniqueWords = new HashSet<>();

        for (Sentence sentence : text.getInterrogativeSentences()) {
            for (Word word : sentence.getWords()) {
                if (word.length() == targetLength && word.isValid()) {
                    uniqueWords.add(word.toString());
                }
            }
        }

        return uniqueWords;
    }
}
