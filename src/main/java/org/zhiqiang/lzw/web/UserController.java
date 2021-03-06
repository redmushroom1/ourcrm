package org.zhiqiang.lzw.web;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zhiqiang.lzw.entity.Group;
import org.zhiqiang.lzw.entity.Role;
import org.zhiqiang.lzw.entity.User;
import org.zhiqiang.lzw.entity.Weather;
import org.zhiqiang.lzw.entity.custom.PageBean;
import org.zhiqiang.lzw.entity.custom.UserCustom;
import org.zhiqiang.lzw.exception.CustomException;
import org.zhiqiang.lzw.service.IGroupService;
import org.zhiqiang.lzw.service.IRoleService;
import org.zhiqiang.lzw.service.IUserService;
import org.zhiqiang.lzw.service.IWeatherService;
import org.zhiqiang.lzw.util.MD5keyBean;

/**
 * 用户后端控制器
 * @author LZW
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Autowired
	@Qualifier("groupService")
	private IGroupService groupService;
	
	@Autowired
	@Qualifier("roleService")
	private IRoleService roleService;
	
	@Autowired
	@Qualifier("weatherService")
	private IWeatherService weatherService;
	
	/**
	 * 登录
	 * @param name
	 * @param password
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String login(String name,String password,String checkNum,HttpServletRequest request,HttpSession session) throws Exception{
		if (checkNum!=null && !checkNum.trim().isEmpty()) {
			Object attribute = session.getAttribute("CHECK_NUMBER_KEY");
			if (attribute!=null) {
				String verifyNo = (String) attribute;
				if (!verifyNo.equals(checkNum)) {
					request.setAttribute("checkInfo", "验证码错误！");
					request.setAttribute("name", name);
					request.setAttribute("password", password);
					return "index";
				}
			}else {
				request.setAttribute("checkInfo", "验证码生成出错！");
				request.setAttribute("name", name);
				request.setAttribute("password", password);
				return "index";
			}
			
		}else {
			request.setAttribute("checkInfo", "验证码不能为空！");
			request.setAttribute("name", name);
			request.setAttribute("password", password);
			return "index";
		}
		
		System.out.println("name:"+name+"\t"+"password:"+password);
		UserCustom userCustom =null;
		if (name!=null && !name.trim().isEmpty() 
			&& password!=null && !password.trim().isEmpty()) {
			userCustom = userService.login(name, password);//登录查询
		}
		if (userCustom!=null) {
			//登录成功，将用户信息保存至session域中
			session.setAttribute("userCustom", userCustom);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			session.setAttribute("today", dateFormat.format(new Date())); 
			//查询天气信息并保存在到session域中
			try {
				List<Weather> weatherList = weatherService.getWeatherbyCityName("长沙");
				session.setAttribute("weatherList", weatherList);
			} catch (Exception e) {
				logger.info("获得天气信息异常！");
			}
			logger.info("用户登录成功！"+userCustom.getName());
			return "page/newPagePlan/menu/main";
		}
		System.out.println("userCustom"+userCustom);
		return "index";
	}
	
	/**
	 * 注销
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		//将session中的用户对象清除
		HttpSession session = request.getSession();
		session.removeAttribute("userCustom");
		return "index";
	}
	
	/**
	 * 展示用户
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/showUser")
	public String showUser(String cnname,PageBean pageBean,Model model) throws UnsupportedEncodingException{
		if (cnname==null || cnname.trim().isEmpty()) {
			cnname = null;
		}
		if (pageBean==null) {
			pageBean = new PageBean();
		}
		if (cnname!=null) {
			cnname = new String(cnname.getBytes("iso-8859-1"),"utf-8");
			pageBean.setUrl("cnname="+cnname);
		}
		//查询总记录数
		Integer userCount = userService.selectCountLikeUname(cnname==null?null:"%"+cnname+"%");
		pageBean.setTotalRecords(userCount);
		
		//查询分页
		List<User> userList = userService.selectUserByPage(cnname==null?null:"%"+cnname+"%", pageBean);
		model.addAttribute("userList", userList);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("cnname", cnname);
		
		return "page/newPagePlan/sys/userandrole/list";
	}
	
	/**
	 * 用于为用户页面渲染数据
	 * @return
	 */
	@RequestMapping("/addUserPre")
	public String addUserPre(Model model){
		//获得所有部门
		List<Group> groupList = groupService.selectAllGroup();
		model.addAttribute("groupList", groupList);
		return "page/newPagePlan/sys/userandrole/add";
	}
	
	/**
	 * 新增用户
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(User user){
		if (user!=null) {
			MD5keyBean md5 = new MD5keyBean();
			String pw = md5.getkeyBeanofStr(user.getPassword());
			user.setPassword(pw);
			userService.insertSelective(user);
		}
		//这里的需要采用重定向,这一次请求共享了user.cnname这个属性，这是不必要的
		return "redirect:/user/showUser.do"; 
	}
	
	/**
	 * 批量删除用户
	 * @param uids
	 * @return
	 */
	@RequestMapping("/deleteUserByBatch")
	public String deleteUserByBatch(Integer[] uids){
		if (uids!=null && uids.length>0) {
			for (Integer uid : uids) {
				//删除用户前，先删除用户角色记录
				userService.deleteUserRoleByUid(uid);
			}
			userService.deleteUserByBatch(uids);
		}
		return "forward:/user/showUser.do";
	}
	
	/**
	 * 用户角色设置页面的数据展示
	 * @return
	 */
	@RequestMapping("/showRoleInUser")
	public String showRoleInUser(Integer uid,Model model){
		StringBuilder ridStr = new StringBuilder();
		//当前用户所具有的角色
		List<Role> roleOrigin = userService.selectRoleByUid(uid);
		if (roleOrigin!=null && roleOrigin.size()>0) {
			for (Role role : roleOrigin) {
				ridStr.append(role.getRoleid()+",");
			}
		}
		
		//所有存在的角色
		List<Role> roleAllList = roleService.selectAllRole();
		//在所有角色中过滤掉用户已有角色
		if (roleAllList!=null && roleAllList.size()>0) {
			Iterator<Role> iterator = roleAllList.iterator();
			while (iterator.hasNext()) {
				Role role = (Role) iterator.next();
				boolean flag = false;
				if (roleOrigin!=null && roleOrigin.size()>0) {
					for (Role roleOri : roleOrigin) {
						if (role.getRoleid().equals(roleOri.getRoleid())) {
							flag = true;
						}
					}
				}
				if (flag) {
					iterator.remove();
				}
			}
		}
		
		model.addAttribute("roleOrigin", roleOrigin);
		model.addAttribute("roleAllList", roleAllList);
		model.addAttribute("ridStr", ridStr.toString().length()>0?ridStr.toString()
				.substring(0, ridStr.toString().length()-1):"");
		model.addAttribute("uid", uid);
		
		return "page/newPagePlan/sys/userandrole/roleInUser";
	}
	
	/**
	 * 保存用户角色设置
	 * @return
	 */
	@RequestMapping("/saveUserRole")
	public String saveUserRole(String ridStr,Integer[] lselect,Integer uid){
		String[] ridOrigin = null;
		if (ridStr!=null && !ridStr.trim().isEmpty()) {
			ridOrigin = ridStr.split(",");
			//对比用户原有的角色，和新提交的角色，得出需要删除的用户角色
			for (String ridOri : ridOrigin) {
				boolean flag = true;
				if (lselect!=null) {
					for (Integer rid : lselect) {
						if (rid.equals(Integer.parseInt(ridOri))) {
							flag = false;
							break;
						}
					}
				}
				if (flag) {
					//移除此用户角色记录
					userService.deleteUserRole(uid, Integer.parseInt(ridOri));
				}
			}
		}
		
		//对比新提交的角色和用户原有角色，得出需要新增的用户角色记录
		if (lselect!=null) {
			for (Integer rid : lselect) {
				boolean flag = true;
				if (ridOrigin!=null) {
					for (String ridOri : ridOrigin) {
						if (rid.equals(Integer.parseInt(ridOri))) {
							flag = false;
						}
					}
				}
				if (flag) {
					//在原有集合中没有找到相同的角色，需要新增
					userService.insertUserRole(uid, rid);
				}
			}
		}
		return "forward:/user/showUser.do";
	}
	
	
	
	
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public void setWeatherService(IWeatherService weatherService) {
		this.weatherService = weatherService;
	}
	
	
	
	
}
