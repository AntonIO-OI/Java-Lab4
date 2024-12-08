package org.example;

/**
 * Represents a single letter in text.
 * Immutable class that handles a single character validation and storage.
 */
public class Letter implements TextComponent {
    private final char value;

    /**
     * Creates a new Letter instance.
     *
     * @param value the character value of the letter
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Gets the character value of the letter.
     *
     * @return the letter's character value
     */
    public char getValue() {
        return value;
    }

    /**
     * Checks if the character is a valid letter.
     *
     * @return true if the character is a letter, false otherwise
     */
    public boolean isValid() {
        return Character.isLetter(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Letter letter = (Letter) obj;
        return value == letter.value;
    }

    @Override
    public int hashCode() {
        return Character.hashCode(value);
    }
} 