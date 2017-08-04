package classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by marcelo on 20/07/17.
 */
public class Global {
    EstacaoReserva teste = new EstacaoReserva();
    public static ObservableList<EstacaoReserva> listadd = FXCollections.observableArrayList();
    public static ObservableList<EstacaoReserva> listamul = FXCollections.observableArrayList();
    public static ObservableList<EstacaoReserva> listaload = FXCollections.observableArrayList();
    public static ObservableList<Registrador> listareg = FXCollections.observableArrayList();
    public static ObservableList<EstacaoReserva> listatabela = FXCollections.observableArrayList();
    public static ObservableList<Memoria> tabelamemoria = FXCollections.observableArrayList();

    public static ObservableList<String> instrucoes = FXCollections.observableArrayList();
    public static ObservableList<String> filaadd = FXCollections.observableArrayList();
    public static ObservableList<String> filamul = FXCollections.observableArrayList();
    public static ObservableList<String> filaload = FXCollections.observableArrayList();
    public static String[] memoria = new String[256];

    public static int programcounter = 1;
    public static int ciclo = 0;
    public static int intpass;
    public static int posicaofilaadd = -1;
    public static int posicaofilamul = -1;
    public static int posicaofilaload = -1;

    public static int numeroinstrucoes = 0;
    public static int numeroinstrucoesfilaadd = -1;
    public static int numeroinstrucoesfilamul = -1;
    public static int numeroinstrucoesfilaload = -1;

    public static Boolean branchprocessando = false;
    public static Boolean loadprocessando = false;

    public static Registrador r1 = new Registrador();
    public static Registrador r2 = new Registrador();
    public static Registrador r3 = new Registrador();
    public static Registrador r4 = new Registrador();
    public static Registrador r5 = new Registrador();
    public static Registrador r6 = new Registrador();
    public static Registrador r7 = new Registrador();
    public static Registrador r8 = new Registrador();
    public static Registrador zero = new Registrador();

    public static EstacaoReserva bradd1 = new EstacaoReserva();
    public static EstacaoReserva bradd2 = new EstacaoReserva();
    public static EstacaoReserva bradd3 = new EstacaoReserva();
    public static EstacaoReserva bradd4 = new EstacaoReserva();

    public static EstacaoReserva mul1 = new EstacaoReserva();
    public static EstacaoReserva mul2 = new EstacaoReserva();
    public static EstacaoReserva mul3 = new EstacaoReserva();
    public static EstacaoReserva mul4 = new EstacaoReserva();
    public static EstacaoReserva mul5 = new EstacaoReserva();
    public static EstacaoReserva mul6 = new EstacaoReserva();
    public static EstacaoReserva mul7 = new EstacaoReserva();
    public static EstacaoReserva mul8 = new EstacaoReserva();

    public static EstacaoReserva load1 = new EstacaoReserva();
    public static EstacaoReserva load2 = new EstacaoReserva();
    public static EstacaoReserva load3 = new EstacaoReserva();
    public static EstacaoReserva load4 = new EstacaoReserva();
    public static EstacaoReserva load5 = new EstacaoReserva();
    public static EstacaoReserva load6 = new EstacaoReserva();
    public static EstacaoReserva load7 = new EstacaoReserva();
    public static EstacaoReserva load8 = new EstacaoReserva();

    public static void initialize(){
        int i;
        load1.setNome("Load/Store1");load2.setNome("Load/Store2");load3.setNome("Load/Store3");load4.setNome("Load/Store4");load5.setNome("Load/Store5");load6.setNome("Load/Store6");load7.setNome("Load/Store7");load8.setNome("Load/Store8");
        mul1.setNome("Mul/Div1");mul2.setNome("Mul/Div2");mul3.setNome("Mul/Div3");mul4.setNome("Mul/Div4");mul5.setNome("Mul/Div5");mul6.setNome("Mul/Div6");mul7.setNome("Mul/Div7");mul8.setNome("Mul/Div8");
        bradd1.setNome("Add/Sub1");bradd2.setNome("Add/Sub2");bradd3.setNome("Add/Sub3");bradd4.setNome("Add/Sub4");
        r1.setNome("R1"); r2.setNome("R2"); r3.setNome("R3"); r4.setNome("R4"); r5.setNome("R5"); r6.setNome("R6"); r7.setNome("R7"); r8.setNome("R8");
        listadd.add(bradd1); listadd.add(bradd2); listadd.add(bradd3); listadd.add(bradd4);
        listamul.add(mul1); listamul.add(mul2); listamul.add(mul3); listamul.add(mul4); listamul.add(mul5); listamul.add(mul6); listamul.add(mul7); listamul.add(mul8);
        listaload.add(load1); listaload.add(load2); listaload.add(load3); listaload.add(load4); listaload.add(load5); listaload.add(load6); listaload.add(load7); listaload.add(load8);
        listareg.add(r1); listareg.add(r2); listareg.add(r3); listareg.add(r4); listareg.add(r5); listareg.add(r6); listareg.add(r7); listareg.add(r8);
        listatabela.addAll(listadd);
        listatabela.addAll(listamul);
        listatabela.addAll(listaload);
        for (i = 0; i < 256; i++){
            Memoria tempmem = new Memoria();
            tabelamemoria.add(tempmem);
            tabelamemoria.get(i).setPosicao(String.valueOf(i));
            tabelamemoria.get(i).setValor("0");
        }
        tabelamemoria.get(32).setValor("10");
        tabelamemoria.get(10).setValor("3");
    }
}
