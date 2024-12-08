package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LetterTest {

    @ParameterizedTest
    @ValueSource(chars = {'a', 'z', 'A', 'Z', 'M', 'n'})
    void shouldValidateCorrectLetters(char c) {
        Letter letter = new Letter(c);
        assertTrue(letter.isValid());
    }

    @ParameterizedTest
    @ValueSource(chars = {'1', '.', ',', ' ', '\t', '!'})
    void shouldNotValidateNonLetters(char c) {
        Letter letter = new Letter(c);
        assertFalse(letter.isValid());
    }

    @Test
    void shouldCorrectlyImplementEquals() {
        Letter letter1 = new Letter('a');
        Letter letter2 = new Letter('a');
        Letter letter3 = new Letter('b');

        assertEquals(letter1, letter2);
        assertNotEquals(letter1, letter3);
        assertEquals(letter1.hashCode(), letter2.hashCode());
    }

    @Test
    void shouldCorrectlyConvertToString() {
        Letter letter = new Letter('a');
        assertEquals("a", letter.toString());
    }
} 