package controller;

import java.io.IOException;

import application.Main;
import dao.ConexaoFuncionario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NovoCPFFunController {
	
	Alert alert = new Alert(Alert.AlertType.ERROR);
	Alert alert2 = new Alert(Alert.AlertType.ERROR);
	Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
	Main m = new Main();
	ConexaoFuncionario conF = new ConexaoFuncionario();
	
	@FXML
	private Button btnVoltar;
	@FXML
	private TextField txtNovoCPFFun;
	@FXML
	private TextField txtBuscaFun;
	@FXML
	private Button btnAplicar;
	
	public NovoCPFFunController() {
		alert.setContentText("Preencha todos os campos. N�o deixe nenhum em branco");
		alert2.setContentText("Funcion�rio n�o cadastrado no sistema");
		alert3.setContentText("CPF alterado com suscesso");
	}
	
	public void onAplicarClick() throws IOException {
		if(txtBuscaFun.getText() != "") {
			if(txtNovoCPFFun.getText() != "") {
				if(conF.buscaFuncionario(Integer.parseInt(txtBuscaFun.getText()))){
				conF.alteraFuncionario(Integer.parseInt(txtBuscaFun.getText()), txtNovoCPFFun.getText(), 2);
				alert3.show();
				m.changeScene("OqueAlterarFun.fxml");
				}else alert2.show();
			}else alert.show();
		} else alert.show();
	}
	
	public void onVoltarClick() throws IOException {
		m.changeScene("OqueAlterarFun.fxml");
	}
}