package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservas;
import model.excessoes.DominioExcessao;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try { 
			System.out.print("Quarto numero: ");
			int numero = sc.nextInt();
			System.out.print("Check-in data (dd/MM/yyyy)");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/yyyy)");
			Date checkOut = sdf.parse(sc.next());
			
			Reservas reserva = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
				
			System.out.println();
			System.out.println("Entre com os dados novos da reserva");
			System.out.print("Check-in data (dd/MM/yyyy)");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/yyyy)");
			checkOut = sdf.parse(sc.next());
				
			reserva.atualizaData(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Formato da data invalido");
		}
		catch (DominioExcessao e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
	
		sc.close();
	}

}
