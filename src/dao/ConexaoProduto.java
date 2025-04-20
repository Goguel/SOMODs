package dao;

import java.io.IOException;
import java.sql.*;
import application.Main;
import javafx.scene.control.Alert;
import controller.AfterLoginController;

public class ConexaoProduto {
	
	Alert alert = new Alert(Alert.AlertType.ERROR);
	Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
	private final Conexao con = new Conexao();
	Main m = new Main();
	String aux = "Erro";
	float aux2 = 0;
	int aux3 = 0;

	
	private final String BUSCARPRODUTO = "SELECT codprod FROM produtos WHERE codprod= ?;";
	private final String SELECIONARCODPRODUTO = "SELECT * FROM produtos WHERE nome = ?;";
	private final String SELECIONARPRODUTO = "SELECT * FROM produtos WHERE codprod = ?;";
	private final String INSERIRPRODUTO = "INSERT INTO produtos VALUES(?, ?, ?);";
	private final String ALTERARNOMEPRODUTO = "UPDATE produtos SET nome = ? WHERE codprod = ?;";
	private final String ALTERARVALORPRODUTO = "UPDATE produtos SET valor = ? WHERE codprod = ?;";
	private final String ALTERARQTDRESTANTEPRODUTO = "UPDATE produtos SET qtdrestante = ? WHERE codprod = ?;";
	private final String REMOVERPRODUTO = "DELETE FROM produtos WHERE codprod = ?;";
	
	
	public boolean buscaProduto(int cod) {
		try {
				con.conecta();
				PreparedStatement preparaInstrucao;
				preparaInstrucao = con.getConexao().prepareStatement(BUSCARPRODUTO);
				
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
	
	public String selecionaNomeProd(int cod) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(SELECIONARPRODUTO);
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
	
	public float selecionaValorProd(int cod) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(SELECIONARPRODUTO);
			preparaInstrucao.setInt(1, cod);
			ResultSet rs1 = preparaInstrucao.executeQuery();
			while(rs1.next()) {
				aux2 = (rs1.getFloat("valor"));
			}
			con.desconecta();
			return aux2;
		}catch (SQLException e) {
			return aux2;
		}
	}
	
	public int selecionaQtdrestanteProd(int cod) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(SELECIONARPRODUTO);
			preparaInstrucao.setInt(1, cod);
			ResultSet rs1 = preparaInstrucao.executeQuery();
			while(rs1.next()) {
				aux3 = (rs1.getInt("qtdrestante"));
			}
			con.desconecta();
			return aux3;
		}catch (SQLException e) {
			return aux3;
		}
	}
	public void insereProduto(String nome, float valor, int qtdrestante) {
		try {
				con.conecta();
				PreparedStatement preparaInstrucao;
				preparaInstrucao = con.getConexao().prepareStatement(INSERIRPRODUTO);
				
				preparaInstrucao.setString(1, nome.toUpperCase());
				preparaInstrucao.setFloat(2, valor);
				preparaInstrucao.setInt(3, qtdrestante);
				
				preparaInstrucao.execute();

			con.desconecta();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int selecionaCod(String nome) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(SELECIONARCODPRODUTO);
			
			preparaInstrucao.setString(1, nome.toUpperCase());
			
			ResultSet rs1 = preparaInstrucao.executeQuery();
			while(rs1.next()) {
				aux3 = (rs1.getInt("codprod"));
			}
			con.desconecta();
			return aux3;
		}catch (SQLException e) { return aux3; }
	}
	
	public void alteraProduto(int codprod, String nome, int op, float valor, int qtd) {
		try{
				con.conecta();
				PreparedStatement preparaInstrucao;
			      switch(op) {
					case 1: preparaInstrucao = con.getConexao().prepareStatement(ALTERARNOMEPRODUTO);
						    preparaInstrucao.setString(1, nome);
					        preparaInstrucao.setInt(2, codprod);
					        preparaInstrucao.execute();	
						break;
					case 2: preparaInstrucao = con.getConexao().prepareStatement(ALTERARVALORPRODUTO);
							preparaInstrucao.setFloat(1, valor);
					        preparaInstrucao.setInt(2, codprod);
					        preparaInstrucao.execute();		
						break;
					case 3: preparaInstrucao = con.getConexao().prepareStatement(ALTERARQTDRESTANTEPRODUTO);
							preparaInstrucao.setInt(1, qtd);
					        preparaInstrucao.setInt(2, codprod);
					        preparaInstrucao.execute();	
				}
				
				con.desconecta();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeProduto(int cod) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(REMOVERPRODUTO );
			preparaInstrucao.setInt(1, cod);
			preparaInstrucao.execute();	
			con.desconecta();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
