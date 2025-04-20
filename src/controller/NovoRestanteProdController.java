package controller;

import java.io.IOException;

import application.Main;
import dao.ConexaoProduto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NovoRestanteProdController {
	
	Alert alert = new Alert(Alert.AlertType.ERROR);
	Alert alert2 = new Alert(Alert.AlertType.ERROR);
	Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
	Main m = new Main();
	ConexaoProduto conP = new ConexaoProduto();
	
	@FXML
	private Button btnVoltar;
	@FXML
	private TextField txtNovoRestanteProd;
	@FXML
	private TextField txtBuscaProd;
	@FXML
	private Button btnAplicar;
	
	public NovoRestanteProdController() {
		alert.setContentText("Preencha todos os campos. Não deixe nenhum em branco");
		alert2.setContentText("Produto não cadastrado no sistema");
		alert3.setContentText("Quantidade restante alterada com suscesso");
	}
	
	public void onAplicarClick() throws IOException {
		if(txtBuscaProd.getText() != "") {
			if(txtNovoRestanteProd.getText() != "") {
				if(conP.buscaProduto(Integer.parseInt(txtBuscaProd.getText()))){
				conP.alteraProduto(Integer.parseInt(txtBuscaProd.getText()), null, 3, 0, Integer.parseInt(txtNovoRestanteProd.getText()));
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