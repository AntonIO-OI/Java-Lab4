package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a sentence composed of words and symbols.
 */
public class Sentence implements TextComponent {
    private final List<TextComponent> parts;
    private boolean hasSpaceAfter;

    /**
     * Creates a new Sentence instance.
     */
    public Sentence() {
        this.parts = new ArrayList<>();
        this.hasSpaceAfter = false;
    }

    /**
     * Adds a part (word or symbol) to the sentence.
     * @param part component to add
     */
    public void addSentencePart(TextComponent part) {
        if (part instanceof Symbol && Character.isWhitespace(((Symbol) part).getValue())) {
            hasSpaceAfter = true;
            return;
        }
        parts.add(part);
        hasSpaceAfter = false;
    }

    /**
     * Checks if there's a space after the last component.
     * @return true if there's a space after the last component
     */
    public boolean hasSpaceAfter() {
        return hasSpaceAfter;
    }

    /**
     * Gets the last part of the sentence.
     * @return last component in sentence
     */
    public TextComponent getLastPart() {
        if (parts.isEmpty()) {
            return null;
        }
        return parts.get(parts.size() - 1);
    }

    /**
     * Checks if the sentence is empty.
     * @return true if sentence has no parts
     */
    public boolean isEmpty() {
        return parts.isEmpty();
    }

    /**
     * Gets all words from the sentence.
     * @return list of words
     */
    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (TextComponent part : parts) {
            if (part instanceof Word) {
                words.add((Word) part);
            }
        }
        return words;
    }

    /**
     * Checks if the sentence is interrogative.
     * @return true if ends with question mark
     */
    public boolean isInterrogative() {
        TextComponent lastPart = getLastPart();
        return lastPart instanceof Symbol && ((Symbol) lastPart).isQuestionMark();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        TextComponent lastPart = null;

        for (TextComponent part : parts) {
            if (part instanceof Word) {
                if (lastPart instanceof Word) {
                    sb.append(" ");
                }
            } else if (lastPart instanceof Symbol && !(part instanceof Word)) {
                sb.append(" ");
            }
            sb.append(part.toString());
            if (part instanceof Symbol && !(part instanceof Word)) {
                sb.append(" ");
            }
            lastPart = part;
        }
        return sb.toString().trim();
    }
} 