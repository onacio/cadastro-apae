package controllers;

import dao.PacienteDAO;
import javax.swing.JOptionPane;
import models.Paciente;

/**
 *
 * @author Onacio
 */
public class PacienteController {
    
    public void inserir(
            String nome, 
            String mae, 
            String data_nascimento, 
            String cpf,
            String rg, 
            String rua, 
            String complemento, 
            String numero, 
            String cep, 
            String bairro, 
            String cidade, 
            String ponto_referencia,
            String telefone, 
            String celular, 
            String email)
    {
        
        Paciente p = new Paciente();
        
        p.setNome(nome);
        p.setMae(mae);
        p.setData_nascimento(data_nascimento);
        
        p.setCpf(cpf);
        p.setRg(rg); 
        
        p.setRua(rua);        
        p.setComplemento(complemento);
        p.setNumero(numero);
        p.setCep(cep);
        p.setBairro(bairro);
        p.setCidade(cidade);
        p.setPonto_referencia(ponto_referencia);
        p.setTelefone(telefone);
        p.setCelular(celular);
        p.setEmail(email);
                                
        try {
            PacienteDAO dao = new PacienteDAO();
            dao.inserir(p);            
        } catch (Exception | ExceptionInInitializerError e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados na camada controller: " + e.getMessage());            
        }
        
    }
 
    public void listarPaciente(String nome){
        PacienteDAO dao = new PacienteDAO();
        dao.listarPaciente(nome);
    }
}
