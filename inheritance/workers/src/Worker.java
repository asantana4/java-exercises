import java.time.Year;

public class Worker {

    private String name;
    private String birthdate;
    private String endDate;

    public Worker(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public int getAge() {
        String[] monthDayYear =  birthdate.split("/");
        int birthYear = Integer.parseInt(birthdate.split("/")[2]);
//        System.out.println(birthYear);
        return Year.now().getValue() - birthYear;
    }

    public double collectPay() {
        return 0.0;
    }

    public void terminate (String endDate) {

    }
}
