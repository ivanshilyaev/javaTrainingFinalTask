package ft.training.by.controller.action.tutor;

import ft.training.by.bean.enums.Role;
import ft.training.by.controller.action.Action;

public abstract class TutorAction extends Action {
    public TutorAction() {
        getAllowedRoles().add(Role.TUTOR);
    }
}
