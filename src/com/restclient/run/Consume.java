package com.restclient.run;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;

import com.restclient.client.ApiClient;
import com.restclient.model.category.CategoryBean;
import com.restclient.model.category.Datum;

public class Consume {

	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		String[] catId= {"1371","1368","76","59","620","820","849"};
		
		createNewDatabase("Test.db");
		createCategory(ApplicationManager.connect("Test.db"));
		createProduct(ApplicationManager.connect("Test.db"));
			/*List<com.restclient.model.product.Datum> list=ApiClient.getInstance().products(catId[6]).execute().body().getData();
			for(com.restclient.model.product.Datum datum:list) {
				Connection conn=ApplicationManager.connect();
				InsertProduct(datum, conn, Integer.parseInt(catId[6]));
			}*/
		

	}


	public static void InsertProduct(com.restclient.model.product.Datum datum,Connection conn,int catId) throws SQLException, MalformedURLException, IOException {

		String sql="INSERT INTO Products (category_id,name,minimum,sku,quantity,price,cut_price,status,image) VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		System.out.println(datum.toString());
		pstmt.setInt(1, catId);
		pstmt.setString(2, datum.getName());
		pstmt.setString(3, datum.getMinimum());
		pstmt.setString(4, datum.getSku());
		pstmt.setString(5, datum.getQuantity());
		pstmt.setString(6, datum.getPrice());
		pstmt.setString(7, datum.getCutPrice());
		pstmt.setString(8, datum.getStatus());
		if(datum.getImage()!=null) {
			pstmt.setBytes(9, downloadFile(new URL(datum.getImage().replace(" ", "%20"))));
		}else {
			pstmt.setBytes(9, null);
		}
		pstmt.execute();
		conn.close();		
		System.out.println("Record inserted...");
	}

	public static void InsertCategory(Datum datum,Connection conn) throws SQLException, MalformedURLException, IOException {

		String sql="INSERT INTO Category (name,image) VALUES (?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, datum.getName());
		pstmt.setBytes(2, downloadFile(new URL(datum.getImage().replace(" ", "%20"))));
		pstmt.execute();
		conn.close();		
	}

	public static byte[] downloadFile(URL url) throws IOException
	{

		URLConnection conn = url.openConnection();

		conn.connect(); 

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		IOUtils.copy(conn.getInputStream(), baos);

		return baos.toByteArray();

	}
	
	public static void createNewDatabase(String fileName) {
		 
//        String url = "jdbc:sqlite:" + fileName;
 
        try (Connection conn = ApplicationManager.connect(fileName)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	
	}
    
	
	public static void createCategory(Connection conn) {
		String sql="CREATE TABLE Category (category_id	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,name	TEXT,image	BLOB)";
		Statement stmt = null;
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			System.out.println("Sql-->"+sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {			
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void createProduct(Connection conn) {
		String sql="CREATE TABLE Products (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,category_id INTEGER,name TEXT,minimum TEXT,sku TEXT,quantity TEXT,price TEXT,cut_price TEXT,status TEXT,image BLOB)";
		Statement stmt = null;
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			System.out.println("Sql-->"+sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {			
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
