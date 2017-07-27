package classes;

/**
 * Created by marcelo on 21/07/17.
 */
public class EstacaoReserva {

    private Integer pc;
    private Registrador r;
    private int tempo;
    private Integer resultado;
    private String nome;
    private String busy;
    private String op;
    private String vj;
    private String vk;
    private String qj;
    private String qk;
    private String address;

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }

    public Registrador getR() {
        return r;
    }

    public void setR(Registrador r) {
        this.r = r;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBusy() {
        return busy;
    }

    public void setBusy(String busy) {
        this.busy = busy;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getVj() {
        return vj;
    }

    public void setVj(String vj) {
        this.vj = vj;
    }

    public String getVk() {
        return vk;
    }

    public void setVk(String vk) {
        this.vk = vk;
    }

    public String getQj() {
        return qj;
    }

    public void setQj(String qj) {
        this.qj = qj;
    }

    public String getQk() {
        return qk;
    }

    public void setQk(String qk) {
        this.qk = qk;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPc() {
        return pc;
    }

    public void setPc(Integer pc) {
        this.pc = pc;
    }

    public EstacaoReserva(){
        this.setQj("");
        this.setQk("");
        this.setBusy("0");
        this.setResultado(null);
        this.setPc(null);
    }
}
