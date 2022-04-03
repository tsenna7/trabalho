
public class ListaEncadeada<T> implements Lista<T> {
	private NoLista<T> primeiro;
	private NoLista<T> ultimo;
	private int qtdElem;

	@Override
	public void inserir(T valor) {
		NoLista<T> novo = new NoLista<>();
		novo.setInfo(valor);
		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProximo(novo);
		}
		ultimo = novo;
		qtdElem++;
	}

	@Override
	public String exibir() {
		String resultado = "[";
		NoLista<T> p = primeiro;
		while (p != null) {
			// processar o n�
			resultado += p.getInfo() + ", ";
			p = p.getProximo();
		}
		return resultado + "]";
	}

	@Override
	public int buscar(T valor) {
		int posicao = 0;
		NoLista<T> p = primeiro;
		while (p != null) {
			// processar o n�
			if (p.getInfo().equals(valor)) {
				return posicao;
			}
			p = p.getProximo();
			posicao++;
		}
		return -1;
	}

	@Override
	public void retirar(T valor) {
		NoLista<T> anterior = null;
		NoLista<T> p = primeiro;

		while (p != null && !p.getInfo().equals(valor)) {
			anterior = p;
			p = p.getProximo();
		}

		if (p != null) { // significa que encontrou
			if (anterior == null) {
				primeiro = p.getProximo();
			} else {
				anterior.setProximo(p.getProximo());
			}
			qtdElem--;
		}
		if (ultimo == p) {
			ultimo = anterior;
		}
	}

	@Override
	public boolean estaVazia() {
		return (primeiro == null);
	}

	@Override
	public Lista<T> copiar() { // Contribui��o da Ana Carolina
		Lista<T> copia = new ListaEncadeada<>();
		NoLista<T> p = primeiro;
		while (p != null) {
			copia.inserir(p.getInfo());
			p = p.getProximo();
		}
		return copia;
	}

	@Override
	public void concatenar(Lista<T> outra) {
		for (int i = 0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}
	}

	@Override
	public int getTamanho() {
		return qtdElem;
	}

	@Override
	public Lista<T> dividir() {
		Lista<T> outraMetade = new ListaEncadeada<>();
		int metade = this.qtdElem / 2;
		int contador = 1;
		NoLista<T> p = primeiro;

		while (p != null) {
			if (contador > metade) {
				outraMetade.inserir(p.getInfo());
			} else if (contador == metade) {
				this.ultimo = p;
			}
			contador++;
			p = p.getProximo();
		}
		ultimo.setProximo(null);
		this.qtdElem = metade;
		return outraMetade;
	}

	@Override
	public T pegar(int posicao) { // Contribui��o do Guilherme
		if (posicao < 0 || posicao >= this.getTamanho()) {
			throw new IndexOutOfBoundsException("Posicao = " + posicao + "; Tamanho = " + this.getTamanho());
		}
		int resultado = 0;
		NoLista<T> p = primeiro;

		while (p != null) {
			if (resultado == posicao) {
				return p.getInfo();
			}
			p = p.getProximo();
			resultado++;
		}
		return null; // nunca deveria chegar aqui
	}

}