package ft.training.by.controller;

import ft.training.by.controller.action.Action;
import ft.training.by.controller.action.ActionManager;
import ft.training.by.controller.action.ActionManagerFactory;
import ft.training.by.controller.resource.ConfigurationManager;
import ft.training.by.controller.resource.MessageManager;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.dao.pool.ConnectionPool;
import ft.training.by.service.ServiceFactory;
import ft.training.by.service.ServiceFactoryImpl;
import ft.training.by.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String DB_URL = "jdbc:mysql://localhost:3306/account_db";
    public static final String DB_LOGIN = "application";
    public static final String DB_PASSWORD = "application_password";
    public static final int DB_POOL_START_ACTIVE = 10;
    public static final int DB_POOL_MAX_ACTIVE = 1000;
    public static final int DB_POOL_MAX_WAIT = 0;

    private ServiceFactory getFactory() throws ServiceException {
        return new ServiceFactoryImpl();
    }

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
        System.out.println("Inside servlet 1");
        try {
            // redirected data
            HttpSession session = request.getSession(false);
            if (session != null) {
                @SuppressWarnings("unchecked")
                Map<String, Object> attributes = (Map<String, Object>)
                        session.getAttribute("redirectedData");
                if (attributes != null) {
                    for (String key : attributes.keySet()) {
                        request.setAttribute(key, attributes.get(key));
                    }
                    session.removeAttribute("redirectedData");
                }
            }

            Action action = (Action) request.getAttribute("action");
            ActionManager actionManager = ActionManagerFactory.getManager(getFactory());
            Action.Forward forward = actionManager.execute(action, request, response);
            System.out.println("Inside servlet 2");

            // redirected data
            if (session != null && forward != null && !forward.getAttributes().isEmpty()) {
                session.setAttribute("redirectedData", forward.getAttributes());
            }

            String requestedUri = request.getRequestURI();
            if (forward != null && forward.isRedirect()) {
                String redirectedUri = request.getContextPath() + forward.getForward();
                LOGGER.debug(String.format("Request for URI \"%s\" is redirected to URI \"%s\"", requestedUri, redirectedUri));
                response.sendRedirect(redirectedUri);
            } else {
                String page;
                if (forward != null) {
                    page = forward.getForward();
                } else {
                    page = action.getName() + ".jsp";
                }
                page = "/WEB-INF/jsp" + page;
                System.out.println("Inside servlet 3");
                LOGGER.debug(String.format("Request for URI \"%s\" is forwarded to JSP \"%s\"", requestedUri, page));
                getServletContext().getRequestDispatcher(page).forward(request, response);
            }

//            String page;
//            Action command = ActionFactory.defineCommand(request);
//            page = command.execute(request, response);
//            if (page != null) {
//                request.getRequestDispatcher(page).forward(request, response);
//            } else {
//                page = ConfigurationManager.getProperty("path.page.index");
//                request.getSession().setAttribute("nullPage",
//                        MessageManager.getProperty("message.nullpage"));
//                response.sendRedirect(request.getContextPath() + page);
//            }
        } catch (ServiceException e) {
            LOGGER.error("Impossible to process request", e);
            String page = ConfigurationManager.getProperty("path.page.error");
            request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
