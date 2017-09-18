
package br.jogo.personagem;

public class Personagem {
    private String nome;
    private double vida = 10.0;
    
    //construtores (SOBRECARGA)
    public Personagem() { }
    public Personagem(String nome) throws Exception {
        setNome(nome);
    }
    public Personagem(String nome, double vida) 
        throws Exception {
        setNome(nome);
        this.vida = vida;
    }
    
    //métodos setters e getters (ENCAPSULAMENTO):
    public void setNome(String nome) throws Exception {
        if ( nome.trim().length() > 1 ) {
            this.nome = nome;
        } else {
            throw new Exception("[ERRO] Nome inválido!");
        }
    }
    public String getNome(){
        return this.nome;
    }
    public void setVida(double vida){
        if ( vida >= 0.0 ) {
            this.vida = vida;
        } else {
            this.vida = 0.0;
        }
    }
    public double getVida(){
        return this.vida;
    }
    
} // fim da classe Personagem
