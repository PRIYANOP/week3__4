import java.util.*;

class Transaction {
    String id;
    double fee;
    String timestamp; // format HH:MM

    public Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", fee=" + fee +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

    public void display() {
        System.out.println(id + " | Fee: " + fee + " | Time: " + timestamp);
    }
}

public class TransactionSortingSystem {

    // 🔵 Bubble Sort (by fee)
    public static void bubbleSort(List<Transaction> list) {
        int n = list.size();
        int passes = 0, swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passes++;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {

                    // swap
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break; // early stop
        }

        System.out.println("\nBubble Sort Completed → Passes: " + passes + ", Swaps: " + swaps);
    }

    // 🟢 Insertion Sort (by fee + timestamp)
    public static void insertionSort(List<Transaction> list) {
        int n = list.size();

        for (int i = 1; i < n; i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            // sort by fee first, then timestamp
            while (j >= 0 &&
                    (list.get(j).fee > key.fee ||
                            (list.get(j).fee == key.fee &&
                                    list.get(j).timestamp.compareTo(key.timestamp) > 0))) {

                list.set(j + 1, list.get(j)); // shift
                j--;
            }

            list.set(j + 1, key);
        }

        System.out.println("\nInsertion Sort Completed (Fee + Timestamp)");
    }

    // 🔴 High fee detection
    public static void findHighFee(List<Transaction> list) {
        System.out.println("\nHigh-Fee Outliers (>50):");

        boolean found = false;
        for (Transaction t : list) {
            if (t.fee > 50) {
                t.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("None");
        }
    }

    // 🟡 Display
    public static void displayList(List<Transaction> list) {
        for (Transaction t : list) {
            System.out.println(t.id + ":" + t.fee + "@" + t.timestamp);
        }
    }

    // 🚀 MAIN
    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();

        // Sample Input
        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));

        System.out.println("Original Transactions:");
        displayList(transactions);

        // Decide sorting method
        int size = transactions.size();

        if (size <= 100) {
            bubbleSort(transactions);
        } else if (size <= 1000) {
            insertionSort(transactions);
        }

        System.out.println("\nSorted Transactions:"+transactions.toString());

        // High fee detection
        findHighFee(transactions);
    }
}