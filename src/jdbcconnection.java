import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class jdbcconnection {

	@Test
	public void dbConnection() {
		String host = "localhost";
		String port = "3306";
		// jdbc:mysql://localhost:3306/QADb
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/QADb", "root",
				"Nani1234!@");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from accountInfo where accname='Positivebalance';");
		while (rs.next()) {
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.salesforce.com/");
			driver.findElement(By.cssSelector("span[slot='start']")).click();
			driver.findElement(By.linkText("Salesforce")).click();
			driver.findElement(By.id("username")).sendKeys(rs.getString("username"));
			driver.findElement(By.id("password")).sendKeys(rs.getString("pass"));

		}
	}
}
