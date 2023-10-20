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
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projectdb?allowPublicKeyRetrieval=true&useSSL=false&user=john&password=pass1234");
            System.out.println(connect);
        }
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
        String sql = "SELECT * FROM User LEFT JOIN Quotes ON User.email = Quotes.id UNION SELECT * FROM User RIGHT JOIN Quotes ON User.email = Quotes.id";
        connect_func();
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String email = resultSet.getString("email");
        	String firstName = resultSet.getString("firstName");
        	String lastName = resultSet.getString("lastName");
        	String password = resultSet.getString("password");
        	String phone_num = resultSet.getString("phone_num");
        	String card_num = resultSet.getString("card_num");
        	String card_date = resultSet.getString("card_date");
        	String card_cvc = resultSet.getString("card_cvc");
        	String role = resultSet.getString("role");
        	String id = resultSet.getString("id");
        	Blob tree_pic1;
        	Blob tree_pic2;
        	Blob tree_pic3;
        	String quote_price;
        	String quote_time;
        	String quote_note;
        	String quote_response;
        	String quote_date;
        	String work_order_terms;
        	String work_order_status;
        	String bill_amount;
        	String bill_status;
        	String img_1;
        	String img_2;
        	String img_3;
        	
        	
        	System.out.println(id);
        	if (id != null) {
        		System.out.println(id);
        		tree_pic1 = resultSet.getBlob("tree_pic1");
            	tree_pic2 = resultSet.getBlob("tree_pic2");
            	tree_pic3 = resultSet.getBlob("tree_pic3");
            	quote_price = resultSet.getString("quote_price");
            	quote_time = resultSet.getString("quote_time");
            	quote_note = resultSet.getString("quote_note");
            	quote_response = resultSet.getString("quote_response");
            	quote_date = resultSet.getString("quote_date");
            	work_order_terms = resultSet.getString("work_order_terms");
            	work_order_status = resultSet.getString("work_order_status");
            	bill_amount = resultSet.getString("bill_amount");
            	bill_status = resultSet.getString("bill_status");

            	
        		InputStream inputStream = tree_pic1.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                byte[] imageBytes = outputStream.toByteArray();
                img_1 = Base64.getEncoder().encodeToString(imageBytes);
                inputStream.close();
                outputStream.close();
                
                inputStream = tree_pic2.getBinaryStream();
                outputStream = new ByteArrayOutputStream();
                buffer = new byte[4096];
                bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                imageBytes = outputStream.toByteArray();
                img_2 = Base64.getEncoder().encodeToString(imageBytes);
                inputStream.close();
                outputStream.close();
                
                inputStream = tree_pic3.getBinaryStream();
                outputStream = new ByteArrayOutputStream();
                buffer = new byte[4096];
                bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                imageBytes = outputStream.toByteArray();
                img_3 = Base64.getEncoder().encodeToString(imageBytes);
                inputStream.close();
                outputStream.close();
        	}
        	else {
        		tree_pic1 = null;
            	tree_pic2 = null;
            	tree_pic3 = null;
            	quote_price = "N/A";
            	quote_time = "N/A";
            	quote_note = "N/A";
            	quote_response = "N/A";
            	quote_date = "N/A";
            	work_order_terms = "N/A";
            	work_order_status = "N/A";
            	bill_amount = "N/A";
            	bill_status = "N/A";
            	img_1 = null;
            	img_2 = null;
            	img_3 = null;
        	}
        	
        	
             
            user users = new user(email, firstName, lastName, password, phone_num, card_num, card_date, card_cvc, role, id, tree_pic1, tree_pic2, tree_pic3, quote_price, quote_time, quote_note, quote_response, quote_date, work_order_terms, work_order_status, bill_amount, bill_status, img_1, img_2, img_3);
            listUser.add(users);
        }        
        resultSet.close();
        disconnect();        
        return listUser;
    }
    
    
    //needs testing
    public List<user> getAllUserQuotes() throws SQLException, IOException {
    	List<user> listUser = new ArrayList<user>(); 
    	//String sql = "SELECT * FROM User LEFT JOIN Quotes on User.email = Quotes.id";  //best so far
    	//String sql = "SELECT * FROM Quotes LEFT JOIN User on Quotes.id = User.email where id = '?'";
    	String sql = "SELECT * FROM Quotes";
        connect_func();
        
        
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	//String email = resultSet.getString("email");
        	//String firstName = resultSet.getString("firstName");
        	//String lastName = resultSet.getString("lastName");
        	//String password = resultSet.getString("password");
        	//String phone_num = resultSet.getString("phone_num");
        	//String card_num = resultSet.getString("card_num");
        	//String card_date = resultSet.getString("card_date");
        	//String card_cvc = resultSet.getString("card_cvc");
        	//String role = resultSet.getString("role");
        	String email = null;
        	String firstName = null;
        	String lastName = null;
        	String password = null;
        	String phone_num = null;
        	String card_num = null;
        	String card_date = null;
        	String card_cvc = null;
        	String role = null;
        	String id = resultSet.getString("id");
        	Blob tree_pic1 = resultSet.getBlob("tree_pic1");
        	Blob tree_pic2 = resultSet.getBlob("tree_pic2");
        	Blob tree_pic3 = resultSet.getBlob("tree_pic3");
        	String quote_price = resultSet.getString("quote_price");
        	String quote_time = resultSet.getString("quote_time");
        	String quote_note = resultSet.getString("quote_note");
        	String quote_response = resultSet.getString("quote_response");
        	String quote_date = resultSet.getString("quote_date");
        	String work_order_terms = resultSet.getString("work_order_terms");
        	String work_order_status = resultSet.getString("work_order_status");
        	String bill_amount = resultSet.getString("bill_amount");
        	String bill_status = resultSet.getString("bill_status");
        	String img_1;
        	String img_2;
        	String img_3;
        	
        	InputStream inputStream = tree_pic1.getBinaryStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);                  
            }
            byte[] imageBytes = outputStream.toByteArray();
            img_1 = Base64.getEncoder().encodeToString(imageBytes);
            inputStream.close();
            outputStream.close();
            
            System.out.println(img_1);
            System.out.println();
            System.out.println();
            
            
            inputStream = tree_pic2.getBinaryStream();
            outputStream = new ByteArrayOutputStream();
            buffer = new byte[4096];
            bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);                  
            }
            imageBytes = outputStream.toByteArray();
            img_2 = Base64.getEncoder().encodeToString(imageBytes);
            inputStream.close();
            outputStream.close();
            
            System.out.println(img_2);
            System.out.println();
            System.out.println();
            
            
            inputStream = tree_pic3.getBinaryStream();
            outputStream = new ByteArrayOutputStream();
            buffer = new byte[4096];
            bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);                  
            }
            imageBytes = outputStream.toByteArray();
            img_3 = Base64.getEncoder().encodeToString(imageBytes);
            inputStream.close();
            outputStream.close();
            
            System.out.println(img_3);
            System.out.println();
            System.out.println();
            
             
            user users = new user(email, firstName, lastName, password, phone_num, card_num, card_date, card_cvc, role, id, tree_pic1, tree_pic2, tree_pic3, quote_price, quote_time, quote_note, quote_response, quote_date, work_order_terms, work_order_status, bill_amount, bill_status, img_1, img_2, img_3);
            listUser.add(users);
        }        
        resultSet.close();
        disconnect();        
        return listUser;
    }
 
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    
    //needs work
    public void insert(user users) throws SQLException {
    	connect_func("root","pass1234");         
		String sql = "insert into User(email, firstName, lastName, password, card_num, card_date, card_cvc ,role) values (?, ?, ?, ?, ?, ?, ?, ?)";
		String quote = "insert into Quotes(id, quotes_content, quotes_response, quotes_status, work_order_content, work_order_status, bill_of_work_content, bill_of_work_status,) values (?, ?, ?, ?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement2 = (PreparedStatement) connect.prepareStatement(quote);
		
		preparedStatement.setString(1, users.getEmail());
		preparedStatement.setString(2, users.getFirstName());
		preparedStatement.setString(3, users.getLastName());
		preparedStatement.setString(4, users.getPassword());
		preparedStatement.setString(5, users.getPhone_num());
		preparedStatement.setString(6, users.getCard_num());
		preparedStatement.setString(7, users.getCard_date());
		preparedStatement.setString(8, users.getCard_cvc());
		preparedStatement.setString(9, users.getRole());
		preparedStatement.setString(10, users.getId());
		preparedStatement.setBlob(11, users.getTree_pic1());
		preparedStatement.setBlob(12, users.getTree_pic2());
		preparedStatement.setBlob(13, users.getTree_pic3());
		preparedStatement.setString(14, users.getQuote_price());
		preparedStatement.setString(15, users.getQuote_time());
		preparedStatement.setString(16, users.getQuote_note());
		preparedStatement.setString(17, users.getQuote_response());
		preparedStatement.setString(18, users.getQuote_date());
		preparedStatement.setString(19, users.getWork_order_terms());
		preparedStatement.setString(20, users.getWork_order_status());
		preparedStatement.setString(21, users.getBill_amount());
		preparedStatement.setString(22, users.getBill_status());

		preparedStatement.executeUpdate();
        preparedStatement.close();
        preparedStatement2.executeUpdate();
        preparedStatement2.close();
    }
    
    public boolean delete(String email) throws SQLException {
        String sql = "DELETE FROM User WHERE email = ?";     
        String quote = "DELETE FROM Quote WHERE id = ?"; 
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
        
        preparedStatement2 = (PreparedStatement) connect.prepareStatement(quote);
        preparedStatement2.setString(1, email);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    public boolean update(user users) throws SQLException {
    	String quote = "insert into Quotes(id, quotes_content, quotes_response, quotes_status, work_order_content, work_order_status, bill_of_work_content, bill_of_work_status,) values (?, ?, ?, ?, ?, ?, ?, ?)";
        String sql = "update User set firstName=?, lastName =?,password = ?, card_num=?, card_date=?, card_cvc=?, role=? where email = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement2 = (PreparedStatement) connect.prepareStatement(quote);

        preparedStatement.setString(1, users.getEmail());
        preparedStatement.setString(2, users.getFirstName());
        preparedStatement.setString(3, users.getLastName());
        preparedStatement.setString(4, users.getPassword());
        preparedStatement.setString(5, users.getPhone_num());
        preparedStatement.setString(6, users.getCard_num());
        preparedStatement.setString(7, users.getCard_date());
        preparedStatement.setString(8, users.getCard_cvc());
        preparedStatement.setString(9, users.getRole());
        preparedStatement.setString(10, users.getId());
        preparedStatement.setBlob(11, users.getTree_pic1());
        preparedStatement.setBlob(12, users.getTree_pic2());
        preparedStatement.setBlob(13, users.getTree_pic3());
        preparedStatement.setString(14, users.getQuote_price());
        preparedStatement.setString(15, users.getQuote_time());
        preparedStatement.setString(16, users.getQuote_note());
        preparedStatement.setString(17, users.getQuote_response());
        preparedStatement.setString(18, users.getQuote_date());
        preparedStatement.setString(19, users.getWork_order_terms());
        preparedStatement.setString(20, users.getWork_order_status());
        preparedStatement.setString(21, users.getBill_amount());
        preparedStatement.setString(22, users.getBill_status());

         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        
        return rowUpdated;     
    }
    
    public user getUser(String email) throws SQLException, IOException {
    	user user = null; 
    	String sql = "SELECT * FROM User LEFT JOIN Quotes on User.email = Quotes.id where email = ?";
    	//String sql = "SELECT * FROM Quotes where id = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
        	String firstName = resultSet.getString("firstName");
        	String lastName = resultSet.getString("lastName");
        	String password = resultSet.getString("password");
        	String phone_num = resultSet.getString("phone_num");
        	String card_num = resultSet.getString("card_num");
        	String card_date = resultSet.getString("card_date");
        	String card_cvc = resultSet.getString("card_cvc");
        	String role = resultSet.getString("role");
        	String id = resultSet.getString("id");
        	Blob tree_pic1 = resultSet.getBlob("tree_pic1");
        	Blob tree_pic2 = resultSet.getBlob("tree_pic2");
        	Blob tree_pic3 = resultSet.getBlob("tree_pic3");
        	String quote_price = resultSet.getString("quote_price");
        	String quote_time = resultSet.getString("quote_time");
        	String quote_note = resultSet.getString("quote_note");
        	String quote_response = resultSet.getString("quote_response");
        	String quote_date = resultSet.getString("quote_date");
        	String work_order_terms = resultSet.getString("work_order_terms");
        	String work_order_status = resultSet.getString("work_order_status");
        	String bill_amount = resultSet.getString("bill_amount");
        	String bill_status = resultSet.getString("bill_status");
        	String img_1;
        	String img_2;
        	String img_3;
        	
        	InputStream inputStream = tree_pic1.getBinaryStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);                  
            }
            byte[] imageBytes = outputStream.toByteArray();
            img_1 = Base64.getEncoder().encodeToString(imageBytes);
            inputStream.close();
            outputStream.close();
            System.out.println(img_1);
            
            inputStream = tree_pic2.getBinaryStream();
            outputStream = new ByteArrayOutputStream();
            buffer = new byte[4096];
            bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);                  
            }
            imageBytes = outputStream.toByteArray();
            img_2 = Base64.getEncoder().encodeToString(imageBytes);
            inputStream.close();
            outputStream.close();
            System.out.println(img_2);
            
            inputStream = tree_pic3.getBinaryStream();
            outputStream = new ByteArrayOutputStream();
            buffer = new byte[4096];
            bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);                  
            }
            imageBytes = outputStream.toByteArray();
            img_3 = Base64.getEncoder().encodeToString(imageBytes);
            inputStream.close();
            outputStream.close();
            System.out.println(img_3);
            
            

            
            user = new user(email, firstName, lastName, password, phone_num, card_num, card_date, card_cvc, role, id, tree_pic1, tree_pic2, tree_pic3, quote_price, quote_time, quote_note, quote_response, quote_date, work_order_terms, work_order_status, bill_amount, bill_status, img_1, img_2, img_3);
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
        		"drop table if exists Quotes; ",
        		"drop table if exists User; ",

        		("CREATE TABLE if not exists User( " +
        		    "email VARCHAR(50) NOT NULL, " +
        		    "firstName VARCHAR(10) NOT NULL, " +
        		    "lastName VARCHAR(10) NOT NULL, " +
        		    "password VARCHAR(20) NOT NULL, " +
        		    "card_num VARCHAR(20), " +
        		    "card_date VARCHAR(5), " +
        		    "card_cvc VARCHAR(3), " +
        		    "role VARCHAR(10), " +
        		    "PRIMARY KEY (email) "+"); "),
        		    
        		    
        		    ("CREATE TABLE if not exists Quotes( " +
        		    "id VARCHAR(50) NOT NULL, " +
        			"quotes_content VARCHAR(50), " +
        		    "quotes_response VARCHAR(50), " +
        		    "quotes_status VARCHAR(50), " +
        		    "work_order_content VARCHAR(50), " +
        		    "work_order_status VARCHAR(15), " +
        		    "bill_of_work_content VARCHAR(50), " +
        		    "bill_of_work_status VARCHAR(15)" + ");")
        };

        String[] TUPLES = {("insert into Quotes(id, quotes_content, quotes_response, quotes_status, work_order_content, work_order_status, bill_of_work_content, bill_of_work_status) " +
        		    "values" +
        		    "('lJones@email.com', 'tree removal', 'Can do for $1,200', 'Approved', 'remove tree for 1200', 'unfufilled', '1200', 'unpaied');")
        		    };

        String[] TUPLES2 = {("insert into User(email, firstName, lastName, password, card_num, card_date, card_cvc, role)" +
        		    "values" +
        		    "('root', 'default', 'default','pass1234', '0000-0000-0000-0000', '00/00', '000', 'admin')," +
        			"('dSmith@email.com', 'David', 'Smith','smith1234', '0000-0000-0000-0000', '00/00', '000', 'owner')," +
        		    "('lJones@email.com', 'Luke', 'Jones','jones1234', '1234-5555-25607-5403', '10/29', '123', 'customer');")
        		    };
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        for (int i = 0; i < TUPLES.length; i++)	
        	statement.execute(TUPLES[i]);
        for (int i = 0; i < TUPLES2.length; i++)
        	statement.execute(TUPLES2[i]);
        	
        disconnect();
    }
    
    
   
    
    
    
    
    
	
	

}
