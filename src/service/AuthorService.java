package service;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domain.Author;
import domain.Book;

public class AuthorService {
    public Integer validateAuthor(Author author) {
        Connection conn = getConn();
        String sql = "select * from author";//对数据库中的authors表进行扫描
        PreparedStatement pstmt;
        System.out.println("0000");
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                if(rs.getString(2).equals(author.getName()))
                    return 1;
            }
            pstmt.close();//记得用完数据库要把数据库关掉
            conn.close();
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public ArrayList<Author> getAuthorID(Author author) {
    	Connection conn = getConn();
        String sql = "select * from author";//对数据库中的authors表进行扫描
        PreparedStatement pstmt;
        ArrayList<Author> find = new ArrayList<Author>();
        
        System.out.println("1111");
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
            	//System.out.println("in");
            	Author newAuthor = new Author();
            	if(rs.getString(2).equals(author.getName())) {//作者名字相匹配
                	newAuthor.setAuthorID(rs.getString(1));
                	newAuthor.setName(rs.getString(2));
                	newAuthor.setAge(rs.getString(3));
                	newAuthor.setCountry(rs.getString(4));
                	find.add(newAuthor);
                	System.out.println(newAuthor.getName());
                }
                    
            }
            pstmt.close();//记得用完数据库要把数据库关掉
            conn.close();
            return find;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Book> getBook(String AuthorID) {
    	Connection conn = getConn();
        String sql = "select * from book";//对数据库中的authors表进行扫描
        PreparedStatement pstmt;
        ArrayList<Book> findBook = new ArrayList<Book>();
        
        System.out.println("2222");
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
            	Book newBook = new Book();//必须在循环内部申明，否则会覆盖之前数据
            	if(rs.getString(3).equals(AuthorID)) {
                	newBook.setIsbn(rs.getString(1));
                	newBook.setTitle(rs.getString(2));
                	newBook.setAuthorID(rs.getString(3));
                	newBook.setPublisher(rs.getString(4));
                	newBook.setPublishdate(rs.getString(5));
                	newBook.setPrice(rs.getString(6));
                	findBook.add(newBook);
                }
            }
            pstmt.close();//记得用完数据库要把数据库关掉
            conn.close();
            return findBook;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean searchAuthor(String authorID) {
    	Connection conn = getConn();
        String sql = "select * from author";//对数据库中的authors表进行扫描
        PreparedStatement pstmt;
        
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
            	if(rs.getString(1).equals(authorID)) {
            		System.out.println("找到作者了");
                	return true;
                }
            }
            pstmt.close();//记得用完数据库要把数据库关掉
            conn.close();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }
    
    public boolean insertAuthor(Author au) {
    	Connection conn = getConn();
        String sql = "select * from author";//对数据库中的authors表进行扫描
        String sql_insert = "insert into author (authorid,name,age,country) values(?,?,?,?)";
        PreparedStatement pstmt;
        
        System.out.println("insertauthor");
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
            	if(rs.getString(1).equals(au.getAuthorID())) {//作者名字相匹配
                	return false;
                }   
            }
            pstmt = (PreparedStatement) conn.prepareStatement(sql_insert);
	        pstmt.setString(1, au.getAuthorID());
	        pstmt.setString(2, au.getName());
	        pstmt.setString(3, au.getAge());
	        pstmt.setString(4, au.getCountry());
	        pstmt.executeUpdate();
            pstmt.close();//记得用完数据库要把数据库关掉
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Author> getAllAuthors() {
    	ArrayList<Author> all = new ArrayList<Author>();
    	
    	Connection conn = getConn();
        String sql = "select * from author";//对数据库中的authors表进行扫描
        PreparedStatement pstmt;
        
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
            	Author newAuthor = new Author();
            	newAuthor.setAuthorID(rs.getString(1));
            	newAuthor.setName(rs.getString(2));
            	newAuthor.setAge(rs.getString(3));
            	newAuthor.setCountry(rs.getString(4));
            	all.add(newAuthor);
            }
            pstmt.close();//记得用完数据库要把数据库关掉
            conn.close();
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
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