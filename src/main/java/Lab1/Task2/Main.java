package Lab1.Task2;

import java.io.IOException;
import java.io.FileNotFoundException;
public class Main {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Please provide a file path as a command-line argument.");
            return;
        }

        String filePath = args[0];
        try {

            String fileContent = MyFileReader.readFile(filePath);


            TextData textData = new TextData(filePath, fileContent);


            System.out.println("File Name: " + textData.getFileName());
            System.out.println("Text: " + textData.getText());
            System.out.println("Number of Vowels: " + textData.getNumberOfVowels());
            System.out.println("Number of Consonants: " + textData.getNumberOfConsonants());
            System.out.println("Number of Letters: " + textData.getNumberOfLetters());
            System.out.println("Number of Sentences: " + textData.getNumberOfSentences());
            System.out.println("Longest Word: " + textData.getLongestWord());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
