package com.tmb.utils;

import com.tmb.testdata.Testdata;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;

import java.lang.reflect.Method;

public class DataProviderUtils {

    @DataSupplier(runInParallel = true)
    public StreamEx<Testdata> getData(Method method){
        return TestDataReader.use(XlsxReader.class)
                .withTarget(Testdata.class)
                .withSource("testdata.xlsx")
                .read()
                .filter(testdata -> testdata.testcasename.equalsIgnoreCase(method.getName()));
    }
}
