package client;

public class User {
    private String nome;
    private String cognome;
    private int eta;

    public User(String nome, String cognome, int eta){
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public User(){
        this.nome = "";
        this.cognome = "";
        this.eta = 0;
    }

    public String getCognome() {
        return cognome;
    }
    public int getEta() {
        return eta;
    }
    public String getNome() {
        return nome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEta(int eta) {
        this.eta = eta;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Nome:"+nome+",Cognome:"+cognome+",Eta:"+eta+";";
    }
}
