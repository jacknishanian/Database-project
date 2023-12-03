import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;
import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.io.InputStream;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/userDAO")
public class userDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private PreparedStatement preparedStatement2 = null;
	private PreparedStatement preparedStatement3 = null;
	private PreparedStatement preparedStatement4 = null;
	private PreparedStatement preparedStatement5 = null;
	private PreparedStatement preparedStatement6 = null;
	private PreparedStatement preparedStatement7 = null;
	private PreparedStatement preparedStatement8 = null;
	private PreparedStatement preparedStatement9 = null;
	private PreparedStatement preparedStatement10 = null;
	
	private ResultSet resultSet = null;
	
	public userDAO(){}
	
	/** 
	 * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
    	//uses default connection to the database
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projectdb?allowPublicKeyRetrieval=true&useSSL=false&user=dave&password=pass1234");
            System.out.println(connect);
        }
    }
    
    public String picToImg(Blob tree_pic) throws IOException, SQLException {
    	String img;
    	InputStream inputStream = tree_pic.getBinaryStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);                  
        }
        byte[] imageBytes = outputStream.toByteArray();
        img = Base64.getEncoder().encodeToString(imageBytes);
        String img2 = Base64.getEncoder().encodeToString(imageBytes);
        inputStream.close();
        outputStream.close();
        
        //return img;
        return img2;
    }
    
    public boolean database_login(String email, String password) throws SQLException{
    	try {
    		connect_func("root","pass1234");
    		String sql = "select * from user where email = ?";
    		preparedStatement = connect.prepareStatement(sql);
    		preparedStatement.setString(1, email);
    		ResultSet rs = preparedStatement.executeQuery();
    		return rs.next();
    	}
    	catch(SQLException e) {
    		System.out.println("failed login");
    		return false;
    	}
    }
	//connect to the database 
    public void connect_func(String username, String password) throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/userdb?"
  			          + "useSSL=false&user=" + username + "&password=" + password);
            System.out.println(connect);
        }
    }
    
    public List<user> listAllUsers() throws SQLException, IOException {
        List<user> listUser = new ArrayList<user>();        
        //String sql = "SELECT * FROM User LEFT JOIN Quotes ON User.email = Quotes.id UNION SELECT * FROM User RIGHT JOIN Quotes ON User.email = Quotes.id";
        String sql = "SELECT * FROM User WHERE role ='customer'";
        connect_func();
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String email = resultSet.getString("email");
        	String firstName = resultSet.getString("firstName");
        	String lastName = resultSet.getString("lastName");
        	String password = resultSet.getString("password");
        	String address = resultSet.getString("address");
        	String phone_num = resultSet.getString("phone_num");
        	String card_num = resultSet.getString("card_num");
        	String card_date = resultSet.getString("card_date");
        	String card_cvc = resultSet.getString("card_cvc");
        	String role = resultSet.getString("role");
        	String treeInfo_id = resultSet.getString("treeInfo_id");
        	String payment_id = resultSet.getString("payment_id");
        	String billResponse_id = resultSet.getString("billResponse_id");
        	String disputes_id = resultSet.getString("disputes_id");
        	String orderOfWork_id = resultSet.getString("orderOfWork_id");
        	String bill_id = resultSet.getString("bill_id");
        	String requestQuote_id = resultSet.getString("requestQuote_id");
        	String quoteResponse_id = resultSet.getString("quoteResponse_id");
        	
        	String size;
        	String height;
        	String location;
        	String house_dist;
        	String bill_response_note;
        	String bill_response_date;
        	String amount_paid;
        	String payment_date;
        	String dispute_note;
        	String dispute_date;
        	String terms_agreed;
        	String oow_status;
        	String amount_due;
        	String bill_status;
        	String bill_note;
        	String request_note;
        	String request_status;
        	String quote_response_note;
        	String quote_response_status;

        	
        	String img_1;
        	String img_2;
        	String img_3;

        	
        	
        	System.out.println(treeInfo_id);
        	if (treeInfo_id != null) {
        		System.out.println(treeInfo_id);
        		bill_response_note = resultSet.getString("bill_response_note");
        		bill_response_date = resultSet.getString("bill_response_date");
        		amount_paid = resultSet.getString("amount_paid");
        		payment_date = resultSet.getString("payment_date");
        		dispute_note = resultSet.getString("dispute_note");
        		dispute_date = resultSet.getString("dispute_date");
        		terms_agreed = resultSet.getString("terms_agreed");
        		oow_status = resultSet.getString("oow_status");
        		amount_due = resultSet.getString("amount_due");
        		bill_status = resultSet.getString("bill_status");
        		bill_note = resultSet.getString("bill_note");
        		request_note = resultSet.getString("request_note");
        		request_status = resultSet.getString("request_status");
        		quote_response_note = resultSet.getString("quote_response_note");
        		quote_response_status = resultSet.getString("quote_response_status");
        		size = resultSet.getString("size");
        		height = resultSet.getString("height");
        		location = resultSet.getString("location");
        		house_dist = resultSet.getString("house_dist");
        		
                treeInfo_id = resultSet.getString("treeInfo_id");
                payment_id = resultSet.getString("payment_id");
                billResponse_id = resultSet.getString("billResponse_id");
                disputes_id = resultSet.getString("disputes_id");
                orderOfWork_id = resultSet.getString("orderOfWork_id");
                bill_id = resultSet.getString("bill_id");
                requestQuote_id = resultSet.getString("requestQuote_id");
                quoteResponse_id = resultSet.getString("quoteResponse_id");
                
        	}
        	else {
        		
        		size = "N/A";
        		height = "N/A";
        		location = "N/A";
        		house_dist = "N/A";
        		bill_response_note = "N/A";
        		bill_response_date = "N/A";
        		amount_paid = "N/A";
        		payment_date = "N/A";
        		dispute_note = "N/A";
        		dispute_date = "N/A";
        		terms_agreed = "N/A";
        		oow_status = "N/A";
        		amount_due = "N/A";
        		bill_status = "N/A";
        		bill_note = "N/A";
        		request_note = "N/A";
        		request_status = "N/A";
        		quote_response_note = "N/A";
        		quote_response_status = "N/A";
        		
        		
            	img_1 = null;
            	img_2 = null;
            	img_3 = null;
            	
            	treeInfo_id = "N/A";
            	payment_id = "N/A";
            	billResponse_id = "N/A";
            	disputes_id = "N/A";
            	orderOfWork_id = "N/A";
            	bill_id = "N/A";
            	requestQuote_id = "N/A";
            	quoteResponse_id = "N/A";
        	}
        	
        	
             
            user users = new user(email, firstName, lastName, password, address, phone_num, card_num, card_date, card_cvc, role, size, height, location, house_dist, bill_response_note, bill_response_date, amount_paid, payment_date, dispute_note, dispute_date, terms_agreed, oow_status, amount_due, bill_status, bill_note, request_note, request_status, quote_response_note, quote_response_status, treeInfo_id, payment_id, billResponse_id, disputes_id, orderOfWork_id, bill_id, requestQuote_id, quoteResponse_id);
            listUser.add(users);
        }        
        resultSet.close();
        disconnect();        
        return listUser;
    }
    
    
    //needs testing
    public List<quote> getAllUserQuotes() throws SQLException, IOException {
    	List<quote> listQuote = new ArrayList<quote>(); 

    	
    	
    	String sql2 = "SELECT * FROM TreeInfo";

        connect_func();
        
        
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql2);

         
        while (resultSet.next()) {

        	String id = resultSet.getString("treeInfo_id");
        	
        	String size = resultSet.getString("size");
        	String height = resultSet.getString("height");
        	String location = resultSet.getString("location");
        	String house_dist = resultSet.getString("house_dist");
        	
        	

        	
        	String bill_response_note = null;
        	String bill_response_date = null;
        	
        	String amount_paid = null;
        	String payment_date = null;
        	
        	String dispute_note = null;
        	String dispute_date = null;
        	
        	String terms_agreed = null;
        	String oow_status = null;
        	
        	String amount_due = null;
        	String bill_status = null;
        	String bill_note = null;
        	
        	String request_note = null;
        	String request_status = null;
        	
        	String quote_response_note = null;
        	String quote_response_status = null;
            

            quote quotes = new quote(id, size, height, location, house_dist, bill_response_note, bill_response_date, amount_paid, payment_date, dispute_note, dispute_date, terms_agreed, oow_status, amount_due, bill_status, bill_note, request_note, request_status, quote_response_note, quote_response_status);
            listQuote.add(quotes);
        }        
        resultSet.close();
        disconnect();        
        return listQuote;
    }
    
    public List<quote> getAllSingleTreeQuotes() throws SQLException, IOException {
    	List<quote> listQuote = new ArrayList<quote>(); 

    	
    	
    	String sql2 = "SELECT * FROM TreeInfo WHERE num_trees='1'";

        connect_func();
        
        
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql2);

         
        while (resultSet.next()) {

        	String id = resultSet.getString("treeInfo_id");
        	
        	String size = resultSet.getString("size");
        	String height = resultSet.getString("height");
        	String location = resultSet.getString("location");
        	String house_dist = resultSet.getString("house_dist");
        	String num_trees = resultSet.getString("num_trees");
        	

        	
        	String bill_response_note = null;
        	String bill_response_date = null;
        	
        	String amount_paid = null;
        	String payment_date = null;
        	
        	String dispute_note = null;
        	String dispute_date = null;
        	
        	String terms_agreed = null;
        	String oow_status = null;
        	
        	String amount_due = null;
        	String bill_status = null;
        	String bill_note = null;
        	
        	String request_note = null;
        	String request_status = null;
        	
        	String quote_response_note = null;
        	String quote_response_status = null;
            

        	
        	
        	System.out.println("id: " + id);
        	System.out.println("tree size: " + size);
        	System.out.println("tree num: " + num_trees);
            quote quotes = new quote(id, size, height, location, house_dist, num_trees, bill_response_note, bill_response_date, amount_paid, payment_date, dispute_note, dispute_date, terms_agreed, oow_status, amount_due, bill_status, bill_note, request_note, request_status, quote_response_note, quote_response_status);
            listQuote.add(quotes);
        }        
        resultSet.close();
        disconnect();        
        return listQuote;
    }
 
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void insertOwnerResponse1(String id, String terms_agreed, String oow_status, String amount_due, String bill_status, String bill_note, String request_note, String request_status) throws SQLException { 
    	//connect_func("root","pass1234");
    	connect_func();
    	
    	String delOOW = "DELETE FROM OrderOfWork where orderOfWork_id = ?";
    	preparedStatement4 = (PreparedStatement) connect.prepareStatement(delOOW);
        preparedStatement4.setString(1, id);
        preparedStatement4.executeUpdate();
        
        String delBill = "DELETE FROM Bill where bill_id = ?";
    	preparedStatement5 = (PreparedStatement) connect.prepareStatement(delBill);
        preparedStatement5.setString(1, id);
        preparedStatement5.executeUpdate();
        
        String delReqResp = "DELETE FROM RequestQuote where requestQuote_id = ?";
    	preparedStatement6 = (PreparedStatement) connect.prepareStatement(delReqResp);
        preparedStatement6.setString(1, id);
        preparedStatement6.executeUpdate();
        
        System.out.println("made it here");
        
        
    	String insOOW = "insert into OrderOfWork(orderOfWork_id, terms_agreed, oow_status) values (?, ?, ?)";
    	String insBill = "insert into Bill(bill_id, amount_due, bill_status, bill_note) values (?, ?, ?, ?)";
    	String insReqResp = "insert into RequestQuote(requestQuote_id, request_note, request_status) values (?, ?, ?)";
    	
    	
    	preparedStatement = (PreparedStatement) connect.prepareStatement(insOOW);
    	preparedStatement2 = (PreparedStatement) connect.prepareStatement(insBill);
    	preparedStatement3 = (PreparedStatement) connect.prepareStatement(insReqResp);
    	
    	preparedStatement.setString(1, id);
		preparedStatement.setString(2, terms_agreed);
		preparedStatement.setString(3, oow_status);
		
		preparedStatement2.setString(1, id);
		preparedStatement2.setString(2, amount_due);
		preparedStatement2.setString(3, bill_status);
		preparedStatement2.setString(4, bill_note);
		
		preparedStatement3.setString(1, id);
		preparedStatement3.setString(2, request_note);
		preparedStatement3.setString(3, "Sent For approval");
		
		preparedStatement.executeUpdate();
		preparedStatement2.executeUpdate();
		preparedStatement3.executeUpdate();
    }
    
    public void insertClientResponse(String id, String bill_response_note, String bill_response_date, String dispute_note, String dispute_date) throws SQLException { 
    	connect_func();
    	System.out.println("here");
    	String delBillResp = "DELETE FROM BillResponse where billResponse_id = ?";
    	preparedStatement3 = (PreparedStatement) connect.prepareStatement(delBillResp);
        preparedStatement3.setString(1, id);
        preparedStatement3.executeUpdate();
        
        System.out.println("now here");
        
        String delDisp = "DELETE FROM Disputes where disputes_id = ?";
    	preparedStatement4 = (PreparedStatement) connect.prepareStatement(delDisp);
        preparedStatement4.setString(1, id);
        preparedStatement4.executeUpdate();
    	
    	String insBillResp = "insert into BillResponse(billResponse_id, bill_response_note, bill_response_date) values (?, ?, ?)";
    	String insDisp = "insert into Disputes(disputes_id, dispute_note, dispute_date) values (?, ?, ?)";
    	
    	preparedStatement = (PreparedStatement) connect.prepareStatement(insBillResp);
    	preparedStatement2 = (PreparedStatement) connect.prepareStatement(insDisp);
  
    	preparedStatement.setString(1, id);
    	preparedStatement.setString(2, bill_response_note);
		preparedStatement.setString(3, bill_response_date);
		
		preparedStatement2.setString(1, id);
		preparedStatement2.setString(2, dispute_note);
		preparedStatement2.setString(3, dispute_date);


		preparedStatement.executeUpdate();
		preparedStatement2.executeUpdate();
    }
    public void insertClientResponseFinal(String id, String quote_response_status, String quote_response_note) throws SQLException { 
    	connect_func();
    	System.out.println("in respones final");
    	String delReqResp = "DELETE FROM RequestQuote where requestQuote_id = ?";
    	preparedStatement2 = (PreparedStatement) connect.prepareStatement(delReqResp);
        preparedStatement2.setString(1, id);
        preparedStatement2.executeUpdate();
        
        
    	String insReqResp = "insert into RequestQuote(requestQuote_id, quote_response_note, quote_response_status) values (?, ?, ?)";
    	
    	preparedStatement = (PreparedStatement) connect.prepareStatement(insReqResp);

  
    	preparedStatement.setString(1, id);
    	preparedStatement.setString(2, "Approved");
    	preparedStatement.setString(3, quote_response_note);


		preparedStatement.executeUpdate();
    }
    
    public void insertOwnerResponseFinal(String id, String payment_date, String amount_paid) throws SQLException { 
    	//connect_func("root","pass1234");
    	connect_func();
    	System.out.println("Made it here2");
    	String delPayment = "DELETE FROM Payment where payment_id = ?";
    	preparedStatement2 = (PreparedStatement) connect.prepareStatement(delPayment);
        preparedStatement2.setString(1, id);
        preparedStatement2.executeUpdate();
        System.out.println("Made it here");
        
    	String insPayment = "insert into Payment(payment_id, amount_paid, payment_date) values (?, ?, ?)";
    	
    	
    	System.out.println("in the insert/update func");
    	System.out.println(id);
    	preparedStatement = (PreparedStatement) connect.prepareStatement(insPayment);

    	preparedStatement.setString(1, id);
    	preparedStatement.setString(2, payment_date);
		preparedStatement.setString(3, amount_paid);
		
		preparedStatement.executeUpdate();
        //preparedStatement.close();


    }
    
    public void insert(user users) throws SQLException {
    	connect_func("root","pass1234");         
		String sql = "insert into User(email, firstName, lastName, password, address, phone_num, card_num, card_date, card_cvc ,role) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String quote = "insert into Quotes(id, quote_price, quote_time, quote_note, quote_response, quote_date, work_order_terms, work_order_status, bill_amount, bill_status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		String treeInfo = "insert into TreeInfo(id, size, height, location, house_dist,) values (?, ?, ?)";
		String payment = "insert into Payment(id, amount_paid, payment_date) values (?, ?, ?)";
		String billResponse = "insert into BillResponse(id, bill_response_note, bill_response_date) values (?, ?, ?)";
		String disputes = "insert into Disputes(id, dispute_note, dispute_date) values (?, ?, ?)";
		String orderOfWork = "insert into OrderOfWork(id, terms_agreed, oow_status) values (?, ?, ?)";
		String bill = "insert into Bill(id, amount_due, bill_status, bill_note) values (?, ?, ?, ?)";
		String requestQuote = "insert into RequestQuote(id, request_note, request_status) values (?, ?, ?)";
		String quoteResponse = "insert into QuoteResponse(id, quote_response_note, quote_response_status) values (?, ?, ?)";
		
		
		
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement2 = (PreparedStatement) connect.prepareStatement(quote);
		
		preparedStatement3 = (PreparedStatement) connect.prepareStatement(treeInfo);
		preparedStatement4 = (PreparedStatement) connect.prepareStatement(payment);
		preparedStatement5 = (PreparedStatement) connect.prepareStatement(billResponse);
		preparedStatement6 = (PreparedStatement) connect.prepareStatement(disputes);
		preparedStatement7 = (PreparedStatement) connect.prepareStatement(orderOfWork);
		preparedStatement8 = (PreparedStatement) connect.prepareStatement(bill);
		preparedStatement9 = (PreparedStatement) connect.prepareStatement(requestQuote);
		preparedStatement10 = (PreparedStatement) connect.prepareStatement(quoteResponse);
		
		preparedStatement.setString(1, users.getEmail());
		preparedStatement.setString(2, users.getFirstName());
		preparedStatement.setString(3, users.getLastName());
		preparedStatement.setString(4, users.getPassword());
		preparedStatement.setString(5, users.getAddress());
		preparedStatement.setString(6, users.getPhone_num());
		preparedStatement.setString(7, users.getCard_num());
		preparedStatement.setString(8, users.getCard_date());
		preparedStatement.setString(9, users.getCard_cvc());
		preparedStatement.setString(10, users.getRole());
		preparedStatement.executeUpdate();
        preparedStatement.close();
	


        
        
        
        preparedStatement3.setString(1, users.getSize());
        preparedStatement3.setString(2, users.getHeight());
        preparedStatement3.setString(3, users.getLocation());
        preparedStatement3.setString(4, users.getHouse_dist());
      
        preparedStatement3.executeUpdate();
        preparedStatement3.close();
        
        preparedStatement4.setString(1, users.getBill_response_note());
        preparedStatement4.setString(2, users.getBill_response_date());
        preparedStatement4.executeUpdate();
        preparedStatement4.close();
        
        preparedStatement5.setString(1, users.getAmount_paid());
        preparedStatement5.setString(2, users.getPayment_date());
        preparedStatement5.executeUpdate();
        preparedStatement5.close();
        
        preparedStatement6.setString(1, users.getDispute_note());
        preparedStatement6.setString(2, users.getDispute_date());
        preparedStatement6.executeUpdate();
        preparedStatement6.close();
        
        preparedStatement7.setString(1, users.getTerms_agreed());
        preparedStatement7.setString(2, users.getOow_status());
        preparedStatement7.executeUpdate();
        preparedStatement7.close();
        
        preparedStatement8.setString(1, users.getAmount_due());
        preparedStatement8.setString(2, users.getBill_status());
        preparedStatement8.setString(3, users.getBill_note());
        preparedStatement8.executeUpdate();
        preparedStatement8.close();
        
        preparedStatement9.setString(1, users.getRequest_note());
        preparedStatement9.setString(2, users.getRequest_status());
        preparedStatement9.executeUpdate();
        preparedStatement9.close();
        
        preparedStatement10.setString(1, users.getQuote_response_note());
        preparedStatement10.setString(2, users.getQuote_response_status());
        preparedStatement10.executeUpdate();
        preparedStatement10.close();
    }
    
    public void insertQuote(quote quotes) throws SQLException {
    	connect_func("root","pass1234");         
		
		
		String treeInfo = "insert into TreeInfo(id, size, height, location, house_dist) values (?, ?, ?)";
		String payment = "insert into Payment(id, amount_paid, payment_date) values (?, ?, ?)";
		String billResponse = "insert into BillResponse(id, bill_response_note, bill_response_date) values (?, ?, ?)";
		String disputes = "insert into Disputes(id, dispute_note, dispute_date) values (?, ?, ?)";
		String orderOfWork = "insert into OrderOfWork(id, terms_agreed, oow_status) values (?, ?, ?)";
		String bill = "insert into Bill(id, amount_due, bill_status, bill_note) values (?, ?, ?, ?)";
		String requestQuote = "insert into RequestQuote(id, request_note, request_status) values (?, ?, ?)";
		String quoteResponse = "insert into QuoteResponse(id, quote_response_note, quote_response_status) values (?, ?, ?)";
		
		
		preparedStatement3 = (PreparedStatement) connect.prepareStatement(treeInfo);
		preparedStatement4 = (PreparedStatement) connect.prepareStatement(payment);
		preparedStatement5 = (PreparedStatement) connect.prepareStatement(billResponse);
		preparedStatement6 = (PreparedStatement) connect.prepareStatement(disputes);
		preparedStatement7 = (PreparedStatement) connect.prepareStatement(orderOfWork);
		preparedStatement8 = (PreparedStatement) connect.prepareStatement(bill);
		preparedStatement9 = (PreparedStatement) connect.prepareStatement(requestQuote);
		preparedStatement10 = (PreparedStatement) connect.prepareStatement(quoteResponse);
		

		preparedStatement.executeUpdate();
        preparedStatement.close();
	


        
        
        
        preparedStatement3.setString(1, quotes.getSize());
        preparedStatement3.setString(2, quotes.getHeight());
        preparedStatement3.setString(3, quotes.getLocation());
        preparedStatement3.setString(4, quotes.getHouse_dist());
        
        preparedStatement3.executeUpdate();
        preparedStatement3.close();
        
        preparedStatement4.setString(1, quotes.getBill_response_note());
        preparedStatement4.setString(2, quotes.getBill_response_date());
        preparedStatement4.executeUpdate();
        preparedStatement4.close();
        
        preparedStatement5.setString(1, quotes.getAmount_paid());
        preparedStatement5.setString(2, quotes.getPayment_date());
        preparedStatement5.executeUpdate();
        preparedStatement5.close();
        
        preparedStatement6.setString(1, quotes.getDispute_note());
        preparedStatement6.setString(2, quotes.getDispute_date());
        preparedStatement6.executeUpdate();
        preparedStatement6.close();
        
        preparedStatement7.setString(1, quotes.getTerms_agreed());
        preparedStatement7.setString(2, quotes.getOow_status());
        preparedStatement7.executeUpdate();
        preparedStatement7.close();
        
        preparedStatement8.setString(1, quotes.getAmount_due());
        preparedStatement8.setString(2, quotes.getBill_status());
        preparedStatement8.setString(3, quotes.getBill_note());
        preparedStatement8.executeUpdate();
        preparedStatement8.close();
        
        preparedStatement9.setString(1, quotes.getRequest_note());
        preparedStatement9.setString(2, quotes.getRequest_status());
        preparedStatement9.executeUpdate();
        preparedStatement9.close();
        
        preparedStatement10.setString(1, quotes.getQuote_response_note());
        preparedStatement10.setString(2, quotes.getQuote_response_status());
        preparedStatement10.executeUpdate();
        preparedStatement10.close();
    }
    public void approveQuote(String id) throws SQLException {
    	connect_func();
    	System.out.println("in respones final");
    	String delReqResp = "DELETE FROM QuoteResponse where quoteResponse_id = ?";
    	preparedStatement2 = (PreparedStatement) connect.prepareStatement(delReqResp);
        preparedStatement2.setString(1, id);
        preparedStatement2.executeUpdate();
        
        
    	String insReqResp = "insert into QuoteResponse(quoteResponse_id, quote_response_note, quote_response_status) values (?, ?, ?)";
    	
    	preparedStatement = (PreparedStatement) connect.prepareStatement(insReqResp);
    	
    	System.out.println("past del");
    	
    	preparedStatement.setString(1, id);
    	preparedStatement.setString(2, "Approved");
    	preparedStatement.setString(3, "Notes here");


		preparedStatement.executeUpdate();
		
		System.out.println("eof");
    }
    public boolean deleteQuote(String id) throws SQLException {
     
        
        String treeInfo = "DELETE FROM TreeInfo where treeInfo_id = ?";
        String payment = "DELETE FROM Payment where payment_id = ?";
        String billResponse = "DELETE FROM BillResponse where billResponse_id = ?";
        String disputes = "DELETE FROM Disputes where disputes_id = ?";
        String orderOfWork = "DELETE FROM OrderOfWork where orderOfWork_id = ?";
        String bill = "DELETE FROM Bill where bill_id = ?";
        String requestQuote = "DELETE FROM RequestQuote where requestQuote_id = ?";
        String quoteResponse = "DELETE FROM QuoteResponse where quoteResponse_id = ?";
        
        connect_func();
         

        preparedStatement3 = (PreparedStatement) connect.prepareStatement(treeInfo);
        preparedStatement3.setString(1, id);

        preparedStatement4 = (PreparedStatement) connect.prepareStatement(payment);
        preparedStatement4.setString(1, id);

        preparedStatement5 = (PreparedStatement) connect.prepareStatement(billResponse);
        preparedStatement5.setString(1, id);

        preparedStatement6 = (PreparedStatement) connect.prepareStatement(disputes);
        preparedStatement6.setString(1, id);

        preparedStatement7 = (PreparedStatement) connect.prepareStatement(orderOfWork);
        preparedStatement7.setString(1, id);

        preparedStatement8 = (PreparedStatement) connect.prepareStatement(bill);
        preparedStatement8.setString(1, id);

        preparedStatement9 = (PreparedStatement) connect.prepareStatement(requestQuote);
        preparedStatement9.setString(1, id);

        preparedStatement10 = (PreparedStatement) connect.prepareStatement(quoteResponse);
        preparedStatement10.setString(1, id);
         
        //boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement3.close();
        preparedStatement4.close();
        preparedStatement5.close();
        preparedStatement6.close();
        preparedStatement7.close();
        preparedStatement8.close();
        preparedStatement9.close();
        preparedStatement10.close();
        
        return true;  
    }
    
    
    public boolean delete(String email) throws SQLException {
        String sql = "DELETE FROM User WHERE email = ?";     
        String quote = "DELETE FROM Quote WHERE id = ?"; 
        
        String treeInfo = "DELETE FROM TreeInfo where id = ?";
        String payment = "DELETE FROM Payment where id = ?";
        String billResponse = "DELETE FROM BillResponse where id = ?";
        String disputes = "DELETE FROM Disputes where id = ?";
        String orderOfWork = "DELETE FROM OrderOfWork where id = ?";
        String bill = "DELETE FROM Bill where id = ?";
        String requestQuote = "DELETE FROM RequestQuote where id = ?";
        String quoteResponse = "DELETE FROM QuoteResponse where id = ?";
        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
        
        preparedStatement2 = (PreparedStatement) connect.prepareStatement(quote);
        preparedStatement2.setString(1, email);
        
        preparedStatement3 = (PreparedStatement) connect.prepareStatement(treeInfo);
        preparedStatement3.setString(1, email);

        preparedStatement4 = (PreparedStatement) connect.prepareStatement(payment);
        preparedStatement4.setString(1, email);

        preparedStatement5 = (PreparedStatement) connect.prepareStatement(billResponse);
        preparedStatement5.setString(1, email);

        preparedStatement6 = (PreparedStatement) connect.prepareStatement(disputes);
        preparedStatement6.setString(1, email);

        preparedStatement7 = (PreparedStatement) connect.prepareStatement(orderOfWork);
        preparedStatement7.setString(1, email);

        preparedStatement8 = (PreparedStatement) connect.prepareStatement(bill);
        preparedStatement8.setString(1, email);

        preparedStatement9 = (PreparedStatement) connect.prepareStatement(requestQuote);
        preparedStatement9.setString(1, email);

        preparedStatement10 = (PreparedStatement) connect.prepareStatement(quoteResponse);
        preparedStatement10.setString(1, email);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    public boolean update(user users) throws SQLException {
    	String quote = "insert into Quotes(id, quotes_content, quotes_response, quotes_status, work_order_content, work_order_status, bill_of_work_content, bill_of_work_status,) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sql = "update User set firstName=?, lastName =?,password = ?, card_num=?, card_date=?, card_cvc=?, role=? where email = ?";
        
        String treeInfo = "update TreeInfo set id=?, size=?, height=?, location=?, house_dist=?";
        String payment = "update Payment set id=?, amount_paid=?, payment_date=?";
        String billResponse = "update BillResponse set id=?, bill_response_note=?, bill_response_date=?";
        String disputes = "update Disputes set id=?, dispute_note=?, dispute_date=?";
        String orderOfWork = "update OrderOfWork set id=?, terms_agreed=?, oow_status=?";
        String bill = "update Bill set id=?, amount_due=?, bill_status=?, bill_note";
        String requestQuote = "update RequestQuote set id=?, request_note=?, request_status=?";
        String quoteResponse = "update QuoteResponse set id=?, quote_response_note=?, quote_response_status=?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement2 = (PreparedStatement) connect.prepareStatement(quote);
		preparedStatement3 = (PreparedStatement) connect.prepareStatement(treeInfo);
		preparedStatement4 = (PreparedStatement) connect.prepareStatement(payment);
		preparedStatement5 = (PreparedStatement) connect.prepareStatement(billResponse);
		preparedStatement6 = (PreparedStatement) connect.prepareStatement(disputes);
		preparedStatement7 = (PreparedStatement) connect.prepareStatement(orderOfWork);
		preparedStatement8 = (PreparedStatement) connect.prepareStatement(bill);
		preparedStatement9 = (PreparedStatement) connect.prepareStatement(requestQuote);
		preparedStatement10 = (PreparedStatement) connect.prepareStatement(quoteResponse);

        preparedStatement.setString(1, users.getEmail());
        preparedStatement.setString(2, users.getFirstName());
        preparedStatement.setString(3, users.getLastName());
        preparedStatement.setString(4, users.getPassword());
        preparedStatement.setString(5, users.getAddress());
        preparedStatement.setString(6, users.getPhone_num());
        preparedStatement.setString(7, users.getCard_num());
        preparedStatement.setString(8, users.getCard_date());
        preparedStatement.setString(9, users.getCard_cvc());
        preparedStatement.setString(10, users.getRole());
       
        
        
        preparedStatement3.setString(1, users.getSize());
        preparedStatement3.setString(2, users.getHeight());
        preparedStatement3.setString(3, users.getLocation());
        preparedStatement3.setString(4, users.getHouse_dist());
     
        preparedStatement3.executeUpdate();
        preparedStatement3.close();
        
        preparedStatement4.setString(1, users.getBill_response_note());
        preparedStatement4.setString(2, users.getBill_response_date());
        preparedStatement4.executeUpdate();
        preparedStatement4.close();
        
        preparedStatement5.setString(1, users.getAmount_paid());
        preparedStatement5.setString(2, users.getPayment_date());
        preparedStatement5.executeUpdate();
        preparedStatement5.close();
        
        preparedStatement6.setString(1, users.getDispute_note());
        preparedStatement6.setString(2, users.getDispute_date());
        preparedStatement6.executeUpdate();
        preparedStatement6.close();
        
        preparedStatement7.setString(1, users.getTerms_agreed());
        preparedStatement7.setString(2, users.getOow_status());
        preparedStatement7.executeUpdate();
        preparedStatement7.close();
        
        preparedStatement8.setString(1, users.getAmount_due());
        preparedStatement8.setString(2, users.getBill_status());
        preparedStatement8.setString(3, users.getBill_note());
        preparedStatement8.executeUpdate();
        preparedStatement8.close();
        
        preparedStatement9.setString(1, users.getRequest_note());
        preparedStatement9.setString(2, users.getRequest_status());
        preparedStatement9.executeUpdate();
        preparedStatement9.close();
        
        preparedStatement10.setString(1, users.getQuote_response_note());
        preparedStatement10.setString(2, users.getQuote_response_status());
        preparedStatement10.executeUpdate();
        preparedStatement10.close();

         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        
        return rowUpdated;     
    }
    
    public user getUser(String email) throws SQLException, IOException {
    	user user = null; 
    	//String sql = "SELECT * FROM User LEFT JOIN Quotes on User.email = Quotes.id where email = ?";
    	String sql = "SELECT * FROM User, TreeInfo, Payment, BillResponse, Disputes, OrderOfWork, Bill, RequestQuote, QuoteResponse WHERE User.email = ?";
        connect_func();
        
        String test = "SELECT * FROM OrderOfWork WHERE orderOfWork_id = ?";
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
        
        
        ResultSet resultSet = preparedStatement.executeQuery();
        
//        preparedStatement2 = (PreparedStatement) connect.prepareStatement(test);
//        preparedStatement2.setString(1, email);
//        ResultSet resultSet2 = preparedStatement2.executeQuery();

        if (resultSet.next()) {
        	String firstName = resultSet.getString("firstName");
        	String lastName = resultSet.getString("lastName");
        	String password = resultSet.getString("password");
        	String address = resultSet.getString("address");
        	String phone_num = resultSet.getString("phone_num");
        	String card_num = resultSet.getString("card_num");
        	String card_date = resultSet.getString("card_date");
        	String card_cvc = resultSet.getString("card_cvc");
        	String role = resultSet.getString("role");
        	String bill_response_note = resultSet.getString("bill_response_note");
        	String bill_response_date = resultSet.getString("bill_response_date");
        	String amount_paid = resultSet.getString("amount_paid");
        	String payment_date = resultSet.getString("payment_date");
        	String dispute_note = resultSet.getString("dispute_note");
        	String dispute_date = resultSet.getString("dispute_date");
        	String terms_agreed = resultSet.getString("terms_agreed");
        	String oow_status = resultSet.getString("oow_status");
        	String amount_due = resultSet.getString("amount_due");
        	String bill_status = resultSet.getString("bill_status");
        	String bill_note = resultSet.getString("bill_note");
        	String request_note = resultSet.getString("request_note");
        	String request_status = resultSet.getString("request_status");
        	String quote_response_note = resultSet.getString("quote_response_note");
        	String quote_response_status = resultSet.getString("quote_response_status");
        	String size = resultSet.getString("size");
        	String height = resultSet.getString("height");
        	String location = resultSet.getString("location");
        	String house_dist = resultSet.getString("house_dist");
        	String treeInfo_id = resultSet.getString("treeInfo_id");
        	String payment_id = resultSet.getString("payment_id");
        	String billResponse_id = resultSet.getString("billResponse_id");
        	String disputes_id = resultSet.getString("disputes_id");
        	String orderOfWork_id = resultSet.getString("orderOfWork_id");
        	String bill_id = resultSet.getString("bill_id");
        	String requestQuote_id = resultSet.getString("requestQuote_id");
        	String quoteResponse_id = resultSet.getString("quoteResponse_id");
        	
        	
        	
            
            

            
            user = new user(email, firstName, lastName, password, address, phone_num, card_num, card_date, card_cvc, role, size, height, location, house_dist, bill_response_note, bill_response_date, amount_paid, payment_date, dispute_note, dispute_date, terms_agreed, oow_status, amount_due, bill_status, bill_note, request_note, request_status, quote_response_note, quote_response_status, treeInfo_id, payment_id, billResponse_id, disputes_id, orderOfWork_id, bill_id, requestQuote_id, quoteResponse_id);
        } 
         
        resultSet.close();
        statement.close();
         
        return user;
    }
    
    public boolean checkEmail(String email) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE email = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
    	return checks;
    }
    public boolean checkAddress(String address) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE address = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, address);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
    	return checks;
    }
    
    public boolean checkPassword(String password) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE password = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
       	return checks;
    }
    
    
    
    public boolean isValid(String email, String password) throws SQLException
    {
    	String sql = "SELECT * FROM User";
    	connect_func();
    	statement = (Statement) connect.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	
    	resultSet.last();
    	
    	int setSize = resultSet.getRow();
    	resultSet.beforeFirst();
    	
    	for(int i = 0; i < setSize; i++)
    	{
    		resultSet.next();
    		if(resultSet.getString("email").equals(email) && resultSet.getString("password").equals(password)) {
    			return true;
    		}		
    	}
    	return false;
    }
    
    
    //need to update
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func();
        statement =  (Statement) connect.createStatement();
        

        String[] INITIAL = {"use projectdb; ",

        		"drop table if exists User; ",
        		"drop table if exists Quotes; ",
        		"drop table if exists TreeInfo; ",
        		"drop table if exists Payment; ",
        		"drop table if exists BillResponse; ",
        		"drop table if exists Disputes; ",
        		"drop table if exists OrderOfWork; ",
        		"drop table if exists Bill; ",
        		"drop table if exists RequestQuote; ",
        		"drop table if exists QuoteResponse; ",

        		("CREATE TABLE if not exists User( " +
        		    "email VARCHAR(50) NOT NULL,  " +
        		    "firstName VARCHAR(10) NOT NULL,  " +
        		    "lastName VARCHAR(10) NOT NULL,  " +
        		    "password VARCHAR(20) NOT NULL,  " +
        		    "address VARCHAR(50) NOT NULL, " +
        		    "phone_num VARCHAR(14), " +
        		    "card_num VARCHAR(20), " +
        		    "card_date VARCHAR(5), " +
        		    "card_cvc VARCHAR(3), " +
        		    "role VARCHAR(10), " +
        		    "PRIMARY KEY (email)  " +
        		    ");"),
        		("CREATE TABLE if not exists Quotes(  " +
        		    "id VARCHAR(50) NOT NULL, " +
        		  
        			"quote_price VARCHAR(50), " +
        		    "quote_time VARCHAR(50), " +
        		    "quote_note VARCHAR(50), " +
        		    "quote_response VARCHAR(10), " +
        		    "quote_date VARCHAR(8), " +
        		    "work_order_terms VARCHAR(50), " +
        		    "work_order_status VARCHAR(15), " +
        		    "bill_amount VARCHAR(50), " +
        		    "bill_status VARCHAR(15) " +
        		    ");"),
        		    
        		    
        		("CREATE TABLE if not exists TreeInfo( " +
        		    "treeInfo_id VARCHAR(20) NOT NULL, " +
        		    "size VARCHAR(20), " +
        		    "height VARCHAR(20), " +
        		    "location VARCHAR(20), " +
        		    "house_dist VARCHAR(20), " +
        		   
        		");"),
        		("CREATE TABLE if not exists Payment( " +
        		    "payment_id VARCHAR(20) NOT NULL, " +
        		    "amount_paid VARCHAR(20), " +
        		    "payment_date VARCHAR(20) " +
        		");"),
        		("CREATE TABLE if not exists BillResponse( " +
        		    "billResponse_id VARCHAR(20) NOT NULL, " +
        		    "bill_response_note VARCHAR(20), " +
        		    "bill_response_date VARCHAR(20) " +
        		");"),
        		("CREATE TABLE if not exists Disputes( " +
        		    "disputes_id VARCHAR(20) NOT NULL, " +
        		    "dispute_note VARCHAR(20), " +
        		    "dispute_date VARCHAR(20) " +
        		");"),
        		("CREATE TABLE if not exists OrderOfWork( " +
        		    "orderOfWork_id VARCHAR(20) NOT NULL, " +
        		    "terms_agreed VARCHAR(20), " +
        		    "oow_status VARCHAR(20) " +
        		");"),
        		("CREATE TABLE if not exists Bill( " +
        		    "bill_id VARCHAR(20) NOT NULL, " +
        		    "amount_due VARCHAR(20), " +
        		    "bill_status VARCHAR(20), " +
        		    "bill_note VARCHAR(20) " +
        		");"),
        		("CREATE TABLE if not exists OrderOfWork( " +
        		    "orderOfWork_id VARCHAR(20) NOT NULL, " +
        		    "request_note VARCHAR(20), " +
        		    "request_status VARCHAR(20) " +
        		");"),
        		("CREATE TABLE if not exists RequestQuote( " +
        		    "requestQuote_id VARCHAR(20) NOT NULL, " +
        		    "request_note VARCHAR(20), " +
        		    "request_status VARCHAR(20) " +
        		");"),
        		("CREATE TABLE if not exists QuoteResponse( " +
        		    "quoteResponse_id VARCHAR(20) NOT NULL, " +
        		    "quote_response_note VARCHAR(20), " +
        		    "quote_response_status VARCHAR(20) " +
        		");")
        		};
        		    
        		String[] TUPLES = {("insert into Quotes(id,  quote_price, quote_time, quote_note, quote_response, quote_date, work_order_terms, work_order_status, bill_amount, bill_status) " +
        		    "values" +
        		    "('lJones@email.com', LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic.jpg'), LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic2.jpg'), LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic3.jpg'), '1200', '2 days', 'no note', 'Approved', '10/18/23', 'terms of work', 'uncompleted', '1200', 'unpaied')," +
        			"('nWayne@email.com', LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic.jpg'), LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic2.jpg'), LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic3.jpg'), '1200', '2 days', 'no note', 'Approved', '10/18/23', 'terms of work', 'uncompleted', '1200', 'unpaied')," +
        			"('mJones@email.com', LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic.jpg'), LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic2.jpg'), LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic3.jpg'), '1200', '2 days', 'no note', 'Approved', '10/18/23', 'terms of work', 'uncompleted', '1200', 'unpaied')," +
        			"('eName@email.com', LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic.jpg'), LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic2.jpg'), LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic3.jpg'), '1200', '2 days', 'no note', 'Approved', '10/18/23', 'terms of work', 'uncompleted', '1200', 'unpaied'), "+
        			"('sSmith@email.com', LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic.jpg'), LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic2.jpg'), LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic3.jpg'), '1200', '2 days', 'no note', 'Approved', '10/18/23', 'terms of work', 'uncompleted', '1200', 'unpaied')," +
        			"('oHanks@email.com', LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic.jpg'), LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic2.jpg'), LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic3.jpg'), '1200', '2 days', 'no note', 'Approved', '10/18/23', 'terms of work', 'uncompleted', '1200', 'unpaied')," +
        			"('mSams@email.com', LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic.jpg'), LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic2.jpg'), LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic3.jpg'), '1200', '2 days', 'no note', 'Approved', '10/18/23', 'terms of work', 'uncompleted', '1200', 'unpaied'), " +
        			"('rDavis@email.com', LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic.jpg'), LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic2.jpg'), LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic3.jpg'), '1200', '2 days', 'no note', 'Approved', '10/18/23', 'terms of work', 'uncompleted', '1200', 'unpaied');" )
        		    };

        		String[] TUPLES2 = {("insert into User(email, firstName, lastName, password, address, phone_num, card_num, card_date, card_cvc, role)" +
        		    "values" +
        		    "('root', 'default', 'default','pass1234', '1234 whatever street, detroit, MI',  '(000)-000-0000', '0000-0000-0000-0000', '00/00', '000', 'admin'), " +
        			"('dSmith@email.com', 'David', 'Smith','smith1234', '1234 other street, detroit, MI', '(111)-222-3333', '0000-0000-0000-0000', '00/00', '000', 'owner'), " +
        		    "('lJones@email.com', 'Luke', 'Jones','jones1234', '1234 whatever Road, detroit, TX', '(111)-222-3333', '1234-5555-25607-5403', '10/29', '123', 'customer'), " +
        		    "('nWayne@email.com', 'Nate', 'Wayne','wayne1234', '1234 whatever street, detroit, MI', '(000)-000-0000', '0000-0000-0000-0000', '00/00', '000', 'customer'), " +
        			"('mJones@email.com', 'Matt', 'Jones','jones1234', '1235 other street, detroit, MI', '(111)-222-3333', '0000-0000-0000-0000', '00/00', '000', 'customer'), " +
        		    "('eName@email.com', 'Even', 'Name','name1234', '1235 whatever Road, detroit, TX', '(111)-222-3333', '1234-5555-25607-5403', '10/29', '123', 'customer'), " +
        		    "('sSmith@email.com', 'Sean', 'Smith','smith1234', '1235 whatever street, detroit, MI', '(000)-000-0000', '0000-0000-0000-0000', '00/00', '000', 'customer'), " +
        			"('oHanks@email.com', 'Owen', 'Hanks','hanks1234', '1236 other street, detroit, MI', '(111)-222-3333', '0000-0000-0000-0000', '00/00', '000', 'customer'), " +
        		    "('mSams@email.com', 'Mick', 'Sams','sams1234', '1236 whatever Road, detroit, TX', '(111)-222-3333', '1234-5555-25607-5403', '10/29', '123', 'customer'), " +
        		    "('rDavis@email.com', 'Randy', 'Davis','davis1234', '1236 whatever street, detroit, MI', '(000)-000-0000', '0000-0000-0000-0000', '00/00', '000', 'customer'); " )
        		    };
        		    
        		    
        		String[] TUPLES3 = {("insert into TreeInfo(treeInfo_id, size, height, location, house_dist) " +
        			"values" +
        			"('lJones@email.com', '0', '10/29/24', 'back yard', '120ft', 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic.jpg', 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic2.jpg', 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic3.jpg')," +
        			"('nWayne@email.com', '12', '10/29/24', 'back yard', '120ft', 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic.jpg', 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic2.jpg', 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic3.jpg')," +
        			"('mJones@email.com', '6', '10/29/24', 'back yard', '120ft', 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic.jpg', 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic2.jpg', 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic3.jpg')," +
        			"('eName@email.com', '4', '10/29/24', 'back yard', '120ft', 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic.jpg', 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic2.jpg', 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/TreePic3.jpg');" )
        		};
        		String[] TUPLES4 = {("insert into Payment(payment_id, amount_paid, payment_date) " +
        			"values" +
        			"('lJones@email.com', 'no note', '10/29/24')," +
        			"('nWayne@email.com', 'no note', '10/29/24')," +
        			"('mJones@email.com', 'no note', '10/29/24')," +
        			"('eName@email.com', 'no note', '10/29/24');" )
        		};
        		String[] TUPLES5 = {("insert into BillResponse(billResponse_id, bill_response_note, bill_response_date) " +
        			"values" +
        			"('lJones@email.com', 'no note', '10/29/24')," +
        			"('nWayne@email.com', 'no note', '10/29/24')," +
        			"('mJones@email.com', 'no note', '10/29/24')," +
        			"('eName@email.com', 'no note', '10/29/24');" )
        		};
        		String[] TUPLES6 = {("insert into Disputes(disputes_id, dispute_note, dispute_date) " +
        			"values" +
        			"('lJones@email.com', 'no note', '10/29/24')," +
        			"('nWayne@email.com', 'no note', '10/29/24')," +
        			"('mJones@email.com', 'no note', '10/29/24')," +
        			"('eName@email.com', 'no note', '10/29/24');" )
        		};
        		String[] TUPLES7 = {("insert into OrderOfWork(orderOfWork_id, terms_agreed, oow_status) " +
        			"values" +
        			"('lJones@email.com', 'no terms', 'incomplete')," +
        			"('nWayne@email.com', 'no terms', 'incomplete')," +
        			"('mJones@email.com', 'no terms', 'incomplete')," +
        			"('eName@email.com', 'no terms', 'incomplete');" )
        		};
        		String[] TUPLES8 = {("insert into Bill(bill_id, amount_due, bill_status, bill_note) " +
        			"values" +
        			"('lJones@email.com', '1500', 'unpaied', 'no note')," +
        			"('nWayne@email.com', '1500', 'unpaied', 'no note')," +
        			"('mJones@email.com', '1500', 'unpaied', 'no note')," +
        			"('eName@email.com', '1500', 'unpaied', 'no note');" )
        		};
        		String[] TUPLES9 = {("insert into RequestQuote(requestQuote_id, request_note, request_status) " +
        			"values" +
        			"('lJones@email.com', 'no note', 'un approved')," +
        			"('nWayne@email.com', 'no note', 'un approved')," +
        			"('mJones@email.com', 'no note', 'un approved')," +
        			"('eName@email.com', 'no note', 'un approved');" )
        		};
        		String[] TUPLES10 = {("insert into QuoteResponse(quoteResponse_id, quote_response_note, quote_response_status) " +
        			"values" +
        			"('lJones@email.com', 'no note', 'un approved')," +
        			"('nWayne@email.com', 'no note', 'un approved')," +
        			"('mJones@email.com', 'no note', 'un approved')," +
        			"('eName@email.com', 'no note', 'un approved');" )
        		};
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        for (int i = 0; i < TUPLES.length; i++)	
        	statement.execute(TUPLES[i]);
        for (int i = 0; i < TUPLES2.length; i++)
        	statement.execute(TUPLES2[i]);
        for (int i = 0; i < TUPLES3.length; i++)
        	statement.execute(TUPLES3[i]);
        for (int i = 0; i < TUPLES4.length; i++)
        	statement.execute(TUPLES4[i]);
        for (int i = 0; i < TUPLES5.length; i++)
        	statement.execute(TUPLES5[i]);
        for (int i = 0; i < TUPLES6.length; i++)
        	statement.execute(TUPLES6[i]);
        for (int i = 0; i < TUPLES7.length; i++)
        	statement.execute(TUPLES7[i]);
        for (int i = 0; i < TUPLES8.length; i++)
        	statement.execute(TUPLES8[i]);
        for (int i = 0; i < TUPLES9.length; i++)
        	statement.execute(TUPLES9[i]);
        for (int i = 0; i < TUPLES10.length; i++)
        	statement.execute(TUPLES10[i]);
        	
        disconnect();
    }
    
    
   
    
    
    
    
    
	
	

}
