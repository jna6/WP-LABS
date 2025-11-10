package mk.ukim.finki.wp.labb.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.labb.model.Chef;
import mk.ukim.finki.wp.labb.service.ChefService;
import mk.ukim.finki.wp.labb.service.DishService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "DishServlet", urlPatterns = "/dish")
public class DishServlet extends HttpServlet {

    private final DishService dishService;
    private final ChefService chefService;
    private final SpringTemplateEngine templateEngine;

    public DishServlet(DishService dishService, ChefService chefService, SpringTemplateEngine templateEngine) {
        this.dishService = dishService;
        this.chefService = chefService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long chefId = Long.valueOf(req.getParameter("chefId"));
        Chef chef = chefService.findById(chefId);

        IWebExchange exchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(exchange);
        context.setVariable("chef", chef);
        context.setVariable("dishes", dishService.listDishes());
        templateEngine.process("dishesList", context, resp.getWriter());
    }
}
