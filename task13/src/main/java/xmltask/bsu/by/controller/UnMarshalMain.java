package xmltask.bsu.by.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import xmltask.bsu.by.bean.Students;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UnMarshalMain {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Students.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            String schemaName = "/Users/ivansilaev/Desktop/javaTraining/task13/src/main/resources/xml/xsdTest.xsd";
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaLocation = new File(schemaName);
            Schema schema = schemaFactory.newSchema(schemaLocation);
            unmarshaller.setSchema(schema);

            FileReader reader = new FileReader("/Users/ivansilaev/Desktop/javaTraining/task13/src/main/resources/xml/xmlTest.xml");
            Students students = (Students) unmarshaller.unmarshal(reader);
            System.out.println(students);
        } catch (JAXBException e) {
            LOGGER.error("Invalid JAXB-content");
        } catch (FileNotFoundException e) {
            LOGGER.error("Can't read XML-file");
        } catch (SAXException e) {
            LOGGER.error("Error while creating xsd-schema");
        }
    }
}
