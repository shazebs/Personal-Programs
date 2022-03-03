import java.util.HashMap;
import java.util.Map;

/**
 * This class holds code on  how to use Hash Maps in Java.
 */
public class PlayMap
{
    /**
     * This main method demonstrates code on how to use the 'HashMap' and 'Map' library objects.
     *
     * @param args (arguments)
     */
    public static void main(String[] args)
    {
        System.out.println();
        // instantiate a HashMap of type Integer keyed by type Integer
        HashMap<Integer, Integer> integerMap = new HashMap<Integer, Integer>();
        // add 5 integers to the list
        integerMap.put(1, 9);
        integerMap.put(2, 8);
        integerMap.put(3, 7);
        integerMap.put(4, 6);
        integerMap.put(5, 5);

        // instantiate a HashMap of type String keyed by type Integer
        HashMap<Integer, String> stringsMap = new HashMap<Integer, String>();
        // add 5 strings to the list
        stringsMap.put(1, "One");
        stringsMap.put(2, "Two");
        stringsMap.put(3, "Three");
        stringsMap.put(4, "Four");
        stringsMap.put(5, "Five");
        stringsMap.put(6, "Six");

        // instantiate a HashMap of type String keyed by type String
        HashMap<String, String> namesMap = new HashMap<String, String>();
        // add 5 strings to the list
        namesMap.put("First Name", "Shazeb");
        namesMap.put("Last Name", "Suhail");
        namesMap.put("Age", "26");
        namesMap.put("Occupation", "Software Developer Student");
        namesMap.put("Country of Origin", "Pakistan");
        namesMap.put("Location", "Phoenix, Arizona");
        namesMap.put("Gender", "Male");


        /*  print some output   */
        // print the size of each HashMap
        System.out.printf("integerMap size = %d\n", integerMap.size());
        System.out.printf("stringsMap size = %d\n", stringsMap.size());
        System.out.printf("namesMap size = %d\n\n", namesMap.size());

        // print namesMap using a for loop
        for (Map.Entry<String, String> name : namesMap.entrySet())
        {
            System.out.printf("Key: %-20s Value: %s\n", name.getKey(), name.getValue());
        }
        System.out.println();
        // print stringsMap
        for (Map.Entry<Integer, String> item : stringsMap.entrySet())
        {
            System.out.printf("Key: %-3s Value: %s\n", item.getKey(), item.getValue());
        }
        System.out.println();
        // print integerMap
        for (Map.Entry<Integer, Integer> item : integerMap.entrySet())
        {
            System.out.printf("Key: %-3s Value: %s\n", item.getKey(), item.getValue());
        }
        System.out.println();

        // remove all items from each HashMap
        integerMap.clear();
        stringsMap.remove(1);
        stringsMap.clear();
        namesMap.clear();

    }
}
