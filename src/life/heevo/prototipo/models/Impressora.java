package life.heevo.prototipo.models;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.UIManager;

/**
 * Representa uma impressão para prescrições
 * 
 * @author hl
 *
 */
public class Impressora implements Printable{
	
	
	private String conteudo;
	
	
	public Impressora(String conteudo) {
		this.conteudo = conteudo;
	}
	
	 public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}


/**
 * Construtor para o objeto Impressora
 * 
 * @param graphics
 * @param pageFormat comes from the PageFormat class which describes the page orientation, its size and imageable area(margin limits).
 * @param page is the zero-based page number that will be rendered.
 * 
 * 
 * @author hl
 *
 */
	public int print(Graphics graphics, PageFormat pageFormat, int page) throws PrinterException {
		 Font f = new Font("Dialog", Font.PLAIN, 12);
		 graphics.setFont(f);
		 if (page > 0) { /* Por enquanto, imprime apenas uma pagina */
			 return NO_SUCH_PAGE;
		 }
		 /* User (0,0) is typically outside the imageable area, so we must
		  * translate by the X and Y values in the PageFormat to avoid clipping
		  */
		 Graphics2D g2d = (Graphics2D)graphics;
		 g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		 /* Now we perform our rendering */
		 int y=100;//define as coordenadas iniciais da impressão
		 
		 String[] texto = conteudo.split("\n"); //o draw string não entende tabulação e pular linha
		 for (String i:texto) {
			 y += graphics.getFontMetrics().getHeight();//pulando linha
			 int x=100; //precisamos redefinir a coordenada x cada vez que pulamos linha
		 for (String line : i.split("\t"))
		        graphics.drawString(line, x += (80-line.length()), y);
		 }
		 /* tell the caller that this page is part of the printed document */
		 return PAGE_EXISTS;
	 }
}

