package OldWomanGame;

public class Computador extends Jogador {

	private int pontuacao[][];
	
	public Computador() {
		pontuacao =new int[Tabuleiro.nLinhas][Tabuleiro.nColunas];		
		this.setHumano(false);
		this.setNome("Jogador "+Jogador.nJogador);
		if(nJogador==1) {
			this.setSimbolo(Simbolo.XIS);
		}		
		else if(nJogador==2) {
			this.setSimbolo(Simbolo.CIRCULO);
		}	
	}
	
	public void pontuacao(Tabuleiro tabuleiro) {
		int i,j,k,nlin,ncol,ndia;
		for(i=0;i<Tabuleiro.nLinhas;i++) {
			for(j=0;j<Tabuleiro.nColunas;j++) {
				if(this.pontuacao[i][j]!=-999) {
					this.pontuacao[i][j]=0;
				}
				if(tabuleiro.espaco[i][j].getSimbolo()==Simbolo.VAZIO) {;
					if(i==j && i==1) {
						this.pontuacao[i][j]=this.pontuacao[i][j]+2;
					}
					if((i==0 && j==0) || (i==0 && j==2) || (i==2 & j==0)|| (i==2 && j==2)) {
						this.pontuacao[i][j]=this.pontuacao[i][j]+1;
					}
					if(this.getSimbolo()==Simbolo.XIS) {
						for(k=0;k<3;k++) {
							if(tabuleiro.espaco[i][k].getSimbolo()==Simbolo.CIRCULO) {
								this.pontuacao[i][j]=this.pontuacao[i][j]-2;
								break;
							}
							if(tabuleiro.espaco[k][j].getSimbolo()==Simbolo.CIRCULO) {
								this.pontuacao[i][j]=this.pontuacao[i][j]-2;
								break;
							}
							if(k==0) {
								if(i==j) {
									if(tabuleiro.espaco[0][0].getSimbolo()==Simbolo.CIRCULO || tabuleiro.espaco[1][1].getSimbolo()==Simbolo.CIRCULO || tabuleiro.espaco[2][2].getSimbolo()==Simbolo.CIRCULO) {
										this.pontuacao[i][j]=this.pontuacao[i][j]-2;
										break;
									}
								}
								if((i==0 && j==2)||(i==1 && j==1)|(i==2 && j==0)) {
									if(tabuleiro.espaco[0][2].getSimbolo()==Simbolo.CIRCULO || tabuleiro.espaco[1][1].getSimbolo()==Simbolo.CIRCULO || tabuleiro.espaco[2][0].getSimbolo()==Simbolo.CIRCULO) {
										this.pontuacao[i][j]=this.pontuacao[i][j]-2;
										break;
									}
								}
							}	
						}
					}
					if(this.getSimbolo()==Simbolo.CIRCULO) {
						for(k=0;k<3;k++) {
							if(tabuleiro.espaco[i][k].getSimbolo()==Simbolo.XIS) {
								this.pontuacao[i][j]=this.pontuacao[i][j]-2;
								break;
							}
							if(tabuleiro.espaco[k][j].getSimbolo()==Simbolo.XIS) {
								this.pontuacao[i][j]=this.pontuacao[i][j]-2;
								break;
							}
							if(k==0) {
								if(i==j) {
									if(tabuleiro.espaco[0][0].getSimbolo()==Simbolo.XIS || tabuleiro.espaco[1][1].getSimbolo()==Simbolo.XIS || tabuleiro.espaco[2][2].getSimbolo()==Simbolo.XIS) {
										this.pontuacao[i][j]=this.pontuacao[i][j]-2;
										break;
									}
								}
								if((i==0 && j==2)||(i==1 && j==1)|(i==2 && j==0)) {
									if(tabuleiro.espaco[0][2].getSimbolo()==Simbolo.XIS || tabuleiro.espaco[1][1].getSimbolo()==Simbolo.XIS || tabuleiro.espaco[2][0].getSimbolo()==Simbolo.XIS) {
										this.pontuacao[i][j]=this.pontuacao[i][j]-2;
										break;
									}
								}
							}
						}				
					}
					ndia=0;
					nlin=0;
					ncol=0;
					for(k=0;k<3;k++) {
						if(tabuleiro.espaco[i][k].getSimbolo()==Simbolo.XIS) {
							nlin=nlin+1;
						}
						if(tabuleiro.espaco[k][j].getSimbolo()==Simbolo.XIS) {
							ncol=ncol+1;
						}
						if(k==0) {
							ndia=0;
							if(i==j) {
								if(tabuleiro.espaco[0][0].getSimbolo()==Simbolo.XIS) {
									ndia=ndia+1;
								}
								if(tabuleiro.espaco[1][1].getSimbolo()==Simbolo.XIS) {
									ndia=ndia+1;
								}
								if(tabuleiro.espaco[2][2].getSimbolo()==Simbolo.XIS) {
									ndia=ndia+1;
								}
								if(ndia==2) {
									this.pontuacao[i][j]=this.pontuacao[i][j]+4;
									break;
								}
								
							}
							ndia=0;
							if((i==1 && j==1) || (i==0 && j==2) || (i==2 && j==0)) {
								if(tabuleiro.espaco[0][2].getSimbolo()==Simbolo.XIS) {
									ndia=ndia+1;
								}
								if(tabuleiro.espaco[1][1].getSimbolo()==Simbolo.XIS) {
									ndia=ndia+1;
								}
								if(tabuleiro.espaco[2][0].getSimbolo()==Simbolo.XIS) {
									ndia=ndia+1;
								}
								if(ndia==2) {
									this.pontuacao[i][j]=this.pontuacao[i][j]+4;
									break;
								}
							}
						}
					}
					if((ncol==2 || nlin==2) && (ndia!=2)) {
						this.pontuacao[i][j]=this.pontuacao[i][j]+4;
					}
					nlin=0;
					ncol=0;
					for(k=0;k<3;k++) {
						if(tabuleiro.espaco[i][k].getSimbolo()==Simbolo.CIRCULO) {
							nlin=nlin+1;
						}
						if(tabuleiro.espaco[k][j].getSimbolo()==Simbolo.CIRCULO) {
							ncol=ncol+1;
						}
						if(k==0) {
							ndia=0;
							if(i==j) {
								if(tabuleiro.espaco[0][0].getSimbolo()==Simbolo.CIRCULO) {
									ndia=ndia+1;
								}
								if(tabuleiro.espaco[1][1].getSimbolo()==Simbolo.CIRCULO) {
									ndia=ndia+1;
								}
								if(tabuleiro.espaco[2][2].getSimbolo()==Simbolo.CIRCULO) {
									ndia=ndia+1;
								}
								if(ndia==2) {
									this.pontuacao[i][j]=this.pontuacao[i][j]+4;
									break;
								}
								
							}
							ndia=0;
							if((i==1 && j==1) || (i==0 && j==2) || (i==2 && j==0)) {
								if(tabuleiro.espaco[0][2].getSimbolo()==Simbolo.CIRCULO) {
									ndia=ndia+1;
								}
								if(tabuleiro.espaco[1][1].getSimbolo()==Simbolo.CIRCULO) {
									ndia=ndia+1;
								}
								if(tabuleiro.espaco[2][0].getSimbolo()==Simbolo.CIRCULO) {
									ndia=ndia+1;
								}
								if(ndia==2) {
									this.pontuacao[i][j]=this.pontuacao[i][j]+4;
									break;
								}
							}
						}
					}
					if((ncol==2 || nlin==2) && (ndia!=2)) {
						this.pontuacao[i][j]=this.pontuacao[i][j]+4;
					}
				
				}
				else {
					this.pontuacao[i][j]=-999;
				}
			}
		}
	}
	

	
	@Override
	public void jogar(Tabuleiro tabuleiro) {
		pontuacao(tabuleiro);
		int i,j,maiorValor,maiorLinha,maiorColuna;
		maiorLinha=0;
		maiorColuna=0;
		maiorValor=-998;
		for(i=0;i<Tabuleiro.nLinhas;i++) {
			for(j=0;j<Tabuleiro.nColunas;j++) {
				if (this.pontuacao[i][j]>maiorValor) {
					maiorLinha=i;
					maiorColuna=j;
					maiorValor=this.pontuacao[i][j];
				}
			}
		}
		for(i=0;i<Tabuleiro.nLinhas;i++) {
			for(j=0;j<Tabuleiro.nColunas;j++) {
					//System.out.print(this.pontuacao[i][j]+" ");				
			}
			System.out.println();
		}
		tabuleiro.espaco[maiorLinha][maiorColuna].setSimbolo(this.getSimbolo());
		System.out.println(this.getNome()+" jogou nas coordenadas ("+(maiorLinha+1)+","+(maiorColuna)+")");
		System.out.println();
	}
	
}
