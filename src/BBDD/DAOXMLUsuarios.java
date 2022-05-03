package BBDD;

import java.io.File;
import java.io.IOException;

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
		//fichero xml
		try {
			file = new File("BaseDatos/usuarios.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			dBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {

		}
	}

	// devuelve false si no encuentra el usuario y devuelve si lo encuentra el
	// usuario 
	//funcion para buscar usuarios en la bbdd
	public DTOUsuarios cargarUsuario(String nombre, String pass) {

		DTOUsuarios user = null;
		try {
			boolean encontrado = false;
			//crea documento con el archivo xml y coge la lista de usuarios
			Document doc = dBuilder.parse(file);
			Element raiz = doc.getDocumentElement();
			NodeList nList = raiz.getChildNodes(); // lista usuarios
			int j = 0;
			
			//recorre la lista de usuarios hasra que encuentre el usuario o se terminen los usuarios
			while (j < nList.getLength() && !encontrado) {
				Node nodo = nList.item(j); // producto
				Element us = (Element) nodo;
				encontrado = us.getElementsByTagName("nombre").item(0).getTextContent().equals(nombre)
						&& us.getElementsByTagName("contrasena").item(0).getTextContent().equals(pass);
				j++;
			}
			
			//si se encuentra el usaurio se crea el DTOUsuarios con la informacion correspondiente
			if (encontrado) {
				j--;
				Node nodo = nList.item(j); // producto
				Element us = (Element) nodo;
				if (us.getNodeName().equals("vendedor")) {
					user = new DTOUsuarios(us.getElementsByTagName("nombre").item(0).getTextContent(),
							us.getElementsByTagName("contrasena").item(0).getTextContent(), true,
							us.getAttribute("mail"));

				} else {
					user = new DTOUsuarios(us.getElementsByTagName("nombre").item(0).getTextContent(),
							us.getElementsByTagName("contrasena").item(0).getTextContent(), false,
							us.getAttribute("mail"));
				}
			}
		} catch (IOException i) {
		} catch (SAXException e) {
		}

		return user;
	}

	//funcion para guardar los usuarios en la bbdd
	public void guardarUsuarios(DTOUsuarios user) {
		try {
			//crea documento a partir del archivo xml
			Document doc = dBuilder.parse(file);
			Element raiz = doc.getDocumentElement();
			Element u = null;

			//crea nuevos elementos en el documento  diferenciando entre vendedor y cliente
			if (user.isDueno()) {
				u = doc.createElement("vendedor");
				Element nom = doc.createElement("nombre");
				nom.setTextContent(user.getUsuario());
				u.appendChild(nom);

				Element pass = doc.createElement("contrasena");
				pass.setTextContent(user.getContrasena());
				u.appendChild(pass);

				u.setAttribute("mail", user.getCorreo());
			} else {
				u = doc.createElement("cliente");
				Element nomb = doc.createElement("nombre");
				nomb.setTextContent(user.getUsuario());
				u.appendChild(nomb);

				Element pass = doc.createElement("contrasena");
				pass.setTextContent(user.getContrasena());
				u.appendChild(pass);

				u.setAttribute("mail", user.getCorreo());
			}

			raiz.appendChild(u);
			
			//Guardamos el documento creado en el archivo xml
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

}
