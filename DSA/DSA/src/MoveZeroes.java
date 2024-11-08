public class MoveZeroes {
    public static void main(String[] args) {
        int[] array = {0, 1, 9, 0, 3, 12, 0}; // Example array

        int n = array.length; // Get the length of the array
        int j = 0; // Index to track the position of non-zero elements

        // Move all non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (array[i] != 0) {
                // Swap non-zero element with the element at index j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j++; // Increment j to the next position for non-zero element
            }
        }

        // Print the modified array
        System.out.print("Array after moving zeroes to the end: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}