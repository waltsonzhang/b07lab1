public class Polynomial {
    private double[] coeffs;
    public Polynomial() {
        coeffs = new double[]{0};
    }
    public Polynomial(double[] coeffs) {
        this.coeffs = new double[coeffs.length];
        for (int i = 0; i < coeffs.length; i++) {
            this.coeffs[i] = coeffs[i];
        }
    }
    public Polynomial add(Polynomial other) {
        int maxLen = Math.max(this.coeffs.length, other.coeffs.length);
        double[] result = new double[maxLen];
        for (int i = 0; i < maxLen; i++) {
            double a = (i < this.coeffs.length) ? this.coeffs[i] : 0;
            double b = (i < other.coeffs.length) ? other.coeffs[i] : 0;
            result[i] = a + b;
        }
        return new Polynomial(result);
    }
    public double evaluate(double x) {
        double result = 0;
        double power = 1;
        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i] * power;
            power *= x;
        }
        return result;
    }
    public boolean hasRoot(double x) {
        return Math.abs(evaluate(x)) < 1e-9;
    }
}