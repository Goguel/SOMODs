package controller;

import java.io.IOException;

import application.Main;
import dao.ConexaoProduto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BuscarProdController {
	
	Alert alert = new Alert(Alert.AlertType.ERROR);
	Alert alert2 = new Alert(Alert.AlertType.ERROR);
	Main m = new Main();
	String x;
	ConexaoProduto conP = new ConexaoProduto();
	
	@FXML
	private TextField txtBuscaProd;
	@FXML
	private Button btnBuscar;
	@FXML
	private Button btnVoltar;
	@FXML
	private Label lblInsereCod;
	@FXML
	private Label lblNomeProd;
	@FXML
	private Label lblValorProd;
	@FXML
	private Label lblqtdrestanteProd;
	@FXML
	private Label lblNomeProd1;
	@FXML
	private Label lblValorProd1;
	@FXML
	private Label lblqtdrestanteProd1;
	
	public BuscarProdController() {
		alert.setContentText("Preencha todos os campos. Não deixe nenhum em branco");
		alert2.setContentText("Produto não cadastrado no sistema");
	}

	public void onBuscarClick() throws IOException {
		if(txtBuscaProd.getText() != "") {
			if(conP.buscaProduto(Integer.parseInt(txtBuscaProd.getText()))){
				lblInsereCod.setOpacity(0);
			   	btnBuscar.setOpacity(0);
			   	txtBuscaProd.setOpacity(0);
			   	lblNomeProd.setText("Nome do Produto:");
			   	lblValorProd.setText("Valor do produto:");
			   	lblqtdrestanteProd.setText("Quantidade restante do produto:");
			   	lblNomeProd1.setText(conP.selecionaNomeProd(Integer.parseInt(txtBuscaProd.getText())));
			   	lblValorProd1.setText(""+conP.selecionaValorProd(Integer.parseInt(txtBuscaProd.getText()))+"");
			   	lblqtdrestanteProd1.setText(""+conP.selecionaQtdrestanteProd(Integer.parseInt(txtBuscaProd.getText()))+"");
			   	
			}else {
				alert2.show();
			}
		}else alert.show();				
	}
	
	public void onVoltarClick() throws IOException {
		m.changeScene("GerProd.fxml");
	}
}
