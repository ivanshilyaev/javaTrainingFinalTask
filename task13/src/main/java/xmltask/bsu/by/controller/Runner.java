package xmltask.bsu.by.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xmltask.bsu.by.service.StudentBuilderFactory;
import xmltask.bsu.by.service.builder.AbstractStudentsBuilder;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        StudentBuilderFactory factory = new StudentBuilderFactory();
        AbstractStudentsBuilder builder = factory.createStudentBuilder("DOM");
        builder.buildListStudents("src/main/resources/xml/bookTest.xml");
        System.out.println(builder.getStudents());
        LOGGER.info("Success");
    }
}
