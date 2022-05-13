/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.helper;

import java.io.Serializable;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.gerdoc.dao.Dos;
import org.gerdoc.service.DosService;


/**
 *
 * @author gerdoc
 */
public class DosHelper implements Serializable
{
    private List<Dos>list;
    private Dos dos;

    public DosHelper() 
    {
    }
    
    public boolean loadList( )
    {
        list = new DosService().getDosList();
        return list != null && list.size() > 0;
    }
    
    public boolean addDos( HttpServletRequest request )
    {
        dos = new Dos( ); 
        dos.setCampo1( getInteger( request.getParameter( "campo1" )) );
        if( dos.getCampo1() == null )
        {
            return false;
        }
        dos.setCampo2( request.getParameter( "campo2" ) );
        if( dos.getCampo2() == null || dos.getCampo2().length() == 0 )
        {
            return false;
        }
        return new DosService().addDos(dos);
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

    public List<Dos> getList()
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

    public void setList(List<Dos> list) 
    {
        this.list = list;
    }

    public Dos getDos() 
    {
        return dos;
    }

    public void setDos(Dos dos) 
    {
        this.dos = dos;
    }
    
}
