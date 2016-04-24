/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenafilmquery;

import org.apache.jena.atlas.logging.LogCtl;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFactory;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.PrintUtil;

/**
 *
 * @author Laura
 */
public class JenaFilmQuery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LogCtl.setCmdLogging();
        //Load Model
        Model model = RDFDataMgr.loadModel("/Users/lala/JenaPaleotologyQuery/JenaFilmQuery/palaeontology_articles-reducido.rdf");
        //Load Query
        Query query = QueryFactory.read("/Users/lala/JenaPaleotologyQuery/Queries/busyAuthors.rq");
        QueryExecution excecution = QueryExecutionFactory.create(query,model);
        ResultSet results = excecution.execSelect();
        results = ResultSetFactory.copyResults(results); //Keeps a copy 
        excecution.close();
        ResultSetFormatter.out(System.out,results);
    }
    
}
