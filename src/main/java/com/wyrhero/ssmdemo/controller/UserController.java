package com.wyrhero.ssmdemo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyrhero.service.UserService;
import com.wyrhero.ssmdemo.bean.User;
import com.wyrhero.utils.ComMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	private UserService userService;

	@Resource(name="userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@ResponseBody
	@RequestMapping("/user")
	public User showUser(/*@PathVariable int id,*/HttpServletRequest request){
		User user = new User();
		user.setId(1);
		user.setUsername("wyrhero");
		user.setPassword("123456");
		/*User user = userService.getUserById(1);
		request.setAttribute("user", user);
		logger.debug("根据ID获取用户："+JSON.toJSONString(user));*/
		return user;
	}

	@RequestMapping("/userinfo")
	public String showUserInfo(/*@PathVariable int id,*/HttpServletRequest request,Model model){
		//ModelAndView model = new ModelAndView();
		User user = new User();
		user.setId(1);
		user.setUsername("wyrhero");
		user.setPassword("123456");
		model.addAttribute("user",user);
		model.addAttribute("username","wyrhero");
		//model.setViewName("userinfo.ftl");
		/*User user = userService.getUserById(1);
		request.setAttribute("user", user);
		logger.debug("根据ID获取用户："+JSON.toJSONString(user));*/
		return "userinfo";
	}
	
	@ResponseBody
	@RequestMapping(value = "/user/list",method=RequestMethod.GET,produces = "application/json; charset=utf-8")
	public String list(){
		/*User user = userService.getUserById(1);
		request.setAttribute("user", user);
		logger.debug("根据ID获取用户："+JSON.toJSONString(user));*/
		List<User> uList = userService.getAllUser();
		//JSONArray jsonArray = new JSONArray();
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(User u : uList) {
			sb.append("{");
			/*Map<String,String> tmp = new HashMap<String,String>();
			tmp.put("id", u.getId().toString());
			tmp.put("username", u.getUsername());
			String str = 0 == u.getRole()? new String("超级管理员") : new String("管理员");
			System.out.println(str);
			tmp.put("role", str);
			jsonArray.add(tmp);*/
			
			sb.append("\"id\":");
			sb.append("\"" + u.getId() + "\"");
			sb.append(",");
			sb.append("\"username\":");
			sb.append("\"" + u.getUsername() + "\"");
			sb.append(",");
			sb.append("\"role\":");
			sb.append("\"" + (0 == u.getRole()? "超级管理员" : "管理员") + "\"");
			
			
			sb.append("}");
			if(!u.equals(uList.get(uList.size() - 1))) {
				sb.append(",");
			}
		}
		sb.append("]");
		System.out.println(sb.toString());
		return sb.toString();
		//return jsonArray.toJSONString();
		//return JSON.toJSONString(uList);
	}
	
	@ResponseBody
	@RequestMapping(value = "/user/add",method=RequestMethod.POST,produces = "text/html; charset=utf-8")
	public String add(User user){
		
		if(null != user && null != user.getUsername() && !"".equals(user.getUsername()) && null != user.getPassword() && !"".equals(user.getPassword()) && null != user.getRole()) {
			user.setPassword(ComMethod.getMD5Str(user.getPassword()));
			userService.addUser(user);
		}
		StringBuffer sb = new StringBuffer();
		sb.append("{\"result\":");
		//0 : 成功   1： 失败
		if(null == user.getId()) {
			sb.append(1);
		} else {
			sb.append(0);
		}
		sb.append("}");
		//userService
		return sb.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "/user/delete",method=RequestMethod.POST,produces = "text/html; charset=utf-8")
	public String delete(User user){
		int affectRow = 0;
		if(null != user && null != user.getId() && !"admin".equals(user.getUsername())) {
			affectRow = userService.delUser(user.getId());
			System.out.println("delete:" + affectRow);
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("{\"result\":");
		//0 : 成功   1： 失败
		if(affectRow > 0) {
			sb.append(0);
		} else {
			sb.append(1);
		}
		sb.append("}");
		//userService
		return sb.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "/user/update",method=RequestMethod.POST,produces = "text/html; charset=utf-8")
	public String edit(User user){
		int affectRow = 0;
		if(null != user && null != user.getId()) {
			User sqlUser = userService.getUserById(user.getId());
			if(null != sqlUser) {
				if(null == user.getPassword() || "".equals(user.getPassword())) {
					user.setPassword(sqlUser.getPassword());
				} else {
					user.setPassword(ComMethod.getMD5Str(user.getPassword()));
				}
				affectRow = userService.updateUser(user);
			}
			
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("{\"result\":");
		//0 : 成功   1： 失败
		if(affectRow > 0) {
			sb.append(0);
		} else {
			sb.append(1);
		}
		sb.append("}");
		//userService
		return sb.toString();
		
	}
	
}
