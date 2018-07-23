package com.rci.moor.cat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

public abstract class AbstractDAO {

		/**
     * Gets a database connection.
     * @return a database connection.
     */
	public abstract Connection getConnection(); 
    
	/**
     * Closes a database connection and a statement.
     */
    public abstract void cleanUp();

	
}
