package org.htw.prog2.aufgabe1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SeqFile {
    Set<String> sequences;
    boolean read;
    String firstSeq;


    /**
     * Reads the specified FASTA file and stores sequences. In case the file does not exist or is not a valid FASTA
     * file, the Constructor does not throw an Exception. Instead, isValid() on the resulting object will return false.
     * @param filename
     */
    public SeqFile(String filename) {
        sequences = new LinkedHashSet<>();
        File f = new File(filename);
        try {
            BufferedReader r = new BufferedReader(new FileReader(f));
            r.readLine();
            while (r.ready() ) {
                String sequence = r.readLine();
                sequences.add(sequence);


            }
            if(!sequences.isEmpty()) read = true;
        } catch (IOException e) {
            isValid();
        }
    }
    
    /**
     * Reads the specified FASTA file.
     * @param filename The path to the FASTA file
     * @return false if the file could not be parsed (wrong format, does not exist), true otherwise.
     */
    private boolean readFile(String filename) {

        return false;
    }

    /**
     * Adds the sequence in the passed StringBuilder to the internal hash set and also sets the first sequence if it
     * is still empty.
     * @param seq SequenceBuilder to get the sequence from.
     * @return The length of the added sequence.
     */
    private int addSequence(StringBuilder seq) {
        return -1;
    }

    /**
     *
     * @return The number of sequences read from the FASTA file, or 0 if isValid() is false.
     */
    public int getNumberOfSequences() {
        if(!isValid()){
            return 0;
        }
        return getSequences().size();
    }
    /**
     *
     * @return The sequences read from the FASTA file, or an empty HashSet if isValid() is false.
     */
    public HashSet<String> getSequences() {
        HashSet<String> sequenc = new HashSet<>();
        sequenc.add(firstSeq);
        return sequenc;


       /// return new HashSet<>(sequences);
    }

    /**
     *
     * @return The first sequence read from the FASTA file, or an empty String if isValid() is false.
     */
    public String getFirstSequence() {

        List<String> firstLine = new ArrayList<>(sequences);
        if(!isValid()){return "";}
         firstSeq = firstLine.get(0) + firstLine.get(1) + firstLine.get(2);
        return firstSeq;
    }

    /**
     *
     * @return true if the FASTA file was read successfully, false otherwise.
     */
    public boolean isValid() {
        if(read) return true;
        return false;
    }
}
