package BBDD;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import model.Botas;
import model.CamisetaLocal;
import model.CamisetaVisitante;
import model.ConjuntoLocal;
import model.ConjuntoVisitante;
import model.Guantes;
import model.PantalonChandal;
import model.PantalonCorto;
import model.Producto;

public class DAOXMLInventario implements IDAOInventario{

	private File file;
	private DocumentBuilder dBuilder;
	
	public DAOXMLInventario() {
		try {
		file=new File("inventario.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	     dBuilder = factory.newDocumentBuilder();
		}
	    catch(ParserConfigurationException e) { 
	    	
	    }
	    
        
	}
	
	@Override
	public void guardarInventario(DTOInventario i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DTOInventario cargarInventario() {
		
		ArrayList<Producto> a=new ArrayList<Producto>();
		try {
		 	Document doc = dBuilder.parse(file);
	        doc.getDocumentElement().normalize();
	        NodeList nList = doc.getChildNodes();//lista productos
	        
	        for (int i = 0; i < nList.getLength(); i++) {
	            Element e =(Element) nList.item(i);//producto
	            Producto p=null;
	            
            	double precio=Double.parseDouble(e.getElementsByTagName("precio").item(0).getTextContent());
            	boolean publicado=false;
            	if(e.getElementsByTagName("publicado").item(0).getTextContent().equals("1")) {
            		publicado=true;
            	}
            	
            	int stock=Integer.valueOf(e.getElementsByTagName("stock").item(0).getTextContent());
            	int udsVendidas=Integer.valueOf(e.getElementsByTagName("udsVendidas").item(0).getTextContent());
            	int reservados=Integer.valueOf(e.getElementsByTagName("udsReservadas").item(0).getTextContent());
	            
	            switch(e.getNodeName()) {   
	            case "camiseta":
	            	
	            	String talla=e.getElementsByTagName("talla").item(0).getTextContent();
	            	String n=e.getElementsByTagName("nombre").item(0).getTextContent();
	            	int dorsal=Integer.valueOf(e.getElementsByTagName("dorsal").item(0).getTextContent());
	            	
	            	if(e.getAttribute("id").equals("CamLocal"))
	            	{
	            		p=new CamisetaLocal(precio,publicado,stock,udsVendidas,reservados,talla,n,dorsal);
	            		a.add(p);
	            	}
	            	else 
	            	{
	            		p=new CamisetaVisitante(precio,publicado,stock,udsVendidas,reservados,talla,n,dorsal);
	            		a.add(p);
	            	}
	            break;
	            
	            case "pantalon":
	            	
	            	int dorsalPantalon=Integer.valueOf(e.getElementsByTagName("dorsal").item(0).getTextContent());
	            	String tallaPant=e.getElementsByTagName("talla").item(0).getTextContent();
	            	if(e.getAttribute("id").equals("PantCorto"))
	            	{
	            		p=new PantalonCorto(precio,publicado,stock,udsVendidas,reservados,tallaPant,dorsalPantalon);
	            		a.add(p);
	            	}
	            	else 
	            	{
	            		p=new PantalonChandal(precio,publicado,stock,udsVendidas,reservados,tallaPant,dorsalPantalon);
	            		a.add(p);
	            	}
	            break;
	            	case "botas":
	            		
	            		int tallaBotas=Integer.valueOf(e.getElementsByTagName("talla").item(0).getTextContent()); 
	            		String modelo=e.getElementsByTagName("modelo").item(0).getTextContent();
	            		String marca=e.getElementsByTagName("marca").item(0).getTextContent();
	            		String color=e.getElementsByTagName("color").item(0).getTextContent();
	            		p=new Botas("Botas",precio,publicado,stock,udsVendidas,reservados,tallaBotas,modelo,marca,color);
	            		a.add(p);
	            	
	            break;
	            
	            	case "conjunto":
		            	
		            	String tallaConjunto=e.getElementsByTagName("talla").item(0).getTextContent();
		            	int dorsalConjunto=Integer.valueOf(e.getElementsByTagName("dorsal").item(0).getTextContent());
		            	String nConjunto=e.getElementsByTagName("nombre").item(0).getTextContent();
		            	
		            	if(e.getAttribute("id").equals("ConLocal"))
		            	{
		            		p=new ConjuntoLocal(precio,publicado,stock,udsVendidas,reservados,tallaConjunto,nConjunto,dorsalConjunto);
		            		a.add(p);
		            	}
		            	else 
		            	{
		            		p=new ConjuntoVisitante(precio,publicado,stock,udsVendidas,reservados,tallaConjunto,nConjunto,dorsalConjunto);
		            		a.add(p);
		            	}
		            break;
	            
	            	case "guantes":
	            		
	            		String tallaGuantes=e.getElementsByTagName("talla").item(0).getTextContent();
	            		String modeloG=e.getElementsByTagName("modelo").item(0).getTextContent();
	            		String marcaG=e.getElementsByTagName("marca").item(0).getTextContent();
	            		String colorG=e.getElementsByTagName("color").item(0).getTextContent();
	            		int adherencia=Integer.valueOf(e.getElementsByTagName("adherencia").item(0).getTextContent());
	            		p=new Guantes("Guantes",precio,publicado,stock,udsVendidas,reservados,tallaGuantes,modeloG,marcaG,colorG,adherencia);
	            		a.add(p);
	            	
	            break;
	        	} 
	        }
		}
	    catch(IOException i) { 
	    	
	    }
		catch(SAXException e) { 
	    	
	    }
		DTOInventario d=new DTOInventario(a);
		
		return d;
	}

}