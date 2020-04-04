package ft.training.by.controller;

import ft.training.by.controller.action.ActionCommand;
import ft.training.by.controller.action.ActionFactory;
import ft.training.by.controller.resource.ConfigurationManager;
import ft.training.by.controller.resource.MessageManager;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.dao.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String DB_URL = "jdbc:mysql://localhost:3306/account_db";
    public static final String DB_LOGIN = "application";
    public static final String DB_PASSWORD = "application_password";
    public static final int DB_POOL_START_ACTIVE = 10;
    public static final int DB_POOL_MAX_ACTIVE = 1000;
    public static final int DB_POOL_MAX_WAIT = 0;

    @Override
    public void init() throws ServletException {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            ConnectionPool.getInstance().init(DB_URL,
                    DB_LOGIN, DB_PASSWORD, DB_POOL_START_ACTIVE,
                    DB_POOL_MAX_ACTIVE, DB_POOL_MAX_WAIT);
            LOGGER.info("Servlet has been started");
        } catch (DAOException | SQLException e) {
            LOGGER.error("Impossible to init connection pool", e);
            destroy();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page;
        ActionCommand command = ActionFactory.defineCommand(request);
        page = command.execute(request);
        if (page != null) {
            request.getRequestDispatcher(page).forward(request, response);
        } else {
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
