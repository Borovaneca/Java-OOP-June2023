package Polymorphism.Exercise.word;


public class CutTransform implements TextTransform {

    private String lastCut;

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        lastCut = text.substring(startIndex, endIndex);
        text.replace(startIndex, endIndex, "");
    }

    public String getLastCut() {
        return lastCut;
    }
}
