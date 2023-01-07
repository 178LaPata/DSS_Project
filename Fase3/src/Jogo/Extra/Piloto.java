package Jogo.Extra;

import java.io.Serializable;

public class Piloto implements Serializable
{
    //Variaveis de instancia
    private int idPiloto;
    private String nome;
    private int sva;
    private int cts;


    //Construtores
    public Piloto()
    {
        this.idPiloto = 0;
        this.nome = "";
        this.sva = 0;
        this.cts = 0;
    }
    
    public Piloto(int idPiloto, String nome, int svaP, int ctsP)
    {   
        this.idPiloto = idPiloto; 
        this.nome = nome;
        this.sva = svaP;
        this.cts = ctsP;
    }
    
    public Piloto(Piloto p)
    {  
        this.idPiloto = p.getIdPiloto();
        this.nome = p.getNome();
        this.sva = p.getSVA();
        this.cts = p.getCTS();
    }
    
    //Gets e Sets
    public int getIdPiloto()
    {
        return this.idPiloto;
    }

    public String getNome()
    {
        return this.nome;
    }

    public int getSVA()
    {
        return this.sva;
    }
    
    public int getCTS()
    {
        return this.cts;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setSVA(int q)
    {
        this.sva = q;
    }
    
    public void setCTS(int q)
    {
        this.cts = q;
    }

    //Metodos usuais
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNome: "); sb.append(this.nome);
        sb.append("\tValor de Segurança vs. Agressividade: ");sb.append(this.sva);
        sb.append("\tValor de Chuva vs Tempo Seco: ");sb.append(this.cts);
        return sb.toString();
    }
    
    public Piloto clone()
    {
        return new Piloto(this);
    }
    
    public boolean equals(Object o)
    {
        if(this == o)
        return true;
        
        if((o == null) || (this.getClass() != o.getClass()))
        return false;
        
        Piloto p = (Piloto) o;
        return (this.nome.equals(p.getNome()) && 
                this.sva==p.getSVA() &&
                this.cts==p.getCTS());
    }
}
