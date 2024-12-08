package org.example;

/**
 * Class which converts String into Text object.
 * @see Text
 */
public class StringParser {
    private Text text;
    private Word word;
    private Sentence sentence;

    /**
     * Converts string into Text object. Removes punctuation marks duplicates,
     * replaces tabulation with space.
     * @param input string text to convert
     * @return Text
     */
    public Text parseText(String input) {
        text = new Text();
        word = new Word();
        sentence = new Sentence();

        for (char c : input.toCharArray()) {
            if (isLetter(c)) {
                word.addLetter(new Letter(c));
                continue;
            }

            if (!word.isEmpty()) {
                sentence.addSentencePart(word);
                word = new Word();
            }

            Symbol symbol = new Symbol(c);

            if (canSkipSymbol(symbol)) {
                continue;
            }

            sentence.addSentencePart(symbol);

            if (isSentenceEnd(c)) {
                text.addSentence(sentence);
                sentence = new Sentence();
            }
        }

        if (!word.isEmpty()) {
            sentence.addSentencePart(word);
        }

        if (!sentence.isEmpty()) {
            sentence.addSentencePart(new Symbol('.'));
            text.addSentence(sentence);
        }

        return text;
    }

    /**
     * Checks if symbol can be skipped. Returns true if this symbol is already in last place in sentence.
     * Returns true if sentence is empty and symbol isn't space, else return false.
     * @param symbol symbol to check
     * @return boolean
     */
    private boolean canSkipSymbol(Symbol symbol) {
        if (Character.isWhitespace(symbol.getValue())) {
            TextComponent lastPart = sentence.getLastPart();
            return lastPart == null || (lastPart instanceof Word && sentence.hasSpaceAfter());
        }

        if (sentence.isEmpty()) {
            return true;
        }
        
        return sentence.getLastPart().equals(symbol);
    }

    /**
     * Checks if character is letter of English alphabet.
     * @param c character to check
     * @return boolean
     */
    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    /**
     * Check if character is sentence end (symbols '.', '?' or '!').
     * @param c character to check
     * @return boolean
     */
    private boolean isSentenceEnd(char c) {
        return c == '.' || c == '!' || c == '?';
    }
}
