package com.neu.cloud.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.neu.cloud.model.Employee;

public class EmployeeDao extends DAO{
	
	public List<Employee> queryEmployeeByName(String lastName)
            throws Exception {
        try {
      //      begin();
        	
        	Criteria criteria = getSession().createCriteria(Employee.class).add(Restrictions.eq("lastname",lastName));
            
            
        	List<Employee> employeeList = null;
            
            try
    		{
            	employeeList =  criteria.list();
    			
    		}
    		catch(Exception ex)
    		{
    			System.out.println("Exception occured" + ex.getCause().getMessage());
    		}
    		System.out.println(employeeList.size());
            
           return employeeList;
           
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user " + lastName, e);
        }
	}
	
	public List<Employee> queryEmployees()
            throws Exception {
		List<Employee> employeeList = null;
        try {
        	
        	Criteria criteria = getSession().createCriteria(Employee.class).setMaxResults(5000);
            try
    		{
            	employeeList =  criteria.list();
    			
    		}
    		catch(Exception ex)
    		{
    			System.out.println("Exception occured" + ex.getCause().getMessage());
    		}
    		System.out.println(employeeList.size());
            
           
           
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user ", e);
        }
        finally{
        	close();
        }
        return employeeList;
	}
	
	
	public boolean login(String username, String password)
            throws Exception {
        try {
      //      begin();
        	
        	Criteria criteria = getSession().createCriteria(Employee.class).add(Restrictions.eq("lastname",username)).add(Restrictions.eq("firstname",password));
            
            
        	List<Employee> users = null;
            
            try
    		{
            	users =  criteria.list();
    			
    		}
    		catch(Exception ex)
    		{
    			System.out.println("Exception occured" + ex.getCause().getMessage());
    		}
            
            if (users.size() > 0) {
    			return true;
    		} else {
    			return false;
    		}
           
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user ", e);
        }
	}
	
	

}
