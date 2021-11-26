package Model;

import java.util.List;
import java.util.ArrayList;

public class Student extends Person implements Comparable<Student> {

    long studentID;
    int totalCredits;
    List<Long> enrolledCourses;

    public Student(String firstName, String lastName, long studentID, int totalCredits, List<Long> enrolledCourses) {
        super(firstName, lastName);
        this.studentID = studentID;
        this.totalCredits = totalCredits;
        this.enrolledCourses = enrolledCourses;
    }

    public Student(String firstName, String lastName, long studentID) {
        super(firstName, lastName);
        this.studentID = studentID;
        this.totalCredits = 0;
        this.enrolledCourses = new ArrayList<>();
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public List<Long> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Long> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", studentID=" + studentID +
                ", totalCredits=" + totalCredits +
                ", enrolledCourses=" + enrolledCourses +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Student student = (Student) obj;
        return studentID == student.studentID && totalCredits == student.totalCredits && enrolledCourses.equals(student.enrolledCourses);
    }

    /**
     * Deleting course from the student list
     *
     * @param course to be deleted
     */
    public void deleteCourse(Course course) {
        this.enrolledCourses.remove(course.getID());
        this.totalCredits -= course.getCredits();
    }


    /**
     * Updating the course list
     *
     * @param course the course in which the student has enrolled
     */
    public void enrolled(Course course) {
        this.enrolledCourses.add(course.getID());
        this.totalCredits += course.getCredits();
    }

    /**
     * Number of enrolled courses
     *
     * @return Number of courses
     */
    public int getNumberCourses() {
        return this.enrolledCourses.size();
    }

    /**
     * Comparing the number of enrolled courses between two students
     *
     * @param student the two students
     * @return the student with fewer courses
     */
    @Override
    public int compareTo(Student student) {
        return Integer.compare(this.getNumberCourses(), student.getNumberCourses());

    }

    /**
     * How many credits points until 30
     *
     * @return credit points
     */
    public int getEnoughCredits() {
        return (30 - this.getTotalCredits());
    }


}
