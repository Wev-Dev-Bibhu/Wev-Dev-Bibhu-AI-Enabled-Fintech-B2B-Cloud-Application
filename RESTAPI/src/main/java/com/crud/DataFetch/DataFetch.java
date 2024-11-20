package com.crud.DataFetch;



public class DataFetch {
	private	String  business_code,clear_date,doc_id,invoice_currency,document_type,cust_payment_terms,business_name,posting_date,document_create_date,due_in_date,baseline_create_date,aging_bucket;
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	private Double total_open_amount;
	private int sl_no, cust_number,buisness_year,posting_id,invoice_id,isOpen,no_of_customers, no_of_invoice_currency;
	public int getNo_of_invoice_currency() {
		return no_of_invoice_currency;
	}
	public void setNo_of_invoice_currency(int no_of_invoice_currency) {
		this.no_of_invoice_currency = no_of_invoice_currency;
	}
	public int getNo_of_customers() {
		return no_of_customers;
	}
	public void setNo_of_customers(int no_of_customers) {
		this.no_of_customers = no_of_customers;
	}
	public String getAging_bucket() {
		return aging_bucket;
	}
	public void setAging_bucket(String aging_bucket) {
		this.aging_bucket = aging_bucket;
	}
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	public String getClear_date() {
		return clear_date;
	}
	public void setClear_date(String clear_date) {
		this.clear_date = clear_date;
	}
	public String getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	public String getInvoice_currency() {
		return invoice_currency;
	}
	public void setInvoice_currency(String invoice_currency) {
		this.invoice_currency = invoice_currency;
	}
	public String getDocument_type() {
		return document_type;
	}
	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}
	public String getCust_payment_terms() {
		return cust_payment_terms;
	}
	public void setCust_payment_terms(String cust_payment_terms) {
		this.cust_payment_terms = cust_payment_terms;
	}
	public Double getTotal_open_amount() {
		return total_open_amount;
	}
	public void setTotal_open_amount(Double total_open_amount) {
		this.total_open_amount = total_open_amount;
	}
	public int getSl_no() {
		return sl_no;
	}
	public void setSl_no(int sl_no) {
		this.sl_no = sl_no;
	}
	public int getCust_number() {
		return cust_number;
	}
	public void setCust_number(int cust_number) {
		this.cust_number = cust_number;
	}
	public int getBuisness_year() {
		return buisness_year;
	}
	public void setBuisness_year(int buisness_year) {
		this.buisness_year = buisness_year;
	}
	public int getPosting_id() {
		return posting_id;
	}
	public void setPosting_id(int posting_id) {
		this.posting_id = posting_id;
	}
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	public int getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
	}
	public String getPosting_date() {
		return posting_date;
	}
	public void setPosting_date(String posting_date) {
		this.posting_date = posting_date;
	}
	public String getDocument_create_date() {
		return document_create_date;
	}
	public void setDocument_create_date(String document_create_date) {
		this.document_create_date = document_create_date;
	}
	public String getDue_in_date() {
		return due_in_date;
	}
	public void setDue_in_date(String due_in_date) {
		this.due_in_date = due_in_date;
	}
	public String getBaseline_create_date() {
		return baseline_create_date;
	}
	public void setBaseline_create_date(String baseline_create_date) {
		this.baseline_create_date = baseline_create_date;
	}
}