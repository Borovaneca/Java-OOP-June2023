package MilitaryElite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Soldier> soldiersList = new ArrayList<>();

        String input;

        while (!(input = scanner.nextLine()).equals("End")) {

            String[] data = input.split("\\s+");

            String soldierType = data[0];
            int id = Integer.parseInt(data[1]);
            String firstName = data[2];
            String lastName = data[3];
            double salary = Double.parseDouble(data[4]);

            switch (soldierType) {

                case "Private":
                    PrivateImpl currentPrivate = new PrivateImpl(id, firstName, lastName, salary);

                    soldiersList.add(currentPrivate);
                    break;
                case "LieutenantGeneral":
                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);

                    String[] ids = getIds(data);

                    addPrivate(soldiersList, lieutenantGeneral, ids);

                    soldiersList.add(lieutenantGeneral);
                    break;
                case "Engineer":
                    String engineerCorp = data[5];

                    try {
                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, engineerCorp);

                        String[] parts = getParts(data);

                        addRepair(engineer, parts);

                        soldiersList.add(engineer);
                    } catch (IllegalArgumentException e) {

                    }
                    break;
                case "Commando":
                    String commandoCorp = data[5];

                    try {
                        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, commandoCorp);

                        String[] missions = getParts(data);

                        addMission(commando, missions);

                        soldiersList.add(commando);
                    } catch (IllegalArgumentException e) {

                    }
                    break;
                case "Spy":
                    String codeNumber = data[4];
                    SpyImpl spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    soldiersList.add(spy);
                    break;
            }
        }

        soldiersList.forEach(System.out::println);
    }

    private static void addMission(CommandoImpl commando, String[] missions) {

        for (int i = 0; i < missions.length; i += 2) {

            String missionCodeName = missions[i];
            String missionState = missions[i + 1];

            try {
                MissionImpl mission = new MissionImpl(missionCodeName, missionState);
                commando.addMission(mission);
            } catch (IllegalArgumentException e) {

            }
        }
    }

    private static void addRepair(EngineerImpl engineer, String[] parts) {

        for (int i = 0; i < parts.length; i += 2) {

            String partName = parts[i];
            int workHours = Integer.parseInt(parts[i + 1]);

            RepairImpl repair = new RepairImpl(partName, workHours);

            engineer.addRepair(repair);
        }
    }

    private static void addPrivate(List<Soldier> soldiersList, LieutenantGeneralImpl lieutenantGeneral, String[] ids) {

        for (String privateIds : ids) {

            Soldier currentPrivate = soldiersList.stream()
                    .filter(s -> s.getId() == Integer.parseInt(String.valueOf(privateIds)))
                    .findFirst()
                    .get();

            lieutenantGeneral.addPrivate(currentPrivate);
        }
    }

    private static String[] getIds(String[] data) {

        String[] ids = new String[data.length - 5];

        System.arraycopy(data, 5, ids, 0, ids.length);

        return ids;
    }

    private static String[] getParts(String[] data) {

        String[] parts = new String[data.length - 6];

        System.arraycopy(data, 6, parts, 0, parts.length);

        return parts;
    }
}
