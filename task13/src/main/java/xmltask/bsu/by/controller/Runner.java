package xmltask.bsu.by.controller;

import xmltask.bsu.by.service.StudentsSAXBuilder;

public class Runner {
    public static void main(String[] args) {
        StudentsSAXBuilder saxBuilder = new StudentsSAXBuilder();
        saxBuilder.buildSetStudents("/Users/ivansilaev/Desktop/javaTraining/task13/src/main/resources/xml/bookTest.xml");
        System.out.println(saxBuilder.getStudents());
    }
}
