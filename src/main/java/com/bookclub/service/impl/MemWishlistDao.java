package com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MemWishlistDao implements WishlistDao {

    private List<WishlistItem> wishlist;

    public MemWishlistDao() {
        wishlist = new ArrayList<>();
        // Add some dummy data for testing
        wishlist.add(new WishlistItem("1234567890", "Test Book 1"));
        wishlist.add(new WishlistItem("0987654321", "Test Book 2"));
    }

    @Override
    public void add(WishlistItem item) {
        wishlist.add(item);
    }

    @Override
    public List<WishlistItem> list() {
        return wishlist;
    }

    @Override
    public WishlistItem find(String isbn) {
        for (WishlistItem item : wishlist) {
            if (item.getIsbn().equals(isbn)) {
                return item;
            }
        }
        return null; // Return null if item is not found
    }
}
