class Client {
    String name;
    int riskScore;
    double accountBalance;

    public Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    public void display() {
        System.out.println(name + " | Risk: " + riskScore + " | Balance: " + accountBalance);
    }
}

public class ClientRiskRanking {

    // 🔵 Bubble Sort (Ascending riskScore)
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {

                    // swap
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break; // optimization
        }

        System.out.println("\nBubble Sort (Ascending) → Swaps: " + swaps);
    }

    // 🟢 Insertion Sort (Descending riskScore + accountBalance)
    public static void insertionSort(Client[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            Client key = arr[i];
            int j = i - 1;

            // Descending by riskScore, if equal → higher balance first
            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].accountBalance < key.accountBalance))) {

                arr[j + 1] = arr[j]; // shift
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("\nInsertion Sort (Descending Risk + Balance) Done");
    }

    // 🔴 Display array
    public static void display(Client[] arr) {
        for (Client c : arr) {
            System.out.println(c.name + ":" + c.riskScore);
        }
    }

    // 🟡 Top 10 highest risk clients
    public static void topRiskClients(Client[] arr, int topN) {
        System.out.println("\nTop " + topN + " Highest Risk Clients:");

        for (int i = 0; i < Math.min(topN, arr.length); i++) {
            System.out.println(arr[i].name + "(" + arr[i].riskScore + ")");
        }
    }

    // 🚀 MAIN
    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 10000),
                new Client("clientB", 50, 7000)
        };

        System.out.println("Original Data:");
        display(clients);

        // 🔵 Bubble Sort (Ascending)
        bubbleSort(clients);
        System.out.println("\nAfter Bubble Sort:");
        display(clients);

        // 🟢 Insertion Sort (Descending)
        insertionSort(clients);
        System.out.println("\nAfter Insertion Sort:");
        display(clients);

        // 🔝 Top Risks
        topRiskClients(clients, 10);
    }
}