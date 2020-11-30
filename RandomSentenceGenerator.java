// Author: Shazeb Suhail
// Date:   11/29/20
// Time:   1:26 AM -> 8:31 PM
/*
Write an application that uses random-number generation to create sentences. Use four arrays of strings called
article, noun, verb, and preposition. Create a sentence by selecting a word at random from each array in the
following order: article, noun, verb, preposition, article, and noun. As each word is picked, concatenate it
to the previous words in the sentence. The words should be separated by spaces. When the final sentence is output,
it should start with a capital letter and end with a period. The application should generate and display 20
sentences.
The article array should contain the articles "the", "a", "one", "some", and "any";
the noun array should contain the nouns "boy", "girl", "dog", "town", and "car";
the verb array should contain the verbs "drove", "jumped", "ran", "walked", and "skipped";
the preposition array should contain the prepositions "to", "from", "over", "under", and "on".
 */

// class imports
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RandomSentenceGenerator {
    // Create Random number generator
    private static final SecureRandom randomNumbers = new SecureRandom();

    // start of main method
    public static void main(String[] args) {

        // create 4 String arrays: article, noun, verb, and preposition
        String[] article = {"the", "a", "one", "some", "any"};
        String[] noun = {"boy", "girl", "dog", "town", "car"};
        String[] verb = {"drove", "jumped", "ran", "walked", "skipped"};
        String[] preposition = {"to", "from", "over", "under", "on"};


        // create a loop of 20 times and display random sentences
        for (int count = 0; count < 20; count++) {
            System.out.printf("%2d) ", count+1);
            getRandomSentence(article,noun,verb,preposition);
            System.out.println();
        }

        // End Program.
        getLocalDateAndTime();
        System.exit(0);

    }

    // create a random sentence method
    public static void getRandomSentence
    (String[] article, String[] noun, String[] verb, String[] preposition) {

        // local variables
        int num; // to hold random number value
        StringBuilder buffer = new StringBuilder(); // to hold a random sentence via String.append()
        String spacebar = " ";
        String period = ".";

        // get first word from array 'article' at random
        num = randomNumbers.nextInt(5);
        // capitalize first letter of the sentence
        buffer.append(article[num].substring(0,1).toUpperCase())
                // print the remaining substring of the word
                .append(article[num].substring(1, article[num].length()))
                .append(spacebar);

        // get second word from array 'noun'
        num = randomNumbers.nextInt(5);
        buffer.append(noun[num]).append(spacebar);

        // get third word from array 'verb'
        num = randomNumbers.nextInt(5);
        buffer.append(verb[num]).append(spacebar);

        // get fourth word from array 'preposition'
        num = randomNumbers.nextInt(5);
        buffer.append(preposition[num]).append(spacebar);

        // get fifth word from array 'article'
        num = randomNumbers.nextInt(5);
        buffer.append(article[num]).append(spacebar);

        // get sixth word from array 'noun'
        num = randomNumbers.nextInt(5);
        buffer.append(noun[num]).append(period);

        // print buffer
        System.out.print(buffer.toString());

    }

    // method for getting local date/time
    public static void getLocalDateAndTime() {
        //
        System.out.printf("\nThank you for using the Random Sentences application.\n");
        System.out.printf("Time of calculation is <");
        // Get Local Date and Time.
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, YYYY h:mm a");
        System.out.print(dtf.format(localDate));
        System.out.println(">");
    }
}
