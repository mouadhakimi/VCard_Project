package isen.vcard.daos;


import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import isen.vcard.entities.Person;

public class PersonDaoTestCase {
	
	private PersonDao personDao = new PersonDao();
	
	@Before
	public void initDatabase() throws Exception {
		Connection connection = DataSourceFactory.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(
				"CREATE TABLE IF NOT EXISTS person (\r\n"
				+ "    idperson INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, \r\n"
				+ "    lastname VARCHAR(45) NOT NULL,  \r\n"
				+ "    firstname VARCHAR(45) NOT NULL,\r\n"
				+ "    nickname VARCHAR(45) NOT NULL,\r\n"
				+ "    phone_number VARCHAR(15) NULL,\r\n"
				+ "    address VARCHAR(200) NULL,\r\n"
				+ "    email_address VARCHAR(150) NULL,\r\n"
				+ "    birth_date VARCHAR(150) NULL);");
		
		stmt.executeUpdate("DELETE FROM person");
		stmt.executeUpdate("INSERT INTO person(idperson,lastname,firstname,nickname,phone_number,address,email_address,birth_date) VALUES"
				+ " (1,'Ouda','Amine','Aminux','+33763942277','saint omer','amine.ouda@student.junia.com',NULL)");
		//stmt.executeUpdate("INSERT INTO person(idperson,lastname,firstname,nickname,phone_number,address,email_address,birth_date) VALUES"
				//+ " (2,'Ouda','Amine','Aminux','+33763942277','saint omer','amine.ouda@student.junia.com','2002-10-01')");
		//stmt.executeUpdate("INSERT INTO person(idperson,lastname,firstname,nickname,phone_number,address,email_address,birth_date) VALUES"
				//+ " (3,'Ouda','Amine','Aminux','+33763942277','saint omer','amine.ouda@student.junia.com','2005-05-09')");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void shouldListGenres() {
		// WHEN
		List<Person> person = personDao.listPersonnes();
		
		// THEN
		person.forEach(System.out::println);

	}
	

}
