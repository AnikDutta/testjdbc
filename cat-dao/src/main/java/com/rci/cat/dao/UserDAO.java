package com.rci.moor.cat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.rci.moor.cat.OfferConstants;
import com.rci.util.db.DBConnectionManager;

public class UserDAO extends AbstractDAO {
	
	private static Logger log = Logger.getLogger(UserDAO.class);
	protected Connection con = null;
	protected PreparedStatement stmt = null;
	protected ResultSet rs = null;

	public UserDAO()
	{
		con = getConnection();
	}
	
	/**
     * Gets a database connection.
     * @return a database connection.
     */
    public Connection getConnection(){
        
        try {
        	con = DBConnectionManager.getODSConnection(OfferConstants.RCIAPPSECURITYDATASOURCE);
			/*javax.naming.InitialContext ic  = new javax.naming.InitialContext();
			DataSource dataSource = (DataSource)ic.lookup(OfferConstants.RCIAPPSECURITYDATASOURCE);
			con = dataSource.getConnection();*/
			log.info("DB URL= " +con.getMetaData().getURL());
		} /*catch (NamingException e) {
			log.error("NamingException ",e);
			con = null;
		} */catch (SQLException e) {
			log.error("SQLException",e);
			con = null;
		}catch (Exception e){
			log.error(e);
		}
		return con;
    }
    
    public Map<String,String> getUserRegionMap() throws SQLException
    {
    	Map<String,String> userRegionMap = new HashMap<String, String>();
	  	try {
	    		
			String userSQL = "SELECT * FROM SECURITY_USER";
			if(log.isDebugEnabled())
				log.debug("userSQL= " +userSQL);
			stmt = con.prepareStatement(userSQL);
			ResultSet userRS = stmt.executeQuery();
			log.debug("SECURITY_USER select statement has been executed");
			//Load User Region Mapping
			while (userRS.next()) {
				userRegionMap.put(userRS.getString("USER_NAME"), userRS.getString("REGION"));
			}
			if(log.isDebugEnabled())
				log.debug(">>>> User Region: Loaded Sucessfully");
		} catch (SQLException e) {
			log.error(e);
			throw e;
		} 
    	return userRegionMap;
    }
    
    public Map<String,String> getGroups() throws SQLException
    {
    	Map<String,String> groupsMap = new LinkedHashMap<String, String>();


	  	try {
	    		
			String groupSQL = "SELECT * FROM SECURITY_GROUP order by GROUP_ID";
			stmt = con.prepareStatement(groupSQL);
			ResultSet groupRS = stmt.executeQuery();
			log.debug("SECURITY_USER select statement has been executed");
			//Load Groups Mapping
			while (groupRS.next()) {
				groupsMap.put(groupRS.getString("GROUP_ID"), groupRS.getString("GROUP_DESC"));
			}
			if(log.isDebugEnabled())
				log.debug(">>>> Groups: Loaded Sucessfully");
		} catch (SQLException e) {
			log.error(e);
			throw e;
		} 
    	return groupsMap;
    }

    public Map<String,String> getRoles() throws SQLException
    {
    	Map<String,String> rolesMap = new LinkedHashMap<String, String>();
	  	try {
	    		
			String groupSQL = "SELECT * FROM SECURITY_ROLE order by ROLE_ID";
			stmt = con.prepareStatement(groupSQL);
			ResultSet roleRS = stmt.executeQuery();
			log.debug("SECURITY_ROLE select statement has been executed");
			//Load Role Mapping
			while (roleRS.next()) {
				rolesMap.put(roleRS.getString("ROLE_ID"), roleRS.getString("ROLE_NAME"));
			}
			if(log.isDebugEnabled())
				log.debug(">>>> Roles: Loaded Sucessfully");
		} catch (SQLException e) {
			log.error(e);
			throw e;
		} 
    	return rolesMap;
    }

    public List<String> getCapabilitiesForRole(String[] roleIDs) throws SQLException
    {
    	List<String>  capabilities = new ArrayList<String>();
	  	try {
	    		
			StringBuffer capabilitySQL 
					=new StringBuffer("SELECT CAPABILITY_NAME FROM SECURITY_ROLE_CAPABILITY T1," +
										" SECURITY_CAPABILITY T2 " +
										"WHERE T1.CAPABILITY_ID = T2.CAPABILITY_ID AND ROLE_ID IN (");
			for(int i=0 ; i<roleIDs.length; i++)
			{
				capabilitySQL.append(roleIDs[i]);
				
				if(i != (roleIDs.length-1))
					capabilitySQL.append(',');
				else
				if(i == (roleIDs.length-1))
					capabilitySQL.append(')');
			}
			
			if(log.isDebugEnabled())
				log.debug("capabilitySQL= " +capabilitySQL);
			
			stmt = con.prepareStatement(capabilitySQL.toString());
			ResultSet capabilityRS = stmt.executeQuery();
			log.debug("capabilitySQL select statement has been executed");
			
			//Load capability Mapping
			while (capabilityRS.next()) {
				capabilities.add(capabilityRS.getString("CAPABILITY_NAME"));
			}
			if(log.isDebugEnabled())
				log.debug(">>>> Capabilities: Loaded Sucessfully");
		} catch (SQLException e) {
			log.error(e);
			throw e;
		} 
    	return capabilities;
    }
    
    /**
     * Closes a database connection and a statement.
     */
    public void cleanUp(){
    	log.debug("In cleanUp");
        try{
            if(stmt != null)
                stmt.close();
        }catch(Exception e){
        	log.error("Error Closing Statement",e);
        }
        try{
            if(con != null) {
                con.close();
            }
        }catch(Exception e){
            log.error("Error Closing Connection",e);
        }
        log.debug("cleanUp complete");
    }

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}
