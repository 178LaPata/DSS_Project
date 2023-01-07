
/**
 * Write a description of class Carro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.Serializable;

public abstract class Carro implements Serializable {
    //Variaveis de instancia
    private String marca;
    private String modelo;
    private int cilindrada;
    private int potencia;
    private int pac;
    private int fiabilidade;

    /* Construtores */
    public Carro() {
        this.marca = "";
        this.modelo = "";
        this.cilindrada = 0;
        this.potencia = 0;
        this.pac = 0;
        this.fiabilidade = 0;
    }

    public Carro(String marca, String modelo,int cilindrada, int pac, int potencia, int fiabilidade) {
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.pac = pac;
        this.fiabilidade = fiabilidade;
    }

    public Carro(Carro c) {
        this.marca = c.getMarca();
        this.modelo = c.getModelo();
        this.cilindrada = c.getCilindrada();
        this.potencia = c.getPotencia();
        this.pac = c.getPac();
        this.fiabilidade = c.getFiabilidade();
    }

    /* Gets e sets */

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getCilindrada() {
        return this.cilindrada;
    }

    public int getPotencia() {
        return this.potencia;
    }

    public int getFiabilidade() {
        return this.fiabilidade;
    }

    public int getPac() {
        return this.pac;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void setPac(int pac) {
        this.pac = pac;
    }

    /* Metodos usuais */
    public abstract Carro clone();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nMarca: ");
        sb.append(this.marca);
        sb.append("\nModelo: ");
        sb.append(this.modelo);
        sb.append("\nCilindrada: ");
        sb.append(this.cilindrada);
        sb.append("\nPotencia: ");
        sb.append(this.potencia);
        sb.append("\nFiabiliade: ");
        sb.append(this.fiabilidade);
        sb.append("\nPAC: ");
        sb.append(this.pac);
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || this.getClass() != o.getClass())
            return false;

        Carro c = (Carro) o;
        return (this.marca.equals(c.getMarca()) &&
                this.modelo.equals(c.getModelo()) &&
                this.cilindrada == c.getCilindrada() &&
                this.potencia == c.getPotencia() &&
                this.fiabilidade == c.getFiabilidade() &&
                this.pac == c.getPac());
    }

    public abstract boolean DNF(int volta, int totalvoltas, int clima, PlayCarro.MotorMode modoM);

    public abstract boolean DNF(int volta, int totalvoltas, int clima, PlayCarro.MotorMode modoM, Piloto p);
}


