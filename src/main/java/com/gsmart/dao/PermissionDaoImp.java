package com.gsmart.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gsmart.model.RolePermission;
import com.gsmart.util.Constants;
import com.gsmart.util.GSmartBaseException;
import com.gsmart.util.GSmartDatabaseException;

@Repository
public class PermissionDaoImp implements PermissionDao {

	@Autowired
	SessionFactory sessionFactory;
	Session session;
	Query query;
	Transaction transaction;

	private static final Logger logger = Logger.getLogger(PermissionDaoImp.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<RolePermission> getPermissionList() throws GSmartDatabaseException {
		List<RolePermission> rolePermissions = null;
		try {
			getConnection();
			query = session.createQuery("from RolePermission");
			rolePermissions = (List<RolePermission>) query.list();
			
		} catch (Exception e) {
			throw new GSmartDatabaseException(e.getMessage());
		} finally {
			session.close();
		}
		return rolePermissions;
	}

	
	@Override
	public void addPermission(RolePermission permission) throws GSmartDatabaseException {
		logger.debug("Start :: PermissionDaoImp.addPermission()");
		try {
			getConnection();
			session.save(permission);
			transaction.commit();
		} catch (ConstraintViolationException e) {
			throw new GSmartDatabaseException(Constants.CONSTRAINT_VIOLATION);
		} catch (Exception e) {
			throw new GSmartDatabaseException(e.getMessage());
		} finally {
			session.close();
		}
		logger.debug("End :: PermissionDaoImp.addPermission()");
	}

	@Override
	public void deletePermission(RolePermission permission) throws GSmartDatabaseException {
		logger.debug("Start :: PermissionDaoImp.deletePermission()");
		try {
			getConnection();
			session.delete(permission);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.debug("End :: PermissionDaoImp.deletePermission()");
	}

		public void getConnection() {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

		@Override
		public void editPermission(RolePermission permission) throws GSmartBaseException {
			logger.debug("Start :: PermissionDaoImp.editBand()");
			try {
				getConnection();
				query = session.createQuery(
						"UPDATE RolePermission set  moduleName =:moduleName, role=:role, add=:add, view=:view, edit=:edit, del=:del WHERE timeStamp = :timeStamp");
				query.setParameter("moduleName", permission.getModuleName());
				query.setParameter("role", permission.getRole());
				query.setParameter("view", permission.getView());
				query.setParameter("add", permission.getAdd());
				query.setParameter("edit", permission.getEdit());
				query.setParameter("del", permission.getDel());
				query.setParameter("timeStamp", permission.getTimeStamp());
				
				query.executeUpdate();
				transaction.commit();

			} catch (ConstraintViolationException e) {
				throw new GSmartDatabaseException(Constants.CONSTRAINT_VIOLATION);
			} catch (Exception e) {
				throw new GSmartDatabaseException(e.getMessage());
			} finally {
				session.close();
			}
			logger.debug("End :: PermissionDaoImp.editBand()");
			
		}

}
