package xmltask.bsu.by.service;

import xmltask.bsu.by.bean.Student;
import xmltask.bsu.by.service.builder.AbstractStudentsBuilder;
import java.io.InputStream;
import java.util.List;

public class BuildCommand {
    public List<Student> exec(String parser, InputStream inputStream) {
        StudentBuilderFactory factory = new StudentBuilderFactory();
        AbstractStudentsBuilder builder = factory.createStudentBuilder(parser);
        builder.buildListStudents(inputStream);
        return builder.getStudents();
    }
}
