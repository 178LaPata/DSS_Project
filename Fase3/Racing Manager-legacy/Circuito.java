
/**
 * Write a description of class Circuito here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

public class Circuito implements Serializable
{
    /* Variaveis instancia */
    private String nome;
    private float distancia;
    private int numvoltas;
    private List<CircuitoParte> turns;
    private int curvas;
    private int retas;
    private int chicanes;

    
    /* Construtores */
    public Circuito()
    {
        this.nome = "";
        this.distancia = 0;
        this.numvoltas = 0;
        this.turns= new ArrayList<>();
        this.curvas=0;
        this.retas=0;
        this.chicanes=0;

    }
    
    public Circuito(String n,float d, int v, List<CircuitoParte> cp, int cu, int ch, int r)
    {
        this.nome = n;
        this.distancia = d;
        this.numvoltas = v;
        this.turns = cp;
        this.curvas = cu;
        this.retas = r;
        this.chicanes = ch;
    }
    
    public Circuito(Circuito c)
    {
        this.nome = c.getNome();
        this.distancia = c.getDistancia();
        this.voltas = c.getVoltas();
        this.temposMedios = c.getTemposMedios();
        this.tempoDesvio = c.getTempoDesvio();
        this.tempoBox = c.getTempoBox();
        this.record = c.getRecord();
    }
    
    /* Gets e Sets */
    public String getNome()
    {
        return this.nome;
    }
    
    public float getDistancia() {return this.distancia;}
    
    public int getVoltas()
    {
        return this.numvoltas;
    }
    
    public void setNome(String n)
    {
        this.nome = n;
    }
    
    public void setDistancia(int d)
    {
        this.distancia = d;
    }
    
    public void setVoltas(int v)
    {
        this.numvoltas = v;
    }
    
    /* Metodos usuais */
    public Circuito clone()
    {
        return new Circuito(this);
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNome: ");sb.append(this.nome);
        sb.append("\nDistancia: ");sb.append(this.distancia);

        return sb.toString();
    }
    
    public boolean equals(Object o)
    {
       if(this == o)
       return true;
       
       if(o == null || this.getClass() != o.getClass())
       return false;
       
       Circuito c = (Circuito) o;
       return ( this.nome.equals(c.getNome()) &&
                this.distancia == c.getDistancia() &&
                this.voltas == c.getVoltas() &&
                //this.tempoMedio == c.getTempoMedio() &&
                this.tempoDesvio == c.getTempoDesvio() &&
                this.tempoBox == c.getTempoBox() &&
                this.record.equals(c.getRecord()));
    }
    
}
