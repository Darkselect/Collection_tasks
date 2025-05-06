package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class ClientStreamProcessor {
    public static void solution(List<Client> clients) {
        String targetName = "Doniyor";

        int totalAgeForName =  clients.stream()
                .filter(c -> c.getName().equals(targetName))
                .mapToInt(Client::getAge)
                .sum();

        System.out.println("Суммарный возраст для " + targetName + ": " + totalAgeForName);

        Set<String> namesInOrder = clients.stream()
                .map(Client::getName)
                .collect(Collectors.toSet());

        System.out.println("Именя в порядке: " + namesInOrder);

        int targetAge = 40;
        boolean anyOlder = clients.stream()
                .anyMatch(c -> c.getAge() > targetAge);

        System.out.println("Есть ли клиент старше " + anyOlder + " ?" + anyOlder);

        Map<UUID, String> idToName = clients.stream()
                .collect(Collectors.toMap(
                        Client::getId,
                        Client::getName,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        System.out.println("ID -> Name: " + idToName);

        Map<Integer, List<Client>> byAge = clients.stream()
                .collect(Collectors.groupingBy(Client::getAge));
        System.out.println("Клиенты по возрасту: " + byAge);

        String allPhones = clients.stream()
                .flatMap(c -> Optional.ofNullable(c.getPhoneNumber()).orElse(List.of()).stream()
                        .map(PhoneNumber::getNumber))
                .collect(Collectors.joining(", "));

        System.out.println("Все номера: " + allPhones);

        clients.stream()
                .filter(c -> Optional.ofNullable(c.getPhoneNumber())
                        .orElse(List.of())
                        .stream()
                        .anyMatch(p -> "стационарный".equalsIgnoreCase(p.getType())))
                .max(Comparator.comparingInt(Client::getAge))
                .ifPresent(c -> System.out.println("Старший со стационарным: " + c.getName() + ", " + c.getAge()));
    
    }
}
