
package br.jogo.personagem;

import jogoguerreirovsinimigos.Util;

public class Zumbi extends Personagem implements IAcao {
    //atributos:
    private final double MIN_DANO = 0.5;
    private final double MAX_DANO = 4.5;
    private final double MIN_ARMADURA = 1.5;
    private final double MAX_ARMADURA = 4.5;
    
    //construtores:
    public Zumbi() { }
    public Zumbi(String nome) throws Exception {
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
    
} // fim da classe Zumbi
