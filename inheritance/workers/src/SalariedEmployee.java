public class SalariedEmployee extends Employee {
    private final double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name) {
        this(name, RANDOM.nextDouble(45000.00, 300000.01), false);
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

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void retire() {

        isRetired = true;
        endDate = String.valueOf(TODAY_DATE);
        System.out.printf("Employee %s has been retired%n", name);
    }

    @Override
    public String toString() {
        return """
                %s
                ID: %d
                Makes %s a year
                Retired?: %b
                Hire date: %s
                Last day: %s%n""".formatted(name, employeeID, MONEY_FORMATTER.format(annualSalary), isRetired,
                                                hireDate, endDate);
    }
}
