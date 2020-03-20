package xmltask.bsu.by.controller;

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
        String button = req.getParameter("button");
        BuildCommand command = new BuildCommand();
        List<Student> list = command.exec(button, inputStream);
        req.setAttribute("list", list);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}
