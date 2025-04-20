package controller;

import java.io.IOException;

import application.Main;
import dao.ConexaoFuncionario;
import dao.ConexaoCliente;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GerVenController {
	
	Alert alert = new Alert(Alert.AlertType.ERROR);
	Alert alert2 = new Alert(Alert.AlertType.ERROR);
	Alert alert3 = new Alert(Alert.AlertType.ERROR);
	Main m = new Main();
	ConexaoCliente conC = new ConexaoCliente();
	ConexaoFuncionario conF = new ConexaoFuncionario();
	
	@FXML
	private Button btnVoltar;
	@FXML
	private TextField txtBuscaCPF;
	@FXML
	private TextField txtBuscaCod;
	@FXML
	private Button btnAplicar;
	
	public GerVenController() {
		alert.setContentText("Preencha todos os campos. Não deixe nenhum em branco");
		alert2.setContentText("Cliente não cadastrado no sistema");
		alert3.setContentText("Funcionário não cadastrado no sistema");
	}
	
	public void onAplicarClick() throws IOException {
		if(txtBuscaCPF.getText() != "") {
			if(txtBuscaCod.getText() != "") {
				if(conC.buscaCliente(txtBuscaCPF.getText())){
					if(conF.buscaFuncionario(Integer.parseInt(txtBuscaCod.getText()))) {		
						m.changeScene("SelecionarProdutos.fxml");
					}else alert3.show();
				}else alert2.show();
			}else alert.show();
		} else alert.show();
	}
	
	public void onVoltarClick() throws IOException {
		m.changeScene("AfterLogin.fxml");
	}
}