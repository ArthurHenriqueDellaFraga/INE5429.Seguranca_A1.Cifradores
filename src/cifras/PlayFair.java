package cifras;

import java.awt.Point;
import java.util.HashMap;

import modelo.Cifrador;

public class PlayFair implements Cifrador{
	private String chave = "";
	char[][] tabelaDeCifragem = new char[5][5];
	HashMap<Character, Point> mapeamentoDeCifragem = new HashMap<Character, Point>();
	
	public PlayFair(String chave){
		this.chave = chave;		
		String alfabeto = this.removerLetrasRepetidas(chave + "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		
		for(int i = 0; i < 25; i++){
			tabelaDeCifragem[i/5][i%5] = alfabeto.charAt(i);
			mapeamentoDeCifragem.put(alfabeto.charAt(i), new Point(i/5, i%5));
		}
	}
	
	//UTILIDADE
	
	private String removerLetrasRepetidas(String texto){
		String retorno = "";
		for(int i = 0; i < texto.length(); i++){
			CharSequence caracter = texto.substring(i, i+1);			
			if(!retorno.contains(caracter)){
				retorno += caracter;
			}
		}
		return retorno;
	}
	
	private String separarLetrasRepetidas(String texto){
		String retorno = "";
		
		for(int i=0; i < texto.length(); i+=2){
			CharSequence caracter1 = texto.substring(i, i+1);	
			CharSequence caracter2 = i == texto.length()-1 || texto.substring(i+1, i+2).equals(caracter1) ? "X" : texto.substring(i+1, i+2);
			
			retorno += caracter1 + "" + caracter2;
		}
		return retorno;
	}

	//FUNCOES
	
	@Override
	public String cifrar(String texto){	
		texto = this.separarLetrasRepetidas(texto);
		String textoCifrado = "";
		
		for(int i = 0; i < texto.length(); i+=2){
			textoCifrado = traduzir(texto.charAt(i), texto.charAt(i+1), +1);
		}
				
		return textoCifrado;
	}
	
	@Override
	public String decifrar(String texto) {
		String textoDecifrado = "";
		
		for(int i = 0; i < texto.length(); i+=2){
			textoDecifrado = traduzir(texto.charAt(i), texto.charAt(i+1), -1);
		}
				
		return textoDecifrado;
	}
	
	public String traduzir(char a, char b, int sentido){
		String traducao = "";
		Point posicaoA = mapeamentoDeCifragem.get(a);
		Point posicaoB = mapeamentoDeCifragem.get(b);
			
		if (posicaoA.x == posicaoB.x){
			traducao += tabelaDeCifragem[posicaoA.x][(posicaoA.y +sentido) % 5];
			traducao += tabelaDeCifragem[posicaoB.x][(posicaoB.y +sentido) % 5];
		}
		else if(posicaoA.y == posicaoB.y){
			traducao += tabelaDeCifragem[(posicaoA.x +sentido) % 5][posicaoA.y];
			traducao += tabelaDeCifragem[(posicaoB.x +sentido) % 5][posicaoB.y];
		}
		else{
			traducao += tabelaDeCifragem[posicaoB.x][posicaoA.y];
			traducao += tabelaDeCifragem[posicaoA.x][posicaoB.y];
		}
		
		return traducao;
	}
}
