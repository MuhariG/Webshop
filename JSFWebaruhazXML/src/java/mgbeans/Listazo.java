/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgbeans;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Cd;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Gabika
 */
@ManagedBean
@SessionScoped
public class Listazo {

    private List<Cd> cdLista;

    public Listazo() {

        SAXBuilder builder = new SAXBuilder();
        File file = new File("C:/prog/cd_catalog.xml");

        try {
            Document document = builder.build(file);
            Element root = document.getRootElement();
            cdLista = new ArrayList<>();
            List<Element> xmlCds = root.getChildren();

            for (Element e : xmlCds) {
                Cd cd = new Cd(e.getChildText("TITLE"),
                        e.getChildText("ARTIST"),
                        e.getChildText("COUNTRY"),
                        e.getChildText("COMPANY"),
                        Double.parseDouble(e.getChildText("PRICE")),
                        Integer.parseInt(e.getChildText("YEAR")));
                cdLista.add(cd);
            }

        } catch (JDOMException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    public List<Cd> getCdLista() {
        return cdLista;
    }

    public void setCdLista(List<Cd> cdLista) {
        this.cdLista = cdLista;
    }

}
