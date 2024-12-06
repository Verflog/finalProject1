public class Main {
    public static void main(String[] args) {
        EmployeeBook Employees = new EmployeeBook(10);

        Employees.addEmployee("Aleksandrova Aleksandra Aleksandrovna", 5, 135000);
        Employees.addEmployee("Ivanov Ivan Ivanovich", 1, 90000);
        Employees.addEmployee("Petrov Petr Petrovich", 3, 120000);
        Employees.addEmployee("Evgenieva Evgeniya Evgenievna", 5, 140000);
        Employees.addEmployee("Vyacheslavov Vyacheslav Vyacheslavovich", 1, 85000);
        Employees.addEmployee("Nikolaev Nikolay Nikolaevich", 2, 65000);
        Employees.addEmployee("Pavlova Paulina Pavlovna", 2, 70000);
        Employees.printEmployeeBase();
        System.out.println("__________________________");

        Employees.removeEmployee(3);
        System.out.println(Employees.salarySummary());
        System.out.println(Employees.salaryMinimum());
        System.out.println(Employees.salaryMaximum());
        System.out.println(Employees.salaryAverage());
        Employees.printEmployeeNames();

        Employees.salaryIndexation(5);
        System.out.println(Employees.salarySummary(5));
        System.out.println(Employees.salaryMinimum(2));
        System.out.println(Employees.salaryMaximum(1));
        System.out.println(Employees.salaryAverage(5));
        Employees.salaryIndexation(2, 1);
        Employees.printEmployeeBase(2);
        System.out.println("__________________________");


        Employees.employeesWithSalaryLowerThan(90000);
        System.out.println("__________________________");
        Employees.employeesWithSalaryHigherOrSameAs(85000);
        System.out.println("__________________________");

        System.out.println(Employees.getEmployeeById(5));
        System.out.println("__________________________");

        Employees.printEmployeeBase();

    }
}