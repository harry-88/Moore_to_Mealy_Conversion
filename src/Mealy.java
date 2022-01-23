import java.util.Arrays;

public class Mealy {
    String startingState;
    String[] endingState;
    String[] output;

    public Mealy(String startingState, String[] endingState, String[] output) {
        this.startingState = startingState;
        this.endingState = endingState;
        this.output = output;
    }


    public String getStartingState() {
        return startingState;
    }

    public void setStartingState(String startingState) {
        this.startingState = startingState;
    }

    public String[] getEndingState() {
        return endingState;
    }

    public void setEndingState(String[] endingState) {
        this.endingState = endingState;
    }

    public String[] getOutput() {
        return output;
    }

    public void setOutput(String[] output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "Mealy{" +
                "startingState='" + startingState + '\'' +
                ", endingState=" + Arrays.toString(endingState) +
                ", output=" + Arrays.toString(output) +
                '}';
    }
}
