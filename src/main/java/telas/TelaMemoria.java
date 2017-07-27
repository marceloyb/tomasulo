package telas;

import classes.Global;
import classes.Memoria;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by marcelo on 21/07/17.
 */
public class TelaMemoria implements Initializable{
    @FXML
    TableColumn<Memoria, String> tcPosicao;
    @FXML
    TableColumn<Memoria, String> tcValor;
    @FXML
    TableView<Memoria> tvMemoria;

    public void btVoltarActionHandler(ActionEvent e){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/telaprocessamento.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setTitle("Simulador Tomasulo");
        stage.setScene(new Scene(root));
        ((Node)e.getSource()).getParent().getScene().getWindow().hide();
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcPosicao.setCellValueFactory(new PropertyValueFactory<>("Posicao"));
        tcValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
        tvMemoria.setItems(FXCollections.observableList(Global.tabelamemoria));

    }
}
