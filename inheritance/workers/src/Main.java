public class Main {

    public static void main(String[] args) {

        Worker[] employees = {new SalariedEmployee("Juan C."), new HourlyEmployee("Alex D."),
                                new HourlyEmployee("Vianel R.")};
        for (Worker employee : employees) {
            System.out.print(employee);
            System.out.println("Age: " + employee.getAge());
            System.out.printf("Payment collected: %s%n", Employee.MONEY_FORMATTER.format(employee.collectPay()));
            employee.terminate("2024-8-29");
            if (employee instanceof SalariedEmployee salariedEmp) {
                salariedEmp.retire();
            } else {
                ((HourlyEmployee) employee).getDoublePay();
            }
            System.out.println(employee);
            System.out.println("-".repeat(25));
        }



    }
}
