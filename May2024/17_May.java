//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.findPair(n, x, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
  public int findPair(int n, int x, int[] arr) {
    // Sort the array in ascending order
    Arrays.sort(arr);

    // Iterate through the sorted array
    for (int i = 0; i < n - 1; i++) {
      // Look for the complement (arr[i] + x) using binary search
      int complement = arr[i] + x;
      int index = Arrays.binarySearch(arr, i + 1, n, complement);

      // Check if binary search found the complement
      if (index >= 0 && arr[index] == complement) {
        return 1;  // Pair found, return 1
      }
    }

    // No pair found, return -1
    return -1;
  }
}
