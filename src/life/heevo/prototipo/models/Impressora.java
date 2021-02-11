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


public class Impressora implements Printable{
	private String conteudo;
	public Impressora(String Pres) {
		this.conteudo = Pres;
	}
	
	 public int print(Graphics g, PageFormat pf, int page) throws
    PrinterException {
		 Font f = new Font("Dialog", Font.PLAIN, 12);
		 g.setFont(f);
		 if (page > 0) { /* Por enquanto, imprime apenas uma pagina */
			 return NO_SUCH_PAGE;
		 }
		 /* User (0,0) is typically outside the imageable area, so we must
		  * translate by the X and Y values in the PageFormat to avoid clipping
		  */
		 Graphics2D g2d = (Graphics2D)g;
		 g2d.translate(pf.getImageableX(), pf.getImageableY());
		 /* Now we perform our rendering */
		 int y=100;//define as coordenadas iniciais da impressão
		 
		 String[] texto = conteudo.split("\n"); //o draw string não entende tabulação e pular linha
		 for (String i:texto) {
			 y += g.getFontMetrics().getHeight();//pulando linha
			 int x=100; //recisamos redefinir a coordenada x cada vez que pulamos linha
		 for (String line : i.split("\t"))
		        g.drawString(line, x += (80-line.length()), y);
		 }
		 /* tell the caller that this page is part of the printed document */
		 return PAGE_EXISTS;
	 }
}

