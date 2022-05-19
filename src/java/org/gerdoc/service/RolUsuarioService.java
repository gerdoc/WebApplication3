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
import org.gerdoc.dao.RolUsuario;
import org.gerdoc.dao.Usuario;

/**
 *
 * @author gerdoc
 */
public class RolUsuarioService 
{
    
    public List<RolUsuario> getRolUsuarioList( )
    {
        List<RolUsuario>rolUsuarioList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        RolUsuario rolUsuario = null;
        String sql = null;
        
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
            sql = "SELECT " +
                    "ID," +
                    "USUARIO, " +
                    "PASSWORD," +
                    "CORREO,"+
                    "ROL,"+
                    "DESCRIPCION "+
                    "FROM TBL_ROL_TBL_USER "+
                    "INNER JOIN TBL_ROL ON "+
                    "TBL_ROL_TBL_USER.TBL_ROL_ROL = TBL_ROL.ROL "+
                    "INNER JOIN TBL_USUARIO ON " +
                    "TBL_ROL_TBL_USER.TBL_USUARIO_USUARIO = TBL_USUARIO.USUARIO";
            resultSet = statement.executeQuery( sql );
            if( resultSet == null )
            {
                return null;
            }
            rolUsuarioList = new ArrayList<>();
            while( resultSet.next() )
            {
                rolUsuario = new RolUsuario( new Rol( ) , new Usuario( ) );
                rolUsuario.setId( resultSet.getInt(1) );
                rolUsuario.getUsuario().setUsuario( resultSet.getString(2) );
                rolUsuario.getUsuario().setPassword( resultSet.getString(3) );
                rolUsuario.getUsuario().setCorreo( resultSet.getString(4) );
                rolUsuario.getRol( ).setRol( resultSet.getString(5) );
                rolUsuario.getRol( ).setDescripcion( resultSet.getString(6) );
                rolUsuarioList.add(rolUsuario);
            }
            resultSet.close();
            MySqlConnection.closeConnection(connection);
            return rolUsuarioList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addRolUsuario( RolUsuario rolUsuario )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO TBL_rolUsuario(ROL,DESCRIPCION) VALUES(?,?)";
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
            preparedStatement.setString(1, rolUsuario.getRol().getDescripcion());
            preparedStatement.setString(2, rolUsuario.getRol().getRol());
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
    
    public boolean deleteRolUsuario( RolUsuario rolUsuario )
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
            preparedStatement.setString(1, rolUsuario.getRol().getRol());
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
    
    public RolUsuario getRolUsuarioById( String rolUsuario1 )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM TBL_UNO WHERE ROL= ?";
        RolUsuario rolUsuario = null;
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return null;
            }
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rolUsuario1 );
            resultSet = preparedStatement.executeQuery( );
            if( resultSet == null )
            {
                return null;
            }
            while( resultSet.next() )
            {
                rolUsuario = new RolUsuario();
                rolUsuario.getRol().setDescripcion(resultSet.getString(1) );
                rolUsuario.getRol().setRol(resultSet.getString(2) );
            }
            resultSet.close();
            MySqlConnection.closeConnection(connection);
            return rolUsuario;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean updateRolUsuario( RolUsuario rolUsuario )
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
            preparedStatement.setString(1, rolUsuario.getRol().getDescripcion());
            preparedStatement.setString(2, rolUsuario.getRol().getRol());
            
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
