package cifras;

import java.awt.Point;
import java.util.HashMap;

import modelo.Cifra;

public class PlayFair implements Cifra{
	private String chave = "";
	char[][] tabelaDeCifragem = new char[5][5];
	HashMap<Character, Point> mapeamentoDeCifragem = new HashMap<Character, Point>();
	
	public PlayFair(String chave){
		this.chave = chave;		
		String alfabeto = this.removerCaracteresRepetidos(chave + "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		
		for(int i = 0; i < 25; i++){
			tabelaDeCifragem[i/5][i%5] = alfabeto.charAt(i);
			mapeamentoDeCifragem.put(alfabeto.charAt(i), new Point(i/5, i%5));
		}
	}
	
	//UTILIDADE
	
	private String removerCaracteresRepetidos(String texto){
		String retorno = "";
		for(int i = 0; i < texto.length(); i++){
			CharSequence caracter = texto.substring(i, i+1);			
			if(!retorno.contains(caracter)){
				retorno += caracter;
			}
		}
		return retorno;
	}

	//FUNCOES
	
	@Override
	public String cifrar(String texto){		
		texto = this.removerCaracteresRepetidos(texto);
		if(texto.length() / 2 == 1){
			texto += tabelaDeCifragem[4][4];
			System.out.println(texto);
		}
		String textoCifrado = "";
		
		int[] x = new int[2];
		int[] y = new int[2];
		
		for(int i = 0; i < texto.length(); i+=2){
			for(int j = 0; j < 2; j++){
				Point ponto = mapeamentoDeCifragem.get(texto.charAt(i + j));
				x[j] = ponto.x;
				y[j] = ponto.y;
			}
			
			if(x[0] == x[1]){
				textoCifrado += tabelaDeCifragem[x[0]][y[0] == 5 ? 5 : y[0]+1];
				textoCifrado += tabelaDeCifragem[x[1]][y[1] == 5 ? 5 : y[1]+1];
			}
			else if(y[0] == y[1]){
				textoCifrado += tabelaDeCifragem[x[0] == 5 ? 5 : x[0]+1][y[0]];
				textoCifrado += tabelaDeCifragem[x[1] == 5 ? 5 : x[1]+1][y[1]];
			}
			else{
				textoCifrado += tabelaDeCifragem[x[1]][y[0]];
				textoCifrado += tabelaDeCifragem[x[0]][y[1]];
			}
		}
				
		return textoCifrado;
	}

	@Override
	public String decifrar(String texto) {
		return chave;
	}

}
