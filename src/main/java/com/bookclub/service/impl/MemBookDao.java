package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

import java.util.ArrayList;
import java.util.List;

public class MemBookDao implements BookDao {
    private List<Book> books;

    public MemBookDao() {
        this.books = new ArrayList<>();
        // Initialize with sample books
        books.add(new Book("978-0066620732", "To Kill a Mockingbird", "A novel by Harper Lee", 336, List.of("Harper Lee")));
        books.add(new Book("978-0142000670", "1984", "A dystopian novel by George Orwell", 328, List.of("George Orwell")));
        books.add(new Book("978-0743273565", "The Great Gatsby", "A novel by F. Scott Fitzgerald", 180, List.of("F. Scott Fitzgerald")));
        books.add(new Book("978-0547928227", "The Hobbit", "A fantasy novel by J.R.R. Tolkien", 310, List.of("J.R.R. Tolkien")));
        books.add(new Book("978-0141439563", "Jane Eyre", "A novel by Charlotte Brontë", 532, List.of("Charlotte Brontë")));
    }

    @Override
    public List<Book> list() {
        return books;
    }

    @Override
    public Book find(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}
