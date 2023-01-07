/**
 * Write a description of class Corrida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;
import java.util.Random;
import java.util.Iterator;
import java.io.Serializable;

public class Corrida implements Serializable
{
   //variaveis de instancia
   private List<PlayCarro> listaCarros;
   private Circuito circuito;
   private Set<PlayCarro> resultados;
   private List<PlayCarro> primeiroVolta;
   private Map<PlayCarro, Integer> dnf;
   private int clima; //1-chove 0-sol
   
   //Construtores
   public Corrida()
   {
       this.listaCarros = new ArrayList<PlayCarro>();
       this.circuito = new Circuito();
       this.resultados = new TreeSet<PlayCarro>();
       //this.bestLap = new HashMap<Carro,Long>();
       this.primeiroVolta = new ArrayList<PlayCarro>();
       this.dnf = new HashMap<PlayCarro,Integer>();
       Random rand=new Random();
       int x=rand.nextInt(2);
       this.clima = x;
   }
   
   
   public Corrida(List<PlayCarro> l, Circuito c, Set<PlayCarro> r, List<PlayCarro> p, int clima)
   {
       this();
       for(PlayCarro car: l)
       {
           this.listaCarros.add(car);
       }
       this.circuito = c.clone();
       for(PlayCarro car: r)
       {
           this.resultados.add(car.clone());
       }
       for(PlayCarro x : p)
       {
           this.primeiroVolta.add(x.clone());
       }
       this.clima = clima;
   }
   
  
   
   public Corrida(Corrida c)
   {
       this.listaCarros = c.getCarros();
       this.circuito = c.getCircuito();
       this.resultados = c.getResultados();
       this.primeiroVolta = c.getPrimeiroVolta();
       this.dnf = c.getDNF();
       this.clima = c.getClima();
   }
   
   
   //Gets e sets
   public List<PlayCarro> getCarros()
   {
       ArrayList<PlayCarro> aux = new ArrayList<PlayCarro>();
       for(PlayCarro c: this.listaCarros)
       {
           aux.add(c.clone());
       }
       return aux;
   }
   
   public Circuito getCircuito() {
       return this.circuito.clone();
   }
   
   
   public Set<PlayCarro> getResultados()
   {
       TreeSet<PlayCarro> aux = new TreeSet<PlayCarro>();
       for(PlayCarro c : this.resultados)
       {
           aux.add(c.clone());
       }
       return aux;
   }
   
   public Map<PlayCarro,Integer> getDNF()
   {
       HashMap<PlayCarro,Integer> aux = new HashMap<PlayCarro,Integer>();
       for(PlayCarro c : this.dnf.keySet())
       {
           aux.put(c.clone(), this.dnf.get(c));
        }
        return aux;
   }
   
   public int getClima()
   {
       return this.clima;
   }
   
   
   public List<PlayCarro> getPrimeiroVolta()
   {
       ArrayList<PlayCarro> aux = new ArrayList<PlayCarro>();
       for(PlayCarro c : this.primeiroVolta)
       {
           aux.add(c.clone());
       }
       return aux;
   }
   
   
   public void setCircuito(Circuito c)
   {
       this.circuito = c.clone();
   }
   
   
   //Metodos
   
   public Corrida clone()
   {
       return new Corrida(this);
    }
   
   /**
     * Adicionar um carro á lista
     */
    public void adicionarCarro(PlayCarro c)
    {
        this.listaCarros.add(c.clone());
    }
    
    /**
     * adicionar lista de carros
     */
    public void adicionarCarro(List<PlayCarro> l)
    {
        for(PlayCarro c : l)
        {
            this.listaCarros.add(c.clone());
        }
    }
    
    /**
     * Numero total de carros
     */
    public int totalCarros()
    {
        return this.listaCarros.size();
    }
    
    /**
     * Remover um carro
     */
    public void removerCarro(PlayCarro c)
    {
        this.listaCarros.remove(c);
    }
    
    /**
     * Limpa a lista de carros
     */
    public void limpaListaCarros()
    {
      this.listaCarros.clear();
    }

    public boolean checkUltrapassagem(PlayCarro c1, PlayCarro c2, CircuitoParte cp){
        Random rand= new Random();
        boolean y= false;
        int x = rand.nextInt(100);
        switch (cp.getTipo()){
            case Curva:
                switch (cp.getGdu()) {
                    case Impossivel:
                        y= (90 > x * (c1.getPacAfin()));
                    case Dificl:
                        y= (75 > x * (c1.getPacAfin()));
                    case Possivel:
                        y = (50 > x * (c1.getPacAfin()));
                }
            case Reta:
                switch (cp.getGdu()){
                    case Impossivel:
                        y = (90 > x*(1 - c1.getPacAfin()));
                    case Dificl:
                        y = (75 > x*(1 - c1.getPacAfin()));
                    case Possivel:
                        y = (50 > x*(1 - c1.getPacAfin()));
                }
            case Chicane:
                y = (90 > x*c1.getPiloto().getSVA());
        }
        return y;
    }

    /**
     * Simula a corrida 
     */   
    public void simulaCorrida()
    {
        int voltas = this.circuito.getNumVoltas();
        long t_aux, t_volta;
        ArrayList<PlayCarro> aux = new ArrayList<PlayCarro>();
        HashMap<PlayCarro,Integer> temp = new HashMap<PlayCarro,Integer>();
        for(PlayCarro c : this.listaCarros)
        {
            aux.add(c.clone());
        }
        for(int i=0; i<voltas; i++)
        {
            for(PlayCarro c : aux)
            {
                if(!c.getDNF()) //verifica se o carro esta acidentado
                {
                    if(c.getCarro() instanceof SC){
                        if(c.getCarro().DNF(i,voltas,this.clima,c.getModoMotor(), c.getPiloto())){
                            c.setDNF(true);
                            temp.put(c.clone(),i);
                        }
                    }
                    if(c.getCarro().DNF(i, voltas, this.clima, c.getModoMotor())) //verifica se o carro tem acidente na volta
                    {
                        c.setDNF(true);
                        temp.put(c.clone(),i);
                    }
                    else
                    {
                       t_aux = c.getTempo(); //tempo feito ate ao momento
                       if(c instanceof Hibrido)
                       {
                           Hibrido h = (Hibrido)c;
                           int motor = h.getPotenciaMotorEletrico();
                           t_volta = c.tempoProximaVolta(this.circuito, 0, i) - motor*10;
                       }
                       else
                            t_volta = c.tempoProximaVolta(this.circuito, 0, i);
                       c.setTempo(t_aux +t_volta); 
                       //atualizar record
                    }
                }
            }
            this.primeiroVolta(i,aux); //metodo auxiliar para determinar o 1º a cada volta
        }
        for(PlayCarro c : aux)
        {
            if(!c.getDNF())
            {
                    this.resultados.add(c);
            }
        }
        this.dnf = temp;
    }
    
    /**
     * Metodo auxiliar privado para determinar o carro que vai em 1o a cada volta
     */
    private void primeiroVolta(int volta, List<PlayCarro> l)
    {
       Collections.sort(l);
       Iterator<PlayCarro> it = l.iterator();
       boolean f = false;
       PlayCarro c = null;
       while(it.hasNext() && !f)
       {
           c = it.next();
           if(!c.getDNF())
                f=true;
       }
       if(c!=null)
            this.primeiroVolta.add(volta,c.clone());
    }
    
    /**
     * Lista o 1o classificado em cada volta
     */
    private String printPrimeiroVolta()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("\n||||| Primeiro carro a cada volta e desistentes |||||");
        for(int i=0; i<this.primeiroVolta.size();i++)
        {
            sb.append("\n");
            sb.append(i+1);sb.append("ª Volta: ");
            sb.append(this.primeiroVolta.get(i).getCarro().getMarca());sb.append(" ");
            sb.append(this.primeiroVolta.get(i).getCarro().getModelo());sb.append(" ");
            sb.append(this.primeiroVolta.get(i).getPiloto().getNome());
            for(PlayCarro c : this.dnf.keySet())
            {
                if(this.dnf.get(c) == i)
                {
                    sb.append("\n\t");sb.append("Desistente: ");
                    sb.append(c.getCarro().getMarca());sb.append(" ");
                    sb.append(c.getCarro().getModelo());sb.append(" ");
                    sb.append(c.getPiloto().getNome());
                }
            }
        }
        return sb.toString();
    }
    
    /**
     * Lista os resultados da corrida.
     */ 
   public String printResultados()
   {
       StringBuilder sb = new StringBuilder();
       int i = 1;
       sb.append("\n||||| ");sb.append(this.circuito.getNome());sb.append(" |||||");
       sb.append("\n||||| ");sb.append("Voltas: ");sb.append(this.circuito.getNumVoltas());sb.append(" |||||");
       sb.append("\n||||| ");sb.append("Distancia: ");sb.append(this.circuito.getDistancia());sb.append("km | ");
       sb.append("Condição meteorológica: ");
       if(this.clima == 0)
        {
            sb.append("Sol");
        }
       else
        {
            sb.append("Chuva");;
        }
       sb.append(" |||||");
       sb.append("\n\n||||| Classificacoes da corrida |||||");
       for(PlayCarro c : this.resultados)
       {
            sb.append("\n");
            sb.append(i);sb.append("º: ");
            sb.append(TimeConverter.toTimeFormat(c.getTempo()));
            sb.append("\t Categoria: "); sb.append(c.getClass().getName()); sb.append(" ");
            sb.append("\t Carro: "); sb.append(c.getCarro().getMarca()); sb.append(" ");
            sb.append(c.getCarro().getModelo());
            sb.append("\t Piloto: ");sb.append(c.getPiloto().getNome());
            i++;
       }      
       for(int v=this.circuito.getNumVoltas();v>=0;v--)
       {
           for(PlayCarro c : this.dnf.keySet())
           {
                   if(v==this.dnf.get(c))
                   {
                   sb.append("\n");
                   sb.append(i);sb.append("º: ");
                   sb.append("DNF");
                   sb.append("\t Categoria: "); sb.append(c.getClass().getName()); sb.append(" ");
                   sb.append("\t Carro: "); sb.append(c.getCarro().getMarca()); sb.append(" ");
                   sb.append(c.getCarro().getModelo());
                   sb.append("\t Piloto: ");sb.append(c.getPiloto().getNome());
                   i++;
                }
           }
       }
       
       sb.append("\n\n||||| Classificacoes da corrida Hibridos |||||");
       i=1;
       for(PlayCarro c : this.resultados)
       {
            if(c instanceof Hibrido)
            {
            sb.append("\n");
            sb.append(i);sb.append("º: ");
            sb.append(TimeConverter.toTimeFormat(c.getTempo()));
            sb.append("\t Categoria: "); sb.append(c.getClass().getName()); sb.append(" ");
            sb.append("\t Carro: "); sb.append(c.getCarro().getMarca()); sb.append(" ");
            sb.append(c.getCarro().getModelo());
            sb.append("\t Piloto: ");sb.append(c.getPiloto().getNome());
            i++;
            }
       }      
       for(int v=this.circuito.getNumVoltas();v>=0;v--)
       {
           for(PlayCarro c : this.dnf.keySet())
           {
               if(c instanceof Hibrido)
               {
                   if(v==this.dnf.get(c))
                   {
                   sb.append("\n");
                   sb.append(i);sb.append("º: ");
                   sb.append("DNF");
                   sb.append("\t Categoria: "); sb.append(c.getClass().getName()); sb.append(" ");
                   sb.append("\t Carro: "); sb.append(c.getCarro().getMarca()); sb.append(" ");
                   sb.append(c.getCarro().getModelo());
                   sb.append("\t Piloto: ");sb.append(c.getPiloto().getNome());
                   i++;
                }
               }
           }
       }
       sb.append(this.printPrimeiroVolta());
       return sb.toString();
   }
   
   /**
    * Lista de Acidentados DNF
    */
   public String printDNF()
   {
       StringBuilder sb = new StringBuilder();
       sb.append("Espetados!!!");
       for(PlayCarro c : this.dnf.keySet())
       {
           sb.append("\n").append(c.getCarro().getMarca()).append(" \t\tVolta: ").append(this.dnf.get(c));
       }
       return sb.toString();
   }
   
   /**
    * Lista de participantes da corrida
    */
   public String listaCarrosParticipantes()
   {
       StringBuilder sb = new StringBuilder();
       int i = 1;
       for(PlayCarro c : this.listaCarros)
       {
           sb.append("\n");
           sb.append(i);sb.append(" - ");sb.append(c.getCarro().getMarca());sb.append(" ");sb.append(c.getCarro().getModelo());
           sb.append("\t ");sb.append(c.getPiloto().getNome());sb.append("\t ");sb.append(c.getClass().getName());
           i++;
       }
       return sb.toString();
   }
}
