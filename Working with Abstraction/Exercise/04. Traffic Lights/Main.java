
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String[] colors = scanner.readLine().split("\\s+");
        int iteration = Integer.parseInt(scanner.readLine());

        List<TrafficLight> trafficLights = Arrays.stream(colors)
                .map(Color::valueOf)
                .map(TrafficLight::new)
                .collect(Collectors.toList());

        for (int i = 1; i <= iteration; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.changeColor();
                System.out.printf("%s ", trafficLight.getColor());
            }
            System.out.println();
        }
    }
}
