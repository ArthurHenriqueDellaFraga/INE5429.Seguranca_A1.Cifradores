package cifras;

import modelo.Cifrador;
import utils.AlgoritmoDeCesar;

public class Veginere implements Cifrador {

	private String chave;
	
	public Veginere(String chave){
		this.chave = chave.toUpperCase();
	}
	
	@Override
	public String cifrar(String texto) {
		int tamanhoTexto = texto.length();
		String chaveExpandida = this.expandirChave(texto.length());
		String textoCifrado = "";
		
		for(int i = 0; i < tamanhoTexto; i++){
			int offsetChave = this.offsetChave(chaveExpandida.charAt(i));
			textoCifrado += AlgoritmoDeCesar.cifrar(texto.substring(i, i + 1), offsetChave);
		}
		
		return textoCifrado;
	}

	@Override
	public String decifrar(String texto) {
		int tamanhoTexto = texto.length();
		String chaveExpandida = this.expandirChave(texto.length());
		String textoDecifrado = "";
		
		for(int i = 0; i < tamanhoTexto; i++){
			int offsetChave = this.offsetChave(chaveExpandida.charAt(i));
			textoDecifrado += AlgoritmoDeCesar.decifrar(texto.substring(i, i + 1), offsetChave);
		}
		
		return textoDecifrado;
	}
	
	private String expandirChave(int tamanho){
		String novaChave = this.chave;
		int tamanhoChave = this.chave.length();
		if(this.chave.length() < tamanho ){
			for(int i = 0; i < tamanho; i++){
				novaChave += this.chave.charAt(i % tamanhoChave);
			}
		}
		return novaChave;
	}
	
	private int offsetChave(char charAt) {
		return charAt - 65;
	}

}
