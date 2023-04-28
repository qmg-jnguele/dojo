package com.qmetric.dojo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SymbolReplacerTest {
    @ParameterizedTest
    @CsvSource({
            "Welcome to this $COMPANY $ACTIVITY, Welcome to this Policy Expert coding dojo",
            "This $NONEXISTENT_SYMBOL should not be replaced, This $NONEXISTENT_SYMBOL should not be replaced"
    })
    void translateSentence(String sentenceToTranslate, String expectedSentence) {
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
