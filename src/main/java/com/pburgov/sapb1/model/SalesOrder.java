package com.pburgov.sapb1.model;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class SalesOrder {
	private Date docDueDate;
	private Date docDate;
	private String cardCode;
	private List<SalesOrderLine> lines;

	public SalesOrder(Date docDueDate, Date docDate, String cardCode) {
		this.docDueDate = docDueDate;
		this.docDate = docDate;
		this.cardCode = cardCode;
	}

	public Date getDocDueDate() {
		return docDueDate;
	}

	public void setDocDueDate(Date docDueDate) {
		this.docDueDate = docDueDate;
	}

	public Date getDocDate() {
		return docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public List<SalesOrderLine> getLines() {
		return lines;
	}

	public void setLines(List<SalesOrderLine> lines) {
		this.lines = lines;
	}

	public void addOrderLine(SalesOrderLine line) {
		if (lines == null) {
			lines = new ArrayList<>();
		}
		lines.add(line);
	}

	@Override
	public String toString() {
		return "SalesOrder [docDueDate=" + docDueDate + ", docDate=" + docDate + ", cardCode=" + cardCode + ", lines="
				+ lines + "]";
	}

}
