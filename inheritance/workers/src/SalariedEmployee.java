import java.time.LocalDate;

public class SalariedEmployee extends Employee {
    private double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name) {
        this(name, RANDOM.nextDouble(45000.00, 300000), false);
    }

    public SalariedEmployee(String name, double annualSalary, boolean isRetired) {
        this(name, getRandomDate(1990, 2001), null, nextID++,
                getRandomDate(2020, 2026), annualSalary, isRetired);
    }

    public SalariedEmployee(String name, String birthdate, String endDate, long employeeID, String hireDate,
                            double annualSalary, boolean isRetired) {
        super(name, birthdate, endDate, employeeID, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = isRetired;
    }

    public void retire() {
        LocalDate today = LocalDate.now();
        isRetired = true;
        super.endDate = String.valueOf(today);
        System.out.printf("Employee %s has been retired%n", super.name);
    }


}
