package Randomizer;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        try {
            File file = new File("write.csv");
            if(!file.exists()) {
                file.createNewFile();
            }
            String line;
            BufferedReader br = new BufferedReader(new FileReader(InitialFileName()));
            PrintWriter pw = new PrintWriter(file);
            while (( line = br.readLine()) != null){
                String[] values = line.split(";");

                double NumberFromColumn1 = Double.parseDouble(values[0])+ Rounding(Math.random());
                double NumberFromColumn2 = Double.parseDouble(values[1])+ Rounding(Math.random());
                double DivisionResult = Rounding(NumberFromColumn1 / NumberFromColumn2);

                String numberWithComma = String.format("%.2f",DivisionResult); //replaces a dot with a comma (Otherwise, the csv reads the numbers as a date)
                System.out.println(numberWithComma);
                pw.println(numberWithComma);
            }
            pw.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
    private static double Rounding(double number){
        return Math.round (number*100.0)/100.0;
    }
    private static String InitialFileName() throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.readLine();
    }
}
