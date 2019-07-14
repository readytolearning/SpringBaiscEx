package com.pvc.service;


import com.pvc.bean.User;

import java.util.List;

/**
 * @author P.Venkatesh
 *
 */
public interface IUserService {
	User getUserById(Long id);

	List<User> getAllUsers();
}
