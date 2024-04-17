package relatorio;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import models.Paciente;

/**
 *
 * @author onacio
 */
public class RelatorioCadastro {
    Paciente paciente;
    
    public RelatorioCadastro(Paciente paciente){
        this.paciente = paciente;                       
    }
    
    public void gerarCabecalho() throws DocumentException, IOException{
        
        Document documento = new Document(PageSize.A4);
        
        documento.setMargins(40f, 40f, 40f, 40f);
                
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("relatorio.pdf"));
            documento.open();
            
            // Criação do título
            Paragraph titulo = new Paragraph(new Phrase(20F, "CADASTRO", FontFactory.getFont(FontFactory.TIMES_BOLD, 16F)));
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);
            
            Paragraph linha1 = new Paragraph(" ");
            documento.add(linha1);
            
            Paragraph dadospessoais = new Paragraph("Dados pessoais");
            dadospessoais.setAlignment(Element.ALIGN_CENTER);
            documento.add(dadospessoais);
            
            Paragraph nome = new Paragraph("Nome: " + this.paciente.getNome());
            documento.add(nome);     
            
            Paragraph nomeMae = new Paragraph("Nome da mãe: " + "Rita Barbosa Nunes");
            documento.add(nomeMae);
            
            Paragraph endereco = new Paragraph("Endereço: " + "Praça Edvaldo Mateó, 49, Coqueiros, Maragogipe - Ba");
            documento.add(endereco);
            
            Paragraph cpf = new Paragraph("CPF: " + "027.258.505-09");
            documento.add(cpf);
            
            Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", "relatorio.pdf"});
            
            documento.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: " + ex);
            //Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void gerarCorpo(){
        
    }
    
}
