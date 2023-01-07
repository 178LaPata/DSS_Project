package Jogo.Extra;
import Jogo.Carro.*;

/**
 * Write a description of class Jogador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Set;
import java.io.Serializable;

public class Jogador implements Serializable {
    private String nome;

    public Jogador() {
        this.nome = "";
    }

    public Jogador(String n) {
        this();
        this.nome = n;
    }

    public Jogador(Jogador j) {
        this.nome = j.getNome();
    }

    public String getNome() {
        return this.nome;
    }

    public Jogador clone() {
        return new Jogador(this);
    }

    /**
     * Informacao do jogador
     */
    public String printInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNome: ");
        sb.append(this.nome);
        return sb.toString();
    }
}