package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;


public final class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine(int size) {
        this.searchables = new ArrayList<>(size);
    }

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(query)) {
                results.add(searchable);
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String searchTerm = searchable.getSearchTerm();
                int count = countOccurrences(searchTerm, search);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = searchable;
                }
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }
        return bestMatch;
    }

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        int substringLength = substring.length();
        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index = index + substringLength;
        }
        return count;
    }
}