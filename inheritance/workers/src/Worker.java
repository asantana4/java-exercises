import java.time.LocalDate;
import java.util.Random;


public class Worker {

    private final String name;
    private final String birthDate;
    protected String endDate;
    protected final static Random RANDOM = new Random();
    protected final static LocalDate TODAY_DATE = LocalDate.now();


    public Worker(String name) {
        this(name, getRandomDate(1990, 2001));
    }

    public Worker(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {

        String[] yearMonthDay =  birthDate.split("-");
        int birthYear = Integer.parseInt(yearMonthDay[0]);
        int birthMonth = Integer.parseInt(yearMonthDay[1]);
        int birthDay = Integer.parseInt(yearMonthDay[2]);
        int age = TODAY_DATE.getYear() - birthYear;
        /* This if statement checks whether the worker's birthdate has passed based on the current date,
        with the purpose of adding precision to the age returned. */
        if (    (birthMonth > TODAY_DATE.getMonthValue()) ||
                (birthMonth == TODAY_DATE.getMonthValue() && birthDay > TODAY_DATE.getDayOfMonth()) ) {
            return age - 1;
        }
        return age;
    }

    public double collectPay() {

        return 0.00;
    }

    public void terminate (String endDate) {
        this.endDate = endDate;
    }

    public static String getRandomDate(int yearFrom, int yearUntil) {
        return java.lang.String.valueOf(LocalDate.ofYearDay(  RANDOM.nextInt(yearFrom, yearUntil),
                                                    RANDOM.nextInt(1, 366)  ));
    }

    @Override
    public String toString() {
        return """
                %s
                Birthday: %s
                End day: %s
                """.formatted(name, birthDate, endDate);
    }


}
