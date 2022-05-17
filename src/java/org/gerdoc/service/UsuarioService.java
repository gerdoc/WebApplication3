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
import org.gerdoc.dao.Usuario;

/**
 *
 * @author gerdoc
 */
public class UsuarioService 
{
    
    public List<Usuario> getUsuarioList( )
    {
        List<Usuario>usuarioList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Usuario usuario = null;
        
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
            resultSet = statement.executeQuery( "SELECT * FROM TBL_USUARIO" );
            if( resultSet == null )
            {
                return null;
            }
            usuarioList = new ArrayList<>();
            while( resultSet.next() )
            {
                usuario = new Usuario();
                usuario.setUsuario(resultSet.getString(1) );
                usuario.setPassword(resultSet.getString(2) );
                usuario.setCorreo(resultSet.getString(3) );
                usuarioList.add(usuario);
            }
            resultSet.close();
            MySqlConnection.closeConnection(connection);
            return usuarioList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addUsuario( Usuario usuario )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO TBL_USUARIO(USUARIO,PASSWORD,CORREO) VALUES(?,?,?)";
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
            preparedStatement.setString(1, usuario.getUsuario());
            preparedStatement.setString(2, usuario.getPassword());
            preparedStatement.setString(3, usuario.getCorreo());
            
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
    
    public boolean deleteUsuario( Usuario usuario )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM TBL_USUARIO WHERE USUARIO = ?";
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
            preparedStatement.setString(1, usuario.getUsuario());
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
    
    public Usuario getUsuarioById( String usuario1 )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM TBL_USUARIO WHERE USUARIO= ?";
        Usuario usuario = null;
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return null;
            }
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario1 );
            resultSet = preparedStatement.executeQuery( );
            if( resultSet == null )
            {
                return null;
            }
            while( resultSet.next() )
            {
                usuario = new Usuario();
                usuario.setUsuario(resultSet.getString(1) );
                usuario.setPassword(resultSet.getString(2) );
                usuario.setCorreo(resultSet.getString(3) );
                
            }
            resultSet.close();
            MySqlConnection.closeConnection(connection);
            return usuario;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean updateUsuario( Usuario usuario )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update TBL_USUARIO SET PASSWORD=?, CORREO=? WHERE USUARIO= ?";
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
            preparedStatement.setString(1, usuario.getPassword());
            preparedStatement.setString(2, usuario.getCorreo());
            preparedStatement.setString(3, usuario.getUsuario());
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
