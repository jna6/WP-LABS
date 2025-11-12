package mk.ukim.finki.wp.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "BookReservationServlet", urlPatterns = "/servlet/bookReservation")
public class BookReservationServlet extends HttpServlet {
    private final SpringTemplateEngine templateEngine;
    private final BookReservationService bookReservationService;

    public BookReservationServlet(SpringTemplateEngine templateEngine, BookReservationService bookReservationService) {
        this.templateEngine = templateEngine;
        this.bookReservationService = bookReservationService;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookTitle = request.getParameter("bookTitle");
        String readerName = request.getParameter("readerName");
        String readerAddress = request.getParameter("readerAddress");
        int numberOfCopies = Integer.parseInt(request.getParameter("numCopies"));

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(request,response);

        WebContext webContext= new WebContext(webExchange);

        webContext.setVariable("bookTitle", bookTitle);
        webContext.setVariable("readerName", readerName);
        webContext.setVariable("readerAddress", readerAddress);
        webContext.setVariable("numberOfCopies", numberOfCopies);

        bookReservationService.placeReservation(bookTitle, readerName, readerAddress, numberOfCopies);

        templateEngine.process("reservationConfirmation", webContext, response.getWriter());
    }
}
