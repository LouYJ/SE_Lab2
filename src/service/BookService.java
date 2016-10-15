package service;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domain.Author;
import domain.Book;

public class BookService {
	public boolean searchBook(Book bo) {
		Connection conn = getConn();
        String sql_insert = "insert into book (isbn,title,authorid,publisher,publishdate,price) values(?,?,?,?,?,?)";
        String sql = "select * from book";
        PreparedStatement pstmt;
        
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                if(rs.getString(1).equals(bo.getIsbn()))
                    return true;
            }
            pstmt.close();//记得用完数据库要把数据库关掉
            conn.close();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
	}
	
	public boolean insertBook(Book bo) {
		Connection conn = getConn();
        String sql_insert = "insert into book (isbn,title,authorid,publisher,publishdate,price) values(?,?,?,?,?,?)";
        String sql = "select * from book";
        PreparedStatement pstmt;
        
        System.out.println("insert");
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                if(rs.getString(1).equals(bo.getIsbn()))
                    return false;
            }
            
            System.out.println("图书不存在");
            pstmt = (PreparedStatement) conn.prepareStatement(sql_insert);
	        pstmt.setString(1, bo.getIsbn());
	        pstmt.setString(2, bo.getTitle());
	        pstmt.setString(3, bo.getAuthorID());
	        pstmt.setString(4, bo.getPublisher());
	        pstmt.setString(5, bo.getPublishdate());
	        pstmt.setString(6, bo.getPrice());
	        pstmt.executeUpdate();
            pstmt.close();//记得用完数据库要把数据库关掉
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public boolean deleteBook(String ISBN) {
		Connection conn = getConn();
		System.out.println("a"+ISBN);
        String sql = "delete from book where isbn='"+ISBN+"'";//对数据库中的book表进行扫描
        PreparedStatement pstmt;
        int i = 0;
        System.out.println("233");
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            i=pstmt.executeUpdate();
            System.out.println(i);
            System.out.println("in");
            pstmt.close();//记得用完数据库要把数据库关掉
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
	}
	
	public ArrayList<Book> getAllBooks() {
    	ArrayList<Book> all = new ArrayList<Book>();
    	
    	Connection conn = getConn();
        String sql = "select * from book";
        PreparedStatement pstmt;
        
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
            	Book newBook = new Book();
            	newBook.setIsbn(rs.getString(1));
            	newBook.setTitle(rs.getString(2));
            	newBook.setAuthorID(rs.getString(3));
            	newBook.setPublisher(rs.getString(4));
            	newBook.setPublishdate(rs.getString(5));
            	newBook.setPrice(rs.getString(6));
            	all.add(newBook);
            }
            pstmt.close();//记得用完数据库要把数据库关掉
            conn.close();
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public Integer upgradeBook(Book book){
		Connection conn = getConn();
	    int i=0,j=0,k=0,z=0;
	    //System.out.println(book.getAuthorID());
	    
	    
	    
	    String publisher=book.getPublisher();
	    String publishdate=book.getPublishdate();
	    //String isbn =book.getIsbn();
	    String title=book.getTitle();
	    String price=book.getPrice();
	    String authorID=book.getAuthorID();
	    //System.out.println(book.getTitle());
	   
	    String sql1 = "update book set authorid='" + authorID + "' where title='" + title + "'";
	    String sql2 = "update book set publisher='" + publisher + "'where title='" + title + "'";
	    String sql3 = "update book set publishdate='" + publishdate + "' where title='" +title + "'";
	    String sql4 = "update book set price='" + price + "' where title='" +title +"'";
	    //String sql5 = "update book set country='" + isbn + "' where title='" + title+"'";
	    PreparedStatement pstmt1;
	    PreparedStatement pstmt2;
	    PreparedStatement pstmt3;
	    PreparedStatement pstmt4;
	    //PreparedStatement pstmt5;
	    try {
	        pstmt1 = (PreparedStatement) conn.prepareStatement(sql1);
	        pstmt2 = (PreparedStatement) conn.prepareStatement(sql2);
	        pstmt3 = (PreparedStatement) conn.prepareStatement(sql3);
	        pstmt4 = (PreparedStatement) conn.prepareStatement(sql4);
	        //pstmt5 = (PreparedStatement) conn.prepareStatement(sql5);
	        i = pstmt1.executeUpdate();
	        j = pstmt2.executeUpdate();
	        z = pstmt3.executeUpdate();
	        k = pstmt4.executeUpdate();
	        System.out.println("resutl:1 " + i+j+k+z);
	        pstmt1.close();
	        pstmt2.close();
	        pstmt3.close();
	        pstmt4.close();
	        //pstmt5.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	private static Connection getConn() {//获得数据库，写成一个函数，省的每次调用数据库都重复写一遍，只需要调用这个函数就可以了
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://kqntgiohhckt.rds.sae.sina.com.cn:10469/bookdb?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "louyujing127";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
