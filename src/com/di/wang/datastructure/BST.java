package com.di.wang.datastructure;

import java.util.*;
import java.util.stream.Collectors;

public class BST
{
    public static class Node
    {
        public Node left = null;
        public Node right = null;
        public int value;

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    public static void insert(Node root, int value)
    {
        if (root == null)
            throw new RuntimeException("root is not initiated");

        // less than
        if (value < root.value)
        {
            if (root.left == null)
            {
                root.left = initNode(value);
                System.out.println("inserted node: " + root.left);
            }
            else
            {
                insert(root.left, value);
            }
        }
        // greater than or equals
        else
        {
            if (root.right == null)
            {
                root.right = initNode(value);
                System.out.println("inserted node: " + root.right);
            }
            else
            {
                insert(root.right, value);
            }
        }
    }

    public static boolean search(Node root, int value)
    {
        if (root == null)
        {
            return false;
        }

        if (value == root.value)
            return true;

        if (value < root.value)
            return search(root.left, value);

        else
            return search(root.right, value);

    }

    public static Node initNode(int value)
    {
        Node node = new Node();
        node.value = value;
        return node;
    }

    public static String printNode(Node root)
    {
        TreeMap<Long, String> strs = new TreeMap<>();

        printEachNode(root, -1, strs);

        return strs.values().stream().collect(Collectors.joining("\n"));
    }

    private static void printEachNode(Node root, long depth, Map<Long, String> strs)
    {
        depth++;

        String currentStr = strs.get(depth) == null ? "" : strs.get(depth);
        strs.put(depth, currentStr + " " + root.value);

        if (root.left != null)
            printEachNode(root.left, depth, strs);
        if (root.right != null)
            printEachNode(root.right, depth, strs);

        depth--;
    }


//    private static String[] printEachNodeWithPadding(Node root, long depth, Map<Long, String> strs)
//    {
//        String[] paddings = {"__", "__"};
//        depth++;
//
//        if (root.left != null)
//        {
//            String[] paddingsLeft = printEachNodeWithPadding(root.left, depth, strs);
//            paddings[0] += paddingsLeft[0];
//
//        }
//        if (root.right != null)
//        {
//            String[] paddingsRight = printEachNodeWithPadding(root.right, depth, strs);
//            paddings[1] += paddingsRight[1];
//        }
//
//        String currentStr = strs.get(depth) == null ? "" : strs.get(depth);
//        strs.put(depth, currentStr + paddings[0] + root.value + paddings[1]);
//
//        depth--;
//        return paddings;
//    }
}