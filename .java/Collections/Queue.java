package app;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class holds code on how to use Queue containers.
 */
public class PlayQueue
{
    /**
     offer()   - inserts an element into the head of the Queue
     add()     - inserts an element into the head of the Queue
     peek()    - retrieves but does not remove from the head element of the Queue
     remove()  - retrieves and removes an element from the head of the Queue
     size()    - returns the number of elements in the Queue

     * PlayQueue main method.
     * @param args statements
     */
    public static void main(String[] args)
    {
        System.out.println();
        // instantiate a Queue of integer values
        Queue<Integer> integerQueue = new LinkedList<Integer>();
        // add 5 integers to the list
        integerQueue.add(26);
        integerQueue.add(27);
        integerQueue.add(28);
        integerQueue.add(29);
        integerQueue.add(30);

        // instantiate a Queue of string values
        Queue<String> stringsQueue = new LinkedList<String>();
        // add 5 strings to the list
        stringsQueue.add("Spider-Man");
        stringsQueue.add("Superman");
        stringsQueue.add("Batman");
        stringsQueue.add("The Hulk");
        stringsQueue.add("Hancock");

        // print integerQueue list using its "ToString" method
        System.out.println(integerQueue.toString());

        // print integerQueue's size and head values
        System.out.printf("integerQueue head = %d\nintegerQueue size = %d\n\n", integerQueue.peek(), integerQueue.size());

        // print the stringsQueue with an Iterator object
        Iterator<String> itr = stringsQueue.iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }
        System.out.println();
    }
}
