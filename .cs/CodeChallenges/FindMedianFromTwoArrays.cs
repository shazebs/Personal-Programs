
public static double FindMedianSortedArrays(int[] nums1, int[] nums2)
{
    double FindMedianInOneArray(List<int> list)
    {
        list.Sort();
        // is even
        if (list.Count % 2 == 0)
            return (double)(list.ElementAt(list.Count / 2) + list.ElementAt((list.Count / 2) - 1)) / 2;
        // is odd
        else
            return list.ElementAt((list.Count / 2));
    }

    // if either array is empty 
    if (nums1.Length == 0)
        return FindMedianInOneArray(nums2.ToList());
    else if (nums2.Length == 0)
        return FindMedianInOneArray(nums1.ToList());

    return FindMedianInOneArray(nums1.Concat(nums2).ToList());
}

public static void Main(string[] args)
{
    int[] nums1 = new int[] { 1, 2 };
    int[] nums2 = { 3, 4 }; 
    Console.WriteLine(FindMedianSortedArrays(nums1, nums2)); 
    Console.ReadLine();
}
    
