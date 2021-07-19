package a;

public class Rectangle {

	private int w ;
	private int l ;

	public Rectangle(int w, int l) {
		super();
		this.w = w;
		this.l = l;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) throws Exception {
		if (w >= 0) {
		this.w = w;
		}else {
			throw new Exception("width cannot be negetive: " + w);
		}
	}

	public int getL() {
		return l;
	}

	public void setL(int l) throws Exception {
		if (l >=0) {
			this.l = l;
		}else {
			throw new Exception("legnth cannot be negetive: " + l);
		}
		
	}

	@Override
	public String toString() {
		return "Rectangle [w=" + w + ", l=" + l + "]";
	}

}
