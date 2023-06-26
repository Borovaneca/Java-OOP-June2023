package Encapsulation.Exercise.PizzaCalories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;
    private double flourCalories;
    private double bakingCalories;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }


    private void setFlourType(String flourType) {
            if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
                throw new IllegalStateException("Invalid type of dough.");
            }
        this.flourType = flourType;
        switch (this.flourType) {
            case "White":
                setFlourCalories(1.5);
                break;
            case "Wholegrain":
                setFlourCalories(1.0);
                break;
        }
    }



    private void setBakingCalories(double bakingCalories) {
        this.bakingCalories = bakingCalories;
    }


    private void setFlourCalories(double flourCalories) {
        this.flourCalories = flourCalories;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.bakingTechnique = bakingTechnique;
        switch (this.bakingTechnique) {
            case "Crispy":
                setBakingCalories(0.9);
                break;
            case "Chewy":
                setBakingCalories(1.1);
                break;
            case "Homemade":
                setBakingCalories(1.0);
                break;
        }
    }

    private void setWeight(double weight) {
        if (weight > 200 || weight < 1) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (this.weight * 2) * this.flourCalories * this.bakingCalories;
    }
}
