package base;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	private static PersonDomainModel per = new PersonDomainModel();
	private static UUID perUUID = UUID.randomUUID();
	private static  LocalDate date = LocalDate.of(1998, 5, 22);
	
	@BeforeClass
	
	public static void setUpBeforeClass() throws Exception {
		
	per = new PersonDomainModel();
	per.setFirstName("Justin");
	per.setLastName("Schnee");
	per.setBirthday(date);
	per.setCity("Mahwah");
	per.setPostalCode(12345);
	per.setStreet("123 Catskill Court");
}

	@AfterClass
	
	public static void tearDownAfterClass() throws Exception {
					per = null;
	
	}

	@Before
	public void setUp() throws Exception 
	{
		
	}

	@After
	public void tearDown() throws Exception 
	{
	
	}

	@Test
	public void GetPerson() throws Exception
	{
		
		PersonDAL.addPerson(per);
		String FirstName = per.getLastName();
			assertEquals("Justin",FirstName);
	}
	
	@Test
	public void AddPerson() throws Exception 
	{
		
		PersonDomainModel per=new PersonDomainModel();
		PersonDAL.addPerson(per);
		}

	@Test
	public void DeletePerson() throws Exception
	{
		PersonDAL.addPerson(per);
		PersonDAL.deletePerson(per.getPersonID());
	}
	@Test
	public void UpdatePerson() throws Exception
	{
		PersonDAL.addPerson(per);
		per.setLastName("Schnee");
		PersonDAL.updatePerson(per);
	    }


}