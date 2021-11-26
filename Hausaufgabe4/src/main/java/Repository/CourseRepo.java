package Repository;

import Model.Course;
import Model.Student;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.*;

import Exception.Exception2;
import Exception.Exception1;

import java.util.*;

public class CourseRepo extends InMemoryRepo<Course> implements FileRepo<Course> {

    String file;

    public CourseRepo(String file) {
        super();
        this.file = file;
    }

    @Override
    public String toString() {
        return "CourseRepo{" +
                "repoList=" + repoList +
                '}';
    }

    /**
     * Reading from course file
     *
     * @return Course list
     * @throws IOException
     */
    @Override
    public List<Course> readFromFile() throws IOException {

        Reader reader = new BufferedReader(new FileReader(file));
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode parser = objectMapper.readTree(reader);

        for (JsonNode pm : parser) {
            long ID = pm.path("id").asLong();
            String name = pm.path("name").asText();
            int teacher = pm.path("teacher").asInt();
            int maxEnrollment = pm.path("maxEnrollment").asInt();
            List<Long> studentsEnrolled = new ArrayList<>();
            for (JsonNode v : pm.path("studentsEnrolled")) {
                studentsEnrolled.add(v.asLong());
            }

            int credits = pm.path("credits").asInt();
            Course course = new Course(name, ID, teacher, maxEnrollment, studentsEnrolled, credits);
            repoList.add(course);
        }
        return repoList;
    }

    /**
     * Writing new course in Course file
     *
     * @throws IOException
     */
    @Override
    public void writeToFile() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());

        writer.writeValue(new File(file), repoList);
    }


    @Override
    public Course create(Course obj) throws IOException, Exception1 {
        for (Course course : repoList) {
            if (course.getID() == obj.getID())
                throw new Exception1("Cursul e deja in lista");
        }
        this.repoList.add(obj);
        writeToFile();
        return obj;
    }

    /**
     * Updating a course
     *
     * @param obj Course object which needs to be updated
     * @return Updated course
     * @throws IOException
     * @throws Exception2, if the list is empty
     */
    @Override
    public Course update(Course obj) throws IOException {
        Course CourseUpdated = this.repoList.stream()
                .filter(course -> Objects.equals(course.getID(), obj.getID()))
                .findFirst()
                .orElseThrow();

        CourseUpdated.setName(obj.getName());
        CourseUpdated.setTeacher(obj.getTeacher());
        CourseUpdated.setMaxEnrollment(obj.getMaxEnrollment());
        CourseUpdated.setCredits(obj.getCredits());
        CourseUpdated.setStudentsEnrolled(obj.getStudentsEnrolled());

        writeToFile();
        return CourseUpdated;
    }

    /**
     * Sorting the courses after free places
     */
    public void sortList() {
        repoList.sort(Course::compareTo);
    }

    /**
     * Searching for courses with more than 15 credit points
     *
     * @return courses list
     */
    public List<Course> filterList() {
        return repoList.stream()
                .filter(course -> course.getCredits() > 15).toList();
    }

    /**
     * Adding a course in the list
     *
     * @param obj, Course object which needs to be added
     * @return the added object
     * @throws IOException
     * @throws Exception1  if the object is already in the list
     */

    public Course addCourse(Course obj) throws IOException, Exception1 {
        for (Course course : repoList) {
            if (course.getID() == obj.getID())
                throw new Exception1("Curs deja adaugat");
        }
        this.repoList.add(obj);
        writeToFile();
        return obj;
    }

    /**
     * Searching courses with free places
     *
     * @return the courses
     */
    public Map<Long, Integer> coursesWithFreePlaces() {
        Map<Long, Integer> freeCourses = new HashMap<>();
        for (Course course : repoList) {
            if (course.free()) {
                freeCourses.put(course.getID(), course.getFree());
            }
        }
        return freeCourses;

    }

    /**
     * Checking if there are enough places
     *
     * @param idCourse which course is checked
     * @return true if there are places, else false
     */
    public boolean hasFreePlace(Long idCourse) {
        boolean aux = false;
        for (Course course : repoList) {
            if (course.getID() == idCourse)
                if (course.free())
                    aux = true;
        }
        return aux;
    }


    public Course findOne(Long idCourse) throws IOException {
        Reader reader = new BufferedReader(new FileReader(file));
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode parser = objectMapper.readTree(reader);

        for (JsonNode pm : parser) {
            Long ID = pm.path("id").asLong();
            if (Objects.equals(idCourse, ID)) {
                String name = pm.path("name").asText();
                int teacher = pm.path("teacher").asInt();
                int maxEnrollment = pm.path(" maxEnrollment").asInt();
                List<Long> studentenEnrolled = new ArrayList<>();
                for (JsonNode v : pm.path("studentenEnrolled")) {
                    studentenEnrolled.add(v.asLong());
                }
                int credits = pm.path("credits").asInt();
                return new Course(name, idCourse, maxEnrollment, studentenEnrolled, credits);
            }
        }
        return null;
    }


    public boolean delete(Long idCourse) throws IOException {
        if (repoList.isEmpty())
            throw new IndexOutOfBoundsException("Lista vida");

        for (Course course : repoList) {
            if (course.getID() == idCourse) {
                repoList.remove(course);
                writeToFile();
                return true;
            }
        }
        return false;
    }


    /**
     * Checking if a student is in a course
     *
     * @param idCourse  the course
     * @param idStudent the searched student
     * @return true, if the student participate, else false
     */
    public boolean containsCourseStud(Long idCourse, Long idStudent) {
        boolean aux = false;
        for (Course course : repoList) {
            if (course.getID() == idCourse)
                if (!course.getStudentsEnrolled().contains(idStudent))
                    aux = true;
        }
        return aux;
    }

    /**
     * Checking if a course exists
     *
     * @param id the searched course
     * @return true, if it exists, else false
     */
    public boolean containsID(Long id) {
        for (Course course : repoList) {
            if (course.getID() == id)
                return true;
        }
        return false;
    }

    /**
     * Adding a new student to the course
     *
     * @param student, which will be added
     * @param idCourse to which course will the student be added
     * @throws IOException
     * @throws Exception2, if the list is empty
     */
    public void addStudent(Student student, Long idCourse) throws IOException, Exception2 {
        if (hasFreePlace(idCourse) && containsCourseStud(idCourse, student.getStudentID())) {
            for (Course course : repoList) {
                if (idCourse == course.getID()) {
                    course.addStudent(student);
                    this.update(course);
                    writeToFile();
                }
            }
        }
    }

    /**
     * Checking which courses are free
     *
     * @return the list with founded courses
     */
    public List<Course> getCourseFreeSpace() {
        List<Course> freeCourse = new ArrayList<>();
        for (Course course : repoList) {
            if (course.free()) {
                freeCourse.add(course);
            }
        }
        return freeCourse;
    }
}
