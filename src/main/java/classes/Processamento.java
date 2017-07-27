package classes;

import static classes.Global.*;

/**
 * Created by marcelo on 25/07/17.
 */
public class Processamento {
    private int i;
    private int tempo;
    EstacaoReserva bancotemporario = new EstacaoReserva();
    Execucao executa = new Execucao();


    public void add() {
        for (i = 0; i < listadd.size(); i++) {
            bancotemporario = listadd.get(i);
            if ((bancotemporario.getQj().equals("")) && (bancotemporario.getQk().equals(""))) {
                if (bancotemporario.getBusy().equals("1") && (bancotemporario.getOp().equals("ADD"))) {
                    bancotemporario = listadd.get(i);
                    executa.add(bancotemporario);
                }
            }
        }
    }

    public void sub(){
        for (i = 0; i < listadd.size(); i++) {
            bancotemporario = listadd.get(i);
            if ((bancotemporario.getQj().equals("")) && (bancotemporario.getQk().equals(""))) {
                if ((bancotemporario.getBusy().equals("1")) && (bancotemporario.getOp().equals("SUB"))) {
                    bancotemporario = listadd.get(i);
                    executa.sub(bancotemporario);
                }
            }
        }
    }


    public void mul(){
        for (i = 0; i < listamul.size(); i++) {
            bancotemporario = listamul.get(i);
            if ((bancotemporario.getQj().equals("")) && (bancotemporario.getQk().equals(""))) {
                if ((bancotemporario.getBusy().equals("1")) && (bancotemporario.getOp().equals("MUL"))){
                    bancotemporario = listamul.get(i);
                    executa.mul(bancotemporario);
                }
            }
        }
    }

    public void div(){
        for (i = 0; i < listamul.size(); i++) {
            bancotemporario = listamul.get(i);
            if ((bancotemporario.getQj().equals("")) && (bancotemporario.getQk().equals(""))) {
                if ((bancotemporario.getBusy().equals("1")) && (bancotemporario.getOp().equals("DIV"))){
                    bancotemporario = listamul.get(i);
                    executa.div(bancotemporario);
                }
            }
        }
    }

    public void and() {
        for (i = 0; i < listadd.size(); i++) {
            bancotemporario = listadd.get(i);
            if ((bancotemporario.getQj().equals("")) && (bancotemporario.getQk().equals(""))) {
                if (bancotemporario.getBusy().equals("1") && (bancotemporario.getOp().equals("AND"))) {
                    bancotemporario = listadd.get(i);
                    executa.and(bancotemporario);
                }
            }
        }
    }

    public void or() {
        for (i = 0; i < listadd.size(); i++) {
            bancotemporario = listadd.get(i);
            if ((bancotemporario.getQj().equals("")) && (bancotemporario.getQk().equals(""))) {
                if (bancotemporario.getBusy().equals("1") && (bancotemporario.getOp().equals("OR"))) {
                    bancotemporario = listadd.get(i);
                    executa.or(bancotemporario);
                }
            }
        }
    }

    public void not() {
        for (i = 0; i < listadd.size(); i++) {
            bancotemporario = listadd.get(i);
            if ((bancotemporario.getQj().equals("")) && (bancotemporario.getQk().equals(""))) {
                if (bancotemporario.getBusy().equals("1") && (bancotemporario.getOp().equals("NOT"))) {
                    bancotemporario = listadd.get(i);
                    executa.not(bancotemporario);
                }
            }
        }
    }

    public void blt(){
        for (i = 0; i < listadd.size(); i++) {
            bancotemporario = listadd.get(i);
            if ((bancotemporario.getQj().equals("")) && (bancotemporario.getQk().equals(""))) {
                if ((bancotemporario.getBusy().equals("1")) && (bancotemporario.getOp().equals("BLT"))) {
                    bancotemporario = listadd.get(i);
                    executa.blt(bancotemporario);
                }
            }
        }
    }

    public void bgt(){
        for (i = 0; i < listadd.size(); i++) {
            bancotemporario = listadd.get(i);
            if ((bancotemporario.getQj().equals("")) && (bancotemporario.getQk().equals(""))) {
                if ((bancotemporario.getBusy().equals("1")) && (bancotemporario.getOp().equals("BGT"))) {
                    bancotemporario = listadd.get(i);
                    executa.bgt(bancotemporario);
                }
            }
        }
    }

    public void beq(){
        for (i = 0; i < listadd.size(); i++) {
            bancotemporario = listadd.get(i);
            if ((bancotemporario.getQj().equals("")) && (bancotemporario.getQk().equals(""))) {
                if ((bancotemporario.getBusy().equals("1")) && (bancotemporario.getOp().equals("BEQ"))) {
                    bancotemporario = listadd.get(i);
                    executa.beq(bancotemporario);
                }
            }
        }
    }

    public void jump(){
        for (i = 0; i < listadd.size(); i++) {
            bancotemporario = listadd.get(i);
            if ((bancotemporario.getQj().equals("")) && (bancotemporario.getQk().equals(""))) {
                if ((bancotemporario.getBusy().equals("1")) && (bancotemporario.getOp().equals("JUMP"))) {
                    bancotemporario = listadd.get(i);
                    executa.jump(bancotemporario);
                }
            }
        }
    }

    public void lw() {
        for (i = 0; i < listaload.size(); i++) {
            bancotemporario = listaload.get(i);
            if ((bancotemporario.getQj().equals("")) && (bancotemporario.getQk().equals(""))) {
                if ((bancotemporario.getBusy().equals("1")) && (bancotemporario.getOp().equals("LOAD"))) {
                    executa.lw(bancotemporario);
                }
            }
        }
    }

    public void sw(){
        for (i = 0; i < listaload.size(); i++) {
            bancotemporario = listaload.get(i);
            if ((bancotemporario.getQj().equals(""))) {
                if ((bancotemporario.getBusy().equals("1")) && (bancotemporario.getOp().equals("STORE"))) {
                    executa.sw(bancotemporario);
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
