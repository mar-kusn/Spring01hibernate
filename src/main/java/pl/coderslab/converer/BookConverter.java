package pl.coderslab.converer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

public class BookConverter implements Converter<String, Book> {
    @Autowired
    private BookDao bookDao;

    @Override
    public Book convert(String s) {
        return this.bookDao.findById(Long.parseLong(s));
    }
}