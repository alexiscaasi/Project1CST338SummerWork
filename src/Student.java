import java.util.ArrayList;

public class Student {
    private String studentName;
    private Integer studentID;
    private Double studentAverage;

    public void setScore(Double score) {
        this.score = score;
    }

    private String studentCourse;
    private Double score = 0.0;
    private ArrayList<Course> courses = new ArrayList<>();

    public Student(Integer studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    };

    public Integer getStudentID() {
        return studentID;
    };

    public String getStudentCourses() {
        return studentCourse;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentID(Integer id) {
        this.studentID = id;
    }

    public Double getAverage() {
        return studentAverage;
    };

    public void setAverage(Double average) {
        this.studentAverage = average;
    }

    public void setStudentCourses(String course) {
        this.studentCourse = studentCourse;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.studentCourse = studentCourse;
    }

    public void addCourses(Course course) {
        courses.add(course);
    }
}


