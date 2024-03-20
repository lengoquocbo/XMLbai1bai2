import java.io.File;
import java.io.FileWriter;
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

public class StudentListToXML {
    public static void main(String[] args) {
        try {
            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Students");
            doc.appendChild(rootElement);

            
            Element student1 = doc.createElement("Student");
            student1.setAttribute("id", "1");
            rootElement.appendChild(student1);

            Element name1 = doc.createElement("Name");
            name1.appendChild(doc.createTextNode("John Doe"));
            student1.appendChild(name1);

            Element age1 = doc.createElement("Age");
            age1.appendChild(doc.createTextNode("20"));
            student1.appendChild(age1);

            Element gpa1 = doc.createElement("GPA");
            gpa1.appendChild(doc.createTextNode("3.5"));
            student1.appendChild(gpa1);

           
            Element student2 = doc.createElement("Student");
            student2.setAttribute("id", "2");
            rootElement.appendChild(student2);

            Element name2 = doc.createElement("Name");
            name2.appendChild(doc.createTextNode("Jane Smith"));
            student2.appendChild(name2);

            Element age2 = doc.createElement("Age");
            age2.appendChild(doc.createTextNode("22"));
            student2.appendChild(age2);

            Element gpa2 = doc.createElement("GPA");
            gpa2.appendChild(doc.createTextNode("3.8"));
            student2.appendChild(gpa2);

            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            
            StreamResult result = new StreamResult(new File("student_list.xml"));
            transformer.transform(source, result);

            System.out.println("Danh sách sinh viên đã được xuất thành công vào file XML.");
        } catch (ParserConfigurationException | TransformerException ex) {
            ex.printStackTrace();
        }
    }
}