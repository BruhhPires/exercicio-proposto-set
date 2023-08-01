package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the file full path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			Set<LogEntry> set = new HashSet<>(); //É O MAIS RÁPIDO DE TODOS
			String line = br.readLine();         //SERÁ ACOPLADO CADA LINHA
			while (line != null) {				 // ENQUANTO A LINHA NÃO É NULA
				String[] fields = line.split(" "); 	//A LINHA SERÁ DIVIVIDA PELO ESPAÇO
				String username = fields[0];		//USERNAME NO CAMPO 0
				Date moment = Date.from(Instant.parse(fields[1])); //DATE NO CAMPO 1
				
				set.add(new LogEntry(username, moment)); // AQUI ADICIONAMOS AS INFORMAÇÕES COM SET (NÃO ACEITARÁ REPETIDAS)
				
				line = br.readLine();       // AQUI CONTINUARÁ O LOOP LENDO A PROXIMA LINHA
			}
			
			System.out.println("Total users: " + set.size()); // ESSE METODO IMPRIME O TAMANHO DO CONJUNTO

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}

}

