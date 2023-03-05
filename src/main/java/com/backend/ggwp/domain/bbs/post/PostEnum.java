package com.backend.ggwp.domain.bbs.post;

public enum PostEnum {
    TOP("TOP"), JUG("JUG"), MID("MID"), ADC("ADC"), SUP("SUP"), FREE("FREE");
    private final String tag;

    PostEnum(String tag) {
        this.tag = tag;
    }

    public String tag() {
        return tag;
    }
}
