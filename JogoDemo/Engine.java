package JogoDemo;

import java.util.Scanner;

import ClassesBasicas.Mochila;
import ClassesBasicas.Sala;

public class Engine {
	private StageScene palco;
	//private Scanner sc;
	private Sala salaInicial;
	private Mochila mochila;
	private Sala salaCorrente;
	private boolean fim;

	public Engine(StageScene palco) {
		this.palco = palco;
		//sc = new Scanner(System.in);
		mochila = new Mochila();
		criaLabirinto();
		salaInicial.entra(mochila);
		salaCorrente = salaInicial;
		fim = false;
	}

	private void criaLabirinto() {
		Sala salaBlackHole = new SalaBlackHole();
		Sala salaSaturno = new SalaSaturno();
		Sala celaSubterranea = new CelaSubterranea();
		Sala salaGuardas = new SalaGuardas();
		Sala salaMarte = new SalaMarte();
		
//		Sala hallEntrada = new HallEntrada();
//		Sala salaCofre = new SalaCofre();
//		Sala salaPedras = new SalaPedras();
//		Sala salaBuraco = new SalaBlackHole();
	
		salaBlackHole.getPortas().put(salaSaturno.getNome(), salaSaturno);
		salaSaturno.getPortas().put(celaSubterranea.getNome(), celaSubterranea);
		celaSubterranea.getPortas().put(salaGuardas.getNome(), salaGuardas);
		salaGuardas.getPortas().put(salaMarte.getNome(), salaMarte); 
		
		//hallEntrada.getPortas().put(salaCofre.getNome(), salaCofre);
		//salaCofre.getPortas().put(hallEntrada.getNome(), hallEntrada);
		//salaCofre.getPortas().put(salaPedras.getNome(), salaPedras);
		//salaPedras.getPortas().put(salaCofre.getNome(), salaCofre);
		salaInicial = salaBlackHole;

	}

	public void joga(String acao) {
		if (!fim) {
			salaCorrente.entra(mochila);
			
			palco.setImagem(Integer.parseInt(salaCorrente.getRepVisual()));
			palco.exibeTexto("\n" + salaCorrente.textoDescricao() + "Suas opções: \n fim - sair do jogo.\n pegar - colocar uma ferramenta na mochila"
							+ "\n inventário - o que você já tem na mochila \n usar - usar uma ferramenta ");
//			System.out.println(salaCorrente.textoDescricao());
//			System.out.println("O que voce deseja fazer? ");
	//acao = sc.nextLine();
			String[] tokens = acao.split(" ");
			
			switch (tokens[0]) {
			case "fim":
				fim = true;
				break;
			
			case "pegar":
				if (salaCorrente.pega(tokens[1])) {
					System.out.println("Ok! " + tokens[1] + " na mochila.");
					}else {
					System.out.println("Ferramenta " + tokens[1] + " não encontrada.");
					}
					break;
			
			case "inventario":
				System.out.println("Conteudo da mochila: " + mochila.inventario());
				break;
			
			case "usar":
				if (salaCorrente.usa(tokens[1])) {
					System.out.println("Feito!");
					salaCorrente.sai("porta"); //o que vai nesse parametro? ele sai da sala depois que usa as ferramentas certas no objetos certos?
				} else {
					System.out.println("Não é possível usar " + tokens[1] + " nesta sala");
				}
				break;
				
//			case "sair_da_sala":
//				Sala novaSala = salaCorrente.sai(tokens[1]);
//				if (novaSala == null) {
//					System.out.println("Sala desconhecida ...");
//				} else {
//					novaSala.entra(mochila);
//					salaCorrente = novaSala;
//				}
//				break;
				
			default:
				System.out.println("Comando desconhecido: " + tokens[0]);
				break;
			}
		}
		if (fim) {
			//comando para encerrar o jogo de verdade verdadeira???
			System.out.println("Adeus, astronauta!");
		} else System.out.println("Próxima jogada...");
		
		
	}
	
}
