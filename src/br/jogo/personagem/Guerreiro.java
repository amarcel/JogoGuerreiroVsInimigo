
package br.jogo.personagem;

import jogoguerreirovsinimigos.Util;

public class Guerreiro extends Personagem implements IAcao {
    //atributos:
    private final double MIN_DANO = 1.5;
    private final double MAX_DANO = 5.0;
    private final double MIN_ARMADURA = 0.5;
    private final double MAX_ARMADURA = 4.5;
    
    //construtores:
    public Guerreiro() { }
    public Guerreiro(String nome){
        super(nome);
    }
    @Override
    public double atacar(){
        return Util.gerarNumAleatorio(MIN_DANO, MAX_DANO);
    }
    @Override
    public void defender(double dano){
        double defesa = Util.gerarNumAleatorio(MIN_ARMADURA, MAX_ARMADURA);
        double ataque = dano - defesa;
        if ( ataque > 0.0 )
            setVida( getVida() - ataque );
    }
    
} // fim da classe Guerreiro
