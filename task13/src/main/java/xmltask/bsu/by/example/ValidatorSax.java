package xmltask.bsu.by.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class ValidatorSax {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        String filename = "/Users/ivansilaev/Desktop/javaTraining/task13/src/main/resources/xml/xmlTest.xml";
        String schemaName = "/Users/ivansilaev/Desktop/javaTraining/task13/src/main/resources/xml/xsdTest.xsd";
        Schema schema;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            schema = factory.newSchema(new File(schemaName));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
            SAXParser parser = spf.newSAXParser();
            parser.parse(filename, new DefaultHandler());
            System.out.println(filename + " is valid");
        } catch (ParserConfigurationException e) {
            LOGGER.error(filename + " config error: " + e.getMessage());
        } catch (SAXException e) {
            LOGGER.error(filename + " SAX error: " + e.getMessage());
        } catch (IOException e) {
            LOGGER.error("I/O error: " + e.getMessage());
        }
    }
}
