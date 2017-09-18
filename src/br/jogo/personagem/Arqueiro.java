
package br.jogo.personagem;

import jogoguerreirovsinimigos.Util;

public class Arqueiro extends Personagem implements IAcao {
    //atributos:
    private final double MIN_DANO = 0.3;
    private final double MAX_DANO = 1.7;
    private final double MIN_ARMADURA = 0.1;
    private final double MAX_ARMADURA = 2.5;
    
    public Arqueiro() { }
    public Arqueiro(String nome) throws Exception {
        super(nome);
    }

    @Override
    public double atacar() {
        return Util.gerarNumAleatorio(MIN_DANO, MAX_DANO);
    }

    @Override
    public void defender(double dano) {
        double defesa = Util.gerarNumAleatorio(MIN_ARMADURA, MAX_ARMADURA);
        double ataque = dano - defesa;
        if( ataque > 0.0 )
            setVida( getVida() - ataque );
    }
    
} // fim da classe Arqueiro
