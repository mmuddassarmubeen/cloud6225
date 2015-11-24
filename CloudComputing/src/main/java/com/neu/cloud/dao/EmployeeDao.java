package com.neu.cloud.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.cloud.model.Employee;

public class EmployeeDao extends DAO {

	/*
	 * Since its a query, it is not necessary to wrap code inside the begin
	 * transaction and commit part, unlike update, create, and delete. Since
	 * there is no object in the session yet, nothing will be committed. After
	 * Adding these, "transaction is not successfully started' Exception will be
	 * thrown.
	 */

	public Employee queryUserByName(String name) throws Exception {
		try {
			// begin();

			Query q = getSession().createQuery("from Employee where name = :name ");
			q.setString("name", name);

			Employee user = (Employee) q.uniqueResult();
			// commit();
			close();
			return user;
		} catch (HibernateException e) {
			// rollback();
			throw new Exception("Could not get user " + name, e);
		}
	}

}
