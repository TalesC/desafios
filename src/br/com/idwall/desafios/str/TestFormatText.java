package br.com.idwall.desafios.str;

public class TestFormatText {

	public static void main(String[] args) {

		String texto = "In the beginning Back in nineteen fifty-five Man didn't know about a rock'n' roll show And all that jive The white man had the smoltz The black man had the blues No one knew what they was gonna do But Tchaikovsky had the news He said \n Let there be sound There was sound Let there be light There was light Let there be drums There was drums Let there be guitar There was guitar Oh, Let there be rock";
		
		FormaterText ft =new FormaterText();
		System.out.println("Desafio 1\n");
		System.out.println("Parte 1\n");
		System.out.println(ft.limitText(texto, 40));
		System.out.println("\n\n");
		System.out.println("Parte 2\n");
		System.out.println(ft.justify(texto, 40));
		
	}

}
