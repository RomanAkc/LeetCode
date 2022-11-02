public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isSymmetric(GetTreeNodeByArrary(new Integer[]{1,2,2,3,4,4,3})));
        System.out.println(s.isSymmetric(GetTreeNodeByArrary(new Integer[]{1,2,2,null,3,null,3})));
        System.out.println(s.isSymmetric(GetTreeNodeByArrary(new Integer[]{1,2,2,null,3,3,null})));
        //System.out.println(s.isSymmetric(GetTreeNodeByArrary(new Integer[]{1,2,2,null,3,3,null})));

        //[3,4,4,5,null,null,5,6,null,null,6]
    }

    private static TreeNode GetTreeNodeByArrary(Integer[] arr) {
        TreeNode[] tmp = new TreeNode[arr.length];

        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] != null)
                tmp[i] = new TreeNode(arr[i]);
            else
                tmp[i] = null;
        }

        int i = 0;
        while (true) {
            int start = 2 * i + 1;
            int end = start * 2;

            if(start >= tmp.length)
                break;

            for(int j = start; j <= end; ++j) {
                int parent = (j - 1) / 2;

                if(j % 2 == 1)
                    tmp[parent].left = tmp[j];
                else
                    tmp[parent].right = tmp[j];
            }

            i = start;
        }

        return tmp[0];
    }
}