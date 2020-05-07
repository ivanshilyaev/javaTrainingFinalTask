package ft.training.by.controller.action.administrator;

import ft.training.by.bean.Faculty;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.FacultyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindAllFacultiesAction extends AdministratorAction {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        FacultyService facultyService = factory.createService(FacultyService.class);
        List<Faculty> faculties = facultyService.read();
        request.setAttribute("listFaculties", faculties);
        return null;
    }
}
