package com.bookclub;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import com.bookclub.service.impl.MemBookDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    private final BookDao bookDao = new MemBookDao();

    @RequestMapping("/home")
    public String showHome(Model model) {
        List<Book> books = bookDao.list();
        model.addAttribute("books", books);
        return "index";
    }

    @RequestMapping("/about")
    public String showAboutUs() {
        return "about";
    }

    @RequestMapping("/contact")
    public String showContactUs() {
        return "contact";
    }

    @GetMapping("/{id}")
    public String getMonthlyBook(@PathVariable String id, Model model) {
        Book book = bookDao.find(id);
        model.addAttribute("book", book);
        return "monthly-books/view";
    }
}
