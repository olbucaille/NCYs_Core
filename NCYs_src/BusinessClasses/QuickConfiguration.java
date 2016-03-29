package BusinessClasses;

public class QuickConfiguration {

	
	private int Id_Application;
	private String Position;
	private boolean Active;
	
	public QuickConfiguration(int id_Application, String position, boolean active) {
		super();
		Id_Application = id_Application;
		Position = position;
		Active = active;
	}

	@Override
	public String toString() {
		return " {\"Id_Application\" :" + Id_Application + ",\n"
				+ "\"Position\":" + Position + ",\n"
				+ " \"Active\":" + Active+"\n"
				+ "}";
	}
	
	
	
}
	

