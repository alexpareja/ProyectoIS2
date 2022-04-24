package BBDD;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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
		file=new File("BaseDatos/inventario.xml");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	     dBuilder = factory.newDocumentBuilder();
		}
	    catch(ParserConfigurationException e) { 
	    	
	    }
	    
        
	}
	
	@Override
	public void guardarInventario(DTOInventario inv) {
		  Document doc = dBuilder.newDocument();
	      Element raiz = doc.createElement("inventario");
	      doc.appendChild(raiz);
	     
	      ArrayList<Producto> array=inv.getInventario();
	      for(int i=0;i<array.size();i++) {
	    	  
	    	  Element e=array.get(i).convierteXML(doc);
	    	  raiz.appendChild(e);
	      }
	      try {
	      TransformerFactory transformerFactory = TransformerFactory.newInstance();
	      Transformer transformer = transformerFactory.newTransformer();
	      DOMSource source = new DOMSource(doc);
	      StreamResult result = new StreamResult(file);
	      transformer.transform(source, result);
	      }
	      catch (TransformerException tfe) {
	          tfe.printStackTrace();
	      }
	  
	}

	@Override
	public DTOInventario cargarInventario() {
		
		ArrayList<Producto> a=new ArrayList<Producto>();
		try {
			
		 	Document doc = dBuilder.parse(file);
		 	Element raiz= doc.getDocumentElement();
	        NodeList nList = raiz.getChildNodes();//lista productos
	       
	        for (int i = 0; i < nList.getLength(); i++) {
	        	
	            Node nodo= nList.item(i);//producto
	            Element e=(Element) nodo;
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