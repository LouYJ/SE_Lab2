package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;

import domain.Book;
import service.BookService;

public class displayBooks implements Action {
	private BookService bo = new BookService();
	private ArrayList<Book> books = new ArrayList<Book>();
	
	public BookService getBo() {
		return bo;
	}

	public void setBo(BookService bo) {
		this.bo = bo;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	@Override
	public String execute() throws Exception {
		books = bo.getAllBooks();
		return SUCCESS;
	}

}
