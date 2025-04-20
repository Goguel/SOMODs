
	package controller;

	import java.io.IOException;

import application.Main;
import dao.ConexaoProduto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

	public class RemoverProdController{
		
		Alert alert = new Alert(Alert.AlertType.ERROR);
		Alert alert2 = new Alert(Alert.AlertType.ERROR);
		Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
		Main m = new Main();
		ConexaoProduto conP = new ConexaoProduto();
		
		@FXML
		private Button btnVoltar;
		@FXML
		private TextField txtBuscaProd;
		@FXML
		private Button btnBuscar;
		
		public RemoverProdController() {
			alert.setContentText("Preencha todos os campos. Não deixe nenhum em branco");
			alert2.setContentText("Produto não cadastrado no sistema");
			alert3.setContentText("Produto removido com suscesso");
		}
		
		public void onBuscarClick() throws IOException {
			if(txtBuscaProd.getText() != "") {
					if(conP.buscaProduto(Integer.parseInt(txtBuscaProd.getText()))){
					conP.removeProduto(Integer.parseInt(txtBuscaProd.getText()));
					alert3.show();
					m.changeScene("GerProd.fxml");
					}else alert2.show();
			} else alert.show();
		}
		
		public void onVoltarClick() throws IOException {
			m.changeScene("GerProd.fxml");
		}
	}

