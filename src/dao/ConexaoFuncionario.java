package dao;

import java.io.IOException;
import java.sql.*;
import application.Main;
import javafx.scene.control.Alert;
import controller.AfterLoginController;

public class ConexaoFuncionario {
	
	Alert alert = new Alert(Alert.AlertType.ERROR);
	Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
	private final Conexao con = new Conexao();
	Main m = new Main();
	String aux = "Erro";
	int aux2 = 0;

	private final String ENTRARFUNCIONARIO = "SELECT cpf FROM funcionarios WHERE codfunc = ?";
	private final String BUSCARFUNCIONARIO = "SELECT codfunc from funcionarios WHERE codFunc = ?;";
	private final String BUSCARCPFFUNCIONARIO = "SELECT cpf from funcionarios WHERE cpf = ?;";
	private final String SELECIONARFUNCIONARIO = "SELECT * FROM funcionarios WHERE codFunc = ?;";
	private final String SELECIONARCPFFUNCIONARIO = "SELECT * FROM funcionarios WHERE cpf = ?;";
	private final String INSERIRFUNCIONARIO = "INSERT INTO funcionarios VALUES(?, ?, ?, ?, ?);";
	private final String ALTERARNOMEFUNCIONARIO = "UPDATE funcionarios SET nome = ? WHERE codfunc = ?;";
	private final String ALTERARCPFFUNCIONARIO = "UPDATE funcionarios SET CPF = ? WHERE codfunc = ?;";
	private final String ALTERARTELEFONEFUNCIONARIO = "UPDATE funcionarios SET telefone = ? WHERE codfunc = ?;";
	private final String ALTERARENDERECOFUNCIONARIO = "UPDATE funcionarios SET endereco = ? WHERE codfunc = ?;";
	private final String ALTERAREMAILFUNCIONARIO = "UPDATE funcionarios SET email = ? WHERE codfunc = ?;";
	private final String REMOVERFUNCIONARIO = "DELETE FROM funcionarios WHERE codfunc = ?;";
	
