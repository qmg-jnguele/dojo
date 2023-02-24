package com.qmetric.dojo;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SymbolReplacerTest {
    @Test
    void translateSentence() {
        var sentenceToTranslate = "Welcome to this $COMPANY $ACTIVITY";
        var expectedSentence = "Welcome to this Policy Expert coding dojo";

        var result = new TestSymbolReplacer(sentenceToTranslate).replace();
        assertThat(result).isEqualTo(expectedSentence);
    }

    static class TestSymbolReplacer extends SymbolReplacer {
        private static final Map<String, String> translations = Map.of(
                "COMPANY", "Policy Expert",
                "ACTIVITY", "coding dojo"
        );

        TestSymbolReplacer(String s) {
            super(s);
        }

        @Override
        String getSymbol(String symbolName) {
            return translations.get(symbolName);
        }
    }
}
