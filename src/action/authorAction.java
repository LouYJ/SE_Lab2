package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;

import domain.Author;
import domain.Book;
import service.AuthorService;

public class authorAction implements Action {
	private Author author;
	private ArrayList<Author> findAuthor = new ArrayList<Author>();
    private ArrayList<Book> findBook = new ArrayList<Book>();
    private ArrayList<Book> bookList = new ArrayList<Book>();
    
    public ArrayList<Author> getFindAuthor() {
		return findAuthor;
	}
	public void setFindAuthor(ArrayList<Author> findAuthor) {
		this.findAuthor = findAuthor;
	}
	public ArrayList<Book> getFindBook() {
		return findBook;
	}
	public void setFindBook(ArrayList<Book> findBook) {
		this.findBook = findBook;
	}
	public ArrayList<Book> getBookList() {
		return bookList;
	}
	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}
	public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    @Override
    public String execute() throws Exception {
        AuthorService au=new AuthorService();
        Integer i =au.validateAuthor(author);
        if (i>0) {
        	findAuthor = au.getAuthorID(author);
        	for (Author tmpA : findAuthor) {
        		findBook = au.getBook(tmpA.getAuthorID());
        		bookList.addAll(findBook);
        	}
        	return SUCCESS;
        }
        else	
        	return ERROR;
    }
}
