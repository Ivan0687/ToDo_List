package ua.goit.todo.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.goit.todo.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@WebServlet(name = "ToDoServlet", urlPatterns = "/servlet")
public class ToDoServlet extends HttpServlet {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private HttpSession session;

    private ArrayList<Task> tasks;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("use service");
        session = req.getSession();

        tasks = (ArrayList<Task>) session.getAttribute("tasks");

        if (tasks == null) {
            tasks = new ArrayList<>();
            tasks.add(new Task("Add new task"));
            session.setAttribute("tasks", tasks);
        }

        if (req.getParameter("taskIdDel") != null){
            doDelete(req, resp);
        } else if (req.getParameter("taskIdUpd") != null){
            doPut(req, resp);
        } else super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("use get");
        if (tasks.isEmpty()) {
            tasks = new ArrayList<>();
            tasks.add(new Task("Add new task"));
            session.setAttribute("tasks", tasks);
        }

        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("use post");
        Task task = new Task(req.getParameter("task"));
        tasks.add(task);

        if (tasks.size() > 0) {
            tasks.get(0).setDone(true);
        }

        doGet(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info(" use put");
        int id = Integer.parseInt(req.getParameter("taskIdUpd"));

        Task task = tasks.stream().filter(t -> t.getId() == id).findFirst().get();

        if (task.isDone()){
            task.setDone(false);
        } else task.setDone(true);

        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("use delete");
        int id = Integer.parseInt(req.getParameter("taskIdDel"));

        tasks.removeIf(task -> task.getId() == id);

        doGet(req, resp);

    }
}
