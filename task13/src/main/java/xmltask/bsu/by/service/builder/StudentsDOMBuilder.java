package xmltask.bsu.by.service.builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import xmltask.bsu.by.bean.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class StudentsDOMBuilder extends AbstractStudentsBuilder {
    //private static final Logger LOGGER = LogManager.getLogger();

    private DocumentBuilder documentBuilder;

    public StudentsDOMBuilder() {
        students = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            //LOGGER.error("Configuration parser error: " + e.getMessage());
        }
    }

    public void buildListStudents(String fileName) {
        Document document;
        try {
            document = documentBuilder.parse(fileName);
            Element root = document.getDocumentElement();
            NodeList studentsList = root.getElementsByTagName("student");
            for (int i = 0; i < studentsList.getLength(); ++i) {
                Element studentElement = (Element) studentsList.item(i);
                Student student = buildStudent(studentElement);
                students.add(student);
            }
        } catch (SAXException e) {
            //LOGGER.error("Parsing failure: " + e.getMessage());
        } catch (IOException e) {
            //LOGGER.error("File or I/O error: " + e.getMessage());
        }
    }

    public Student buildStudent(Element studentElement) {
        Student student = new Student();
        student.setId(Integer.parseInt(getElementTextContent(studentElement, "id")));
        // user
        Element userElement = (Element) studentElement.getElementsByTagName("user").item(0);
        student.setUser(new User());
        try {
            int role = Integer.parseInt(userElement.getAttribute("role"));
            switch (role) {
                case 0:
                    student.getUser().setRole(Role.STUDENT);
                    break;
                case 1:
                    student.getUser().setRole(Role.ADMINISTRATOR);
                    break;
                case 2:
                    student.getUser().setRole(Role.TUTOR);
                    break;
            }
        } catch (NumberFormatException e) {
            //LOGGER.error("NumberFormatException while building student: " + e.getMessage());
        }
        student.getUser().setId(Integer.parseInt(getElementTextContent(userElement, "id")));
        student.getUser().setLogin(getElementTextContent(userElement, "login"));
        student.getUser().setPassword(getElementTextContent(userElement, "password").toCharArray());
        student.getUser().setSurname(getElementTextContent(userElement, "surname"));
        student.getUser().setName(getElementTextContent(userElement, "name"));
        student.getUser().setPatronymic(getElementTextContent(userElement, "patronymic"));
        // subgroup
        Element subgroupElement = (Element) studentElement.getElementsByTagName("subgroup").item(0);
        student.setSubgroup(new Subgroup());
        student.getSubgroup().setId(Integer.parseInt(getElementTextContent(subgroupElement, "id")));
        student.getSubgroup().setSubgroupNumber(getElementTextContent(subgroupElement, "subgroupNumber").charAt(0));
        // group
        Element groupElement = (Element) subgroupElement.getElementsByTagName("group").item(0);
        student.getSubgroup().setGroup(new Group());
        student.getSubgroup().getGroup().setId(Integer.parseInt(getElementTextContent(groupElement, "id")));
        student.getSubgroup().getGroup().setGroupNumber(
                Integer.parseInt(getElementTextContent(groupElement, "groupNumber"))
        );
        student.getSubgroup().getGroup().setCourseNumber(
                Integer.parseInt(getElementTextContent(groupElement, "courseNumber"))
        );
        // faculty
        Element facultyElement = (Element) groupElement.getElementsByTagName("faculty").item(0);
        student.getSubgroup().getGroup().setFaculty(new Faculty());
        student.getSubgroup().getGroup().getFaculty().setId(
                Integer.parseInt(getElementTextContent(facultyElement, "id"))
        );
        student.getSubgroup().getGroup().getFaculty().setName(
                getElementTextContent(facultyElement, "name")
        );
        return student;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
