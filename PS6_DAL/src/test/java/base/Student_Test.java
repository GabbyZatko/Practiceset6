package base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Student_Test {

	static PersonDomainModel per0 = new PersonDomainModel();
	static PersonDomainModel per1 = new PersonDomainModel();
	static PersonDomainModel per2 = new PersonDomainModel();
	
	//add some blank entries for testing
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PersonDAL.addPerson(per0);
		PersonDAL.addPerson(per1);
		PersonDAL.addPerson(per2);
	}

	//delete those entries
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PersonDAL.deletePerson(per0.getPersonID());
		PersonDAL.deletePerson(per1.getPersonID());
		PersonDAL.deletePerson(per2.getPersonID());
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	// this tests all 5 methods in PersonDAL
	// see comments for specific tests
	@Test
	public void test() {
		//first, ensure all three people were added correctly
		// this tests the getPerson and addPerson method
		assertTrue(PersonDAL.getPerson(per0.getPersonID()).getFirstName() == null);
		assertTrue(PersonDAL.getPerson(per1.getPersonID()).getFirstName() == null);
		assertTrue(PersonDAL.getPerson(per2.getPersonID()).getFirstName() == null);
		//check that after three were added, there are 3 entries in getPersons
		// this ensures getPersons works
		assertTrue(PersonDAL.getPersons().size() == 3);
		PersonDAL.deletePerson(per2.getPersonID());
		//delete a person, and getPersons
		// this ensures deletePerson and getPersons works
		assertTrue(PersonDAL.getPersons().size() == 2);
		//finally, update per0, and check to make sure the change was committed
		per0.setFirstName("bob");
		PersonDAL.updatePerson(per0);
		assertTrue(PersonDAL.getPerson(per0.getPersonID()).getFirstName() == "bob");
	}

}