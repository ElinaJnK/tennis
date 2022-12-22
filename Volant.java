public class Volant {
	private int x, y;

	public Volant(int x, int y) {
		this.x = x;
		this.y = y;
	}
  //permet de faire tomber le volant au pif sur le terrain
	public void randomDrop(int maxX, int minX, int maxY, int minY) {
		this.x = (int) (Math.random() * (maxX - minX) + minX);
		this.y = (int) (Math.random() * (maxY - minY) + minY);
	}
  //retourne la position x du volant
	public int getX() {
		return x;
	}
  //retourne la position y du volant
	public int getY() {
		return y;
	}
  //permet de changer la position x du volant
	public void setX(int x) {
		this.x = x;
	}
  //permet de changer la position y du volant
	public void setY(int y) {
		this.y = y;
	}
}
