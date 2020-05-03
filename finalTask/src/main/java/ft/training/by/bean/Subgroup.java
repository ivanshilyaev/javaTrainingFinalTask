package ft.training.by.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Objects;

public class Subgroup extends Entity {
    private char subgroupNumber;
    private Group group;

    public Subgroup() {
    }

    public Subgroup(int id) {
        super(id);
    }

    public Subgroup(int id, char subgroupNumber, Group group) {
        super(id);
        this.subgroupNumber = subgroupNumber;
        this.group = group;
    }

    public char getSubgroupNumber() {
        return subgroupNumber;
    }

    public void setSubgroupNumber(char subgroupNumber) {
        this.subgroupNumber = subgroupNumber;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subgroup subgroup = (Subgroup) o;
        return subgroupNumber == subgroup.subgroupNumber &&
                group.equals(subgroup.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subgroupNumber, group);
    }

    @Override
    public String toString() {
        return "Subgroup{" +
                "subgroupNumber=" + subgroupNumber +
                ", group=" + group +
                '}';
    }
}
