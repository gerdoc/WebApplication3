/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.helper;

import java.io.Serializable;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.gerdoc.dao.Rol;
import org.gerdoc.dao.RolUsuario;
import org.gerdoc.dao.Usuario;
import org.gerdoc.service.RolUsuarioService;


/**
 *
 * @author gerdoc
 */
public class RolUsuarioHelper implements Serializable
{
    private List<RolUsuario>list;
    private RolUsuario rolUsuario;

    public RolUsuarioHelper() 
    {
    }
    
    public boolean loadList( )
    {
        list = new RolUsuarioService().getRolUsuarioList();
        return list != null && list.size() > 0;
    }
    
    public boolean addRolUsuario( HttpServletRequest request )
    {
        rolUsuario = new RolUsuario( new Rol( ) , new Usuario( ) ); 
        rolUsuario.getUsuario().setUsuario(request.getParameter( "usuario" ) );
        if( rolUsuario.getUsuario().getUsuario() == null || rolUsuario.getUsuario().getUsuario().length() == 0 )
        {
            return false;
        }
        rolUsuario.getRol().setRol(request.getParameter( "rol" ) );
        if( rolUsuario.getRol().getRol() == null || rolUsuario.getRol().getRol().length() == 0 )
        {
            return false;
        }
        return new RolUsuarioService().addRolUsuario(rolUsuario);
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

    public List<RolUsuario> getList()
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

    public void setList(List<RolUsuario> list) 
    {
        this.list = list;
    }

    public RolUsuario getRolUsuario() 
    {
        return rolUsuario;
    }

    public void setRolUsuario(RolUsuario rolUsuario) 
    {
        this.rolUsuario = rolUsuario;
    }
    
}
