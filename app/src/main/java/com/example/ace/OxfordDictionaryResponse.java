package com.example.ace;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.xml.transform.Result;

public class OxfordDictionaryResponse {
    @SerializedName("results")
    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public static class Result {
        @SerializedName("lexicalEntries")
        private List<LexicalEntry> lexicalEntries;
        public List<LexicalEntry> getLexicalEntries() {
            return lexicalEntries;
        }
        public void setLexicalEntries(List<LexicalEntry>lexicalEntries) {
            this.lexicalEntries = lexicalEntries;
        }
        public static class LexicalEntry {
            @SerializedName("entries")
            private List<Entry> entries;
            public List<Entry> getEntries() {
                return entries;
            }
            public void setEntries(List<Entry> entries) {
                this.entries = entries;
            }

            public static class Entry {
                @SerializedName("senses")
                private List<Sense>senses;
                public List<Sense> getSenses() {
                    return senses;
                }

                public void setSenses(List<Sense> senses) {
                    this.senses = senses;
                }
                public static class Sense {
                    @SerializedName("definitions")
                    private List<String> definitions;
                    public List<String> getDefinitions() {
                        return definitions;
                    }
                    public void setDefinitions(List<String> definitions) {
                        this.definitions = definitions;
                    }
                }
            }
        }
    }
}
