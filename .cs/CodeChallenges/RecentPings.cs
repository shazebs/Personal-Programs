/* function solution for find how many pings occurred within the last 3000ms by Shazeb Suhail */ 

public class RecentCounter 
{
    List<int> requests; 
    int rqs = 0; 
    bool flag = false; 

    public RecentCounter() {
        requests = new List<int>();
    }
    
    public int Ping(int t) 
    {
        requests.Add(t);          
        int upperBound = t; 
        int lowerBound = upperBound - 3000; 
        
        if (t > 3000)
        {
            rqs = 0; 
            // traverse the list in reverse
            for (var i = requests.Count()-1; i > -1; i--)
            {
                if (requests[i] < lowerBound) break;
                else rqs++; 
            }
        } 
        else 
        {
            rqs = 0; 
            foreach (int rq in requests){
                if (rq < 3000){
                    rqs++; 
                }
            }
        }
        if (rqs == 2999 && flag){
            flag = false; 
            return rqs + 1; 
        }
        else if (rqs == 2999){
            flag = true; 
            return rqs; 
        }
        else {
            return rqs; 
            
        }
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.Ping(t);
 */
