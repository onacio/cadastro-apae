package dao;

import jdbc.Conexao;
import models.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Onacio
 */
public class PacienteDAO {
    private final Connection conexao;
    ResultSet rs;
    
    public PacienteDAO(){
        this.conexao = new Conexao().pegarConexao();
    }
        
    public void inserir(Paciente obj){
        
        String sql = "INSERT INTO pacientes (nome, mae, data_nascimento,"
                    + "cpf, rg, rua, complemento, numero, cep, bairro,"
                    + "cidade, ponto_referencia, telefone, celular, email)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getMae());
                stmt.setString(3, obj.getData_nascimento());
                
                stmt.setString(4, obj.getCpf());
                stmt.setString(5, obj.getRg());
                
                stmt.setString(6, obj.getRua());
                stmt.setString(7, obj.getComplemento());
                stmt.setString(8, obj.getNumero());
                stmt.setString(9, obj.getCep());
                stmt.setString(10, obj.getBairro());
                stmt.setString(11, obj.getCidade());
                stmt.setString(12, obj.getPonto_referencia());
                stmt.setString(13, obj.getTelefone());
                stmt.setString(14, obj.getCelular());
                stmt.setString(15, obj.getEmail());
                
                stmt.execute();
            }
            
            JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!!!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados no banco" + e.getMessage());
        }
    }

    
    public Paciente listarPaciente(String nome){
        String aql = "SELECT * FROM pacientes WHERE nome like '%?%' order by nome";
                
        try {
            PreparedStatement stmt = conexao.prepareStatement(aql);
            
            stmt.setString(1, nome);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                System.out.println("Encontrou");                
            }else{
                System.out.println("Não encontrou");
            }
        } catch (SQLException e) {
            System.out.println("Deu erro");
        }        
        return null;
    }
}
