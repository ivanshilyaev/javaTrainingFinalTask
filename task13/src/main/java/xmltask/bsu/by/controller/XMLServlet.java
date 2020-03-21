package xmltask.bsu.by.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xmltask.bsu.by.bean.Student;
import xmltask.bsu.by.service.BuildCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/parse")
@MultipartConfig
public class XMLServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void init() throws ServletException {
        LOGGER.info("Servlet started");
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

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        InputStream inputStream = req.getPart("file").getInputStream();

        String parser = req.getParameter("item");
        BuildCommand command = new BuildCommand();
        List<Student> list = command.exec(parser, inputStream);
        req.setAttribute("list", list);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}
