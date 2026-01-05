public class Main {

    public static void main(String[] args) {
//        Worker worker = new Worker("Jeffrey E.");
//        Employee emp = new Employee("Carlos S.");

//        SalariedEmployee emp = new SalariedEmployee("Alex S.");
        HourlyEmployee emp = new HourlyEmployee("Alex S.");
        System.out.println(Worker.getRandomDate(1990, 2000));
        System.out.println(Worker.getRandomDate(1990, 2000));
        System.out.println(Worker.getRandomDate(1990, 2000));
        System.out.println(emp);
        emp.getDoublePay();
        System.out.println(emp);

        System.out.println(emp.collectPay());

    }
}
