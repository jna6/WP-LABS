package mk.ukim.finki.wp.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bookReservation")
public class BookReservationController {

    private final BookReservationService bookReservationService;

    public BookReservationController(BookReservationService bookReservationService) {
        this.bookReservationService = bookReservationService;
    }

    @PostMapping
    public String placeReservation(@RequestParam String bookTitle,
                                   @RequestParam String readerName,
                                   @RequestParam String readerAddress,
                                   @RequestParam int numberOfCopies,
                                   HttpServletRequest request,
                                   Model model) {
        BookReservation bookReservation = bookReservationService.placeReservation(bookTitle, readerName, readerAddress, numberOfCopies);
        model.addAttribute("readerName", bookReservation.getReaderName());
        model.addAttribute("bookTitle", bookReservation.getBookTitle());
        model.addAttribute("ipAddress", request.getRemoteAddr());
        model.addAttribute("numberOfCopies", bookReservation.getNumberOfCopies());


        return "reservationConfirmation";
    }
}
