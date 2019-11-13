package test.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import test.project.model.Oil;
import test.project.model.PremiumOil;
import test.project.model.StandardOil;

public class Main {

	public static List<Oil> oils = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println(1.0/0);
		
		System.out.println("Input price value: ");

		Scanner scanner = new Scanner(System.in);
		String readString = scanner.nextLine();
		while (readString != null) {

			System.out.println(readString);

			if (readString.isEmpty()) {
				System.out.println("Read Enter Key.");
			}

//	        if (scanner.hasNextLine()) {
			readString = scanner.nextLine();
			String priceInString = readString;
			if (!isValid(priceInString)) {
				System.out.println("Invallid format of price.");
				return;
			}
			float price = Float.valueOf(priceInString);
			float revenueYieldForPremiumOil = 0;
			float revenueYieldForStandardOil = 0;
			for (Oil oil : oils) {

				if (oil instanceof PremiumOil) {
					revenueYieldForPremiumOil += oil.getRevenue(price);
				} else if (oil instanceof StandardOil) {
					revenueYieldForStandardOil += oil.getRevenue(price);
				}

			}
			System.out.println("Revenue yield for premium oil: " + revenueYieldForPremiumOil);
			System.out.println("Revenue yield for standard oil: " + revenueYieldForStandardOil);

			System.out.println("Price-Earnings Ratio for premium oil: " + price / revenueYieldForPremiumOil);
			System.out.println("Price-Earnings Ratio for standard oil: " + price / revenueYieldForStandardOil);

//	        } else {
//	            readString = null;
//	        }
		}

		String priceInString = System.console().readLine();
		if (!isValid(priceInString)) {
			System.out.println("Invallid format of price.");
			return;
		}
		float price = Float.valueOf(priceInString);
		float revenueYieldForPremiumOil = 0;
		float revenueYieldForStandardOil = 0;
		for (Oil oil : oils) {

			if (oil instanceof PremiumOil) {
				revenueYieldForPremiumOil += oil.getRevenue(price);
			} else if (oil instanceof StandardOil) {
				revenueYieldForStandardOil += oil.getRevenue(price);
			}

		}
		System.out.println("Revenue yield for premium oil: " + revenueYieldForPremiumOil);
		System.out.println("Revenue yield for standard oil: " + revenueYieldForStandardOil);

		System.out.println("Price-Earnings Ratio for premium oil: " + price / revenueYieldForPremiumOil);
		System.out.println("Price-Earnings Ratio for standard oil: " + price / revenueYieldForStandardOil);

	
	}

	private static boolean isValid(String price) {
		try {
			Double.parseDouble(price);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}
}
