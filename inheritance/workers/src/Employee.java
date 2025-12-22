import java.text.NumberFormat;

public class Employee extends Worker {

    private final long employeeID;
    protected String hireDate;
    private static long nextID = 1542247;
    protected final static NumberFormat MONEY_FORMATTER = NumberFormat.getCurrencyInstance();

    public Employee(String name) {
        super(name);
        this.employeeID = nextID++;
        this.hireDate = String.valueOf(Worker.getRandomDate(2020, 2026));
    }

    @Override
    public String toString() {
        return super.toString() + """
                ID: %d
                Hired on: %s
                """.formatted(employeeID, hireDate);
    }


}
