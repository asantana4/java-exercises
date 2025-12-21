import java.util.Random;

public class Employee extends Worker {

    private long employeeID;
    private String hireDate;
    public static long nextID = 1542247;
    public static final Random RANDOM = new Random();


    public Employee(String name) {
        this(name, nextID++, getRandomDate(2020, 2026));
    }

    public Employee(String name, long employeeID, String hireDate) {
        this(name, getRandomDate(1990, 2001), null, employeeID, hireDate);

    }


    public Employee(String name, String birthdate, String endDate, long employeeID, String hireDate) {
        super(name, birthdate, endDate);
        this.employeeID = employeeID;
        this.hireDate = hireDate;
    }


}
