import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {		
		Scanner s = new Scanner(System.in);
	
		System.out.println("Digite sua express�o: ");
		String expressao  = s.nextLine();
		
		System.out.println("Deseja usar qual tipo de pilha?");
		System.out.println("1 - Pilha Lista \n2 - Pilha Vetor");
		int opcao = s.nextInt();
		
		System.out.println( "expressao " + expressao);
		String[] expressaoArray = expressao.split(" ");
		System.out.println( "expressaoArray " + expressaoArray.length);
		System.out.println( "tamanho " + expressaoArray.length);
		if(opcao == 1) {
			PilhaLista<Integer> pilhaLista = new PilhaLista<Integer>();
			pilhaLista.lista = 	new ListaEstatica<Integer>();
			int tamanho = 0;
			for(int i = 0; i <= expressaoArray.length -1; i++) { 
				String valor = expressaoArray[i];
				
				
				if(isNumeric(valor)) {
					tamanho++;
					pilhaLista.push(Integer.parseInt(valor));
				}else if(isOperator(valor)) {
					int valorB = (int) pilhaLista.pop();
					int valorA =   (int) pilhaLista.pop();
					System.out.println("Valor a" + valorA);
					System.out.println(valorB);
					tamanho = tamanho - 2;
					pilhaLista.push(calcular(valor, valorB, valorA));
				}

			}
			System.out.println(pilhaLista.toString());
		}else {
			PilhaVetor<Integer> pilhaVetor = new PilhaVetor<Integer>(expressaoArray.length);
			int tamanho = 0;
			for(int i = 0; i <= expressaoArray.length-1; i++) { 
				String valor = expressaoArray[i];
				if(isNumeric(valor)) {
					tamanho++;
					pilhaVetor.push(Integer.parseInt(valor));
				}else if(isOperator(valor)) {
					int valorB = (int) pilhaVetor.pop();
					int valorA =   (int) pilhaVetor.pop();
					tamanho = tamanho - 2;
					pilhaVetor.push(calcular(valor, valorB, valorA));
				}

			}
			System.out.println(pilhaVetor.toString());

		}

	}
	
	
	
	public static boolean isNumeric(String string) {
	    int intValue;
						
	    if(string == null || string.equals("") || isOperator(string)) {
	        return false;
	    }
	    
	    try {
	        intValue = Integer.parseInt(string);
	        return true;
	    } catch (NumberFormatException e) {
	    }
	    return false;
	} 
	
	public static boolean isOperator(String s) {
	   if(s.equals("+") || s.equals("-") ||s.equals("*") ||s.equals("/")) {
	        return true;
	    }else {
	    	return false;
	    }
	}
	
	public static int calcular(String operator, int valorA, int valorB) {
		int valorCalcular = 0;
		switch (operator) {
			case "+":
				valorCalcular = valorA + valorB;
				break;
			case "-":
				valorCalcular = valorA - valorB;
				break;
			case "*":
				valorCalcular =  valorA * valorB;
				break;
			case "/":
				valorCalcular = valorA / valorB;
				break;
		}
		
		return valorCalcular;
	}

}
