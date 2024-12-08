package org.example;

import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TextAnalyzerTest {

    @Test
    void shouldFindWordsInQuestions() {
        StringParser parser = new StringParser();
        Text text = parser.parseText("What time is it? The sky is blue. How are you?");
        
        TextAnalyzer analyzer = new TextAnalyzer(text);
        Set<String> words = analyzer.findUniqueWordsInQuestions(4);
        
        assertEquals(2, words.size());
        assertTrue(words.contains("What"));
        assertTrue(words.contains("time"));
    }

    @Test
    void shouldNotFindWordsInNonQuestions() {
        StringParser parser = new StringParser();
        Text text = parser.parseText("This is a test. Word has four letters.");
        
        TextAnalyzer analyzer = new TextAnalyzer(text);
        Set<String> words = analyzer.findUniqueWordsInQuestions(4);
        
        assertTrue(words.isEmpty());
    }

    @Test
    void shouldOnlyFindWordsOfSpecifiedLength() {
        StringParser parser = new StringParser();
        Text text = parser.parseText("What is your name? Who are you?");
        
        TextAnalyzer analyzer = new TextAnalyzer(text);
        Set<String> words = analyzer.findUniqueWordsInQuestions(4);
        
        assertEquals(3, words.size());
        assertTrue(words.contains("What"));
        assertTrue(words.contains("your"));
        assertTrue(words.contains("name"));
        assertFalse(words.contains("is"));
    }
} 