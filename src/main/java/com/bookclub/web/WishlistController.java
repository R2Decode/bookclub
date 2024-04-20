package com.bookclub.web;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    private WishlistDao wishlistDao;

    public WishlistController(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    @Autowired
    private void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    @GetMapping("/list")
    public String showWishlist(Model model) {
        List<WishlistItem> wishlistItems = wishlistDao.list();
        model.addAttribute("wishlistItems", wishlistItems);
        return "wishlist/list";
    }

    @GetMapping("/new")
    public String wishlistForm(Model model) {
        model.addAttribute("wishlistItem", new WishlistItem());
        return "wishlist/new";
    }

    @PostMapping("/add")
    public String addWishlistItem(@Valid @ModelAttribute("wishlistItem") WishlistItem wishlistItem,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }
        wishlistDao.add(wishlistItem);
        return "redirect:/wishlist/list";
    }
}

