package org.htw.prog2.aufgabe1;

public class Main {
    public static void main(String[] args){
        SeqFile p = new SeqFile("data/protease_sequences.fasta");
        System.out.println(p.getNumberOfSequences());
    }
}
