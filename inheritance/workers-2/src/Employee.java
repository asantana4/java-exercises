public class Employee extends Worker {

    private long employeeID;
    private String hireDate;
    private static long nextID = 412589;

    public Employee(String name) {
        this(name, nextID++, Worker.getRandomDate(2000, 2026));

    }

    public Employee(String name, long employeeID, String hireDate) {
        super(name);
        this.employeeID = employeeID;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return super.toString() + """ 
                Employee ID: %d
                Hired on %s
                """.formatted(employeeID, hireDate);
    }
}
