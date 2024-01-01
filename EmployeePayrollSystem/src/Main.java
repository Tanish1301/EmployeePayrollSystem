import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Employee{
    private String name;
    private int id;

// the below is a constructor, whenever object is created this constructor will assign values to variable
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

//  encapsulation - to check variable value without accessing value, no need of employee.name, this enhances code security
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

//  abstraction can be achieved by abstract class and abstract method

    public abstract double calculateSalary();
//polymorphism

    @Override
    public String toString() {
        return "Employee [name="+name+",id="+id+", salary="+calculateSalary()+"]";
    }
}
class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary=monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}
class partTimeEmployee extends Employee {
    private double hourlyWage;

    private int noOfHours;

    public partTimeEmployee(String name, int id, double hourlyWage, int noOfHours) {
        super(name, id);
        this.hourlyWage = hourlyWage;
        this.noOfHours = noOfHours;
    }

    @Override
    public double calculateSalary() {
        return hourlyWage * noOfHours;
    }

}
    class PayrollSystem{

        // datatype of list can be integer,string,double
        // ArrayList<Integer> arr = new ArrayList<>() - breakdown of below two usages
        private List<Employee> employeeList;

        public PayrollSystem() {
            employeeList = new ArrayList<>();
        }

        public void addEmployee(Employee employee){
            employeeList.add(employee);
        }

        public void removeEmployee(int id) {
            Employee employeeToRemove = null;
            for (Employee employee : employeeList) {
                if (employee.getId() == id) {
                    employeeToRemove = employee;
                    break;
                }
            }
            if (employeeToRemove != null) {
                employeeList.remove(employeeToRemove);
            }
        }
        public void displayEmployee() {
            for (Employee employee: employeeList){
                System.out.println(employee);
            }
        }

    }



public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Tanish",1,7000);
        partTimeEmployee emp2 = new partTimeEmployee("Raju",2,800,8);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Employee Details: ");
        payrollSystem.displayEmployee();
        System.out.println("Removing Employees: ");
        payrollSystem.removeEmployee(2);
        payrollSystem.displayEmployee();

    }
}
