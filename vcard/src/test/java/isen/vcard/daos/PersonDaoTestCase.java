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
		stmt.executeUpdate("INSERT INTO person(idperson,lastname,firstname,nickname,phone_number,address,email_address,birth_date) VALUES"
				+ " (2,'HAKIMI','Mouad','Haki','+33784321699','saint denis','mouad.hakimi@student.junia.com',NULL)");
		stmt.executeUpdate("INSERT INTO person(idperson,lastname,firstname,nickname,phone_number,address,email_address,birth_date) VALUES"
				+ " (3,'BLINDA','Wissal','WiWi','+33763963498','fives','wissal.blinda@student.junia.com',NULL)");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void ListPersons() {
		// WHEN
		List<Person> person = personDao.listPersonnes();
		
		// THEN
		for(Person P : person) {
			P.printperson();
		}
		System.out.print("\n\n\n");
	}
	
	@Test
	public void AddPerson() {
		PersonDao.addPersonnes(4,"Test", "Test", "Test", "+33999999999", "Test", "Test@test.com", null);
		ListPersons();
		DeletePersonne();
		ListPersons();
	}
	
	@Test
	public void DeletePersonne() {
		PersonDao.DeletePersonne(4);
	}
	
}
