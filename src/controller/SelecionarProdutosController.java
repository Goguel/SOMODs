package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import dao.Conexao;
import dao.ConexaoProduto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Produtos;

public class SelecionarProdutosController {
	
	Alert alert = new Alert(Alert.AlertType.ERROR);
	Alert alert2 = new Alert(Alert.AlertType.ERROR);
	Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
	Alert alert4 = new Alert(Alert.AlertType.ERROR);
	Alert alert5 = new Alert(Alert.AlertType.INFORMATION);
	Main m = new Main();
	ConexaoProduto conP = new ConexaoProduto();
	Conexao c = new Conexao();
	public List<Produtos> listProdutos = new ArrayList();
	int[] x = new int[50];
	int i = 0;
	@FXML
	private Button btnVoltar;
	@FXML
	private Label lblBuscaProd;
	@FXML
	private TextField txtBuscaProd;
	@FXML
	private Label lblValorUni;
	@FXML
	private Label lblqtdRestante;
	@FXML
	private Label lblValorUni1;
	@FXML
	private Label lblqtdRestante1;
	@FXML
	private Label lblqtdCompra;
	@FXML
	private Button btnAplicar;
	@FXML
	private TextField txtqtdCompra;
	@FXML
	private Button btnAdicionar;
	@FXML
	private Button btnFin;
	
	public SelecionarProdutosController() {
		alert.setContentText("Preencha todos os campos. Não deixe nenhum em branco");
		alert2.setContentText("Produto não cadastrado no sistema");
		alert3.setContentText("Produto adicionado com suscesso");
		alert4.setContentText("Digite uma quantidade coerente");
		alert5.setContentText("Venda efetuada e nota fiscal gerada com suscesso");
	}
	
	public void onAplicarClick() {
		if(txtBuscaProd.getText() != "") {
			if(conP.buscaProduto(Integer.parseInt(txtBuscaProd.getText()))){
				txtBuscaProd.setOpacity(0);
				lblBuscaProd.setText(null);
				btnAplicar.setCursor(null);
				btnAplicar.setOpacity(0);
				btnAdicionar.setOpacity(1);
				lblValorUni.setText("Valor unitário do produto (R$):");
				lblqtdRestante.setText("Quantidade restante:");
				lblValorUni1.setText(""+(conP.selecionaValorProd(Integer.parseInt(txtBuscaProd.getText())))+"");
				lblqtdRestante1.setText(""+(conP.selecionaQtdrestanteProd(Integer.parseInt(txtBuscaProd.getText())))+"");
				lblqtdCompra.setText("Quantidade a ser comprada:");
				txtqtdCompra.setOpacity(1);
				}else alert2.show();
			}else alert.show();
	}
	
	public void onAdicionarClick() {
		if(lblBuscaProd.getText() == null) {
			if(txtqtdCompra.getText() != "") {
				if(Integer.parseInt(txtqtdCompra.getText()) <= conP.selecionaQtdrestanteProd(Integer.parseInt(txtBuscaProd.getText()))) {
					i++;
					Produtos p1 = new Produtos(Integer.parseInt(txtBuscaProd.getText()),conP.selecionaNomeProd(Integer.parseInt(txtBuscaProd.getText())), conP.selecionaValorProd(Integer.parseInt(txtBuscaProd.getText())), Integer.parseInt(txtqtdCompra.getText()), conP.selecionaValorProd(Integer.parseInt(txtBuscaProd.getText()))*Integer.parseInt(txtqtdCompra.getText()));
					listProdutos.add(p1);
					x[i-1] = Integer.parseInt(txtqtdCompra.getText());
					alert3.show();
					txtBuscaProd.setOpacity(1);
					lblBuscaProd.setText("Insira o código do produto a ser comprado:");
					btnAplicar.setOpacity(1);
					btnAdicionar.setOpacity(0);
					lblValorUni.setText(null);
					lblqtdRestante.setText(null);
					lblValorUni1.setText(null);
					lblqtdRestante1.setText(null);
					lblqtdCompra.setText(null);
					txtqtdCompra.setOpacity(0);
					btnFin.setOpacity(1);
					txtBuscaProd.clear();
					txtqtdCompra.clear();
				}else alert4.show();
			}else alert.show();
		}
	}

	public void onFinClick() throws IOException{
		c.Write(listProdutos);
		for(int i = 0; i <listProdutos.size(); i++) {
			conP.alteraProduto(listProdutos.get(i).getCod(), null, 3, 0, ((conP.selecionaQtdrestanteProd(listProdutos.get(i).getCod())) - x[i]));
		}
		m.changeScene("AfterLogin.fxml");
		alert5.show();
	}
	
	public void onVoltarClick() throws IOException {
		m.changeScene("GerVen.fxml");
	}
}