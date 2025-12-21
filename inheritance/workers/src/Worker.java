import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Random;


public class Worker {

    protected String name;
    private final String birthdate;
    protected String endDate;
    public final static Random RANDOM = new Random();
    public final static NumberFormat MONEY_FORMATTER = NumberFormat.getCurrencyInstance();
    public final static LocalDate TODAY_DATE = LocalDate.now();


    public Worker(String name, String birthdate, String endDate) {
        this.name = name;
        this.birthdate = birthdate;
        this.endDate = endDate;
    }

    public int getAge() {

        String[] yearMonthDay =  birthdate.split("-");
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

        String employeeName = "UNKNOWN";
        double payment = 100.00;
        if (this instanceof SalariedEmployee salariedEmp) {
            employeeName = salariedEmp.name;
            payment = salariedEmp.getAnnualSalary() / 12;
        } else if (this instanceof HourlyEmployee hourlyEmp){
            employeeName = hourlyEmp.name;
            payment = hourlyEmp.getHourlyPayRate() * 150;
        }
        System.out.printf("The employee %s collected %s for the month.%n", employeeName,
                            MONEY_FORMATTER.format(payment));
        return payment;
    }

    public void terminate (String endDate) {
        this.endDate = endDate;
        System.out.println("Employee " + name + " was terminated on " + this.endDate);
    }

    public static String getRandomDate(int yearFrom, int yearUntil) {
        return String.valueOf(LocalDate.ofYearDay(  RANDOM.nextInt(yearFrom, yearUntil),
                                                    RANDOM.nextInt(1, 366)  ));
    }


}
