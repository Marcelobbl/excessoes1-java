package model.excessoes;

public class DominioExcessao extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DominioExcessao(String mensagem) {
		super(mensagem);
	}

}
