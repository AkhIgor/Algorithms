fun main() {

}

private fun isSymmetric(root: TreeNode?): Boolean =
    root == null || symmetricHelper(root.left, root.right)

private fun symmetricHelper(left: TreeNode?, right: TreeNode?): Boolean {
    if (left == null && right == null) return true
    if (left == null || right == null) return false
    return left.`val` == right.`val` &&
            symmetricHelper(left.left, right.right) &&
            symmetricHelper(left.right, right.left)
}

// MINE (не учитывал структуру дерева
//private fun isSymmetric(root: TreeNode?): Boolean {
//    val leftList = mutableListOf<Int>()
//    val rightList = mutableListOf<Int>()
//
//    buildLeftList(root?.left, leftList)
//    buildRightList(root?.right, rightList)
//
//    if (leftList.size != rightList.size) return false
//
//    for (i in 0..<leftList.size) {
//        if (leftList[i] != rightList[i]) return false
//    }
//    return true
//}
//
//private fun buildLeftList(tree: TreeNode?, list: MutableList<Int>) {
//    if (tree == null) return
//
//    list.add(tree.`val`)
//
//    buildLeftList(tree.left, list)
//    buildLeftList(tree.right, list)
//}
//
//private fun buildRightList(tree: TreeNode?, list: MutableList<Int>) {
//    if (tree == null) return
//
//    list.add(tree.`val`)
//
//    buildRightList(tree.right, list)
//    buildRightList(tree.left, list)
//}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}