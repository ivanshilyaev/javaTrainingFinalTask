//package ft.training.by.controller.action;
//
//import ft.training.by.controller.resource.ConfigurationManager;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class LogoutAction extends Action {
//    @Override
//    public String execute(HttpServletRequest request, HttpServletResponse response) {
//        String page = ConfigurationManager.getProperty("path.page.index");
//        request.getSession().invalidate();
//        return page;
//    }
//}
