import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.upcloo.client.model.indexer.Doc;

import junit.framework.TestCase;


public class IndexerXMLGenTest extends TestCase {
	public void testDocBase() throws JAXBException, ParserConfigurationException, SAXException, IOException, XPathExpressionException
	{
		Doc d = new Doc();
		d.setId("ciao");
		d.setPassword("password");
		d.setSitekey("sitekey");
		d.setTitle("Example");
		
		String xml = d.asXml();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true); // never forget this!
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new ByteArrayInputStream(xml.getBytes()));
		
		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression expr = xpath.compile("/model/title");
				
		NodeList result = (NodeList)expr.evaluate(document, XPathConstants.NODESET);
		String title = result.item(0).getChildNodes().item(0).getNodeValue();
		
		assertEquals("Example", title);
	}
	
	public void testDocDates() throws DatatypeConfigurationException, JAXBException, ParserConfigurationException, SAXException, IOException, XPathExpressionException
	{
		Doc d = new Doc();
		d.setId("ciao");
		d.setPassword("password");
		d.setSitekey("sitekey");
		
		Date date = new Date();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(date.getTime());
		XMLGregorianCalendar publishDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		
		d.setPublishDate(publishDate);
		
		String xml = d.asXml();
		
		String createdPublishDate = publishDate.toXMLFormat();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true); // never forget this!
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new ByteArrayInputStream(xml.getBytes()));
		
		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression expr = xpath.compile("/model/publish_date");
				
		NodeList result = (NodeList)expr.evaluate(document, XPathConstants.NODESET);
		String pd = result.item(0).getChildNodes().item(0).getNodeValue();
		
		assertEquals(createdPublishDate, pd);
	}
}
