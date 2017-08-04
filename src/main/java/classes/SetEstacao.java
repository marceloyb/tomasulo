package classes;

import static classes.Global.*;

/**
 * Created by marcelo on 24/07/17.
 */
public class SetEstacao {
    private Boolean clearadd;
    private Boolean clearmul;
    private Boolean clearload;
    private boolean use = false;
    Global g = new Global();
    private int i = 0;
    private String instrucao;
    private int check = 0;
    private Boolean cheio = false;
    private String qjreplace;
    private String qkreplace;

    public void clearEstacao(String nomebanco){
        for (i = 0; i < listatabela.size(); i++){
            if(listatabela.get(i).getNome().equals(nomebanco)){
                listatabela.get(i).setBusy("0");
                listatabela.get(i).setTempo(0);
                listatabela.get(i).setOp("");
                listatabela.get(i).setQj("");
                listatabela.get(i).setQk("");
                listatabela.get(i).setVj("");
                listatabela.get(i).setVk("");
                listatabela.get(i).setAddress("");
                listatabela.get(i).setPc(null);
            }
        }
    }

    public Boolean liberaBancoAdd() {
        clearadd = false;
        for (i = 0; i < listadd.size(); i++) {
            if (listadd.get(i).getTempo() < 0) {
                listadd.get(i).setBusy("0");
                listadd.get(i).setTempo(0);
                listadd.get(i).setOp("");
                listadd.get(i).setQj("");
                listadd.get(i).setQk("");
                listadd.get(i).setVj("");
                listadd.get(i).setVk("");
                listadd.get(i).setAddress("");
                listadd.get(i).setPc(null);
                clearadd = true;
            }
        }
        return clearadd;
    }

    public boolean liberaBancoMul() {
        clearmul = false;
        for (i = 0; i < listamul.size(); i++) {
            if (listamul.get(i).getTempo() < 0) {
                listamul.get(i).setBusy("0");
                listamul.get(i).setTempo(0);
                listamul.get(i).setOp("");
                listamul.get(i).setQj("");
                listamul.get(i).setQk("");
                listamul.get(i).setVj("");
                listamul.get(i).setVk("");
                listamul.get(i).setAddress("");
                clearmul = true;
            }
        }
        return clearmul;
    }

    public boolean liberaBancoLoad() {
        clearload = false;
        for (i = 0; i < listaload.size(); i++) {
            if (listaload.get(i).getTempo() < 0) {
                listaload.get(i).setBusy("0");
                listaload.get(i).setTempo(0);
                listaload.get(i).setOp("");
                listaload.get(i).setQj("");
                listaload.get(i).setQk("");
                listaload.get(i).setVj("");
                listaload.get(i).setVk("");
                listaload.get(i).setAddress("");
                clearload = true;
            }
        }
        return clearload;
    }

    public void replace(String nomedobanco, int valorconta){
        for (i = 0; i < listatabela.size(); i++){
            qjreplace = listatabela.get(i).getQj();
            qkreplace = listatabela.get(i).getQk();
            if (qjreplace.equals(nomedobanco)){
                listatabela.get(i).setQj("");
                listatabela.get(i).setVj(String.valueOf(valorconta));
            }
            if (qkreplace.equals(nomedobanco)){
                listatabela.get(i).setQk("");
                listatabela.get(i).setVk(String.valueOf(valorconta));
            }
        }
    }


    public Boolean cheioadd() {
        cheio = false;
        check = 0;
        for (i = 0; i < listadd.size(); i++) {
            if(listadd.get(i).getBusy().equals("1")){
                check++;
            }
            if ((i == 3) && (check == 4)){
                cheio = true;
            }
        }
        return cheio;
    }

    public Boolean cheiomul(){
        cheio = false;
        check = 0;
        for (i = 0; i < listamul.size(); i++) {
            if(listamul.get(i).getBusy().equals("1")){
                check++;
            }
            if ((i == 7) && (check == 8)){
                cheio = true;
            }
        }
        return cheio;
    }

    public Boolean cheioload(){
        cheio = false;
        check = 0;
        for (i = 0; i < listaload.size(); i++) {
            if(listaload.get(i).getBusy().equals("1")){
                check++;
            }
            if ((i == 7) && (check == 8)){
                cheio = true;
            }
        }
        return cheio;
    }

