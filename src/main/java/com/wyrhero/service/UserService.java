package com.wyrhero.service;

import java.util.List;

import com.wyrhero.ssmdemo.bean.User;


public interface UserService {
	/**
	 * 根据id获取用户
	 */
	public User getUserById(Integer id);
	public User getUserByUsername(String username);
	public List<User> getAllUser();
	public int addUser(User user);
	public int delUser(int id);
	public int updateUser(User user);
}
