/**
 * 
 */
package fpdualeveris;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operators.Pinball;

/**
 * @author dlopezst
 *
 */
public class FPDual {

	// Creo una instancia de scanner
	private static Scanner input = new Scanner(System.in);

	// Crea una lista con todas las partidas jugadas
	private static List<Pinball> userScores = new ArrayList<>();

	/**
	 * Metodo principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {    
		
		operatorsChallenge();

	}

	/**
	 * Metodo privado donde se ejecutan todas las funciones de la clase pinball
	 */
	private static void operatorsChallenge() {

		String choice = "";

		String menu = "--------------------" + "\n" + "- Jugar            -" + "\n" + "- Ver puntuaciones -" + "\n" + "- Salir            -" + "\n"
		        + "--------------------";
		;

		while (!choice.equals("salir")) {

			System.out.println(menu);

			System.out.print("Qué deseas hacer? :");
			try {
				choice = input.nextLine();
				choice = choice.toLowerCase();
			} catch (IllegalArgumentException e) {
				System.out.println("Valor introducido no válido: " + e);
			}

			switch (choice) {
			case "jugar":
				System.out.print("Introduce el nombre de usuario: ");
				String player = "";
				try {
					player = input.nextLine();

					// Creo instancias de la clase pinball y las añado a la lista
					userScores.add(new Pinball(player));
				} catch (IllegalArgumentException e) {
					System.out.println("Valor introducido no válido: " + e);
				}

				break;
			case "ver puntuaciones":
				// Hago un foreach e imprimo por pantalla la puntuación final por jugador
				printUsersScores();
				break;

			}
		}

		Pinball pinball = new Pinball();

		if (pinball instanceof Object) {
			System.out.println("Pinball es una instancia de objeto");
		} else {
			System.out.println("Pinball no es una instancia de objeto");
		}

	}

	/**
	 * Metodo estático que imprime los jugadores con sus scores totales
	 */
	private static void printUsersScores() {

		for (Pinball pinball : userScores) {

			System.out.println("Jugador: " + pinball.getPlayer() + " | Puntuación: " + pinball.getScore());

		}

	}

}
