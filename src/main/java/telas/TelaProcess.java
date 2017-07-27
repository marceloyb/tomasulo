package telas;

import classes.Global;
import classes.Processamento;
import classes.SetEstacao;
import classes.Tradutor;
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

import static classes.Global.*;

/**
 * Created by marcelo on 21/07/17.
 */
public class TelaProcess implements Initializable{

    @FXML
    TextField tfCiclo;
    SetEstacao setbancotemp = new SetEstacao();
    Processamento processtemp = new Processamento();
    Tradutor tr = new Tradutor();
    private Boolean clearadd;
    private Boolean clearmul;
    private Boolean clearload;
    private String instrucao;

    public void btProcessarActionHandler(ActionEvent e){
        clearadd = false;
        clearmul = false;
        clearload = false;
        ciclo++;
        tfCiclo.setText(""+(ciclo));
        if (ciclo > 1) {
            processtemp.processa();
            if ((branchprocessando == false) && (programcounter <= numeroinstrucoes)) {
                instrucao = Global.instrucoes.get(programcounter - 1);
                tr.LeToken(instrucao);
                programcounter++;
            }
            clearadd = setbancotemp.liberaBancoAdd();
            if ((clearadd) && (numeroinstrucoesfilaadd > posicaofilaadd)) {
                posicaofilaadd++;
                tr.LeToken(filaadd.get(posicaofilaadd));
            }
            clearmul = setbancotemp.liberaBancoMul();
            if ((clearmul) && (numeroinstrucoesfilamul > posicaofilamul)) {
                posicaofilamul++;
                tr.LeToken(filamul.get(posicaofilamul));
            }
            clearload = setbancotemp.liberaBancoLoad();
            if ((clearload) && (numeroinstrucoesfilaload > posicaofilaload)) {
                posicaofilaload++;
                tr.LeToken(filaload.get(posicaofilaload));
            }
        }
    }

    public void btRegActionHandler(ActionEvent e) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/telastatusreg.fxml"));
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

    public void btBancoRegActionHandler(ActionEvent e) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/telastatusestacoesreserva.fxml"));
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
    public void btMemActionHandler(ActionEvent e) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/telastatusmemoria.fxml"));
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
        stage.setTitle("Sistema Hotel");
        stage.setScene(new Scene(root));
        ((Node)e.getSource()).getParent().getScene().getWindow().hide();
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        tfCiclo.setText(String.valueOf(ciclo));
    }
}
