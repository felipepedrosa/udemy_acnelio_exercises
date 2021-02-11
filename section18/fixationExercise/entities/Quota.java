package section18.fixationExercise.entities;

import java.util.Date;

public class Quota {
    private Date dueDate;
    private Double amount;

    public Quota() {
    }

    public Quota(Date dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
