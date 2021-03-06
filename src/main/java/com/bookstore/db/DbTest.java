package com.bookstore.db;

import com.bookstore.models.user.User;
import com.bookstore.models.book.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class DbTest
 */
public class DbTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static String db_url = "jdbc:mysql://localhost:3306/bookstore?useSSL=false";
	final static String db_username = "admin";
	final static String db_passwd = "A29I^BeEIcck@g";
	
	DBConnectionPool connPool = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DbTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// User read test
		User user = new UserDB().selectUser("timgalvin");
		
		// Read all users
		ArrayList<User> users = new UserDB().selectUsers();
			
		// Book read test
		Book book = new BookDB().selectBook("978-0544272996");
		
		// Test retrieving all books from one genre
		ArrayList<Book> genreBook = new BookDB().selectAllBooksFromGenre("Humor");
		
		// Test retrieving all books from one author
		ArrayList<Book> authorBook = new BookDB().selectAllBooksFromAuthor("Randall Munroe");
		
		request.setAttribute("user", user);
		request.setAttribute("users", users);
		request.setAttribute("book", book);
		request.setAttribute("genreBook", genreBook);
		request.setAttribute("authorBook", authorBook);
		request.getRequestDispatcher("DatabaseTester.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
