package com.fdmgroup.Query;

public class QueryObj {

	private String queryUsername;
	private long queryNo;
	private String queryStatus;
	private String queryCategory;
	private String querySubjet;
	
	public QueryObj(){};
	
	public QueryObj(String queryUsername, long queryNo, String queryStatus, String queryCategory, String querySubjet) {
		super();
		this.queryUsername = queryUsername;
		this.queryNo = queryNo;
		this.queryStatus = queryStatus;
		this.queryCategory = queryCategory;
		this.querySubjet = querySubjet;
	}
	
	
	public String getQueryUsername() {
		return queryUsername;
	}
	public void setQueryUsername(String queryUsername) {
		this.queryUsername = queryUsername;
	}
	public long getQueryNo() {
		return queryNo;
	}
	public void setQueryNo(long queryNo) {
		this.queryNo = queryNo;
	}
	public String getQueryStatus() {
		return queryStatus;
	}
	public void setQueryStatus(String queryStatus) {
		this.queryStatus = queryStatus;
	}
	public String getQueryCategory() {
		return queryCategory;
	}
	public void setQueryCategory(String queryCategory) {
		this.queryCategory = queryCategory;
	}
	public String getQuerySubjet() {
		return querySubjet;
	}
	public void setQuerySubjet(String querySubjet) {
		this.querySubjet = querySubjet;
	}

}
