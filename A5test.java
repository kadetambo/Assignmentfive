/**
 *
 * Kade Tambo
 * C202
 * Programming Assignment 5
 */
import java.util.*;
import java.io.*;


public class A5test {

    /**
     *This method outs puts the results for BinarySearchTree list methods. 
     * It displaying the averages and comparison of words found and words not found
     */
    public static void main(String[] args) {

        int WordsFound = 0;
        int WordsNotFound = 0;
        int ComparisonsofWordsFound = 0;
         int ComparisonsofWordsNotFound = 0;
        int i = 0;
        int[] count = new int[1];
        BinarySearchTree[] list = new BinarySearchTree[26];// replacce mylinked list with binary search tree
        for (i = 0; i < list.length; i++) {
            list[i] = new BinarySearchTree<String>();
        }

        try {
            File file = new File("random_dictionary.txt");
            Scanner f = new Scanner(file);
            while (f.hasNext() != false) {
                String word = f.next();
                word = word.toLowerCase();
                list[word.charAt(0) - 97].insert(word);
            }
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        try {
            File file = new File("oliver.txt");
            Scanner f = new Scanner(file);
            while (f.hasNext() == true) {
                String word = f.next();
                word = word.toLowerCase();
                word = word.replaceAll("[^A-Za-z]", "");

                if (!word.isEmpty()) {
                    WordsFound++;
                    if (list[word.charAt(0) - 97].search(word, count)) {
                        WordsFound++;
                        ComparisonsofWordsFound += count[0];
                    } else {
                        WordsNotFound++;
                        ComparisonsofWordsNotFound += count[0];
                    }
                }
            }
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
       int AverageComparisonWordsFound = (ComparisonsofWordsFound / WordsFound);
        int AverageComparisonWordsNotFound = (ComparisonsofWordsNotFound / WordsNotFound);
        System.out.println("The words found: " + WordsFound);
        System.out.println("Comparisons of words found: " + ComparisonsofWordsFound);
        System.out.println("The words not found: " + WordsNotFound);
        System.out.println("Comparisons of words not found: " + ComparisonsofWordsNotFound);
        System.out.println("The average words found in comparisons to words: "
                 + AverageComparisonWordsFound);
        System.out.println("The average of words not found in comparisons to words not found is: "
                 + AverageComparisonWordsNotFound);
    }
}

