package controller;

import java.io.IOException;

import application.Main;
import dao.ConexaoProduto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InserirProdController {
	
	Alert alert = new Alert(Alert.AlertType.ERROR);
	Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
	Main m = new Main();
	ConexaoProduto conP = new ConexaoProduto();
	
	@FXML
	private TextField txtNomeProd;
	@FXML
	private TextField txtValorProd;
	@FXML
	private TextField txtqtdrestanteProd;
	@FXML
	private Button btnAplicar;
	@FXML
	private Button btnVoltar;
	
	public InserirProdController() {
		alert.setContentText("Preencha todos os campos. Não deixe nenhum em branco");
	}

	public void onAplicarClick() throws IOException {
		if(txtNomeProd.getText() != "" && txtValorProd.getText().toString() != "" && txtqtdrestanteProd.getText().toString() != "" ){
				conP.insereProduto(txtNomeProd.getText().toString(), Float.parseFloat(txtValorProd.getText()), Integer.parseInt(txtqtdrestanteProd.getText()));
				alert2.setContentText("O código do novo produto é: "+conP.selecionaCod(txtNomeProd.getText()));
				alert2.show();
				m.changeScene("GerProd.fxml");
		}else alert.show();
	}
	
	public void onVoltarClick() throws IOException {
		m.changeScene("GerProd.fxml");
	}
}
