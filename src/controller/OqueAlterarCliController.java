package controller;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class OqueAlterarCliController {
	
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
		m.changeScene("NovoNomeCli.fxml");
	}
	public void onAltCPFClick() throws IOException {
		m.changeScene("NovoCPFCli.fxml");
	}
	public void onAltTelefoneClick() throws IOException {
		m.changeScene("NovoTelefoneCli.fxml");
	}
	public void onAltEnderecoClick() throws IOException {
		m.changeScene("NovoEnderecoCli.fxml");
	}
	public void onAltEmailClick() throws IOException {
		m.changeScene("NovoEmailCli.fxml");
	}
	public void onVoltarClick() throws IOException {
		m.changeScene("GerCli.fxml");
	}
	
}
