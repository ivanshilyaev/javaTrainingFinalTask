package xmltask.bsu.by.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Students {
    @XmlElement(name = "student")
    private List<Student> list = new ArrayList<>();

    public Students() {
        super();
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public void add(Student student) {
        list.add(student);
    }

    @Override
    public String toString() {
        return "Students " +
                "[list = " + list +
                ']';
    }
}
