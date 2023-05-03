package me.brunosantana.sequenced.collection;

import java.util.LinkedHashSet;
import java.util.SequencedSet;

/*
JEP 431: Sequenced Collections
https://openjdk.org/jeps/431

SequencedSet documentation
https://download.java.net/java/early_access/jdk21/docs/api/java.base/java/util/SequencedSet.html

Download JDK 21 (Early-Access Builds)
https://jdk.java.net/21/

Page about JDK 21 with list of JEPs
https://openjdk.org/projects/jdk/21/
 */

public class ExampleSequencedCollection {

    public static void main(String[] args) {
        testSequencedSet();
    }

    private static void testSequencedSet() {
        System.out.println("-------- SequencedSet --------\n");
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

    private static void printWithTab(Object obj) {
    	System.out.println("\t" + obj);
    }

}
