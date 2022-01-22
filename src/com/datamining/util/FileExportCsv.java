package com.datamining.util;


public class FileExportCsv {
	private String firstName;
	private String address;
	private String invoice;
	private String invoiceDate;
	/*private String customerPO;*/
	private String description;
	private String accountCode;
	private String totalAmount;
	private String cardId;
	private String recordId;
	private String incTaxAmount;
	
	public FileExportCsv(String firstName, 
			String address, String invoice, String invoiceDate2, 
			/*String customerPO,*/ String description, String accountCode, 
			String totalAmount,String incTaxAmount, String cardId, String recordId){
		
		this.firstName = firstName;
		this.address = address;
		this.invoice = invoice;
		this.invoiceDate = invoiceDate2;
		this.description = description;
		this.accountCode = accountCode;
		this.totalAmount = totalAmount;
		this.cardId = cardId;
		this.recordId = recordId;
		this.incTaxAmount = incTaxAmount;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getIncTaxAmount() {
		return incTaxAmount;
	}

	public void setIncTaxAmount(String incTaxAmount) {
		this.incTaxAmount = incTaxAmount;
	}

}
