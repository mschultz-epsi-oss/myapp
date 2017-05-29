package monapp.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import javax.inject.Named;
@Named(value=("applicationCounter"))
@ViewScoped

public class ViewCounter implements Serializable {

    ApplicationCounter appCounter;
    private static final long serialVersionUID = 7983140976075649622L;
    int value = 0;

    public Integer getCounter() {
        return ++value;
    }

    @PostConstruct
    void init() {
        System.err.println("Create " + this);
    }

    @PreDestroy
    void close() {
        System.err.println("Close " + this);
    }
}
