package dao;

import java.io.IOException;
import java.sql.*;
import application.Main;

public class ConexaoCliente{

	private final Conexao con = new Conexao();
	Main m = new Main();
	String aux = "Erro";
	
	private final String BUSCARCLIENTE = "SELECT cpf from clientes WHERE cpf = ?;";
	private final String SELECIONARCLIENTE = "SELECT * FROM clientes WHERE cpf = ?;";
	private final String INSERIRCLIENTE = "INSERT INTO clientes VALUES(?, ?, ?, ?, ?);";
	private final String ALTERARNOMECLIENTE = "UPDATE clientes SET nome = ? WHERE cpf = ?;";
	private final String ALTERARCPFCLIENTE = "UPDATE clientes SET CPF = ? WHERE cpf = ?;";
	private final String ALTERARTELEFONECLIENTE = "UPDATE clientes SET telefone = ? WHERE cpf = ?;";
	private final String ALTERARENDERECOCLIENTE = "UPDATE clientes SET endereco = ? WHERE cpf = ?;";
	private final String ALTERAREMAILCLIENTE = "UPDATE clientes SET email = ? WHERE cpf = ?;";
	private final String REMOVERCLIENTE = "DELETE FROM clientes WHERE cpf = ?;";
	
	public boolean buscaCliente(String CPF) throws IOException {
		try {
				con.conecta();
				PreparedStatement preparaInstrucao;
				preparaInstrucao = con.getConexao().prepareStatement(BUSCARCLIENTE);
				
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

	public String selecionaNomeCliente(String CPF) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(SELECIONARCLIENTE);
			preparaInstrucao.setString(1, CPF);
			ResultSet rs1 = preparaInstrucao.executeQuery();
			String aux = "Erro1";
			while(rs1.next()) {
				aux = (rs1.getString("nome"));
			}
			con.desconecta();
			return aux;
		}catch (SQLException e) {
			return aux;
		}
	}
	
	public String selecionaCPFCliente(String CPF) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(SELECIONARCLIENTE);
			preparaInstrucao.setString(1, CPF);
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
	
	public String selecionaTelefoneCliente(String CPF) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(SELECIONARCLIENTE);
			preparaInstrucao.setString(1, CPF);
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
	
	public String selecionaEnderecoCliente(String CPF) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(SELECIONARCLIENTE);
			preparaInstrucao.setString(1, CPF);
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
	
	public String selecionaEmailCliente(String CPF) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(SELECIONARCLIENTE);
			preparaInstrucao.setString(1, CPF);
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
	
	public void insereCliente(String nome, String CPF, String telefone, String endereco, String email) {
		try {
				con.conecta();
				PreparedStatement preparaInstrucao;
				preparaInstrucao = con.getConexao().prepareStatement(INSERIRCLIENTE);
				
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
	
	public void alteraCliente(String CPF, String op4, int op) {
		try{
				con.conecta();
				PreparedStatement preparaInstrucao;
			      switch(op) {
					case 1: preparaInstrucao = con.getConexao().prepareStatement(ALTERARNOMECLIENTE);
						    preparaInstrucao.setString(1, op4);
					        preparaInstrucao.setString(2, CPF);
					        preparaInstrucao.execute();	
						break;
					case 2: preparaInstrucao = con.getConexao().prepareStatement(ALTERARCPFCLIENTE);
							preparaInstrucao.setString(1, op4);
					        preparaInstrucao.setString(2, CPF);
					        preparaInstrucao.execute();		
						break;
					case 3: preparaInstrucao = con.getConexao().prepareStatement(ALTERARTELEFONECLIENTE);
							preparaInstrucao.setString(1, op4);
					        preparaInstrucao.setString(2, CPF);
					        preparaInstrucao.execute();	
						break;
					case 4: preparaInstrucao = con.getConexao().prepareStatement(ALTERARENDERECOCLIENTE);
							preparaInstrucao.setString(1, op4);
					        preparaInstrucao.setString(2, CPF);
					        preparaInstrucao.execute();		
						break;
					case 5: preparaInstrucao = con.getConexao().prepareStatement(ALTERAREMAILCLIENTE);
							preparaInstrucao.setString(1, op4);
					        preparaInstrucao.setString(2, CPF);
					        preparaInstrucao.execute();		
						break;
				}
				
				con.desconecta();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeCliente(String CPF) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(REMOVERCLIENTE);
			preparaInstrucao.setString(1, CPF);
			preparaInstrucao.execute();	
			con.desconecta();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
