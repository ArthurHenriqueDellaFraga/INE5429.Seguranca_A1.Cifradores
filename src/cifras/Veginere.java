package cifras;

import modelo.Cifra;

public class Veginere implements Cifra {

	private String chave;
	
	public Veginere(String chave){
		this.chave = chave.toUpperCase();
	}
	
	@Override
	public String cifrar(String texto) {
		return null;
	}

	@Override
	public String decifrar(String texto) {
		return null;
	}

}
