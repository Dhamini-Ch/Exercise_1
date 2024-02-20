public class FibonacciTest {

    public static void main(String[] args) {
        testFibonacci();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer N: ");
        int n = scanner.nextInt();

        try {
            int[] series = calculateFibonacci(n);
            int sum = calculateSum(series);

            System.out.println("Fibonacci series:");
            printSeries(series);
            System.out.println("Sum of the series: " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void testFibonacci() {
        int[][] testCases = {
                {5, 12, {0, 1, 1, 2, 3}},
                {0, 0, {}},
                {-5, -1, null},
                {"hello", -1, null}
        };

        for (int[] testCase : testCases) {
            int expectedSum = testCase[1];
            int[] expectedSeries = testCase[2];
            int[] actualSeries = calculateFibonacci(testCase[0]);
            int actualSum = calculateSum(actualSeries);

            String message = "Test case (" + testCase[0] + "): ";
            boolean passed = compareSeries(expectedSeries, actualSeries) && expectedSum == actualSum;
            System.out.println(message + (passed ? "Passed" : "Failed"));
        }
    }

    private static int[] calculateFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N must be non-negative");
        }

        int[] series = new int[n];
        if (n == 0) {
            return series;
        }
        series[0] = 0;
        series[1] = 1;
        for (int i = 2; i < n; i++) {
            series[i] = series[i - 1] + series[i - 2];
        }
        return series;
    }

    private static int calculateSum(int[] series) {
        int sum = 0;
        for (int num : series) {
            sum += num;
        }
        return sum;
    }

    private static void printSeries(int[] series) {
        for (int num : series) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static boolean compareSeries(int[] expected, int[] actual) {
        if (expected.length != actual.length) {
            return false;
        }
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                return false;
            }
        }
        return true;
    }
}
