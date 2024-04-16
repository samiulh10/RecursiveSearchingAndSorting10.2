public class Main {

    public static int[] randomIntGenerator(int minimum, int maximum, int length) {
        int[] ints = new int[length];

        for (int i = 0; i < length; i++) {
            ints[i] = (int)(Math.random() * (maximum - minimum + 1) + minimum);
        }
        return ints;
    }

    public static int binarySearch(int[] ints, int target, int left, int right) {
        int middle = (left + right) / 2;
        if (ints[middle] == target) return ints[middle];
        else if ()

    }
    public static void main(String[] args) {

        int[] randomInts = randomIntGenerator(2, 5, 3);

        for (int i: randomInts) {
            System.out.print(i);
        }

    }
}
