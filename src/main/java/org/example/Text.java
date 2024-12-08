package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a text composed of sentences.
 */
public class Text implements TextComponent {
    private final List<Sentence> sentences;

    /**
     * Creates a new Text instance.
     */
    public Text() {
        this.sentences = new ArrayList<>();
    }

    /**
     * Adds a sentence to the text.
     *
     * @param sentence the sentence to add
     */
    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    /**
     * Gets all interrogative sentences from the text.
     *
     * @return list of interrogative sentences
     */
    public List<Sentence> getInterrogativeSentences() {
        List<Sentence> interrogativeSentences = new ArrayList<>();
        for (Sentence sentence : sentences) {
            if (sentence.isInterrogative()) {
                interrogativeSentences.add(sentence);
            }
        }
        return interrogativeSentences;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}
