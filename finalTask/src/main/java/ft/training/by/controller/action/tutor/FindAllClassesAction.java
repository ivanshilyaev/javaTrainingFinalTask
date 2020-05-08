package ft.training.by.controller.action.tutor;

import ft.training.by.bean.Timetable;
import ft.training.by.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindAllClassesAction extends TutorAction {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        List<Timetable> timetableList;
        return null;
    }
}
