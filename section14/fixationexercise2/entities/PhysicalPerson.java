package section14.fixationexercise2.entities;

public class PhysicalPerson extends Person {

    private Double healthExpenses;

    public PhysicalPerson() {
        super();
    }

    public PhysicalPerson(String name, Double annualIncome, Double healthExpenses) {
        super(name, annualIncome);
        this.healthExpenses = healthExpenses;
    }

    public Double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses(Double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }

    @Override
    public Double calculateTax() {
        return (getAnnualIncome() < 20000 ? getAnnualIncome() * .15 : getAnnualIncome() * .25) - (healthExpenses * .50);
    }
}
