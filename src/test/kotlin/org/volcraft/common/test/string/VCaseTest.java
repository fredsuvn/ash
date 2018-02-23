package org.volcraft.common.test.string;


import org.jetbrains.annotations.NotNull;
import org.volcraft.common.base.NamingCase;
import org.volcraft.common.base.DelimiterCaseJoiner;

public class VCaseTest {

    public static void main(String[] args) {
//        VCases.c
//        CamelSplitter cs = null;
        DelimiterCaseJoiner delimiterJoiner = new DelimiterCaseJoiner("$", true);
        System.out.println(delimiterJoiner.join(new String[]{"a", "s", "d"}));
    }
}


class MyCase extends NamingCase {

    @NotNull
    @Override
    protected VCaseSplitter getSplitter() {
        return null;
    }

    @NotNull
    @Override
    protected VCaseJoiner getJoiner() {
        return null;
    }

    @NotNull
    @Override
    public String getName() {
        return "MyCase";
    }
}