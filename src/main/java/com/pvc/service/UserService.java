package com.pvc.service;

import com.pvc.Utils.DataUtils;
import com.pvc.bean.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author P.Venkatesh
 *
 */
@Service
public class UserService implements IUserService {


	@Override
	public User getUserById(Long id) {
		User user = new User();
		user.setId(1234);
		user.setName("Venkat");
		return user;
	}

	@Override
	public List<User> getAllUsers(){
		return DataUtils.getUsers();
	}

}
