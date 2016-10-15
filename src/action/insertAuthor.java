package action;

import com.opensymphony.xwork2.Action;

import domain.Author;
import service.AuthorService;

public class insertAuthor implements Action {
	private Author author;

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String execute() throws Exception {
		AuthorService au = new AuthorService();
		au.insertAuthor(author);
		return SUCCESS;
	}

}
