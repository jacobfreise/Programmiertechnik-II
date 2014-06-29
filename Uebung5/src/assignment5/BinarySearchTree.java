package assignment5;

import assignment5.adt.Set;

public class BinarySearchTree<T extends Comparable<T>> implements Set<T> {
	public T top;
	public BinarySearchTree<T> left;
	public BinarySearchTree<T> right;
	/*
	 * (non-Javadoc)
	 * @see assignment5.adt.Set#add(java.lang.Comparable)
	 */
	@Override
	public void add(T element) {
		// TODO
		if(top==null){
			top=element;
		}
		if(element.compareTo(top)<=0){
			if(element.equals(top)){
				return;
			}
			else{
				if(left==null){
					left= new BinarySearchTree<T>();
					left.top=element;
					return;
				}
				else{
					left.add(element);
				}
			}
		}
		else{
			if(right==null){
				right = new BinarySearchTree<T>();
				right.top=element;
				return;
			}
			else{
				right.add(element);
			}
		}
	
	}
	/*
	 * (non-Javadoc)
	 * @see assignment5.adt.Set#remove(java.lang.Comparable)
	 */
	@Override
	public void remove(T element) {
		// TODO
		if(top==null){
			return;
		}
		if(element.compareTo(top)<=0){
			if(element.equals(top)){
				if(left==null&&right==null){
					top=null;
				}
				else{
					if(left!=null){
						BinarySearchTree<T> count=this.left;
						while(count.right!=null){
							count=count.left;
						}
						this.remove(count.top);
						this.top=(T) count.top;
					}
					else{
						BinarySearchTree<T> count=this.right;
						while(count.left!=null){
							count=count.left;
						}
						this.remove(count.top);
						this.top= (T)count.top;
						return;
					}
				}
			}
			else{
				if(left==null){
					return;
				}
				else{
					left.remove(element);
				}
			}
				
			
		}
		else{
			if(right==null){
				return;
			}
			else{
				right.remove(element);
			}
		}
		
	}
	/*
	 * (non-Javadoc)
	 * @see assignment5.adt.Set#contains(java.lang.Comparable)
	 */
	@Override
	public boolean contains(T element) {
		// TODO
		if(top==null){
			return false;
		}
		if(element.compareTo(top)<=0){
			if(element.equals(top)){
				return true;
			}
			else{
				if(left==null){
					return false;
				}
				else{
					return left.contains(element);
			
				}
			}
		}
		else{
			if(right==null){
				return false;
			}
			else{
				return right.contains(element);
			}
		}
	}
	/*
	 * (non-Javadoc)
	 * @see assignment5.adt.Set#size()
	 */
	@Override
	public int size() {
		// TODO
		if(this.left==null&&this.right==null&&this.top!=null){
			return 1;
		}
		else{
			if(this.left==null&&this.right==null&&this.top==null){
				return 0;
			}
			else{
				if(this.left!=null&&this.right!=null){
					return 1 + left.size() + right.size();
				}
				else{
					if(this.left==null){
						return 1 + right.size();
					}
					else{
						return 1 + left.size();
					}
				}
			}	
		}

	}
}