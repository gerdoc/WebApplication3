/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.helper;

import java.io.Serializable;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.gerdoc.dao.Usuario;
import org.gerdoc.service.UsuarioService;


/**
 *
 * @author gerdoc
 */
public class UsuarioHelper implements Serializable
{
    private List<Usuario>list;
    private Usuario usuario;

    public UsuarioHelper() 
    {
    }
    
    public boolean loadList( )
    {
        list = new UsuarioService().getUsuarioList();
        return list != null && list.size() > 0;
    }
    
    public boolean addUsuario( HttpServletRequest request )
    {
        usuario = new Usuario( ); 
        usuario.setUsuario( request.getParameter( "usuario" ) );
        if( usuario.getUsuario() == null || usuario.getUsuario().length() == 0 )
        {
            return false;
        }
        usuario.setPassword(request.getParameter( "password" ) );
        if( usuario.getPassword() == null || usuario.getPassword().length() == 0 )
        {
            return false;
        }
        usuario.setCorreo(request.getParameter( "correo" ) );
        if( usuario.getCorreo()== null || usuario.getCorreo().length() == 0 )
        {
            return false;
        }
        return new UsuarioService().addUsuario(usuario);
    }
    
    public Integer getInteger( String campo )
    {
        Integer val = 0;
        if( campo == null || campo.length() == 0 )
        {
            return null;
        }
        try
        {
            val = new Integer(campo);
            return val;
        }
        catch(NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Usuario> getList()
    {
        if( list == null || list.size( )== 0 )
        {
            if( !loadList( ) )
            {
                return null;
            }
        }
        return list;
    }

    public void setList(List<Usuario> list) 
    {
        this.list = list;
    }

    public Usuario getUsuario() 
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario) 
    {
        this.usuario = usuario;
    }
    
}
