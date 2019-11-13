package test.project.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import test.project.model.Oil;
import test.project.model.OilType;
import test.project.model.TransactionRowInfo;
import test.project.model.TransactionType;

public class OilAPIImpl implements OilAPI {

	private final List<Oil> oils;

	public OilAPIImpl(List<Oil> oils) {
		this.oils = oils;
	}

	@Override
	public double getInventoryIndex(List<TransactionRowInfo> transactions) {
		return transactions.stream().mapToDouble(x -> x.getPrice()).reduce(1, Double::sum);
	}

	@Override
	public TransactionRowInfo getTransactionInfoBase(double price, OilType oilType, TransactionType transactionType) {
		double revenueYieldValue = 0;
		int originalQuantity = 0;

		for (Oil oil : this.oils) {
			if (oilType == oil.getType()) {
				revenueYieldValue += oil.getRevenue(price);
				originalQuantity++;
			}
		}
		double priceEarningsRatio = 0;
		if (0 != price) {
			priceEarningsRatio = revenueYieldValue / price;
		}
		if (TransactionType.BUY == transactionType) {
			originalQuantity = originalQuantity + 1;
		} else if (TransactionType.SELL == transactionType) {
			originalQuantity = originalQuantity - 1;
		}

		return new TransactionRowInfo(LocalDateTime.now(), originalQuantity, transactionType, priceEarningsRatio);

	}

	@Override
	public double getVolumeWeightValue(List<TransactionRowInfo> transactions) {
		LocalDateTime past30minDate = LocalDateTime.now().minusMinutes(30);
		List<TransactionRowInfo> result = transactions.stream().filter(x -> x.getCreatedDate().isAfter(past30minDate))
				.collect(Collectors.toList());
		double pricesSum = result.stream().collect(Collectors.summingDouble(x -> x.getPrice()));
		double quantitySum = result.stream().collect(Collectors.summingDouble(x -> x.getQuantity()));
		return pricesSum / quantitySum;
	}

}
