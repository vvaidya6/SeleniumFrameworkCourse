package com.tmb.tests;

import com.tmb.testdata.Testdata;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;
import org.testng.annotations.Test;

public class DataSupplierTest {


    @Test(dataProvider = "getData")
    public void dataSupplierTest(Testdata testdata){
        System.out.println(testdata.username);

    }


    @DataSupplier
    public StreamEx<Testdata> getData(){
        return TestDataReader.use(XlsxReader.class)
                .withTarget(Testdata.class)
                .withSource("testdata.xlsx")
                .read();
    }
}
