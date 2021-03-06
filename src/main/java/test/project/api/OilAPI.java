package test.project.api;

import java.util.List;

import com.google.common.cache.RemovalListener;
import test.project.model.OilType;
import test.project.model.TransactionRowInfo;
import test.project.model.TransactionType;

public interface OilAPI {

    TransactionRowInfo getTransactionInfoBase(double price, OilType oilType, TransactionType transactionType);

    double getInventoryIndex(List<TransactionRowInfo> transactions);

    double getVolumeWeightValue(List<TransactionRowInfo> transactions);

    default void helloWorld() {
        System.out.println("hello world");

    }

}
