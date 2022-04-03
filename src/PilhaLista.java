
public class PilhaLista <T> implements Pilha<T>  {
	Lista lista;
	@Override
	public void push(T v) {
		this.lista.inserir(v);
		// TODO Auto-generated method stub
		
	}

	@Override
	public T pop() {
		T valor;
		valor = this.peek();
		this.lista.retirar(valor);
		
		// TODO Auto-generated method stub
		return valor;
	}

	@Override
	public T peek() {

		if (this.estaVazia()) {
			throw new RuntimeException("Pilha está vazia");
		}
		// TODO Auto-generated method stub
		return (T) this.lista.pegar(this.lista.getTamanho() - 1);
	}

	@Override
	public boolean estaVazia() {
		// TODO Auto-generated method stub
		return this.lista.getTamanho() == 0;
	}

	@Override
	public void liberar() {
		for(int i = this.lista.getTamanho() - 1; i >=0; i--) {
			T valor;
			valor = this.peek();
			this.lista.retirar(lista);

		}
		// TODO Auto-generated method stub
	}
	
	public String toString() {
		String texto = "";

		for (int i = this.lista.getTamanho() - 1; i >= 0; i--) {
			texto += this.lista.pegar(i) + ", ";
		}
		
		texto = texto.substring(0, texto.length() - 2);

		return texto;

	}

}
