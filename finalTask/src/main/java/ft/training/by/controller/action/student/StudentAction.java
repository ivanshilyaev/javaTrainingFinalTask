package ft.training.by.controller.action.student;

import ft.training.by.bean.enums.Role;
import ft.training.by.controller.action.Action;

public abstract class StudentAction extends Action {
    public StudentAction() {
        getAllowedRoles().add(Role.STUDENT);
    }
}
