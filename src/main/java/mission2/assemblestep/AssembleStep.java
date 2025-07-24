package mission2.assemblestep;

public interface AssembleStep {
    void showMenu();
    boolean isValid(int answer);
    void select(int answer);
    int getBackStep(int step);
    int getNextStep(int step);
}
