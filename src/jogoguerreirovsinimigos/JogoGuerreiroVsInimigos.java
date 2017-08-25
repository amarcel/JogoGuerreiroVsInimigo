
package jogoguerreirovsinimigos;

import br.jogo.personagem.Arqueiro;
import br.jogo.personagem.Guerreiro;
import br.jogo.personagem.Zumbi;
import java.util.Scanner;

public class JogoGuerreiroVsInimigos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o nome do guerreiro:");
        String nomeGuerreiro = sc.nextLine();
        System.out.println("Digite o nome do zumbi:");
        String nomeZumbi = sc.nextLine();
        System.out.println("Digite o nome do arqueiro:");
        String nomeArqueiro = sc.nextLine();
        
        Guerreiro g = new Guerreiro(nomeGuerreiro);
        Zumbi     z = new Zumbi(nomeZumbi);
        Arqueiro  a = new Arqueiro(nomeArqueiro);
        
        int contBatalha = 1;
        while( g.getVida() > 0.0 && 
                (z.getVida() > 0.0 || a.getVida() > 0.0) ){
            System.out.println("BATALHA #" + contBatalha);
            z.defender( g.atacar() );
            g.defender( z.atacar() );
            g.defender( a.atacar() );
            // arqueiro só sofre ataque na 3ª batalha em diante:
            if(contBatalha >= 3) { 
                a.defender( g.atacar() );
            }
            System.out.printf("Guerreiro %.2f vs %.2f Zumbi + "
                    + "%.2f Arqueiro \n",
                    g.getVida(), z.getVida(), a.getVida());
            contBatalha++;
        } // fim do while
        //RESULTADO FINAL:
        if ( g.getVida() > 0.0 && z.getVida() == 0.0 
                && a.getVida() == 0.0 ){
            System.out.println("GUERREIRO VENCEU!");
        } else if ( g.getVida() == 0.0 && z.getVida() > 0.0
                && a.getVida() == 0.0 ){
            System.out.println("ZUMBI VENCEU!");
        } else if ( g.getVida() == 0.0 && z.getVida() == 0.0
                && a.getVida() > 0.0 ){
            System.out.println("ARQUEIRO VENCEU!");
        } else if ( g.getVida() == 0.0 && z.getVida() == 0.0 
                && a.getVida() == 0.0 ){
            System.out.println("PARTIDA EMPATADA...");
        }
        
    }
    
}
