package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a word composed of letters.
 * Maintains a list of letters and provides word-specific operations.
 */
public class Word implements TextComponent {
    private final List<Letter> letters;

    /**
     * Creates a new Word instance.
     */
    public Word() {
        this.letters = new ArrayList<>();
    }

    /**
     * Adds a letter to the word.
     *
     * @param letter letter to add
     */
    public void addLetter(Letter letter) {
        letters.add(letter);
    }

    /**
     * Gets an unmodifiable view of the letters in this word.
     *
     * @return list of letters
     */
    public List<Letter> getLetters() {
        return Collections.unmodifiableList(letters);
    }

    /**
     * Checks if the word is empty.
     *
     * @return true if word has no letters
     */
    public boolean isEmpty() {
        return letters.isEmpty();
    }

    /**
     * Gets the length of the word.
     *
     * @return number of letters in the word
     */
    public int length() {
        return letters.size();
    }

    /**
     * Checks if the word contains only valid letters.
     *
     * @return true if all characters are letters
     */
    public boolean isValid() {
        return letters.stream().allMatch(Letter::isValid);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(letters.size());
        for (Letter letter : letters) {
            sb.append(letter.getValue());
        }
        return sb.toString();
    }
}
