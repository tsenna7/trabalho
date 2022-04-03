
public class PilhaVetor<T> implements Pilha<T> {

	private T[] info;
	private int limite;
	private int tamanhoAtual;

	public PilhaVetor(int limite) {
		super();
		this.limite = limite;
		this.tamanhoAtual = 0;
		this.info = (T[]) new Object[limite];
	}

	@Override
	public void push(T v) {
		// TODO Auto-generated method stub
		
		if (this.tamanhoAtual == this.limite) {
			throw new RuntimeException("Capacidade esgotada da pilha");
		}

		this.info[tamanhoAtual] = v;
		this.tamanhoAtual++;

	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		T valor;
		valor = this.peek();
		this.info[tamanhoAtual] = null; 
		this.tamanhoAtual--;

		return valor;
	}

	@Override
	public T peek() {

		if (this.estaVazia()) {
			throw new RuntimeException("Pilha está vazia");
		}
		// TODO Auto-generated method stub
		return this.info[this.tamanhoAtual - 1];
	}

	@Override
	public boolean estaVazia() {
		// TODO Auto-generated method stub
		return this.tamanhoAtual == 0;
	}

	@Override
	public void liberar() {
		this.info = (T[]) new Object[limite];
		this.tamanhoAtual = 0;
		// TODO Auto-generated method stub

	}

	public String toString() {
		String texto = "";

		for (int i = this.tamanhoAtual - 1; i >= 0; i--) {
			texto += this.info[i] + ", ";
		}
		
		texto = texto.substring(0, texto.length() - 2);

		return texto;

	}

}
