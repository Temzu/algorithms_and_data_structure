package com.geekbrains.temzu.homeworks.lesson_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Garden {
    private static class Cat {
        int age;
        String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cat cat = (Cat) o;
            return age == cat.age &&
                    Objects.equals(name, cat.name);
        }

        public Cat(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("C(%s, %d)", name, age);
        }
    }

    private static class Tree {
        private static class TreeNode implements Comparable {
            private Cat c;
            public TreeNode left;
            public TreeNode right;

            public TreeNode(Cat c) {
                this.c = c;
            }

            @Override
            public String toString() {
                return String.format("TN(%s)", c);
            }

            @Override
            public int compareTo(Object o) {
                if (!(o instanceof Cat))
                    throw new ClassCastException("Not a cat!");
                return c.age - ((Cat) o).age;
            }
        }

        TreeNode root;

        public void insert(Cat c) {
            TreeNode node = new TreeNode(c);
            if (root == null) {
                root = node;
            } else {
                TreeNode current = root;
                TreeNode parent;
                while (true) {
                    parent = current;
                    if (c.age < current.c.age) {
                        current = current.left;
                        if (current == null) {
                            parent.left = node;
                            return;
                        }
                    } else if (c.age > current.c.age) {
                        current = current.right;
                        if (current == null) {
                            parent.right = node;
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public Cat find(int age) {
            TreeNode current = root;
            while (current.c.age != age) {
                current = (age < current.c.age) ? current.left : current.right;
                if (current == null) return null;
            }
            return current.c;
        }

        public void preOrderTraverse(TreeNode currentNode) {
            if (currentNode != null) {
                System.out.println(currentNode);
                preOrderTraverse(currentNode.left);
                preOrderTraverse(currentNode.right);
            }
        }

        // LeftRootRight
        // RightLeftRoot
        public void displayTree() {
            preOrderTraverse(root);
        }

        public Cat delete(int age) {
            TreeNode current = root;
            TreeNode parent = root;
            boolean isLeftChild = true;
            while (current.c.age != age) {
                parent = current;
                if (age < current.c.age) {
                    current = current.left;
                    isLeftChild = true;
                } else {
                    current = current.right;
                    isLeftChild = false;
                }
                if (current == null) {
                    return null;
                }
            }
            //leaf
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else if (isLeftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            // one ancestor
            else if (current.right == null) {
                if (isLeftChild)
                    parent.left = current.left;
                else
                    parent.right = current.left;
            } else if (current.left == null) {
                if (isLeftChild)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
            // two ancestors
            else {
                TreeNode successor = getSuccessor(current);
                if (current == root) {
                    root = successor;
                } else if (isLeftChild) {
                    parent.left = successor;
                } else {
                    parent.right = successor;
                }
                successor.left = current.left;
            }
            return current.c;
        }

        private TreeNode getSuccessor(TreeNode node) {
            TreeNode current = node.right;
            TreeNode parent = node;
            TreeNode successor = node;
            while (current != null) {
                parent = successor;
                successor = current;
                current = current.left;
            }

            if (successor != node.right) {
                parent.left = successor.right;
                successor.right = node.right;
            }
            return successor;
        }

        public boolean isBalanced() {
            if(isBalanced(root))
                return true;
            return false;
        }

        private boolean isBalanced(TreeNode node) {
            int leftDepth;
            int rightDepth;
            if (node == null)
                return true;
            else {
                leftDepth = depth(node.left);
                rightDepth = depth(node.right);
                return Math.abs(leftDepth - rightDepth) <= 1;
            }
        }

        private int depth(TreeNode node) {
            int left;
            int right;
            int result;
            if (node == null)
                return 0;
            else {
                left = depth(node.left) + 1;
                right = depth(node.right) + 1;
                result = Math.max(left, right);
                return result;
            }
        }
    }

    public static void main(String[] args) {
        Tree tree123 = new Tree();
        for (int i = 0; i < 10; i++) {
            tree123.insert(new Cat(i, "name"));
        }

        List<Tree> treeList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            treeList.add(createTree((int) (Math.random() * 100)));
        }
        for (Tree tree : treeList) {
            System.out.println(tree.isBalanced());
        }
    }

    public static Tree createTree(int number) {
        Tree newTree = new Tree();
        for (int i = 0; i < number; i++) {
            newTree.insert(new Cat((int)(Math.random()*(200 + 1)) - 100, "name"));
        }
        return newTree;
    }
}
