package controller;

import java.io.IOException;

import application.Main;
import dao.ConexaoProduto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NovoNomeProdController {
	
	Alert alert = new Alert(Alert.AlertType.ERROR);
	Alert alert2 = new Alert(Alert.AlertType.ERROR);
	Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
	Main m = new Main();
	ConexaoProduto conP = new ConexaoProduto();
	
	@FXML
	private Button btnVoltar;
	@FXML
	private TextField txtNovoNomeProd;
	@FXML
	private TextField txtBuscaProd;
	@FXML
	private Button btnAplicar;
	
	public NovoNomeProdController() {
		alert.setContentText("Preencha todos os campos. Não deixe nenhum em branco");
		alert2.setContentText("Produto não cadastrado no sistema");
		alert3.setContentText("Nome alterado com suscesso");
	}
	
	public void onAplicarClick() throws IOException {
		if(txtBuscaProd.getText() != "") {
			if(txtNovoNomeProd.getText() != "") {
				if(conP.buscaProduto(Integer.parseInt(txtBuscaProd.getText()))){
				conP.alteraProduto(Integer.parseInt(txtBuscaProd.getText()), txtNovoNomeProd.getText(), 1, 0, 0);
				alert3.show();
				m.changeScene("OqueAlterarProd.fxml");
				}else alert2.show();
			}else alert.show();
		} else alert.show();
	}
	
	public void onVoltarClick() throws IOException {
		m.changeScene("OqueAlterarProd.fxml");
	}
}