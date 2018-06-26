package JogoDemo;

import java.util.Scanner;

import ClassesBasicas.Mochila;
import ClassesBasicas.Sala;

public class Engine {
	private Scanner sc;
	private Sala salaInicial;
	private Mochila mochila;
	private Sala salaCorrente;
	private boolean fim;

	public Engine() {
		sc = new Scanner(System.in);
		mochila = new Mochila();
		criaLabirinto();
		salaInicial.entra(mochila);
		salaCorrente = salaInicial;
		fim = false;
	}

	private void criaLabirinto() {
		Sala salaBlackHole = new SalaBlackHole();
		Sala salaSaturno = new SalaSaturno();
		Sala hallEntrada = new HallEntrada();
		Sala salaCofre = new SalaCofre();
		Sala salaPedras = new SalaPedras();
		Sala salaBuraco = new SalaBlackHole();
		
		salaBlackHole.getPortas().put(salaSaturno.getNome(), salaSaturno);
		
		hallEntrada.getPortas().put(salaCofre.getNome(), salaCofre);

		salaCofre.getPortas().put(hallEntrada.getNome(), hallEntrada);
		salaCofre.getPortas().put(salaPedras.getNome(), salaPedras);

		salaPedras.getPortas().put(salaCofre.getNome(), salaCofre);
		salaInicial = salaBlackHole;

	}

	public void joga() {
		while (!fim) {
			Sala novaSala = salaCorrente;
			novaSala.entra(mochila);
			
			System.out.println("---------");
			System.out.println(salaCorrente.textoDescricao());
			System.out.println("O que voce deseja fazer? ");
			String acao = sc.nextLine();
			String[] tokens = acao.split(" ");
			switch (tokens[0]) {
			case "fim":
				fim = true;
				break;
			case "pega":
				if (salaCorrente.pega(tokens[1])) {
					System.out.println("Ok! " + tokens[1] + " na mochila!");
				} else {
					System.out.println("Objeto " + tokens[1] + " n�o encontrado.");
				}
				break;
			case "inventario":
				System.out.println("Conteudo da mochila: " + mochila.inventario());
				break;
			case "usa":
				try {
					if (salaCorrente.usa(tokens[1])) {
						System.out.println("Feito !!");
					} else {
						System.out.println("N�o � poss�vel usar " + tokens[1] + " nesta sala");
					}
				} catch (FimDeJogoException e) {
					fim = true;
				}
				break;
//			case "sai":
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
		System.out.println("Fim de jogo !! Voc� conseguiu abrir o cofre !!");
	}

}
