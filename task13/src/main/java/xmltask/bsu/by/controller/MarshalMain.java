package xmltask.bsu.by.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xmltask.bsu.by.bean.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MarshalMain {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Students.class);
            Marshaller marshaller = context.createMarshaller();
            Students students = new Students();

            // first student
            Faculty faculty = new Faculty(1, "FAMCS");
            Group group = new Group(1, 9, 2, faculty);
            Subgroup subgroup = new Subgroup(1, 'b', group);
            User user = new User(1, "1823127", new char[]{'1', '1', '1', '1', '1'},
                    Role.STUDENT, "Shilyaev",
                    "Ivan", "Vladimirovich");
            Student student = new Student(1, user, subgroup);
            students.add(student);

            // second student
            subgroup = new Subgroup(2, 'a', group);
            user = new User(2, "1234567", new char[]{'1', '1', '1', '1', '1'},
                    Role.STUDENT, "Berkovich",
                    "Pavel", "Alexandrovich");
            student = new Student(2, user, subgroup);
            students.add(student);

            // third student
            user = new User(3, "7654321", new char[]{'1', '1', '1', '1', '1'},
                    Role.STUDENT, "Zalomov",
                    "Danil", "Pavlovich");
            student = new Student(3, user, subgroup);
            students.add(student);

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(students,
                    new FileOutputStream("/Users/ivansilaev/Desktop/xmlTest.xml"));
            marshaller.marshal(students, System.out);
        } catch (FileNotFoundException e) {
            LOGGER.error("XML-file can't be created");
        } catch (JAXBException e) {
            LOGGER.error("Invalid JAXB-content");
        }
    }
}
