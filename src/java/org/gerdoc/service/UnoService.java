/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.gerdoc.dao.Uno;

/**
 *
 * @author gerdoc
 */
public class UnoService 
{
    
    public List<Uno> getUnoList( )
    {
        List<Uno>unoList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Uno uno = null;
        
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return null;
            }
            statement = connection.createStatement( );
            if( statement == null )
            {
                return null;
            }
            resultSet = statement.executeQuery( "SELECT * FROM TBL_UNO" );
            if( resultSet == null )
            {
                return null;
            }
            unoList = new ArrayList<>();
            while( resultSet.next() )
            {
                uno = new Uno();
                uno.setId( resultSet.getInt(1) );
                uno.setCampo1(resultSet.getInt(2) );
                uno.setCampo2(resultSet.getString(3) );
                uno.setCampo3(resultSet.getString(4) );
                uno.setCampo4(resultSet.getDate(5) );
                unoList.add(uno);
            }
            resultSet.close();
            MySqlConnection.closeConnection(connection);
            return unoList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addUno( Uno uno )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO TBL_UNO(CAMPO1,CAMPO2,CAMPO3,CAMPO4) VALUES(?,?,?,?)";
        int row = 0;
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setInt(1, uno.getCampo1());
            preparedStatement.setString(2, uno.getCampo2());
            preparedStatement.setString(3, uno.getCampo3());
            preparedStatement.setDate(4, new java.sql.Date( uno.getCampo4().getTime() ) );
            row = preparedStatement.executeUpdate();
            MySqlConnection.closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteUno( Uno uno )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM TBL_UNO WHERE ID = ?";
        int row = 0;
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setInt(1, uno.getId());
            row = preparedStatement.executeUpdate();
            MySqlConnection.closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public Uno getUnoById( Integer id )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM TBL_UNO WHERE ID= ?";
        Uno uno = null;
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return null;
            }
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id );
            resultSet = preparedStatement.executeQuery( );
            if( resultSet == null )
            {
                return null;
            }
            while( resultSet.next() )
            {
                uno = new Uno();
                uno.setId( resultSet.getInt(1) );
                uno.setCampo1(resultSet.getInt(2) );
                uno.setCampo2(resultSet.getString(3) );
                uno.setCampo3(resultSet.getString(4) );
                uno.setCampo4(resultSet.getDate(5) );
            }
            resultSet.close();
            MySqlConnection.closeConnection(connection);
            return uno;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean updateUno( Uno uno )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update TBL_UNO SET CAMPO1= ?, CAMPO2=?, CAMPO3=?,CAMPO4=? WHERE ID = ?";
        int row = 0;
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setInt(1, uno.getCampo1());
            preparedStatement.setString(2, uno.getCampo2());
            preparedStatement.setString(3, uno.getCampo3());
            preparedStatement.setDate(4, new java.sql.Date( uno.getCampo4().getTime() ) );
            preparedStatement.setInt(5, uno.getId());
            row = preparedStatement.executeUpdate();
            MySqlConnection.closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
}
