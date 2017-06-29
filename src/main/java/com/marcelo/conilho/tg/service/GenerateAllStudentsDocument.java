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

/**
 * Created by marce on 21/04/2017.
 */

public class GenerateAllStudentsDocument {
    
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
