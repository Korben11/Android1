package nl.fontys.android.android1;

/**
 * Created by Stefan on 30-Mar-17.
 */

public class Grades {
    //course date grade passed

    private String course;
    private String date;
    private Number grade;
    private Boolean passed;

    public Grades(String course, String date, Number grade, Boolean passed) {
        this.course = course;
        this.date = date;
        this.grade = grade;
        this.passed = passed;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Number getGrade() {
        return grade;
    }

    public void setGrade(Number grade) {
        this.grade = grade;
    }

    public Boolean getPassed() {
        return passed;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }

    @Override
    public String toString(){
        return "Subject: " + course + ",Date: " + date + ",Grade: " + grade + ",Passed: " + passed;
    }

}
