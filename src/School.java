/**
 * @Author: Alexis Caasi
 * @Since: 22 - July - 2020
 * @Abstract: Project 1
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class School {
    private String schoolName;
    private ArrayList<Instructor> instructors = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public void readData(String txtFile) {
        File file = new File(txtFile);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int counter = 0;
        while(scanner.hasNextLine()) {
            Integer start = 0;
            Boolean contains = false;
            Integer end = Integer.parseInt(scanner.nextLine());
            while(start < end) {
                String string = scanner.nextLine();
                ArrayList<String> s = new ArrayList<>(Arrays.asList(string.split(",")));
                if(counter == 0) {
                    for(int i = 0; i < instructors.size(); i++) {
                        if(instructors.get(i).getInstructorID().equals(Integer.parseInt(s.get(0)))) {
                            contains = true;
                            break;
                        }
                    }
                    if(!contains) {
                        Instructor instructor = new Instructor(Integer.parseInt(s.get(0)), s.get(1), s.get(2), s.get(3));
                        instructors.add(instructor);
                    } else {
                        System.out.println("Instructor info reading failed – Employee number " + s.get(0) + " already used.");
                    }
                } else if(counter == 1) {
                    for(int i = 0; i < courses.size(); i++) {
                        if(courses.get(i).getCourseID().equals(Integer.parseInt(s.get(0)))) {
                            contains = true;
                            break;
                        }
                    }
                    if(!contains) {
                        Course course = new Course(Integer.parseInt(s.get(0)), s.get(1), Integer.parseInt(s.get(2)), s.get(3));
                        courses.add(course);
                    } else {
                        System.out.println("Course info reading failed – Course ID " + s.get(0) + " already used.");
                    }
                } else if(counter == 2) {
                    Boolean containsStudent = false;
                    for(int i = 0; i < students.size(); i++) {
                        if(students.get(i).getStudentID().equals(Integer.parseInt(s.get(0)))) {
                            containsStudent = true;
                            break;
                        }
                    }
                    if(!containsStudent) {
                        Student student = new Student(Integer.parseInt(s.get(0)), s.get(1));
                        students.add(student);
                    } else {
                        System.out.println("Student info reading failed – Student ID " + s.get(0) + " already used.");
                    }
                }
                start+=1;
            }
            counter+=1;
        }
        System.out.println("Done.");
    }

    public void schoolInfo() {
        // print out the schools's instructors, courses, and students
        System.out.println("School Name: " + this.schoolName);
        System.out.println("Instructor Information");
        for(Instructor instructor : instructors) {
            System.out.println(instructor.getInstructorName());
        }
        System.out.println("Course Information");
        for(Course course : courses) {
            System.out.println(course.getCourseName());
        }
        System.out.println("Student Information");
        for(Student student : students) {
            System.out.println(student.getStudentName());
        }
    }

    public void searchByEmail(String email){
        Boolean found = false;
        Instructor i = null;
        for(Instructor instructor : instructors) {
            if (instructor.getInstructorEmail().equals(email)) {
                found = true;
                i = instructor;
                break;
            }
        }
        if(found) {
            System.out.println("Search key: " + i.getInstructorEmail());
            System.out.println("Employee Number: " + i.getInstructorID());
            System.out.println("Name: " + i.getInstructorName());
            System.out.println("Phone: " + i.getInstructorPhone());
        } else {
            System.out.println("Search key: " + email);
            System.out.println("No employee with email " + email);
        }
    }

    public void addInstructor(Integer instructorID, String instructorName, String instructorEmail, String instructorPhone) {
        Boolean found = false;
        for(Instructor instructor : instructors) {
            if(instructor.getInstructorID().equals(instructorID)) {
                found = true;
                break;
            }
        }
        if(!found) {
            instructors.add(new Instructor(instructorID, instructorName, instructorEmail, instructorPhone));
        } else {
            System.out.println("Instructor info reading failed – Employee number " + instructorID + " already used.");
        }
    }

    public void addCourse(Integer courseID, String courseName, Integer courseCapacity, String courseLocation) {
        Boolean found = false;
        for(Course course : courses) {
            if(course.getCourseID().equals(courseID)) {
                found = true;
                break;
            }
        }
        if(!found) {
            courses.add(new Course(courseID, courseName, courseCapacity, courseLocation));
        } else {
            System.out.println("Course info reading failed – Course ID "+ courseID +" already used.");
        }
    }

    public void assignInstructor(Integer courseID, Integer instructorID) {
        Instructor instructor = null;
        for(Instructor i : instructors) {
            if(i.getInstructorID().equals(instructorID)) {
                instructor = i;
                break;
            }
        }
        for(Course course : courses) {
            if(course.getCourseID().equals(courseID)) {
                course.getInstructors().add(instructor);
            }
        }
    }

    public void register(Integer courseID, Integer studentID) {
        Boolean contains = false;
        Student s = null;
        for(Student student : students) {
            if(student.getStudentID().equals(studentID)) {
                contains = true;
                s = student;
                break;
            }
        }

        if(contains) {
            for(Course course : courses) {
                if(course.getCourseID().equals(courseID)) {
                    course.getStudents().add(s);
                }
            }
        } else if(!contains) {
            System.out.println("Student " + studentID + " does not exist");
        }
    }

    public void unRegister(Integer courseID, Integer studentID) {
        Boolean contains = false;
        Student s = null;
        for(Student student : students) {
            if(student.getStudentID().equals(studentID)){
                contains = true;
                s = student;
                break;
            }
        }
        if(contains) {
            for(Course course : courses) {
                if(course.getCourseID().equals(courseID)) {
                    course.getStudents().remove(s);
                }
            }
        } else if(!contains) {
            System.out.println("Student " + studentID + " is not enrolled in " + courseID);
        }
    }

    public void putScore(Integer courseID, Integer studentID, Double grade) {
        Boolean contains = false;
        for(int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseID)){
                for(Student student : courses.get(i).getStudents()) {
                    if(student.getStudentID().equals(studentID)) {
                        contains = true;
                        break;
                    }
                }
            }
        }
        if(contains) {
            for(int i = 0; i < courses.size(); i++) {
                if(courses.get(i).getCourseID().equals(courseID)){
                    for(Student student : courses.get(i).getStudents()) {
                        if(student.getStudentID().equals(studentID)) {
                            student.setScore(grade);
                            break;
                        }
                    }
                    break;
                }
            }
        } else {
            for(Student student : students) {
                if(student.getStudentID().equals(studentID)) {
                    System.out.println("Student " + studentID + " (" + student.getStudentName() + ") is not enrolled in " + courseID);
                    break;
                }
            }

        }
    }

    public void courseInfo(Integer courseID) {
        Boolean contains = false;
        Course c = null;
        for(Course course : courses){
            if(course.getCourseID().equals(courseID)) {
                contains = true;
                c = course;
                break;
            }
        }
        if(contains) {
            System.out.println("Course Number: " + courseID);
            System.out.println("Instructor: " + c.getCourseInstructor());
            System.out.println("Course Title: " + c.getCourseName());
            System.out.println("Room: " + c.getCourseLocation());
            System.out.println("Total Enrolled: " + c.getCourseCapacity());
            System.out.println("Course Average: " + c.getCourseAverage());
        }
    }
}
