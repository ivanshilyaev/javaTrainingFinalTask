package xmltask.bsu.by.service.builder;

import xmltask.bsu.by.bean.Student;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractStudentsBuilder {
    // not final, because is usually used in subclasses
    protected Set<Student> students;

    public AbstractStudentsBuilder() {
        students = new HashSet<>();
    }

    public Set<Student> getStudents() {
        return students;
    }

    abstract public void buildSetStudents(String fileName);
}
