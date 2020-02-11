package challenges;

import utils.NaryNode;
import utils.TreeNode;

public class SmallestSumTreePath {

    public int getCheapestCost(NaryNode rootNode) {
        int cheapestRouteSum = Integer.MAX_VALUE;
        getCheapestPathCostRecrsv(rootNode);
        return cheapestRouteSum;
    }
    public int getCheapestPathCostRecrsv(NaryNode node) {
        int cheapestSum = Integer.MAX_VALUE;
        if(node.children == null || node.children.size() == 0) {
            return node.val;
        } else {
            for(NaryNode n : node.children) {
                int val = getCheapestPathCostRecrsv(n);
                cheapestSum = Math.min(cheapestSum, val);
            }
        }
        return cheapestSum;
    }

}
