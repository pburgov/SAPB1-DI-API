package com.pburgov.sapb1;

import com.pburgov.sapb1.di.AddSalesOrder;
import com.pburgov.sapb1.di.SapConnection;
import com.pburgov.sapb1.model.SalesOrder;
import com.pburgov.sapb1.model.SalesOrderLine;
import com.sap.smb.sbo.api.ICompany;

import java.sql.Date;

public class App {

    public static void main( String[] args ) {

        SapConnection sapConnection = new SapConnection();
        sapConnection.connect();
        ICompany iCompany = sapConnection.getICompany();
        SalesOrder salesOrder = loadData();
        AddSalesOrder addSalesOrder = new AddSalesOrder(iCompany, salesOrder);
        addSalesOrder.createOrder();
        sapConnection.disconnect();

    }

    private static SalesOrder loadData() {

        SalesOrder salesOrder = new SalesOrder(Date.valueOf("2019-03-26"), Date.valueOf("2019-03-25"), "C000001");

        SalesOrderLine line1 = new SalesOrderLine("0520", 1.20, 20.0);
        SalesOrderLine line2 = new SalesOrderLine("0521", 1.20, 20.0);
        SalesOrderLine line3 = new SalesOrderLine("0522", 1.20, 20.0);

        salesOrder.addOrderLine(line1);
        salesOrder.addOrderLine(line2);
        salesOrder.addOrderLine(line3);

        return salesOrder;

    }
}