	public void entraFuncionario(String username, String password) throws IOException  {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(ENTRARFUNCIONARIO);
			
			preparaInstrucao.setInt(1, Integer.parseInt(username));
			
			ResultSet rs = preparaInstrucao.executeQuery();
			boolean aux = false;
			while(rs.next()) {
				aux = true;
			}
			if(!aux) {
				alert.setContentText("Usuário não está no banco de dados");
				alert.show();
			}else {
				rs = preparaInstrucao.executeQuery();
				while(rs.next()){ 
					String getPassword = rs.getString("cpf");
					if (getPassword.equals(password)) {
						alert2.setContentText("Entrou no sistema");
						alert2.show();
						m.changeScene("AfterLogin.fxml");
						}else{
							alert.setContentText("Senha incorreta");
							alert.show();
						}
					}
			}
		}catch (SQLException e) {
			
		}
	}

	
	public boolean buscaFuncionario(int cod ) {
		try {
				con.conecta();
				PreparedStatement preparaInstrucao;
				preparaInstrucao = con.getConexao().prepareStatement(BUSCARFUNCIONARIO);
				
				preparaInstrucao.setInt(1, cod);
				
				ResultSet rs = preparaInstrucao.executeQuery();
				boolean aux = false;
					while(rs.next()) {
						aux = true;
					}
					con.desconecta();
					if(aux) {
						return true;
					}else {
						return false;
					}
		}catch (SQLException e) { return false; }
	}
	
	public int selecionaCod(String CPF) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(SELECIONARCPFFUNCIONARIO);
			
			preparaInstrucao.setString(1, CPF);
			
			ResultSet rs1 = preparaInstrucao.executeQuery();
			while(rs1.next()) {
				aux2 = (rs1.getInt("codfunc"));
			}
			con.desconecta();
			return aux2;
		}catch (SQLException e) { return aux2; }
	}
	
	public boolean buscaCPFFuncionario(String CPF ) {
		try {
				con.conecta();
				PreparedStatement preparaInstrucao;
				preparaInstrucao = con.getConexao().prepareStatement(BUSCARCPFFUNCIONARIO);
				
				preparaInstrucao.setString(1, CPF);
				
				ResultSet rs = preparaInstrucao.executeQuery();
				boolean aux = false;
					while(rs.next()) {
						aux = true;
					}
					con.desconecta();
					if(aux) {
						return true;
					}else {
						return false;
					}
		}catch (SQLException e) { return false; }
	}
	
	public String selecionaNomeFunc(int cod) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(SELECIONARFUNCIONARIO);
			preparaInstrucao.setInt(1, cod);
			ResultSet rs1 = preparaInstrucao.executeQuery();
			while(rs1.next()) {
				aux = (rs1.getString("nome"));
			}
			con.desconecta();
			return aux;
		}catch (SQLException e) {
			return aux;
		}
	}
	
	public String selecionaCPFFunc(int cod) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(SELECIONARFUNCIONARIO);
			preparaInstrucao.setInt(1, cod);
			ResultSet rs1 = preparaInstrucao.executeQuery();
			while(rs1.next()) {
				aux = (rs1.getString("cpf"));
			}
			con.desconecta();
			return aux;
		}catch (SQLException e) {
			return aux;
		}
	}
	
	public String selecionaTelefoneFunc(int cod) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(SELECIONARFUNCIONARIO);
			preparaInstrucao.setInt(1, cod);
			ResultSet rs1 = preparaInstrucao.executeQuery();
			while(rs1.next()) {
				aux = (rs1.getString("telefone"));
			}
			con.desconecta();
			return aux;
		}catch (SQLException e) {
			return aux;
		}
	}
	
	public String selecionaEnderecoFunc(int cod) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(SELECIONARFUNCIONARIO);
			preparaInstrucao.setInt(1, cod);
			ResultSet rs1 = preparaInstrucao.executeQuery();
			while(rs1.next()) {
				aux = (rs1.getString("endereco"));
			}
			con.desconecta();
			return aux;
		}catch (SQLException e) {
			return aux;
		}
	}
	
	public String selecionaEmailFunc(int cod) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(SELECIONARFUNCIONARIO);
			preparaInstrucao.setInt(1, cod);
			ResultSet rs1 = preparaInstrucao.executeQuery();
			while(rs1.next()) {
				aux = (rs1.getString("email"));
			}
			con.desconecta();
			return aux;
		}catch (SQLException e) {
			return aux;
		}
	}
	
	public String selecionaCodFunc(int cod) {
		aux = ""+cod+"";
		return aux;
	}
	
	public void insereFuncionario(String nome, String CPF, String telefone, String endereco, String email) {
		try {
				con.conecta();
				PreparedStatement preparaInstrucao;
				preparaInstrucao = con.getConexao().prepareStatement(INSERIRFUNCIONARIO);
				
				preparaInstrucao.setString(1, nome.toUpperCase());
				preparaInstrucao.setString(2, CPF);
				preparaInstrucao.setString(3, telefone);
				preparaInstrucao.setString(4, endereco.toUpperCase());
				preparaInstrucao.setString(5, email);
				
				preparaInstrucao.execute();

			con.desconecta();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alteraFuncionario(int cod, String op4, int op) {
		try{
				con.conecta();
				PreparedStatement preparaInstrucao;
			      switch(op) {
					case 1: preparaInstrucao = con.getConexao().prepareStatement(ALTERARNOMEFUNCIONARIO);
						    preparaInstrucao.setString(1, op4);
					        preparaInstrucao.setInt(2, cod);
					        preparaInstrucao.execute();	
						break;
					case 2: preparaInstrucao = con.getConexao().prepareStatement(ALTERARCPFFUNCIONARIO);
							preparaInstrucao.setString(1, op4);
					        preparaInstrucao.setInt(2, cod);
					        preparaInstrucao.execute();		
						break;
					case 3: preparaInstrucao = con.getConexao().prepareStatement(ALTERARTELEFONEFUNCIONARIO);
							preparaInstrucao.setString(1, op4);
					        preparaInstrucao.setInt(2, cod);
					        preparaInstrucao.execute();	
						break;
					case 4: preparaInstrucao = con.getConexao().prepareStatement(ALTERARENDERECOFUNCIONARIO);
							preparaInstrucao.setString(1, op4);
					        preparaInstrucao.setInt(2, cod);
					        preparaInstrucao.execute();		
						break;
					case 5: preparaInstrucao = con.getConexao().prepareStatement(ALTERAREMAILFUNCIONARIO);
							preparaInstrucao.setString(1, op4);
					        preparaInstrucao.setInt(2, cod);
					        preparaInstrucao.execute();		
						break;
				}
				
				con.desconecta();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeFuncionario(int cod) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(REMOVERFUNCIONARIO);
			preparaInstrucao.setInt(1, cod);
			preparaInstrucao.execute();	
			con.desconecta();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
