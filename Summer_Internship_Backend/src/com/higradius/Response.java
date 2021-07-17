package com.higradius;

import java.sql.Date;

public class Response {
	private int FIELD1;
	private int visi;
	private String name_customer;
	private String cust_number;
	private long invoice_id;
	private float total_open_amount;
	private Date due_in_date;
	private Date clear_datepredicted;
	private String DELAY_BUCKETDAYS;
	public int getFIELD1() {
		return FIELD1;
	}
	public void setFIELD1(int fIELD1) {
		FIELD1 = fIELD1;
	}
	public int getVisi() {
		return visi;
	}
	public void setVisi(int visi) {
		this.visi = visi;
	}
	public String getName_customer() {
		return name_customer;
	}
	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}
	public String getCust_number() {
		return cust_number;
	}
	public void setCust_number(String cust_number) {
		this.cust_number = cust_number;
	}
	public long getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(long invoice_id) {
		this.invoice_id = invoice_id;
	}
	public float getTotal_open_amount() {
		return total_open_amount;
	}
	public void setTotal_open_amount(float total_open_amount) {
		this.total_open_amount = total_open_amount;
	}
	public Date getDue_in_date() {
		return due_in_date;
	}
	public void setDue_in_date(Date due_in_date) {
		this.due_in_date = due_in_date;
	}
	public Date getClear_datepredicted() {
		return clear_datepredicted;
	}
	public void setClear_datepredicted(Date clear_datepredicted) {
		this.clear_datepredicted = clear_datepredicted;
	}
	public String getDELAY_BUCKETDAYS() {
		return DELAY_BUCKETDAYS;
	}
	public void setDELAY_BUCKETDAYS(String dELAY_BUCKETDAYS) {
		DELAY_BUCKETDAYS = dELAY_BUCKETDAYS;
	}
	

}

