package com.ssafy.ws;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.model.repo.BookRepo;
import com.ssafy.ws.model.service.BookServiceImpl;

public class WS_01_BeanCreationTest extends AbstractTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		BookServiceImpl bookService = context.getBean("bookServiceImpl", BookServiceImpl.class);
		BookRepo bookRepo = context.getBean("bookRepoImpl", BookRepo.class);
		bookService.setBookRepo(bookRepo);
		
		List<Book> list = bookService.search();
		for(Book book : list) System.out.println(book.getIsbn());
	}
}
