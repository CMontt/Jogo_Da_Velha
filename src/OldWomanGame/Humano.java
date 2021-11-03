package OldWomanGame;


public class Humano extends Jogador {
	
	public Humano(String nome) {
		this.setNome(nome);
		this.setHumano(true);
		if(nJogador==1) {
			this.setSimbolo(Simbolo.XIS);
		}		
		else if(nJogador==2) {
			this.setSimbolo(Simbolo.CIRCULO);
		}	
		Jogador.nJogador=Jogador.nJogador+1;
	}
	
	public Humano() {
		this("Jogador "+Integer.toString(Jogador.nJogador));
	}

	@Override
	public void jogar(Tabuleiro tabuleiro) {
		int linhaJogar,colunaJogar;
		boolean jogadaRealizada=false;
		while(jogadaRealizada==false) {
			System.out.println(this.getNome()+", digite uma coordenada para linha");
			linhaJogar=Jogo.entrada.nextInt();
			System.out.println(this.getNome()+", digite uma coordenada para coluna");
			colunaJogar=Jogo.entrada.nextInt();	
			System.out.println();
			if(linhaJogar>0 && colunaJogar>0 && linhaJogar<=Tabuleiro.nLinhas && colunaJogar<=Tabuleiro.nColunas && tabuleiro.espaco[linhaJogar-1][colunaJogar-1].getSimbolo()==Simbolo.VAZIO) {
				tabuleiro.espaco[linhaJogar-1][colunaJogar-1].setSimbolo(this.getSimbolo());		
				jogadaRealizada=true;
				System.out.println(this.getNome()+" jogou nas coordenadas ("+(linhaJogar)+","+(colunaJogar)+")");
				System.out.println();
			}
			else {
				System.out.println("Insira uma entrada válida");
			}
		}
	}

	
	
}
