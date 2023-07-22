public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.children.add(new TreeNode(2));
    root.children.add(new TreeNode(3));
    root.children.add(new TreeNode(4));
    root.children.get(0).children.add(new TreeNode(5));
    root.children.get(0).children.add(new TreeNode(6));
    root.children.get(0).children.add(new TreeNode(7));
    root.children.get(1).children.add(new TreeNode(8));
    root.children.get(2).children.add(new TreeNode(9));
    root.children.get(2).children.add(new TreeNode(10));
    root.children.get(2).children.add(new TreeNode(11));
    printNAryTree(root);
}
