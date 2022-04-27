package BBDD;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DAOXMLUsuarios {
	
	private File file;
	private DocumentBuilder dBuilder;
	
	public DAOXMLUsuarios() {
		try {
		file=new File("BaseDatos/usuarios.xml");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	     dBuilder = factory.newDocumentBuilder();
		}
	    catch(ParserConfigurationException e) { 
	    	
	    }
	}
	
	//devuelve false si no encuentra el usuario y devuelve si lo encuentra el usuario y carrito 
public boolean cargarUsuario(String nombre, String pass,DTOUsuarios user, ArrayList<DTOInventario> carrito) {
		boolean encontrado=false;
		try {
			
		 	Document doc = dBuilder.parse(file);
		 	Element raiz= doc.getDocumentElement();
	        NodeList nList = raiz.getChildNodes();//lista productos
	        int j=0;
	        while (j < nList.getLength() && !encontrado) {
	        	
	            Node nodo= nList.item(j);//producto
	            Element us=(Element) nodo;
	            encontrado=us.getElementsByTagName("nombre").item(0).getTextContent().equals(nombre) &&
	            		us.getElementsByTagName("contrasena").item(0).getTextContent().equals(pass);
	            j++;
	            
	        }
	        if(encontrado)
	        {
	        	j--;
	        	Node nodo= nList.item(j);//producto
	            Element us=(Element) nodo;
	        	
	        	if(us.getNodeName().equals("cliente"))
	        	{
	        		user=new DTOUsuarios(us.getElementsByTagName("nombre").item(0).getTextContent(),
	        				us.getElementsByTagName("contrasena").item(0).getTextContent(),true,
	        				us.getAttribute("mail"));
	        	}
	        	else {
	        		user=new DTOUsuarios(us.getElementsByTagName("nombre").item(0).getTextContent(),
	        				us.getElementsByTagName("contrasena").item(0).getTextContent(),false,
	        				us.getAttribute("mail"));
	        		
	        		NodeList carr= us.getElementsByTagName("carrito");
	        		carrito=new ArrayList<DTOInventario>();
	        		for (int i = 0; i < carr.getLength(); i++) {
	    	        	
	    	            Node nod= carr.item(i);//producto
	    	            Element e=(Element) nod;
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
	    	            	carrito.add(p);
	    	            	
	    	            	
	    	            break;
	    	            
	    	            case "pantalon":
	    	            	
	    	            	int dorsalPantalon=Integer.valueOf(e.getElementsByTagName("dorsal").item(0).getTextContent());
	    	            	String tallaPant=e.getElementsByTagName("talla").item(0).getTextContent();
	    	            	p=new DTOInventario(e.getAttribute("id"),precio,publicado,stock,udsVendidas,reservados,tallaPant,dorsalPantalon);
	    	            	carrito.add(p);
	    	            	
	    	            break;
	    	            	case "botas":
	    	            		
	    	            		int tallaBotas=Integer.valueOf(e.getElementsByTagName("talla").item(0).getTextContent()); 
	    	            		String modelo=e.getElementsByTagName("modelo").item(0).getTextContent();
	    	            		String marca=e.getElementsByTagName("marca").item(0).getTextContent();
	    	            		String color=e.getElementsByTagName("color").item(0).getTextContent();
	    	            		p=new DTOInventario(e.getAttribute("id"),precio,publicado,stock,udsVendidas,reservados,tallaBotas,modelo,marca,color);
	    	            		carrito.add(p);
	    	            	
	    	            break;
	    	            
	    	            	case "conjunto":
	    		            	
	    		            	String tallaConjunto=e.getElementsByTagName("talla").item(0).getTextContent();
	    		            	int dorsalConjunto=Integer.valueOf(e.getElementsByTagName("dorsal").item(0).getTextContent());
	    		            	String nConjunto=e.getElementsByTagName("nombre").item(0).getTextContent();
	    		            	p=new DTOInventario(e.getAttribute("id"),precio,publicado,stock,udsVendidas,reservados,tallaConjunto,nConjunto,dorsalConjunto);
	    		            	carrito.add(p);
	    		            	
	    		            break;
	    	            
	    	            	case "guantes":
	    	            		
	    	            		String tallaGuantes=e.getElementsByTagName("talla").item(0).getTextContent();
	    	            		String modeloG=e.getElementsByTagName("modelo").item(0).getTextContent();
	    	            		String marcaG=e.getElementsByTagName("marca").item(0).getTextContent();
	    	            		String colorG=e.getElementsByTagName("color").item(0).getTextContent();
	    	            		int adherencia=Integer.valueOf(e.getElementsByTagName("adherencia").item(0).getTextContent());
	    	            		p=new DTOInventario(e.getAttribute("id"),precio,publicado,stock,udsVendidas,reservados,tallaGuantes,modeloG,marcaG,colorG,adherencia);
	    	            		carrito.add(p);
	    	            	
	    	            break;
	    	        	} 
	    	            
	        		}
	        	
	        	}
	        }
		}
	    catch(IOException i) { 
	    	
	    }
		catch(SAXException e) { 
	    	
	    }
		
		return encontrado;
	}
	
	
	
	public void guardarUsuario(ArrayList<DTOUsuarios> users,ArrayList<DTOInventario> carrito) {
		  Document doc = dBuilder.newDocument();
	      Element raiz = doc.createElement("usuarios");
	      doc.appendChild(raiz);
	      for(int i=0;i<users.size();i++) {
	    	  Element u=null;
	      
	    	  if(users.get(i).isDueno()) {
	    		  	 u= doc.createElement("vendedor");
	    			 Element nom=doc.createElement("nombre");
	    			 nom.setTextContent(users.get(i).getUsuario());
	    			 u.appendChild(nom);
	    		  
	    			 Element pass=doc.createElement("contrasena");
	    			 pass.setTextContent(users.get(i).getContrasena());
	    			 u.appendChild(pass);
	    		  
	    			 u.setAttribute("mail", users.get(i).getCorreo());
	    	  }
	    	  else {
	    		  
	    		  u= doc.createElement("cliente");
	    			 Element nomb=doc.createElement("nombre");
	    			 nomb.setTextContent(users.get(i).getUsuario());
	    			 u.appendChild(nomb);
	    		  
	    			 Element pass=doc.createElement("contrasena");
	    			 pass.setTextContent(users.get(i).getContrasena());
	    			 u.appendChild(pass);
	    		  
	    			 u.setAttribute("mail", users.get(i).getCorreo());
	    			 
	    			 Element carr=doc.createElement("carrito");
	    		
	    			 for(int j=0;j<carrito.size();j++) {
	    		    	  Element e=null;
	    		    	  switch(carrito.get(j).getId()) {
	    		    	  
	    		    	  case "CamLocal":
	    		    		  
	    		    		   	 e= doc.createElement("camiseta");
	    		    			 
	    		    			 Element nom=doc.createElement("nombre");
	    		    			 nom.setTextContent(carrito.get(j).getNombre());
	    		    			 e.appendChild(nom);
	    		    			 
	    		    			 e.setAttribute("id", carrito.get(j).getId());
	    		    			 
	    		    			 Element dor=doc.createElement("dorsal");
	    		    			 dor.setTextContent(String.valueOf(carrito.get(j).getDorsal()));
	    		    			 e.appendChild(dor);
	    		    			 
	    		    			 Element tal=doc.createElement("talla");
	    		    			 tal.setTextContent(carrito.get(j).getTalla());
	    		    			 e.appendChild(tal);
	    		    			 
	    		    			 Element prec=doc.createElement("precio");
	    		    			 prec.setTextContent(String.valueOf(carrito.get(j).getPrecio()));
	    		    			 e.appendChild(prec);
	    		    			 
	    		    			 Element pub=doc.createElement("publicado");
	    		    			 String act;
	    		    			 if(carrito.get(j).isActivo()) {act="1";}
	    		    			 else {act="0";}
	    		    			 pub.setTextContent(act);
	    		    			 e.appendChild(pub);
	    		    			 
	    		    			 Element sto=doc.createElement("stock");
	    		    			 sto.setTextContent(String.valueOf(carrito.get(j).getStock()));
	    		    			 e.appendChild(sto);
	    		    			 
	    		    			 Element udsVen=doc.createElement("udsVendidas");
	    		    			 udsVen.setTextContent(String.valueOf(carrito.get(j).getUdsvendidas()));
	    		    			 e.appendChild(udsVen);
	    		    			 
	    		    			 Element udsRes=doc.createElement("udsReservadas");
	    		    			 udsRes.setTextContent(String.valueOf(carrito.get(j).getReservados()));
	    		    			 e.appendChild(udsRes);
	    		    		  
	    		    			 
	    		    		 break;
	    		    		  
	    		    	  case "CamVisitante":
	    		    		  
	    		    		  	 e= doc.createElement("camiseta");
	    		    		   	 e.setAttribute("id", carrito.get(j).getId());
	    		    			 nom=doc.createElement("nombre");
	    		    			 nom.setTextContent(carrito.get(j).getNombre());
	    		    			 e.appendChild(nom);
	    		    			 
	    		    			 dor=doc.createElement("dorsal");
	    		    			 dor.setTextContent(String.valueOf(carrito.get(j).getDorsal()));
	    		    			 e.appendChild(dor);
	    		    			 
	    		    			 tal=doc.createElement("talla");
	    		    			 tal.setTextContent(carrito.get(j).getTalla());
	    		    			 e.appendChild(tal);
	    		    			 
	    		    			 prec=doc.createElement("precio");
	    		    			 prec.setTextContent(String.valueOf(carrito.get(j).getPrecio()));
	    		    			 e.appendChild(prec);
	    		    			 
	    		    			 pub=doc.createElement("publicado");
	    		    			 
	    		    			 if(carrito.get(j).isActivo()) {act="1";}
	    		    			 else {act="0";}
	    		    			 pub.setTextContent(act);
	    		    			 e.appendChild(pub);
	    		    			 
	    		    			 sto=doc.createElement("stock");
	    		    			 sto.setTextContent(String.valueOf(carrito.get(j).getStock()));
	    		    			 e.appendChild(sto);
	    		    			 
	    		    			 udsVen=doc.createElement("udsVendidas");
	    		    			 udsVen.setTextContent(String.valueOf(carrito.get(j).getUdsvendidas()));
	    		    			 e.appendChild(udsVen);
	    		    			 
	    		    			 udsRes=doc.createElement("udsReservadas");
	    		    			 udsRes.setTextContent(String.valueOf(carrito.get(j).getReservados()));
	    		    			 e.appendChild(udsRes);
	    		    		  
	    		    		 break;
	    		    	  
	    		    	  case "ConVisitante":
	    		    		  
	    		    		  	 e= doc.createElement("conjunto");
	    		    		   	 e.setAttribute("id", carrito.get(j).getId());
	    		    			 nom=doc.createElement("nombre");
	    		    			 nom.setTextContent(carrito.get(j).getNombre());
	    		    			 e.appendChild(nom);
	    		    			 
	    		    			 dor=doc.createElement("dorsal");
	    		    			 dor.setTextContent(String.valueOf(carrito.get(j).getDorsal()));
	    		    			 e.appendChild(dor);
	    		    			 
	    		    			 tal=doc.createElement("talla");
	    		    			 tal.setTextContent(carrito.get(j).getTalla());
	    		    			 e.appendChild(tal);
	    		    			 
	    		    			 prec=doc.createElement("precio");
	    		    			 prec.setTextContent(String.valueOf(carrito.get(j).getPrecio()));
	    		    			 e.appendChild(prec);
	    		    			 
	    		    			 pub=doc.createElement("publicado");
	    		    			 
	    		    			 if(carrito.get(j).isActivo()) {act="1";}
	    		    			 else {act="0";}
	    		    			 pub.setTextContent(act);
	    		    			 e.appendChild(pub);
	    		    			 
	    		    			 sto=doc.createElement("stock");
	    		    			 sto.setTextContent(String.valueOf(carrito.get(j).getStock()));
	    		    			 e.appendChild(sto);
	    		    			 
	    		    			 udsVen=doc.createElement("udsVendidas");
	    		    			 udsVen.setTextContent(String.valueOf(carrito.get(j).getUdsvendidas()));
	    		    			 e.appendChild(udsVen);
	    		    			 
	    		    			 udsRes=doc.createElement("udsReservadas");
	    		    			 udsRes.setTextContent(String.valueOf(carrito.get(j).getReservados()));
	    		    			 e.appendChild(udsRes);
	    		    		  
	    		    		 break;
	    		    	  
	    		    	  case "ConLocal":
	    		    		  
	    		    		  	 e= doc.createElement("conjunto");
	    		    		   	 e.setAttribute("id", carrito.get(j).getId());
	    		    			 nom=doc.createElement("nombre");
	    		    			 nom.setTextContent(carrito.get(j).getNombre());
	    		    			 e.appendChild(nom);
	    		    			 
	    		    			 dor=doc.createElement("dorsal");
	    		    			 dor.setTextContent(String.valueOf(carrito.get(j).getDorsal()));
	    		    			 e.appendChild(dor);
	    		    			 
	    		    			 tal=doc.createElement("talla");
	    		    			 tal.setTextContent(carrito.get(j).getTalla());
	    		    			 e.appendChild(tal);
	    		    			 
	    		    			 prec=doc.createElement("precio");
	    		    			 prec.setTextContent(String.valueOf(carrito.get(j).getPrecio()));
	    		    			 e.appendChild(prec);
	    		    			 
	    		    			 pub=doc.createElement("publicado");
	    		    			 
	    		    			 if(carrito.get(j).isActivo()) {act="1";}
	    		    			 else {act="0";}
	    		    			 pub.setTextContent(act);
	    		    			 e.appendChild(pub);
	    		    			 
	    		    			 sto=doc.createElement("stock");
	    		    			 sto.setTextContent(String.valueOf(carrito.get(j).getStock()));
	    		    			 e.appendChild(sto);
	    		    			 
	    		    			 udsVen=doc.createElement("udsVendidas");
	    		    			 udsVen.setTextContent(String.valueOf(carrito.get(j).getUdsvendidas()));
	    		    			 e.appendChild(udsVen);
	    		    			 
	    		    			 udsRes=doc.createElement("udsReservadas");
	    		    			 udsRes.setTextContent(String.valueOf(carrito.get(j).getReservados()));
	    		    			 e.appendChild(udsRes);
	    		    		  
	    		    		 break;
	    		    	  
	    		    	  case "PantChandal":
	    		    		  
	    		    		  	 e= doc.createElement("pantalon");
	    		    		   	 e.setAttribute("id", carrito.get(j).getId());
	    		    			 
	    		    			 dor=doc.createElement("dorsal");
	    		    			 dor.setTextContent(String.valueOf(carrito.get(j).getDorsal()));
	    		    			 e.appendChild(dor);
	    		    			 
	    		    			 tal=doc.createElement("talla");
	    		    			 tal.setTextContent(carrito.get(j).getTalla());
	    		    			 e.appendChild(tal);
	    		    			 
	    		    			 prec=doc.createElement("precio");
	    		    			 prec.setTextContent(String.valueOf(carrito.get(j).getPrecio()));
	    		    			 e.appendChild(prec);
	    		    			 
	    		    			 pub=doc.createElement("publicado");
	    		    			 
	    		    			 if(carrito.get(j).isActivo()) {act="1";}
	    		    			 else {act="0";}
	    		    			 pub.setTextContent(act);
	    		    			 e.appendChild(pub);
	    		    			 
	    		    			 sto=doc.createElement("stock");
	    		    			 sto.setTextContent(String.valueOf(carrito.get(j).getStock()));
	    		    			 e.appendChild(sto);
	    		    			 
	    		    			 udsVen=doc.createElement("udsVendidas");
	    		    			 udsVen.setTextContent(String.valueOf(carrito.get(j).getUdsvendidas()));
	    		    			 e.appendChild(udsVen);
	    		    			 
	    		    			 udsRes=doc.createElement("udsReservadas");
	    		    			 udsRes.setTextContent(String.valueOf(carrito.get(j).getReservados()));
	    		    			 e.appendChild(udsRes);
	    		    		  
	    		    		 break;
	    		    		 
	    		    	  case "PantCorto":
	    		    		  
	    		    		  	 e= doc.createElement("pantalon");
	    		    		   	 e.setAttribute("id",carrito.get(j).getId());
	    		    			 
	    		    			 dor=doc.createElement("dorsal");
	    		    			 dor.setTextContent(String.valueOf(carrito.get(j).getDorsal()));
	    		    			 e.appendChild(dor);
	    		    			 
	    		    			 tal=doc.createElement("talla");
	    		    			 tal.setTextContent(carrito.get(j).getTalla());
	    		    			 e.appendChild(tal);
	    		    			 
	    		    			 prec=doc.createElement("precio");
	    		    			 prec.setTextContent(String.valueOf(carrito.get(j).getPrecio()));
	    		    			 e.appendChild(prec);
	    		    			 
	    		    			 pub=doc.createElement("publicado");
	    		    			 
	    		    			 if(carrito.get(j).isActivo()) {act="1";}
	    		    			 else {act="0";}
	    		    			 pub.setTextContent(act);
	    		    			 e.appendChild(pub);
	    		    			 
	    		    			 sto=doc.createElement("stock");
	    		    			 sto.setTextContent(String.valueOf(carrito.get(j).getStock()));
	    		    			 e.appendChild(sto);
	    		    			 
	    		    			 udsVen=doc.createElement("udsVendidas");
	    		    			 udsVen.setTextContent(String.valueOf(carrito.get(j).getUdsvendidas()));
	    		    			 e.appendChild(udsVen);
	    		    			 
	    		    			 udsRes=doc.createElement("udsReservadas");
	    		    			 udsRes.setTextContent(String.valueOf(carrito.get(j).getReservados()));
	    		    			 e.appendChild(udsRes);
	    		    		  
	    		    		 break;
	    		    		 
	    		    	  case "Botas":
	    		    		  
	    		    		  	 e= doc.createElement("botas");
	    		    		   	 e.setAttribute("id", carrito.get(j).getId());
	    		    		   			 
	    		    			 tal=doc.createElement("talla");
	    		    			 tal.setTextContent(String.valueOf(carrito.get(j).getTallaZ()));
	    		    			 e.appendChild(tal);
	    		    			 
	    		    			 Element mod=doc.createElement("modelo");
	    		    			 mod.setTextContent(carrito.get(j).getModelo());
	    		    			 e.appendChild(mod);
	    		    			 
	    		    			 Element mar=doc.createElement("marca");
	    		    			 mar.setTextContent(carrito.get(j).getMarca());
	    		    			 e.appendChild(mar);
	    		    			 
	    		    			 Element col=doc.createElement("color");
	    		    			 col.setTextContent(carrito.get(j).getColor());
	    		    			 e.appendChild(col);
	    		    			 
	    		    			 prec=doc.createElement("precio");
	    		    			 prec.setTextContent(String.valueOf(carrito.get(j).getPrecio()));
	    		    			 e.appendChild(prec);
	    		    			 
	    		    			 pub=doc.createElement("publicado");
	    		    			 
	    		    			 if(carrito.get(j).isActivo()) {act="1";}
	    		    			 else {act="0";}
	    		    			 pub.setTextContent(act);
	    		    			 e.appendChild(pub);
	    		    			 
	    		    			 sto=doc.createElement("stock");
	    		    			 sto.setTextContent(String.valueOf(carrito.get(j).getStock()));
	    		    			 e.appendChild(sto);
	    		    			 
	    		    			 udsVen=doc.createElement("udsVendidas");
	    		    			 udsVen.setTextContent(String.valueOf(carrito.get(j).getUdsvendidas()));
	    		    			 e.appendChild(udsVen);
	    		    			 
	    		    			 udsRes=doc.createElement("udsReservadas");
	    		    			 udsRes.setTextContent(String.valueOf(carrito.get(j).getReservados()));
	    		    			 e.appendChild(udsRes);
	    		    		  
	    		    		 break;
	    		    		 
	    		    	   default:
	    		    		  
	    		    		  	 e= doc.createElement("guantes");
	    		    		   	 e.setAttribute("id", carrito.get(j).getId());
	    		    		   			 
	    		    		   	 tal=doc.createElement("talla");
	    		    			 tal.setTextContent(carrito.get(j).getTalla());
	    		    			 e.appendChild(tal);
	    		    			 
	    		    			 mod=doc.createElement("modelo");
	    		    			 mod.setTextContent(carrito.get(j).getModelo());
	    		    			 e.appendChild(mod);
	    		    			 
	    		    			 mar=doc.createElement("marca");
	    		    			 mar.setTextContent(carrito.get(j).getMarca());
	    		    			 e.appendChild(mar);
	    		    			 
	    		    			 col=doc.createElement("color");
	    		    			 col.setTextContent(carrito.get(j).getColor());
	    		    			 e.appendChild(col);
	    		    			 
	    		    			 Element adh=doc.createElement("adherencia");
	    		    			 adh.setTextContent(String.valueOf(carrito.get(j).getAdherencia()));
	    		    			 e.appendChild(adh);
	    		    			 
	    		    			 prec=doc.createElement("precio");
	    		    			 prec.setTextContent(String.valueOf(carrito.get(j).getPrecio()));
	    		    			 e.appendChild(prec);
	    		    			 
	    		    			 pub=doc.createElement("publicado");
	    		    			 
	    		    			 if(carrito.get(j).isActivo()) {act="1";}
	    		    			 else {act="0";}
	    		    			 pub.setTextContent(act);
	    		    			 e.appendChild(pub);
	    		    			 
	    		    			 sto=doc.createElement("stock");
	    		    			 sto.setTextContent(String.valueOf(carrito.get(j).getStock()));
	    		    			 e.appendChild(sto);
	    		    			 
	    		    			 udsVen=doc.createElement("udsVendidas");
	    		    			 udsVen.setTextContent(String.valueOf(carrito.get(j).getUdsvendidas()));
	    		    			 e.appendChild(udsVen);
	    		    			 
	    		    			 udsRes=doc.createElement("udsReservadas");
	    		    			 udsRes.setTextContent(String.valueOf(carrito.get(j).getReservados()));
	    		    			 e.appendChild(udsRes);
	    		    		  
	    		    		 break;
	    		    	  }
	    		    	  carr.appendChild(e);	    			 	    			 	    	
	    	  }
	    	u.appendChild(carr);
	      }
	    raiz.appendChild(u);
	    
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

	
	
}
