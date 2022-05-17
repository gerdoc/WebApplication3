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
import org.gerdoc.service.RolService;


/**
 *
 * @author gerdoc
 */
public class RolHelper implements Serializable
{
    private List<Rol>list;
    private Rol rol;

    public RolHelper() 
    {
    }
    
    public boolean loadList( )
    {
        list = new RolService().getRolList();
        return list != null && list.size() > 0;
    }
    
    public boolean addRol( HttpServletRequest request )
    {
        rol = new Rol( ); 
        rol.setRol( request.getParameter( "rol" ) );
        if( rol.getRol() == null || rol.getRol().length() == 0 )
        {
            return false;
        }
        rol.setDescripcion( request.getParameter( "descripcion" ) );
        if( rol.getDescripcion() == null || rol.getDescripcion().length() == 0 )
        {
            return false;
        }
        return new RolService().addRol(rol);
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

    public List<Rol> getList()
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

    public void setList(List<Rol> list) 
    {
        this.list = list;
    }

    public Rol getRol() 
    {
        return rol;
    }

    public void setRol(Rol rol) 
    {
        this.rol = rol;
    }
    
}
