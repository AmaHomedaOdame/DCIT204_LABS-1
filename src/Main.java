public class Main {

    public static void main(String[] args) {

        // Read array size
        System.out.print("Enter array size: ");
        int size = readInt();

        // Fill array with user input
        int[] array = new int[size];
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = readInt();
        }

        // Get target value
        System.out.print("\nEnter target value: ");
        int target = readInt();

        // Linear Search
        int linearResult = Algorithms.linearSearch(array, target);
        System.out.println("\nLinear Search Result:");
        if (linearResult != -1) {
            System.out.println("Target found at index " + linearResult);
        } else {
            System.out.println("Target not found.");
        }

        // Sort a copy of the array for Binary Search (bubble sort)
        int[] sortedArray = new int[size];
        for (int i = 0; i < size; i++) {
            sortedArray[i] = array[i];
        }
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }

        // Binary Search
        int binaryResult = Algorithms.binarySearch(sortedArray, target);
        System.out.println("\nBinary Search Result:");
        if (binaryResult != -1) {
            System.out.println("Target found at index " + binaryResult);
        } else {
            System.out.println("Target not found.");
        }
    }

    static int readInt() {
        int result = 0;
        try {
            int b;
            // Skip any non-digit characters (spaces, newlines, etc.)
            while ((b = System.in.read()) < '0');
            // Now read the actual digits
            do {
                result = result * 10 + (b - '0');
                b = System.in.read();
            } while (b >= '0');
        } catch (Exception e) {
            System.out.println("Input error.");
        }
        return result;
    }

}