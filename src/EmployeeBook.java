public class EmployeeBook {
    private Employee[] employeesBase;

    public EmployeeBook(int employeesBaseLength) {
        this.employeesBase = new Employee[employeesBaseLength];
    }

    public void addEmployee(String fullName, int department, int salary) {
        if (isBaseFull()) {
            return;
        }
        Employee temporaryEmployee = new Employee(fullName, department, salary);
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] == null) {
                employeesBase[i] = temporaryEmployee;
                break;
            }
        }
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getId() == id) {
                employeesBase[i] = null;
                return;
            }
        }
        System.out.println("Employee not found");
    }

    public Employee getEmployeeById(int id) {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getId() == id) {
                return employeesBase[i];
            }
        }
        return null;
    }

    public void printEmployeeBase() {
        if (isBaseEmpty()) {
            return;
        }
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null) {
                System.out.println("Employee{" +
                        "name='" + employeesBase[i].getName() + '\'' +
                        ", department=" + employeesBase[i].getDepartment() +
                        ", salary=" + employeesBase[i].getSalary() +
                        ", id=" + employeesBase[i].getId() +
                        '}');
            }
        }
    }

    public void printEmployeeBase(int department) {
        if (isBaseEmpty()) {
            return;
        }
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getDepartment() == department) {
                System.out.println("Employee{" +
                        "name='" + employeesBase[i].getName() + '\'' +
                        ", salary=" + employeesBase[i].getSalary() +
                        ", id=" + employeesBase[i].getId() +
                        '}');
            }
        }
    }

    public void printEmployeeNames() {
        if (isBaseEmpty()) {
            return;
        }
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null) {
                System.out.println(employeesBase[i].getName());
            }
        }
    }

    public void changeSalaryByName(String name, int salary) {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getName().equals(name)) {
                employeesBase[i].setSalary(salary);
                return;
            }
        }
        System.out.println("Employee not found");
    }

    public void changeDepartmentByName(String fullName, int newDepartment) {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getName().equals(fullName)) {
                employeesBase[i].setDepartment(newDepartment);
                return;
            }
        }
        System.out.println("Employee not found");
    }

    public double salarySummary() {
        double salarySum = 0.0;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null) {
                salarySum += employeesBase[i].getSalary();
            }
        }
        return salarySum;
    }

    public double salarySummary(int department) {
        double salarySum = 0.0;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getDepartment() == department) {
                salarySum += employeesBase[i].getSalary();
            }
        }
        return salarySum;
    }

    public Employee salaryMinimum() {
        double minimum = Double.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getSalary() < minimum) {
                minSalaryEmployee = employeesBase[i];
                minimum = minSalaryEmployee.getSalary();
            }
        }
        return minSalaryEmployee;
    }

    public Employee salaryMinimum(int department) {
        double minimum = Double.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getSalary() < minimum
                    && employeesBase[i].getDepartment() == department) {
                minSalaryEmployee = employeesBase[i];
                minimum = minSalaryEmployee.getSalary();
            }
        }
        return minSalaryEmployee;
    }

    public Employee salaryMaximum() {
        double maximum = Double.MIN_VALUE;
        Employee maxSalaryEmployee = null;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getSalary() > maximum) {
                maxSalaryEmployee = employeesBase[i];
                maximum = maxSalaryEmployee.getSalary();
            }
        }
        return maxSalaryEmployee;
    }

    public Employee salaryMaximum(int department) {
        double maximum = Double.MIN_VALUE;
        Employee maxSalaryEmployee = null;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getSalary() > maximum
                    && employeesBase[i].getDepartment() == department) {
                maxSalaryEmployee = employeesBase[i];
                maximum = maxSalaryEmployee.getSalary();
            }
        }
        return maxSalaryEmployee;
    }

    public double salaryAverage() {
        int counter = 0;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null) {
                counter++;
            }
        }
        return salarySummary() / counter;
    }

    public double salaryAverage(int department) {
        int counter = 0;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getDepartment() == department) {
                counter++;
            }
        }
        return salarySummary(department) / counter;
    }

    public void salaryIndexation(double percent) {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null) {
                employeesBase[i].setSalary((employeesBase[i].getSalary() * (100 + percent) / 100));
            }
        }
    }

    public void salaryIndexation(double percent, int department) {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getDepartment() == department) {
                employeesBase[i].setSalary((employeesBase[i].getSalary() * (100 + percent) / 100));
            }
        }
    }

    public void employeesWithSalaryLowerThan(int maxPointSalary) {
        boolean flag = true;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getSalary() < maxPointSalary) {
                System.out.println("Employee{" +
                        "id=" + employeesBase[i].getId() +
                        ", name='" + employeesBase[i].getName() + '\'' +
                        ", salary=" + employeesBase[i].getSalary() +
                        '}');
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Employee not found");
        }
    }

    public void employeesWithSalaryHigherOrSameAs(int maxPointSalary) {
        boolean flag = true;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getSalary() >= maxPointSalary) {
                System.out.println("Employee{" +
                        "id=" + employeesBase[i].getId() +
                        ", name='" + employeesBase[i].getName() + '\'' +
                        ", salary=" + employeesBase[i].getSalary() +
                        '}');
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Employee not found");
        }
    }



    private boolean isBaseEmpty() {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null) {
                return false;
            }
        }
        System.out.println("Base are empty");
        return true;
    }

    private boolean isBaseFull() {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] == null) {
                return false;
            }
        }
        System.out.println("Base are full");
        return true;
    }
}