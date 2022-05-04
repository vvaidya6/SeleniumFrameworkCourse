package com.tmb.testdata;

import com.creditdatamw.zerocell.annotation.Column;
import com.creditdatamw.zerocell.converter.IntegerConverter;

public class Testdata {

    @Column(name = "testcasename", index = 0)
    public String testcasename;

    @Column(name = "username", index = 1)
    public String username;

    @Column(name = "password", index = 2)
    public String password;

    @Column(name = "expectedTitle", index = 3)
    public String expectedTitle;

}
