package com.bookclub.service.dao;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.GenericCrudDao;

import java.util.List;

public interface WishlistDao extends GenericCrudDao<WishlistItem, String> {
    // No need to explicitly declare the add method here since it's already defined in GenericCrudDao

    // Additional methods specified in the assignment instructions
    void update(WishlistItem item);
    boolean remove(WishlistItem item);
    List<WishlistItem> list();
    WishlistItem find(String id);
}
