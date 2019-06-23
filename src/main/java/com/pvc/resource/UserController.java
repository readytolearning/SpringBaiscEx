package com.pvc.resource;

import com.pvc.bean.User;
import com.pvc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest")
public class UserController {

	public static final String FAILURE = "Failure";
	public static final String SUCCESS = "Success";
	@Autowired
	private IUserService userService;
	
	@GetMapping("user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("user")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		String response = null;
		HttpStatus httpStatus = null;
		if(user.getId() == 0){
			response = FAILURE;
			httpStatus = HttpStatus.BAD_REQUEST;
		}else{
			response = SUCCESS;
			httpStatus = HttpStatus.OK;
		}
		return new ResponseEntity<String>(response, httpStatus);
	}
	

	

} 