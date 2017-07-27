package classes;

/**
 * Created by marcelo on 20/07/17.
 */
public class Registrador {

    private String nome;

    private String valor;

    private String processing;

    private String banco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getProcessing() {
        return processing;
    }

    public void setProcessing(String processing) {
        this.processing = processing;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Registrador() {
        this.processing = "0";
        this.valor = "0";
        this.banco = "";
    }
}
