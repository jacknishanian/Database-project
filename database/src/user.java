import java.sql.Blob;

public class user 
{
		protected String email;  
		protected String firstName;  
		protected String lastName;   
		protected String password;  
		protected String phone_num; 
		protected String card_num; 
		protected String card_date; 
		protected String card_cvc; 
		protected String role; 
		protected String id; 
		protected Blob tree_pic1; 
		protected Blob tree_pic2; 
		protected Blob tree_pic3; 
		protected String quote_price; 
		protected String quote_time; 
		protected String quote_note; 
		protected String quote_response; 
		protected String quote_date; 
		protected String work_order_terms; 
		protected String work_order_status; 
		protected String bill_amount; 
		protected String bill_status; 
		protected String img_1;
		protected String img_2;
		protected String img_3;

	 
	    //constructors
	    public user() {
	    }
	 
	    public user(String email) 
	    {
	        this.email = email;
	    }
	    
	    public user(String email, String firstName, String lastName, String password, String phone_num, String card_num, String card_date, String card_cvc, String role, String id, Blob tree_pic1, Blob tree_pic2, Blob tree_pic3, String quote_price, String quote_time, String quote_note, String quote_response, String quote_date, String work_order_terms, String work_order_status, String bill_amount, String bill_status, String img_1, String img_2, String img_3)
	    {
	    	this(firstName, lastName, password, phone_num, card_num, card_date, card_cvc, role, id, tree_pic1, tree_pic2, tree_pic3, quote_price, quote_time, quote_note, quote_response, quote_date, work_order_terms, work_order_status, bill_amount, bill_status, img_1, img_2, img_3);
	    	this.email = email;
	    }
	 
	
	    public user(String firstName, String lastName, String password, String phone_num, String card_num, String card_date, String card_cvc, String role, String id, Blob tree_pic1, Blob tree_pic2, Blob tree_pic3, String quote_price, String quote_time, String quote_note, String quote_response, String quote_date, String work_order_terms, String work_order_status, String bill_amount, String bill_status, String img_1, String img_2, String img_3) 
	    {
	    	  
	    	this.firstName = firstName;  
	    	this.lastName = lastName;   
	    	this.password = password;  
	    	this.phone_num = phone_num; 
	    	this.card_num = card_num; 
	    	this.card_date = card_date; 
	    	this.card_cvc = card_cvc; 
	    	this.role = role; 
	    	this.id = id; 
	    	this.tree_pic1 = tree_pic1; 
	    	this.tree_pic2 = tree_pic2; 
	    	this.tree_pic3 = tree_pic3; 
	    	this.quote_price = quote_price; 
	    	this.quote_time = quote_time; 
	    	this.quote_note = quote_note; 
	    	this.quote_response = quote_response; 
	    	this.quote_date = quote_date; 
	    	this.work_order_terms = work_order_terms; 
	    	this.work_order_status = work_order_status; 
	    	this.bill_amount = bill_amount; 
	    	this.bill_status = bill_status; 
	    	this.img_1 = img_1;
	    	this.img_2 = img_2;
	    	this.img_3 = img_3;
	    }
	    
	    
	    //getter and setter methods
	    
	    //setters
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    public void setPhone_num(String phone_num) {
	        this.phone_num = phone_num;
	    }
	    public void setCard_num(String card_num) {
	        this.card_num = card_num;
	    }
	    public void setCard_date(String card_date) {
	        this.card_date = card_date;
	    }
	    public void setCard_cvc(String card_cvc) {
	        this.card_cvc = card_cvc;
	    }
	    public void setRole(String role) {
	        this.role = role;
	    }
	    public void setId(String id) {
	        this.id = id;
	    }
	    public void setTree_pic1(Blob tree_pic1) {
	        this.tree_pic1 = tree_pic1;
	    }
	    public void setTree_pic2(Blob tree_pic2) {
	        this.tree_pic2 = tree_pic2;
	    }
	    public void setTree_pic3(Blob tree_pic3) {
	        this.tree_pic3 = tree_pic3;
	    }
	    public void setQuote_price(String quote_price) {
	        this.quote_price = quote_price;
	    }
	    public void setQuote_time(String quote_time) {
	        this.quote_time = quote_time;
	    }
	    public void setQuote_note(String quote_note) {
	        this.quote_note = quote_note;
	    }
	    public void setQuote_response(String quote_response) {
	        this.quote_response = quote_response;
	    }
	    public void setQuote_date(String quote_date) {
	        this.quote_date = quote_date;
	    }
	    public void setWork_order_terms(String work_order_terms) {
	        this.work_order_terms = work_order_terms;
	    }
	    public void setWork_order_status(String work_order_status) {
	        this.work_order_status = work_order_status;
	    }
	    public void setBill_amount(String bill_amount) {
	        this.bill_amount = bill_amount;
	    }
	    public void setBill_status(String bill_status) {
	        this.bill_status = bill_status;
	    }
	    public void setImg_1(String img_1) {
	        this.img_1 = img_1;
	    }
	    public void setImg_2(String img_2) {
	        this.img_2 = img_2;
	    }
	    public void setImg_3(String img_3) {
	        this.img_3 = img_3;
	    }
	    //getters
	    public String getEmail() {
	        return email;
	    }
	    public String getFirstName() {
	        return firstName;
	    }
	    public String getLastName() {
	        return lastName;
	    }
	    public String getPassword() {
	        return password;
	    }
	    public String getPhone_num() {
	        return phone_num;
	    }
	    public String getCard_num() {
	        return card_num;
	    }
	    public String getCard_date() {
	        return card_date;
	    }
	    public String getCard_cvc() {
	        return card_cvc;
	    }
	    public String getRole() {
	        return role;
	    }
	    public String getId() {
	        return id;
	    }
	    public Blob getTree_pic1() {
	        return tree_pic1;
	    }
	    public Blob getTree_pic2() {
	        return tree_pic2;
	    }
	    public Blob getTree_pic3() {
	        return tree_pic3;
	    }
	    public String getQuote_price() {
	        return quote_price;
	    }
	    public String getQuote_time() {
	        return quote_time;
	    }
	    public String getQuote_note() {
	        return quote_note;
	    }
	    public String getQuote_response() {
	        return quote_response;
	    }
	    public String getQuote_date() {
	        return quote_date;
	    }
	    public String getWork_order_terms() {
	        return work_order_terms;
	    }
	    public String getWork_order_status() {
	        return work_order_status;
	    }
	    public String getBill_amount() {
	        return bill_amount;
	    }
	    public String getBill_status() {
	        return bill_status;
	    }
	    public String getImg_1() {
	        return img_1;
	    }
	    public String getImg_2() {
	        return img_2;
	    }
	    public String getImg_3() {
	        return img_3;
	    }
	}