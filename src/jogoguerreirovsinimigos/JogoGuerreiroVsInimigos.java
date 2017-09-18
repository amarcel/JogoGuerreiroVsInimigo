package jogoguerreirovsinimigos;

import br.jogo.personagem.Arqueiro;
import br.jogo.personagem.Guerreiro;
import br.jogo.personagem.Zumbi;
import java.util.Scanner;


/*TESTE GITHUB*/
public class JogoGuerreiroVsInimigos {

    public static void main(String[] args) {
        
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite o nome do guerreiro:");
            String nomeGuerreiro = sc.nextLine();
            Guerreiro g = new Guerreiro(nomeGuerreiro);
            
            System.out.println("Digite o nome do zumbi:");
            String nomeZumbi = sc.nextLine();
            Zumbi z = new Zumbi(nomeZumbi);
            
            System.out.println("Digite o nome do arqueiro:");
            String nomeArqueiro = sc.nextLine();
            Arqueiro a = new Arqueiro(nomeArqueiro);
                    
            int contBatalha = 1;
            while (g.getVida() > 0.0
                    && (z.getVida() > 0.0 || a.getVida() > 0.0)) {
                System.out.println("BATALHA #" + contBatalha);
                double guerreiroDano = g.atacar();
                System.out.printf("Gerreiro atacou zumbi com %.2f \n", 
                        guerreiroDano);
                z.defender(guerreiroDano);
                Thread.sleep(3000); //delay de 3 segs
                
                double zumbiDano = z.atacar();
                System.out.printf("Zumbi atacou guerreiro com %.2f \n",
                        zumbiDano);
                g.defender(z.atacar());
                Thread.sleep(3000); //delay de 3 segs
                
                double arqueiroDano = z.atacar();
                System.out.printf("Arqueiro atacou guerreiro com %.2f \n",
                        arqueiroDano);
                g.defender(a.atacar());
                Thread.sleep(3000); //delay de 3 segs
                
                // arqueiro só sofre ataque na 3ª batalha em diante:
                if (contBatalha >= 3) {
                    a.defender(g.atacar());
                }
                System.out.printf("Guerreiro %.2f vs %.2f Zumbi + "
                        + "%.2f Arqueiro \n",
                        g.getVida(), z.getVida(), a.getVida());
                contBatalha++;
            } // fim do while
            //RESULTADO FINAL:
            if (g.getVida() > 0.0 && z.getVida() == 0.0
                    && a.getVida() == 0.0) {
                System.out.println("GUERREIRO VENCEU!");
            } else if (g.getVida() == 0.0 && z.getVida() > 0.0
                    && a.getVida() == 0.0) {
                System.out.println("ZUMBI VENCEU!");
            } else if (g.getVida() == 0.0 && z.getVida() == 0.0
                    && a.getVida() > 0.0) {
                System.out.println("ARQUEIRO VENCEU!");
            } else if (g.getVida() == 0.0 && z.getVida() == 0.0
                    && a.getVida() == 0.0) {
                System.out.println("PARTIDA EMPATADA...");
            }
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }

    }

}
