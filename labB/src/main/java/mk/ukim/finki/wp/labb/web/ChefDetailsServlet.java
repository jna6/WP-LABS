package mk.ukim.finki.wp.labb.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.labb.model.Chef;
import mk.ukim.finki.wp.labb.model.Dish;
import mk.ukim.finki.wp.labb.service.ChefService;
import mk.ukim.finki.wp.labb.service.DishService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "ChefDetailsServlet", urlPatterns = "/chefDetails")
public class ChefDetailsServlet extends HttpServlet {

    private final ChefService chefService;
    private final DishService dishService;
    private final SpringTemplateEngine templateEngine;

    public ChefDetailsServlet(ChefService chefService, DishService dishService, SpringTemplateEngine templateEngine) {
        this.chefService = chefService;
        this.dishService = dishService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long chefId = Long.valueOf(req.getParameter("chefId"));
        Long dishId = Long.valueOf(req.getParameter("dishId"));

        Chef chef = chefService.addDishToChef(chefId, String.valueOf(dishId));
        Dish dish= dishService.findByDishId(String.valueOf(dishId));

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext webContext = new WebContext(webExchange);
        chefService.addDishToChef(chefId, String.valueOf(dishId));
        webContext.setVariable("chef", chef);
        templateEngine.process("chefDetails", webContext, resp.getWriter());
    }
}
