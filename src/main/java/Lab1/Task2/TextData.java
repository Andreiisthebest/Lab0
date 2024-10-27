package Lab1.Task2;

public class TextData {

    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;


    public TextData(String fileName, String text) {
        this.fileName = fileName;
        this.text = text;
        calculateTextMetrics();
    }


    private void calculateTextMetrics() {
        numberOfVowels = 0;
        numberOfConsonants = 0;
        numberOfLetters = 0;
        numberOfSentences = 0;
        longestWord = "";

        String[] words = text.split("\\s+");
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                numberOfLetters++;
                if (isVowel(c)) {
                    numberOfVowels++;
                } else {
                    numberOfConsonants++;
                }
            } else if (c == '.' || c == '!' || c == '?') {
                numberOfSentences++;
            }
        }
    }


    private boolean isVowel(char c) {
        char lower = Character.toLowerCase(c);
        return lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u';
    }

    // Getters
    public String getFileName() {
        return fileName;
    }

    public String getText() {
        return text;
    }

    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public int getNumberOfSentences() {
        return numberOfSentences;
    }

    public String getLongestWord() {
        return longestWord;
    }
}
