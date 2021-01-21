package poo.exercises.student;

public class Student {

    private static final double MAX_NOTE = 100;
    private static final double MIN_NOTE = MAX_NOTE * .6;
    private String name;
    private double firstNote;
    private double secondNote;
    private double thirdNote;

    public Student(String name, double firstNote, double secondNote, double thirdNote) {
        this.name = name;
        this.firstNote = firstNote;
        this.secondNote = secondNote;
        this.thirdNote = thirdNote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFirstNote() {
        return firstNote;
    }

    public void setFirstNote(double firstNote) {
        this.firstNote = firstNote;
    }

    public double getSecondNote() {
        return secondNote;
    }

    public void setSecondNote(double secondNote) {
        this.secondNote = secondNote;
    }

    public double getThirdNote() {
        return thirdNote;
    }

    public void setThirdNote(double thirdNote) {
        this.thirdNote = thirdNote;
    }

    public double getFinalGrade() {
        return getFirstNote() + getSecondNote() + getThirdNote();
    }

    public double getMissingPoints() {
        return MIN_NOTE - (getFirstNote() + getSecondNote() + getThirdNote());
    }

    @Override
    public String toString() {
        return getMissingPoints() > 0
                ? String.format("FINAL GRADE = %.2f\nFAILED\nMISSING %.2f POINTS", getFinalGrade(), getMissingPoints())
                : String.format("FINAL GRADE = %.2f\nPASS", getFinalGrade());
    }
}

