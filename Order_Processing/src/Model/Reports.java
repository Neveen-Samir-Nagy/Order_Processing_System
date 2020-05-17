package Model;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

public class Reports {

	Statement stmt;
	ResultSet rs;
	connectDB db = connectDB.get_instance();

	public void total_sales() throws JRException {
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = db.get_connection();
			JasperReport jasperReport = JasperCompileManager
					.compileReport(System.getProperty("user.dir") + "/report/totalSales.jrxml");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connect);
			JasperExportManager.exportReportToHtmlFile(jasperPrint,
					System.getProperty("user.dir") + "/src/report/totalSales.html");
			JasperViewer.viewReport(jasperPrint, false);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void top_fiveCustomers() throws JRException {
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = db.get_connection();
			JasperReport jasperReport = JasperCompileManager
					.compileReport(System.getProperty("user.dir") + "/report/topCustomers.jrxml");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connect);
			JasperExportManager.exportReportToHtmlFile(jasperPrint,
					System.getProperty("user.dir") + "/src/report/topCustomers.html");
			JasperViewer.viewReport(jasperPrint, false);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void top_tenSellingBooks() throws JRException {
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = db.get_connection();
			JasperReport jasperReport = JasperCompileManager
					.compileReport(System.getProperty("user.dir") + "/report/topBooks.jrxml");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connect);
			JasperExportManager.exportReportToHtmlFile(jasperPrint,
					System.getProperty("user.dir") + "/src/report/topBooks.html");
			JasperViewer.viewReport(jasperPrint, false);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
