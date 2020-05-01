/*package com.mazars.in.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.hibernate.boot.Metadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

public class Tika {
	private static final Logger logger = LoggerFactory.getLogger(Tika.class);
	 public String getPdfDocument(File file) throws IOException, SAXException, TikaException {
	 	   BodyContentHandler handler = new BodyContentHandler();
	 	      Metadata metadata = new Metadata();
	 	    //  FileInputStream inputstream = new FileInputStream(new File("E:\\Lucene\\Data\\sample.pdf"));
	 	      FileInputStream inputstream = new FileInputStream(file);
	 	      ParseContext pcontext = new ParseContext();
	 	      
	 	      //parsing the document using PDF parser
	 	      PDFParser pdfparser = new PDFParser(); 
	 	      pdfparser.parse(inputstream, handler, metadata,pcontext);
	 	      
	 	      //getting the content of the document
//	 	      logger.info("Contents of the PDF :" + handler.toString());
//	 	      
////	 	      
//	 	      //getting metadata of the document
//	 	      logger.info("Metadata of the PDF:");
	 	      String[] metadataNames = metadata.names();
	 	      
	 	      for(String name : metadataNames) {
	 	         logger.info(name+ " : " + metadata.get(name));
	 	      }
	 	      
	 	      return handler.toString();
	    }

}
*/