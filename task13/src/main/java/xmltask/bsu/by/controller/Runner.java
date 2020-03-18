package xmltask.bsu.by.controller;

import xmltask.bsu.by.service.StudentBuilderFactory;
import xmltask.bsu.by.service.builder.AbstractStudentsBuilder;

public class Runner {
    public static void main(String[] args) {
        StudentBuilderFactory factory = new StudentBuilderFactory();
        AbstractStudentsBuilder builder = factory.createStudentBuilder("sax");
        builder.buildSetStudents("src/main/resources/xml/bookTest.xml");
        System.out.println(builder.getStudents());
    }
}
