public class Employee extends Worker {

    protected long employeeID;
    protected String hireDate;
    public static long nextID = 1542247;


    public Employee(String name, String birthdate, String endDate, long employeeID, String hireDate) {
        super(name, birthdate, endDate);
        this.employeeID = employeeID;
        this.hireDate = hireDate;
    }


}
