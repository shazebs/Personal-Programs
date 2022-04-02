

static void Main(string[] args)
{
    int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    List<int> intList = toList(array); 
    returnList(intList, "print"); 
    array = returnList(intList, "return");
    printArray(array); 


    Console.ReadLine();
}





/* print the contents of a static array */ 
public static void printArray(int[] array) {
   
    foreach (var i in array) {
       
        Console.Write(i + " "); }
    
    Console.WriteLine(); }




/* turn a static array into a linklist */ 
public static List<int> toList(int[] array) {
    
    List<int> list = new List<int>(); 
    
    for (var n = 0; n < array.Length; n++) {
       
        list.Add(array[n]); }
   
    return list; }




/* either print linked list or return it back as a static array */ 
public static int[] returnList(List<int> list, string str) {
    
    if (str == "print") {
        
        Console.Write("[");
        
        int rep = 0;
        
        foreach (var item in list) {
            
            Console.Write($"{item}");
            
            if (++rep == list.Count) break;
            
            else Console.Write(","); }
        
        Console.WriteLine("]");
        
        return null; }
    
    else if (str == "return") {
        
        int[] A = new int[list.Count];
        
        for (var n = 0; n < list.Count; n++) {
            
            A[n] = list.ElementAt(n); }
        
        return A;}
    
    else return null; }



