/**
 * 
 */
package operators;

/**
 * @author dlopezst
 *
 */
public class Pinball {

	StringBuilder stringBuilder = new StringBuilder();

	/**Variable estatica pero privado que cuenta las veces que la bola ha rebotado*/
	private static int numBounces = 0;

	/** Variables privada que te cuenta el total de puntos*/
	private int score = 0;

	/**Variable privada que almacena el nombre del jugador*/
	private String player = "";

	/**
	 * Constructor que no hace nada, simplemente para poder comprobar el instanceof
	 */
	public Pinball() {

	}

	/**
	 * Constructor que inicia el juego, introduce el nick del jugador y te resetea el numero de rebotes a 0
	 */
	public Pinball(String player) {
		this.setPlayer(player);
		Pinball.numBounces = 0;
		launchBall();
	}

	/**
	 * Método principal de la clase pinball que comienza el "juego"
	 */
	private void launchBall() {

		// Genero de forma aleatoria la cantidad de veces que se recorre el for, para que la bola continue rebotando
		int gameTime = generateRandomNumbers(5, 20);
		for (int i = 0; i < gameTime; i++) {

			// Por cada vez que se ejecuta el metodo la bola rebota.
			ballBounce();

			try {

				Thread.sleep(500);
			} catch (Exception e) {

				System.out.println("ERROR: " + e);
			}
		}

	}

	/**
	 * Metodo que se ejecuta cada vez que la bola rebota en alguna parte del pinball (que devuelve una puntuación)
	 */

	private void ballBounce() {

		Pinball.numBounces += 1;

		typesOfRewards(generateRandomNumbers(1, 3));

	}

	/**
	 * Metodo que devuelve un tipo de objeto que sirve para determinar la cantidad de puntuación a sumar o restar
	 */
	private void typesOfRewards(int type) {

		if (type == 1) {
			if (addOrSubstract(generateRandomNumbers(1, 100))) {

				updateScores(generateRandomNumbers(1, 25), type);

			} else {

				updateScores(generateRandomNumbers(-1, -25), type);

			}
		} else if (type == 2) {
			if (addOrSubstract(generateRandomNumbers(0, 2))) {

				updateScores(generateRandomNumbers(26, 100), type);

			} else {

				updateScores(generateRandomNumbers(-26, -100), type);

			}

		} else {
			if (addOrSubstract(generateRandomNumbers(0, 2))) {

				updateScores(generateRandomNumbers(101, 250), type);

			} else {

				updateScores(generateRandomNumbers(-101, -250), type);

			}
		}

	}

	/**
	 * Metodo que actualiza la puntuacion e imprime por consola si se han restado o sumado puntos
	 * 
	 * @param
	 */

	private void updateScores(int score, int tier) {

		if (numBounces != 0 && score > 0) {
			score = score * Pinball.numBounces;
		}

		this.score += score;

		if (score < 0) {
			System.out.println(
			        "No has rebotado bien!, se te resta: " + score + ", se ha reseteado el numero de rebotes seguidos!" + " Total: " + "(" + this.score + ")");
			Pinball.numBounces = 0;
		} else {
			System.out.println("Rebotaste en un tier: " + tier + " conseguiste " + score + " puntos! " + "(" + Pinball.numBounces + ")" + " Total: " + "("
			        + this.score + ")");
		}

	}

	/**
	 * Metodo que devuelve verdadero o falso dependiendo si lo introducido es mayor a 1 o menor
	 * 
	 * @param
	 */
	private Boolean addOrSubstract(int random) {

		// Si devuelve positivo suma, si devuelve negativo resta
		return (random > 0 && random < 80) ? true : false;
	}

	/**
	 * Metodo que genera numeros de forma aleatoria en un rango especifico
	 * 
	 * @param
	 */
	private int generateRandomNumbers(int min, int max) {

		return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}

	/**
	 * Metodo que devuelve el numero de rebotes
	 * 
	 * @return the numBounces
	 */
	public static int getNumBounces() {
		return numBounces;
	}

	/**
	 * Método que devuelve la puntuación
	 * 
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Metodo que establece la puntuación
	 * 
	 * @param
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Metodo que devuelve el nombre del jugador
	 * @return the player
	 */
	public String getPlayer() {
		return player;
	}

	/**
	 * Metodo que establece el nombre del jugador
	 * @param player
	 *            the player to set
	 */
	public void setPlayer(String player) {
		this.player = player;
	}

}
