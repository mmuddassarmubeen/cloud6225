package com.neu.cloud;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.cloud.dao.EmployeeDao;
import com.neu.cloud.model.Employee;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "loginpage";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authenticate(HttpServletRequest request) 
	{
		
		EmployeeDao emp = new EmployeeDao();
		boolean result = false;
		try {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			 result = emp.login(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(result)
		{
			return "/report";
		}
		else
		{
			return "loginpage";
		}
		
	}
	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String report() {
		return "report";
	}
	
	@RequestMapping(value = "/healthreport", method = RequestMethod.GET)
	public @ResponseBody List<Employee> healthreport() {
		
		EmployeeDao emp = new EmployeeDao();
		
		List<Employee> empList = null;
		try {
			empList = emp.queryEmployees();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(empList.get(0).getLastname());
		return empList;
	}
	
	@RequestMapping(value = "/report", method = RequestMethod.POST)
	public @ResponseBody List<Employee> report(@RequestParam String lastName) {
		
		Date date = new Date();
		//DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		//String formattedDate = dateFormat.format(date);
		
		
		
		EmployeeDao emp = new EmployeeDao();
		
		List<Employee> empList = null;
		try {
			empList = emp.queryEmployeeByName(lastName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(empList.get(0).getLastname());
		return empList;
	}
	
	@RequestMapping(value = "/healthCheck", method = RequestMethod.POST)
	public @ResponseBody boolean healthCheck(@RequestParam String userCount) {
		
		ProcessBuilder pb = new ProcessBuilder("python", "/home/ubuntu/webclient.py",userCount);
		pb.directory(new File("/usr/bin/"));
		Process p = null;
		try {
			 p = pb.start();
			p.waitFor();
			int exit = p.exitValue();
			System.out.println(exit);
			
			InputStreamReader reader = new InputStreamReader(p.getErrorStream());
			
			BufferedReader rd = new BufferedReader(reader);
			String line = rd.readLine();
			while(line !=null)
			{
				System.out.println(line);
				line = rd.readLine();
			}
			p.getInputStream();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			p.destroy();
		}
		return true;
	}
	
}
