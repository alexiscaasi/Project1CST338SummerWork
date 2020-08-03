import java.util.ArrayList;

public class Course {
    private String courseName;
    private Integer courseID;
    private Integer courseCapacity;
    private String courseLocation;
    private Double courseAverage = 0.0;
    private String courseInstructor;
    private ArrayList<Instructor> instructors = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    public Course(Integer courseID, String courseName, Integer courseCapacity, String courseLocation) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.courseCapacity = courseCapacity;
        this.courseLocation = courseLocation;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public Integer getCourseCapacity() {
        return courseCapacity;
    }

    public void setCourseCapacity(Integer courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(ArrayList<Instructor> instructors) {
        this.instructors = instructors;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    public void addInstructors(Instructor instructor) {
        instructors.add(instructor);
    }

    public void addStudents(Student student) {
        students.add(student);
    }

    public Double getCourseAverage() {
        return courseAverage / students.size();
    }

    public void setCourseAverage(Double courseAverage) {
        this.courseAverage = courseAverage;
    }

    public void addAverage(Double grade) {
        courseAverage += grade;
    }
}
