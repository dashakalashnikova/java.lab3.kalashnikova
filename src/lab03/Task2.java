package lab03;

/**
 * Lab 03, Task 2 (Variant 6, Table 2 Task 7)
 * Expression:
 * x(t, i) = ln(t),                        if i = 1, 2
 * x(t, i) = \sum_{k=1}^{i} (sin(t) / k),  if i > 2
 *
 * @author Kalashnikova
 */
public class Task2 {

    /**
     * Entry point. Tests the method {@code x(t, i)} by calling the helper
     * method {@code printResults(t, i)} few times with different arguments.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        printResults(1.0, 1);
        printResults(Math.E, 1);
        printResults(2.0, 2);
        printResults(0.5, 2);
        printResults(Math.PI / 2, 3);
        printResults(0.0, 4);
        printResults(Math.PI / 6, 5);
        printResults(-1.5, 10);
        printResults(1.0, 0);
        printResults(2.0, -3);
        printResults(0.0, 1);
        printResults(-5.0, 1);
        printResults(-2.5, 2);
        printResults(Double.NaN, 3);
        printResults(Double.POSITIVE_INFINITY, 1);
        printResults(Double.NEGATIVE_INFINITY, 4);
    }

    /**
     * Calculates the value of function x(t, i). Special cases:
     * <ul><li>If parameter i is less than 1, then exception
     * IllegalArgumentException is thrown.</li>
     * <li>If argument t is not a finite number (NaN or Infinity), then exception
     * IllegalArgumentException is thrown.</li>
     * <li>If (i == 1 || i == 2) and t <= 0, then exception
     * IllegalArgumentException is thrown because ln(t) requires t > 0.</li></ul>
     *
     * @param t function argument.
     * @param i function parameter (i >= 1).
     * @return value of x(t, i).
     * @exception IllegalArgumentException if i < 1, t is NaN/Infinite, or t <= 0 when i = 1, 2.
     */
    public static double x(double t, int i) {
        if (i < 1) {
            throw new IllegalArgumentException("param i = " + i);
        }
        if (Double.isNaN(t) || Double.isInfinite(t)) {
            throw new IllegalArgumentException("param t = " + t);
        }

        if (i == 1 || i == 2) {
            if (t <= 0) {
                throw new IllegalArgumentException("param t = " + t + " for i = " + i);
            }
            return Math.log(t);
        } else {
            double sum = 0.0;
            double sinT = Math.sin(t);
            for (int k = 1; k <= i; k++) {
                sum += sinT / k;
            }
            return sum;
        }
    }

    /**
     * Helper method for printing result of {@code x(t, i)}.
     *
     * @param t function argument.
     * @param i function parameter.
     */
    static void printResults(double t, int i) {
        System.out.print("t:" + t + " i:" + i + " result:");
        try {
            System.out.println(x(t, i));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
