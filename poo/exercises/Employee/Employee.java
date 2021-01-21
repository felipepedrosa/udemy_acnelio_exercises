package poo.exercises.Employee;

public class Employee {
    private String name;
    private double grossSalary;
    private double tax;

    public Employee(String name, double grossSalary, double tax) {
        this.name = name;
        this.grossSalary = grossSalary;
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    private double getNetSalary() {
        return getGrossSalary() - tax;
    }

    public void increaseSalary(double amount) {
        double newGrossSalary = (getGrossSalary() * (amount / 100)) + getGrossSalary();
        setGrossSalary(newGrossSalary);
    }

    @Override
    public String toString() {
        return String.format("%s, $ %.2f", getName(), getNetSalary());
    }
}
