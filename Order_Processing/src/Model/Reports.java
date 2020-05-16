package Model;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Reports {

	public void total_sales() throws ClassNotFoundException, JRException {
		Map<String, Object> params = new HashMap<String, Object>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = connectDB.get_instance().get_connection();
		JasperReport jasperReport = JasperCompileManager.compileReport(System.getProperty("user.dir")+"/Report/src/Total_Sales.jrxml");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connect);
		JasperExportManager.exportReportToHtmlFile(jasperPrint, System.getProperty("user.dir")+"/Report/src/report/Total_Sales.html");
        JasperViewer.viewReport(jasperPrint, false);
	}
	
	public void top_fiveCustomers() throws ClassNotFoundException, JRException {
		Map<String, Object> params = new HashMap<String, Object>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = connectDB.get_instance().get_connection();
		JasperReport jasperReport = JasperCompileManager.compileReport(System.getProperty("user.dir")+"/Report/Top_fiveCustomers.jrxml");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connect);
		JasperExportManager.exportReportToHtmlFile(jasperPrint, System.getProperty("user.dir")+"/src/Report/Top_fiveCustomers.html");
        JasperViewer.viewReport(jasperPrint, false);
	}
	
	public void top_tenSellingBooks() throws ClassNotFoundException, JRException {
		Map<String, Object> params = new HashMap<String, Object>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = connectDB.get_instance().get_connection();
		JasperReport jasperReport = JasperCompileManager.compileReport(System.getProperty("user.dir")+"/Report/Top_tenSellingBooks.jrxml");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connect);
		JasperExportManager.exportReportToHtmlFile(jasperPrint, System.getProperty("user.dir")+"/src/Report/Top_tenSellingBooks.html");
        JasperViewer.viewReport(jasperPrint, false);
	}
}
