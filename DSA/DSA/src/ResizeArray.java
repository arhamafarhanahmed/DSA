public class ResizeArray {
    public static void main(String[] args) {
        // Original array
        int[] originalArray = {1, 2, 3, 4, 5};

        // New size for the array
        int newSize = 8;

        // Create a new array with the desired size
        int[] resizedArray = new int[newSize];

        // Copy the elements from the original array to the resized array
        for (int i = 0; i < originalArray.length; i++) {
            resizedArray[i] = originalArray[i];
        }

        // Print the resized array
        System.out.print("Resized Array: ");
        for (int i = 0; i < resizedArray.length; i++) {
            System.out.print(resizedArray[i] + " ");
        }
    }
}