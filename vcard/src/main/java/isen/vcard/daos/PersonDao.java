package isen.vcard.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import isen.vcard.entities.Person;

public class PersonDao {
	
	public List<Person> listPersonnes() {
		List<Person> listPersonnes = new ArrayList<>();
		Connection conn = null;
		try {
		      conn = DataSourceFactory.getDataSource().getConnection();
		      
		      String sqlQuery = "SELECT * FROM person";
		      PreparedStatement statement = conn.prepareStatement(sqlQuery);
		      ResultSet resultSet = statement.executeQuery();
		      
		      while (resultSet.next()) {
		    	  Person person = new Person(resultSet.getInt("idperson"),resultSet.getString("lastname"), resultSet.getString("firstname"),
		    			  					resultSet.getString("nickname"), resultSet.getString("phone_number"), resultSet.getString("address"),
		    			  					resultSet.getString("email_address"), resultSet.getDate("birth_date"));
		    	  listPersonnes.add(person);
	          }
		      

		    } catch (SQLException e) {
		        throw new Error("Problem", e);
		    } finally {
		      try {
		        if (conn != null) {
		            conn.close();
		        }
		      } catch (SQLException ex) {
		          System.out.println(ex.getMessage());
		      }
		    }
		return listPersonnes;
	}
	
	public static void addPersonnes(Integer id,String ln,String fn,String nn,
			String pn,String ad,String ea,Date bd) {
		Connection conn = null;
		try {
		      conn = DataSourceFactory.getDataSource().getConnection();
		      
		      String sqlQuery = "INSERT INTO person(idperson,lastname,firstname,nickname,phone_number,address,email_address,birth_date)"
		      		+ " VALUES (?,?,?,?,?,?,?,NULL)";
		      PreparedStatement statement = conn.prepareStatement(sqlQuery);
		      statement.setInt(1, id);
		      statement.setString(2, ln);
		      statement.setString(3, fn);
		      statement.setString(4, nn);
		      statement.setString(5, pn);
		      statement.setString(6, ad);
		      statement.setString(7, ea);
		      statement.executeUpdate();	      
		      
		    } catch (SQLException e) {
		        throw new Error("Problem", e);
		    } finally {
		      try {
		        if (conn != null) {
		            conn.close();
		        }
		      } catch (SQLException ex) {
		          System.out.println(ex.getMessage());
		      }
		    }
		
	}
	
	public static void DeletePersonne(Integer id) {
		Connection conn = null;
		try {
		      conn = DataSourceFactory.getDataSource().getConnection();
		      
		      String sqlQuery = "DELETE FROM person WHERE idperson = ?";
		      PreparedStatement statement = conn.prepareStatement(sqlQuery);
		      statement.setInt(1, id);
		      statement.executeUpdate();	      
		      
		    } catch (SQLException e) {
		        throw new Error("Problem", e);
		    } finally {
		      try {
		        if (conn != null) {
		            conn.close();
		        }
		      } catch (SQLException ex) {
		          System.out.println(ex.getMessage());
		      }
		    }
	}

}
