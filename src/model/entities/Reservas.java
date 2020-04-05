package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.excessoes.DominioExcessao;

public class Reservas {
	private Integer quartoNumero;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservas(Integer quartoNumero, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
			throw new DominioExcessao("A data de check-out deve ser posterior a data de check-in ");
		}
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
	public void atualizaData(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)){
			throw new DominioExcessao( "As datas da reserva para atualização devem ser futuras");
		}
		if(!checkOut.after(checkIn)) {
			throw new DominioExcessao("A data de check-out deve ser posterior a data de check-in ");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
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
