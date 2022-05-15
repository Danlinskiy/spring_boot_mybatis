package com.shan;

import com.shan.dao.IBookDao;
import com.shan.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMybatisApplicationTests {
    @Autowired
    IBookDao dao;

    @Test
    void select() {
        Book book = dao.selectById(1);
        System.out.println(book.toString());
    }

    @Test
    void insert() {
        for (int i = 2; i < 100; i++) {
            dao.insert(new Book(i, "type" + i, "name" + i, "description" + i));
            System.out.println(dao.selectById(i).toString());
        }
    }

    @Test
    void update() {
        Book book = new Book();
        book.setId(1);
        book.setName("Hello Shan");
        dao.update(book, null);
        System.out.println(dao.selectById(1).toString());
    }

    @Test
    void delete() {
        for (int i = 2; i < 100; i++) {
            dao.deleteById(i);
        }

        List<Book> list = dao.selectList(null);
        for(Book book: list) {
            System.out.println((book.toString()));
        }
    }

    @Test
    void revertUpdate() {
        Book book = new Book();
        book.setId(1);
        book.setName("Hello progres");
        dao.update(book, null);
        System.out.println(dao.selectById(1).toString());
    }

}
