package classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by marcelo on 24/07/17.
 */
public class Tradutor {
    private String operacao;
    private String reg1;
    private String endereco;
    Registrador operando1 = new Registrador();
    Registrador operando2 = new Registrador();
    Registrador operando3 = new Registrador();
    Registrador reg = new Registrador();
    SetEstacao ex = new SetEstacao();
    private int imediato;
    private int ciclo;


    ObservableList<Registrador> listareg = FXCollections.observableArrayList();

    public BufferedReader AbreArq() {
        FileReader arq = null;
        File file = new File("instrucoes/instrucoes.txt");
        try {
            arq = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader lerArq = new BufferedReader(arq);
        return lerArq;

    }

    public Registrador DecodificaReg(String reg){
        Registrador retorno = new Registrador();
        switch (reg){
            case "r1":
                retorno = Global.r1;
                break;
            case "r2":
                retorno = Global.r2;
                break;
            case "r3":
                retorno = Global.r3;
                break;
            case "r4":
                retorno = Global.r4;
                break;
            case "r5":
                retorno = Global.r5;
                break;
            case "r6":
                retorno = Global.r6;
                break;
            case "r7":
                retorno = Global.r7;
                break;
            case "r8":
                retorno = Global.r8;
                break;
            case "zero":
                retorno = Global.zero;
                break;
            default:
                Global.intpass = Integer.valueOf(reg);
        }
        return retorno;
    }


    public void LeToken(String linha) {
        BufferedReader lerArq = null;
        lerArq = AbreArq();
        if (linha != null) {
                StringTokenizer st = new StringTokenizer(linha);
                if (st.hasMoreTokens()) {
                    this.operacao = st.nextToken(",");
                }
                switch (operacao) {
                    case "add":
                        listareg = FXCollections.observableArrayList();
                        while (st.hasMoreTokens()) {
                            this.reg1 = st.nextToken(",");
                            reg = DecodificaReg(reg1);
                            listareg.add(reg);
                        }
                        operando1 = listareg.get(0);
                        operando2 = listareg.get(1);
                        operando3 = listareg.get(2);
                        ex.add(operando1, operando2, operando3);
                        break;
                    case "addi":
                        listareg = FXCollections.observableArrayList();
                        while (st.hasMoreTokens()) {
                            this.reg1 = st.nextToken(",");
                            reg = DecodificaReg(reg1);
                            listareg.add(reg);
                        }
                        operando1 = listareg.get(0);
                        operando2 = listareg.get(1);
                        imediato = Global.intpass;
                        ex.addi(operando1, operando2, imediato);
                        break;
                    case "sub":
                        while (st.hasMoreTokens()) {
                            this.reg1 = st.nextToken(",");
                            reg = DecodificaReg(reg1);
                            listareg.add(reg);
                        }
                        operando1 = listareg.get(0);
                        operando2 = listareg.get(1);
                        operando3 = listareg.get(2);
                        ex.sub(operando1, operando2, operando3);
                        break;
                    case "subi":
                        while (st.hasMoreTokens()) {
                            this.reg1 = st.nextToken(",");
                            reg = DecodificaReg(reg1);
                            listareg.add(reg);
                        }
                        operando1 = listareg.get(0);
                        operando2 = listareg.get(1);
                        imediato = Global.intpass;
                        ex.subi(operando1, operando2, imediato);
                        break;
                    case "mul":
                        while (st.hasMoreTokens()) {
                            this.reg1 = st.nextToken(",");
                            reg = DecodificaReg(reg1);
                            listareg.add(reg);
                        }
                        operando1 = listareg.get(0);
                        operando2 = listareg.get(1);
                        operando3 = listareg.get(2);
                        ex.mul(operando1, operando2, operando3);
                        break;
                    case "div":
                        while (st.hasMoreTokens()) {
                            this.reg1 = st.nextToken(",");
                            reg = DecodificaReg(reg1);
                            listareg.add(reg);
                        }
                        operando1 = listareg.get(0);
                        operando2 = listareg.get(1);
                        operando3 = listareg.get(2);
                        ex.div(operando1, operando2, operando3);
                        break;
                    case "and":
                        while (st.hasMoreTokens()) {
                            this.reg1 = st.nextToken(",");
                            reg = DecodificaReg(reg1);
                            listareg.add(reg);
                        }
                        operando1 = listareg.get(0);
                        operando2 = listareg.get(1);
                        operando3 = listareg.get(2);
                        ex.and(operando1, operando2, operando3);
                        break;
                    case "or":
                        while (st.hasMoreTokens()) {
                            this.reg1 = st.nextToken(",");
                            reg = DecodificaReg(reg1);
                            listareg.add(reg);
                        }
                        operando1 = listareg.get(0);
                        operando2 = listareg.get(1);
                        operando3 = listareg.get(2);
                        ex.or(operando1, operando2, operando3);
                        break;
                    case "not":
                        while (st.hasMoreTokens()) {
                            this.reg1 = st.nextToken(",");
                            reg = DecodificaReg(reg1);
                            listareg.add(reg);
                        }
                        operando1 = listareg.get(0);
                        operando2 = listareg.get(1);
                        ex.not(operando1, operando2);
                        break;
                    case "blt":
                        while (st.hasMoreTokens()) {
                            this.reg1 = st.nextToken(",");
                            reg = DecodificaReg(reg1);
                            listareg.add(reg);
                        }
                        Global.branchprocessando = true;
                        operando1 = listareg.get(0);
                        operando2 = listareg.get(1);
                        imediato = Global.intpass;
                        ex.blt(operando1, operando2, imediato);
                        break;
                    case "bgt":
                        while (st.hasMoreTokens()) {
                            this.reg1 = st.nextToken(",");
                            reg = DecodificaReg(reg1);
                            listareg.add(reg);
                        }
                        Global.branchprocessando = true;
                        operando1 = listareg.get(0);
                        operando2 = listareg.get(1);
                        imediato = Global.intpass;
                        ex.bgt(operando1, operando2, imediato);
                        break;
                    case "beq":
                        while (st.hasMoreTokens()) {
                            this.reg1 = st.nextToken(",");
                            reg = DecodificaReg(reg1);
                            listareg.add(reg);
                        }
                        Global.branchprocessando = true;
                        operando1 = listareg.get(0);
                        operando2 = listareg.get(1);
                        imediato = Global.intpass;
                        ex.beq(operando1, operando2, imediato);
                        break;
                    case "jump":
                        Global.branchprocessando = true;
                        endereco = st.nextToken(",");
                        ex.jump(Integer.valueOf(endereco));
                        break;
                    case "lw":
                        while (st.hasMoreTokens()) {
                            this.reg1 = st.nextToken(",");
                            reg = DecodificaReg(reg1);
                            listareg.add(reg);
                        }
                        operando1 = listareg.get(0);
                        operando2 = listareg.get(1);
                        imediato = Global.intpass;
                        ex.lw(operando1, imediato, operando2);

                        break;
                    case "sw":
                        while (st.hasMoreTokens()) {
                            this.reg1 = st.nextToken(",");
                            reg = DecodificaReg(reg1);
                            listareg.add(reg);
                        }
                        operando1 = listareg.get(0);
                        operando2 = listareg.get(1);
                        imediato = Global.intpass;
                        ex.sw(operando1, imediato,operando2);
                        break;
                    default:
                        break;
                }
            listareg.clear();
        }

    }
    public void ArmazenaInstrucao(){
        BufferedReader lerArq = null;
        lerArq = AbreArq();
        String linha = null;
        try{
            linha = lerArq.readLine();
            do{
                Global.numeroinstrucoes++;
                Global.instrucoes.add(linha);
                linha = lerArq.readLine();
            }while (linha != null);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
