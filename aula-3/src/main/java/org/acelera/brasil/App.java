package org.acelera.brasil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class App {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("chave", "valor");
        String orDefault = map.getOrDefault("naote", "um valor padrao");
        System.out.println(orDefault);


    }
}
