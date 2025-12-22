import java.time.LocalDate;

public class SalariedEmployee extends Employee {
    private double annualSalary;
    private boolean isRetired;


    public SalariedEmployee(String name) {
        super(name);
        this.annualSalary = Employee.RANDOM.nextDouble(45000, 300000.01);
    }

    @Override
    public double collectPay() {
        return annualSalary / 12;
    }

    public void retire() {
        isRetired = true;
        annualSalary *= 0.85;
        terminate(String.valueOf(LocalDate.now()));
        System.out.printf("Salaried employee %s has been retired.%n", super.getName());



    }





    @Override
    public String toString() {
        return super.toString() + """
                Annual salary: %s
                Retired?: %b
                """.formatted(MONEY_FORMATTER.format(annualSalary), isRetired);
    }
}
