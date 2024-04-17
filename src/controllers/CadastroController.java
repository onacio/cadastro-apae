package controllers;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
import models.Paciente;
import relatorio.RelatorioCadastro;

/**
 *
 * @author onacio
 */
public class CadastroController {
    
    public void gerarRelatorioCadastro() throws DocumentException, IOException{
        Paciente p = new Paciente();
        p.setNome("Antonia dos Santos");
        RelatorioCadastro relCad = new RelatorioCadastro(p);
        relCad.gerarCabecalho();        
    }    
}
