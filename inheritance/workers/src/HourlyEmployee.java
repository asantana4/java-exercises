public class HourlyEmployee extends Employee {
    private double hourlyPayRate;

    public HourlyEmployee(String name) {
        super(name);
        this.hourlyPayRate = Employee.RANDOM.nextDouble(40, 65.01);
    }


    public void getDoublePay() {
        hourlyPayRate *= 2;
        System.out.println("This employee is getting double pay.");
    }

    @Override
    public double collectPay() {
        return hourlyPayRate * 150;
    }

    @Override
    public String toString() {
        return  super.toString() + "Hourly pay rate: %s%n".formatted(MONEY_FORMATTER.format(hourlyPayRate));
    }

}
