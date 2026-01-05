public class HourlyEmployee extends Employee {

    private double hourlyPayRate;

    public HourlyEmployee(String name) {
        this(name, Worker.RANDOM.nextDouble(45.0, 81.0));
    }

    public HourlyEmployee(String name, double hourlyPayRate) {
        super(name);
        this.hourlyPayRate = hourlyPayRate;
    }

    public void getDoublePay() {
        hourlyPayRate *= 2;
    }

    @Override
    public double collectPay() {
        return hourlyPayRate * 85;
    }

    @Override
    public String toString() {
        return super.toString() + """
                Hourly salary: $%.2f
                """.formatted(hourlyPayRate);
    }

}
