package xmltask.bsu.by.service;

import xmltask.bsu.by.bean.Student;
import xmltask.bsu.by.service.builder.AbstractStudentsBuilder;
import xmltask.bsu.by.service.builder.StudentsSAXBuilder;

import java.io.InputStream;
import java.util.List;

public class BuildCommand {
    public List<Student> exec(String parser, InputStream inputStream) {
        //StudentBuilderFactory factory = new StudentBuilderFactory();
        //AbstractStudentsBuilder builder = factory.createStudentBuilder(parser);
        StudentsSAXBuilder builder = new StudentsSAXBuilder();
        builder.buildListStudents(inputStream);
//        builder.buildListStudents(
//                "/Users/ivansilaev/Desktop/javaTraining/task13/src/main/resources/xml/xmlTest.xml"
//        );
        return builder.getStudents();
    }
}
