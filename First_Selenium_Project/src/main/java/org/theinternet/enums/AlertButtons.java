package org.theinternet.enums;

public enum AlertButtons {
    ALERT("JS Alert", "jsAlert()"),
    CONFIRM("JS Confirm", "jsConfirm()"),
    PROMPT("JS Prompt", "jsPrompt()");



    private final String TEXT_ON_BUTTON;

    private final String ON_CLICK_JS_FUNCTION;

    AlertButtons(String TEXT_ON_BUTTON, String ON_CLICK_JS_FUNCTION) {
        this.TEXT_ON_BUTTON = TEXT_ON_BUTTON;
        this.ON_CLICK_JS_FUNCTION = ON_CLICK_JS_FUNCTION;
    }

    public String getTEXT_ON_BUTTON() {
        return TEXT_ON_BUTTON;
    }

    public String getON_CLICK_JS_FUNCTION() {
        return ON_CLICK_JS_FUNCTION;
    }
}
