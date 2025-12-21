import java.time.LocalDate;
import java.util.Random;

/*
Note: I am writing the code to auto generate all the fields I can.
* */
public class Worker {

    protected String name;
    private String birthdate;
    protected String endDate;
    public final static Random random = new Random();

    public Worker (String name) {
        this(name, getRandomDate(1990, 2001));
    }

    public Worker(String name, String birthdate) {
        this(name, birthdate, null);
    }

    public Worker(String name, String birthdate, String endDate) {
        this.name = name;
        this.birthdate = birthdate;
        this.endDate = endDate;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        String[] monthDayYear =  birthdate.split("/");
        int birthYear = Integer.parseInt(monthDayYear[2]);
        int birthMonth = Integer.parseInt(monthDayYear[0]);
        int birthDay = Integer.parseInt(monthDayYear[1]);
        int age = today.getYear() - birthYear;
        if (    (birthMonth > today.getMonthValue()) ||
                (birthMonth == today.getMonthValue() && birthDay > today.getDayOfMonth()) ) {
            return age - 1;
        }
        return age;
    }

    public double collectPay() {
        double payment = 700.00;
        System.out.println("The employee " + name + " collected " + payment + ".");
        return payment;
    }

    public void terminate (String endDate) {
        this.endDate = endDate;
        System.out.println("Employee " + name + " was terminated on " + this.endDate);
    }

    public static String getRandomDate(int yearFrom, int yearUntil) {
        return String.valueOf(LocalDate.ofYearDay(  random.nextInt(yearFrom, yearUntil),
                                                    random.nextInt(1, 366)  ));
    }
}
