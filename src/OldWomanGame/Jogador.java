package OldWomanGame;

public abstract class Jogador {

	public static int nJogador=1;
	
	private boolean isHumano;
	private String nome;
	private Simbolo simbolo;
	
	public abstract void jogar(Tabuleiro tabuleiro);

	public static int getnJogador() {
		return nJogador;
	}

	public boolean isHumano() {
		return isHumano;
	}

	public String getNome() {
		return nome;
	}

	public Simbolo getSimbolo() {
		return simbolo;
	}

	public static void setnJogador(int nJogador) {
		Jogador.nJogador = nJogador;
	}

	public void setHumano(boolean isHumano) {
		this.isHumano = isHumano;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSimbolo(Simbolo simbolo) {
		this.simbolo = simbolo;
	}
	
	
	
}
