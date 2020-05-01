package ft.training.by.controller.action.administrator;

import ft.training.by.bean.enums.Role;
import ft.training.by.controller.action.Action;

public abstract class AdministratorAction extends Action {
    public AdministratorAction() {
        getAllowedRoles().add(Role.ADMINISTRATOR);
    }
}
