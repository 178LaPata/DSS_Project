package Jogo.Carro;
import Jogo.Extra.*;

import java.util.Map;

public class PlayCarro implements Comparable<PlayCarro>{
    //Variáveis de instância
    private Carro car;
    private Piloto driver;
    private int pacafin;
    private boolean dnf;
    private int afinsrestantes;
    private long tempo;
    enum MotorMode {
        Normal, Agressivo, Conservador, Undefined
    }
    private MotorMode modomotor;
    enum TPneus{
        Macio, Duro, Chuva, Undefined
    }
    private TPneus pneus;

    // Construtores
    public PlayCarro(Carro car,Piloto driver){
        this.car = car;
        this.driver = driver;
        this.pacafin = 0;
        this.afinsrestantes = 0;
        this.tempo = 0;
        this.modomotor = MotorMode.Undefined;
        this.pneus = TPneus.Undefined;
        this.dnf = false;
    }

    public PlayCarro(Carro car, Piloto driver, int pacafin, int afinsrestantes, long tempo, MotorMode modomotor, TPneus pneus, boolean DNF){
        this.car = car;
        this.driver = driver;
        this.pacafin = pacafin;
        this.afinsrestantes = afinsrestantes;
        this.tempo = tempo;
        this.modomotor = modomotor;
        this.pneus = pneus;
        this.dnf = DNF;
    }

    public PlayCarro(PlayCarro c){
        this.car = getCarro();
        this.driver = getPiloto();
        this.pacafin = getPacAfin();
        this.afinsrestantes = getAfinsRestantes();
        this.tempo = getTempo();
        this.modomotor = getModoMotor();
        this.pneus = getPneus();
        this.dnf = getDNF();

    }

    // Gets e Sets
    public Carro getCarro() 
    {
        return this.car;
    }

    public Piloto getPiloto() 
    {
        return this.driver;
    }

    public int getPacAfin() 
    {
        return this.pacafin;
    }

    public int getAfinsRestantes() 
    {
        return this.afinsrestantes;
    }

    public long getTempo() {
        return this.tempo;
    }

    public MotorMode getModoMotor() {
        return this.modomotor;
    }

    public TPneus getPneus() {
        return this.pneus;
    }

    public boolean getDNF() {
        return this.dnf;
    }

    public void setCarro(Carro car) {
        this.car = car;
    }

    public void setPacAfin(int pacafin) {
        this.pacafin = pacafin;
    }

    public void setAfinsRestantes(int afinsrestantes) {
        this.afinsrestantes = afinsrestantes;
    }

    public void setTempo(long tempo) {
        this.tempo = tempo;
    }

    public void setModoMotor (MotorMode modomotor) {
        this.modomotor = modomotor;
    }

    public void setPneus (TPneus pneus) {
        this.pneus = pneus;
    }

    public void setDNF (boolean dnf) {
        this.dnf = dnf;
    }

    public PlayCarro clone(){
        return new PlayCarro(this);
    }

    public int compareTo(PlayCarro c) {
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
    public long tempoProximaVolta(Circuito c, int clima, int volta)
    {
        Map<String,Long> aux = c.getTemposMedios();
        long t_medio = aux.get(this.getClass().getName());
        long t_chuva = c.getTempoDesvio();
        long minimum = 0;
        double mmBoost=0;
        long maximum = 5000;
        long fator_sorte = minimum + Double.valueOf(Math.random()*(maximum-minimum)).intValue();
        long maximum_chuva = 2000;
        long fator_sorte_chuva= minimum + Double.valueOf(Math.random()*(maximum_chuva-minimum)).intValue();
        if (this.pneus == TPneus.Macio && clima==0){
            fator_sorte = fator_sorte * (50-volta)/25;
        }
        if (this.pneus == TPneus.Duro && clima==0){
            fator_sorte = fator_sorte * (80-volta)/40;
        }
        if (this.pneus == TPneus.Chuva && clima==0){
            fator_sorte = fator_sorte/2 * (20-volta)/10;
        }
        if (this.pneus == TPneus.Macio || this.pneus == TPneus.Duro && clima==1){
            clima=clima*3;
            fator_sorte_chuva = fator_sorte_chuva/5;
        }
        if (this.pneus == TPneus.Chuva && clima==1){
            fator_sorte_chuva = fator_sorte_chuva * (60-volta/30);
        }
        switch (this.modomotor){
            case Normal -> mmBoost=1;
            case Conservador -> mmBoost=0.75;
            case Agressivo -> mmBoost=1.5;
        }
        if(this.car instanceof Hibrido){
            return (long) ((t_medio + ((this.car.getCilindrada()/this.car.getPotencia())+(this.car.getCilindrada()/((Hibrido) this.car).getPotenciaMotorEletrico())-this.driver.getSVA())* 1000L) - mmBoost*fator_sorte
                                + (clima*(t_chuva - this.driver.getCTS()* 1000L)) - fator_sorte_chuva);
        }
        else return (long) ((t_medio + ((this.car.getCilindrada()/this.car.getPotencia())-this.driver.getSVA())* 1000L) - mmBoost*fator_sorte
                            + (clima*(t_chuva - this.driver.getCTS()* 1000L)) - fator_sorte_chuva);


    }
}

