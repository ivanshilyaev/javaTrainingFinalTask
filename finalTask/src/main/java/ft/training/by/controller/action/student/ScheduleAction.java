package ft.training.by.controller.action.student;

import ft.training.by.bean.Student;
import ft.training.by.bean.Subgroup;
import ft.training.by.service.interfaces.StudentService;
import ft.training.by.service.interfaces.SubgroupService;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.TimetableGroupService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScheduleAction extends StudentAction {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        StudentService studentService = factory.createService(StudentService.class).orElseThrow(ServiceException::new);
        Student student = (Student) request.getSession().getAttribute("authorizedStudent");
        int day = -1;
        try {
            day = Integer.parseInt(request.getParameter("day"));
        } catch (NumberFormatException e) {

        }
        System.out.println(day);
        SubgroupService subgroupService = factory.createService(SubgroupService.class).orElseThrow(ServiceException::new);
        Subgroup subgroup = subgroupService.findEntityById(student.getSubgroup().getId()).orElse(null);
        TimetableGroupService timetableGroupService = factory.createService(TimetableGroupService.class).orElseThrow(ServiceException::new);
        System.out.println(timetableGroupService.findAll());
        request.getSession().setAttribute("schedule", null);
        return null;
    }
}
