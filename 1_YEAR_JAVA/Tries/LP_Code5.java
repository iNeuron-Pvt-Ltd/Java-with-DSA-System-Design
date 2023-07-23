import java.util.*;

class Node implements Comparable<Node> {
    char symbol;
    int frequency;
    Node left;
    Node right;

    public Node(char symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
    }

    public Node(char symbol, int frequency, Node left, Node right) {
        this.symbol = symbol;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    
    @Override
    public int compareTo(Node other) {
        return this.frequency - other.frequency;
    }
}

public class HuffmanTree {

    public static Node buildHuffmanTree(String data) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : data.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (priorityQueue.size() > 1) {
            Node leftNode = priorityQueue.poll();
            Node rightNode = priorityQueue.poll();
            Node parent = new Node('\0', leftNode.frequency + rightNode.frequency, leftNode, rightNode);
            priorityQueue.add(parent);
        }

        return priorityQueue.poll();
    }

    public static void printHuffmanCodes(Node root, String code) {
        if (root == null) {
            return;
        }

        if (root.symbol != '\0') {
            System.out.println(root.symbol + ": " + code);
        }

        printHuffmanCodes(root.left, code + "0");
        printHuffmanCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        String input = "this is an example for huffman encoding";
        Node root = buildHuffmanTree(input);
        System.out.println("Huffman Codes:");
        printHuffmanCodes(root, "");
    }
}
