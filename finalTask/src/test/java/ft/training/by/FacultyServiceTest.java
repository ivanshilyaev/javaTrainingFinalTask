package ft.training.by;

import static org.testng.Assert.assertEquals;

import ft.training.by.bean.Faculty;
import ft.training.by.controller.Runner;
import ft.training.by.service.interfaces.FacultyService;
import ft.training.by.service.interfaces.ServiceFactory;
import ft.training.by.service.impl.ServiceFactoryImpl;
import ft.training.by.service.exception.ServiceException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacultyServiceTest {
    private FacultyService facultyService;

    @BeforeTest
    public void init() {
        try {
            Runner.initConnectionPool();
            ServiceFactory serviceFactory = new ServiceFactoryImpl();
            facultyService = serviceFactory.createService(FacultyService.class).orElseThrow(ServiceException::new);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "positiveDataForFacultyTest")
    public Object[] createPositiveDataForFacultyTest() throws ServiceException {
        return new Object[][]{
                {
                        new Faculty(1, "Факультет прикладной математики и информатики"),
                        facultyService.findEntityById(1)
                },
                {
                        new Faculty(2, "Механико-математический факультет"),
                        facultyService.findEntityById(2)
                }
        };
    }

    @Test(description = "Positive scenario of finding all faculties",
            dataProvider = "positiveDataForFacultyTest")
    public void testFaculty(Faculty expected, Faculty actual) {
        assertEquals(expected, actual);
    }
}
