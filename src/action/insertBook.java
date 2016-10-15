package action;

import com.opensymphony.xwork2.Action;

import domain.Book;
import service.AuthorService;
import service.BookService;

public class insertBook implements Action {
	private Book book;
	private String authorName;
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String execute() throws Exception {
		BookService bo = new BookService();
		AuthorService au = new AuthorService();
		boolean flag1 = bo.searchBook(book);
		boolean flag2 = false;
		if (flag1==false) {
			flag2 = au.searchAuthor(book.getAuthorID());
			System.out.println(flag2);
			bo.insertBook(book);
			if (flag2==false)
				return "newauthor";
			else
				return SUCCESS;
		}
		return ERROR;
	}

}
