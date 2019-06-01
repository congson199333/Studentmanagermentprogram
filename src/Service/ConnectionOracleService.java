/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Service;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author hcshl
 */
public class ConnectionOracleService {
    protected Connection conn ;
public ConnectionOracleService()
{
	try 
	{
		String strConn ="jdbc:oracle:thin:@localhost:1521/orcl";
		conn=DriverManager.getConnection(strConn, "HCS", "son123");
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}
}