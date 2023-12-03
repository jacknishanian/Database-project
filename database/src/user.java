import java.sql.Blob;


public class user 
{
		protected String email;  
		protected String firstName;  
		protected String lastName;   
		protected String password;  
		protected String address;
		protected String phone_num; 
		protected String card_num; 
		protected String card_date; 
		protected String card_cvc; 
		protected String role;
		protected String size;
		protected String height;
		protected String location;
		protected String house_dist;
		protected String bill_response_note;
		protected String bill_response_date;
		protected String amount_paid;
		protected String payment_date;
		protected String dispute_note;
		protected String dispute_date;
		protected String terms_agreed;
		protected String oow_status;
		protected String amount_due;
		protected String bill_status;
		protected String bill_note;
		protected String request_note;
		protected String request_status;
		protected String quote_response_note;
		protected String quote_response_status;
		
		
		protected String treeInfo_id;
		protected String payment_id;
		protected String billResponse_id;
		protected String disputes_id;
		protected String orderOfWork_id;
		protected String bill_id;
		protected String requestQuote_id;
		protected String quoteResponse_id;

	 
	    //constructors
	    public user() {
	    }
	 
	    public user(String email) 
	    {
	        this.email = email;
	    }
	    
	    public user(String email, String firstName, String lastName, String password, String address, String phone_num, String card_num, String card_date, String card_cvc, String role, String size, String height, String location, String house_dist, String bill_response_note, String bill_response_date, String amount_paid, String payment_date, String dispute_note, String dispute_date, String terms_agreed, String oow_status, String amount_due, String bill_status, String bill_note, String request_note, String request_status, String quote_response_note, String quote_response_status, String treeInfo_id, String payment_id, String billResponse_id, String disputes_id, String orderOfWork_id, String bill_id, String requestQuote_id, String quoteResponse_id)
	    {
	    	this(firstName, lastName, password, address, phone_num, card_num, card_date, card_cvc, role, size, height, location, house_dist, bill_response_note, bill_response_date, amount_paid, payment_date, dispute_note, dispute_date, terms_agreed, oow_status, amount_due, bill_status, bill_note, request_note, request_status, quote_response_note, quote_response_status, treeInfo_id, payment_id, billResponse_id, disputes_id, orderOfWork_id, bill_id, requestQuote_id, quoteResponse_id);
	    	this.email = email;
	    }
	 
	
	    public user(String firstName, String lastName, String password, String address, String phone_num, String card_num, String card_date, String card_cvc, String role, String size, String height, String location, String house_dist, String bill_response_note, String bill_response_date, String amount_paid, String payment_date, String dispute_note, String dispute_date, String terms_agreed, String oow_status, String amount_due, String bill_status, String bill_note, String request_note, String request_status, String quote_response_note, String quote_response_status, String treeInfo_id, String payment_id, String billResponse_id, String disputes_id, String orderOfWork_id, String bill_id, String requestQuote_id, String quoteResponse_id) 
	    {
	    	  
	    	this.firstName = firstName;  
	    	this.lastName = lastName;   
	    	this.password = password;  
	    	this.address = address;
	    	this.phone_num = phone_num; 
	    	this.card_num = card_num; 
	    	this.card_date = card_date; 
	    	this.card_cvc = card_cvc; 
	    	this.role = role; 


	    	this.size = size;
	    	this.height = height;
	    	this.location = location;
	    	this.house_dist = house_dist;
	    	this.bill_response_note = bill_response_note;
	    	this.bill_response_date = bill_response_date;
	    	this.amount_paid = amount_paid;
	    	this.payment_date = payment_date;
	    	this.dispute_note = dispute_note;
	    	this.dispute_date = dispute_date;
	    	this.terms_agreed = terms_agreed;
	    	this.oow_status = oow_status;
	    	this.amount_due = amount_due;
	    	this.bill_status = bill_status;
	    	this.bill_note = bill_note;
	    	this.request_note = request_note;
	    	this.request_status = request_status;
	    	this.quote_response_note = quote_response_note;
	    	this.quote_response_status = quote_response_status;
	    	this.bill_status = bill_status; 
	    	this.treeInfo_id = treeInfo_id;
	    	this.payment_id = payment_id;
	    	this.billResponse_id = billResponse_id;
	    	this.disputes_id = disputes_id;
	    	this.orderOfWork_id = orderOfWork_id;
	    	this.bill_id = bill_id;
	    	this.requestQuote_id = requestQuote_id;
	    	this.quoteResponse_id = quoteResponse_id;
	    	
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
	    public void setAddress(String address) {
	    	this.address = address;
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

	    
	    public void setSize(String size) {
	        this.size = size;
	    }
	    public void setHeight(String height) {
	        this.height = height;
	    }
	    public void setLocation(String location) {
	        this.location = location;
	    }
	    public void setHouse_dist(String house_dist) {
	        this.house_dist = house_dist;
	    }
	    public void setBill_response_note(String bill_response_note) {
	        this.bill_response_note = bill_response_note;
	    }
	    public void setBill_response_date(String bill_response_date) {
	        this.bill_response_date = bill_response_date;
	    }
	    public void setAmount_paid(String amount_paid) {
	        this.amount_paid = amount_paid;
	    }
	    public void setPayment_date(String payment_date) {
	        this.payment_date = payment_date;
	    }
	    public void setDispute_note(String dispute_note) {
	        this.dispute_note = dispute_note;
	    }
	    public void setDispute_date(String dispute_date) {
	        this.dispute_date = dispute_date;
	    }
	    public void setTerms_agreed(String terms_agreed) {
	        this.terms_agreed = terms_agreed;
	    }
	    public void setOow_status(String oow_status) {
	        this.oow_status = oow_status;
	    }
	    public void setAmount_due(String amount_due) {
	        this.amount_due = amount_due;
	    }
	    public void setBill_status(String bill_status) {
	        this.bill_status = bill_status;
	    }
	    public void setBill_note(String bill_note) {
	        this.bill_note = bill_note;
	    }
	    public void setRequest_note(String request_note) {
	        this.request_note = request_note;
	    }
	    public void setRequest_status(String request_status) {
	        this.request_status = request_status;
	    }
	    public void setQuote_response_note(String quote_response_note) {
	        this.quote_response_note = quote_response_note;
	    }
	    public void setQuote_response_status(String quote_response_status) {
	        this.quote_response_status = quote_response_status;
	    }
	    public void setTreeInfo_id(String treeInfo_id) {
	        this.treeInfo_id = treeInfo_id;
	    }
	    public void setPayment_id(String payment_id) {
	        this.payment_id = payment_id;
	    }
	    public void setBillResponse_id(String billResponse_id) {
	        this.billResponse_id = billResponse_id;
	    }
	    public void setDisputes_id(String disputes_id) {
	        this.disputes_id = disputes_id;
	    }
	    public void setOrderOfWork_id(String orderOfWork_id) {
	        this.orderOfWork_id = orderOfWork_id;
	    }
	    public void setBill_id(String bill_id) {
	        this.bill_id = bill_id;
	    }
	    public void setRequestQuote_id(String requestQuote_id) {
	        this.requestQuote_id = requestQuote_id;
	    }
	    public void setQuoteResponse_id(String quoteResponse_id) {
	        this.quoteResponse_id = quoteResponse_id;
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
	    public String getAddress() {
	    	return address;
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
	 
	  
	    public String getSize() {
	        return size;
	    }
	    public String getHeight() {
	        return height;
	    }
	    public String getLocation() {
	        return location;
	    }
	    public String getHouse_dist() {
	        return house_dist;
	    }
	    public String getBill_response_note() {
	        return bill_response_note;
	    }
	    public String getBill_response_date() {
	        return bill_response_date;
	    }
	    public String getAmount_paid() {
	        return amount_paid;
	    }
	    public String getPayment_date() {
	        return payment_date;
	    }
	    public String getDispute_note() {
	        return dispute_note;
	    }
	    public String getDispute_date() {
	        return dispute_date;
	    }
	    public String getTerms_agreed() {
	        return terms_agreed;
	    }
	    public String getOow_status() {
	        return oow_status;
	    }
	    public String getAmount_due() {
	        return amount_due;
	    }
	    public String getBill_status() {
	        return bill_status;
	    }
	    public String getBill_note() {
	        return bill_note;
	    }
	    public String getRequest_note() {
	        return request_note;
	    }
	    public String getRequest_status() {
	        return request_status;
	    }
	    public String getQuote_response_note() {
	        return quote_response_note;
	    }
	    public String getQuote_response_status() {
	        return quote_response_status;
	    }
	    public String getTreeInfo_id() {
	        return treeInfo_id;
	    }
	    public String getPayment_id() {
	        return payment_id;
	    }
	    public String getBillResponse_id() {
	        return billResponse_id;
	    }
	    public String getDisputes_id() {
	        return disputes_id;
	    }
	    public String getOrderOfWork_id() {
	        return orderOfWork_id;
	    }
	    public String getBill_id() {
	        return bill_id;
	    }
	    public String getRequestQuote_id() {
	        return requestQuote_id;
	    }
	    public String getQuoteResponse_id() {
	        return quoteResponse_id;
	    }
	    
	    
	}