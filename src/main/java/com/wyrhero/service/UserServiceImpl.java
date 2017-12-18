package com.wyrhero.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyrhero.dao.UserMapper;
import com.wyrhero.ssmdemo.bean.User;


@Service
public class UserServiceImpl implements UserService {

	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	//@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User getUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public User getUserByUsername(String username) {
		return userMapper.selectByUsername(username);
	}

	@Override
	public int addUser(User user) {
		return userMapper.insert(user);
		
	}

	@Override
	public int delUser(int id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateUser(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public List<User> getAllUser() {
		return userMapper.selectAll();
	}

	

}
