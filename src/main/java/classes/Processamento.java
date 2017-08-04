package classes;

import javafx.scene.control.Alert;

import static classes.Global.*;

/**
 * Created by marcelo on 25/07/17.
 */
public class Processamento {
    private int i;
    private int tempo;
    EstacaoReserva estacaotemporaria = new EstacaoReserva();
    Execucao executa = new Execucao();
    SetEstacao settemporario = new SetEstacao();


    public void add() {
        for (i = 0; i < listadd.size(); i++) {
            estacaotemporaria = listadd.get(i);
            if ((estacaotemporaria.getQj().equals("")) && (estacaotemporaria.getQk().equals(""))) {
                if (estacaotemporaria.getBusy().equals("1") && (estacaotemporaria.getOp().equals("ADD"))) {
                    estacaotemporaria = listadd.get(i);
                    executa.add(estacaotemporaria);
                }
            }
        }
    }

    public void sub(){
        for (i = 0; i < listadd.size(); i++) {
            estacaotemporaria = listadd.get(i);
            if ((estacaotemporaria.getQj().equals("")) && (estacaotemporaria.getQk().equals(""))) {
                if ((estacaotemporaria.getBusy().equals("1")) && (estacaotemporaria.getOp().equals("SUB"))) {
                    estacaotemporaria = listadd.get(i);
                    executa.sub(estacaotemporaria);
                }
            }
        }
    }


    public void mul(){
        for (i = 0; i < listamul.size(); i++) {
            estacaotemporaria = listamul.get(i);
            if ((estacaotemporaria.getQj().equals("")) && (estacaotemporaria.getQk().equals(""))) {
                if ((estacaotemporaria.getBusy().equals("1")) && (estacaotemporaria.getOp().equals("MUL"))){
                    estacaotemporaria = listamul.get(i);
                    executa.mul(estacaotemporaria);
                }
            }
        }
    }

    public void div(){
        for (i = 0; i < listamul.size(); i++) {
            estacaotemporaria = listamul.get(i);
            if ((estacaotemporaria.getQj().equals("")) && (estacaotemporaria.getQk().equals(""))) {
                if ((estacaotemporaria.getBusy().equals("1")) && (estacaotemporaria.getOp().equals("DIV"))){
                    if (estacaotemporaria.getVk().equals("0")) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Uma divisão por 0 foi detectada");
                        alert.setContentText("Estacao de reserva pertinente foi limpa");
                        alert.showAndWait();
                        settemporario.clearEstacao(estacaotemporaria.getNome());
                    }
                    else{
                        estacaotemporaria = listamul.get(i);
                        executa.div(estacaotemporaria);
                    }
                }
            }
        }
    }

    public void and() {
        for (i = 0; i < listadd.size(); i++) {
            estacaotemporaria = listadd.get(i);
            if ((estacaotemporaria.getQj().equals("")) && (estacaotemporaria.getQk().equals(""))) {
                if (estacaotemporaria.getBusy().equals("1") && (estacaotemporaria.getOp().equals("AND"))) {
                    estacaotemporaria = listadd.get(i);
                    executa.and(estacaotemporaria);
                }
            }
        }
    }

    public void or() {
        for (i = 0; i < listadd.size(); i++) {
            estacaotemporaria = listadd.get(i);
            if ((estacaotemporaria.getQj().equals("")) && (estacaotemporaria.getQk().equals(""))) {
                if (estacaotemporaria.getBusy().equals("1") && (estacaotemporaria.getOp().equals("OR"))) {
                    estacaotemporaria = listadd.get(i);
                    executa.or(estacaotemporaria);
                }
            }
        }
    }

    public void not() {
        for (i = 0; i < listadd.size(); i++) {
            estacaotemporaria = listadd.get(i);
            if ((estacaotemporaria.getQj().equals("")) && (estacaotemporaria.getQk().equals(""))) {
                if (estacaotemporaria.getBusy().equals("1") && (estacaotemporaria.getOp().equals("NOT"))) {
                    estacaotemporaria = listadd.get(i);
                    executa.not(estacaotemporaria);
                }
            }
        }
    }

    public void blt(){
        for (i = 0; i < listadd.size(); i++) {
            estacaotemporaria = listadd.get(i);
            if ((estacaotemporaria.getQj().equals("")) && (estacaotemporaria.getQk().equals(""))) {
                if ((estacaotemporaria.getBusy().equals("1")) && (estacaotemporaria.getOp().equals("BLT"))) {
                    estacaotemporaria = listadd.get(i);
                    executa.blt(estacaotemporaria);
                }
            }
        }
    }

    public void bgt(){
        for (i = 0; i < listadd.size(); i++) {
            estacaotemporaria = listadd.get(i);
            if ((estacaotemporaria.getQj().equals("")) && (estacaotemporaria.getQk().equals(""))) {
                if ((estacaotemporaria.getBusy().equals("1")) && (estacaotemporaria.getOp().equals("BGT"))) {
                    estacaotemporaria = listadd.get(i);
                    executa.bgt(estacaotemporaria);
                }
            }
        }
    }

    public void beq(){
        for (i = 0; i < listadd.size(); i++) {
            estacaotemporaria = listadd.get(i);
            if ((estacaotemporaria.getQj().equals("")) && (estacaotemporaria.getQk().equals(""))) {
                if ((estacaotemporaria.getBusy().equals("1")) && (estacaotemporaria.getOp().equals("BEQ"))) {
                    estacaotemporaria = listadd.get(i);
                    executa.beq(estacaotemporaria);
                }
            }
        }
    }

    public void jump(){
        for (i = 0; i < listadd.size(); i++) {
            estacaotemporaria = listadd.get(i);
            if ((estacaotemporaria.getQj().equals("")) && (estacaotemporaria.getQk().equals(""))) {
                if ((estacaotemporaria.getBusy().equals("1")) && (estacaotemporaria.getOp().equals("JUMP"))) {
                    estacaotemporaria = listadd.get(i);
                    executa.jump(estacaotemporaria);
                }
            }
        }
    }

    public void lw() {
        for (i = 0; i < listaload.size(); i++) {
            estacaotemporaria = listaload.get(i);
            if ((estacaotemporaria.getQj().equals("")) && (estacaotemporaria.getQk().equals(""))) {
                if ((estacaotemporaria.getBusy().equals("1")) && (estacaotemporaria.getOp().equals("LOAD"))) {
                    executa.lw(estacaotemporaria);
                }
            }
        }
    }

    public void sw(){
        for (i = 0; i < listaload.size(); i++) {
            estacaotemporaria = listaload.get(i);
            if ((estacaotemporaria.getTempo() >= 0) &&(estacaotemporaria.getOp() == "LOAD")) {
                loadprocessando = true;
            }
        }
        for (i = 0; i <listaload.size(); i++) {
            estacaotemporaria = listaload.get(i);
            if (loadprocessando == false) {
                if ((estacaotemporaria.getQj().equals(""))) {
                    if ((estacaotemporaria.getBusy().equals("1")) && (estacaotemporaria.getOp() == "STORE")) {
                        executa.sw(estacaotemporaria);
                    }
                }
            }
        }
    }

    public void processa(){
        add();
        sub();
        div();
        mul();
        blt();
        bgt();
        beq();
        jump();
        and();
        or();
        not();
        lw();
        sw();
    }

}
