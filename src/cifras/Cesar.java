package cifras;

import modelo.Cifra;
import utils.AlgoritmoDeCesar;

public class Cesar implements Cifra{

	private int chave;
	
	public Cesar(int chave){
		this.chave = chave;
	}
	
	@Override
	public String cifrar(String texto) {
		String textoCifrado = AlgoritmoDeCesar.cifrar(texto, this.chave);
		return textoCifrado;
	}

	@Override
	public String decifrar(String texto) {
		String textoDecifrado = AlgoritmoDeCesar.decifrar(texto, this.chave);
		return textoDecifrado;
	}

}
