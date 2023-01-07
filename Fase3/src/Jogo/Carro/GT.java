package Jogo.Carro;

/**
 * Write a description of class GT here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Map;
import java.util.Random;


public class GT extends Carro
{
    public GT()
    {
        super();
    }
    
    public GT(String marca, String modelo, int cilindrada, int potencia, int pac)
    {
        super(marca,modelo,cilindrada,potencia,pac,0);
    }
    
    public GT(GT p)
    {
        super(p);
    }
    
    public GT clone()
    {
        return new GT(this);
    }
    
    public boolean DNF(int volta, int totalvoltas, int clima, PlayCarro.MotorMode modoM)
    {
       double degMM=0;
       switch (modoM){
           case Conservador -> degMM=0.5;
           case Normal -> degMM=1;
           case Agressivo -> degMM=2;
       }
       Random rand=new Random();
       int x=rand.nextInt(70);
       //no maximo fiabilidade de 85%
       // 3000 cilindrada = 85% / 4500 cilindrada = 57%
       int fiabilidade = (int)((100000/super.getCilindrada())*2.55);
       int desgaste = (int)((volta+1)*0.5*degMM); //0.5% a cada volta
       return (x > (fiabilidade - desgaste));
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
        
        GT c = (GT) o;
        return ( super.equals(c));
    }
}
