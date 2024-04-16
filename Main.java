public class Main {

    public static void printArray(int[] ints) {
        for (int i : ints) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

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
        else if (left > right) return -1;
        if (ints[middle] > target) {
            return binarySearch(ints, target, left, middle - 1);

        }
        if (target > ints[middle]) {
            return binarySearch(ints, target, middle + 1, right);
        }
        return -1;

    }

    public static void merge(int[] ints, int from, int mid, int to, int[] temp) {
        int i = from;
        int j = mid + 1;
        int k = from;

        while (i <= mid && j <= to) {
            if (ints[i] < ints[j]) {
                temp[k] = ints[i];
                i++;
            }
            else {
                temp[k] = ints[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = ints[i];
            i++;
            k++;
        }
        while (j <= to) {
            temp[k] = ints[j];
            j++;
            k++;
        }
        for (k = from; k <= to; k++) {
            ints[k] = temp[k];
        }
    }

    public static void mergeHelper(int[] ints, int from, int to, int[] temp) {
        if (from < to) {
            int middle = (from + to) / 2;
            mergeHelper(ints, from, middle, temp);
            mergeHelper(ints, middle + 1, to, temp);
            merge(ints, from, middle, to, temp);
        }
    }


    public static int iterativeBinarySearch(int[] ints, int target) {
        int left = 0;
        int right = ints.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (ints[middle] == target) return middle;
            else if (ints[middle] < target) {
                left = middle + 1;
            } else if (ints[middle] > target) {
                right = middle - 1;
            }

        }

        return -1;
    }

    public static void main(String[] args)      {

        int[] randomInts = randomIntGenerator(0, 20, 10);

        int[] binaryTestInts = new int[] {1, 3, 5, 7, 9, 9, 11};

        System.out.println(binarySearch(binaryTestInts, 2, 0, 7));
        System.out.println(binarySearch(binaryTestInts, 9, 0, 7));

        mergeHelper(randomInts, 0, randomInts.length - 1, new int[randomInts.length]);

        printArray(randomInts);

        System.out.println(binarySearch(randomInts, 5, 0, randomInts.length - 1));
        System.out.println(iterativeBinarySearch(binaryTestInts, 5));





    }

    }
