package OldWomanGame;

import java.util.Scanner;

public class Jogo {

	private StatusDaPartida status;
	private Tabuleiro tabuleiro;
	private static boolean vezDoJogador; //true:jogador 1;false:jogador 2
	private Jogador jogador1,jogador2;
	public static Scanner entrada = new Scanner(System.in);
	
	public Jogo() {
		tabuleiro=new Tabuleiro();
		jogador1=new Humano();
		jogador2=new Computador();
		iniciarJogo();
		while(status==StatusDaPartida.JOGANDO) {
			if(vezDoJogador==true) {
				jogador1.jogar(tabuleiro);
				vezDoJogador=false;
			}
			else {
				jogador2.jogar(tabuleiro);
				vezDoJogador=true;			
			}	
			tabuleiro.desenhar();
			System.out.println();
			if(vezDoJogador==false) {
				verificarFinalDaPartida(jogador1);
			}
			else {
				verificarFinalDaPartida(jogador2);
			}
		}
	}
	
	public void iniciarJogo() {
		tabuleiro.limparTabuleiro();
		status=StatusDaPartida.JOGANDO;
		vezDoJogador=true;
	}	
																																																																																																																																			
	public void verificarFinalDaPartida(Jogador jogador) {	
		boolean vitoria,empate;
		vitoria=tabuleiro.verificarVitoria(jogador.getSimbolo());
		if(vitoria==true) {
			if(jogador.getSimbolo()==Simbolo.XIS) {
				this.status=StatusDaPartida.VITORIA_XIS;
			}
			else {
				this.status=StatusDaPartida.VITORIA_CIRCULO;
			}
		}
		empate=tabuleiro.verificarEmpate();
		if(empate==true) {
			this.status=StatusDaPartida.EMPATE;
		}
	}
	
	public static void main(String[] args) {
		new Jogo();
	}
	
}
