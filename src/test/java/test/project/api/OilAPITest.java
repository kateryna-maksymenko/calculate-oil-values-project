package test.project.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import test.project.model.Oil;
import test.project.model.OilType;
import test.project.model.PremiumOil;
import test.project.model.StandardOil;
import test.project.model.TransactionRowInfo;
import test.project.model.TransactionType;

public class OilAPITest {

	private final List<Oil> oils = getTestOilValues();

	private OilAPI api = new OilAPIImpl(oils);

	@Test
	public void end2endTest() {
		TransactionRowInfo transactionRow1 = api.getTransactionInfoBase(33.2, OilType.STANDARD, TransactionType.BUY);
		assertEquals(5, transactionRow1.getQuantity());

		TransactionRowInfo transactionRow2 = api.getTransactionInfoBase(6.2, OilType.PREMIUM, TransactionType.SELL);
		assertEquals(0, transactionRow2.getQuantity());

		double volumeWeightValue = api.getVolumeWeightValue(Arrays.asList(transactionRow1, transactionRow2));
		assertNotNull(volumeWeightValue);

		double inventoryIndex = api.getInventoryIndex(Arrays.asList(transactionRow1, transactionRow2));
		assertNotNull(inventoryIndex);

	}

	private List<Oil> getTestOilValues() {
		List<Oil> result = new ArrayList<Oil>();
		StandardOil oil1 = new StandardOil();
		oil1.setId("AAC");
		oil1.setType(OilType.STANDARD);
		oil1.setFixedRevenue(1);
		oil1.setCost(42);

		StandardOil oil2 = new StandardOil();
		oil2.setId("REW");
		oil2.setType(OilType.STANDARD);
		oil2.setFixedRevenue(7);
		oil2.setCost(47);

		StandardOil oil3 = new StandardOil();
		oil3.setType(OilType.STANDARD);
		oil3.setId("BWO");
		oil3.setFixedRevenue(17);
		oil3.setCost(61);

		PremiumOil oil4 = new PremiumOil();
		oil4.setId("TIM");
		oil4.setFixedRevenue(5);
		oil4.setType(OilType.PREMIUM);
		oil4.setCost(111);
		oil4.setVariableRevenue(7);

		StandardOil oil5 = new StandardOil();
		oil5.setId("QFC");
		oil5.setType(OilType.STANDARD);
		oil5.setFixedRevenue(22);
		oil5.setCost(123);

		result.add(oil1);
		result.add(oil2);
		result.add(oil3);
		result.add(oil4);
		result.add(oil5);

		return result;
	}

}
