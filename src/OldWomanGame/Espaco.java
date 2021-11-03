package OldWomanGame;

public class Espaco {

	private Simbolo simbolo;
	private int linha,coluna;
	
	public Espaco(int linha,int coluna) {
		this.linha=linha;
		this.coluna=coluna;
	}
	
	public void limparEspaco() {
		simbolo=Simbolo.VAZIO;
	}
	
	public void desenhar() {
		if(this.getSimbolo()==Simbolo.XIS) {
			System.out.print(" X ");
		}
		else if(this.getSimbolo()==Simbolo.CIRCULO) {
			System.out.print(" O ");
		}
		else {
			System.out.print("   ");
		}		
	   }


	public Simbolo getSimbolo() {
		return simbolo;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setSimbolo(Simbolo simbolo) {
		this.simbolo = simbolo;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	
}
