package secao13.ex1.entities;

import secao13.ex1.enums.WorkerLevel;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private Set<HourContract> contracts = new HashSet<>();

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Set<HourContract> getContracts() {
        return contracts;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addContract(HourContract contract) {
        getContracts().add(contract);

    }

    public void removeContract(HourContract contract) {
        getContracts().remove(contract);
    }

    public Double income(int year, int month) {
        Calendar calendar = Calendar.getInstance();

        return getBaseSalary() + getContracts().stream()
                .filter(contract -> {
                    calendar.setTime(contract.getDate());
                    return calendar.get(Calendar.YEAR) == year && calendar.get(Calendar.MONTH) == month;
                })
                .collect(Collectors.summingDouble(contract -> contract.totalValue()));
    }
}

