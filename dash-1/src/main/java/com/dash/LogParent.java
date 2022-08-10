package com.dash;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties
public class LogParent {
	
	private String totalPages;
	private List<Reports> reports;
	private String totalItems;
	private String currentPage;
	
	public String getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}
	
	
	public List<Reports> getReports() {
		return reports;
	}
	public void setReports(List<Reports> reports) {
		this.reports = reports;
	}
	public String getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(String totalItems) {
		this.totalItems = totalItems;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	
	

}
