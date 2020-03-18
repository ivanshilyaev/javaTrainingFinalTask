package xmltask.bsu.by.service;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import xmltask.bsu.by.bean.*;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class StudentHandler extends DefaultHandler {
    private Set<Student> students;
    private Student currentStudent;
    private StudentEnum currentClassEnum;
    private StudentEnum currentEnum;
    private EnumSet<StudentEnum> withText;

    public StudentHandler() {
        students = new HashSet<>();
        withText = EnumSet.range(StudentEnum.ID, StudentEnum.COURSENUMBER);
    }

    public Set<Student> getStudents() {
        return students;
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if ("students".equals(qName) || "".equals(qName)) {
        } else if ("student".equals(qName)) {
            currentStudent = new Student();
            currentClassEnum = StudentEnum.valueOf(qName.toUpperCase());
        } else if ("user".equals(qName)) {
            currentStudent.setUser(new User());
            currentClassEnum = StudentEnum.valueOf(qName.toUpperCase());
            int role = Integer.parseInt(attributes.getValue(0));
            switch (role) {
                case 0:
                    currentStudent.getUser().setRole(Role.STUDENT);
                    break;
                case 1:
                    currentStudent.getUser().setRole(Role.ADMINISTRATOR);
                    break;
                case 2:
                    currentStudent.getUser().setRole(Role.TUTOR);
                    break;
            }
        } else if ("subgroup".equals(qName)) {
            currentStudent.setSubgroup(new Subgroup());
            currentClassEnum = StudentEnum.valueOf(qName.toUpperCase());
        } else if ("group".equals(qName)) {
            currentStudent.getSubgroup().setGroup(new Group());
            currentClassEnum = StudentEnum.valueOf(qName.toUpperCase());
        } else if ("faculty".equals(qName)) {
            currentStudent.getSubgroup().getGroup().setFaculty(new Faculty());
            currentClassEnum = StudentEnum.valueOf(qName.toUpperCase());
        } else {
            StudentEnum temp = StudentEnum.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = StudentEnum.valueOf(qName.toUpperCase());
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("student".equals(qName)) {
            students.add(currentStudent);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case ID: {
                    switch (currentClassEnum) {
                        case STUDENT:
                            currentStudent.setId(Integer.parseInt(s));
                            break;
                        case USER:
                            currentStudent.getUser().setId(Integer.parseInt(s));
                            break;
                        case SUBGROUP:
                            currentStudent.getSubgroup().setId(Integer.parseInt(s));
                            break;
                        case GROUP:
                            currentStudent.getSubgroup().getGroup().setId(Integer.parseInt(s));
                            break;
                        case FACULTY:
                            currentStudent.getSubgroup().getGroup().getFaculty().setId(Integer.parseInt(s));
                            break;
                    }
                    break;
                }
                case LOGIN:
                    currentStudent.getUser().setLogin(s);
                    break;
                case PASSWORD:
                    currentStudent.getUser().setPassword(s.toCharArray());
                    break;
                case SURNAME:
                    currentStudent.getUser().setSurname(s);
                    break;
                case NAME: {
                    switch (currentClassEnum) {
                        case USER:
                            currentStudent.getUser().setName(s);
                            break;
                        case FACULTY:
                            currentStudent.getSubgroup().getGroup().getFaculty().setName(s);
                            break;
                    }
                    break;
                }
                case PATRONYMIC:
                    currentStudent.getUser().setPatronymic(s);
                    break;
                case SUBGROUPNUMBER:
                    currentStudent.getSubgroup().setSubgroupNumber(s.charAt(0));
                    break;
                case GROUPNUMBER:
                    currentStudent.getSubgroup().getGroup().setGroupNumber(Integer.parseInt(s));
                    break;
                case COURSENUMBER:
                    currentStudent.getSubgroup().getGroup().setCourseNumber(Integer.parseInt(s));
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(),
                            currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
