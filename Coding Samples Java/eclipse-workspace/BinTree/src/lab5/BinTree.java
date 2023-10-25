package lab5;

import CITS2200.BinaryTree;
import CITS2200.Iterator;

public class BinTree<E> extends BinaryTree<E> {
	public BinTree(){ 
		super();
	}

	public BinTree(E item, BinaryTree<E> b1, BinaryTree<E> b2){
		super(item,b1,b2);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BinaryTree) {
			BinaryTree<E> tree = (BinaryTree<E>) obj;
			if(getItem() == tree.getItem()) {
				return (equals(getLeft(), tree.getLeft()) && equals(getRight(), tree.getRight()));
			}
		}
		return false;
	}

	private boolean equals(BinaryTree<E> tree1, BinaryTree<E> tree2) {
		if(tree1.isEmpty() && tree2.isEmpty()) {
			return true;
		}
		else if(tree1.getItem() == tree2.getItem()) {
			return (equals(tree1.getLeft(), tree2.getLeft()) && equals(tree1.getRight(), tree2.getRight()));
		}
		else {
			return false;
		}
	}

	@Override
	public Iterator<E> iterator() {
	}
}
