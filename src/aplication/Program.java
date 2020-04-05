package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservas;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Quarto numero: ");
		int numero = sc.nextInt();
		System.out.print("Check-in data (dd/MM/yyyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out data (dd/MM/yyyy)");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: a data de check-out deve ser posterior a data de check-in ");
		}
		else {
			Reservas reserva = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com os dados novos da reserva");
			System.out.print("Check-in data (dd/MM/yyyy)");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/yyyy)");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)){
				System.out.println("Erro na reserva: as datas da reserva para atualização devem ser futuras");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: a data de check-out deve ser posterior a data de check-in ");
			}
			else {
				reserva.atualizaData(checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
		}
		}
		
		
		
		sc.close();
	}

}
