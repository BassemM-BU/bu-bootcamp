import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    public static void main(String[] args) {
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores("scores.txt");
        
        // Handle empty file
        if (scores.isEmpty()) {
            System.out.println("No valid scores found in file.");
            return;
        }
        
        // Step 2: calculate statistics
        double average = calculateAverage(scores);
        
        // Find highest and lowest scores
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        
        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
            if (score < lowest) {
                lowest = score;
            }
        }
        
        // Count grade bands
        int countA = 0; // 90+
        int countB = 0; // 80-89
        int countC = 0; // 70-79
        int countD = 0; // 60-69
        int countF = 0; // below 60
        
        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }
        
        // Step 3: write and print report
        writeReport(scores, average, highest, lowest, "report.txt", 
                   countA, countB, countC, countD, countF);
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        int invalidLineCount = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                
                // Skip blank lines
                if (line.isEmpty()) {
                    continue;
                }
                
                // Try to parse the line as an integer
                try {
                    int score = Integer.parseInt(line);
                    scores.add(score);
                } catch (NumberFormatException e) {
                    System.out.println("Warning: Invalid line '" + line + "' skipped");
                    invalidLineCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        if (invalidLineCount > 0) {
            System.out.println("Total invalid lines skipped: " + invalidLineCount);
        }
        
        return scores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0.0;
        for (int score : scores) {
            sum += score;
        }
        
        return sum / scores.size();
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile,
                                   int countA, int countB, int countC, 
                                   int countD, int countF) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            // Format the report
            String line1 = String.format("=== Grade Analysis Report ===%n");
            String line2 = String.format("Total scores processed: %d%n", scores.size());
            String line3 = String.format("%n");
            String line4 = String.format("Average score:   %.2f%n", avg);
            String line5 = String.format("Highest score:   %d%n", high);
            String line6 = String.format("Lowest score:    %d%n", low);
            String line7 = String.format("%n");
            String line8 = String.format("Grade distribution:%n");
            String line9 = String.format("  A (90-100):   %d%n", countA);
            String line10 = String.format("  B (80-89):    %d%n", countB);
            String line11 = String.format("  C (70-79):    %d%n", countC);
            String line12 = String.format("  D (60-69):    %d%n", countD);
            String line13 = String.format("  F (below 60): %d%n", countF);
            
            // Write to file
            writer.write(line1);
            writer.write(line2);
            writer.write(line3);
            writer.write(line4);
            writer.write(line5);
            writer.write(line6);
            writer.write(line7);
            writer.write(line8);
            writer.write(line9);
            writer.write(line10);
            writer.write(line11);
            writer.write(line12);
            writer.write(line13);
            
            // Print to terminal
            System.out.println("\n" + line1);
            System.out.println(line2);
            System.out.print(line3);
            System.out.print(line4);
            System.out.print(line5);
            System.out.print(line6);
            System.out.print(line7);
            System.out.print(line8);
            System.out.print(line9);
            System.out.print(line10);
            System.out.print(line11);
            System.out.print(line12);
            System.out.print(line13);
            
            System.out.println("Report written to " + outputFile);
            
        } catch (IOException e) {
            System.out.println("Error writing report: " + e.getMessage());
        }
    }
} 