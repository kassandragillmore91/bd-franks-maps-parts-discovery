package com.amazon.ata.maps.partsdiscovery;

import javax.security.auth.login.AccountNotFoundException;
import java.util.*;

/**
 * Helps expose key words from new editions of part catalogs.
 */
public class DevicePartDiscovery {

    // --- Part A ---
    /**
     * Calculate how often each word appears in a Catalog.
     * @param catalog The catalog to calculate word frequencies for.
     * @return A Map of words that appear in the catalog to the number of times they appear.
     */
    public Map<String, Integer> calculateWordCounts(PartCatalog catalog) {
        // PARTICIPANTS: Implement calculateWordCounts()
        // instantiate the object to be returned (returnMap)
        Map<String, Integer> returnedMap = new HashMap<>();
        // go through all the words in the PartCatalog catalogWordList
        for (String aWord : catalog.getCatalogWords()) {
            //      check to see if the word is already in the returnedMap
            if (returnedMap.containsKey(aWord)) {               // if it is in the returnedMap
                int currentCount = returnedMap.get(aWord) + 1;  // get the current count for the word from the returnMap and increment count
                returnedMap.put(aWord, currentCount);           // put the current count for the word back in the returned
            } else {                                            // if it's not in the returnedMap
                returnedMap.put(aWord, 1);                      // add current word to returnedMap with count of 1
            }
        }
        // return the object expected
        return returnedMap;
    }

    // --- Part B ---
    /**
     * Removes a word from the provided word count map.
     * @param word the word to be removed
     * @param wordCounts the map to remove the word from
     */
    public void removeWord(String word, Map<String, Integer> wordCounts) {
        // PARTICIPANTS: Implement removeWord()
        wordCounts.remove(word);
    }

    // --- Part C ---
    /**
     * Find the word that appears most frequently based on the word counts from a catalog.
     * @param wordCounts an association between a word and the total number of times it appeared in a catalog
     * @return The word that appears most frequently in the catalog to the number of times they appear.
     */
    public String getMostFrequentWord(Map<String, Integer> wordCounts) {
        // PARTICIPANTS: Implement getMostFrequentWord()
        // Word count is the VALUE in an entry in the Map
        // TreeMap will keep the entries in KEY sequence - there is no map version that keeps value sequence

        // instantiate String to be returned
        String mostFrequentWord = "";

        // hold highest count as we iterate through the map
        int highestCountSoFar = 0;

        // iterate through the map, remembering the key with the highest word count
        // Map.Entry: represents an entry in a Map, .entrySet() returns all the entries in a Map
        // foreach loop says to look through entire Map, one entry at a time
        for (Map.Entry<String, Integer> anEntry : wordCounts.entrySet()) {
            // if the value in anEntry is > highestCountSoFar
            // make mostFrequentWord = anEntry.getKey and the highestCountSoFar = anEntry.getValue
            if(anEntry.getValue() > highestCountSoFar) {
                highestCountSoFar = anEntry.getValue();
                mostFrequentWord = anEntry.getKey();
            }
        }

        // return word with highest count
        return mostFrequentWord;
    }

    // --- Part D ---
    /**
     * Calculates the TF-IDF score for each word in a catalog. The TF-IDF score for a word
     * is equal to the count * idf score. You can assume there will be an idfScore for each word
     * in wordCounts.
     * @param wordCounts - associates a count for each word from a catalog
     * @param idfScores - associates an IDF score for each word in the catalog
     * @return a map associating each word with its TF-IDF score.
     */
    public Map<String, Double> getTfIdfScores(Map<String, Integer> wordCounts, Map<String, Double> idfScores) {
        // PARTICIPANTS: Implement getTfIdfScores()
        // instantiate expected return map tfIdScores
        Map<String, Double> tfIdScores = new HashMap<>();

        // iterate through wordCounts
        for (Map.Entry<String, Integer> wcEntry : wordCounts.entrySet()) {
            // iterate through idfScores
            for (Map.Entry<String, Double> idfScoreEntry : idfScores.entrySet()) {
                // multiply wordCount by IDF score
                // put calculated TF-IDF scores in new map, associated with correct word
                tfIdScores.put(wcEntry.getKey(), wcEntry.getValue() * idfScoreEntry.getValue());
            }
        }
        // return tfIdScores - expected return object
        return tfIdScores;
    }

    // --- Extension 1 ---
    /**
     * Gets the 10 highest (TF-IDF) scored words for a catalog.
     *
     * @param tfIdfScores - associates a TF-IDF score for each word in a catalog
     * @return a list of the 10 highest scored words for a catalog.
     */
    public List<String> getBestScoredWords(Map<String, Double> tfIdfScores) {
        // PARTICIPANTS: Implement getBestScoredWords()
        return Collections.emptyList();
    }

    // --- Extension 2 ---
    /**
     * Calculates the IDF score for each word in a set of catalogs. The IDF score for a word
     * is equal to the inverse of the total number of times appears in all catalogs.
     * Assume df is the sum of the counts of a single word across all catalogs, then idf = 1.0/df.
     *
     * @param catalogWordCounts - a list of maps that associate a count for each word for each catalog
     * @return a map associating each word with its IDF score.
     */
    public Map<String, Double> calculateIdfScores(List<Map<String,Integer>> catalogWordCounts) {
        // PARTICIPANTS: Implement getIdfScores()
        return Collections.emptyMap();
    }

}
