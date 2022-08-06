package org.zerock.myapp.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zaxxer.hikari.HikariConfig;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= "file:src/main/webapp/WEB-INF/spring/root-context.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class DataSourceTsets {
	
	@Autowired
	private DataSource dataSource;
	
	@Setter(onMethod_= {@Autowired})
	private HikariConfig confing;
	
//	---------------------------------
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked.");
		
		Objects.requireNonNull(this.dataSource);
		log.trace("\t+ this.dataSource: {}",this.dataSource);
		
		assertNotNull(this.confing);
		log.trace("\t+ this.confing: {}",this.confing);
	}//beforeAll
	
	@Test
	@Order(2)
	@DisplayName("testHikariconfig")
	@Timeout(value=1000, unit=TimeUnit.MILLISECONDS)
	void testHikariconfig() {
		log.trace("testHikariconfig() invoked.");
		
		log.info("\t+ 1. DriverClassName: {}", this.confing.getDriverClassName());
	}//dummy
	
	
	@Test
	@Order(1)
	@DisplayName("testHikariCP")
	@Timeout(value=1000, unit=TimeUnit.MILLISECONDS)
	void testHikariCP() throws SQLException{
		log.trace("testHikariCP() invoked.");
		
		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
		
		try(conn; stmt; rs;){
			log.info("\t+ conn:"+conn);
			log.info("\t+ stmt:"+stmt);
			log.info("\t+ rs:"+rs);
			
			while(rs.next()) {
				String employee_id = rs.getString("EMPLOYEE_ID");
				String first_name = rs.getString("FIRST_NAME");
				String last_name = rs.getString("LAST_NAME");
				String email = rs.getString("EMAIL");
				String phone_number = rs.getString("PHONE_NUMBER");
				String hire_date = rs.getString("HIRE_DATE");
				String job_id = rs.getString("JOB_ID");
				String salary = rs.getString("SALARY");
				String commission_pct = rs.getString("COMMISSION_PCT");
				String department_id = rs.getString("DEPARTMENT_ID");
				
				String employee = String.format(
						"%s, %s, %s, %s, %s, %s, %s, %s, %s, %s",
						employee_id,first_name,last_name,email,phone_number,
						hire_date,job_id,salary,commission_pct,department_id
						);
				
				log.info(employee);
			}//while

		}//try
		
	}//testHikariCP
	
}//end class
