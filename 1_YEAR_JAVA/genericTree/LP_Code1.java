public static class TreeNode{
    int val;
    List<TreeNode> children = new LinkedList<>();
    TreeNode(int data){
        val = data;
    }

    TreeNode(int data,List<TreeNode> child){
        val = data;
        children = child;
    }
}
