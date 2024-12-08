package org.example;

/**
 * Represents a punctuation mark or symbol in text.
 * Immutable class that handles punctuation marks and special characters.
 */
public class Symbol implements TextComponent {
    private final char value;

    /**
     * Creates a new Symbol instance.
     *
     * @param value the character value of the symbol
     */
    public Symbol(char value) {
        this.value = value;
    }

    /**
     * Gets the character value of the symbol.
     *
     * @return the symbol's character value
     */
    public char getValue() {
        return value;
    }

    /**
     * Checks if the character is a question mark.
     *
     * @return true if the symbol is a question mark, false otherwise
     */
    public boolean isQuestionMark() {
        return value == '?';
    }

    /**
     * Checks if the symbol is a whitespace character.
     *
     * @return true if the symbol is a whitespace, false otherwise
     */
    public boolean isWhitespace() {
        return Character.isWhitespace(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Symbol symbol = (Symbol) obj;
        return value == symbol.value;
    }

    @Override
    public int hashCode() {
        return Character.hashCode(value);
    }
} 