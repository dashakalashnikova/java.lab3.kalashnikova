package lab03;

/**
 * Lab 03, Task 3 (Variant 6, Table 2 Task 13)
 * Expression: \sum_{i=1}^{\infty} \frac{(-1)^i}{i!}, eps > 0
 *
 * @author Kalashnikova
 */
public class Task3 {

    /**
     * Entry point. Tests the method {@code sum(eps)} by calling the helper
     * method {@code printResults(eps)} few times with different arguments.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        printResults(1.5);
        printResults(0.5);
        printResults(0.1);
        printResults(0.01);
        printResults(0.001);
        printResults(1e-5);
        printResults(1e-7);
        printResults(1e-12);
        printResults(1e-15);
        printResults(0.0);
        printResults(-0.01);
        printResults(-1e-5);
        printResults(Double.NaN);
        printResults(Double.POSITIVE_INFINITY);
        printResults(Double.NEGATIVE_INFINITY);
    }

    /**
     * Calculates the infinite series sum: \sum_{i=1}^{\infty} (-1)^i / i! with precision eps.
     * Special cases:
     * <ul><li>If parameter eps is less than or equal to 0, or is not a finite number,
     * then exception IllegalArgumentException is thrown.</li></ul>
     *
     * @param eps precision threshold (eps > 0).
     * @return sum of the infinite series.
     * @exception IllegalArgumentException if eps <= 0, or eps is NaN/Infinite.
     */
    public static double sum(double eps) {
        if (Double.isNaN(eps) || Double.isInfinite(eps) || eps <= 0.0) {
            throw new IllegalArgumentException("param eps = " + eps);
        }

        double total = 0.0;
        int i = 1;
        double term = -1.0; // (-1)^1 / 1! = -1.0

        while (Math.abs(term) >= eps) {
            total += term;
            i++;
            term = -term / i;
        }

        return total;
    }

    /**
     * Helper method for printing result of {@code sum(eps)}.
     *
     * @param eps precision threshold.
     */
    static void printResults(double eps) {
        System.out.print("eps:" + eps + " result:");
        try {
            System.out.println(sum(eps));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
