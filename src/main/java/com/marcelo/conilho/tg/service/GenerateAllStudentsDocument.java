package com.marcelo.conilho.tg.service;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import com.marcelo.conilho.tg.model.Student;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.document.images.IImageProvider;
import fr.opensagres.xdocreport.document.images.FileImageProvider;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.test.annotations.WrapToTest;
import com.marcelo.conilho.tg.constant.ConstantsCertificadoApresentacao;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image;
import javax.imageio.ImageIO;

/**
 * Created by marce on 21/04/2017.
 */

public class GenerateAllStudentsDocument {
  
  public void createPDFwithItext(String name) throws IOException {
        ClassLoader cl = getClass().getClassLoader();
    
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter("TESTPDF.pdf");
 
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
 
        // Initialize document
        Document document = new Document(pdf);
        
        // Create a PdfFont
        PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        
        // Compose Paragraph
        System.out.println();
        Image fox = ImageIO.read(cl.getResource("logo.png"));
        Paragraph p = new Paragraph("The quick brown ")
                .add(fox);
 
        //Add paragraph to the TITLE
        document.add(new Paragraph(ConstantsCertificadoApresentacao.TITULO).setFont(font));
        
        //Add paragraph to the BODY
        document.add(new Paragraph(ConstantsCertificadoApresentacao.BEFORE_NAME+name+ConstantsCertificadoApresentacao.AFTER_NAME).setFont(font));
 
        //Close document
        document.close();
    }
    
    public void replaceNameWithVelocity(String name){
        try {
          // 1) Load Docx file by filling Velocity template engine and cache it to the registry
          ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream in = classloader.getResourceAsStream("Apresentação-Alunos-TG-I.docx");
          IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);
    
          // 2) Create context Java model
          IContext context = report.createContext();
          Student student = new Student();
          student.setName(name);
          context.put("student", student);
          
          // Create fields metadata to manage image
            FieldsMetadata logoImg = new FieldsMetadata();
            logoImg.addFieldAsImage("logo");
            report.setFieldsMetadata(logoImg);
            
            FieldsMetadata footerImg = new FieldsMetadata();
            footerImg.addFieldAsImage("footer");
            report.setFieldsMetadata(footerImg);
            
            ClassLoader cl = getClass().getClassLoader();
            IImageProvider logo = new FileImageProvider(new File(cl.getResource("logo.png").getFile()));
            IImageProvider footer = new FileImageProvider(new File(cl.getResource("footer.png").getFile()), true);
            
            context.put("logo", logo);
            context.put("footer", footer);
    
          // 3) Generate report by merging Java model with the Docx
          OutputStream out = new FileOutputStream(new File("Apresentação-Alunos-TG-I.pdf"));
          Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.XWPF);
          report.convert(context, options, out);
    
        } catch (IOException e) {
          e.printStackTrace();
        } catch (XDocReportException e) {
          e.printStackTrace();
        }
    }
}
