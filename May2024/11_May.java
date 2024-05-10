//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            StringBuilder out = new StringBuilder();
            ans = ob.jugglerSequence(n);
            for (int i = 0; i < ans.size(); i++) out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static List<Integer> jugglerSequence(int n) {
         List<Integer> sequence = new ArrayList<>();
        sequence.add(n); // Adding the first term to the sequence
        
        while (n != 1) {
            if (n % 2 == 0) {
                n = (int) Math.floor(Math.sqrt(n));
            } else {
                n = (int) Math.floor(Math.sqrt(n) * Math.sqrt(n) * Math.sqrt(n));
            }
            sequence.add(n); // Adding the next term to the sequence
        }
        
        return sequence;
    }
}
