import java.util.Iterator;
import java.util.Stack;

/**
 * This class holds code on Stacks in Java.
 */
public class PlayStack
{
    /**
     * LAST IN FIRST OUT -
     * push()  - Inserts an element into the top from the Stack.
     * peek()  - Retrieves but does not remove the top element from the Stack.
     * pop()   - Retrieves and removes the top element from the Stack.
     * size()  - Returns the number of elements in the Stack.
     *
     * @param args (arguments)
     */
    public static void main(String[] args)
    {
        System.out.println();
        // instantiate a Stack collection container of type Integer
        Stack<Integer> integerStack = new Stack<Integer>();
        // add 5 integers to the list
        integerStack.push(-200);
        integerStack.push(-100);
        integerStack.push(0);
        integerStack.push(100);
        integerStack.push(300);

        // instantiate a Stack collection container of type String
        Stack<String> stringsStack = new Stack<String>();
        // add 5 strings to the list
        stringsStack.push("C++");
        stringsStack.push("Java");
        stringsStack.push("Python");
        stringsStack.push("JavaScript");
        stringsStack.push("C#");

        // print some details about integerStack
        System.out.printf("integerStack size = %d\nintegerStack value at second position = %d\n", integerStack.size(), integerStack.elementAt(1));
        // print integerStack toString
        System.out.println(integerStack);
        System.out.println();

        // use an Iterator to print stringsStack
        Iterator<String> itr = stringsStack.iterator();
        while (itr.hasNext())
        {
            System.out.println(stringsStack.pop());
        }
    }
}
