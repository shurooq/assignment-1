package eduparser;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Use JAXP DOM Parser to display all persons: title, names...
 * 
 * @author Huseyin OZVEREN
 */
public class TestParsingXmlWithDOM {

	public static void main(String[] args) throws Exception {

		// Create a DOM parser factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// Obtain a DOM builder
		DocumentBuilder docBuilder = factory.newDocumentBuilder();

		// XML Stream
		InputStream xmlStream = TestParsingXmlWithDOM.class.getResourceAsStream("users.xml");
		
		// Parse the given XML document 
		// in order to build a DOM tree representing the XML document
		Document doc = docBuilder.parse(xmlStream);

		// Return all the person elements as NodeList
		//NodeList personNodes = doc.getElementsByTagName("person"); 
		// Return the root element
		//Element root = doc.getDocumentElement();  

		// Get a list of all elements in the document
		// The wild card * matches all tags
		NodeList list = doc.getElementsByTagName("*");
                String[][]users=new String[list.getLength()][9];
                
		int peopleCount = 0;
		for (int i = 0; i < list.getLength(); i++) {
			
			// Get the elements person (attribute ID), title, names...
			Element element = (Element) list.item(i);
			String nodeName = element.getNodeName();
			
			if (nodeName.equals("user")) {
				peopleCount++;
				//System.out.println("user " + peopleCount);
				String personId = element.getAttribute("id");
                                 
				//System.out.println("\tID:\t" + personId);
                               
                                users[peopleCount-1][0]=personId;
			
			} else if (nodeName.equals("name")) {
				//System.out.println("\tname:\t" + element.getChildNodes().item(0).getNodeValue());
                                 users[peopleCount-1][1]=element.getChildNodes().item(0).getNodeValue();


			} else if (nodeName.equals("major")) {
				//System.out.println("\tMajor:\t" + element.getChildNodes().item(0).getNodeValue());
                                users[peopleCount-1][2]=element.getChildNodes().item(0).getNodeValue();
			
                        }
                        else if (nodeName.equals("age")) {
				//System.out.println("\tAge:\t" + element.getChildNodes().item(0).getNodeValue());
                                users[peopleCount-1][3]=element.getChildNodes().item(0).getNodeValue();
			
                        }
                        else if (nodeName.equals("height")) {
				//System.out.println("\tHeight:\t" + element.getChildNodes().item(0).getNodeValue());
                                users[peopleCount-1][4]=element.getChildNodes().item(0).getNodeValue();
			
                        }
                        else if (nodeName.equals("weight")) {
				//System.out.println("\tWeight:\t" + element.getChildNodes().item(0).getNodeValue());
                                users[peopleCount-1][5]=element.getChildNodes().item(0).getNodeValue();
			
                        }
                        
                        else if (nodeName.equals("address")) {
				//System.out.println("\tAddress:\t" + element.getChildNodes().item(0).getNodeValue());
                                users[peopleCount-1][6]=element.getChildNodes().item(0).getNodeValue();
			
                        }
                        
                        else if (nodeName.equals("location")) {
				//System.out.println("\tLocation:\t" + element.getChildNodes().item(0).getNodeValue());
                                users[peopleCount-1][7]=element.getChildNodes().item(0).getNodeValue();
			
                        }
		} // end-for
                // Create a DOM parser factory
		DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
		// Obtain a DOM builder
		DocumentBuilder docBuilder2 = factory2.newDocumentBuilder();

		// XML Stream
		InputStream xmlStream2 = TestParsingXmlWithDOM.class.getResourceAsStream("relations.xml");
		
		// Parse the given XML document 
		// in order to build a DOM tree representing the XML document
		Document doc2 = docBuilder2.parse(xmlStream2);

		// Return all the person elements as NodeList
		//NodeList personNodes = doc.getElementsByTagName("person"); 
		// Return the root element
		//Element root = doc.getDocumentElement();  

		// Get a list of all elements in the document
		// The wild card * matches all tags
		NodeList list2 = doc2.getElementsByTagName("*");
                int RelationCount = 0;
                String f1="",f2="";
                int id1=0,id2=0;
		for (int i = 0; i < list2.getLength(); i++) {
			
			// Get the elements person (attribute ID), title, names...
			Element element2 = (Element) list2.item(i);
			String nodeName = element2.getNodeName();
			
			if (nodeName.equals("relation")) {
				RelationCount++;
				//System.out.println("Relation " + RelationCount);
				
			
			} else if (nodeName.equals("friend1")) {
				//System.out.println("\tFriend1:\t" + element2.getChildNodes().item(0).getNodeValue());
				//System.out.println("\tFriend1:\t" + users[Integer.parseInt(element2.getChildNodes().item(0).getNodeValue())][1]);
                                id1=Integer.parseInt(element2.getChildNodes().item(0).getNodeValue());
                                f1=users[Integer.parseInt(element2.getChildNodes().item(0).getNodeValue())][1];
                        } else if (nodeName.equals("friend2")) {
				//System.out.println("\tFriend2:\t" + element2.getChildNodes().item(0).getNodeValue());
				//System.out.println("\tFriend1:\t" + users[Integer.parseInt(element2.getChildNodes().item(0).getNodeValue())][1]);
                                 id2=Integer.parseInt(element2.getChildNodes().item(0).getNodeValue());
                                f2=users[Integer.parseInt(element2.getChildNodes().item(0).getNodeValue())][1];
                                
                                users[id1][8]=users[id1][8]+","+f2;
                                users[id2][8]=users[id2][8]+","+f1;
                        }
                        


                        
	}
                                        for(int k=0;k<10;k++){
                                           System.out.println("user1 : ");
                                           System.out.println("ID : "+users[k][0]);
                                            System.out.println("name : "+users[k][1]);
                                           System.out.println("Major : "+users[k][2]);
                                           System.out.println("age : "+users[k][3]);
                                           System.out.println("Height : "+users[k][4]);
                                           System.out.println("Weight : "+users[k][5]);
                                           System.out.println("Address : "+users[k][6]);
                                           System.out.println("Location : "+users[k][7]);
                                           System.out.println("Friends : "+users[k][8]);
                                       System.out.println("**********************************");
                                        
                        }
	
}
}