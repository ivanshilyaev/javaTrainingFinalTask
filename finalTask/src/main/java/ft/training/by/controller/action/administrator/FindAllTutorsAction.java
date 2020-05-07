package ft.training.by.controller.action.administrator;

import ft.training.by.bean.Tutor;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.TutorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindAllTutorsAction extends AdministratorAction {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        TutorService tutorService = factory.createService(TutorService.class);
        List<Tutor> listTutors = tutorService.read();
        request.setAttribute("listTutors", listTutors);
        return null;
    }
}
