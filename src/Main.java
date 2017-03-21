import java.util.Scanner;

import cifras.Cesar;
import cifras.PlayFair;
import cifras.Veginere;
import modelo.Cifra;

public class Main {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		char resposta = prompt("Selecione um cifrador: (0) Cesar, (1) Playfair ou (2) Viginere: ", scanner, 1).charAt(0);
		
		Cifra cifrador;
		String chave;
		String texto;

		switch (resposta) {
			case 'c':	chave = prompt("Entre com a chave de encriptacao (um numero entre 1 e 26): ", scanner, 1);
						cifrador = new Cesar(Integer.parseInt(chave));
						break;
						
			case 'p':	chave = prompt("Entre com a chave de encriptacao (Somente caracteres)): ", scanner, 1);
						cifrador = new PlayFair(chave);
						break;
			
			default:	chave = prompt("Entre com a chave de encriptacao (Somente caracteres)): ", scanner, 1);
						cifrador = new Veginere(chave);
						break;
		}
		texto = prompt("Digite o texto a ser cifrado: ", scanner, 1);

		String textoCifrado = cifrador.cifrar(texto);
		String textoDecifrado = cifrador.cifrar(textoCifrado);

		System.out.println("Texto cifrado: " + textoCifrado);
		System.out.println("Texto decifrado: " + textoDecifrado);
	}

	private static String prompt(String texto, Scanner scaner, int tamanho) {
		String retorno;
		do {
			System.out.print(texto);
			retorno = scaner.nextLine().trim();
		} while (retorno.length() < tamanho);
		return retorno;
	}
		

}
