import java.sql.Blob;

public class quote 
{
	
	protected String id;
	
	protected String size;
	protected String height;
	protected String location;
	protected String house_dist;
	protected Blob tree_pic1; 
	protected Blob tree_pic2; 
	protected Blob tree_pic3; 
	protected String img_1;
	protected String img_2;
	protected String img_3;
	
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


	public quote() {
	}

	public quote(String id) 
	{
	    this.id = id;
	}
	
	public quote(String id, String size, String height, String location, String house_dist, Blob tree_pic1, Blob tree_pic2, Blob tree_pic3, String img_1, String img_2, String img_3, String bill_response_note, String bill_response_date, String amount_paid, String payment_date, String dispute_note, String dispute_date, String terms_agreed, String oow_status, String amount_due, String bill_status, String bill_note, String request_note, String request_status, String quote_response_note, String quote_response_status)
	{
		this(size, height, location, house_dist, tree_pic1, tree_pic2, tree_pic3, img_1, img_2, img_3, bill_response_note, bill_response_date, amount_paid, payment_date, dispute_note, dispute_date, terms_agreed, oow_status, amount_due, bill_status, bill_note, request_note, request_status, quote_response_note, quote_response_status);
		this.id = id;
	}
	
	public quote(String size, String height, String location, String house_dist, Blob tree_pic1, Blob tree_pic2, Blob tree_pic3, String img_1, String img_2, String img_3, String bill_response_note, String bill_response_date, String amount_paid, String payment_date, String dispute_note, String dispute_date, String terms_agreed, String oow_status, String amount_due, String bill_status, String bill_note, String request_note, String request_status, String quote_response_note, String quote_response_status)
	{
    	this.size = size;
    	this.height = height;
    	this.location = location;
    	this.house_dist = house_dist;
    	this.tree_pic1 = tree_pic1; 
    	this.tree_pic2 = tree_pic2; 
    	this.tree_pic3 = tree_pic3; 
    	this.img_1 = img_1;
    	this.img_2 = img_2;
    	this.img_3 = img_3;
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
    public void setImg_1(String img_1) {
        this.img_1 = img_1;
    }
    public void setImg_2(String img_2) {
        this.img_2 = img_2;
    }
    public void setImg_3(String img_3) {
        this.img_3 = img_3;
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
    public String getImg_1() {
        return img_1;
    }
    public String getImg_2() {
        return img_2;
    }
    public String getImg_3() {
        return img_3;
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

}


