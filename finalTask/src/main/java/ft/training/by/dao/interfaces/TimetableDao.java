package ft.training.by.dao.interfaces;

import ft.training.by.bean.Timetable;
import ft.training.by.dao.exception.DAOException;

import java.util.List;

public interface TimetableDao extends Dao<Integer, Timetable> {
    List<Timetable> findByTutorId(Integer tutorId) throws DAOException;
}
