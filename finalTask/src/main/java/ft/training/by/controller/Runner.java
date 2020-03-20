package ft.training.by.controller;

import ft.training.by.bean.*;
import ft.training.by.dao.*;
import ft.training.by.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        List<Student> list = null;
        try {
            AbstractDAO studentDAO = new StudentDAO();
            list = studentDAO.findAll();
//            if (!list.isEmpty()) {
//                for (Student student : list) {
//                    System.out.println(student);
//                }
//            }
        } catch (DAOException e) {
            e.printStackTrace();
        }

        try {
            JAXBContext context = JAXBContext.newInstance(Students.class);
            Marshaller marshaller = context.createMarshaller();
            Students students = new Students();
            if (list != null) {
                students.setList(list);
            }

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(students,
                    new FileOutputStream("/Users/ivansilaev/Desktop/javaTraining/task13/src/main/resources/xml/bookTest.xml"));
            marshaller.marshal(students, System.out);
            LOGGER.info("Success");
        } catch (FileNotFoundException e) {
            LOGGER.error("XML-file can't be created");
        } catch (JAXBException e) {
            LOGGER.error("Invalid JAXB-content");
        }

//        try {
//            AbstractDAO studentDAO = new StudentDAO();
//            Student student = (Student) studentDAO.findEntityById(23);
//            if (student != null) {
//                System.out.println(student.getUser().getName());
//            }
//        } catch (DAOException e) {
//            e.printStackTrace();
//        }
    }
}
