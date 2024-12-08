package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SymbolTest {

    @Test
    void shouldIdentifyQuestionMark() {
        Symbol symbol = new Symbol('?');
        assertTrue(symbol.isQuestionMark());
    }

    @Test
    void shouldNotIdentifyOtherMarksAsQuestionMark() {
        Symbol symbol = new Symbol('.');
        assertFalse(symbol.isQuestionMark());
    }

    @ParameterizedTest
    @ValueSource(chars = {' ', '\t', '\n', '\r'})
    void shouldIdentifyWhitespace(char c) {
        Symbol symbol = new Symbol(c);
        assertTrue(symbol.isWhitespace());
    }

    @ParameterizedTest
    @ValueSource(chars = {'.', ',', '!', '?', 'a'})
    void shouldNotIdentifyNonWhitespaceAsWhitespace(char c) {
        Symbol symbol = new Symbol(c);
        assertFalse(symbol.isWhitespace());
    }

    @Test
    void shouldCorrectlyImplementEquals() {
        Symbol symbol1 = new Symbol(',');
        Symbol symbol2 = new Symbol(',');
        Symbol symbol3 = new Symbol('.');

        assertEquals(symbol1, symbol2);
        assertNotEquals(symbol1, symbol3);
        assertEquals(symbol1.hashCode(), symbol2.hashCode());
    }
} 