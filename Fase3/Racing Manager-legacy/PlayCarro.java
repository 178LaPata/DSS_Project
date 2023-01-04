public class PlayCarro implements Comparable<PlayCarro>{
    //Variáveis de instância
    private Carro car;
    private int pacafin;
    private boolean dnf;
    private int afinsrestantes;
    private int tempo;
    enum MotorMode {
        Normal, Agressivo, Conservador, Undefined
    }
    MotorMode modomotor;
    enum TPneus{
        Macio, Duro, Chuva, Undefined
    }
    TPneus pneus;

    // Construtores
    public PlayCarro(Carro car){
        this.car = car;
        this.pacafin = 0;
        this.dnf = false;
        this.afinsrestantes = 0;
        this.tempo = 0;
        this.modomotor = MotorMode.Undefined;
        this.pneus = TPneus.Undefined;
    }


     public int compareTo(Carro c)
     {
     if(this.tempo < c.getTempo())
     return -1;
     if(this.tempo > c.getTempo())
     return 1;
     else
     return 0;
     }

     //Outros metodos
     /**
     * Tempo em milisegundos de uma volta
     */
    /*public long tempoProximaVolta(Circuito c, int clima, int volta)
    {
        Piloto p1 = this.getEquipa().getPiloto1();
        Piloto p2 = this.getEquipa().getPiloto2();
        Map<String,Long> aux = c.getTemposMedios();
        long t_medio = aux.get(this.getClass().getName());
        long t_chuva = c.getTempoDesvio();
        long minimum = 0;
        long maximum = 5000;
        long fator_sorte = minimum + Double.valueOf(Math.random()*(maximum-minimum)).intValue();
        long maximum_chuva = 2000;
        long fator_sorte_chuva= minimum + Double.valueOf(Math.random()*(maximum_chuva-minimum)).intValue();

        if(volta<(c.getVoltas()/2))
        {
            /* usa piloto 1
            return (t_medio + ((this.getCilindrada()/this.getPotencia())-p1.getQualidade())*1000) - fator_sorte
                    + (clima*(t_chuva - p1.getQualidadeChuva()*1000)) - fator_sorte_chuva;
        }
        else
        {
            /*usa piloto 2
            if(volta == (c.getVoltas()/2))
            {
                return (t_medio + ((this.getCilindrada()/this.getPotencia())-p2.getQualidade())*1000) - fator_sorte
                    + (clima*(t_chuva - p2.getQualidadeChuva()*1000)) - fator_sorte_chuva + c.getTempoBox();
            }
            else
            return (t_medio + ((this.getCilindrada()/this.getPotencia())-p2.getQualidade())*1000) - fator_sorte
                    + (clima*(t_chuva - p2.getQualidadeChuva()*1000)) - fator_sorte_chuva;
        }
    }
    */
    /**
     * define se o carro desiste (true desiste, false continua em prova)
    public  boolean DNF(int volta,int totalvoltas,int clima);
    */
}

