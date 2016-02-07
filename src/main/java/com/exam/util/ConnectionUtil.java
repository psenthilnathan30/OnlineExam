package com.exam.util;

import java.sql.Connection;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConnectionUtil {

	/** A private Constructor prevents any other class from instantiating. */
	private ConnectionUtil() {
		// Optional Code
	}

	private static Connection conn;

	public static synchronized Connection getSingletonObject() {
		if (conn == null) {
		//	String url = PropertiesCache.getProperty("MYSQL_URL");
			//String dbName = PropertiesCache.getProperty("DATABASE_NAME");
			;
			//String driver = PropertiesCache.getProperty("MYSQL_DRIVER");
			;
			//String userName = PropertiesCache.getProperty("MYSQL_USERNAME");
			;
			//String password = PropertiesCache.getProperty("MYSQL_PASSWORD");
			;
			try {
				//Class.forName(driver).newInstance();
				//conn = DriverManager.getConnection(url + dbName, userName,
					//	password);
			} catch (Exception sqle) {
				sqle.printStackTrace();
			}
		}
		return conn;
	}

	// We can still be able to create a copy of the Object by cloning it using
	// the Object’s clone method
	// to prevent we are overriding below method
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public static void main(String[] args) {
		convertXMLToText("");
	}

	public static void convertXMLToText(String path) {

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer tr;
		try {
			System.out.println(" Range Id \t\t\t Line Number");
			String fileName = "C:\\Users\\senthil kumar\\Desktop\\sample.xml";
			String xslFile = "C:\\Users\\senthil kumar\\Desktop\\sample.xslt";
			tr = tf.newTransformer(new StreamSource(
					"C:\\Users\\senthil kumar\\Desktop\\sample.xslt"));
			tr.transform(new StreamSource(
					"C:\\Users\\senthil kumar\\Desktop\\sample.xml"),
					new StreamResult(System.out));

		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
