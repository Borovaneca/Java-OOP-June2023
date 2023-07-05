package Polymorphism.Exercise.word;

public class PasteTransform implements TextTransform {

    private CutTransform lastCut;

    public PasteTransform(CutTransform lastCut) {
        this.lastCut = lastCut;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        text.replace(startIndex, endIndex, lastCut.getLastCut());
    }
}
