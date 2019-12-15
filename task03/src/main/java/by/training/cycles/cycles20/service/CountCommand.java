package by.training.cycles.cycles20.service;

// a_n = 1/((3n-1)(3n+1)) = 1/3 * (1/(3n-2) - 1/(3n+1)) =
// = 1/3 * (1 - 1/4 + 1/4 - 1/7 + 1/7 - 1/10 + ...)

public class CountCommand {
    public double exec(double eps) {
        double sum = 0;
        int n = 2;
        double a = 1;
        double b = 0.25;
        while (a - b >= eps) {
            sum = 1 - b;
            a = 1.0 / (3 * n - 2);
            b = 1.0 / (3 * n + 1);
            ++n;
        }
        return sum / 3;
    }
}
