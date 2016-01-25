import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractNumbers {
	ArrayList<String> Nummers = new ArrayList<>();
	String varDate = "";	
	public ExtractNumbers(String varDate){

		ArrayList<String> Nummers = new ArrayList<>(); 
		Document doc = null;
		this.varDate = varDate;
		//File input = new File("C:/Users/User/Documents/Eclipse Projecten/ExtractNumbers/numbers.html");
		String baseURL = "https://www.loten.nl/trekkingsuitslagen/lotto/";
		
		try {
			//doc = Jsoup.parse(input, "UTF-8", "");
			doc = Jsoup.connect(baseURL + varDate).get();
			Element content = doc.getElementById("draw-current-lotto-output");
			Elements links = content.getElementsByClass("ball");
			
			for (Element link : links) {
				//String linkHref = link.attr("href");
				String linkText= link.text();
				System.out.println(linkText);
				Nummers.add(linkText);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Geen trekking gevonden");
			//e.printStackTrace();
		}

	}
	
	public String getTrekkingDate(){
		return varDate;
	}

	

}
