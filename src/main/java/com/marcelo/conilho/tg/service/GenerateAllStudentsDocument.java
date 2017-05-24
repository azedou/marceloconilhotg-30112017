package com.marcelo.conilho.tg.service;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by marce on 21/04/2017.
 */

public class GenerateAllStudentsDocument {

    public void replaceName(String name) throws Exception {
        XWPFDocument doc = new XWPFDocument(OPCPackage.open("C:\\Users\\marce\\Desktop\\TG2\\tg2repo\\src\\main\\resources\\Apresentacao-Alunos-TG-I.docx"));
        for (XWPFParagraph p : doc.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    if (text != null && text.contains("[NOME_ALUNO]")) {
                        text = text.replace("[NOME_ALUNO]", name);
                        r.setText(text, 0);
                    }
                }
            }
        }
        File docx = new File("C:\\Users\\marce\\Desktop\\TG2\\tg2repo\\src\\main\\resources\\testMenor.docx");
        saveAsPDF(docx);


    }

    public void saveAsPDF(File docx) throws IOException, InvalidFormatException {
        File pdf = new File("C:\\Users\\marce\\Desktop\\TG2\\tg2repo\\src\\main\\resources\\output2.pdf");
        XWPFDocument docToConvert = new XWPFDocument(OPCPackage.openOrCreate(docx));
        FileOutputStream fos = new FileOutputStream(pdf);
        PdfConverter.getInstance().convert(docToConvert, fos , PdfOptions.create());
        fos.close();

    }
}
