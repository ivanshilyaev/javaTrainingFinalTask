package ft.training.by.controller.action.student;

import ft.training.by.bean.enums.Role;
import ft.training.by.controller.action.AuthorizedUserAction;

public abstract class StudentAction extends AuthorizedUserAction {
    public StudentAction() {
        getAllowedRoles().add(Role.STUDENT);
    }
}
