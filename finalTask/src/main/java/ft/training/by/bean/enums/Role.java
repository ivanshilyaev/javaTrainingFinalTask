package ft.training.by.bean.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "role")
@XmlEnum
public enum Role {
    @XmlEnumValue("0")
    STUDENT,
    @XmlEnumValue("1")
    ADMINISTRATOR,
    @XmlEnumValue("2")
    TUTOR;

    public static Role getById(int id) {
        return Role.values()[id];
    }
}
