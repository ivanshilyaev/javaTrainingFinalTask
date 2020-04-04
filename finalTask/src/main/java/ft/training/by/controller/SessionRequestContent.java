package ft.training.by.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class SessionRequestContent {
    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;

    private boolean invalidateSession;

    public SessionRequestContent() {
        requestAttributes = new HashMap<>();
        requestParameters = new HashMap<>();
        sessionAttributes = new HashMap<>();
    }

    public HashMap<String, Object> getRequestAttributes() {
        return requestAttributes;
    }

    public HashMap<String, String[]> getRequestParameters() {
        return requestParameters;
    }

    public HashMap<String, Object> getSessionAttributes() {
        return sessionAttributes;
    }

    public void setInvalidateSession(boolean invalidateSession) {
        this.invalidateSession = invalidateSession;
    }

    public void extractValues(HttpServletRequest request) {
        Enumeration<String> requestAttributesNames = request.getAttributeNames();
        while (requestAttributesNames.hasMoreElements()) {
            String name = requestAttributesNames.nextElement();
            requestAttributes.put(name,
                    request.getAttribute(name));
        }

        Enumeration<String> requestParametersNames = request.getParameterNames();
        while (requestParametersNames.hasMoreElements()) {
            String name = requestParametersNames.nextElement();
            requestParameters.put(name,
                    request.getParameterValues(name));
        }

        Enumeration<String> sessionAttributesNames = request.getSession().getAttributeNames();
        while (sessionAttributesNames.hasMoreElements()) {
            String name = sessionAttributesNames.nextElement();
            sessionAttributes.put(name,
                    request.getSession().getAttribute(name));
        }
    }

    public void insertValues(HttpServletRequest request) {
        for (Map.Entry<String, Object> entry : requestAttributes.entrySet()) {
            request.setAttribute(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Object> entry : sessionAttributes.entrySet()) {
            request.getSession().setAttribute(entry.getKey(), entry.getValue());
        }
        if (invalidateSession) {
            request.getSession().invalidate();
        }
    }
}
