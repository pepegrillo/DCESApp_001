package observatorioPrecio;

import java.util.Vector;

import pck_WS.CategoriaProductoCx;

import net.rim.device.api.collection.util.SortedReadableList;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.KeywordFilterField;
import net.rim.device.api.ui.component.KeywordProvider;
import net.rim.device.api.util.Comparator;
import net.rim.device.api.util.StringUtilities;
import configurations.ConexionController;
import estilos.Estilos;

public class CategoriaProductoSearcherDemo extends Estilos implements FieldChangeListener{
	
	KeywordFilterField _keywordFilterField;
    CountryList _countryList;
	
	int tFuente;
	Font fLite;
	int tFuente2;
	Font fTitle;
	
	Vector vLista   = new Vector();
	//Vector vColores = new Vector();
	
	Bitmap arrow;
	Bitmap bordes;
	
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	
	CategoriaProductoCx categoria = new CategoriaProductoCx();
	
	public CategoriaProductoSearcherDemo() {
		
		
		
		_countryList = new CountryList();
		for (int i = 0; i < categoria.IdCategoria.size(); i++){

			
			
	        
	        //vLista.addElement(new ListStyleButtonField(null,categoria.Categoria.elementAt(i).toString().toUpperCase() , arrow,DrawStyle.ELLIPSIS));
			_countryList.addElement(new Country(categoria.Categoria.elementAt(i).toString().toUpperCase()));
    	    
    	    
		}

		
		_keywordFilterField = new KeywordFilterField();
        _keywordFilterField.setLabel("Buscar");
        _keywordFilterField.setSourceList(_countryList, _countryList);
          
        setTitle(_keywordFilterField.getKeywordField());
        add(_keywordFilterField);    
        
        //_keywordFilterField.setChangeListener(this);
        //_keywordFilterField.setChangeListener(_countryList);
        
	}
	
	void addElementToList(Country country)
    {       
         _countryList.addElement(country);
        _keywordFilterField.updateList();
        //_keywordFilterField.setChangeListener(this);
    }
	
	//public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		
		//for(int j=0;j<=_keywordFilterField.getSize()-1;j++){
			//if( _keywordFilterField.getElementAt(j)== field ){
				//pushScreen(new MenuMain());
				//UiApplication.getUiApplication().pushScreen(new Producto(j+1));
			//}
		//}
	//}
	
	
	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		//UiApplication.getUiApplication().pushScreen(new Producto(1));
	}


}



class CountryList extends SortedReadableList implements KeywordProvider
{
    public CountryList()
    {
        super(new CountryListComparator());
    } 
   
    void addElement(Object element)
    {
        doAdd(element);        
    }    
        
    public String[] getKeywords(Object element)
    {
        if(element instanceof Country)
        {
            return StringUtilities.stringToWords(element.toString());
        }
        return null;
    }

    final static class CountryListComparator implements Comparator
    {
        public int compare(Object o1, Object o2)
        {
            if (o1 == null || o2 == null)
                throw new IllegalArgumentException("Cannot compare null countries");
            
        
            return o1.toString().compareTo(o2.toString());
        }
        
    }
    
}
 
class Country
{
    private String _countryName;
    
    public Country(String countryName)
    {
        _countryName = countryName;        
    }
    
    public String toString()
    {
        return _countryName;
    }
}
