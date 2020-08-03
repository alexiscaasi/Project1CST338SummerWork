import java.util.ArrayList;

public class Instructor {
    private String instructorName;
    private Integer instructorID;
    private String instructorCourses;
    private String instructorEmail;
    private String instructorPhone;
    private ArrayList<Course> courses = new ArrayList<>();

    public Instructor(Integer instructorID, String instructorName, String instructorEmail, String instructorPhone) {
        this.instructorName = instructorName;
        this.instructorID = instructorID;
        this.instructorEmail = instructorEmail;
        this.instructorPhone = instructorPhone;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public Integer getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(Integer instructorID) {
        this.instructorID = instructorID;
    }

    public String getInstructorCourses() {
        return instructorCourses;
    }

    public void setInstructorCourses(String instructorCourses) {
        this.instructorCourses = instructorCourses;
    }

    public String getInstructorEmail() {
        return instructorEmail;
    }

    public void setInstructorEmail(String instructorEmail) {
        this.instructorEmail = instructorEmail;
    }

    public String getInstructorPhone() {
        return instructorPhone;
    }

    public void setInstructorPhone(String instructorPhone) {
        this.instructorPhone = instructorPhone;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void addCourses(Course course) {
        courses.add(course);
    }
}
