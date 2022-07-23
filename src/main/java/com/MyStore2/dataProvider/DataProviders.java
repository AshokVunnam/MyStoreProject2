package com.MyStore2.dataProvider;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.MyStore.utility.NewExcelLibrary;

public class DataProviders {
	
	NewExcelLibrary obj=new NewExcelLibrary();
	
	@DataProvider(name="Credentials")
	public Object[][] getCredentials()
	{
		int row=obj.getRowCount("Credentials");
		int columns=obj.getColumnCount("Credentials");
		int actRows=row-1;
		
		Object[][] data=new Object[actRows][columns];
		for(int i=0;i<actRows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				data[i][j]=obj.getCellData("Credentials", j, i+2);
			}
		}
		
		return data;
	}
	
	@DataProvider(name="Email")
	public Object[][] getEmail()
	{
		int row=obj.getRowCount("Email");
		int column=obj.getColumnCount("Email");
		int actRows=row-1;
		
		Object[][] data=new Object[actRows][column];
		for(int i=0;i<actRows;i++)
		{
			for(int j=0;j<column;j++)
			{
				data[i][j]=obj.getCellData("Email", j, i+2);
			}
		}
		
		return data;
	}
	
	@DataProvider(name="SearchProduct")
	public Object[][] getProduct()
	{
		int row=obj.getRowCount("SearchProduct");
		int column=obj.getColumnCount("SearchProduct");
		int actRows=row-1;
		
		Object[][] data=new Object[actRows][column];
		for(int i=0;i<actRows;i++)
		{
				for(int j=0;j<column;j++)
				{
					data[i][j]=obj.getCellData("SearchProduct", j, i+2);
				}
		}
		
		return data;
	}
	
	@DataProvider(name="ProductDetails")
	public Object[][] getProductDetails()
	{
		int row=obj.getRowCount("ProductDetails");
		int column=obj.getColumnCount("ProductDetails");
		int actRows=row-1;
		
		Object[][] data=new Object[actRows][column];
		for(int i=0;i<actRows;i++)
		{
			for(int j=0;j<column;j++)
			{
				data[i][j]=obj.getCellData("ProductDetails", j, i+2);
			}
		}
		
		return data;
	}
	
	@DataProvider(name="AccountCreationData")
	public Object[][] getAccountCreationDetails()
	{
		int rows = obj.getRowCount("AccountCreationData");
		// Total Columns
		int column = obj.getColumnCount("AccountCreationData");
		int actRows = rows - 1;
		//Created an object of array to store data
		Object[][] data = new Object[actRows][1];
		
		for (int i = 0; i < actRows; i++) {
			Map<String, String> hashMap = new HashMap<>();
			for (int j = 0; j < column; j++) {
				hashMap.put(obj.getCellData("AccountCreationData", j, 1),
						obj.getCellData("AccountCreationData", j, i + 2));
			}
			data[i][0]=hashMap;
		}
		return data;
	}

}
