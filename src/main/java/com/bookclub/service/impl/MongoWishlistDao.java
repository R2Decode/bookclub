package com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao {

    private final MongoTemplate mongoTemplate;

    public MongoWishlistDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void add(WishlistItem item) {
        mongoTemplate.save(item);
    }

    @Override
    public void update(WishlistItem item) {
        mongoTemplate.save(item);
    }

    @Override
    public boolean remove(WishlistItem item) {
        mongoTemplate.remove(item);
        return true; // Assuming successful deletion
    }

    @Override
    public List<WishlistItem> list() {
        return mongoTemplate.findAll(WishlistItem.class);
    }

    @Override
    public WishlistItem find(String id) {
        return mongoTemplate.findById(id, WishlistItem.class);
    }
}
