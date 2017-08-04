package telas;

import classes.Registrador;
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

import static classes.Global.listareg;


/**
 * Created by marcelo on 23/07/17.
 */
public class TelaStatusRegistradores implements Initializable{
    @FXML
    TableColumn<Registrador, String> tcReg;
    @FXML
    TableColumn <Registrador, String> tcValor;
    @FXML
    TableColumn <Registrador, String> tcProcessing;
    @FXML
    TableColumn <Registrador, String> tcEstacao;
    @FXML
    TableView<Registrador> tvReg;

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
        tcReg.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        tcValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
        tcProcessing.setCellValueFactory(new PropertyValueFactory<>("Processing"));
        tcEstacao.setCellValueFactory(new PropertyValueFactory<>("Estacao"));
        tvReg.setItems(FXCollections.observableList(listareg));
    }
}
