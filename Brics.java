package cgg.gov.in.rest;


 
public class Brics {

	private String custName;
	private String no_of_Brics;
	private String mobileNo;
	private String address;
	@Override
	public String toString() {
		return "Brics [custName=" + custName + ", no_of_Brics=" + no_of_Brics
				+ ", mobileNo=" + mobileNo + ", address=" + address + "]";
	}
	public String getNo_of_Brics() {
		return no_of_Brics;
	}
	public void setNo_of_Brics(String no_of_Brics) {
		this.no_of_Brics = no_of_Brics;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public String getCustName() {
		return custName;
	}
	 
}
