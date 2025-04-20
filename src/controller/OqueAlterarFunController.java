package controller;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class OqueAlterarFunController {

	Main m = new Main();
	
	@FXML
	private Button btnVoltar;
	@FXML
	private Button btnNome;
	@FXML
	private Button btnCPF;
	@FXML
	private Button btnTelefone;
	@FXML
	private Button btnEndereco;
	@FXML
	private Button btnEmail;
	
	public void onAltNomeClick() throws IOException {
		m.changeScene("NovoNomeFun.fxml");
	}
	public void onAltCPFClick() throws IOException {
		m.changeScene("NovoCPFFun.fxml");
	}
	public void onAltTelefoneClick() throws IOException {
		m.changeScene("NovoTelefoneFun.fxml");
	}
	public void onAltEnderecoClick() throws IOException {
		m.changeScene("NovoEnderecoFun.fxml");
	}
	public void onAltEmailClick() throws IOException {
		m.changeScene("NovoEmailFun.fxml");
	}
	public void onVoltarClick() throws IOException {
		m.changeScene("GerFun.fxml");
	}
}
