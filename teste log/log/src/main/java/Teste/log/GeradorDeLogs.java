package Teste.log;

import static java.lang.Thread.sleep;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class GeradorDeLogs {


		public void log() throws IOException {
			while(true) {
			Thread tr1 = new Thread() {
				@Override
				public void run() {
					try {


			File logs = new File("C:\\Users\\uppda\\OneDrive\\Área de Trabalho\\Logg.txt");
			  try {
					sleep(1000);
				} catch (InterruptedException e1) {
																	e1.printStackTrace();
				}
			if (!logs.exists()) {
				logs.createNewFile();
				System.out.println("existe");
			}
			
			
			List<String> lista = new ArrayList<String>();
			System.out.println("adicionou");
			lista.add("Esse Demônio só me faz passar dor de cabeça e ficar depressivo");
			lista.add("Informações: "
					+ LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

			Files.write(Paths.get(logs.getPath()), lista, StandardOpenOption.APPEND);}
					catch (Exception e) {
				e.printStackTrace(System.err);
			}}};
			tr1.start();
			
	}}

		
}