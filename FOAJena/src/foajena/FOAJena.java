/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foajena;

import org.apache.jena.atlas.logging.LogCtl;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;
import org.apache.jena.vocabulary.VCARD;

/**
 *
 * @author Laura
 */
public class FOAJena {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LogCtl.setCmdLogging(); //avoid loging warnings

        String filePath;
        if(args.length > 1)
            filePath = args[1];
        else
            filePath = "people.xml";
        
        Model model = ModelFactory.createDefaultModel();
        model.read(filePath);
        
        //model.write(System.out); //Write in XML format
        /* Tarea 2 */
        System.out.println("-----------------------------");
        System.out.println("||         TURTLE          ||");
        System.out.println("-----------------------------");
        RDFDataMgr.write(System.out, model, RDFFormat.TURTLE_PRETTY);
        
        
        
        System.out.println("-----------------------------");
        System.out.println("||        NTRIPLES         ||");
        System.out.println("-----------------------------");
        RDFDataMgr.write(System.out, model, RDFFormat.NTRIPLES);
        
        /* Tarea 3 */
        
    }
    
}