    public void add(Registrador r1, Registrador r2, Registrador r3){
        cheio = cheioadd();
        if (cheio == false) {
            for (i = 0; i < listadd.size(); i++) {
                if (listadd.get(i).getBusy().equals("0")) {
                    listadd.get(i).setBusy("1");
                    listadd.get(i).setTempo(5);
                    listadd.get(i).setOp("ADD");
                    listadd.get(i).setR(r1);

                    if (r2.getProcessing().equals("1")) {
                        listadd.get(i).setQj(r2.getEstacao());
                    } else {
                        listadd.get(i).setVj(r2.getValor());
                    }
                    if (r3.getProcessing().equals("1")) {
                        listadd.get(i).setQk(r3.getEstacao());
                    } else {
                        listadd.get(i).setVk(r3.getValor());
                    }
                    r1.setProcessing("1");
                    r1.setValor("");
                    r1.setEstacao(listadd.get(i).getNome());
                    break;
                }
            }
        }
        else{
            instrucao = Global.instrucoes.get(ciclo-1);
            Global.numeroinstrucoesfilaadd++;
            Global.filaadd.add(instrucao);
        }
    }

    public void addi(Registrador r1, Registrador r2, int valor) {
        cheio = cheioadd();
        if (cheio == false) {
            for (i = 0; i < listadd.size(); i++) {
                if (listadd.get(i).getBusy().equals("0")) {
                    listadd.get(i).setBusy("1");
                    listadd.get(i).setTempo(5);
                    listadd.get(i).setOp("ADD");
                    listadd.get(i).setR(r1);
                    if (r2.getProcessing().equals("1")) {
                        listadd.get(i).setQj(r2.getEstacao());
                    } else {
                        listadd.get(i).setVj(r2.getValor());
                    }
                    listadd.get(i).setVk(String.valueOf(valor));
                    r1.setProcessing("1");
                    r1.setValor("");
                    r1.setEstacao(listadd.get(i).getNome());
                    break;
                }
            }
        }
        else{
            instrucao = Global.instrucoes.get(ciclo-1);
            Global.filaadd.add(instrucao);
        }
    }

    public void sub(Registrador r1, Registrador r2, Registrador r3){
        cheio = cheioadd();
        if (cheio == false) {
            for (i = 0; i < listadd.size(); i++) {
                if (listadd.get(i).getBusy().equals("0")) {
                    listadd.get(i).setBusy("1");
                    listadd.get(i).setTempo(5);
                    listadd.get(i).setOp("SUB");
                    listadd.get(i).setR(r1);
                    if (r2.getProcessing().equals("1")) {
                        listadd.get(i).setQj(r2.getEstacao());
                    } else {
                        listadd.get(i).setVj(r2.getValor());
                    }
                    if (r3.getProcessing().equals("1")) {
                        listadd.get(i).setQk(r3.getEstacao());
                    } else {
                        listadd.get(i).setVk(r3.getValor());
                    }
                    r1.setProcessing("1");
                    r1.setValor("");
                    r1.setEstacao(listadd.get(i).getNome());
                    break;
                }
            }
        }
        else{
            instrucao = Global.instrucoes.get(ciclo-1);
            Global.filaadd.add(instrucao);
        }
    }

    public void subi(Registrador r1, Registrador r2, int valor){
        cheio = cheioadd();
        if (cheio == false) {
            for (i = 0; i < listadd.size(); i++) {
                if (listadd.get(i).getBusy().equals("0")) {
                    listadd.get(i).setBusy("1");
                    listadd.get(i).setTempo(5);
                    listadd.get(i).setOp("SUB");
                    listadd.get(i).setR(r1);
                    if (r2.getProcessing().equals("1")) {
                        listadd.get(i).setQj(r2.getEstacao());
                    } else {
                        listadd.get(i).setVj(r2.getValor());
                    }
                    listadd.get(i).setVk(String.valueOf(valor));
                    r1.setProcessing("1");
                    r1.setValor("");
                    r1.setEstacao(listadd.get(i).getNome());
                    break;
                }
            }
        }
        else{
            instrucao = Global.instrucoes.get(ciclo-1);
            Global.filaadd.add(instrucao);
        }
    }

