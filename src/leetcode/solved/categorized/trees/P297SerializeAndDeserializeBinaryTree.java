package leetcode.solved.categorized.trees;


import java.util.LinkedList;

public class P297SerializeAndDeserializeBinaryTree {
    StringBuilder sb = new StringBuilder();
    String serialized;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        preOrder(root);
        sb.setLength(sb.length() - 1);
        serialized = sb.toString();
        // System.out.println(serialized);
        return serialized;
    }

    void preOrder(TreeNode node) {
        if (node == null) {
            sb.append("X,");
            return;
        }
        sb.append(node.val);
        sb.append(",");
        preOrder(node.left);
        preOrder(node.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] nodes = data.split(",");
        LinkedList<String> queue = new LinkedList<>();
        for (String node : nodes) queue.add(node);
        TreeNode root = construct(queue);
        return root;
    }

    TreeNode construct(LinkedList<String> queue) {
        String currNode = queue.removeFirst();
        if (currNode.equals("X")) return null;

        TreeNode curr = new TreeNode(Integer.parseInt(currNode));
        curr.left = construct(queue);
        curr.right = construct(queue);

        return curr;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));