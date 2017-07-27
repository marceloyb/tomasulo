package telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by marcelo on 20/07/17.
 */
public class TelaInicial implements Initializable{

    @FXML
    TextField tfReg;
    @FXML
    TextField tfUfAdd;
    @FXML
    TextField tfUfMul;
    @FXML
    TextField tfUfLoad;
    @FXML
    TextField tfErAdd;
    @FXML
    TextField tfErMul;
    @FXML
    TextField tfErLoad;

    public void btOkActionHandler(ActionEvent e){
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
        ((Node) e.getSource()).getParent().getScene().getWindow().hide();
        stage.show();
    }

    public void btExitActionHandler(ActionEvent e){
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfReg.setText("8");
        tfUfAdd.setText("2");
        tfUfMul.setText("2");
        tfUfLoad.setText("1");
        tfErAdd.setText("4");
        tfErMul.setText("8");
        tfErLoad.setText("8");
    }

}
