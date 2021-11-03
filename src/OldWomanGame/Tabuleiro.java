package OldWomanGame;

public class Tabuleiro {

	public static final int nLinhas=3,nColunas=3;
	
	Espaco[][] espaco;
	
	public Tabuleiro() {
		int i,j;
		espaco=new Espaco[nLinhas][nColunas];
		for(i=0;i<nLinhas;i++) {
			for(j=0;j<nColunas;j++) {
				espaco[i][j]=new Espaco(i,j);
			}
		}
	}
	
	public void limparTabuleiro() {
		int i,j;
		for(i=0;i<nLinhas;i++) {
			for(j=0;j<nColunas;j++) {
				espaco[i][j].limparEspaco();
			}
		}
	}
	
	public boolean verificarEmpate() {
		int i,j;
		for(i=0;i<nLinhas;i++) {
			for(j=0;j<nColunas;j++) {
				if(espaco[i][j].getSimbolo()==Simbolo.VAZIO) {
					return false;
				}
			}
		}
		return true;
	}
	
//	if(simboloVerificado==Simbolo.XIS) {
//		Jogo.status=StatusDaPartida.VITORIA_XIS;
//	}
//	else if(simboloVerificado==Simbolo.CIRCULO) {
//		Jogo.status=StatusDaPartida.VITORIA_CIRCULO;
//	}
//	
	public boolean verificarVitoria(Simbolo simboloVerificado) {
		if(verificarColunas(simboloVerificado)==true) {
			return true;
		}
		if(verificarLinhas(simboloVerificado)==true) {
			return true;
		}
		if(verificarDiagonais(simboloVerificado)==true) {
			return true;
		}
		return false;
		
	}
	
	public boolean verificarColunas(Simbolo simboloVerificado) {
		int coluna;
		for (coluna=0;coluna<nColunas;coluna++) {
			if(espaco[0][coluna].getSimbolo()==espaco[1][coluna].getSimbolo()	
			&& espaco[1][coluna].getSimbolo()==espaco[2][coluna].getSimbolo()
			&& espaco[2][coluna].getSimbolo()==simboloVerificado) {
				return true;
			}
		}
		return false;
	}
	
	public boolean verificarLinhas(Simbolo simboloVerificado) {
		int linha;
		for (linha=0;linha<nLinhas;linha++) {
			if(espaco[linha][0].getSimbolo()==espaco[linha][1].getSimbolo()
			&& espaco[linha][1].getSimbolo()==espaco[linha][2].getSimbolo()
			&& espaco[linha][2].getSimbolo()==simboloVerificado) {
				return true;
			}
		}
		return false;
	}
	
	public boolean verificarDiagonais(Simbolo simboloVerificado) {
		if(espaco[0][0].getSimbolo()==espaco[1][1].getSimbolo()
				&& espaco[1][1].getSimbolo()==espaco[2][2].getSimbolo() 
				&& espaco[2][2].getSimbolo()==simboloVerificado) {
					return true;
		}
		else if(espaco[0][2].getSimbolo()==espaco[1][1].getSimbolo()
				&& espaco[1][1].getSimbolo()==espaco[2][0].getSimbolo()
				&& espaco[2][0].getSimbolo()==simboloVerificado) {
					return true;
		}
		return false;
	}
	
	public void desenhar() {
		int i,j;
	    for (i = 0; i < nLinhas; i++) {
	    	for (j = 0; j < nColunas; j++) {
	    		espaco[i][j].desenhar();   
	            if (j < nColunas - 1) System.out.print("|");
	         }
	         System.out.println();
	         if (i < nLinhas - 1) {
	            System.out.println("-----------");
	         }
	      }
	   }
	
}
