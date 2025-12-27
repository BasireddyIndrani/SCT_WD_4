import java.util.Scanner;

public class SearchSortAlgo {

    Scanner sc = new Scanner(System.in);
    int[] arr;
    int n;

    public static void main(String[] args) {
        SearchSortAlgo obj = new SearchSortAlgo();
        obj.menu();
    }

    void menu() {
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Enter Array");
            System.out.println("2. Linear Search");
            System.out.println("3. Binary Search");
            System.out.println("4. Bubble Sort");
            System.out.println("5. Insertion Sort");
            System.out.println("6. Selection Sort");
            System.out.println("7. Merge Sort");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    inputArray();
                    break;
                case 2:
                    linearSearch();
                    break;
                case 3:
                    bubbleSort();
                    binarySearch();
                    break;
                case 4:
                    bubbleSort();
                    printArray();
                    break;
                case 5:
                    insertionSort();
                    printArray();
                    break;
                case 6:
                    selectionSort();
                    printArray();
                    break;
                case 7:
                    mergeSort(0, n - 1);
                    printArray();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 8);
    }

    void inputArray() {
        System.out.print("Enter number of elements: ");
        n = sc.nextInt();
        arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
    }

    void linearSearch() {
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at index " + i);
                return;
            }
        }
        System.out.println("Element not found");
    }

    void binarySearch() {
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                System.out.println("Element found at index " + mid);
                return;
            } else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        System.out.println("Element not found");
    }

    void bubbleSort() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    void insertionSort() {
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    void selectionSort() {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            int t = arr[min];
            arr[min] = arr[i];
            arr[i] = t;
        }
    }

    void mergeSort(int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(l, m);
            mergeSort(m + 1, r);
            merge(l, m, r);
        }
    }

    void merge(int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }

    void printArray() {
        System.out.println("Array:");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
