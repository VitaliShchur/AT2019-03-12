package by.it.simanovich.at16;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class StAX {

    private static String tab = "";
    private static StringBuilder text=new StringBuilder();

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        String filename = "src/by/it/asimanovich/at15/sites.xml";
        Reader source = new FileReader(filename);
        XMLStreamReader reader = factory.createXMLStreamReader(source);
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    StringBuilder at = new StringBuilder();
                    int n = reader.getAttributeCount();
                    for (int i = 0; i < n; i++)
                        at
                                .append(" ")
                                .append(reader.getAttributeLocalName(i))
                                .append("=")
                                .append(reader.getAttributeValue(i));
                    System.out.println(tab + "<" + reader.getLocalName() + at + ">");
                    tab = tab.concat("\t");
                    break;
                case XMLStreamConstants.CHARACTERS:
                    text.append(reader.getText());
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    tab = tab.substring(1);
                    String out = text.toString().trim();
                    if (!out.isEmpty()) {
                        System.out.println(tab + out);
                        text.setLength(0);
                    }
                    System.out.println(tab + "</" + reader.getLocalName() + ">");
                    break;
                default:
            }
        }

    }
}
