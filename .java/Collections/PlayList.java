package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class holds code on how to use Linked Lists.
 * @author shazebs
 *
 */
public class PlayList
{
    // properties

    // constructor

    // methods

    /**
     * This main method demonstrates the 'ArrayList' and 'Iterator' objects.
     * @param args program's statements to execute program logic.
     */
    public static void main(String[] args)
    {
        System.out.println();

        // create a list of type integer
        List<Integer> integerList = new ArrayList<Integer>();
        // add 5 integers to that list
        integerList.add(Integer.valueOf(10));
        integerList.add(Integer.valueOf(20));
        integerList.add(Integer.valueOf(30));
        integerList.add(Integer.valueOf(40));
        integerList.add(Integer.valueOf(50));
        // print the first item of the list to the console
        System.out.println("The first item of the 'integerList' is: " + integerList.get(0));

        // Create a list of type string
        List<String> stringsList = new ArrayList<String>();
        // add 5 strings to that list
        stringsList.add(String.valueOf("A"));
        stringsList.add(String.valueOf("B"));
        stringsList.add(String.valueOf("C"));
        stringsList.add(String.valueOf("D"));
        stringsList.add(String.valueOf("E"));
        // print the first item of the list to the console
        System.out.println("The first item of the 'stringsList' is: " + stringsList.get(0));

        /* loops */
        // print integerList with a for loop
        for (Integer i : integerList)
        {
            System.out.printf("\nInteger Value: %d", i);
        }
        System.out.println();
        // print stringsList with a while loop
        Iterator<String> stringIterator = stringsList.iterator();
        while (stringIterator.hasNext())
        {
            System.out.printf("\nString value: %s", stringIterator.next());
        }
        System.out.println();
    }
}
