package Jogo.Carro;
import Jogo.Extra.*;
    
/**
 * Write a description of class PC1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;

public class PC1 extends Carro
{
    public PC1()
    {
        super();
    }
    
    public PC1(String marca, String modelo, int cilindrada, int potencia, int pac)
    {
        super(marca,modelo,cilindrada,potencia,pac,85);
    }
    
    public PC1(PC1 p)
    {
        super(p);
    }
    
    public PC1 clone()
    {
        return new PC1(this);
    }
    
    public boolean DNF(int volta, int totalvoltas, int clima, PlayCarro.MotorMode modoM)
    {
        double degMM=0;
        switch (modoM){
            case Conservador -> degMM=1.2;
            case Normal -> degMM=1;
            case Agressivo -> degMM=0.8;
        }
       Random rand=new Random();
       int x=rand.nextInt(87);
       return (x > (super.getFiabilidade()*degMM));
       //return false;
    }

    public boolean DNF(int volta, int totalvoltas, int clima, PlayCarro.MotorMode modoM,Piloto p) {
        return false;
    }

    public boolean equals(Object o)
    {
        if(this==o)
        return true;
        
        if(o==null || this.getClass()!=o.getClass())
        return false;
        
        PC1 c = (PC1) o;
        return ( super.equals(c));
    }
}
