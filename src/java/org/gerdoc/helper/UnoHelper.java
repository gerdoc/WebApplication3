/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.helper;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.gerdoc.dao.Uno;
import org.gerdoc.service.UnoService;

/**
 *
 * @author gerdoc
 */
public class UnoHelper implements Serializable
{
    private List<Uno>list;
    private Uno uno;

    public UnoHelper() 
    {
    }
    
    public boolean loadList( )
    {
        list = new UnoService().getUnoList();
        return list != null && list.size() > 0;
    }
    
    public boolean addUno( HttpServletRequest request )
    {
        uno = new Uno( ); 
        uno.setCampo1( getInteger( request.getParameter( "campo1" )) );
        if( uno.getCampo1() == null )
        {
            return false;
        }
        uno.setCampo2( request.getParameter( "campo2" ) );
        if( uno.getCampo2() == null || uno.getCampo2().length() == 0 )
        {
            return false;
        }
        uno.setCampo3( request.getParameter( "campo3" ) );
        if( uno.getCampo3() == null || uno.getCampo3().length() == 0 )
        {
            return false;
        }
        uno.setCampo4( getDate( request.getParameter( "campo4" ) ) );
        if( uno.getCampo4() == null )
        {
            return false;
        }
        return new UnoService().addUno(uno);
    }
    
    public Date getDate( String campo )
    {
        DateFormat dateFormat = null;
        try 
        {
            if( campo == null || campo.length() == 0 )
            {
                return null;
            }
            dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
            return dateFormat.parse(campo);
        } 
        catch (ParseException ex) 
        {
            ex.printStackTrace();
        }
        return null;
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

    public List<Uno> getList()
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
    
    public boolean deleteUno( HttpServletRequest request )
    {
        uno = new Uno( ); 
        uno.setId( getInteger( request.getParameter( "id" )) );
        if( uno.getId( ) == null )
        {
            return false;
        }
        return new UnoService().deleteUno( uno );
    }
    
    public boolean updateUno( HttpServletRequest request )
    {
        uno = new Uno( ); 
        uno.setId( getInteger( request.getParameter( "id" )) );
        if( uno.getId( ) == null )
        {
            return false;
        }
        uno.setCampo1( getInteger( request.getParameter( "campo1" )) );
        if( uno.getCampo1() == null )
        {
            return false;
        }
        uno.setCampo2( request.getParameter( "campo2" ) );
        if( uno.getCampo2() == null || uno.getCampo2().length() == 0 )
        {
            return false;
        }
        uno.setCampo3( request.getParameter( "campo3" ) );
        if( uno.getCampo3() == null || uno.getCampo3().length() == 0 )
        {
            return false;
        }
        uno.setCampo4( getDate( request.getParameter( "campo4" ) ) );
        if( uno.getCampo4() == null )
        {
            return false;
        }
        return new UnoService().updateUno( uno );
    }
    
    public Uno getUnoById( HttpServletRequest request )
    {
        Uno uno = null;
        Integer id = null;
        id = getInteger( request.getParameter( "id" ) );
        if( id == null )
        {
            return null;
        }
        return new UnoService().getUnoById( id );
    }

    public void setList(List<Uno> list) 
    {
        this.list = list;
    }

    public Uno getUno() 
    {
        return uno;
    }

    public void setUno(Uno uno) 
    {
        this.uno = uno;
    }
    
}
