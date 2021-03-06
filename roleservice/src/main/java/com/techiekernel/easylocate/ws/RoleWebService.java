package com.techiekernel.easylocate.ws;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techiekernel.easylocate.pojo.Role;
import com.techiekernel.easylocate.service.RoleService;

@Controller
@RequestMapping("/api/role")
public class RoleWebService {

	@Autowired
	RoleService roleService;

	@RequestMapping(value = "/{roleId}", method = RequestMethod.GET, headers = "Accept=application/json", produces = { "application/json" })
	@ResponseBody
	public Role getRole(@PathVariable int roleId, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return roleService.getRole(roleId);
	}

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", produces = { "application/json" })
	@ResponseBody
	public List<Role> getRoles(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return roleService.getRoles();
	}

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public boolean createRole(@RequestBody Role role,
			HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return roleService.saveOrUpdateRole(role);
	}

	@RequestMapping(value = "/{roleId}", method = RequestMethod.PUT, headers = "Accept=application/json", produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public boolean editFoobar(@RequestBody Role role, @PathVariable int roleId,
			HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		if (role.getRoleId() != null)
			return roleService.saveOrUpdateRole(role);
		else
			return false;
	}

	@RequestMapping(value = "/{roleId}", method = RequestMethod.DELETE, headers = "Accept=application/json", produces = { "application/json" })
	@ResponseBody
	public boolean deleteRole(@PathVariable int roleId,
			HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return roleService.deleteRole(roleId);
	}

}
