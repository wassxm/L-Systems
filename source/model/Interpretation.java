package model;
/*La classe "Interpretation" est utilisée pour effectuer des calculs de coordonnées dans le contexte d'un système L-système en 2D 
et en 3D. Elle contient plusieurs méthodes pour effectuer des rotations en 2D et en 3D, calculer les coordonnées à partir d'un système
 L-système, obtenir la longueur du reste d'une chaîne de caractères à partir d'un certain index, et d'autres fonctionnalités associées
  à la simulation de systèmes L-système. */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Interpretation {

	private static int beginWidth, beginHeight, beginX, beginY, beginZ;

	public static final Set<Character> cons = new HashSet<>(Arrays.asList('+', '-', '[', ']'));

	/**
	 * Effectue une rotation en 2D autour d'un point donné.
	 *
	 * @param Angle   L'angle de rotation en degrés.
	 * @param c1      Le point de départ de la rotation.
	 * @param c2      Le point d'arrivée de la rotation.
	 * @param longeur La longueur du segment de droite entre c1 et c2.
	 * @return Le nouveau point après rotation.
	 */
	public Coordinate rotation(double Angle, Coordinate c1, Coordinate c2, int longeur) {
		double xDiff = c2.getX() - c1.getX();
		double yDiff = c2.getY() - c1.getY();
		double alpha = Math.toRadians(Angle);
		double angle = Math.atan2(yDiff, xDiff);
		double newAngle = angle + alpha;
		int x3 = (int) (c2.getX() + longeur * Math.cos(newAngle));
		int y3 = (int) (c2.getY() + longeur * Math.sin(newAngle));

		return new Coordinate(x3, y3, 0);
	}

	/**
	 * Calcule les coordonnées d'un système L-système en 2D.
	 *
	 * @param ls Le système L-système à simuler.
	 * @return Une liste de coordonnées représentant la trajectoire de la simulation.
	 */
	public ArrayList<Coordinate> calculateCoordinates(AbstractLsystem ls) {
		ArrayList<Coordinate> resultas = new ArrayList<>();
		String chaine = ls.simulation();
		Coordinate c1 = new Coordinate(beginWidth, beginHeight, 0);
		Coordinate c2 = new Coordinate(beginWidth, beginHeight - ls.getLongeur(), 0);
		resultas.add(c2);
		double angle = 0;
		Stack stack = new Stack();
		for (int i = 0; i < chaine.length(); i++) {
			char c = chaine.charAt(i);

			if (c == '+') {
				if (angle != ls.getangle())
					angle += ls.getangle();
				if (chaine.charAt(i + 1) == '+') {
					angle += ls.getangle();
					i++;
				} else if (chaine.charAt(i + 1) == '-') {
					angle -= ls.getangle();
					i++;
				}
			} else if (c == '-') {
				if (angle == ls.getangle())
					angle = -ls.getangle();
				else
					angle -= ls.getangle();
				if (chaine.charAt(i + 1) == '+') {
					angle += ls.getangle();
					i++;
				} else if (chaine.charAt(i + 1) == '-') {
					angle -= ls.getangle();
					i++;
				}
			} else if (c == '[') {
				stack.push(c2);
				stack.push(c1);
				stack.push(angle);
			} else if (c == ']') {
				if (!stack.isEmpty()) {
					angle = 0;
					stack.pop();
					c1 = (Coordinate) stack.peek();
					stack.pop();
					c2 = (Coordinate) stack.peek();
					stack.pop();

					resultas.add(c2);
				}
			} else {
				int index = getRestOfString(chaine, i);
				if (index == 1) {
					Coordinate c3 = rotation(angle, c1, c2, ls.getLongeur() * index);
					c1 = c2;
					c2 = c3;
					angle = ls.getangle();
					resultas.add(c3);
				} else {
					Coordinate c3 = rotation(angle, c1, c2, ls.getLongeur() * index);
					c1 = c2;
					c2 = c3;
					angle = ls.getangle();
					resultas.add(c3);
					i = i + index - 1;
				}
			}

		}

		return resultas;
	}
	public ArrayList<Coordinate> calculateCoordinatesWithIndex(LSystem ls,int nbr) {
		ArrayList<Coordinate> resultas = new ArrayList<>();
		String chaine = ls.simulation(nbr);
		Coordinate c1 = new Coordinate(beginWidth, beginHeight, 0);
		Coordinate c2 = new Coordinate(beginWidth, beginHeight - ls.getLongeur(), 0);
		resultas.add(c2);
		double angle = 0;
		Stack stack = new Stack();
		Stack stack1 = new Stack();
		for (int i = 0; i < chaine.length(); i++) {
			char c = chaine.charAt(i);
			if (c == '+') {
				if (angle != ls.getangle())
					angle += ls.getangle();
				if (chaine.charAt(i + 1) == '+') {
					angle += ls.getangle();
					i++;
				} else if (chaine.charAt(i + 1) == '-') {
					angle -= ls.getangle();
					i++;
				}
			} else if (c == '-') {
				if (angle == ls.getangle())
					angle = -ls.getangle();
				else
					angle -= ls.getangle();
				if (chaine.charAt(i + 1) == '+') {
					angle += ls.getangle();
					i++;
				} else if (chaine.charAt(i + 1) == '-') {
					angle -= ls.getangle();
					i++;
				}
			} else if (c == '[') {
				stack.push(c2);
				stack.push(c1);
				stack.push(angle);
			} else if (c == ']') {
				if (!stack.isEmpty()) {
					angle = 0;// (double) stack.peek();
					stack.pop();
					c1 = (Coordinate) stack.peek();
					stack.pop();
					c2 = (Coordinate) stack.peek();
					stack.pop();

					resultas.add(c2);
				}
				else if(c == '('){
					stack1.push(c2);
					stack1.push(c1);
					stack1.push(angle);
				}
				else if(c == ')') {
					if(!stack1.isEmpty()) {
						angle =(double) stack1.peek();
						stack1.pop();
						c1 = (Coordinate) stack1.peek();
						stack1.pop();
						c2 = (Coordinate) stack1.peek();
						stack1.pop();
					}
				}
			} else {
				int index = getRestOfString(chaine, i);
				if (index == 1) {
					Coordinate c3 = rotation(angle, c1, c2, ls.getLongeur() * index);
					c1 = c2;
					c2 = c3;
					angle = ls.getangle();
					resultas.add(c3);
				} else {
					Coordinate c3 = rotation(angle, c1, c2, ls.getLongeur() * index);
					c1 = c2;
					c2 = c3;
					angle = ls.getangle();
					resultas.add(c3);
					i = i + index - 1;
				}
			}
		}
		return resultas;
	}

	/**
	 * Obtient la longueur du reste de la chaîne de caractères à partir d'un certain index.
	 *
	 * @param str   La chaîne de caractères.
	 * @param index L'index à partir duquel obtenir la longueur du reste de la chaîne.
	 * @return La longueur du reste de la chaîne à partir de l'index donné.
	 */
	public int getRestOfString(String str, int index) {
		String chaine = str.substring(index);
		int j = 0;
		for (int i = 0; i < chaine.length() - 1; i++) {
			if (cons.contains(chaine.charAt(i + 1)) == false) {
				j++;
			} else {
				return j + 1;
			}
		}
		return j + 1;
	}
	/**
	 * Effectue une rotation en 3D d'un vecteur autour des axes X, Y et Z.
	 *
	 * @param vector  Le vecteur à rotation.
	 * @param angleX  L'angle de rotation autour de l'axe X en radians.
	 * @param angleY  L'angle de rotation autour de l'axe Y en radians.
	 * @param angleZ  L'angle de rotation autour de l'axe Z en radians.
	 * @return Le nouveau vecteur après rotation.
	 */
	public Coordinate rotation3D(Coordinate vector, double angleX, double angleY, double angleZ) {
		double cosX = Math.cos(angleX);
		double sinX = Math.sin(angleX);
		double cosY = Math.cos(angleY);
		double sinY = Math.sin(angleY);
		double cosZ = Math.cos(angleZ);
		double sinZ = Math.sin(angleZ);

		double[][] rotX = { { 1, 0, 0 }, { 0, cosX, -sinX }, { 0, sinX, cosX } };
		double[][] rotY = { { cosY, 0, sinY }, { 0, 1, 0 }, { -sinY, 0, cosY } };
		double[][] rotZ = { { cosZ, -sinZ, 0 }, { sinZ, cosZ, 0 }, { 0, 0, 1 } };

		double newX1 = vector.getX() * rotX[0][0] + vector.getY() * rotX[1][0] + vector.getZ() * rotX[2][0];
		double newY1 = vector.getX() * rotX[0][1] + vector.getY() * rotX[1][1] + vector.getZ() * rotX[2][1];
		double newZ1 = vector.getX() * rotX[0][2] + vector.getY() * rotX[1][2] + vector.getZ() * rotX[2][2];

		double newX2 = newX1 * rotY[0][0] + newY1 * rotY[1][0] + newZ1 * rotY[2][0];
		double newY2 = newX1 * rotY[0][1] + newY1 * rotY[1][1] + newZ1 * rotY[2][1];
		double newZ2 = newX1 * rotY[0][2] + newY1 * rotY[1][2] + newZ1 * rotY[2][2];

		double newX3 = newX2 * rotZ[0][0] + newY2 * rotZ[1][0] + newZ2 * rotZ[2][0];
		double newY3 = newX2 * rotZ[0][1] + newY2 * rotZ[1][1] + newZ2 * rotZ[2][1];
		double newZ3 = newX2 * rotZ[0][2] + newY2 * rotZ[1][2] + newZ2 * rotZ[2][2];

		return new Coordinate(newX3, newY3, newZ3);
	}

	/**
	 * Calcule les coordonnées d'un système L-système en 3D.
	 *
	 * @param l Le système L-système à simuler.
	 * @return Une liste de coordonnées en 3D représentant la trajectoire de la simulation.
	 */
	public ArrayList<Coordinate> calculateCoordinates3D(AbstractLsystem l) {
		String simulation = l.simulation();
		ArrayList<Coordinate> coordinates = new ArrayList<>();
		Stack<Coordinate> positionStack = new Stack<>();
		Stack<Coordinate> directionStack = new Stack<>();
		Coordinate currentPosition = new Coordinate(beginX, beginY, beginZ);
		Coordinate currentDirection = new Coordinate(0, 1, 0);

		for (char c : simulation.toCharArray()) {
			if (c == '+') {
				currentDirection = rotation3D(currentDirection, +l.getangle(), l.getangle(), l.getangle());
			} else if (c == '-') {
				currentDirection = rotation3D(currentDirection, -l.getangle(), -l.getangle(), -l.getangle());
			} else if (c == '[') {
				positionStack.push(currentPosition);
				directionStack.push(currentDirection);
			} else if (c == ']') {
				currentPosition = positionStack.pop();
				currentDirection = directionStack.pop();
			} else {
				Coordinate newPosition = new Coordinate(
						currentPosition.getX() + l.getLongeur() * currentDirection.getX(),
						currentPosition.getY() + l.getLongeur() * currentDirection.getY(),
						currentPosition.getZ() + l.getLongeur() * currentDirection.getZ());
				coordinates.add(currentPosition);
				currentPosition = newPosition;
			}
		}

		coordinates.add(currentPosition);

		return coordinates;
	}

	/**
	 * Obtient la valeur de la hauteur initiale.
	 *
	 * @return La hauteur initiale.
	 */
	public static int getBeginHeight() {
		return beginHeight;
	}

	/**
	 * Obtient la valeur de la largeur initiale.
	 *
	 * @return La largeur initiale.
	 */
	public static int getBeginWidth() {
		return beginWidth;
	}

	/**
	 * Définit la valeur de la hauteur initiale.
	 *
	 * @param height La hauteur initiale à définir.
	 */
	public static void setBeginHeight(int Height) {
		beginHeight = Height;
	}
	/**
	 * Définit la valeur de la largeur initiale.
	 *
	 * @param width La largeur initiale à définir.
	 */
	public static void setBeginWidth(int Width) {
		beginWidth = Width;
	}

	/**
	 * Définit la valeur de la coordonnée X initiale.
	 *
	 * @param beginX La coordonnée X initiale à définir.
	 */
	public static void setBeginX(int beginX) {
		Interpretation.beginX = beginX;
	}

	/**
	 * Définit la valeur de la coordonnée Y initiale.
	 *
	 * @param beginY La coordonnée Y initiale à définir.
	 */
	public static void setBeginY(int beginY) {
		Interpretation.beginY = beginY;
	}

	/**
	 * Définit la valeur de la coordonnée Z initiale.
	 *
	 * @param beginZ La coordonnée Z initiale à définir.
	 */
	public static void setBeginZ(int beginZ) {
		Interpretation.beginZ = beginZ;
	}

}