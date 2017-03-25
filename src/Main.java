import java.util.Scanner;

import cifras.Cesar;
import cifras.PlayFair;
import cifras.Veginere;
import modelo.Cifrador;

public class Main {
	
	public static void main(String[] args){
		executar();
	}

	private static void executar(){
		Scanner scanner = new Scanner(System.in);

		char resposta = prompt("Selecione um cifrador - (c)esar, (p)layfair ou (v)iginere: ", scanner, 1).charAt(0);
		
		Cifrador cifrador = new Cesar(1);
		String chave;

		switch (resposta) {
			case 'c':	chave = prompt("Entre com a chave de encriptacao (um numero entre 1 e 26): ", scanner, 1).toUpperCase();
						cifrador = new Cesar(Integer.parseInt(chave));
						break;
			
			case 'p':	chave = prompt("Entre com a chave de encriptacao (Somente caracteres)): ", scanner, 1).toUpperCase();
						cifrador = new PlayFair(chave);
						break;
			
			case 'v':	chave = prompt("Entre com a chave de encriptacao (Somente caracteres)): ", scanner, 1).toUpperCase();
						cifrador = new Veginere(chave);
						break;
		
			default:	resposta = prompt("Selecione um cifrador: (c)esar, (p)layfair ou (v)iginere: ", scanner, 1).charAt(0);
						break;

		}
		
		String texto = prompt("Digite o texto a ser cifrado: ", scanner, 1).toUpperCase();

		String textoCifrado = cifrador.cifrar(texto);
		String textoDecifrado = cifrador.decifrar(textoCifrado);

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
