import classes.Execucao;
import classes.Global;
import classes.Processamento;
import classes.Tradutor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static classes.Global.listadd;

public class Main extends Application {
    public static void main(String[] args) {
        Global.initialize();
        Tradutor tr = new Tradutor();
        tr.ArmazenaInstrucao();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/inicial.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Simulador Tomasulo");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
