package com.wyrhero.dao;

import java.util.List;

import com.wyrhero.common.persistence.annotation.MyBatisDao;
import com.wyrhero.ssmdemo.bean.User;

@MyBatisDao
public interface UserMapper {
	List<User> selectAll();
	User selectByPrimaryKey(Integer id);
	User selectByUsername(String username);
	int insert(User user);
	int deleteByPrimaryKey(Integer id);
	int updateByPrimaryKey(User user);
	 
    /*

    int insertSelective(User record);

    

    int updateByPrimaryKeySelective(User record);

   */
}