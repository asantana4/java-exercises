import java.time.LocalDate;
import java.util.Random;

public class Worker {

    private String name;
    private String birthDate;
    protected String endDate;
    protected final static Random RANDOM = new Random();
    protected static final LocalDate TODAY_DATE = LocalDate.now();


    public Worker(String name) {
        this(name, getRandomDate(1985, 2001));
    }

    public Worker(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    /*
     I used the if statement to compare the birthdate to today's date in order to
     have more precision in the age being returned.
    */
    public int getAge() {
        String[] yearMonthDay = birthDate.split("-");
        int birthYear = Integer.parseInt(yearMonthDay[0]);
        int birthMonth = Integer.parseInt(yearMonthDay[1]);
        int birthDay = Integer.parseInt(yearMonthDay[2]);
        int age = TODAY_DATE.getYear() - birthYear;
        if ( (birthMonth > TODAY_DATE.getMonthValue() )||
                ( birthMonth == TODAY_DATE.getMonthValue() && birthDay > TODAY_DATE.getDayOfMonth()) ) {
            age -= 1;
        }
      return age;
    }

    public double collectPay() {
        return 0.00;
    }


    public static String getRandomDate(int yearFrom, int yearUntil) {
        int year = RANDOM.nextInt(yearFrom, yearUntil);
        LocalDate date = LocalDate.ofYearDay(year, RANDOM.nextInt(366));
        return date.toString();
    }

    public void terminate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return """
                   %s
                   Born on %s
                   Last day working: %s
                   """.formatted(name, birthDate, endDate);
    }
}
