package com.qmetric.dojo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class SymbolReplacer {
    private static final Pattern SYMBOL_PATTERN = Pattern.compile("\\$([a-zA-Z]\\w*)");
    private final Matcher symbolMatcher;
    protected String stringToReplace;
    protected List<String> alreadyReplaced = new ArrayList<>();

    SymbolReplacer(String s) {
        this.stringToReplace = s;
        symbolMatcher = createMatcher(stringToReplace);
    }

    String replace() {
        while (symbolFound()) {
            replaceSymbolFound();
        }
        return stringToReplace;
    }

    private void replaceSymbolFound() {
        String symbolName = getCurrentSymbolName();
        if (canReplaceSymbol(symbolName)) {
            replaceSymbol(symbolName);
        }
    }

    private String getCurrentSymbolName() {
        return symbolMatcher.group(1);
    }

    private boolean canReplaceSymbol(String symbolName) {
        return symbolExists(symbolName) && symbolNotReplacedYet(symbolName);
    }

    private boolean symbolFound() {
        return symbolMatcher.find();
    }

    private void replaceSymbol(String symbolName) {
        stringToReplace = stringToReplaceAfterReplacingSymbol(symbolName);
        markSymbolAsReplaced(symbolName);
    }

    private void markSymbolAsReplaced(String symbolName) {
        alreadyReplaced.add(symbolName);
    }

    private String stringToReplaceAfterReplacingSymbol(String symbolName) {
        return stringToReplace.replace("$" + symbolName, translate(symbolName));
    }

    private boolean symbolNotReplacedYet(String symbolName) {
        return !alreadyReplaced.contains(symbolName);
    }

    private boolean symbolExists(String symbolName) {
        return getSymbol(symbolName) != null;
    }

    private Matcher createMatcher(String input) {
        return SYMBOL_PATTERN.matcher(input);
    }

    protected String translate(String symbolName) {
        return getSymbol(symbolName);
    }

    abstract String getSymbol(String symbolName);
}
