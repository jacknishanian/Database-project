import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Blob;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.Base64;
import javax.sql.rowset.serial.SerialBlob;

@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
				maxFileSize=1024*1024*50,      	// 50 MB
				maxRequestSize=1024*1024*100)   	// 100 MB


public class ControlServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private userDAO userDAO = new userDAO();
	    private String currentUser;
	    private HttpSession session=null;
	    
	    public ControlServlet()
	    {
	    	
	    }
	    
	    public void init()
	    {
	    	userDAO = new userDAO();
	    	currentUser= "";
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getServletPath();
	        System.out.println(action);
	    
	    try {
        	switch(action) {  
        	case "/login":
        		login(request,response);
        		break;
        	case "/register":
        		register(request, response);
        		break;
        	case "/initialize":
        		userDAO.init();
        		System.out.println("Database successfully initialized!");
        		rootPage(request,response,"");
        		break;
        	case "/root":
        		rootPage(request,response, "");
        		break;
        	case "/owner":
        		ownerPage(request,response, "");
        		break;
        	case "/edit": // should be called when you go to edit a quote
        		System.out.println("Enter edit page");
        		quoteEditer(request,response, currentUser);
        		break;
        	case "/save": // should be called when you go to save an edit
        		System.out.println("Enter edit page");
        		quoteEditer(request,response, currentUser);
        		break;
        	case "/logout":
        		logout(request,response);
        		break;
        	 case "/list": 
                 System.out.println("The action is: list");
                 listUser(request, response);           	
                 break;
	    	}
	    }
	    catch(Exception ex) {
        	System.out.println(ex.getMessage());
	    	}
	    }
        	
	    private void listUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        System.out.println("listUser started: 00000000000000000000000000000000000");

	     
	        List<user> listUser = userDAO.listAllUsers();
	        request.setAttribute("listUser", listUser);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");       
	        dispatcher.forward(request, response);
	     
	        System.out.println("listPeople finished: 111111111111111111111111111111111111");
	    }
	    	        
	    private void rootPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("root view");
			request.setAttribute("listUser", userDAO.listAllUsers());
	    	request.getRequestDispatcher("rootView.jsp").forward(request, response);
	    }
	    private void userPage(HttpServletRequest request, HttpServletResponse response, String userName) throws ServletException, IOException, SQLException{
	    	System.out.println("user view");
			request.setAttribute("user", userDAO.getUser(userName));
			request.getRequestDispatcher("activitypage.jsp").forward(request, response);
	    } 
	    private void ownerPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("owner view");   	
	    	request.setAttribute("listUser", userDAO.getAllUserQuotes());
	    	request.getRequestDispatcher("ownerView.jsp").forward(request, response);
	    	
	    	String client = request.getParameter("client"); // possible use have owner input email of client to edit
	    	
	    	// these next lines are what is planned to take you to the page to edit the quotes
	    	// rn they console output is: edit quote *nextline* Cannot forward after response has been committed
	    	session = request.getSession(); 
			session.setAttribute("username", client);
			quoteEditer(request, response, client);
	    }
	    private void quoteEditer(HttpServletRequest request, HttpServletResponse response, String userName) throws ServletException, IOException, SQLException{
	    	//Need to split function to: go to edit page and Save edits
	    	System.out.println("edit quote");   	
	    	//request.setAttribute("client", userDAO.getUser(userName));
	    	request.getRequestDispatcher("editPage.jsp").forward(request, response);
	    	
	    	
	    	String quote_price = request.getParameter("quote_price"); 
	    	String quote_time = request.getParameter("quote_time");
	    	String quote_note = request.getParameter("quote_note");
	    	String quote_response = request.getParameter("quote_response");
	    	String quote_date = request.getParameter("quote_date");
	    	String work_order_terms = request.getParameter("work_order_terms");
	    	String work_order_status = request.getParameter("work_order_status");
	    	String bill_amount = request.getParameter("bill_amount");
	    	String bill_status = request.getParameter("bill_status");
	    	
	    	//client.setQuote_price(quote_price);
	    	//client.setQuote_time(quote_time);
	    	//client.setQuote_note(quote_note);
	    	//client.setQuote_response(quote_response);
	    	//client.setQuote_date(quote_date);
	    	//client.setWork_order_terms(work_order_terms);
	    	//client.setWork_order_status(work_order_status);
	    	//client.setBill_amount(bill_amount);
	    	//client.setBill_status(bill_status);
	    	
	    	
	    	
	    	
	    	
	    	
	    } // Need to make a userDAO.updateQuote that works the same way as insert
          
      
	    
	    
	    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	 System.out.println("in the login function");
	    	 String email = request.getParameter("email");
	    	 String password = request.getParameter("password");
	    	 
	    	 if (email.equals("root") && password.equals("pass1234")) {
				 System.out.println("Login Successful! Redirecting to root");
				 session = request.getSession();
				 session.setAttribute("username", email);
				 rootPage(request, response, "");
	    	 }
	    	 else if (email.equals("dSmith@email.com") && password.equals("smith1234")) {
				 System.out.println("Login Successful! Redirecting to owner");
				 session = request.getSession();
				 session.setAttribute("username", email);
				 ownerPage(request, response, "");
	    	 }
	    	 else if(userDAO.isValid(email, password)) 
	    	 {
			 	 
			 	 currentUser = email;
				 System.out.println("Login Successful! Redirecting");
				 session = request.getSession();
				 userPage(request, response, email);
				 //
				 //request.getRequestDispatcher("activitypage.jsp").forward(request, response);
			 			 			 			 
	    	 }
	    	 else {
	    		 request.setAttribute("loginStr","Login Failed: Please check your credentials.");
	    		 request.getRequestDispatcher("login.jsp").forward(request, response);
	    	 }
	    }
	           
	    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	String email = request.getParameter("email");  
	    	String firstName = request.getParameter("firstName");  
	    	String lastName = request.getParameter("lastName");   
	    	String password = request.getParameter("password");  
	    	String confirm = request.getParameter("confirmation");
	    	String address = request.getParameter("address");
	    	String phone_num = request.getParameter("phone_num"); 
	    	String card_num = request.getParameter("card_num"); 
	    	String card_date = request.getParameter("card_date"); 
	    	String card_cvc = request.getParameter("card_cvc"); 
	    	String role = "customer"; 
	    	
	    	
	    	//Blob tree_pic1 = toBlob(request.getPart("tree_pic1"));
	    	//Blob tree_pic2 = toBlob(request.getPart("tree_pic2"));
	    	//Blob tree_pic3 = toBlob(request.getPart("tree_pic3"));
	    	System.out.println("made it here");
	    	
	    	//Blob tree_pic1 = toBlob(request.getParameter("tree_pic1"));
	    	//Blob tree_pic2 = toBlob(request.getParameter("tree_pic2"));
	    	//Blob tree_pic3 = toBlob(request.getParameter("tree_pic3"));
	    	
	    	//System.out.println(tree_pic1);

	    	
	    	String id = request.getParameter("email"); 
	    	// make defaults
	    	String quote_price = "N/A"; 
	    	String quote_time = "N/A"; 
	    	String quote_note = "N/A"; 
	    	String quote_response = "N/A"; 
	    	String quote_date = "N/A"; 
	    	String work_order_terms = "N/A"; 
	    	String work_order_status = "N/A"; 
	    	String bill_amount = "N/A"; 
	    	String bill_status = "N/A"; 
	
	   	 	//end defaults
	    	
	   	 	Blob tree_pic1 = toBlob(request.getPart("tree_pic1"));
	   	 	Blob tree_pic2 = toBlob(request.getPart("tree_pic2"));
	    	Blob tree_pic3 = toBlob(request.getPart("tree_pic3"));
	    	
	   	 	String img_1 = null;
	   	 	String img_2 = null;
	   	 	String img_3 = null;
	   	 	
	   	 	if (userDAO.checkAddress(address)) {
	   	 		System.out.println("Address taken, please enter new address");
	 			request.setAttribute("errorOne","Registration failed: Address taken, please enter a new address.");
	 			request.getRequestDispatcher("register.jsp").forward(request, response);
	   	 	}
	   	 	else {
		   	 	if (password.equals(confirm)) {
		   	 		if (!userDAO.checkEmail(email)) {
			   	 		System.out.println("Registration Successful! Added to database");
			   	 		
			   	 		
			            user users = new user(email, firstName, lastName, password, address, phone_num, card_num, card_date, card_cvc, role, id, tree_pic1, tree_pic2, tree_pic3, quote_price, quote_time, quote_note, quote_response, quote_date, work_order_terms, work_order_status, bill_amount, bill_status, img_1, img_2, img_3);
			            System.out.println("made it here2");
			            userDAO.insert(users);
			   	 		response.sendRedirect("login.jsp");
		   	 		}
			   	 	else {
			   	 		System.out.println("Username taken, please enter new username");
			    		request.setAttribute("errorOne","Registration failed: Username taken, please enter a new username.");
			    		request.getRequestDispatcher("register.jsp").forward(request, response);
			   	 	}
		   	 	}
		   	 	else {
		   	 		System.out.println("Password and Password Confirmation do not match");
		   		 request.setAttribute("errorTwo","Registration failed: Password and Password Confirmation do not match.");
		   		 request.getRequestDispatcher("register.jsp").forward(request, response);
		   	 	}
	   	 	}
	    }    

		private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    	currentUser = "";
        		response.sendRedirect("login.jsp");
        	} 
		
		public static Blob toBlob(Part pic) throws SQLException, IOException {
			InputStream inputStream = null;
	   	 	
	   	 	inputStream = pic.getInputStream();
	   	 	byte[] img = inputStream.readAllBytes();
	   	 	return new SerialBlob(img);
			
		}
}
	        
	        
	    
	        
	        
	        
	    


