package action;

import com.opensymphony.xwork2.Action;

import domain.Book;
import service.BookService;

public class deleteAction implements Action {
	private Book book;
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String execute() throws Exception {
		BookService bo = new BookService();
		System.out.println(book.getIsbn());
		boolean flag = bo.deleteBook(book.getIsbn());
		if (flag)
			return SUCCESS;
		return ERROR;
	}

}