    public void mul(Registrador r1, Registrador r2, Registrador r3){
        cheio = cheiomul();
        if (cheio == false) {
            for (i = 0; i < listamul.size(); i++) {
                if (listamul.get(i).getBusy().equals("0")) {
                    listamul.get(i).setBusy("1");
                    listamul.get(i).setTempo(10);
                    listamul.get(i).setOp("MUL");
                    listamul.get(i).setR(r1);
                    if (r2.getProcessing().equals("1")) {
                        listamul.get(i).setQj(r2.getEstacao());
                    } else {
                        listamul.get(i).setVj(r2.getValor());
                    }
                    if (r3.getProcessing().equals("1")) {
                        listamul.get(i).setQk(r3.getEstacao());
                    } else {
                        listamul.get(i).setVk(r3.getValor());
                    }
                    r1.setProcessing("1");
                    r1.setEstacao(listamul.get(i).getNome());
                    break;
                }
            }
        }
        else{
            instrucao = Global.instrucoes.get(ciclo-1);
            Global.filamul.add(instrucao);
        }
    }

    public void div(Registrador r1, Registrador r2, Registrador r3){
        cheio = cheiomul();
        if (cheio == false) {
            for (i = 0; i < listamul.size(); i++) {
                if (listamul.get(i).getBusy().equals("0")) {
                    listamul.get(i).setBusy("1");
                    listamul.get(i).setTempo(20);
                    listamul.get(i).setOp("DIV");
                    listamul.get(i).setR(r1);
                    if (r2.getProcessing().equals("1")) {
                        listamul.get(i).setQj(r2.getEstacao());
                    } else {
                        listamul.get(i).setVj(r2.getValor());
                    }
                    if (r3.getProcessing().equals("1")) {
                        listamul.get(i).setQk(r3.getEstacao());
                    } else {
                        listamul.get(i).setVk(r3.getValor());
                    }
                    r1.setProcessing("1");
                    r1.setEstacao(listamul.get(i).getNome());
                    break;
                }
            }
        }
        else{
            instrucao = Global.instrucoes.get(ciclo-1);
            Global.filamul.add(instrucao);
        }
    }

    public void and(Registrador r1, Registrador r2, Registrador r3){
        for (i = 0; i < listadd.size(); i++) {
            if (listadd.get(i).getBusy().equals("0")) {
                listadd.get(i).setBusy("1");
                listadd.get(i).setTempo(5);
                listadd.get(i).setR(r1);
                listadd.get(i).setOp("AND");
                if (r2.getProcessing().equals("1")) {
                    listadd.get(i).setQj(r2.getEstacao());
                } else {
                    listadd.get(i).setVj(r2.getValor());
                }
                if (r3.getProcessing().equals("1")) {
                    listadd.get(i).setQk(r3.getEstacao());
                } else {
                    listadd.get(i).setVk(r3.getValor());
                }
                r1.setProcessing("1");
                r1.setValor("");
                r1.setEstacao(listadd.get(i).getNome());
                break;
            }
        }
    }
    public void or(Registrador r1, Registrador r2, Registrador r3){
        for (i = 0; i < listadd.size(); i++) {
            if (listadd.get(i).getBusy().equals("0")) {
                listadd.get(i).setBusy("1");
                listadd.get(i).setTempo(5);
                listadd.get(i).setOp("OR");
                listadd.get(i).setR(r1);
                if (r2.getProcessing().equals("1")) {
                    listadd.get(i).setQj(r2.getEstacao());
                } else {
                    listadd.get(i).setVj(r2.getValor());
                }
                if (r3.getProcessing().equals("1")) {
                    listadd.get(i).setQk(r3.getEstacao());
                } else {
                    listadd.get(i).setVk(r3.getValor());
                }
                r1.setProcessing("1");
                r1.setValor("");
                r1.setEstacao(listadd.get(i).getNome());
                break;
            }
        }
    }
    public void not(Registrador r1, Registrador r2){
        for (i = 0; i < listadd.size(); i++) {
            if (listadd.get(i).getBusy().equals("0")) {
                listadd.get(i).setBusy("1");
                listadd.get(i).setTempo(5);
                listadd.get(i).setOp("NOT");
                listadd.get(i).setR(r1);
                if (r2.getProcessing().equals("1")) {
                    listadd.get(i).setQj(r2.getEstacao());
                } else {
                    listadd.get(i).setVj(r2.getValor());
                }
                r1.setProcessing("1");
                r1.setValor("");
                r1.setEstacao(listadd.get(i).getNome());
                break;
            }
        }
    }

