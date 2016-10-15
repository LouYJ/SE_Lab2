package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;

import domain.Author;
import service.AuthorService;

public class displayAuthors implements Action {
	private AuthorService au = new AuthorService();
	private ArrayList<Author> authors = new ArrayList<Author>();
	
	public ArrayList<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}

	public AuthorService getAu() {
		return au;
	}

	public void setAu(AuthorService au) {
		this.au = au;
	}

	@Override
	public String execute() throws Exception {
		authors = au.getAllAuthors();
		return SUCCESS;
	}

}
