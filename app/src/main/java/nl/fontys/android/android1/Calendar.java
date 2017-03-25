package nl.fontys.android.android1;

/**
 * Created by Stefan on 23-Mar-17.
 */

public class Calendar {

    private String teacherName;
    private String courseName;
    private String duration;
    private String location;
    private String start;
    private String end;


    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public Calendar(String teacherName, String courseName, String start, String end, String location){
        this.teacherName=teacherName;
        this.courseName=courseName;
        this.location=location;
        this.start = start;
        this.end = end;

    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString(){
        return "Teacher Name: "+teacherName+", Course Name: "+courseName+", Duration: "+duration+", Location: "+location;
    }
}
