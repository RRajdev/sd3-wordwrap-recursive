public class Wordwrap {

    public String wrap(String line, int lineLength){
        String delimiter = " ";

        if (line.trim().length() <= lineLength) return line.trim(); //base case
        char charAtLineBreak = line.trim().charAt(lineLength);
        int lineBreak = (Character.toString(charAtLineBreak).equals(delimiter))?  lineLength: line.trim().indexOf(delimiter);
        return line.trim().substring(0, lineBreak) + System.lineSeparator() +  wrap(line.trim().substring(lineBreak), lineLength); //recursive case (divide and conquer)
    }
}
