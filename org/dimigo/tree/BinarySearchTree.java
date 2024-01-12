package org.dimigo.tree;

public class BinarySearchTree {

    public TreeNode root;
    public int size;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode makeNode(TreeNode left, int data, TreeNode right) {
        TreeNode node = new TreeNode(data);
        node.left = left;
        node.right = right;
        size++;
        return node;
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public void searchBST(int key) {
        searchBST(root, key);
    }

    // 재귀적 탐색
    public void searchBST(TreeNode node, int key) {
        if (node == null) {
            System.out.println(key + " Not Found");
            return;
        }
        if (key < node.data) {
            searchBST(node.left, key);  // 왼쪽 서브 트리에서 탐색을 실시
        } else if (key > node.data) {
            searchBST(node.right, key); //오른쪽 서브 트리에서 탐색을 실시
        } else {            // 데이터 찾았으면 종료
            System.out.println(key + " Found");
        }
    }

    // 반복적 탐색
    public TreeNode searchBST2(int key) {
        TreeNode node = root;
        while (node != null) {
            if (key < node.data) {
                node = node.left;
            } else if (key > node.data) {
                node = node.right;
            } else {
                System.out.println(key + " Found");
                return node;
            }
        }
        System.out.println(key + " Not Found");
        return null;
    }

    // 재귀적 추가
    public void insertBST(int data) {
        root = insertBST3(root, data);
    }

    public void insertBST3(int data) {
        if(root != null)
            insertBST3(root, data);
        else
            root = new TreeNode(data);
    }

    /**
     * 기존의 트리를 root 부터 삽입하려는 노드와 비교하면서 트리의 끝까지 내려간다.
     * 삽입하려는 노드가 더 작으면 왼쪽 자식쪽으로 내려가고 더 크면 오른쪽 자식쪽으로 내려가서 null이 되는 부분에 새로운 노드를 삽입한다.
     */
    public TreeNode insertBST(TreeNode node, int data) {
        if (node == null) {
            size++;
            return new TreeNode(data);
        }
        if (data < node.data) {
            node.left = insertBST(node.left, data);
        } else if (data > node.data) {
            node.right = insertBST(node.right, data);
        } else {
            System.out.println(data + " Exists");
        }
        return node;
    }

    // 반복적 추가
    public void insertBST2(int item) {
        if (root == null) {
            root = new TreeNode(item);
        } else {
            TreeNode node = root;
            while (true) {
                if (item < node.data) {
                    if (node.left == null) {
                        node.left = new TreeNode(item);
                        return;
                    } else {
                        node = node.left;
                    }
                } else if (item > node.data) {
                    if (node.right == null) {
                        node.right = new TreeNode(item);
                        return;
                    } else {
                        node = node.right;
                    }
                } else {
                    System.out.println(item + " Exists");
                    return;
                }
            }
        }
    }

    public TreeNode insertBST3(TreeNode node, int data) {
        if(data < node.data) {
            if(node.left != null)
                insertBST(node.left, data);
            else {
                return node.left = new TreeNode(data);
            }
        }
        else if(node.data < data) {
            if(node.right != null)
                insertBST(node.right, data);
            else
                return node.right = new TreeNode(data);
        }
        return null;
    }

    // 재귀적 삭제
    public void deleteBST(int data) {
        root = deleteBST(root, data);
    }

    public TreeNode deleteBST(TreeNode node, int data) {
        if (node == null) return null;
        if (data < node.data)
            node.left = deleteBST(node.left, data);
        else if (data > node.data)
            node.right = deleteBST(node.right, data);
        else {
            if (node.left == null && node.right == null) return null;
            else if (node.left == null) return node.right;
            else if (node.right == null) return node.left;
            else {
                node.data = getMinNode(node.right);
                node.right = deleteBST(node.right, node.data);
            }
        }
        return node;
    }

    private int getMinNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    // 반복적 삭제
    public boolean deleteBST2(int key) {
        TreeNode parent = root;
        TreeNode curr = root;
        boolean isLeftChild = false;

        while (key != curr.data) {
            parent = curr;
            if (key < curr.data){
                isLeftChild = true;
                curr = curr.left;
            } else {
                isLeftChild = false;
                curr = curr.right;
            }
            if (curr == null){
                return false;       // not found
            }
        }
        // 여기까지 while이 돌고나면 x의 위치를 찾은것임.

        //1. 자식노드가 없는 경우(단말노드)
        if (curr.left == null && curr.right == null) {
            //x와 같은 값을 가지는 노드가 루트이고 자식이없다면 루트 삭제
            if (curr == root){
                root = null;
            }
            //단말노드와의 연결을 끊음
            if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        //2. 하나의 자식을 갖는 경우
        // 왼쪽자식을 가지는경우
        else if (curr.right == null){
            if (curr == root){
                root = curr.left;
            } else if (isLeftChild){
                parent.left = curr.left;
            } else {
                parent.right = curr.left;
            }
        }
        //오른쪽 자식을 가지는 경우
        else if (curr.left == null){
            if (curr == root){
                root = curr.right;
            } else if (isLeftChild){
                parent.left = curr.right;
            } else {
                parent.right = curr.right;
            }
        }
        //3. 두개의 자식을 갖는 경우
        else if(curr.left != null && curr.right != null) {
            // 오른쪽 서브트리의 최소값을 찾음
            TreeNode succ = getSuccessor(curr);
            if (curr == root) {
                root = succ;
            } else if (isLeftChild) {
                parent.left = succ;
            } else {
                parent.right = succ;
            }
            succ.left = curr.left;
        }
        return true;
    }

    //후임자를 구하는 함수 //오른쪽 서브트리의 최소값(오른쪽 서브트리의 왼쪽값)
    public TreeNode getSuccessor(TreeNode node){
        TreeNode succ = null;
        TreeNode succParent = null;
        TreeNode curr = node.right;

        while(curr != null){
            succParent = succ;
            succ = curr;
            //왼쪽 서브트리를 타고 내려감
            curr = curr.left;
        }
        if(succ != node.right){
            succParent.left = succ.right;
            succ.right = node.right;
        }
        return succ;
    }
}
