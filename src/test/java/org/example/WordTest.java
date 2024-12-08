package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {

    @Test
    void shouldBuildWordCorrectly() {
        Word word = new Word();
        word.addLetter(new Letter('t'));
        word.addLetter(new Letter('e'));
        word.addLetter(new Letter('s'));
        word.addLetter(new Letter('t'));

        assertEquals("test", word.toString());
        assertEquals(4, word.length());
    }

    @Test
    void shouldBeEmptyInitially() {
        Word word = new Word();
        assertTrue(word.isEmpty());
        assertEquals(0, word.length());
    }

    @Test
    void shouldValidateCorrectWord() {
        Word word = new Word();
        word.addLetter(new Letter('a'));
        word.addLetter(new Letter('b'));
        word.addLetter(new Letter('c'));

        assertTrue(word.isValid());
    }

    @Test
    void shouldNotValidateWordWithNonLetters() {
        Word word = new Word();
        word.addLetter(new Letter('a'));
        word.addLetter(new Letter('1'));
        word.addLetter(new Letter('c'));

        assertFalse(word.isValid());
    }

    @Test
    void shouldProvideUnmodifiableLetterList() {
        Word word = new Word();
        word.addLetter(new Letter('a'));

        assertThrows(UnsupportedOperationException.class, () -> 
            word.getLetters().add(new Letter('b'))
        );
    }
} 