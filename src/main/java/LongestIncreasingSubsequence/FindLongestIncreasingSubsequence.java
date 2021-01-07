package LongestIncreasingSubsequence;

public class FindLongestIncreasingSubsequence {

	static int max_ref;

	static int longestIncreasingSubsequence(int arr[], int n) {

		if (n == 1)
			return 1;

		int res, max_ending_here = 1;

		for (int i = 1; i < n; i++) {
			res = longestIncreasingSubsequence(arr, i);

			if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here)
				max_ending_here = res + 1;
		}

		if (max_ref < max_ending_here)
			max_ref = max_ending_here;

		return max_ending_here;
	}

	static int lisWrapper(int arr[], int n) {

		max_ref = 1;

		longestIncreasingSubsequence(arr, n);

		return max_ref;
	}

	public static void main(String args[]) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		System.out.println("Length of longest increasing subsequence is " + lisWrapper(arr, n) + "\n");
	}

}