    public void blt(Registrador r1, Registrador r2, int endereco){
        for (i = 0; i < listadd.size(); i++) {
            if (listadd.get(i).getBusy().equals("0")) {
                listadd.get(i).setBusy("1");
                listadd.get(i).setTempo(5);
                listadd.get(i).setOp("BLT");
                listadd.get(i).setAddress(String.valueOf(endereco));
                if (r1.getProcessing().equals("1")) {
                    listadd.get(i).setQj(r1.getEstacao());
                } else {
                    listadd.get(i).setVj(r1.getValor());
                }
                if (r2.getProcessing().equals("1")) {
                    listadd.get(i).setQk(r2.getEstacao());
                } else {
                    listadd.get(i).setVk(r2.getValor());
                }
                break;
            }
        }
    }

    public void bgt(Registrador r1, Registrador r2, int endereco){
        for (i = 0; i < listadd.size(); i++) {
            if (listadd.get(i).getBusy().equals("0")) {
                listadd.get(i).setBusy("1");
                listadd.get(i).setTempo(5);
                listadd.get(i).setOp("BGT");
                listadd.get(i).setAddress(String.valueOf(endereco));
                if (r1.getProcessing().equals("1")) {
                    listadd.get(i).setQj(r1.getEstacao());
                } else {
                    listadd.get(i).setVj(r1.getValor());
                }
                if (r2.getProcessing().equals("1")) {
                    listadd.get(i).setQk(r2.getEstacao());
                } else {
                    listadd.get(i).setVk(r2.getValor());
                }
                break;
            }
        }
    }

    public void beq(Registrador r1, Registrador r2, int endereco){
        for (i = 0; i < listadd.size(); i++) {
            if (listadd.get(i).getBusy().equals("0")) {
                listadd.get(i).setBusy("1");
                listadd.get(i).setTempo(5);
                listadd.get(i).setOp("BEQ");
                listadd.get(i).setAddress(String.valueOf(endereco));
                if (r1.getProcessing().equals("1")) {
                    listadd.get(i).setQj(r1.getEstacao());
                } else {
                    listadd.get(i).setVj(r1.getValor());
                }
                if (r2.getProcessing().equals("1")) {
                    listadd.get(i).setQk(r2.getEstacao());
                } else {
                    listadd.get(i).setVk(r2.getValor());
                }
                break;
            }
        }
    }

    public void jump(int endereco){
        for (i = 0; i < listadd.size(); i++) {
            if (listadd.get(i).getBusy().equals("0")) {
                listadd.get(i).setBusy("1");
                listadd.get(i).setTempo(5);
                listadd.get(i).setOp("JUMP");
                listadd.get(i).setAddress(String.valueOf(endereco));
                break;
            }
        }
    }

    public void lw(Registrador r1, int imediato, Registrador r2){
        for (i = 0; i < listaload.size(); i++) {
            if (listaload.get(i).getBusy().equals("0")) {
                loadprocessando = true;
                listaload.get(i).setBusy("1");
                listaload.get(i).setTempo(5);
                listaload.get(i).setOp("LOAD");
                listaload.get(i).setR(r1);
                listaload.get(i).setAddress(String.valueOf(imediato));
                if (r2.getProcessing().equals("1")) {
                    listaload.get(i).setQk(r2.getEstacao());
                } else {
                    listaload.get(i).setVk(r2.getValor());
                }
                break;
            }
        }
    }

    public void sw(Registrador r1,int imediato, Registrador r2){
        for (i = 0; i < listaload.size(); i++) {
            if (listaload.get(i).getBusy().equals("0")) {
                listaload.get(i).setBusy("1");
                listaload.get(i).setTempo(5);
                listaload.get(i).setOp("STORE");
                listaload.get(i).setR(r1);
                listaload.get(i).setAddress(String.valueOf(imediato));
                if (r1.getProcessing().equals("1")) {
                    listaload.get(i).setQj(r1.getEstacao());
                } else {
                    listaload.get(i).setVj(r1.getValor());
                }
                if (r2.getProcessing().equals("1")) {
                    listaload.get(i).setQk(r2.getEstacao());
                } else {
                    listaload.get(i).setVk(r2.getValor());
                }
                break;
            }
        }
    }

}
