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
import org.gerdoc.dao.Rol;

/**
 *
 * @author gerdoc
 */
public class RolService 
{
    
    public List<Rol> getRolList( )
    {
        List<Rol>rolList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Rol rol = null;
        
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
            resultSet = statement.executeQuery( "SELECT * FROM TBL_ROL" );
            if( resultSet == null )
            {
                return null;
            }
            rolList = new ArrayList<>();
            while( resultSet.next() )
            {
                rol = new Rol();
                rol.setRol(resultSet.getString(1) );
                rol.setDescripcion(resultSet.getString(2) );
                rolList.add(rol);
            }
            resultSet.close();
            MySqlConnection.closeConnection(connection);
            return rolList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addRol( Rol rol )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO TBL_rol(ROL,DESCRIPCION) VALUES(?,?)";
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
            preparedStatement.setString(1, rol.getRol());
            preparedStatement.setString(2, rol.getDescripcion());
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
    
    public boolean deleteRol( Rol rol )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM TBL_UNO WHERE ROL = ?";
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
            preparedStatement.setString(1, rol.getRol());
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
    
    public Rol getRolById( String rol1 )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM TBL_UNO WHERE ROL= ?";
        Rol rol = null;
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return null;
            }
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rol1 );
            resultSet = preparedStatement.executeQuery( );
            if( resultSet == null )
            {
                return null;
            }
            while( resultSet.next() )
            {
                rol = new Rol();
                rol.setRol(resultSet.getString(1) );
                rol.setDescripcion(resultSet.getString(2) );
            }
            resultSet.close();
            MySqlConnection.closeConnection(connection);
            return rol;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean updateRol( Rol rol )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update TBL_UNO SET DESCRIPCION=? WHERE ROL = ?";
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
            preparedStatement.setString(1, rol.getDescripcion());
            preparedStatement.setString(2, rol.getRol());
            
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
