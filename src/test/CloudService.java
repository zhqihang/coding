package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CloudService {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int threshold = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Map<String, Node> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            String service = line[0];
            String parent = line[1];
            int level = Integer.parseInt(line[2]);
            int count = Integer.parseInt(line[3]);

            Node parentNode = parent.equals("*") ? null : nodes.get(parent);
            Node node = new Node(service, parentNode, level, count);
            nodes.put(service, node);
            if (parentNode != null) {
                parentNode.addChild(node);
            }
        }
        int riskCount = countRiskServices(nodes, threshold);
        System.out.println(riskCount);
    }

    private static int countRiskServices(Map<String, Node> nodes, int threshold) {
        int count = 0;
        for (Node node : nodes.values()) {
            int di = calculateDI(node);
            if (di > threshold) {
                count++;
            }
        }
        return count;
    }

    private static int calculateDI(Node node) {
        if (node == null) {
            return 0;
        }

        int severeProblems = node.severeProblems;
        int normalProblems = node.normalProblems;

        for (Node child : node.children.values()) {
            severeProblems += calculateDI(child);
            normalProblems += child.severeProblems + child.normalProblems;
        }

        return 5 * severeProblems + 2 * normalProblems;
    }

    static class Node {
        String service;
        Node parent;
        int severeProblems;
        int normalProblems;
        Map<String, Node> children;

        Node(String service, Node parent, int level, int count) {
            this.service = service;
            this.parent = parent;
            this.severeProblems = level == 0 ? count : 0;
            this.normalProblems = level == 1 ? count : 0;
            this.children = new HashMap<>();
        }

        void addChild(Node child) {
            children.put(child.service, child);
        }
    }
}

