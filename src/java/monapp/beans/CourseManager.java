package monapp.beans;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CourseManager {

    private List<Course> listeCourses;

    public CourseManager() {
//creer la liste de course
    }

    public List<Course> findCourses() {

        return listeCourses;
    }

    public Course findCourse(Integer n) {
        // a coder
    }

    public Course saveCourse(Course c) {
        if (c.getId() == null) {
//ajout dans la liste
        } else {
//le rechercher et le modifier
        }
        return c;
    }

    public void deleteCourse(Course c) {
//le supprimer
    }
}
