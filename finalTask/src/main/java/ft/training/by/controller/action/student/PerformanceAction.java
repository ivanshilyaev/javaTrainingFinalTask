package ft.training.by.controller.action.student;

import ft.training.by.bean.Performance;
import ft.training.by.bean.Student;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.PerformanceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PerformanceAction extends StudentAction {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Student student = (Student) request.getSession().getAttribute("authorizedStudent");
        try {
            int semester = Integer.parseInt(request.getParameter("semester"));
            PerformanceService performanceService = factory.createService(PerformanceService.class);
            List<Performance> performance = performanceService.findByStudentId(student.getId());
            performance.removeIf(item -> item.getSemester() != semester);
            request.setAttribute("performance", performance);
        } catch (NumberFormatException e) {
            request.setAttribute("performance", null);
        }
        return null;
    }
}
