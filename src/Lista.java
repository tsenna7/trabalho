
public interface Lista<T> {
	int getTamanho();

	void inserir(T valor);

	String exibir();

	int buscar(T valor);

	void retirar(T valor);

	boolean estaVazia();

	Lista<T> copiar();

	void concatenar(Lista<T> outra);

	Lista<T> dividir();

	T pegar(int posicao);

}