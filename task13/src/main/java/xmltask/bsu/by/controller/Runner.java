package xmltask.bsu.by.controller;

import xmltask.bsu.by.service.StudentsDOMBuilder;
import xmltask.bsu.by.service.StudentsSAXBuilder;
import xmltask.bsu.by.service.StudentsStAXBuilder;

public class Runner {
    public static void main(String[] args) {
        // SAX
//        StudentsSAXBuilder saxBuilder = new StudentsSAXBuilder();
//        saxBuilder.buildSetStudents("src/main/resources/xml/bookTest.xml");
//        System.out.println(saxBuilder.getStudents());

        // DOM
//        StudentsDOMBuilder domBuilder = new StudentsDOMBuilder();
//        domBuilder.buildSetStudents("src/main/resources/xml/bookTest.xml");
//        System.out.println(domBuilder.getStudents());

        // StAX
        StudentsStAXBuilder staxBuilder = new StudentsStAXBuilder();
        staxBuilder.buildSetStudents("src/main/resources/xml/bookTest.xml");
        System.out.println(staxBuilder.getStudents());
    }
}
