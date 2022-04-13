package generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Desktop;

public class Tester implements Generator {

	private static String[] elements = {"h1", "p", "a", "table", "tr", "td"};
	
	public static void generateDoc(String nev, String email) {
		
		List<String> elementList = new ArrayList<>(Arrays.asList(elements));
		System.out.println("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<title>Teszt Feladat</title>\n"
				+ "</head>\n"
				+ "<body>");
		
		if (elementList.contains("h1")) {
			System.out.println("<h1>Teszt Feladat</h1>");
		}
		
		if (elementList.contains("a")) { 
			System.out.println("<p><a href=valami>Megoldás</a></p>");
		}
		
		if (elementList.contains("p")) { 
			System.out.println("<p>A feladat elkészítõjének adatai</p>");
		}
		
		if (elementList.contains("table")) { 
			System.out.println("<table border=\"1px solid black\">");
			if (elementList.contains("tr")) {
				System.out.println("<tr>");
				if (elementList.contains("td")) {
					System.out.println("<td>Név</td>\n<td>" + nev + "</td>");
				}
				System.out.println("</tr>\n<tr>");
				if (elementList.contains("td")) {
					System.out.println("<td>Elérhetõségek</td>\n<td>" + email + "</td>");
				}
				System.out.println("</tr>");
			}
			System.out.println("</table>");
		}
		System.out.println("<a href=\"http://lpsolutions.hu\">L&P Solutions</a>\n"
				+ "</body\n>"
				+ "</html>\n");
	
	}
	
	public static void generateFile(String nev, String email) {
		
		List<String> elementList = new ArrayList<>(Arrays.asList(elements));
		
		try {
		FileWriter fileWriter = new FileWriter("tesztfeladat.html");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print("<!DOCTYPE html>\n<html>\n<head>\n<title>Teszt Feladat</title>\n</head>\n<body>");
		if (elementList.contains("h1")){
			printWriter.print("<h1>Teszt Feladat</h1>\n");
		}
		if (elementList.contains("a")){
			printWriter.print("<p><a href=\"https://github.com/csmark5/htmlgenerator\">Megoldás</a></p>\n");
		}
		if (elementList.contains("p")){
			printWriter.print("<p>A feladat elkészítõjének adatai</p>\n");
		}
		if (elementList.contains("table")){
			printWriter.print("<table border=\"1px solid black\">\n");
			if (elementList.contains("tr")){
				printWriter.print("<tr>\n");
				if (elementList.contains("td")){
					printWriter.printf("<td>Név</td>\n<td>%s</td>\n", nev);
				}
				printWriter.print("</tr>\n<tr>\n");
				if (elementList.contains("td")){
					printWriter.printf("<td>Elérhetõségek</td>\n<td>%s</td>\n", email);
				}
				printWriter.print("</tr>\n");
			}
			printWriter.print("</table>\n");
		}
		printWriter.print("<a href=\"http://lpsolutions.hu\">L&P Solutions</a>\n"
				+ "</body>\n"
				+ "</html>\n");
		
		printWriter.close();
		
		//File finalFile = new File("C:/Users/csmar/eclipse-workspace/html_generator/tesztfeladat.html");
		//Desktop.getDesktop().browse(finalFile.toURI());
		
		
	} catch (IOException e) { System.out.println("File error");} }
	
	public static void removeElement(String[] elements, String removeable) {
		int index;
		String[] copy = new String[elements.length-1];
		for (int i = 0, j = 0; i < elements.length; i++) {
			if (elements[i] != removeable) {
				copy[j] = elements[i];
				j++;
			}
		}
		elements = copy;
	}
    		
	public static void main(String[] args)
	{
		
		removeElement(elements, "table");
		generateDoc(args[0], args[1]);
		generateFile(args[0], args[1]);
		
	}
	
}
