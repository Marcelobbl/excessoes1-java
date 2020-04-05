package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {
	private Integer quartoNumero;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservas(Integer quartoNumero, Date checkIn, Date checkOut) {
		this.quartoNumero = quartoNumero;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getQuartoNumero() {
		return quartoNumero;
	}

	public void setQuartoNumero(Integer quartoNumero) {
		this.quartoNumero = quartoNumero;
	}

	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long diferenca = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	public String atualizaData(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)){
			return "As datas da reserva para atualização devem ser futuras";
		}
		if(!checkOut.after(checkIn)) {
			return "A data de check-out deve ser posterior a data de check-in ";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	

	@Override
	public String toString() {
		return "Quarto "
				+ quartoNumero + 
				", checkIn: " 
				+ sdf.format(checkIn)
				+ ", checkOut: " 
				+ sdf.format(checkOut)
				+", "
				+ duracao()
				+ " noites";
		
	}
	
	
	
}
