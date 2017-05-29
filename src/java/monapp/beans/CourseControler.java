package monapp.beans;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "course")
@SessionScoped
public class CourseControler {

    @EJB
    CourseManager cm;
    Course theCourse = new Course();

    @PostConstruct
    public void init() {
        System.out.println("Create " + this);
        if (cm.findCourses().size() == 0) {
            Course c1 = new Course();
            c1.setName("Architecture JEE");
            c1.setHours(60);
            c1.setLevel("D");
            c1.setDescription("Introduction à JEE.");
            cm.saveCourse(c1);
        }
    }

    public List<Course> getCourses() {
        return cm.findCourses();
    }

    public Course getTheCourse() {
        return theCourse;
    }

    public String show(Integer n) {
        theCourse = cm.findCourse(n);
        return "showCourse";
    }

    public String save() {
        if (theCourse.getHours() % 2 != 0) {
            FacesContext ct = FacesContext.getCurrentInstance();
            Locale locale = ct.getViewRoot().getLocale();
            String messageBundleName = ct.getApplication().getMessageBundle();
            ResourceBundle bundle = ResourceBundle.getBundle(messageBundleName, locale);
            String message = bundle.getString("hoursNotValid");
            FacesMessage msg = new FacesMessage(message);
            ct.addMessage("test:hours", msg);
            ct.validationFailed();
            return "editCourse";
        }
        cm.saveCourse(theCourse);
        return "showCourse";
    }

    public String newCourse() {
        theCourse = new Course();
        return "editCourse";
    }
}
