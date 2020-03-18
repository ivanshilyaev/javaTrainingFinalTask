package xmltask.bsu.by.service;

import xmltask.bsu.by.service.builder.AbstractStudentsBuilder;
import xmltask.bsu.by.service.builder.StudentsDOMBuilder;
import xmltask.bsu.by.service.builder.StudentsSAXBuilder;
import xmltask.bsu.by.service.builder.StudentsStAXBuilder;

public class StudentBuilderFactory {
    private enum TypeParser {
        SAX,
        STAX,
        DOM
    }

    public AbstractStudentsBuilder createStudentBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new StudentsDOMBuilder();
            case STAX:
                return new StudentsStAXBuilder();
            case SAX:
                return new StudentsSAXBuilder();
            default:
                throw new EnumConstantNotPresentException(
                        type.getDeclaringClass(), type.name()
                );
        }
    }
}
