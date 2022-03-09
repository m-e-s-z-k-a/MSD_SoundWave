public class Point {

	public Point nNeighbor;
	public Point wNeighbor;
	public Point eNeighbor;
	public Point sNeighbor;
	public float nVel;
	public float eVel;
	public float wVel;
	public float sVel;
	public float pressure;
	public static Integer[] types = {0, 1, 2};
	int type;
	int sinInput = 0;

	public Point() {
		this.type = 0;
		clear();
	}

	public void clicked() {
		pressure = 1;
	}
	
	public void clear()
	{
		this.eVel = 0;
		this.nVel = 0;
		this.sVel = 0;
		this.wVel = 0;
		this.pressure = 0;
		// TODO: clear velocity and pressure
	}

	public void updateVelocity()
	{
		if (this.type == 0)
		{
		this.eVel = this.eVel - (this.eNeighbor.pressure - this.pressure);
		this.wVel = this.wVel - (this.wNeighbor.pressure - this.pressure);
		this.nVel = this.nVel - (this.nNeighbor.pressure - this.pressure);
		this.sVel = this.sVel - (this.sNeighbor.pressure - this.pressure);
		}
		// TODO: velocity update
	}

	public void updateSinInput()
	{
		this.sinInput = sinInput + 10;
		if (this.sinInput >= 360)
		{
			this.sinInput -= 360;
		}
	}

	public void updatePresure()
	{
		if (this.type == 0)
		{
		this.pressure = (float) (this.pressure - 0.5*(this.wVel + this.eVel + this.sVel + this.nVel));
		}
		else if (this.type == 2)
		{
			double radians = Math.toRadians(sinInput);
			pressure = (float) (Math.sin(radians));
		}
		// TODO: pressure update
	}

	public float getPressure() {
		return pressure;
	}
}