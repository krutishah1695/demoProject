package com.example.SpringBatchDoc.model;

public class InterfaceData {

	public InterfaceData(String date, String fundCode, String costCenter, String naturalAccount, String currency,
			String accInfo, String type, long number, String glas) {
		super();
		Date = date;
		this.fundCode = fundCode;
		this.costCenter = costCenter;
		this.naturalAccount = naturalAccount;
		this.currency = currency;
		this.accInfo = accInfo;
		this.type = type;
		this.number = number;
		this.glas = glas;
	}
	@Override
	public String toString() {
		return "InterfaceData [Date=" + Date + ", fundCode=" + fundCode + ", costCenter=" + costCenter
				+ ", naturalAccount=" + naturalAccount + ", currency=" + currency + ", accInfo=" + accInfo + ", type="
				+ type + ", number=" + number + ", glas=" + glas + "]";
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	String Date;
	String fundCode;
	String costCenter;
	String naturalAccount;
	String currency;
	String accInfo;
	String type;
	long number;
	String glas;
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	public String getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	public String getNaturalAccount() {
		return naturalAccount;
	}
	public void setNaturalAccount(String naturalAccount) {
		this.naturalAccount = naturalAccount;
	}
	



	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAccInfo() {
		return accInfo;
	}
	public void setAccInfo(String accInfo) {
		this.accInfo = accInfo;
	}
		public String getGlas() {
		return glas;
	}
	public void setGlas(String glas) {
		this.glas = glas;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public InterfaceData(){
		
	}
	
}
