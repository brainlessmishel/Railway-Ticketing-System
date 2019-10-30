import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;

public class Counter_Check2{
	private String strain;
	private String tseat;
	private String sold;
	private String available;
	
	public Counter_Check2(String strain,String tseat, String sold, String available){
		this.strain=strain;
		this.tseat= tseat;
		this.sold= sold;
		this.available=available;
		
	}
	
	public String getStrain(){
		return strain;
	}
	public String getTseat(){
		return tseat;
	}
	public String getSold(){
		return sold;
	}
	public String getAvailable(){
		return available;
	}

	@Override
	public String toString() {
		return "Cancel_Reservation [strain=" + strain + ", tseat=" + tseat
				+ ", sold=" + sold + ", available=" + available + "]";
	}

	

}
