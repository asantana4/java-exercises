public class Worker {

    private String name;
    private String birthdate;
    private String endDate;

    public Worker(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public int getAge() {
        return 0;
    }

    public double collectPay() {
        return 0.0;
    }

    public void terminate (String endDate) {

    }
}
