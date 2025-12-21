public class HourlyEmployee extends Employee {
    private double hourlyPayRate;

    public HourlyEmployee(String name) {
        this(name, RANDOM.nextDouble(25.00, 60.01));
    }

    public HourlyEmployee(String name, double hourlyPayRate) {
        this(name, getRandomDate(1990, 2001), null, nextID++,
                getRandomDate(2020, 2026), hourlyPayRate);
    }

    public HourlyEmployee(String name, String birthdate, String endDate, long employeeID, String hireDate,
                          double hourlyPayRate) {
        super(name, birthdate, endDate, employeeID, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    public void getDoublePay() {
        hourlyPayRate *= 2;
        System.out.println("This employee is getting double pay.");
    }

}
