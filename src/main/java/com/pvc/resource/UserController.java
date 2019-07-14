package com.pvc.resource;

import com.pvc.bean.User;
import com.pvc.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest")
public class UserController {

	public static final String FAILURE = "Failure";
	public static final String SUCCESS = "Success";
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUserService userService;
	
	@GetMapping("user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		LOGGER.debug("debug level log");
		LOGGER.info("info level log");
		LOGGER.error("error level log");
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		String response = null;
		HttpStatus httpStatus = null;
		if(user.getId() == 0){
			response = FAILURE;
			httpStatus = HttpStatus.BAD_REQUEST;
		}else{
			response = SUCCESS;
			httpStatus = HttpStatus.OK;
		}
		return new ResponseEntity<User>(user, httpStatus);
	}

	@GetMapping("users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	

	

} 