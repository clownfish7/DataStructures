package com.clownfish7.huffmancode;


import java.io.*;
import java.util.*;

/**
 * @author yzy
 * @classname HuffmanCode
 * @description 赫夫曼编码
 * @create 2019-09-09 10:59
 */
public class HuffmanCode {
    public static void main(String[] args) {
        /*String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes();

        byte[] zipBytes = huffmanZip(bytes);
        System.out.println(Arrays.toString(zipBytes));

        System.out.println("===========================");
        byte[] decode = decode(huffmancodes, zipBytes);
        System.out.println(new String(decode));*/

        String srcFile = "f://background.jpg";
        String dstFile = "f://dst.zip";
        zipFile(srcFile, dstFile);
        System.out.println("zip file success");

        String zipFile = "f://dst.zip";
        dstFile = "f://dst.jpg";
        unZipFile(zipFile, dstFile);
        System.out.println("unzip file success ");

//        String srcFile = "f://src.bmp";
//        String dstFile = "f://dst.zip";
//        zipFile(srcFile, dstFile);
//        System.out.println("zip file success");
//
//        String zipFile = "f://dst.zip";
////        String dstFile = "f://dst.jpg";
//        dstFile = "f://dst.bmp";
//        unZipFile(zipFile, dstFile);
//        System.out.println("unzip file success ");
    }

    private static byte[] decode(Map<Byte, String> huffmancodes, byte[] huffmanBytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            boolean flag = (i == huffmanBytes.length - 1);
            sb.append(byteToBitString(!flag, huffmanBytes[i]));
        }
        System.out.println(sb.toString());

        Map<String, Byte> map = new HashMap<>();
        huffmancodes.forEach((k, v) -> {
            map.put(v, k);
        });

        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < sb.length(); ) {
            int count = 1;
            Byte b = null;
            while ((b = map.get(sb.substring(i, i + count))) == null) {
                count++;
            }
            list.add(b);
            i += count;
        }

        byte b[] = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    private static String byteToBitString(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }


    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        Node huffmanTree = createHuffmanTree(nodes);
        getHuffmanCode(huffmanTree, "", builder);
        return zip(bytes, huffmancodes);
    }

    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        HashMap<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            Integer count = map.get(b);
            if (count == null) {
                map.put(b, 1);
            } else {
                map.put(b, count + 1);
            }
        }

        map.forEach((k, v) -> {
            nodes.add(new Node(k, v));
        });
        return nodes;
    }

    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }


    static StringBuilder builder = new StringBuilder();
    static Map<Byte, String> huffmancodes = new HashMap<>();

    private static void getHuffmanCode(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder builder = new StringBuilder(stringBuilder);
        builder.append(code);
        if (node != null) {
            if (node.data == null) {
                getHuffmanCode(node.left, "0", builder);
                getHuffmanCode(node.right, "1", builder);
            } else {
                huffmancodes.put(node.data, builder.toString());
            }
        }
    }

    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmancodes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append(huffmancodes.get(bytes[i]));
        }
        int length = (stringBuilder.length() + 7) / 8;
        byte[] huffmanCodeBytes = new byte[length];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    private static void zipFile(String srcFile, String dstFile) {
        InputStream is = null;
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            is = new FileInputStream(srcFile);
            byte[] b = new byte[is.available()];
            is.read(b);
            byte[] huffmanBytes = huffmanZip(b);
            os = new FileOutputStream(dstFile);
            oos = new ObjectOutputStream(os);
            oos.writeObject(huffmanBytes);
            oos.writeObject(huffmancodes);
            System.out.println("--> "+new String(huffmanBytes));
            System.out.println("--> "+huffmancodes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                is.close();
                oos.close();
                os.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void unZipFile(String zipFile, String dstFile) {
        InputStream is = null;
        OutputStream os = null;
        ObjectInputStream ois = null;
        try {
            is = new FileInputStream(zipFile);
            os = new FileOutputStream(dstFile);
            ois = new ObjectInputStream(is);

            byte[] huffmanBytes = (byte[]) ois.readObject();
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();
            System.out.println("++> "+new String(huffmanBytes));
            System.out.println("++> "+huffmanCodes);
            byte[] decode = decode(huffmanCodes, huffmanBytes);
            os.write(decode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                ois.close();
                is.close();
                os.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class Node implements Comparable<Node> {
    Byte data;
    int weight;
    Node left;
    Node right;

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
