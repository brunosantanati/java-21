package me.brunosantana.sequenced.collection;

import java.util.*;

/*
Spotify - Inside Java - Podcast Episode "Sequenced Collections" with Stuart Marks
https://open.spotify.com/episode/14SIAjU3vXy6s5EFH9bOyW

JEP 431: Sequenced Collections
https://openjdk.org/jeps/431

SequencedSet documentation
https://download.java.net/java/early_access/jdk21/docs/api/java.base/java/util/SequencedSet.html

SequencedMap documentation
https://download.java.net/java/early_access/jdk21/docs/api/java.base/java/util/SequencedMap.html

Download JDK 21 (Early-Access Builds)
https://jdk.java.net/21/

Page about JDK 21 with list of JEPs
https://openjdk.org/projects/jdk/21/
 */

public class ExampleSequencedCollection {

    public static void main(String[] args) {
        testSequencedSet();
        testList();
        testSequencedMap();
        testCollectionsUtility();
    }

    private static void testSequencedSet() {
        System.out.println("\n-------- SequencedSet --------\n");
        printWithTab("######## Adding items ########");

        SequencedSet<String> sequencedSet = new LinkedHashSet<>();
        sequencedSet.add("B");
        sequencedSet.add("C");

        sequencedSet.addFirst("A");
        sequencedSet.addLast("D");

        printWithTab(sequencedSet);

        printWithTab("######## Get first and last ########");

        printWithTab(sequencedSet.getFirst());
        printWithTab(sequencedSet.getLast());

        printWithTab("######## Reverse order and get first and last ########");

        SequencedSet<String> reversed = sequencedSet.reversed();

        printWithTab(reversed);
        printWithTab(reversed.getFirst());
        printWithTab(reversed.getLast());

        printWithTab("######## Removing items ########");

        reversed.removeFirst();
        printWithTab(sequencedSet);
        printWithTab(reversed);

        sequencedSet.removeLast();
        printWithTab(sequencedSet);
        printWithTab(reversed);
    }

    private static void testList() {
        System.out.println("\n-------- List --------\n");

        printWithTab("######## Adding items ########");
        List<String> list = new ArrayList<>(List.of("B", "C"));
        list.addFirst("A");
        list.addLast("D");

        printWithTab(list);

        printWithTab("######## Reverse order ########");
        printWithTab(list.reversed());
    }

    private static void testSequencedMap() {
        System.out.println("\n-------- SequencedMap --------\n");

        printWithTab("######## Adding items ########");
        SequencedMap<String, String> sequencedMap = new LinkedHashMap<>(Map.of("B", "Bruno"));
        sequencedMap.putFirst("A", "Arthur");
        sequencedMap.putLast("C", "Carlos");
        printWithTab(sequencedMap);

        printWithTab("######## Get first and last ########");
        printWithTab(sequencedMap.firstEntry());
        printWithTab(sequencedMap.lastEntry());

        printWithTab("######## Reverse order ########");
        printWithTab(sequencedMap.reversed());

        printWithTab("######## Get entries, keys and values ########");
        printWithTab(sequencedMap.sequencedEntrySet()); //Returns a SequencedSet view of this map's entrySet.
        printWithTab(sequencedMap.sequencedKeySet()); //Returns a SequencedSet view of this map's keySet.
        printWithTab(sequencedMap.sequencedValues()); //Returns a SequencedCollection view of this map's values collection.

        sequencedMap.sequencedValues().forEach(ExampleSequencedCollection::printWithTab);

        printWithTab("######## Removing items ########");
        printWithTab(sequencedMap.pollFirstEntry());
        printWithTab(sequencedMap);
        printWithTab(sequencedMap.pollLastEntry());
        printWithTab(sequencedMap);
    }

    private static void testCollectionsUtility() {
        System.out.println("\n-------- Collections Utility new methods --------\n");

        printWithTab("######## Unmodifiable Set ########");

        SequencedSet<String> sequencedSet = new LinkedHashSet<>(Set.of("B", "C"));
        sequencedSet.addFirst("A");
        printWithTab(sequencedSet);

        Set<String> unmodifiableSet = Collections.unmodifiableSet(sequencedSet);
        try {
            unmodifiableSet.add("D");
        } catch (UnsupportedOperationException e) {
            printWithTab("unmodifiableSet is really unmodifiable");
        }
        printWithTab(unmodifiableSet);

        System.out.println();
        printWithTab("######## Unmodifiable Map ########");

        SequencedMap<String, String> sequencedMap = new LinkedHashMap<>();
        //sequencedMap.putAll(Map.of("B", "Bruno", "C", "Carlos"));
        sequencedMap.put("B", "Bruno");
        sequencedMap.put("C", "Carlos");

        Collections.unmodifiableMap(sequencedMap);
        printWithTab(sequencedMap);

        //Collections.unmodifiableSequencedCollection(sequencedCollection) //check this method later
    }
    private static void printWithTab(Object obj) {
    	System.out.println("\t" + obj);
    }

}
