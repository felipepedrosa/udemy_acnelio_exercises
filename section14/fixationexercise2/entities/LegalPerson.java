package section14.fixationexercise2.entities;

public class LegalPerson extends Person {
    private Integer employeeNumber;

    public LegalPerson() {
        super();
    }

    public LegalPerson(String name, Double annualIncome, Integer employeeNumber) {
        super(name, annualIncome);
        this.employeeNumber = employeeNumber;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public Double calculateTax() {
        return employeeNumber > 10
                ? getAnnualIncome() * .14
                : getAnnualIncome() * .16;
    }
}
