package xmltask.bsu.by.controller;

import xmltask.bsu.by.service.StudentsDOMBuilder;
import xmltask.bsu.by.service.StudentsSAXBuilder;

public class Runner {
    public static void main(String[] args) {
        // SAX
//        StudentsSAXBuilder saxBuilder = new StudentsSAXBuilder();
//        saxBuilder.buildSetStudents("src/main/resources/xml/bookTest.xml");
//        System.out.println(saxBuilder.getStudents());

        // DOM
        StudentsDOMBuilder domBuilder = new StudentsDOMBuilder();
        domBuilder.buildSetStudents("src/main/resources/xml/bookTest.xml");
        System.out.println(domBuilder.getStudents());
    }
}
