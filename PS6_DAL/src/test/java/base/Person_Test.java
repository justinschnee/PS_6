package base;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person_Test {
	
	private static PersonDomainModel p1;
	private static UUID per1id = UUID.randomUUID();
			
	private static PersonDomainModel p2;
	private static UUID per2id = UUID.randomUUID();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		p1 = new PersonDomainModel();
		p2 = new PersonDomainModel();
				
		p1.setPersonID(per1id);
		p1.setFirstName("Justin");
		p1.setLastName("Schnee");
		p1.setStreet("123 Catskill CT");
		p1.setPostalCode(12345);
		p1.setCity("Mahwah");
		
		p2.setPersonID(per2id);
		p2.setFirstName("James");
		p2.setLastName("Smith");
		p2.setStreet("123 South Catskill");
		p2.setPostalCode(34567);
		p2.setCity("Mahwah");
		
		PersonDAL.addPerson(p1);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PersonDAL.deletePerson(per1id);
		PersonDAL.deletePerson(per2id);
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void AddPerson() {
		PersonDomainModel p3 = new PersonDomainModel();
		p3.setBirthday(new Date(0));
		p3.setCity("Newark");
		p3.setFirstName("Mike");
		p3.setLastName("Smith");
		p3.setPostalCode(12345);
		p3.setStreet("123 Yotes Way");
		
		PersonDAL.addPerson(p3);
	}
	@Test 
	public void testGetPersons(){
		ArrayList<PersonDomainModel> pers = PersonDAL.getPersons();
		assertNotNull(pers);
	}
	@Test
	public void GetPersonTest(){
		String LastName = p1.getLastName();
		assertEquals("Schnee",LastName);
	}
	
	@Test
	public void TestDeletePerson() {
		PersonDAL.deletePerson(per2id);
		assertFalse(PersonDAL.getPersons().contains(p2));
	}
	

}