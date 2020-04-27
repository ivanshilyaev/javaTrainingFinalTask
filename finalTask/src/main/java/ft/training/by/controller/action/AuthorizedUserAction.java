package ft.training.by.controller.action;

import ft.training.by.bean.enums.Role;

import java.util.Arrays;

public abstract class AuthorizedUserAction extends Action {
    public AuthorizedUserAction() {
        getAllowedRoles().addAll(Arrays.asList(Role.values()));
    }
}
