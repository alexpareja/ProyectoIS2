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

public class DAOXMLInventario{

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
	

	public void guardarInventario(ArrayList<DTOInventario> inv) {
		  Document doc = dBuilder.newDocument();
	      Element raiz = doc.createElement("inventario");
	      doc.appendChild(raiz);
	     
	     // ArrayList<Producto> array=inv.getInventario();
	      for(int i=0;i<inv.size();i++) {
	    	  Element e=null;
	    	  switch(inv.get(i).getId()) {
	    	  
	    	  case "CamLocal":
	    		  
	    		   	 e= doc.createElement("camiseta");
	    			 
	    			 Element nom=doc.createElement("nombre");
	    			 nom.setTextContent(inv.get(i).getNombre());
	    			 e.appendChild(nom);
	    			 
	    			 e.setAttribute("id", inv.get(i).getId());
	    			 
	    			 Element dor=doc.createElement("dorsal");
	    			 dor.setTextContent(String.valueOf(inv.get(i).getDorsal()));
	    			 e.appendChild(dor);
	    			 
	    			 Element tal=doc.createElement("talla");
	    			 tal.setTextContent(inv.get(i).getTalla());
	    			 e.appendChild(tal);
	    			 
	    			 Element prec=doc.createElement("precio");
	    			 prec.setTextContent(String.valueOf(inv.get(i).getPrecio()));
	    			 e.appendChild(prec);
	    			 
	    			 Element pub=doc.createElement("publicado");
	    			 String act;
	    			 if(inv.get(i).isActivo()) {act="1";}
	    			 else {act="0";}
	    			 pub.setTextContent(act);
	    			 e.appendChild(pub);
	    			 
	    			 Element sto=doc.createElement("stock");
	    			 sto.setTextContent(String.valueOf(inv.get(i).getStock()));
	    			 e.appendChild(sto);
	    			 
	    			 Element udsVen=doc.createElement("udsVendidas");
	    			 udsVen.setTextContent(String.valueOf(inv.get(i).getUdsvendidas()));
	    			 e.appendChild(udsVen);
	    			 
	    			 Element udsRes=doc.createElement("udsReservadas");
	    			 udsRes.setTextContent(String.valueOf(inv.get(i).getReservados()));
	    			 e.appendChild(udsRes);
	    		  
	    			 
	    		 break;
	    		  
	    	  case "CamVisitante":
	    		  
	    		  	 e= doc.createElement("camiseta");
	    		   	 e.setAttribute("id", inv.get(i).getId());
	    			 nom=doc.createElement("nombre");
	    			 nom.setTextContent(inv.get(i).getNombre());
	    			 e.appendChild(nom);
	    			 
	    			 dor=doc.createElement("dorsal");
	    			 dor.setTextContent(String.valueOf(inv.get(i).getDorsal()));
	    			 e.appendChild(dor);
	    			 
	    			 tal=doc.createElement("talla");
	    			 tal.setTextContent(inv.get(i).getTalla());
	    			 e.appendChild(tal);
	    			 
	    			 prec=doc.createElement("precio");
	    			 prec.setTextContent(String.valueOf(inv.get(i).getPrecio()));
	    			 e.appendChild(prec);
	    			 
	    			 pub=doc.createElement("publicado");
	    			 
	    			 if(inv.get(i).isActivo()) {act="1";}
	    			 else {act="0";}
	    			 pub.setTextContent(act);
	    			 e.appendChild(pub);
	    			 
	    			 sto=doc.createElement("stock");
	    			 sto.setTextContent(String.valueOf(inv.get(i).getStock()));
	    			 e.appendChild(sto);
	    			 
	    			 udsVen=doc.createElement("udsVendidas");
	    			 udsVen.setTextContent(String.valueOf(inv.get(i).getUdsvendidas()));
	    			 e.appendChild(udsVen);
	    			 
	    			 udsRes=doc.createElement("udsReservadas");
	    			 udsRes.setTextContent(String.valueOf(inv.get(i).getReservados()));
	    			 e.appendChild(udsRes);
	    		  
	    		 break;
	    	  
	    	  case "ConVisitante":
	    		  
	    		  	 e= doc.createElement("conjunto");
	    		   	 e.setAttribute("id", inv.get(i).getId());
	    			 nom=doc.createElement("nombre");
	    			 nom.setTextContent(inv.get(i).getNombre());
	    			 e.appendChild(nom);
	    			 
	    			 dor=doc.createElement("dorsal");
	    			 dor.setTextContent(String.valueOf(inv.get(i).getDorsal()));
	    			 e.appendChild(dor);
	    			 
	    			 tal=doc.createElement("talla");
	    			 tal.setTextContent(inv.get(i).getTalla());
	    			 e.appendChild(tal);
	    			 
	    			 prec=doc.createElement("precio");
	    			 prec.setTextContent(String.valueOf(inv.get(i).getPrecio()));
	    			 e.appendChild(prec);
	    			 
	    			 pub=doc.createElement("publicado");
	    			 
	    			 if(inv.get(i).isActivo()) {act="1";}
	    			 else {act="0";}
	    			 pub.setTextContent(act);
	    			 e.appendChild(pub);
	    			 
	    			 sto=doc.createElement("stock");
	    			 sto.setTextContent(String.valueOf(inv.get(i).getStock()));
	    			 e.appendChild(sto);
	    			 
	    			 udsVen=doc.createElement("udsVendidas");
	    			 udsVen.setTextContent(String.valueOf(inv.get(i).getUdsvendidas()));
	    			 e.appendChild(udsVen);
	    			 
	    			 udsRes=doc.createElement("udsReservadas");
	    			 udsRes.setTextContent(String.valueOf(inv.get(i).getReservados()));
	    			 e.appendChild(udsRes);
	    		  
	    		 break;
	    	  
	    	  case "ConLocal":
	    		  
	    		  	 e= doc.createElement("conjunto");
	    		   	 e.setAttribute("id", inv.get(i).getId());
	    			 nom=doc.createElement("nombre");
	    			 nom.setTextContent(inv.get(i).getNombre());
	    			 e.appendChild(nom);
	    			 
	    			 dor=doc.createElement("dorsal");
	    			 dor.setTextContent(String.valueOf(inv.get(i).getDorsal()));
	    			 e.appendChild(dor);
	    			 
	    			 tal=doc.createElement("talla");
	    			 tal.setTextContent(inv.get(i).getTalla());
	    			 e.appendChild(tal);
	    			 
	    			 prec=doc.createElement("precio");
	    			 prec.setTextContent(String.valueOf(inv.get(i).getPrecio()));
	    			 e.appendChild(prec);
	    			 
	    			 pub=doc.createElement("publicado");
	    			 
	    			 if(inv.get(i).isActivo()) {act="1";}
	    			 else {act="0";}
	    			 pub.setTextContent(act);
	    			 e.appendChild(pub);
	    			 
	    			 sto=doc.createElement("stock");
	    			 sto.setTextContent(String.valueOf(inv.get(i).getStock()));
	    			 e.appendChild(sto);
	    			 
	    			 udsVen=doc.createElement("udsVendidas");
	    			 udsVen.setTextContent(String.valueOf(inv.get(i).getUdsvendidas()));
	    			 e.appendChild(udsVen);
	    			 
	    			 udsRes=doc.createElement("udsReservadas");
	    			 udsRes.setTextContent(String.valueOf(inv.get(i).getReservados()));
	    			 e.appendChild(udsRes);
	    		  
	    		 break;
	    	  
	    	  case "PantChandal":
	    		  
	    		  	 e= doc.createElement("pantalon");
	    		   	 e.setAttribute("id", inv.get(i).getId());
	    			 
	    			 dor=doc.createElement("dorsal");
	    			 dor.setTextContent(String.valueOf(inv.get(i).getDorsal()));
	    			 e.appendChild(dor);
	    			 
	    			 tal=doc.createElement("talla");
	    			 tal.setTextContent(inv.get(i).getTalla());
	    			 e.appendChild(tal);
	    			 
	    			 prec=doc.createElement("precio");
	    			 prec.setTextContent(String.valueOf(inv.get(i).getPrecio()));
	    			 e.appendChild(prec);
	    			 
	    			 pub=doc.createElement("publicado");
	    			 
	    			 if(inv.get(i).isActivo()) {act="1";}
	    			 else {act="0";}
	    			 pub.setTextContent(act);
	    			 e.appendChild(pub);
	    			 
	    			 sto=doc.createElement("stock");
	    			 sto.setTextContent(String.valueOf(inv.get(i).getStock()));
	    			 e.appendChild(sto);
	    			 
	    			 udsVen=doc.createElement("udsVendidas");
	    			 udsVen.setTextContent(String.valueOf(inv.get(i).getUdsvendidas()));
	    			 e.appendChild(udsVen);
	    			 
	    			 udsRes=doc.createElement("udsReservadas");
	    			 udsRes.setTextContent(String.valueOf(inv.get(i).getReservados()));
	    			 e.appendChild(udsRes);
	    		  
	    		 break;
	    		 
	    	  case "PantCorto":
	    		  
	    		  	 e= doc.createElement("pantalon");
	    		   	 e.setAttribute("id",inv.get(i).getId());
	    			 
	    			 dor=doc.createElement("dorsal");
	    			 dor.setTextContent(String.valueOf(inv.get(i).getDorsal()));
	    			 e.appendChild(dor);
	    			 
	    			 tal=doc.createElement("talla");
	    			 tal.setTextContent(inv.get(i).getTalla());
	    			 e.appendChild(tal);
	    			 
	    			 prec=doc.createElement("precio");
	    			 prec.setTextContent(String.valueOf(inv.get(i).getPrecio()));
	    			 e.appendChild(prec);
	    			 
	    			 pub=doc.createElement("publicado");
	    			 
	    			 if(inv.get(i).isActivo()) {act="1";}
	    			 else {act="0";}
	    			 pub.setTextContent(act);
	    			 e.appendChild(pub);
	    			 
	    			 sto=doc.createElement("stock");
	    			 sto.setTextContent(String.valueOf(inv.get(i).getStock()));
	    			 e.appendChild(sto);
	    			 
	    			 udsVen=doc.createElement("udsVendidas");
	    			 udsVen.setTextContent(String.valueOf(inv.get(i).getUdsvendidas()));
	    			 e.appendChild(udsVen);
	    			 
	    			 udsRes=doc.createElement("udsReservadas");
	    			 udsRes.setTextContent(String.valueOf(inv.get(i).getReservados()));
	    			 e.appendChild(udsRes);
	    		  
	    		 break;
	    		 
	    	  case "Botas":
	    		  
	    		  	 e= doc.createElement("botas");
	    		   	 e.setAttribute("id", inv.get(i).getId());
	    		   			 
	    			 tal=doc.createElement("talla");
	    			 tal.setTextContent(String.valueOf(inv.get(i).getTallaZ()));
	    			 e.appendChild(tal);
	    			 
	    			 Element mod=doc.createElement("modelo");
	    			 mod.setTextContent(inv.get(i).getModelo());
	    			 e.appendChild(mod);
	    			 
	    			 Element mar=doc.createElement("marca");
	    			 mar.setTextContent(inv.get(i).getMarca());
	    			 e.appendChild(mar);
	    			 
	    			 Element col=doc.createElement("color");
	    			 col.setTextContent(inv.get(i).getColor());
	    			 e.appendChild(col);
	    			 
	    			 prec=doc.createElement("precio");
	    			 prec.setTextContent(String.valueOf(inv.get(i).getPrecio()));
	    			 e.appendChild(prec);
	    			 
	    			 pub=doc.createElement("publicado");
	    			 
	    			 if(inv.get(i).isActivo()) {act="1";}
	    			 else {act="0";}
	    			 pub.setTextContent(act);
	    			 e.appendChild(pub);
	    			 
	    			 sto=doc.createElement("stock");
	    			 sto.setTextContent(String.valueOf(inv.get(i).getStock()));
	    			 e.appendChild(sto);
	    			 
	    			 udsVen=doc.createElement("udsVendidas");
	    			 udsVen.setTextContent(String.valueOf(inv.get(i).getUdsvendidas()));
	    			 e.appendChild(udsVen);
	    			 
	    			 udsRes=doc.createElement("udsReservadas");
	    			 udsRes.setTextContent(String.valueOf(inv.get(i).getReservados()));
	    			 e.appendChild(udsRes);
	    		  
	    		 break;
	    		 
	    	   default:
	    		  
	    		  	 e= doc.createElement("guantes");
	    		   	 e.setAttribute("id", inv.get(i).getId());
	    		   			 
	    		   	 tal=doc.createElement("talla");
	    			 tal.setTextContent(inv.get(i).getTalla());
	    			 e.appendChild(tal);
	    			 
	    			 mod=doc.createElement("modelo");
	    			 mod.setTextContent(inv.get(i).getModelo());
	    			 e.appendChild(mod);
	    			 
	    			 mar=doc.createElement("marca");
	    			 mar.setTextContent(inv.get(i).getMarca());
	    			 e.appendChild(mar);
	    			 
	    			 col=doc.createElement("color");
	    			 col.setTextContent(inv.get(i).getColor());
	    			 e.appendChild(col);
	    			 
	    			 Element adh=doc.createElement("adherencia");
	    			 adh.setTextContent(String.valueOf(inv.get(i).getAdherencia()));
	    			 e.appendChild(adh);
	    			 
	    			 prec=doc.createElement("precio");
	    			 prec.setTextContent(String.valueOf(inv.get(i).getPrecio()));
	    			 e.appendChild(prec);
	    			 
	    			 pub=doc.createElement("publicado");
	    			 
	    			 if(inv.get(i).isActivo()) {act="1";}
	    			 else {act="0";}
	    			 pub.setTextContent(act);
	    			 e.appendChild(pub);
	    			 
	    			 sto=doc.createElement("stock");
	    			 sto.setTextContent(String.valueOf(inv.get(i).getStock()));
	    			 e.appendChild(sto);
	    			 
	    			 udsVen=doc.createElement("udsVendidas");
	    			 udsVen.setTextContent(String.valueOf(inv.get(i).getUdsvendidas()));
	    			 e.appendChild(udsVen);
	    			 
	    			 udsRes=doc.createElement("udsReservadas");
	    			 udsRes.setTextContent(String.valueOf(inv.get(i).getReservados()));
	    			 e.appendChild(udsRes);
	    		  
	    		 break;
	    	  }
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


	public ArrayList<DTOInventario> cargarInventario() {
		
		ArrayList<DTOInventario> a=new ArrayList<DTOInventario>();
		try {
			
		 	Document doc = dBuilder.parse(file);
		 	Element raiz= doc.getDocumentElement();
	        NodeList nList = raiz.getChildNodes();//lista productos
	       
	        for (int i = 0; i < nList.getLength(); i++) {
	        	
	            Node nodo= nList.item(i);//producto
	            Element e=(Element) nodo;
	            DTOInventario p=null;
	          
	         
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
	            	p=new DTOInventario(e.getAttribute("id"),precio,publicado,stock,udsVendidas,reservados,talla,n,dorsal);
	            	a.add(p);
	            	
	            	
	            break;
	            
	            case "pantalon":
	            	
	            	int dorsalPantalon=Integer.valueOf(e.getElementsByTagName("dorsal").item(0).getTextContent());
	            	String tallaPant=e.getElementsByTagName("talla").item(0).getTextContent();
	            	p=new DTOInventario(e.getAttribute("id"),precio,publicado,stock,udsVendidas,reservados,tallaPant,dorsalPantalon);
	            	a.add(p);
	            	
	            break;
	            	case "botas":
	            		
	            		int tallaBotas=Integer.valueOf(e.getElementsByTagName("talla").item(0).getTextContent()); 
	            		String modelo=e.getElementsByTagName("modelo").item(0).getTextContent();
	            		String marca=e.getElementsByTagName("marca").item(0).getTextContent();
	            		String color=e.getElementsByTagName("color").item(0).getTextContent();
	            		p=new DTOInventario(e.getAttribute("id"),precio,publicado,stock,udsVendidas,reservados,tallaBotas,modelo,marca,color);
	            		a.add(p);
	            	
	            break;
	            
	            	case "conjunto":
		            	
		            	String tallaConjunto=e.getElementsByTagName("talla").item(0).getTextContent();
		            	int dorsalConjunto=Integer.valueOf(e.getElementsByTagName("dorsal").item(0).getTextContent());
		            	String nConjunto=e.getElementsByTagName("nombre").item(0).getTextContent();
		            	p=new DTOInventario(e.getAttribute("id"),precio,publicado,stock,udsVendidas,reservados,tallaConjunto,nConjunto,dorsalConjunto);
		            	a.add(p);
		            	
		            break;
	            
	            	case "guantes":
	            		
	            		String tallaGuantes=e.getElementsByTagName("talla").item(0).getTextContent();
	            		String modeloG=e.getElementsByTagName("modelo").item(0).getTextContent();
	            		String marcaG=e.getElementsByTagName("marca").item(0).getTextContent();
	            		String colorG=e.getElementsByTagName("color").item(0).getTextContent();
	            		int adherencia=Integer.valueOf(e.getElementsByTagName("adherencia").item(0).getTextContent());
	            		p=new DTOInventario(e.getAttribute("id"),precio,publicado,stock,udsVendidas,reservados,tallaGuantes,modeloG,marcaG,colorG,adherencia);
	            		a.add(p);
	            	
	            break;
	        	} 
	        }
		}
	    catch(IOException i) { 
	    	
	    }
		catch(SAXException e) { 
	    	
	    }
		
		return a;
	}

}