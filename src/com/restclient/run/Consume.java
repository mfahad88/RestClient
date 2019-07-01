package com.restclient.run;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;

import com.restclient.client.ApiClient;
import com.restclient.model.category.CategoryBean;
import com.restclient.model.category.Datum;

public class Consume {

	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub

		List<Datum> list=ApiClient.getInstance().categories().execute().body().getData();
		for(Datum datum:list) {
			Connection conn=ApplicationManager.connect();
			//System.out.println("category_id: "+datum.getCategoryId()+"\nname: "+datum.getName()+"\nimage: "+datum.getImage()+"\nhref: "+datum.getHref());
			InsertCategory(datum, conn);
		}

	}


	public static void InsertProduct(Datum datum,Connection conn) throws SQLException, MalformedURLException, IOException {

		String sql="INSERT INTO Category (name,image) VALUES (?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, datum.getName());
		pstmt.setBytes(2, downloadFile(new URL(datum.getImage().replace(" ", "%20"))));
		pstmt.execute();
		conn.close();		
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
}
