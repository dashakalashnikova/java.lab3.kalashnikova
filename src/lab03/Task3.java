package lab03;


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

  
    static void printResults(double eps) {
        System.out.print("eps:" + eps + " result:");
        try {
            System.out.println(sum(eps));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
