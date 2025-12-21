public class Main {
    public static void main(String[] args) {

        String[] names = {"Anthony C.", "Julio H.", "Erika K.", "Fausto M.", "Gabriel R."};
        for (int i = 0; i < names.length; i++) {
            if (i < 2) {
                SalariedEmployee salariedEmp = new SalariedEmployee(names[i]);
                System.out.print(salariedEmp);
                System.out.println("Age: " + salariedEmp.getAge());
                System.out.println(salariedEmp.collectPay());
                salariedEmp.retire();
                System.out.println(salariedEmp);
                continue;
            }
            if (i == 2) System.out.println("-".repeat(25));
            HourlyEmployee hourlyEmp = new HourlyEmployee(names[i]);
            System.out.print(hourlyEmp);
            System.out.println("Age: " + hourlyEmp.getAge());
            System.out.println(hourlyEmp.collectPay());
            hourlyEmp.getDoublePay();
            hourlyEmp.terminate("2025-10-15");
            System.out.println(hourlyEmp);
        }



    }
}
