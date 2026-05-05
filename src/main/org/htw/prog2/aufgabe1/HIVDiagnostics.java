package org.htw.prog2.aufgabe1;
import org.apache.commons.cli.*;

import java.util.Scanner;

public class HIVDiagnostics {
   /**String mutFiles;
   String  drug;
   String refer;
   String patient;
   public HIVDiagnostics(){
       this.mutFiles = "";
       this.drug = "";
       this.refer = "";
       this.patient = "";
   }*/
    /**
     * Parst die Kommandozeilenargumente. Gibt null zurück, falls:
     * <ul>
     *     <li>Ein Fehler beim Parsen aufgetreten ist (z.B. eins der erforderlichen Argumente nicht angegeben wurde)</li>
     *     <li>Bei -m, -d und -r nicht die gleiche Anzahl an Argumenten angegeben wurde</li>
     * </ul>
     * @param args Array mit Kommandozeilen-Argumenten
     * @return CommandLine-Objekt mit geparsten Optionen
     *
     * -m, --mutationfiles: Pfad zu CSV-Datei mit Mutationspattern. Muss angegeben werden.
     * -d, --drugnames: Name des Medikaments. Muss angegeben werden.
     * -r, --references: Pfad zu FASTA-Datei mit der Referenzsequenz. Muss angegeben werden.
     * -p, --patientseqs: Pfad zu FASTA-Datei mit Patientensequenzen. Muss angegeben werden.
     */

    public static CommandLine parseOptions(String[] args) {

        Options options = new Options();

        Option mutationfiles = new Option("m", "mutationfiles", true, "Mutationspattern");
        mutationfiles.setRequired(true);
        options.addOption(mutationfiles);

        Option drugnames = new Option("d", "drugnames", true, "Medikaments");
        drugnames.setRequired(true);
        options.addOption(drugnames);

        Option references = new Option("r", "references", true, "Referenzsequenz");
        references.setRequired(true);
        options.addOption(references);

        Option patientseqs = new Option("p", "patientseqs", true, "Patientensequenzen");
        patientseqs.setRequired(true);
        options.addOption(patientseqs);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        try {
            return parser.parse(options, args);
        } catch (ParseException e){
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            return null;

            }

    }

    public static void main(String[] args) {
        CommandLine cmd = parseOptions(args);
        if (cmd == null){
            System.exit(1);
        }
        String mutFiles = cmd.getOptionValue("m");
        String drug = cmd.getOptionValue("d");
        String refer = cmd.getOptionValue("r");
        String patient = cmd.getOptionValue("p");

    }
}
