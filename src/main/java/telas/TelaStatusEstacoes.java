package telas;

import classes.EstacaoReserva;
import classes.Global;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
 * Created by marcelo on 20/07/17.
 */
public class TelaStatusEstacoes implements Initializable{
    @FXML
    TableColumn <EstacaoReserva, String> TCTempo;
    @FXML
    TableColumn <EstacaoReserva, String> TCNome;
    @FXML
    TableColumn <EstacaoReserva, String> TCBusy;
    @FXML
    TableColumn <EstacaoReserva, String> TCOp;
    @FXML
    TableColumn <EstacaoReserva, String> TCQj;
    @FXML
    TableColumn <EstacaoReserva, String> TCQk;
    @FXML
    TableColumn <EstacaoReserva, String> TCVj;
    @FXML
    TableColumn <EstacaoReserva, String> TCVk;
    @FXML
    TableColumn <EstacaoReserva, String> TCEnd;

    @FXML
    TableView<EstacaoReserva> TVBanco;




    @Override
    public void initialize(URL location, ResourceBundle resources){
        ObservableList<EstacaoReserva> listareg  = FXCollections.observableList(Global.listatabela);
        TCBusy.setCellValueFactory(new PropertyValueFactory<>("Busy"));
        TCEnd.setCellValueFactory(new PropertyValueFactory<>("Address"));
        TCNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        TCOp.setCellValueFactory(new PropertyValueFactory<>("Op"));
        TCQj.setCellValueFactory(new PropertyValueFactory<>("Qj"));
        TCQk.setCellValueFactory(new PropertyValueFactory<>("Qk"));
        TCTempo.setCellValueFactory(new PropertyValueFactory<>("Tempo"));
        TCVj.setCellValueFactory(new PropertyValueFactory<>("Vj"));
        TCVk.setCellValueFactory(new PropertyValueFactory<>("Vk"));
        TVBanco.setItems(FXCollections.observableList(listareg));

    }
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
}
