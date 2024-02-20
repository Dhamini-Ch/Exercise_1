import java.util.Scanner;
public class Fibonacci {

    public static void main(String[] args) {
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
}