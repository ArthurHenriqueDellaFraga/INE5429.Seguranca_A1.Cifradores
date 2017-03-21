package utils;

public class AlgoritmoDeCesar {

	public static String cifrar(String texto, int chave) {
		StringBuilder textoCifrado = new StringBuilder(texto.toUpperCase());
		
		for (int i = 0; i < texto.length(); i++) {
			char temp = (char) ((textoCifrado.charAt(i) + chave) % 26);
			textoCifrado.setCharAt(i, temp);
		}

		return textoCifrado.toString();
	}

	public static String decifrar(String texto, int chave) {
		StringBuilder textoCifrado = new StringBuilder(texto.toUpperCase());

		for (int i = 0; i < texto.length(); i++) {
			char temp = (char) ((textoCifrado.charAt(i) - chave) % 26);
			textoCifrado.setCharAt(i, temp);
		}
		
		return textoCifrado.toString();
	}

}
