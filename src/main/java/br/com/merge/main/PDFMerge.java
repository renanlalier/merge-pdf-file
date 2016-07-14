package br.com.merge.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.util.PDFMergerUtility;

public class PDFMerge {

	public static void main(String[] args) {

		PDFMergerUtility mergePdf = new PDFMergerUtility();
		List<InputStream> listaArquivos = new ArrayList<InputStream>();

		try {
			
			//monta lista de arquivos para merge
			listaArquivos.add(new FileInputStream("src/main/resources/arquivo01.pdf"));
			listaArquivos.add(new FileInputStream("src/main/resources/arquivo02.pdf"));
			
			//cria novo arquivo
			FileOutputStream out = new FileOutputStream(new File("src/main/resources/novoArquivo.pdf"));

			//obtem arquivos para merge
			for (InputStream arquivo : listaArquivos) {
				mergePdf.addSource(arquivo);
			}

			//atribui o merge de todos os arquivos da lista para o novo arquivo
			mergePdf.setDestinationStream(out);
			
			//realiza merge
			mergePdf.mergeDocuments();
			
			out.flush();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (COSVisitorException e) {
			e.printStackTrace();
		}

	}

}
