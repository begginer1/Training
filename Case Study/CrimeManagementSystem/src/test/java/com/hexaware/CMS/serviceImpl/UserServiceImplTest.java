package com.hexaware.CMS.serviceImpl;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;
import com.hexaware.CMS.entity.User;
import com.hexaware.CMS.exception.AlreadyExistException;
import com.hexaware.CMS.exception.NotExistException;


@SpringBootTest
public class UserServiceImplTest {
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@Autowired
	private UserServiceImpl UserServiceImpl;    

	@Test
	public void generateIncidentTest() throws AlreadyExistException {
		Incident incident=new Incident(12,"Intiated","Lost Property","Purse","1000","Purse.img","Brown Leather","Near Gurgaon",LocalDate.of(2023,05,15),new HashSet<Officer>());
		User user = new User(1,new BigInteger("123456789012"),"John Doe","ABCDE1234F",LocalDate.of(1990,05,15),"123 Main St, City, Country"
				,"user@gmail.com",User.CalculateAge(LocalDate.of(1990,05,15)),List.of(incident));
		user = UserServiceImpl.generateIncident(user);
		LOGGER.log(Level.INFO, "saved user " + user);

	}

	@Test
	public void trackIncidentById() throws NotExistException {
		Incident incident= UserServiceImpl.trackIncidentById(1).get();
		if(incident ==null)
		LOGGER.log(Level.INFO, "saved user " + incident);

	}
}