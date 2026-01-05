public class SalariedEmployee extends Employee {

    private double annualSalary;
    private boolean isRetired;


    public SalariedEmployee(String name) {
        this(name, Worker.RANDOM.nextDouble(45000.96, 365452.51));
    }
    public SalariedEmployee(String name, double annualSalary) {
        super(name);
        this.annualSalary = annualSalary;
    }

    public void retire() {
        isRetired = true;
        annualSalary *= 0.85;
        super.terminate(Worker.TODAY_DATE.toString());
    }

    @Override
    public double collectPay() {
        return annualSalary / 12;
    }

    @Override
    public String toString() {
        return super.toString() + """
                Annual salary: $%.2f
                Retired? %b
                """.formatted(annualSalary, isRetired);
    }
}
