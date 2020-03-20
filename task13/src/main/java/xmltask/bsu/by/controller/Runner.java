package xmltask.bsu.by.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xmltask.bsu.by.service.StudentBuilderFactory;
import xmltask.bsu.by.service.builder.AbstractStudentsBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            StudentBuilderFactory factory = new StudentBuilderFactory();
            AbstractStudentsBuilder builder = factory.createStudentBuilder("DOM");
            InputStream inputStream = new FileInputStream(new File("src/main/resources/xml/bookTest.xml"));
            builder.buildListStudents(inputStream);
            System.out.println(builder.getStudents());
            LOGGER.info("Success");
        } catch (FileNotFoundException e) {
            LOGGER.error("failure");
        }
    }
}
