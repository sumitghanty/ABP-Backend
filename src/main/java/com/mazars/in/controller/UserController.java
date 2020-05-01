package com.mazars.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mazars.in.model.mastermodel.Retainer;
import com.mazars.in.model.mastermodel.User;
import com.mazars.in.service.MasterListService;
import com.mazars.in.service.UserService;
@RestController
public class UserController {
@Autowired	
private UserService userService;
@Autowired	
private MasterListService masterListService;
	
	/**
	  * 
	  * 
	  * This method is for create the trip
	  * @param trip
	  * @return 
	  */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public User createUser(@RequestBody User user,@RequestHeader("token") String token,@RequestHeader("emailId") String emailId) {		
		User toFrontEnd=userService.save(user);
		return toFrontEnd ;

	}
	
	/**
	  * 
	  * 
	  * This method is for update the trip
	  * @param trip
	  * @return 
	  */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public User updateUser(@RequestBody User user,@RequestHeader("token") String token,@RequestHeader("emailId") String emailId) {
		User toFrontEnd=userService.update(user);
		return toFrontEnd ;

	}



/**
 * 
 * 
 * This method is for delete the trip
 * @param trip
 * @return
 */
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String deleteUser(@RequestBody User user) {
		
		String toFrontEnd=userService.delete(user);
		return toFrontEnd ;

	}
	/**
	  * 
	  * 
	  * This method is for getting the trip
	  * @param trip
	  * @return
	  */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/getUserList", method = RequestMethod.GET)
	public List<User> getUserList(@RequestHeader("token") String token,@RequestHeader("emailId") String emailId) {
		List<User> user=userService.list();
       return user;
	}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/getRetainerList", method = RequestMethod.GET)
	public List<Retainer> getRetainerList(@RequestHeader("token") String token,@RequestHeader("emailId") String emailId) {
		List<Retainer> retainerMaster=masterListService.getRetainerMaster();
       return retainerMaster;
	}

	
}
