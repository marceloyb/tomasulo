package classes;

/**
 * Created by marcelo on 20/07/17.
 */
public class Registrador {

    private String nome;

    private String valor;

    private String processing;

    private String estacao;

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

    public String getEstacao() {
        return estacao;
    }

    public void setEstacao(String estacao) {
        this.estacao = estacao;
    }

    public Registrador() {
        this.processing = "0";
        this.valor = "0";
        this.estacao = "";
    }
}
