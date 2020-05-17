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
					.compileReport(System.getProperty("user.dir") + "/report/Total_Sales.jrxml");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connect);
			JasperExportManager.exportReportToHtmlFile(jasperPrint,
					System.getProperty("user.dir") + "/src/report/Total_Sales.html");
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
					.compileReport(System.getProperty("user.dir") + "/report/Top_fiveCustomers.jrxml");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connect);
			JasperExportManager.exportReportToHtmlFile(jasperPrint,
					System.getProperty("user.dir") + "/src/report/Top_fiveCustomers.html");
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
					.compileReport(System.getProperty("user.dir") + "/report/Top_tenSellingBooks.jrxml");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connect);
			JasperExportManager.exportReportToHtmlFile(jasperPrint,
					System.getProperty("user.dir") + "/src/report/Top_tenSellingBooks.html");
			JasperViewer.viewReport(jasperPrint, false);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
