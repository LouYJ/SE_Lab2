package action;

import com.opensymphony.xwork2.Action;

import domain.Book;
import service.BookService;

public class upgradeBook implements Action {
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
		System.out.println("要更新了");
		int i = bo.upgradeBook(book);
		if (i!=0)
			return SUCCESS;
		else
			return ERROR;
	}

}
