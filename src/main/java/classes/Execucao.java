package classes;

import static classes.Global.branchprocessando;
import static classes.Global.listaload;
import static classes.Global.tabelamemoria;

/**
 * Created by marcelo on 25/07/17.
 */
public class Execucao {
    private int tempo;
    private int i;
    private int operando1, operando2;
    private Registrador regtemp;
    private EstacaoReserva bancotemp;
    private int valorendereco;
    SetEstacao setbancotemp = new SetEstacao();

    public void add(EstacaoReserva banco) {
        tempo = banco.getTempo();
        banco.setTempo(tempo - 1);
        if (tempo == 0) {
            regtemp = banco.getR();
            operando1 = Integer.valueOf(banco.getVj());
            operando2 = Integer.valueOf(banco.getVk());
            operando1 = operando1 + operando2;
            regtemp.setBanco("");
            regtemp.setValor(String.valueOf(operando1));
            regtemp.setProcessing("0");
            banco.setResultado(operando1);
            setbancotemp.replace(banco.getNome(), operando1);
        }
    }

    public void sub(EstacaoReserva banco) {
        tempo = banco.getTempo();
        banco.setTempo(tempo - 1);
        if (tempo == 0) {
            regtemp = banco.getR();
            operando1 = Integer.valueOf(banco.getVj());
            operando2 = Integer.valueOf(banco.getVk());
            operando1 = operando1 - operando2;
            regtemp.setBanco("");
            regtemp.setValor(String.valueOf(operando1));
            regtemp.setProcessing("0");
            banco.setResultado(operando1);
            setbancotemp.replace(banco.getNome(), operando1);
        }
    }


    public void mul(EstacaoReserva banco) {
        tempo = banco.getTempo();
        banco.setTempo(tempo - 1);
        if (tempo == 0) {
            regtemp = banco.getR();
            operando1 = Integer.valueOf(banco.getVj());
            operando2 = Integer.valueOf(banco.getVk());
            operando1 = operando1 * operando2;
            regtemp.setBanco("");
            regtemp.setValor(String.valueOf(operando1));
            regtemp.setProcessing("0");
            banco.setResultado(operando1);
            setbancotemp.replace(banco.getNome(), operando1);
        }
    }

    public void div(EstacaoReserva banco) {
        tempo = banco.getTempo();
        banco.setTempo(tempo - 1);
        if (tempo == 0) {
            regtemp = banco.getR();
            operando1 = Integer.valueOf(banco.getVj());
            operando2 = Integer.valueOf(banco.getVk());
            operando1 = operando1 / operando2;
            regtemp.setBanco("");
            regtemp.setValor(String.valueOf(operando1));
            regtemp.setProcessing("0");
            banco.setResultado(operando1);
            setbancotemp.replace(banco.getNome(), operando1);
        }
    }

    public void and(EstacaoReserva banco) {
        tempo = banco.getTempo();
        banco.setTempo(tempo - 1);
        if (tempo == 0) {
            regtemp = banco.getR();
            operando1 = Integer.valueOf(banco.getVj());
            operando2 = Integer.valueOf(banco.getVk());
            operando1 = operando1 & operando2;
            regtemp.setBanco("");
            regtemp.setValor(String.valueOf(operando1));
            regtemp.setProcessing("0");
            banco.setResultado(operando1);
            setbancotemp.replace(banco.getNome(), operando1);
        }

    }

    public void or(EstacaoReserva banco) {
        tempo = banco.getTempo();
        banco.setTempo(tempo - 1);
        if (tempo == 0) {
            regtemp = banco.getR();
            operando1 = Integer.valueOf(banco.getVj());
            operando2 = Integer.valueOf(banco.getVk());
            operando1 = operando1 | operando2;
            regtemp.setBanco("");
            regtemp.setValor(String.valueOf(operando1));
            regtemp.setProcessing("0");
            banco.setResultado(operando1);
            setbancotemp.replace(banco.getNome(), operando1);
        }

    }

    public void not(EstacaoReserva banco) {
        tempo = banco.getTempo();
        banco.setTempo(tempo - 1);
        if (tempo == 0) {
            regtemp = banco.getR();
            operando1 = Integer.valueOf(banco.getVj());
            operando1 = ~operando1;
            regtemp.setBanco("");
            regtemp.setValor(String.valueOf(operando1));
            regtemp.setProcessing("0");
            banco.setResultado(operando1);
            setbancotemp.replace(banco.getNome(), operando1);
        }
    }

    public void load() {
        for (i = 0; i < listaload.size(); i++) {
            if (listaload.get(i).getBusy().equals("1")) {
                tempo = listaload.get(i).getTempo();
            }
        }
    }

    public void blt(EstacaoReserva banco) {
        tempo = banco.getTempo();
        banco.setTempo(tempo - 1);
        if (tempo == 0) {
            operando1 = Integer.valueOf(banco.getVj());
            operando2 = Integer.valueOf(banco.getVk());
            if (operando1 < operando2) {
                Global.programcounter = Integer.valueOf(banco.getAddress());
                branchprocessando = false;
            }
        }
    }

    public void bgt(EstacaoReserva banco) {
        tempo = banco.getTempo();
        banco.setTempo(tempo - 1);
        if (tempo == 0) {
            operando1 = Integer.valueOf(banco.getVj());
            operando2 = Integer.valueOf(banco.getVk());
            if (operando1 > operando2) {
                Global.programcounter = Integer.valueOf(banco.getAddress());
                branchprocessando = false;
            }
        }
    }

    public void beq(EstacaoReserva banco) {
        tempo = banco.getTempo();
        banco.setTempo(tempo - 1);
        if (tempo == 0) {
            operando1 = Integer.valueOf(banco.getVj());
            operando2 = Integer.valueOf(banco.getVk());
            if (operando1 == operando2) {
                Global.programcounter = Integer.valueOf(banco.getAddress());
                branchprocessando = false;
            }
        }
    }

    public void jump(EstacaoReserva banco) {
        tempo = banco.getTempo();
        banco.setTempo(tempo - 1);
        if (tempo == 0) {
            Global.programcounter = Integer.valueOf(banco.getAddress());
            branchprocessando = false;
        }
    }

    public void lw(EstacaoReserva banco) {
        tempo = banco.getTempo();
        banco.setTempo(tempo - 1);
        if (tempo == 0) {
            regtemp = banco.getR();
            operando1 = Integer.valueOf(banco.getAddress());
            operando2 = Integer.valueOf(banco.getVk());
            operando1 = operando1 + operando2;
            regtemp.setBanco("");
            regtemp.setValor(tabelamemoria.get(operando1).getValor());
            regtemp.setProcessing("0");
            banco.setResultado(Integer.valueOf(tabelamemoria.get(operando1).getValor()));
            setbancotemp.replace(banco.getNome(), Integer.valueOf(tabelamemoria.get(operando1).getValor()));
        }
    }

    public void sw(EstacaoReserva banco) {
        tempo = banco.getTempo();
        banco.setTempo(tempo - 1);
        if (tempo == 0) {
            regtemp = banco.getR();
            operando1 = Integer.valueOf(banco.getAddress());
            operando2 = Integer.valueOf(banco.getVk());
            operando1 = operando1 + operando2;
            regtemp.setBanco("");
            regtemp.getValor();
            regtemp.setProcessing("0");
            tabelamemoria.get(operando1).setValor(regtemp.getValor());
            setbancotemp.replace(banco.getNome(), Integer.valueOf(regtemp.getValor()));

        }
    }
}