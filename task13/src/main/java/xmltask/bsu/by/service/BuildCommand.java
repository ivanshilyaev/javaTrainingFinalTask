package xmltask.bsu.by.service;

import xmltask.bsu.by.bean.Student;
import xmltask.bsu.by.service.builder.AbstractStudentsBuilder;

import java.util.List;

public class BuildCommand {
    public List<Student> exec(String parser) {
        StudentBuilderFactory factory = new StudentBuilderFactory();
        AbstractStudentsBuilder builder = factory.createStudentBuilder(parser);
        builder.buildListStudents(
                "/Users/ivansilaev/Desktop/javaTraining/task13/src/main/resources/xml/bookTest.xml"
        );
        return builder.getStudents();
    }
}
