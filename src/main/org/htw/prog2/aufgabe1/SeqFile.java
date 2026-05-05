package org.htw.prog2.aufgabe1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SeqFile {
    HashSet<String> sequences;
    boolean read;
    String sequence;
    LinkedHashSet<String> orderedSeq;


    /**
     * Reads the specified FASTA file and stores sequences. In case the file does not exist or is not a valid FASTA
     * file, the Constructor does not throw an Exception. Instead, isValid() on the resulting object will return false.
     * @param filename
     */
    public SeqFile(String filename) {
        orderedSeq = new LinkedHashSet<>();
        sequences = new HashSet<>();
        File f = new File(filename);
        StringBuilder partLine = new StringBuilder();
        try {
            BufferedReader r = new BufferedReader(new FileReader(f));
            String firstLetter = "";
            r.readLine();
            while (r.ready() ) {
                String line = r.readLine();
                String line1 = line.trim();
                String[] splitLine = line1.split("");
                for(int i = 0; i<splitLine.length; i++){
                    firstLetter = splitLine[0];
                }
                if(!firstLetter.equals(">")) {
                    partLine.append(line1);
                }else{
                    if(!partLine.isEmpty()){
                        sequence = partLine.toString();
                        orderedSeq.add(sequence);
                        partLine.delete(0, partLine.length());
                    }
                }
            }sequence = partLine.toString();
            orderedSeq.add(sequence);
            partLine.delete(0, partLine.length());
            if(!orderedSeq.isEmpty()) read = true;
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
        sequences = new HashSet<>(orderedSeq);
        if(!isValid()) return new HashSet<>();
        return sequences;


       /// return new HashSet<>(sequences);
    }

    /**
     *
     * @return The first sequence read from the FASTA file, or an empty String if isValid() is false.
     */
    public String getFirstSequence() {
        if (!isValid()) {
            return "";
        } else {
            String[] array = orderedSeq.toArray(new String[getSequences().size()]);
            return array[0];
        }
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
