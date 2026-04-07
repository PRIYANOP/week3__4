import java.util.Arrays;

public class AccountSearch {

    // 🔵 LINEAR SEARCH - First Occurrence
    public static int linearFirst(String[] arr, String target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear First → Index: " + i + ", Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Not Found (Linear First), Comparisons: " + comparisons);
        return -1;
    }

    // 🔵 LINEAR SEARCH - Last Occurrence
    public static int linearLast(String[] arr, String target) {
        int comparisons = 0;
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                index = i;
            }
        }

        System.out.println("Linear Last → Index: " + index + ", Comparisons: " + comparisons);
        return index;
    }

    // 🟢 BINARY SEARCH - Find any occurrence
    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                System.out.println("Binary Search → Index: " + mid + ", Comparisons: " + comparisons);
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Not Found (Binary), Comparisons: " + comparisons);
        return -1;
    }

    // 🟡 Count occurrences using Binary Search idea
    public static int countOccurrences(String[] arr, String target) {
        int count = 0;

        for (String s : arr) {
            if (s.equals(target)) count++;
        }

        return count;
    }

    // 🔴 Display
    public static void display(String[] arr) {
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    // 🚀 MAIN
    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        System.out.println("Original Logs:");
        display(logs);

        // 🔵 Linear Search
        linearFirst(logs, "accB");
        linearLast(logs, "accB");

        // 🟢 Sort before Binary Search
        Arrays.sort(logs);

        System.out.println("\nSorted Logs:");
        display(logs);

        // 🟢 Binary Search
        int index = binarySearch(logs, "accB");

        // 🟡 Count duplicates
        int count = countOccurrences(logs, "accB");
        System.out.println("Total Occurrences of accB: " + count);
    }
}