package xmltask.bsu.by.service.builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xmltask.bsu.by.bean.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentsStAXBuilder extends AbstractStudentsBuilder {
    private static final Logger LOGGER = LogManager.getLogger();

    private List<Student> students;
    private XMLInputFactory inputFactory;

    public StudentsStAXBuilder() {
        students = new ArrayList<>();
        inputFactory = XMLInputFactory.newInstance();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void buildSetStudents(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (StudentEnum.valueOf(name.toUpperCase()) == StudentEnum.STUDENT) {
                        Student st = buildStudent(reader);
                        students.add(st);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            LOGGER.error("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            LOGGER.error("File " + fileName + " not found! " + ex.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Impossible close file " + fileName + " : " + e);
            }
        }
    }

    public Student buildStudent(XMLStreamReader reader) throws XMLStreamException {
        Student student = new Student();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (StudentEnum.valueOf(name.toUpperCase())) {
                        case ID:
                            student.setId(Integer.parseInt(getXMLText(reader)));
                            break;
                        case USER:
                            student.setUser(buildUser(reader));
                            break;
                        case SUBGROUP:
                            student.setSubgroup(buildSubgroup(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (StudentEnum.valueOf(name.toUpperCase()) == StudentEnum.STUDENT) {
                        return student;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag student");
    }

    public User buildUser(XMLStreamReader reader) throws XMLStreamException {
        User user = new User();
        int role = Integer.parseInt(
                reader.getAttributeValue(null, StudentEnum.ROLE.getValue())
        );
        switch (role) {
            case 0:
                user.setRole(Role.STUDENT);
                break;
            case 1:
                user.setRole(Role.ADMINISTRATOR);
                break;
            case 2:
                user.setRole(Role.TUTOR);
                break;
        }
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (StudentEnum.valueOf(name.toUpperCase())) {
                        case ID:
                            user.setId(Integer.parseInt(getXMLText(reader)));
                            break;
                        case LOGIN:
                            user.setLogin(getXMLText(reader));
                            break;
                        case PASSWORD:
                            user.setPassword(getXMLText(reader).toCharArray());
                            break;
                        case SURNAME:
                            user.setSurname(getXMLText(reader));
                            break;
                        case NAME:
                            user.setName(getXMLText(reader));
                            break;
                        case PATRONYMIC:
                            user.setPatronymic(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (StudentEnum.valueOf(name.toUpperCase()) == StudentEnum.USER) {
                        return user;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag user");
    }

    public Subgroup buildSubgroup(XMLStreamReader reader) throws XMLStreamException {
        Subgroup subgroup = new Subgroup();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (StudentEnum.valueOf(name.toUpperCase())) {
                        case ID:
                            subgroup.setId(Integer.parseInt(getXMLText(reader)));
                            break;
                        case SUBGROUPNUMBER:
                            subgroup.setSubgroupNumber(getXMLText(reader).charAt(0));
                            break;
                        case GROUP:
                            subgroup.setGroup(buildGroup(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (StudentEnum.valueOf(name.toUpperCase()) == StudentEnum.SUBGROUP) {
                        return subgroup;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag subgroup");
    }

    public Group buildGroup(XMLStreamReader reader) throws XMLStreamException {
        Group group = new Group();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (StudentEnum.valueOf(name.toUpperCase())) {
                        case ID:
                            group.setId(Integer.parseInt(getXMLText(reader)));
                            break;
                        case GROUPNUMBER:
                            group.setGroupNumber(Integer.parseInt(getXMLText(reader)));
                            break;
                        case COURSENUMBER:
                            group.setCourseNumber(Integer.parseInt(getXMLText(reader)));
                            break;
                        case FACULTY:
                            group.setFaculty(buildFaculty(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (StudentEnum.valueOf(name.toUpperCase()) == StudentEnum.GROUP) {
                        return group;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag group");
    }

    public Faculty buildFaculty(XMLStreamReader reader) throws XMLStreamException {
        Faculty faculty = new Faculty();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (StudentEnum.valueOf(name.toUpperCase())) {
                        case ID:
                            faculty.setId(Integer.parseInt(getXMLText(reader)));
                            break;
                        case NAME:
                            faculty.setName(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (StudentEnum.valueOf(name.toUpperCase()) == StudentEnum.FACULTY) {
                        return faculty;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag faculty");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
