public class subSetsSumTarget {
  public static void main(String[] args) {

    int[] arr = { 1, 2, 3, 4, 5, 6 };
    int target = 7;

    System.out.print("total subsets: " + countSubSets(arr, target));
  }

  private static int countSubSets(int[] arr, int target) {
    int n = arr.length;
    int totalSubSets = 1 << n;
    int count = 0;

    for (int i = 0; i < totalSubSets; i++) {
      int currSum = 0;
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0)
          currSum += arr[j];
      }
      if (currSum == target)
        count++;
    }
    return count;
  }

}