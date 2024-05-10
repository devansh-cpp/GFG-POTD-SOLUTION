//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr); // Sort the array to handle duplicates
        backtrack(arr, n, k, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] arr, int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(current)); // Found a valid combination
            return;
        }

        for (int i = start; i < n; i++) {
            if (i > start && arr[i] == arr[i - 1]) // Skip duplicates
                continue;
            if (k - arr[i] < 0) // Optimization: stop early if the current number exceeds the target
                break;
            current.add(arr[i]);
            backtrack(arr, n, k - arr[i], i + 1, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}

