package ft.training.by.controller.action.student;

import ft.training.by.bean.Student;
import ft.training.by.bean.Subgroup;
import ft.training.by.bean.Timetable;
import ft.training.by.bean.TimetableGroup;
import ft.training.by.bean.enums.Day;
import ft.training.by.service.interfaces.SubgroupService;
import ft.training.by.service.exception.ServiceException;
import ft.training.by.service.interfaces.TimetableGroupService;
import ft.training.by.service.interfaces.TimetableService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ScheduleAction extends StudentAction {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        // 1. берём пользователя-студента из сессии
        Student student = (Student) request.getSession().getAttribute("authorizedStudent");
        try {
            // 2. забираем день недели, для которого нужно отображать расписание
            int day = Integer.parseInt(request.getParameter("day"));
            // 3. находим группу (подгруппу) студента
            SubgroupService subgroupService = factory.createService(SubgroupService.class);
            Subgroup subgroup = subgroupService.read(student.getSubgroup().getId()).orElse(null);
            // 4. находим все занятия для этой подгурппы
            TimetableGroupService timetableGroupService = factory.createService(TimetableGroupService.class);
            List<TimetableGroup> list = timetableGroupService.findBySubgroupId(subgroup.getId());
            // 5. находим все пары
            List<Timetable> classes = new ArrayList<>();
            TimetableService timetableService = factory.createService(TimetableService.class);
            for (TimetableGroup timetableGroup : list) {
                classes.add(timetableService.read(timetableGroup.getTimetable().getId()).orElse(null));
            }
            // 6. находим все пары для данного дня
            List<Timetable> schedule = new ArrayList<>();
            for (Timetable timetable : classes) {
                if (timetable.getDay() == Day.getById(day)) {
                    schedule.add(timetable);
                }
            }
            request.getSession().setAttribute("schedule", schedule);
        } catch (NumberFormatException e) {
            // если день ещё не установлен, то ничего не выводим
            request.getSession().setAttribute("schedule", null);
        }
        return null;
    }
}
