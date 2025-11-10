package mk.ukim.finki.wp.labb.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.labb.model.Chef;
import mk.ukim.finki.wp.labb.service.ChefService;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@WebServlet(name = "ChefListServlet", urlPatterns = "/listChefs")
public class ChefListServlet extends HttpServlet {
    private final ChefService chefService;
    private final SpringTemplateEngine templateEngine;

    public ChefListServlet(ChefService chefService, SpringTemplateEngine templateEngine) {
        this.chefService = chefService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange exchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(exchange);

        context.setVariable("chefs", chefService.listChefs());
        templateEngine.process("listChefs.html", context, resp.getWriter());
    }
}
