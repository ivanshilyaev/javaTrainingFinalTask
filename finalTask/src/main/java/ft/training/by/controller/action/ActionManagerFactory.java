package ft.training.by.controller.action;

import ft.training.by.service.interfaces.ServiceFactory;

public class ActionManagerFactory {
    private ActionManagerFactory() {
    }

    public static ActionManager getManager(ServiceFactory factory) {
        return new ActionManagerImpl(factory);
    }
}
