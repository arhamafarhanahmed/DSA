
public class SecondMax {
    public static void main(String[] args) {
        int[] array = {5, 3, 9, 1, 6, 9}; // Example array

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        // Traverse the array to find the max and second max values
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                secondMax = max; // Update secondMax to the old max
                max = array[i];   // Update max to the new maximum
            } else if (array[i] > secondMax && array[i] < max) {
                secondMax = array[i]; // Update secondMax if we find a larger number than secondMax
            }
        }

        // Output the second maximum value
        System.out.println("Second maximum value: " + secondMax);
    }
}