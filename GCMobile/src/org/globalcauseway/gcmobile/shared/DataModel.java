package org.globalcauseway.gcmobile.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.globalcauseway.gcmobile.client.css.AppBundle;
import org.globalcauseway.gcmobile.shared.dto.Product;
import org.globalcauseway.gcmobile.shared.dto.ProductCategory;

public class DataModel {
	
	private static List<Product> products;
	private static List<ProductCategory> catecories;
	private static List<String> trivia;
	static {
		trivia = new ArrayList<String>();
		trivia.add("Ethical fashion maximises benefits to the people and communities while minimising impacts on the environment");
		trivia.add("Fair trade is considered an important component of ethical fashion");
		trivia.add("Conventionally grown cotton uses more insecticide than any other crop in the world");
		trivia.add("Ethical fashion promotes the healthier growth of underwater organisms by eliminating contaminants in surface run-off.");
		trivia.add("Did you know that the ecological devastation of the Aral sea is almost entirely due to cotton production?");
		trivia.add("Every day, pesticides that are sprayed on commercial cotton dissolve in rain ending up on other plants");
		trivia.add("One of the causes of rising sea levels is the production of synthetic fibres such as Nylon");
		trivia.add("Carbon emissions from agricultural soil can be reduced by reducing fertiliser use");
		trivia.add("Organic farming reduces carbon dioxide emissions by 25%");
		trivia.add("In 2007, 265,517 bales of organic cotton were produced in 24 countries worldwide");
		trivia.add("Ethical fashion requires the use of only ethically sourced animal products");
		trivia.add("Birth defects can be caused by a build-up of pesticides in the body");
		trivia.add("Commercial Cotton represents 2.5% of the world’s cultivated land, but 16% of pesticide use");
		trivia.add("Excessive exposure to pesticides has been linked to a risk of cancer");
		trivia.add("Believe it or not, soil is the third largest carbon pool on Earth's surface?");
		trivia.add("Ethical Fashion reduces the use of pesticides, carbon dioxide emissions and increases health standards");
		trivia.add("Ethical Fashion is at the forefront of Fashion Forward conferences and Forums");
		trivia.add("Organic clothing is made from fibre grown without the use of pesticides or other toxic substances");
		trivia.add("Organic Cotton production is growing at the rate of 50% each year");
		
		Map<String, String> wesay = new HashMap<String, String>();
		wesay.put("Etrican", "Etrican is taking the certification route to ensure the materials they used are sustainably-sourced. Score has been adjusted as they are not required by law to disclose profits.");
		wesay.put("Zhai","Zhai is committed to good work. Main business dealing with environmentally-friendly fabrics is a huge plus. Score has been adjusted as they are not required by law to disclose profits.");
		Map<String, String> theysay = new HashMap<String, String>();
		theysay.put("Etrican", "Coming Soon.");
		theysay.put("Zhai", "Zhai is big on the " 
				+"environment, and has several " 
+"initiatives such as shop LED lights," 
+"recycled/upcycled packaging, and " 
+"selling clothes made from organic " 
+"material. They also participate in a " 
+"number of charity fundraisers and" 
+"donation drives, and support " 
+"overseas charities.");
		
		products =  new ArrayList<Product>();
		catecories =  new ArrayList<ProductCategory>();
		
		catecories.add(new ProductCategory("Apparel - Female",1));
		catecories.add(new ProductCategory("Apparel - Male",2));
		
		Product p1 = new Product("Etrican",1);
		p1.setPhilanthropy("No");
		p1.setCategory(1);
		p1.setId(3);
		p1.setQuantum("Undisclosed");
		p1.setGlobes("1.0");
		p1.setImgUrl("Globe_1.png");
		p1.setImage(AppBundle.INSTANCE.Globe_1Image());
		p1.setCauses("Environment");
		p1.setLogo(AppBundle.INSTANCE.defaut_logo());
		p1.setTheySay(theysay.get(p1.getName()));
		p1.setWeSay(wesay.get(p1.getName()));
		p1.setCategoryname(getProductCategoryNmae(p1.getCategory()));
		
		Product p2 = new Product("Zhai", 2);
		p2.setPhilanthropy("Yes");
		p2.setCategory(1);
		p2.setId(2);
		p2.setQuantum("Undisclosed");
		p2.setGlobes("3");
		p2.setImgUrl("Globe_3.png");
		p2.setImage(AppBundle.INSTANCE.Globe_3Image());
		p2.setLogo(AppBundle.INSTANCE.zai_logo38());
		p2.setCauses("Environment");
		p2.setTheySay(theysay.get(p2.getName()));
		p2.setWeSay(wesay.get(p2.getName()));
		p2.setCategoryname(getProductCategoryNmae(p2.getCategory()));
		
		Product p3 = new Product("Zhai", 3);
		p3.setPhilanthropy("Yes");
		p3.setCategory(2);
		p3.setId(1);
		p3.setQuantum("Undisclosed");
		p3.setGlobes("3");
		p3.setImgUrl("Globe_3.png");
		p3.setImage(AppBundle.INSTANCE.Globe_3Image());
		p3.setLogo(AppBundle.INSTANCE.zai_logo38());
		p3.setCauses("Environment,"
+"\nPoverty,"
+"\nCapacity Building,"
+"\nEducation");
		p3.setTheySay(theysay.get(p3.getName()));
		p3.setWeSay(wesay.get(p3.getName()));
		p3.setCategoryname(getProductCategoryNmae(p3.getCategory()));
		
		products.add(p1);
		products.add(p2);
		products.add(p3);

		
	}
	
	public List<Product> getAllProducts() {
		return products;
	}
	
	public List<ProductCategory> getAllCategoryProducts() {
		return catecories;
	}
	public List<Product> getProductsByCategoryId(int categoryId) {
		
		List<Product> products = new ArrayList<Product>();
		for (Product product : getAllProducts()) {
			if (product.getCategory() == categoryId) {
				products.add(product);
			}
		}
		return products;
	}

	public static List<String> getTrivia() {
		return trivia;
	}

	public static void setTrivia(List<String> trivia) {
		DataModel.trivia = trivia;
	}
	
	public static String getProductCategoryNmae(int categoryId) {
		
		String products = "";
		for (ProductCategory product : catecories) {
			if (product.getId() == categoryId) {
				products = product.getName();
			}
		}
		return products;
	}

}
