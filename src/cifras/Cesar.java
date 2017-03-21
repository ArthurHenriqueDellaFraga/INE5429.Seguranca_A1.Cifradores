package cifras;

import modelo.Cifra;

public class Cesar implements Cifra{

	private int chave;
	
	public Cesar(int chave){
		this.chave = chave;
	}
	
	@Override
	public String cifrar(String texto, int cifra) {
		StringBuilder cipheredText = new StringBuilder(texto.toUpperCase());
		for (int i = 0; i < texto.length(); i++) {

			char temp = (char) (((cipheredText.charAt(i) + this.key - 65) % 26) + 65);
			cipheredText.setCharAt(i, temp);
		}
		return cipheredText.toString();
	}

	@Override
	public String decifrar(String texto) {
		StringBuilder cipheredText = new StringBuilder(texto.toUpperCase());

		for (int i = 0; i < texto.length(); i++) {

			char temp = (char) (((cipheredText.charAt(i) - this.key - 90) % 26) + 90);
			cipheredText.setCharAt(i, temp);
		}
		return cipheredText.toString();
	}

}
