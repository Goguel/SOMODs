package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import model.Produtos;

public class Conexao {
	
	private static final String url = "jdbc:postgresql://localhost:5433/postgres";
	private static final String user = "postgres";
	private static final String password = "!@12NDGbdg42";
	private static final String driver = "org.postgresql.Driver";
	private Connection conexao;
	
	public void conecta() {
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);	
		}catch(ClassNotFoundException | SQLException e) {
			System.err.println(e);
		}
	}
	
	public void desconecta() {
		try {
			conexao.close();
		}catch(SQLException ex) {
			System.err.println(ex);
		}
	}
	
	public Connection getConexao() {
		return conexao;
	}
	
	public void Write(List<Produtos> listProdutos) {
		File f = new File("C:\\Users\\migue\\OneDrive\\Documentos\\NotaFiscal.txt");
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    		Date data = new Date(System.currentTimeMillis());
            String texto = "SOMOD's\nDia e hora da compra: "+dateFormat.format(data)+"\n------------";
            String texto2 = "";
            bw.write(texto);
            float x = 0;
            for(int i = 0; i <listProdutos.size(); i++) {
            	texto2 = "\nNome do produto: "+listProdutos.get(i).getNome()+" | Valor unitário do produto: R$"+listProdutos.get(i).getValor()+" | Quantidade comprada: "+listProdutos.get(i).getQtdRestante()+" | Valor gasto com o produto: R$"+listProdutos.get(i).getValorFinal();
            	bw.write(texto2);
            	x += Float.parseFloat(listProdutos.get(i).getValorFinal());
            }
            String texto3 = "\n----------------------------------------\nValor total das compras: R$"+x;
            bw.write(texto3);
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
