package com.pburgov.sapb1.di;

import com.pburgov.sapb1.model.SalesOrder;
import com.pburgov.sapb1.model.SalesOrderLine;
import com.sap.smb.sbo.api.ICompany;
import com.sap.smb.sbo.api.IDocuments;
import com.sap.smb.sbo.api.SBOCOMConstants;
import com.sap.smb.sbo.api.SBOCOMException;
import com.sap.smb.sbo.api.SBOCOMUtil;
import com.sap.smb.sbo.api.SBOErrorMessage;

public class AddSalesOrder {

	private SalesOrder order;
	private ICompany iCompany;

	public AddSalesOrder(ICompany iCompany, SalesOrder order) {
		this.order = order;
		this.iCompany = iCompany;
	}

	public void createOrder() {
		try {
            IDocuments orderSap = SBOCOMUtil.newDocuments(iCompany, SBOCOMConstants.BoObjectTypes_Document_oOrders);

			orderSap.setCardCode(order.getCardCode());
			orderSap.setDocDate(order.getDocDate());
			orderSap.setDocDueDate(order.getDocDueDate());

			for (SalesOrderLine line : order.getLines()) {
				orderSap.getLines().setItemCode(line.getItemCode());
				orderSap.getLines().setQuantity(line.getQuantity());
				orderSap.getLines().setPrice(line.getPrice());
				orderSap.getLines().add();
				System.out.println("Adding : " + line.toString());	
			}

			if (orderSap.add() == 0) {
				System.out.println("Order Nº"+ iCompany.getNewObjectKey()+" successfully created!!");

			} else {
				SBOErrorMessage errMsg = iCompany.getLastError();
				System.out.println("Cannot add Sales Order: " + errMsg.getErrorMessage() + " " + errMsg.getErrorCode());
				
			}

		} catch (SBOCOMException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}

	}

}
