package Jogo.Extra;
import Jogo.Carro.*;

public class CircuitoParte {
    //Variáveis de Instância
    private int id;
    enum GDU{
        Possivel, Dificl, Impossivel, Undefined
    }
    private GDU gdu;
    enum TipoParte{
        Reta,Curva,Chicane,Undefined
    }
    private TipoParte tipo;

    // Construtores
    public CircuitoParte(){
        this.id = 0;
        this.gdu = GDU.Undefined;
        this.tipo = TipoParte.Undefined;
    }

    public CircuitoParte(int id, GDU gdu, TipoParte tipo){
        this.id=id;
        this.gdu=gdu;
        this.tipo=tipo;
    }

    public CircuitoParte(CircuitoParte p){
        this.id = p.getId();
        this.gdu = p.getGdu();
        this.tipo = p.getTipo();
    }

    //Gets e Sets
    public int getId() {return this.id;}
    public GDU getGdu() {return this.gdu;}
    public TipoParte getTipo() {return this.tipo;}
    public void setId(int id) {this.id=id;}
    public void setTipo(TipoParte tipo) {this.tipo = tipo;}
    public void setGdu(GDU gdu) {this.gdu = gdu;}

    //Métodos
    public CircuitoParte clone() {return  new CircuitoParte(this);}

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nID: ");sb.append(this.id);
        sb.append("\nGDU: ");sb.append(this.gdu);
        sb.append("\nTipo: ");sb.append(this.tipo);
        return sb.toString();
    }

}
