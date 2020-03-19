package xmltask.bsu.by.service.builder;

import xmltask.bsu.by.bean.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class AbstractStudentsBuilder {
    // not final, because is usually used in subclasses
    protected List<Student> students;

    public AbstractStudentsBuilder() {
        students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    abstract public void buildSetStudents(String fileName);
}
