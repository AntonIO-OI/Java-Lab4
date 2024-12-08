package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {

    @Test
    void shouldParseSimpleSentence() {
        StringParser parser = new StringParser();
        Text text = parser.parseText("Hello world.");
        
        assertEquals("Hello world.", text.toString());
    }

    @Test
    void shouldHandleMultipleSpacesAndTabs() {
        StringParser parser = new StringParser();
        Text text = parser.parseText("Hello    world.\tTest\t\tsentence.");
        
        assertEquals("Hello world. Test sentence.", text.toString());
    }

    @Test
    void shouldPreservePunctuation() {
        StringParser parser = new StringParser();
        Text text = parser.parseText("Hello, world! How are you?");
        
        assertEquals("Hello, world! How are you?", text.toString());
    }

    @Test
    void shouldHandleEmptyInput() {
        StringParser parser = new StringParser();
        Text text = parser.parseText("");
        
        assertTrue(text.toString().isEmpty());
    }

    @Test
    void shouldAddPeriodToUnfinishedSentence() {
        StringParser parser = new StringParser();
        Text text = parser.parseText("Hello world");
        
        assertEquals("Hello world.", text.toString());
    }
} 