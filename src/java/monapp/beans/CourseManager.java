package monapp.beans;

import java.util.ArrayList;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateful;

@Stateful
public class CourseManager {
    private int id= 0;
    final private List<Course> listeCourses;

    public CourseManager() {
        listeCourses = new ArrayList<>();
    }

    public List<Course> findCourses() {
        return listeCourses;
    }

    public Course findCourse(Integer n) {
        for (Course c : listeCourses) {
            if (Objects.equals(c.getId(), n)) {
                return c;
            }
        }
        return null;
    }

    public Course saveCourse(Course c) {
        if (c.getId() == null) {
            c.setId(id++);
            listeCourses.add(c);
        } else {
            for (Course course : listeCourses) {
                if (Objects.equals(course.getId(), c.getId())) {
                    c.setName(c.getName());
                    c.setHours(c.getHours());
                    c.setLevel(c.getLevel());
                    c.setDescription(c.getDescription());
                }
            }
        }
        return c;
    }

    public void deleteCourse(Course c) {
        //le supprimer
    }
}
