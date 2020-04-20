package ft.training.by.controller;

import ft.training.by.controller.action.Action;
import ft.training.by.controller.action.ChangePasswordAction;
import ft.training.by.controller.action.FindAllUsersAction;
import ft.training.by.controller.action.LoginAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActionFromUriFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger();

    private static Map<String, Class<? extends Action>> actions = new ConcurrentHashMap<>();

    static {
        /*
         * В зависимости от того, на какой путь мы идём,
         * вызывается нужный обработчик (Action)
         */

        actions.put("/", LoginAction.class);
        actions.put("/index", LoginAction.class);
        actions.put("/list", LoginAction.class);
        actions.put("/login", LoginAction.class);
        actions.put("/password", ChangePasswordAction.class);
        actions.put("/main", FindAllUsersAction.class);
        // !!!
        actions.put("/controller", LoginAction.class);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
            String contextPath = httpRequest.getContextPath();
            String uri = httpRequest.getRequestURI();
            LOGGER.debug(String.format("Starting of processing of request for URI \"%s\"", uri));
            int beginAction = contextPath.length();
            int endAction = uri.lastIndexOf('.');
            String actionName;
            if (endAction >= 0) {
                actionName = uri.substring(beginAction, endAction);
            } else {
                actionName = uri.substring(beginAction);
            }
            Class<? extends Action> actionClass = actions.get(actionName);
            try {
                Action action = actionClass.getDeclaredConstructor().newInstance();
                action.setName(actionName);
                httpRequest.setAttribute("action", action);
                filterChain.doFilter(servletRequest, servletResponse);
            } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                LOGGER.error("Impossible to create action handler object", e);
                //httpRequest.setAttribute("error", String.format("Запрошенный адрес %s не может быть обработан сервером", uri));
                httpRequest.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(servletRequest, servletResponse);
            }
        } else {
            LOGGER.error("It is impossible to use HTTP filter");
            servletRequest.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
