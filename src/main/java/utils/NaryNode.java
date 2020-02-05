package utils;

import lombok.Data;

import java.util.List;

@Data
public class NaryNode {
    public int val;
    public List<NaryNode> children;

    public NaryNode() {
    }

    public NaryNode(int _val, List<NaryNode> _children) {
        val = _val;
        children = _children;
    }
}
